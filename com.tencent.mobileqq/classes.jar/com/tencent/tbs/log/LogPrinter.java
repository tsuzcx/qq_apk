package com.tencent.tbs.log;

public abstract interface LogPrinter
{
  public abstract void close();
  
  public abstract void println(LogItem paramLogItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.LogPrinter
 * JD-Core Version:    0.7.0.1
 */