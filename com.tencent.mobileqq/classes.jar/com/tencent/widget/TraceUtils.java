package com.tencent.widget;

import android.os.Build.VERSION;
import java.lang.reflect.Method;

public class TraceUtils
{
  private static Method a;
  private static Method b;
  
  public static void a() {}
  
  public static void a(long paramLong, String paramString, int paramInt)
  {
    if ((Build.VERSION.SDK_INT <= 17) || (a == null)) {}
    try
    {
      a = Class.forName("android.os.Trace").getMethod("asyncTraceBegin", new Class[] { Long.TYPE, String.class, Integer.TYPE });
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          a.invoke(null, new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
          return;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
        }
        localThrowable = localThrowable;
        localThrowable.printStackTrace();
      }
    }
  }
  
  public static void a(String paramString) {}
  
  public static void b(long paramLong, String paramString, int paramInt)
  {
    if ((Build.VERSION.SDK_INT <= 17) || (b == null)) {}
    try
    {
      b = Class.forName("android.os.Trace").getMethod("asyncTraceEnd", new Class[] { Long.TYPE, String.class, Integer.TYPE });
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          b.invoke(null, new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
          return;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
        }
        localThrowable = localThrowable;
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.TraceUtils
 * JD-Core Version:    0.7.0.1
 */