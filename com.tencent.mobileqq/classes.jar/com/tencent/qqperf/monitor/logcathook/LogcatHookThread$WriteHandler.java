package com.tencent.qqperf.monitor.logcathook;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.app.MobileQQ;

class LogcatHookThread$WriteHandler
  extends Handler
{
  public LogcatHookThread$WriteHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      try
      {
        if (MobileQQ.sProcessId != 1) {
          return;
        }
        LogcatHookThread.b(System.currentTimeMillis());
        LogcatHookThread.b.removeMessages(2);
        LogcatHookThread.b.sendEmptyMessageDelayed(2, 300000L);
        return;
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
    }
    else
    {
      try
      {
        LogcatHookThread.a(System.currentTimeMillis());
        LogcatHookThread.b.removeMessages(1);
        LogcatHookThread.b.sendEmptyMessageDelayed(1, 300000L);
        return;
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.logcathook.LogcatHookThread.WriteHandler
 * JD-Core Version:    0.7.0.1
 */