package com.tencent.qg.sdk.log;

public class GLog
{
  public static final String LOG_TAG = "QGJ.";
  private static IQLog mIQLog;
  
  public static void a(String paramString1, String paramString2)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.a(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.a(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.d(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.i(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void init(IQLog paramIQLog)
  {
    mIQLog = paramIQLog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.v(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.v(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.w(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.w(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    IQLog localIQLog = mIQLog;
    if (localIQLog != null) {
      localIQLog.w(paramString, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.log.GLog
 * JD-Core Version:    0.7.0.1
 */