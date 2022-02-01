package com.tencent.mobileqq.logcathook;

import android.content.SharedPreferences;
import awcm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

final class LogcatHook$1
  implements Runnable
{
  public void run()
  {
    try
    {
      if ((BaseApplicationImpl.getApplication().getSharedPreferences("suspend_thread_pref_file", 0).getBoolean("enable_sys_log", false)) && (!LogcatHook.a))
      {
        System.loadLibrary("logcathook");
        awcm.a("com.tencent.mobileqq", BaseApplicationImpl.processName, AppSetting.a, 0L);
        LogcatHook.updateLogFilePath(awcm.a());
        LogcatHook.a(false);
        LogcatHook.a = true;
        QLog.sLogcatHooked = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      LogcatHook.a = false;
      QLog.e("LogcatHook", 1, "logcat hook faild", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.logcathook.LogcatHook.1
 * JD-Core Version:    0.7.0.1
 */