package com.tencent.upload.utils.pool;

import android.os.Build.VERSION;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityThreadPoolExecutor
  extends ThreadPoolExecutor
{
  public static final int ABOVE_NORMAL = 1;
  public static final int BELOW_NORMAL = -1;
  public static final int HIGH = 2;
  public static final int IDEL = -2;
  public static final int NORMAL = 0;
  private static final String TAG = "PriorityThreadPoolExecutor";
  
  public PriorityThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, new PriorityBlockingQueue(), paramThreadFactory);
  }
  
  public PriorityThreadPoolExecutor(int paramInt1, int paramInt2, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, 15L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), paramThreadFactory);
  }
  
  public void execute(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof PriorityThreadPoolExecutor.ComparableFutureTask))
    {
      super.execute(paramRunnable);
      return;
    }
    submit(paramRunnable);
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new PriorityThreadPoolExecutor.ComparableFutureTask(paramRunnable, paramT);
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return new PriorityThreadPoolExecutor.ComparableFutureTask(paramCallable);
  }
  
  public boolean remove(Runnable paramRunnable)
  {
    return super.remove(new PriorityThreadPoolExecutor.PriorityRunnable(paramRunnable));
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new PriorityThreadPoolExecutor.PriorityRunnable(paramRunnable));
    }
    paramRunnable = newTaskFor(new PriorityThreadPoolExecutor.PriorityRunnable(paramRunnable), null);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public Future<?> submit(Runnable paramRunnable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new PriorityThreadPoolExecutor.PriorityRunnable(paramRunnable, paramInt));
    }
    paramRunnable = newTaskFor(new PriorityThreadPoolExecutor.PriorityRunnable(paramRunnable, paramInt), null);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new PriorityThreadPoolExecutor.PriorityRunnable(paramRunnable), paramT);
    }
    paramRunnable = newTaskFor(new PriorityThreadPoolExecutor.PriorityRunnable(paramRunnable), paramT);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public <T> Future<?> submit(Runnable paramRunnable, T paramT, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new PriorityThreadPoolExecutor.PriorityRunnable(paramRunnable, paramInt), paramT);
    }
    paramRunnable = newTaskFor(new PriorityThreadPoolExecutor.PriorityRunnable(paramRunnable, paramInt), paramT);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new PriorityThreadPoolExecutor.PriorityCallable(paramCallable));
    }
    paramCallable = newTaskFor(new PriorityThreadPoolExecutor.PriorityCallable(paramCallable));
    execute(paramCallable);
    return paramCallable;
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return submit(new PriorityThreadPoolExecutor.PriorityCallable(paramCallable, paramInt));
    }
    paramCallable = newTaskFor(new PriorityThreadPoolExecutor.PriorityCallable(paramCallable, paramInt));
    execute(paramCallable);
    return paramCallable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.utils.pool.PriorityThreadPoolExecutor
 * JD-Core Version:    0.7.0.1
 */