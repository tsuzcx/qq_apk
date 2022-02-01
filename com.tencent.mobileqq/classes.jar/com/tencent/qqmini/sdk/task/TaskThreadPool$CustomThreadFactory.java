package com.tencent.qqmini.sdk.task;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class TaskThreadPool$CustomThreadFactory
  implements ThreadFactory
{
  private static final AtomicInteger poolNumber = new AtomicInteger(1);
  private final ThreadGroup group;
  private final String namePrefix;
  private final AtomicInteger threadNumber = new AtomicInteger(1);
  
  TaskThreadPool$CustomThreadFactory(String paramString)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    this.group = ((ThreadGroup)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "threadpool";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("-");
    localStringBuilder.append(poolNumber.getAndIncrement());
    localStringBuilder.append("-thread-");
    this.namePrefix = localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskThreadPool.CustomThreadFactory
 * JD-Core Version:    0.7.0.1
 */