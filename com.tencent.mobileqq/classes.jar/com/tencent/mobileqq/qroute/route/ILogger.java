package com.tencent.mobileqq.qroute.route;

public abstract interface ILogger
{
  public abstract void debug(String paramString1, String paramString2);
  
  public abstract void info(String paramString1, String paramString2);
  
  public abstract boolean isColorLevel();
  
  public abstract void warning(String paramString1, String paramString2);
  
  public abstract void warning(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.ILogger
 * JD-Core Version:    0.7.0.1
 */