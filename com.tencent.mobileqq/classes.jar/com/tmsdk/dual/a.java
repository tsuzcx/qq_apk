package com.tmsdk.dual;

import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import tmsdkdual.e;
import tmsdkdual.f;
import tmsdkdual.h;

public class a
{
  public static int a = 0;
  public static boolean b = true;
  private static HandlerThread c;
  
  public static Looper a()
  {
    if (c == null)
    {
      c = new HandlerThread("TMSDual_Core_Looper");
      c.start();
    }
    for (;;)
    {
      return c.getLooper();
      if (!c.isAlive())
      {
        c = new HandlerThread("TMSDual_Core_Looper");
        c.start();
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      if (tmsdkdual.a.b().g.getBoolean("r_drsn", true)) {
        new e().f();
      }
      label27:
      if (!paramBoolean) {}
      try
      {
        f.g();
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          try
          {
            h.b(paramBoolean);
            return;
          }
          catch (Throwable localThrowable2)
          {
            return;
          }
          localThrowable1 = localThrowable1;
        }
      }
    }
    catch (Throwable localThrowable3)
    {
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tmsdk.dual.a
 * JD-Core Version:    0.7.0.1
 */