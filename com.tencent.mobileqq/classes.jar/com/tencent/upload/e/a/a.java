package com.tencent.upload.e.a;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  implements ThreadFactory
{
  private final int a;
  private final AtomicInteger b = new AtomicInteger();
  private final String c;
  
  public a(String paramString, int paramInt)
  {
    this.c = paramString;
    this.a = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    new Thread(paramRunnable, this.c + '-' + this.b.getAndIncrement())
    {
      public void run()
      {
        Process.setThreadPriority(a.a(a.this));
        super.run();
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.a.a
 * JD-Core Version:    0.7.0.1
 */