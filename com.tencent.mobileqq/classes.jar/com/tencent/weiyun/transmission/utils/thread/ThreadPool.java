package com.tencent.weiyun.transmission.utils.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool
{
  protected static final int DEFAULT_POOL_SIZE = 4;
  protected static final int KEEP_ALIVE_TIME = 10;
  public static final int MODE_CPU = 1;
  public static final int MODE_NETWORK = 2;
  public static final int MODE_NONE = 0;
  ThreadPool.ResourceCounter mCpuCounter = new ThreadPool.ResourceCounter(2);
  private final ThreadPoolExecutor mExecutor;
  ThreadPool.ResourceCounter mNetworkCounter = new ThreadPool.ResourceCounter(2);
  
  public ThreadPool()
  {
    this("thread-pool", 4);
  }
  
  public ThreadPool(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt, new LinkedBlockingQueue());
  }
  
  public ThreadPool(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    if (paramInt1 <= 0) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt2 <= paramInt1) {
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        this.mExecutor = new ThreadPoolExecutor(paramInt1, paramInt2, 10L, TimeUnit.SECONDS, paramBlockingQueue, new PriorityThreadFactory(paramString, 10));
        return;
      }
    }
  }
  
  public ThreadPool(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    if (paramThreadPoolExecutor != null) {}
    for (;;)
    {
      this.mExecutor = paramThreadPoolExecutor;
      return;
      paramThreadPoolExecutor = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PriorityThreadFactory("thread_pool", 10));
    }
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
 * Qualified Name:     com.tencent.weiyun.transmission.utils.thread.ThreadPool
 * JD-Core Version:    0.7.0.1
 */