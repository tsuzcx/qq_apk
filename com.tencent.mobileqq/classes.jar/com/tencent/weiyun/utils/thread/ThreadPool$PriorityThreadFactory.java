package com.tencent.weiyun.utils.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ThreadPool$PriorityThreadFactory
  implements ThreadFactory
{
  private final String mName;
  private final AtomicInteger mNumber = new AtomicInteger();
  private int mPriority;
  
  public ThreadPool$PriorityThreadFactory(String paramString, int paramInt)
  {
    this.mName = paramString;
    this.mPriority = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new ThreadPool.PriorityThreadFactory.1(this, paramRunnable, this.mName + '-' + this.mNumber.getAndIncrement());
  }
  
  public void setPriority(int paramInt)
  {
    this.mPriority = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.utils.thread.ThreadPool.PriorityThreadFactory
 * JD-Core Version:    0.7.0.1
 */