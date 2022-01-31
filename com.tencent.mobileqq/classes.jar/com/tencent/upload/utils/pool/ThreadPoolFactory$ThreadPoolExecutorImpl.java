package com.tencent.upload.utils.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadPoolFactory$ThreadPoolExecutorImpl
  extends ThreadPoolExecutor
{
  public ThreadPoolFactory$ThreadPoolExecutorImpl(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(new ThreadPoolFactory.RunnableProxy(paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.utils.pool.ThreadPoolFactory.ThreadPoolExecutorImpl
 * JD-Core Version:    0.7.0.1
 */