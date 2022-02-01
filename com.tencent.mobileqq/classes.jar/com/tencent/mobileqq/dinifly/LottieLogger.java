package com.tencent.mobileqq.dinifly;

public abstract interface LottieLogger
{
  public abstract void debug(String paramString);
  
  public abstract void debug(String paramString, Throwable paramThrowable);
  
  public abstract void error(String paramString, Throwable paramThrowable);
  
  public abstract void warning(String paramString);
  
  public abstract void warning(String paramString, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieLogger
 * JD-Core Version:    0.7.0.1
 */