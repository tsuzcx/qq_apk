package com.tencent.upload.utils.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory
  implements ThreadFactory
{
  private final String mName;
  private final AtomicInteger mNumber = new AtomicInteger();
  private final int mPriority;
  
  public PriorityThreadFactory(String paramString, int paramInt)
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
    return new PriorityThreadFactory.1(this, paramRunnable, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.utils.pool.PriorityThreadFactory
 * JD-Core Version:    0.7.0.1
 */