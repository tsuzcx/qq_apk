package com.tencent.raft.raftframework.log;

public abstract interface ILogDelegate
{
  public abstract void debug(String paramString1, String paramString2);
  
  public abstract void debug(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void error(String paramString1, String paramString2);
  
  public abstract void error(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void info(String paramString1, String paramString2);
  
  public abstract void info(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void warn(String paramString1, String paramString2);
  
  public abstract void warn(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftframework.log.ILogDelegate
 * JD-Core Version:    0.7.0.1
 */