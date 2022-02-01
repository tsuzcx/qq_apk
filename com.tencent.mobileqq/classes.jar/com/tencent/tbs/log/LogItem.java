package com.tencent.tbs.log;

public final class LogItem
{
  public LogLevel level;
  public String msg;
  public String tag;
  public long timeMillis;
  
  LogItem(long paramLong, LogLevel paramLogLevel, String paramString1, String paramString2)
  {
    this.timeMillis = paramLong;
    this.level = paramLogLevel;
    this.tag = paramString1;
    this.msg = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.LogItem
 * JD-Core Version:    0.7.0.1
 */