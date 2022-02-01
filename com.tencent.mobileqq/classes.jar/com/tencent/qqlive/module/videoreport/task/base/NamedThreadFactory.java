package com.tencent.qqlive.module.videoreport.task.base;

import android.support.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory
  implements ThreadFactory
{
  private final String mBaseName;
  private final AtomicInteger mCount = new AtomicInteger(0);
  private final ThreadFactory mDefaultThreadFactory = Executors.defaultThreadFactory();
  
  public NamedThreadFactory(String paramString)
  {
    this.mBaseName = paramString;
  }
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    paramRunnable = this.mDefaultThreadFactory.newThread(paramRunnable);
    if (paramRunnable != null) {
      paramRunnable.setName(this.mBaseName + "-" + this.mCount.getAndIncrement());
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.task.base.NamedThreadFactory
 * JD-Core Version:    0.7.0.1
 */