package com.tencent.tavsticker.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadPoolManager$CommonThreadFactory
  implements ThreadFactory
{
  public final ThreadGroup group = Thread.currentThread().getThreadGroup();
  public final String threadNamePrefix;
  public final AtomicInteger threadNumber = new AtomicInteger(1);
  
  public ThreadPoolManager$CommonThreadFactory(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    this.threadNamePrefix = localStringBuilder.toString();
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.group;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.threadNamePrefix);
    localStringBuilder.append(this.threadNumber.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 1) {
      paramRunnable.setPriority(1);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.utils.ThreadPoolManager.CommonThreadFactory
 * JD-Core Version:    0.7.0.1
 */