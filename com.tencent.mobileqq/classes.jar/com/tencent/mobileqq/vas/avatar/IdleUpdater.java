package com.tencent.mobileqq.vas.avatar;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mqq.os.MqqHandler;

public abstract class IdleUpdater
  implements MessageQueue.IdleHandler, Runnable
{
  private int a;
  
  public IdleUpdater(int paramInt)
  {
    this.a = paramInt;
  }
  
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
    ThreadManagerV2.excute(this, this.a, null, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.IdleUpdater
 * JD-Core Version:    0.7.0.1
 */