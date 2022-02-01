package com.tencent.tav.decoder.logger;

public class Logger
{
  public static final int NO_LOG = 2147483647;
  private static int level = 3;
  private static ILog logProxy = new Logger.DefaultLogProxy(null);
  
  static
  {
    com.tencent.tav.coremedia.Logger.setProxy(new Logger.1());
  }
  
  public static void d(String paramString1, String paramString2)
  {
    ILog localILog = logProxy;
    if (localILog != null)
    {
      if (level > 3) {
        return;
      }
      localILog.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    ILog localILog = logProxy;
    if (localILog != null)
    {
      if (level > 6) {
        return;
      }
      localILog.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ILog localILog = logProxy;
    if (localILog != null)
    {
      if (level > 6) {
        return;
      }
      localILog.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    ILog localILog = logProxy;
    if (localILog != null)
    {
      if (level > 4) {
        return;
      }
      localILog.i(paramString1, paramString2);
    }
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
    ILog localILog = logProxy;
    if (localILog != null)
    {
      if (level > 2) {
        return;
      }
      localILog.v(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    ILog localILog = logProxy;
    if (localILog != null)
    {
      if (level > 5) {
        return;
      }
      localILog.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.logger.Logger
 * JD-Core Version:    0.7.0.1
 */