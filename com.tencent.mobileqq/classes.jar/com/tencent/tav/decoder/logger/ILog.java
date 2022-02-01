package com.tencent.tav.decoder.logger;

public abstract interface ILog
{
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void v(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.logger.ILog
 * JD-Core Version:    0.7.0.1
 */