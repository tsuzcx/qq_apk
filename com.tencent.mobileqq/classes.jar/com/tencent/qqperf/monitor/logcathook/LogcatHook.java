package com.tencent.qqperf.monitor.logcathook;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LogcatHook
{
  public static String[] ALL_SO_LIST;
  public static final int ENABEL_HOOK_IN_ALL_SO = 8;
  public static final int ENABEL_IN_APPLICATION_INT_VALUE = 1;
  public static final int ENABEL_IN_PEAK_PROCESS_INT_VALUE = 4;
  public static final int ENABEL_IN_RDM_INT_VALUE = 2;
  public static boolean ENABEL_SYSLOG_IN_ALL_SO = false;
  public static boolean ENABEL_SYSLOG_IN_APPLICATION = false;
  public static boolean ENABEL_SYSLOG_IN_PEAK_PROCESS = false;
  public static boolean ENABEL_SYSLOG_IN_RDM = false;
  public static List<String> IGNORE_SO_LIST;
  public static final String LOGCAT_HOOK_SO_NAME = "logcathook";
  public static final String LOGCAT_HOOK_SP_ENABLE_KEY = "enable_syslog_key";
  public static final String LOGCAT_HOOK_SP_FILE = "suspend_thread_pref_file";
  public static final String LOGCAT_HOOK_SP_IGNORE_LIST_KEY = "ignore_list_key";
  public static String[] REGISTER_SO_LIST;
  public static final String TAG = "LogcatHook";
  public static AtomicBoolean sLogcatHooked = new AtomicBoolean(false);
  
  static
  {
    ENABEL_SYSLOG_IN_APPLICATION = false;
    ENABEL_SYSLOG_IN_RDM = false;
    ENABEL_SYSLOG_IN_PEAK_PROCESS = false;
    ENABEL_SYSLOG_IN_ALL_SO = false;
    IGNORE_SO_LIST = new LogcatHook.1();
    REGISTER_SO_LIST = new String[] { ".*\\libart.so$", ".*\\libhwui.so$", ".*\\libandroid_runtime.so$", ".*\\liblog.so$" };
    ALL_SO_LIST = new String[] { ".*\\.so$" };
    try
    {
      Object localObject1 = MobileQQ.getContext().getSharedPreferences("suspend_thread_pref_file", 0);
      int i = ((SharedPreferences)localObject1).getInt("enable_syslog_key", 0);
      if ((i & 0x1) == 1) {
        ENABEL_SYSLOG_IN_APPLICATION = true;
      } else if ((i & 0x2) == 2) {
        ENABEL_SYSLOG_IN_RDM = true;
      }
      if ((i & 0x4) == 4) {
        ENABEL_SYSLOG_IN_PEAK_PROCESS = true;
      }
      if ((i & 0x8) == 8) {
        ENABEL_SYSLOG_IN_ALL_SO = true;
      }
      localObject1 = ((SharedPreferences)localObject1).getString("ignore_list_key", "");
      if (((String)localObject1).equalsIgnoreCase("")) {
        break label219;
      }
      localObject1 = ((String)localObject1).split("\\|");
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        IGNORE_SO_LIST.add(localObject2);
        i += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      label203:
      break label203;
    }
    ENABEL_SYSLOG_IN_APPLICATION = false;
    ENABEL_SYSLOG_IN_RDM = false;
    ENABEL_SYSLOG_IN_PEAK_PROCESS = false;
    label219:
  }
  
  private static native void disableHook();
  
  private static native void enableHook();
  
  private static native void init(boolean paramBoolean);
  
  private static native void registerHookSo(String paramString);
  
  public static void saveToQLog(String paramString)
  {
    QLog.d("LogcatHook", 1, paramString);
  }
  
  private static native void setIgnoreHookSo(String paramString);
  
  public static void startHookLogcat()
  {
    if ((MobileQQ.sProcessId == 9) && (!ENABEL_SYSLOG_IN_PEAK_PROCESS)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LogcatHook.2());
  }
  
  public static native void updateLogPath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.logcathook.LogcatHook
 * JD-Core Version:    0.7.0.1
 */