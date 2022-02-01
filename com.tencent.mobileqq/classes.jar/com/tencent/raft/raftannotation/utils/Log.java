package com.tencent.raft.raftannotation.utils;

public class Log
{
  private static Log.LogPrinter logPrinter = new Log.LogPrinter();
  
  public static void d(String paramString1, String paramString2)
  {
    logPrinter.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    logPrinter.e(paramString1, paramString2);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    logPrinter.e(paramString, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    logPrinter.i(paramString1, paramString2);
  }
  
  static void setLogPrinter(Log.LogPrinter paramLogPrinter)
  {
    if (paramLogPrinter != null) {
      logPrinter = paramLogPrinter;
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    logPrinter.v(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    logPrinter.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftannotation.utils.Log
 * JD-Core Version:    0.7.0.1
 */