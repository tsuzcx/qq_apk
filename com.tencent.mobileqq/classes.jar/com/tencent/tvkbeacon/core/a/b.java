package com.tencent.tvkbeacon.core.a;

import com.tencent.tvkbeacon.core.c.c;
import java.util.concurrent.ScheduledExecutorService;

public abstract class b
{
  public static boolean a = true;
  private static b c;
  private long b = 10000L;
  
  public static b a(ScheduledExecutorService paramScheduledExecutorService)
  {
    return new b.a(paramScheduledExecutorService);
  }
  
  public static void a(b paramb)
  {
    try
    {
      c.b("[task] setInstance: ".concat(String.valueOf(paramb)), new Object[0]);
      if (c != null) {
        c.a();
      }
      c = paramb;
      c.b("[task] setInstance end", new Object[0]);
      return;
    }
    finally {}
  }
  
  public static b d()
  {
    try
    {
      if (c == null) {
        c = new b.a();
      }
      b localb = c;
      return localb;
    }
    finally {}
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(Runnable paramRunnable, long paramLong);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.a.b
 * JD-Core Version:    0.7.0.1
 */