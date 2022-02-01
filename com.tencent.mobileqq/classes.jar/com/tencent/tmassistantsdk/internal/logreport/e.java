package com.tencent.tmassistantsdk.internal.logreport;

import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;

public class e
{
  protected static e a;
  private static final Class<?>[] b = { b.class };
  private final INetworkChangedObserver c = new f(this);
  
  private e()
  {
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this.c);
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
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      try
      {
        if (localClass.equals(b.class)) {
          b.g().a();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
    NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this.c);
  }
  
  public void c()
  {
    Class[] arrayOfClass = b;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      try
      {
        if (localClass.equals(b.class)) {
          b.g().b();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.e
 * JD-Core Version:    0.7.0.1
 */