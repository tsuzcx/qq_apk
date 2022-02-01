package org.xwalk.core;

public abstract interface XWalkHttpAuth
{
  public abstract void cancel();
  
  public abstract boolean isFirstAttempt();
  
  public abstract void proceed(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkHttpAuth
 * JD-Core Version:    0.7.0.1
 */