package com.tencent.oskplayer.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtils$FlexibleSizeExecutor
  extends ThreadPoolExecutor
{
  String jobDescription = "";
  
  public ThreadUtils$FlexibleSizeExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue);
  }
  
  public ThreadUtils$FlexibleSizeExecutor(String paramString)
  {
    super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    this.jobDescription = paramString;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    Throwable localThrowable1 = paramThrowable;
    if (paramThrowable == null)
    {
      localThrowable1 = paramThrowable;
      if (!(paramRunnable instanceof Future)) {}
    }
    try
    {
      paramRunnable = (Future)paramRunnable;
      localThrowable1 = paramThrowable;
      if (paramRunnable.isDone())
      {
        localThrowable1 = paramThrowable;
        if (!paramRunnable.isCancelled())
        {
          PlayerUtils.log(3, "ThreadUtils", "before future.get()");
          paramRunnable.get();
          PlayerUtils.log(3, "ThreadUtils", "after future.get()");
          localThrowable1 = paramThrowable;
        }
      }
    }
    catch (CancellationException localCancellationException)
    {
      for (;;)
      {
        PlayerUtils.log(5, "ThreadUtils", "CancellationException");
      }
    }
    catch (ExecutionException paramRunnable)
    {
      for (;;)
      {
        PlayerUtils.log(5, "ThreadUtils", "ExecutionException");
        localThrowable2 = paramRunnable.getCause();
      }
    }
    catch (InterruptedException paramRunnable)
    {
      for (;;)
      {
        PlayerUtils.log(5, "ThreadUtils", "InterruptedException");
        Thread.currentThread().interrupt();
        Throwable localThrowable2 = paramThrowable;
      }
    }
    if (localThrowable1 != null) {
      PlayerUtils.log(6, "ThreadUtils", this.jobDescription + " error occurred during processing request : " + PlayerUtils.getPrintableStackTrace(localThrowable1));
    }
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    PlayerUtils.log(4, "ThreadUtils", "beforeExecute: thread=" + paramThread.toString() + " thread.state=" + paramThread.getState() + " runnable=" + paramRunnable.toString());
  }
  
  public int getPendingTaskCount()
  {
    return getActiveCount() + getQueue().size();
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return super.newTaskFor(paramRunnable, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.util.ThreadUtils.FlexibleSizeExecutor
 * JD-Core Version:    0.7.0.1
 */