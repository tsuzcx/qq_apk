package com.tencent.mobileqq.emosm.control;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class EmoCaptureAsyncAutomator$MyThreadFactory
  implements ThreadFactory
{
  private final AtomicInteger b = new AtomicInteger(1);
  
  private EmoCaptureAsyncAutomator$MyThreadFactory(EmoCaptureAsyncAutomator paramEmoCaptureAsyncAutomator) {}
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CaptureAsyncAutomator_");
    localStringBuilder.append(this.b.getAndIncrement());
    paramRunnable = new Thread(paramRunnable, localStringBuilder.toString());
    paramRunnable.setPriority(4);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoCaptureAsyncAutomator.MyThreadFactory
 * JD-Core Version:    0.7.0.1
 */