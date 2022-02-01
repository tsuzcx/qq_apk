package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadInJoyThreadFactory
  implements ThreadFactory
{
  private final ThreadGroup a;
  private final AtomicInteger b = new AtomicInteger(1);
  private final String c;
  
  ReadInJoyThreadFactory()
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    this.a = ((ThreadGroup)localObject);
    this.c = "readinjoy-common-";
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(this.b.getAndIncrement());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyThreadFactory
 * JD-Core Version:    0.7.0.1
 */