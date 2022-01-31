package com.tencent.mobileqq.data;

import atmo;
import atoc;

public class OlympicPredownInfo
  extends atmo
{
  public int dailyRetryCount;
  public long dailyStartTime;
  public int totalRetryCount;
  @atoc
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.OlympicPredownInfo
 * JD-Core Version:    0.7.0.1
 */