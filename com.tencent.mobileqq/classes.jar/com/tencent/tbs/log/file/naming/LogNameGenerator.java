package com.tencent.tbs.log.file.naming;

import com.tencent.tbs.log.LogItem;

public abstract interface LogNameGenerator
{
  public abstract String generateFileName(LogItem paramLogItem);
  
  public abstract boolean isFileNameChangeable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.log.file.naming.LogNameGenerator
 * JD-Core Version:    0.7.0.1
 */