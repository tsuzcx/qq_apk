package com.tribe.async.async;

import android.os.SystemClock;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class LightWeightExecutor$RunnableHolder
  extends WeakReference<Runnable>
{
  private long mRunStartTime = SystemClock.elapsedRealtime();
  
  public LightWeightExecutor$RunnableHolder(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public LightWeightExecutor$RunnableHolder(Runnable paramRunnable, ReferenceQueue<? super Runnable> paramReferenceQueue)
  {
    super(paramRunnable, paramReferenceQueue);
  }
  
  public long getItemRunTimes()
  {
    return SystemClock.elapsedRealtime() - this.mRunStartTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.LightWeightExecutor.RunnableHolder
 * JD-Core Version:    0.7.0.1
 */