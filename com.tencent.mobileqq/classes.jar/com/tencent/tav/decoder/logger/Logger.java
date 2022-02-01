package com.tencent.tav.decoder.logger;

public class Logger
{
  public static final int NO_LOG = 2147483647;
  private static int level = 3;
  private static ILog logProxy = new Logger.DefaultLogProxy(null);
  
  public static void d(String paramString1, String paramString2)
  {
    if ((logProxy == null) || (level > 3)) {
      return;
    }
    logProxy.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if ((logProxy == null) || (level > 6)) {
      return;
    }
    logProxy.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((logProxy == null) || (level > 6)) {
      return;
    }
    logProxy.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if ((logProxy == null) || (level > 4)) {
      return;
    }
    logProxy.i(paramString1, paramString2);
  }
  
  public static void setLevel(int paramInt)
  {
    level = paramInt;
  }
  
  public static void setLogProxy(ILog paramILog)
  {
    logProxy = paramILog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if ((logProxy == null) || (level > 2)) {
      return;
    }
    logProxy.v(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if ((logProxy == null) || (level > 5)) {
      return;
    }
    logProxy.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.logger.Logger
 * JD-Core Version:    0.7.0.1
 */