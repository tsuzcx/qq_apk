package com.tencent.weiyun.transmission.utils.thread;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory
  implements ThreadFactory
{
  public static final String FLAG_THREAD_NAME_SPLIT = " sub:";
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
    new Thread(paramRunnable, this.mName + '-' + this.mNumber.getAndIncrement() + " sub:")
    {
      public void run()
      {
        Process.setThreadPriority(PriorityThreadFactory.this.mPriority);
        super.run();
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.thread.PriorityThreadFactory
 * JD-Core Version:    0.7.0.1
 */