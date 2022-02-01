package org.aspectj.runtime.internal;

import org.aspectj.runtime.internal.cflowstack.ThreadCounter;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactory;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;

public class CFlowCounter
{
  private static ThreadStackFactory tsFactory;
  private ThreadCounter flowHeightHandler = tsFactory.getNewThreadCounter();
  
  static {}
  
  private static String getSystemPropertyWithoutSecurityException(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = System.getProperty(paramString1, paramString2);
      return paramString1;
    }
    catch (SecurityException paramString1) {}
    return paramString2;
  }
  
  private static ThreadStackFactory getThreadLocalStackFactory()
  {
    return new ThreadStackFactoryImpl();
  }
  
  private static ThreadStackFactory getThreadLocalStackFactoryFor11()
  {
    return new ThreadStackFactoryImpl11();
  }
  
  public static String getThreadStackFactoryClassName()
  {
    return tsFactory.getClass().getName();
  }
  
  private static void selectFactoryForVMVersion()
  {
    String str = getSystemPropertyWithoutSecurityException("aspectj.runtime.cflowstack.usethreadlocal", "unspecified");
    boolean bool = str.equals("unspecified");
    int i = 0;
    if (bool)
    {
      if (System.getProperty("java.class.version", "0.0").compareTo("46.0") < 0) {}
    }
    else {
      while ((str.equals("yes")) || (str.equals("true")))
      {
        i = 1;
        break;
      }
    }
    if (i != 0)
    {
      tsFactory = getThreadLocalStackFactory();
      return;
    }
    tsFactory = getThreadLocalStackFactoryFor11();
  }
  
  public void dec()
  {
    this.flowHeightHandler.dec();
    if (!this.flowHeightHandler.isNotZero()) {
      this.flowHeightHandler.removeThreadCounter();
    }
  }
  
  public void inc()
  {
    this.flowHeightHandler.inc();
  }
  
  public boolean isValid()
  {
    return this.flowHeightHandler.isNotZero();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.CFlowCounter
 * JD-Core Version:    0.7.0.1
 */