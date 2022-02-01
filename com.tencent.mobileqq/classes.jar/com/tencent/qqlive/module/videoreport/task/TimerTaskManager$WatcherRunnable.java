package com.tencent.qqlive.module.videoreport.task;

import java.util.concurrent.ConcurrentHashMap;

class TimerTaskManager$WatcherRunnable
  implements Runnable
{
  private boolean mIsPeriod;
  private String mKey;
  private Runnable mRunnable;
  
  TimerTaskManager$WatcherRunnable(TimerTaskManager paramTimerTaskManager, Runnable paramRunnable, String paramString, boolean paramBoolean)
  {
    this.mRunnable = paramRunnable;
    this.mKey = paramString;
    this.mIsPeriod = paramBoolean;
  }
  
  public void run()
  {
    try
    {
      this.mRunnable.run();
      return;
    }
    finally
    {
      if (!this.mIsPeriod) {
        TimerTaskManager.access$200(this.this$0).remove(this.mKey);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.task.TimerTaskManager.WatcherRunnable
 * JD-Core Version:    0.7.0.1
 */