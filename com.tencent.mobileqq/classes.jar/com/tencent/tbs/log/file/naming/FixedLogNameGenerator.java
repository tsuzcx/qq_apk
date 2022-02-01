package com.tencent.tbs.log.file.naming;

import com.tencent.tbs.log.LogItem;

public class FixedLogNameGenerator
  implements LogNameGenerator
{
  private final String fileName;
  
  public FixedLogNameGenerator(String paramString)
  {
    this.fileName = paramString;
  }
  
  public String generateFileName(LogItem paramLogItem)
  {
    return this.fileName;
  }
  
  public boolean isFileNameChangeable()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.log.file.naming.FixedLogNameGenerator
 * JD-Core Version:    0.7.0.1
 */