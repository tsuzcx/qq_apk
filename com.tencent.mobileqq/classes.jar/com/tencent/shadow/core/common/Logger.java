package com.tencent.shadow.core.common;

public abstract interface Logger
{
  public abstract void debug(String paramString);
  
  public abstract void debug(String paramString, Object paramObject);
  
  public abstract void debug(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void debug(String paramString, Throwable paramThrowable);
  
  public abstract void debug(String paramString, Object... paramVarArgs);
  
  public abstract void error(String paramString);
  
  public abstract void error(String paramString, Object paramObject);
  
  public abstract void error(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void error(String paramString, Throwable paramThrowable);
  
  public abstract void error(String paramString, Object... paramVarArgs);
  
  public abstract String getName();
  
  public abstract void info(String paramString);
  
  public abstract void info(String paramString, Object paramObject);
  
  public abstract void info(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void info(String paramString, Throwable paramThrowable);
  
  public abstract void info(String paramString, Object... paramVarArgs);
  
  public abstract boolean isDebugEnabled();
  
  public abstract boolean isErrorEnabled();
  
  public abstract boolean isInfoEnabled();
  
  public abstract boolean isTraceEnabled();
  
  public abstract boolean isWarnEnabled();
  
  public abstract void trace(String paramString);
  
  public abstract void trace(String paramString, Object paramObject);
  
  public abstract void trace(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void trace(String paramString, Throwable paramThrowable);
  
  public abstract void trace(String paramString, Object... paramVarArgs);
  
  public abstract void warn(String paramString);
  
  public abstract void warn(String paramString, Object paramObject);
  
  public abstract void warn(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void warn(String paramString, Throwable paramThrowable);
  
  public abstract void warn(String paramString, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.core.common.Logger
 * JD-Core Version:    0.7.0.1
 */