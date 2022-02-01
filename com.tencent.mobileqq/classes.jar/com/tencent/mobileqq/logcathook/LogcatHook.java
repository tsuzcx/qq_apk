package com.tencent.mobileqq.logcathook;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LogcatHook
{
  public static final int ENABEL_IN_APPLICATION_INT_VALUE = 1;
  public static final int ENABEL_IN_PEAK_PROCESS_INT_VALUE = 4;
  public static final int ENABEL_IN_RDM_INT_VALUE = 2;
  public static boolean ENABEL_SYSLOG_IN_APPLICATION = false;
  public static boolean ENABEL_SYSLOG_IN_PEAK_PROCESS = false;
  public static boolean ENABEL_SYSLOG_IN_RDM = false;
  public static final String LOGCAT_HOOK_SO_NAME = "logcathook";
  public static final String LOGCAT_HOOK_SP_ENABLE_KEY = "enable_syslog_key";
  public static final String LOGCAT_HOOK_SP_FILE = "suspend_thread_pref_file";
  public static final String TAG = "LogcatHook";
  public static AtomicBoolean sLogcatHooked = new AtomicBoolean(false);
  
  static
  {
    ENABEL_SYSLOG_IN_APPLICATION = false;
    ENABEL_SYSLOG_IN_RDM = false;
    try
    {
      int i = BaseApplicationImpl.getApplication().getSharedPreferences("suspend_thread_pref_file", 0).getInt("enable_syslog_key", 0);
      if ((i & 0x1) == 1) {
        ENABEL_SYSLOG_IN_APPLICATION = true;
      }
      while ((i & 0x4) == 4)
      {
        ENABEL_SYSLOG_IN_PEAK_PROCESS = true;
        return;
        if ((i & 0x2) == 2) {
          ENABEL_SYSLOG_IN_RDM = true;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ENABEL_SYSLOG_IN_APPLICATION = false;
      ENABEL_SYSLOG_IN_RDM = false;
      ENABEL_SYSLOG_IN_PEAK_PROCESS = false;
    }
  }
  
  private static native void hookLogcat(boolean paramBoolean);
  
  public static void printNativeLogToQLog(String paramString)
  {
    QLog.d("LogcatHook", 1, paramString);
  }
  
  public static void startHookLogcat()
  {
    if ((MobileQQ.sProcessId == 9) && (!ENABEL_SYSLOG_IN_PEAK_PROCESS)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LogcatHook.1());
  }
  
  private static native void unHookLogcat();
  
  public static native void updateLogFilePath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.logcathook.LogcatHook
 * JD-Core Version:    0.7.0.1
 */