package com.tencent.tfm.metrics.bean;

import com.tencent.tfm.metrics.StatValue;

public class LogItem
{
  public String[] dimensions;
  public final String name;
  public long timestamp;
  public final StatValue[] values;
  
  public LogItem(String paramString, String[] paramArrayOfString, StatValue[] paramArrayOfStatValue, long paramLong)
  {
    this.name = paramString;
    this.dimensions = paramArrayOfString;
    this.values = paramArrayOfStatValue;
    this.timestamp = paramLong;
  }
  
  public String getAggregationKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = this.dimensions;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfString[i]);
      localStringBuilder.append("~");
      i += 1;
    }
    localStringBuilder.append(this.dimensions.length);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfm.metrics.bean.LogItem
 * JD-Core Version:    0.7.0.1
 */