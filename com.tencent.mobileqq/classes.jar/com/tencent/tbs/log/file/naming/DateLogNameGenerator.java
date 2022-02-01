package com.tencent.tbs.log.file.naming;

import com.tencent.tbs.log.LogItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateLogNameGenerator
  implements LogNameGenerator
{
  ThreadLocal<SimpleDateFormat> mLocalDateFormat = new DateLogNameGenerator.1(this);
  
  public String generateFileName(LogItem paramLogItem)
  {
    long l;
    if (paramLogItem != null) {
      l = paramLogItem.timeMillis;
    } else {
      l = System.currentTimeMillis();
    }
    paramLogItem = (SimpleDateFormat)this.mLocalDateFormat.get();
    paramLogItem.setTimeZone(TimeZone.getDefault());
    return paramLogItem.format(new Date(l));
  }
  
  public boolean isFileNameChangeable()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.log.file.naming.DateLogNameGenerator
 * JD-Core Version:    0.7.0.1
 */