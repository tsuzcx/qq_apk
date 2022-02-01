package com.tencent.rfw.barrage.util;

import com.tencent.rfw.barrage.inject.RFWVideoBarrageConfig.ILogger;

public class RFWBarrageLogger
{
  private static RFWVideoBarrageConfig.ILogger a;
  private static final StringBuilder b = new StringBuilder();
  
  public static void a(RFWVideoBarrageConfig.ILogger paramILogger)
  {
    a = paramILogger;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    RFWVideoBarrageConfig.ILogger localILogger = a;
    if (localILogger != null) {
      localILogger.a(paramString1, new Object[] { paramString2 });
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    RFWVideoBarrageConfig.ILogger localILogger = a;
    if (localILogger != null) {
      localILogger.a(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (a != null)
    {
      b.setLength(0);
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        b.append(localObject);
        i += 1;
      }
      a.a(paramString, new Object[] { b.toString() });
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    RFWVideoBarrageConfig.ILogger localILogger = a;
    if (localILogger != null) {
      localILogger.b(paramString1, new Object[] { paramString2 });
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    RFWVideoBarrageConfig.ILogger localILogger = a;
    if (localILogger != null) {
      localILogger.b(paramString, paramVarArgs);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    RFWVideoBarrageConfig.ILogger localILogger = a;
    if (localILogger != null) {
      localILogger.c(paramString1, new Object[] { paramString2 });
    }
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    if (a != null)
    {
      b.setLength(0);
      a.b(paramString, paramVarArgs);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    RFWVideoBarrageConfig.ILogger localILogger = a;
    if (localILogger != null) {
      localILogger.d(paramString1, new Object[] { paramString2 });
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    RFWVideoBarrageConfig.ILogger localILogger = a;
    if (localILogger != null) {
      localILogger.d(paramString, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.util.RFWBarrageLogger
 * JD-Core Version:    0.7.0.1
 */