package com.tencent.viola.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory
  implements ThreadFactory
{
  private static final AtomicInteger poolNumber = new AtomicInteger(1);
  private final ThreadGroup group;
  private final String namePrefix;
  private final AtomicInteger threadNumber = new AtomicInteger(1);
  
  NamedThreadFactory(String paramString)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    this.group = ((ThreadGroup)localObject);
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      localObject = "violaThreadPool";
    }
    paramString = new StringBuilder();
    paramString.append((String)localObject);
    paramString.append("-");
    paramString.append(poolNumber.getAndIncrement());
    paramString.append("-thread-");
    this.namePrefix = paramString.toString();
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.group;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.namePrefix);
    localStringBuilder.append(this.threadNumber.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.NamedThreadFactory
 * JD-Core Version:    0.7.0.1
 */