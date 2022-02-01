package com.tencent.qqlive.module.videoreport.task.base;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledHandlerExecutorService
  implements ScheduledExecutorService
{
  private Handler mHandler;
  private volatile boolean mIsStopped;
  private BlockingQueue<HandlerScheduledFuture> mWorkQueue;
  
  public ScheduledHandlerExecutorService(Looper paramLooper)
  {
    this.mHandler = new Handler(paramLooper);
    this.mWorkQueue = new LinkedBlockingDeque();
    this.mIsStopped = false;
  }
  
  public boolean awaitTermination(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    return false;
  }
  
  public void execute(Runnable paramRunnable)
  {
    schedule(paramRunnable, 0L, TimeUnit.MILLISECONDS);
  }
  
  @NonNull
  public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> paramCollection)
  {
    return null;
  }
  
  @NonNull
  public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> paramCollection, long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @NonNull
  public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> paramCollection)
  {
    return null;
  }
  
  public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> paramCollection, long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public boolean isShutdown()
  {
    return this.mIsStopped;
  }
  
  public boolean isTerminated()
  {
    return this.mIsStopped;
  }
  
  public ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.mIsStopped) {
      return null;
    }
    paramRunnable = new HandlerScheduledFuture(paramRunnable, this.mHandler, paramTimeUnit.convert(paramLong, TimeUnit.MILLISECONDS), 0L);
    this.mWorkQueue.add(paramRunnable);
    this.mHandler.postAtTime(paramRunnable, paramRunnable.setNextRunTime());
    return paramRunnable;
  }
  
  public <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.mIsStopped) {
      return null;
    }
    paramCallable = new HandlerScheduledFuture(paramCallable, this.mHandler, paramTimeUnit.convert(paramLong, TimeUnit.MILLISECONDS), 0L);
    this.mWorkQueue.add(paramCallable);
    this.mHandler.postAtTime(paramCallable, paramCallable.setNextRunTime());
    return paramCallable;
  }
  
  public ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    if (this.mIsStopped) {
      return null;
    }
    if (paramLong2 > 0L)
    {
      paramRunnable = new HandlerScheduledFuture(paramRunnable, this.mHandler, paramTimeUnit.convert(paramLong1, TimeUnit.MILLISECONDS), paramTimeUnit.convert(paramLong2, TimeUnit.MILLISECONDS));
      this.mWorkQueue.add(paramRunnable);
      this.mHandler.postAtTime(paramRunnable, paramRunnable.setNextRunTime());
      return paramRunnable;
    }
    return schedule(paramRunnable, paramLong1, paramTimeUnit);
  }
  
  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    if (this.mIsStopped) {
      return null;
    }
    if (paramLong2 > 0L)
    {
      paramRunnable = new HandlerScheduledFuture(paramRunnable, this.mHandler, paramTimeUnit.convert(paramLong1, TimeUnit.MILLISECONDS), paramTimeUnit.convert(paramLong2, TimeUnit.MILLISECONDS));
      this.mWorkQueue.add(paramRunnable);
      this.mHandler.postAtTime(paramRunnable, paramRunnable.setNextRunTime());
      return paramRunnable;
    }
    return schedule(paramRunnable, paramLong1, paramTimeUnit);
  }
  
  public void shutdown()
  {
    Iterator localIterator = this.mWorkQueue.iterator();
    while (localIterator.hasNext())
    {
      HandlerScheduledFuture localHandlerScheduledFuture = (HandlerScheduledFuture)localIterator.next();
      if (localHandlerScheduledFuture != null) {
        localHandlerScheduledFuture.cancel(false);
      }
    }
    this.mWorkQueue.clear();
    this.mIsStopped = true;
  }
  
  @NonNull
  public List<Runnable> shutdownNow()
  {
    shutdown();
    return null;
  }
  
  @NonNull
  public Future<?> submit(@NonNull Runnable paramRunnable)
  {
    return schedule(paramRunnable, 0L, TimeUnit.MILLISECONDS);
  }
  
  @NonNull
  public <T> Future<T> submit(@NonNull Runnable paramRunnable, T paramT)
  {
    return null;
  }
  
  @NonNull
  public <T> Future<T> submit(@NonNull Callable<T> paramCallable)
  {
    return schedule(paramCallable, 0L, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.task.base.ScheduledHandlerExecutorService
 * JD-Core Version:    0.7.0.1
 */