package com.tribe.async.async;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class MainFreeJobScheduler
  implements JobScheduler
{
  private static final int MSG_DISPATCH_JOB_SCHEDULE = 2;
  private static final int MSG_MAIN_THREAD_SCHEDULE = 1;
  private MainFreeJobScheduler.ChoreographerScheduler mChoreographerScheduler;
  private final Handler mDispatchHandler;
  private final Handler mMainHandler = new MainFreeJobScheduler.MainThreadScheduleHandler(this);
  
  public MainFreeJobScheduler(Looper paramLooper)
  {
    this.mDispatchHandler = new MainFreeJobScheduler.DispatchScheduleHandler(this, paramLooper);
    if (Build.VERSION.SDK_INT >= 16) {
      this.mChoreographerScheduler = new MainFreeJobScheduler.ChoreographerScheduler(this);
    }
  }
  
  public abstract void doSchedule();
  
  public void schedule()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.mChoreographerScheduler.schedule();
      return;
    }
    Message.obtain(this.mMainHandler, 1).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.MainFreeJobScheduler
 * JD-Core Version:    0.7.0.1
 */