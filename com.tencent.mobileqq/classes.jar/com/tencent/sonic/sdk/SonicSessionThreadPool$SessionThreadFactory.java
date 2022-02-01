package com.tencent.sonic.sdk;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class SonicSessionThreadPool$SessionThreadFactory
  implements ThreadFactory
{
  private static final String NAME_PREFIX = "pool-sonic-session-thread-";
  private final ThreadGroup group;
  private final AtomicInteger threadNumber = new AtomicInteger(1);
  
  SonicSessionThreadPool$SessionThreadFactory()
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    this.group = ((ThreadGroup)localObject);
  }
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.group;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pool-sonic-session-thread-");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionThreadPool.SessionThreadFactory
 * JD-Core Version:    0.7.0.1
 */