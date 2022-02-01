package com.tencent.qqlive.module.videoreport.task;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ThreadUtils$1
  implements ThreadFactory
{
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vrpool-");
    localStringBuilder.append(ThreadUtils.access$000().getAndIncrement());
    localStringBuilder.append("-thread");
    return new Thread(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.task.ThreadUtils.1
 * JD-Core Version:    0.7.0.1
 */