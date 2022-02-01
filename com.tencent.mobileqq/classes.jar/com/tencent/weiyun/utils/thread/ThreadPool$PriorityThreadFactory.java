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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mName);
    localStringBuilder.append('-');
    localStringBuilder.append(this.mNumber.getAndIncrement());
    return new ThreadPool.PriorityThreadFactory.1(this, paramRunnable, localStringBuilder.toString());
  }
  
  public void setPriority(int paramInt)
  {
    this.mPriority = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.utils.thread.ThreadPool.PriorityThreadFactory
 * JD-Core Version:    0.7.0.1
 */