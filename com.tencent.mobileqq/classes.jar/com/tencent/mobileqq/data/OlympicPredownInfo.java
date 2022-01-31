package com.tencent.mobileqq.data;

import awge;
import awhs;

public class OlympicPredownInfo
  extends awge
{
  public int dailyRetryCount;
  public long dailyStartTime;
  public int totalRetryCount;
  @awhs
  public String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", url=").append(this.url);
    localStringBuilder.append(", dailyRetryCount=").append(this.dailyRetryCount);
    localStringBuilder.append(", dailyStartTime=").append(this.dailyStartTime);
    localStringBuilder.append(", totalRetryCount=").append(this.totalRetryCount);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.OlympicPredownInfo
 * JD-Core Version:    0.7.0.1
 */