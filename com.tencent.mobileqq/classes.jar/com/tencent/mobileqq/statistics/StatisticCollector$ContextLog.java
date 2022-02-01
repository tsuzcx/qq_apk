package com.tencent.mobileqq.statistics;

import java.text.SimpleDateFormat;
import java.util.Date;

class StatisticCollector$ContextLog
{
  String log;
  int size = 0;
  String tag;
  long time;
  
  public StatisticCollector$ContextLog(long paramLong, String paramString1, String paramString2)
  {
    this.time = paramLong;
    this.tag = paramString1;
    this.log = paramString2;
    int i;
    if (paramString1 == null)
    {
      i = 0;
      if (paramString2 != null) {
        break label67;
      }
    }
    for (;;)
    {
      this.size = (j + (i + 19 + 1) + 1);
      return;
      i = paramString1.getBytes().length;
      break;
      label67:
      j = paramString2.getBytes().length;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    Date localDate = new Date(this.time);
    localStringBuilder.append(StatisticCollector.access$000().format(localDate));
    localStringBuilder.append(" ");
    localStringBuilder.append(this.tag);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.log);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector.ContextLog
 * JD-Core Version:    0.7.0.1
 */