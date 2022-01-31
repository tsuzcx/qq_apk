package com.tencent.mobileqq.util;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public abstract class IdleUpdater
  implements MessageQueue.IdleHandler, Runnable
{
  public abstract void a();
  
  public void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Looper.myQueue().addIdleHandler(this);
      return;
    }
    ThreadManager.getUIHandler().post(this);
  }
  
  public boolean queueIdle()
  {
    ThreadManager.post(this, 5, null, true);
    return false;
  }
  
  public void run()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Looper.myQueue().addIdleHandler(this);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.IdleUpdater
 * JD-Core Version:    0.7.0.1
 */