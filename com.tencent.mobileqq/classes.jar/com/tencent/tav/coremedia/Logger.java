package com.tencent.tav.coremedia;

public class Logger
{
  private static Logger.ILoggerProxy a;
  
  public static void a(Logger.ILoggerProxy paramILoggerProxy)
  {
    try
    {
      a = paramILoggerProxy;
      return;
    }
    finally
    {
      paramILoggerProxy = finally;
      throw paramILoggerProxy;
    }
  }
  
  public static void a(String paramString1, String paramString2, Exception paramException)
  {
    try
    {
      if (a != null) {
        a.e(paramString1, paramString2, paramException);
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.coremedia.Logger
 * JD-Core Version:    0.7.0.1
 */