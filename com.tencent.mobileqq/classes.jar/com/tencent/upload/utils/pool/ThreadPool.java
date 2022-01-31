package com.tencent.upload.utils.pool;

public class ThreadPool
{
  private static final int CORE_POOL_SIZE = 4;
  public static final ThreadPool.JobContext JOB_CONTEXT_STUB = new ThreadPool.JobContextStub(null);
  private static final int MAX_POOL_SIZE = 8;
  public static final int MODE_CPU = 1;
  public static final int MODE_NETWORK = 2;
  public static final int MODE_NONE = 0;
  private static final String TAG = "ThreadPool";
  private final PriorityThreadPoolExecutor mExecutor;
  
  public ThreadPool()
  {
    this(4, 8);
  }
  
  public ThreadPool(int paramInt1, int paramInt2)
  {
    this.mExecutor = ThreadPoolFactory.createPriorityThreadPoolExecutor(paramInt1, paramInt2, "thread-pool");
  }
  
  public ThreadPool(int paramInt1, int paramInt2, String paramString)
  {
    this.mExecutor = ThreadPoolFactory.createPriorityThreadPoolExecutor(paramInt1, paramInt2, paramString);
  }
  
  public PriorityThreadPoolExecutor getExecutor()
  {
    return this.mExecutor;
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob)
  {
    return submit(paramJob, 0, null);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, int paramInt)
  {
    return submit(paramJob, paramInt, null);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, int paramInt, FutureListener<T> paramFutureListener)
  {
    paramJob = new ThreadPool.Worker(this, paramJob, paramFutureListener);
    this.mExecutor.submit(paramJob, paramInt);
    return paramJob;
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener)
  {
    return submit(paramJob, 0, paramFutureListener);
  }
  
  public java.util.concurrent.Future<?> submit(Runnable paramRunnable)
  {
    return this.mExecutor.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.utils.pool.ThreadPool
 * JD-Core Version:    0.7.0.1
 */