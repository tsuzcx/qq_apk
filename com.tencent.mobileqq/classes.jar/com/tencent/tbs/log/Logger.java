package com.tencent.tbs.log;

public abstract interface Logger
{
  public abstract void d(String paramString);
  
  public abstract void d(String paramString, Object... paramVarArgs);
  
  public abstract void e(String paramString);
  
  public abstract void e(String paramString, Object... paramVarArgs);
  
  public abstract void i(String paramString);
  
  public abstract void i(String paramString, Object... paramVarArgs);
  
  public abstract void log(int paramInt, String paramString);
  
  public abstract void log(int paramInt, String paramString, Object... paramVarArgs);
  
  public abstract void v(String paramString);
  
  public abstract void v(String paramString, Object... paramVarArgs);
  
  public abstract void w(String paramString);
  
  public abstract void w(String paramString, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.log.Logger
 * JD-Core Version:    0.7.0.1
 */