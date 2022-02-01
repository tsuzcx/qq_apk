package com.tencent.upload.utils.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolFactory
{
  public static PriorityThreadPoolExecutor createPriorityThreadPoolExecutor(int paramInt1, int paramInt2, String paramString)
  {
    return new PriorityThreadPoolExecutor(paramInt1, paramInt2, new PriorityThreadFactory(paramString, 0));
  }
  
  public static ThreadPoolExecutor createThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    return new ThreadPoolFactory.ThreadPoolExecutorImpl(paramInt1, paramInt2, paramLong, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory(paramString, 10));
  }
  
  public static ThreadPoolExecutor createThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    return new ThreadPoolFactory.ThreadPoolExecutorImpl(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  public static ThreadPoolExecutor createThreadPoolExecutor(int paramInt, long paramLong, String paramString)
  {
    return new ThreadPoolFactory.ThreadPoolExecutorImpl(paramInt, paramInt, paramLong, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory(paramString, 10));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.utils.pool.ThreadPoolFactory
 * JD-Core Version:    0.7.0.1
 */