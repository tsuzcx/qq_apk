package com.tencent.mobileqq.dinifly.utils;

import com.tencent.mobileqq.dinifly.LottieLogger;

public class Logger
{
  private static LottieLogger INSTANCE = new LogcatLogger();
  
  public static void debug(String paramString)
  {
    INSTANCE.debug(paramString);
  }
  
  public static void debug(String paramString, Throwable paramThrowable)
  {
    INSTANCE.debug(paramString, paramThrowable);
  }
  
  public static void error(String paramString, Throwable paramThrowable)
  {
    INSTANCE.error(paramString, paramThrowable);
  }
  
  public static void setInstance(LottieLogger paramLottieLogger)
  {
    INSTANCE = paramLottieLogger;
  }
  
  public static void warning(String paramString)
  {
    INSTANCE.warning(paramString);
  }
  
  public static void warning(String paramString, Throwable paramThrowable)
  {
    INSTANCE.warning(paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.Logger
 * JD-Core Version:    0.7.0.1
 */