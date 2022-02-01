package com.tencent.weiyun.utils.thread;

import android.annotation.TargetApi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool
{
  public static final int DEFAULT_POOL_SIZE = 4;
  public static final int DEFAULT_THREAD_PRIORITY = 10;
  public static final ThreadPool.JobContext JOB_CONTEXT_STUB = new ThreadPool.JobContextStub(null);
  public static final int MODE_CPU = 1;
  public static final int MODE_NETWORK = 2;
  public static final int MODE_NONE = 0;
  private static final String TAG = "ThreadPool";
  ThreadPool.ResourceCounter mCpuCounter = new ThreadPool.ResourceCounter(2);
  private final ThreadPoolExecutor mExecutor;
  ThreadPool.ResourceCounter mNetworkCounter = new ThreadPool.ResourceCounter(2);
  private final ThreadPool.PriorityThreadFactory mThreadFactory;
  
  public ThreadPool()
  {
    this("thread-pool", 4);
  }
  
  public ThreadPool(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt, new LinkedBlockingQueue());
  }
  
  public ThreadPool(String paramString, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt2 < paramInt1) {
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        this.mThreadFactory = new ThreadPool.PriorityThreadFactory(paramString, 10);
        this.mExecutor = new ThreadPoolExecutor(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, this.mThreadFactory);
        return;
      }
    }
  }
  
  public ThreadPool(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    this(paramString, paramInt1, paramInt2, 10L, TimeUnit.SECONDS, paramBlockingQueue);
  }
  
  @TargetApi(9)
  public ThreadPool(String paramString, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this(paramString, paramInt, paramInt, paramLong, paramTimeUnit, new LinkedBlockingQueue());
    if (paramLong > 0L) {
      this.mExecutor.allowCoreThreadTimeOut(true);
    }
  }
  
  @TargetApi(9)
  ThreadPool(String paramString, int paramInt, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    this(paramString, paramInt, paramInt, paramLong, paramTimeUnit, paramBlockingQueue);
    if (paramLong > 0L) {
      this.mExecutor.allowCoreThreadTimeOut(true);
    }
  }
  
  final Executor getExecutor()
  {
    return this.mExecutor;
  }
  
  public boolean isShutdown()
  {
    return this.mExecutor.isShutdown();
  }
  
  public void setPriority(int paramInt)
  {
    this.mThreadFactory.setPriority(paramInt);
  }
  
  public void shutdown()
  {
    this.mExecutor.shutdown();
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob)
  {
    return submit(paramJob, null);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener)
  {
    paramJob = new ThreadPool.Worker(this, paramJob, paramFutureListener);
    this.mExecutor.execute(paramJob);
    return paramJob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.utils.thread.ThreadPool
 * JD-Core Version:    0.7.0.1
 */