package com.tribe.async.async;

import android.os.SystemClock;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class MonitorThreadPoolExecutor$WorkerHolder
  extends WeakReference<Runnable>
{
  private long mExecuteStartTime = SystemClock.elapsedRealtime();
  
  public MonitorThreadPoolExecutor$WorkerHolder(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public MonitorThreadPoolExecutor$WorkerHolder(Runnable paramRunnable, ReferenceQueue<? super Runnable> paramReferenceQueue)
  {
    super(paramRunnable, paramReferenceQueue);
  }
  
  public static boolean objEquals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof WorkerHolder)) {
      return objEquals(((WorkerHolder)paramObject).get(), get());
    }
    if ((paramObject instanceof Runnable)) {
      return objEquals(paramObject, get());
    }
    return false;
  }
  
  public long getExecuteTime()
  {
    return SystemClock.elapsedRealtime() - this.mExecuteStartTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.MonitorThreadPoolExecutor.WorkerHolder
 * JD-Core Version:    0.7.0.1
 */