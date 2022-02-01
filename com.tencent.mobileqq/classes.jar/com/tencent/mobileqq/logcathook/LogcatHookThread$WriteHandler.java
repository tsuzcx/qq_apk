package com.tencent.mobileqq.logcathook;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;

class LogcatHookThread$WriteHandler
  extends Handler
{
  public LogcatHookThread$WriteHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      try
      {
        LogcatHookThread.a(System.currentTimeMillis());
        LogcatHookThread.a.removeMessages(1);
        LogcatHookThread.a.sendEmptyMessageDelayed(1, 300000L);
        return;
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
      try
      {
        if (BaseApplicationImpl.sProcessId == 1)
        {
          LogcatHookThread.b(System.currentTimeMillis());
          LogcatHookThread.a.removeMessages(2);
          LogcatHookThread.a.sendEmptyMessageDelayed(2, 300000L);
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.logcathook.LogcatHookThread.WriteHandler
 * JD-Core Version:    0.7.0.1
 */