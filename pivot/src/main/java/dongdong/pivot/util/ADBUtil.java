package dongdong.pivot.util;

import java.io.IOException;

public class ADBUtil {
    private final static String ADB = System.getProperty("os.name").contains("Windows") ? "adb" : "~/bipartite/adb";

    public static Process executeCmd(String cmd) throws IOException {
        cmd = ADB + cmd;
        System.out.println("execute cmd:  " + cmd);
        return Runtime.getRuntime().exec(cmd);
    }

    public static Process adbForward(String phone, int port) throws IOException {
        String cmd = " -s " + phone + " forward tcp:" + port + " localabstract:scrcpy";
        return executeCmd(cmd);
    }

    public static Process adbRemoveForward(String phone, int port) throws IOException {
        String cmd = " -s " + phone + " forward --remove tcp:" + port;
        return executeCmd(cmd);
    }

    public static Process adbPush(String phone, String fPath, String pPath) throws IOException {
        String cmd = " -s " + phone + " push " + fPath + " " + pPath;
        return executeCmd(cmd);
    }

    public static Process adbShell(String phone, String shell) throws IOException {
        String cmd = " -s " + phone + " shell " + shell;
        return executeCmd(cmd);
    }

}