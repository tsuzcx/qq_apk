package com.tencent.tvkbeacon.core.a;

import com.tencent.tvkbeacon.core.c.c;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class b$b
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    try
    {
      paramRunnable = new Thread(paramRunnable, "tvkbeacon-thread-" + this.a.getAndIncrement());
      return paramRunnable;
    }
    catch (Exception paramRunnable)
    {
      c.a(paramRunnable);
      return null;
    }
    catch (OutOfMemoryError paramRunnable)
    {
      for (;;)
      {
        c.d("[task] memory not enough, create thread failed.", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.a.b.b
 * JD-Core Version:    0.7.0.1
 */