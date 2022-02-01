package com.tencent.mobileqq.logcathook;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class LogcatHook$1
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!LogcatHook.sLogcatHooked.get())
      {
        System.loadLibrary("logcathook");
        LogcatHookThread.a("com.tencent.mobileqq", BaseApplicationImpl.processName, AppSetting.a, 0L);
        LogcatHook.updateLogFilePath(LogcatHookThread.a());
        LogcatHook.access$000(false);
        LogcatHook.sLogcatHooked.compareAndSet(false, true);
        QLog.sLogcatHooked = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      LogcatHook.sLogcatHooked.compareAndSet(true, false);
      QLog.e("LogcatHook", 1, "logcat hook faild", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.logcathook.LogcatHook.1
 * JD-Core Version:    0.7.0.1
 */