package com.tencent.qqperf.monitor.logcathook;

import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

final class LogcatHook$2
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!LogcatHook.sLogcatHooked.get())
      {
        System.loadLibrary("logcathook");
        LogcatHookThread.a("com.tencent.mobileqq", MobileQQ.processName, AppSetting.a, 0L);
        LogcatHook.access$000(false);
        LogcatHook.updateLogPath(LogcatHookThread.a());
        if (LogcatHook.ENABEL_SYSLOG_IN_ALL_SO)
        {
          localObject = LogcatHook.ALL_SO_LIST;
          j = localObject.length;
          i = 0;
          while (i < j)
          {
            LogcatHook.access$100(localObject[i]);
            i += 1;
          }
        }
        Object localObject = LogcatHook.REGISTER_SO_LIST;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          LogcatHook.access$100(localObject[i]);
          i += 1;
        }
        localObject = LogcatHook.IGNORE_SO_LIST.iterator();
        while (((Iterator)localObject).hasNext()) {
          LogcatHook.access$200((String)((Iterator)localObject).next());
        }
        LogcatHook.access$300();
        LogcatHook.sLogcatHooked.compareAndSet(false, true);
        QLog.sLogcatHooked = true;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      LogcatHook.sLogcatHooked.compareAndSet(true, false);
      QLog.e("LogcatHook", 1, "logcat hook faild", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.logcathook.LogcatHook.2
 * JD-Core Version:    0.7.0.1
 */