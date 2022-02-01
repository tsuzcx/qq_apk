package com.tencent.qqlive.module.videoreport.task.base;

import android.os.Handler;
import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;

public class HandlerScheduledFuture<T>
  extends FutureTask<T>
  implements RunnableScheduledFuture<T>
{
  private int count;
  private long mDelay;
  private Handler mHandler;
  private long mInit;
  private final long mPeriodic;
  
  HandlerScheduledFuture(Runnable paramRunnable, Handler paramHandler, long paramLong1, long paramLong2)
  {
    super(paramRunnable, null);
    this.mHandler = paramHandler;
    this.mDelay = paramLong1;
    this.mPeriodic = paramLong2;
    this.mInit = SystemClock.uptimeMillis();
  }
  
  HandlerScheduledFuture(Callable<T> paramCallable, Handler paramHandler, long paramLong1, long paramLong2)
  {
    super(paramCallable);
    this.mHandler = paramHandler;
    this.mDelay = paramLong1;
    this.mPeriodic = paramLong2;
    this.mInit = SystemClock.uptimeMillis();
  }
  
  private void reExecutePeriodic(Runnable paramRunnable, long paramLong)
  {
    this.mHandler.postAtTime(this, paramLong);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    paramBoolean = super.cancel(paramBoolean);
    if (paramBoolean) {
      this.mHandler.removeCallbacks(this);
    }
    return paramBoolean;
  }
  
  public int compareTo(Delayed paramDelayed)
  {
    if (paramDelayed == this) {}
    long l;
    do
    {
      return 0;
      l = this.mDelay - paramDelayed.getDelay(TimeUnit.MILLISECONDS);
      if (l < 0L) {
        return -1;
      }
    } while (l <= 0L);
    return 1;
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    return this.mDelay;
  }
  
  public boolean isPeriodic()
  {
    return this.mPeriodic > 0L;
  }
  
  public void run()
  {
    boolean bool = isPeriodic();
    if (isCancelled()) {
      cancel(false);
    }
    do
    {
      return;
      if (!bool)
      {
        super.run();
        return;
      }
    } while (!super.runAndReset());
    this.count += 1;
    reExecutePeriodic(this, setNextRunTime());
  }
  
  long setNextRunTime()
  {
    return this.mInit + this.mDelay + this.count * this.mPeriodic;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.task.base.HandlerScheduledFuture
 * JD-Core Version:    0.7.0.1
 */