package com.tencent.oskplayer.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadUtils$PriorityExecutor
  extends ThreadPoolExecutor
{
  public ThreadUtils$PriorityExecutor(int paramInt)
  {
    this(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
  }
  
  public ThreadUtils$PriorityExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue);
  }
  
  public void execute(Runnable paramRunnable, long paramLong)
  {
    super.execute(new ThreadUtils.ComparableFutureTask(paramRunnable, null, paramLong));
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return (RunnableFuture)paramRunnable;
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return (RunnableFuture)paramCallable;
  }
  
  public Future<?> submit(Runnable paramRunnable, long paramLong)
  {
    return super.submit(new ThreadUtils.ComparableFutureTask(paramRunnable, null, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.ThreadUtils.PriorityExecutor
 * JD-Core Version:    0.7.0.1
 */