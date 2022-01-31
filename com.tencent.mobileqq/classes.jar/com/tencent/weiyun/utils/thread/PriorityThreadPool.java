package com.tencent.weiyun.utils.thread;

import android.annotation.TargetApi;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityThreadPool
  extends ThreadPool
{
  public PriorityThreadPool()
  {
    this("priority-thread-pool", 4);
  }
  
  public PriorityThreadPool(String paramString, int paramInt)
  {
    super(paramString, paramInt, paramInt, new PriorityBlockingQueue());
  }
  
  @TargetApi(9)
  public PriorityThreadPool(String paramString, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramString, paramInt, paramLong, paramTimeUnit, new PriorityBlockingQueue());
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob)
  {
    return submit(paramJob, null, null);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener)
  {
    return submit(paramJob, paramFutureListener, null);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener, PriorityThreadPool.Priority paramPriority)
  {
    PriorityThreadPool.Priority localPriority = paramPriority;
    if (paramPriority == null) {
      localPriority = PriorityThreadPool.Priority.NORMAL;
    }
    return super.submit(new PriorityThreadPool.PriorityJob(paramJob, localPriority.priority, localPriority.fifo), paramFutureListener);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, PriorityThreadPool.Priority paramPriority)
  {
    return submit(paramJob, null, paramPriority);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.utils.thread.PriorityThreadPool
 * JD-Core Version:    0.7.0.1
 */