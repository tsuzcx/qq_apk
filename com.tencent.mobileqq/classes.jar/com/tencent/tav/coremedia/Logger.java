package com.tencent.tav.coremedia;

public class Logger
{
  private static Logger.ILoggerProxy proxy;
  
  public static void e(String paramString1, String paramString2, Exception paramException)
  {
    try
    {
      if (proxy != null) {
        proxy.e(paramString1, paramString2, paramException);
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void setProxy(Logger.ILoggerProxy paramILoggerProxy)
  {
    try
    {
      proxy = paramILoggerProxy;
      return;
    }
    finally
    {
      paramILoggerProxy = finally;
      throw paramILoggerProxy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.coremedia.Logger
 * JD-Core Version:    0.7.0.1
 */