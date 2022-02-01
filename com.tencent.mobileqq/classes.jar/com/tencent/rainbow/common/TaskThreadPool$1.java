package com.tencent.rainbow.common;

import java.util.concurrent.ThreadFactory;

class TaskThreadPool$1
  implements ThreadFactory
{
  TaskThreadPool$1(TaskThreadPool paramTaskThreadPool) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rainbow-thread-pool-");
    localStringBuilder.append(paramRunnable.getId());
    paramRunnable.setName(localStringBuilder.toString());
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rainbow.common.TaskThreadPool.1
 * JD-Core Version:    0.7.0.1
 */