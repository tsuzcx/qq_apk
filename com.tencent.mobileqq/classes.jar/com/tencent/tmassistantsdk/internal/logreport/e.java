package com.tencent.tmassistantsdk.internal.logreport;

import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.network.a;

public class e
{
  protected static e a = null;
  private static final Class<?>[] b = { b.class };
  private final a c = new f(this);
  
  private e()
  {
    NetworkMonitorReceiver.a().a(this.c);
    c();
  }
  
  public static e a()
  {
    try
    {
      if (a == null) {
        a = new e();
      }
      e locale = a;
      return locale;
    }
    finally {}
  }
  
  public void b()
  {
    Class[] arrayOfClass = b;
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(b.class)) {
            b.h().a();
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    NetworkMonitorReceiver.a().b(this.c);
  }
  
  public void c()
  {
    Class[] arrayOfClass = b;
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(b.class)) {
            b.h().c();
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public void d()
  {
    Class[] arrayOfClass = b;
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(b.class)) {
            b.h().b();
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.e
 * JD-Core Version:    0.7.0.1
 */