package com.tencent.mobileqq.mini.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class AppDetainRecordEntity
  extends Entity
{
  @unique
  public String appId;
  public int showTimes = 0;
  public long timestamp = 0L;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TempEntity{appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(", showTimes=");
    localStringBuilder.append(this.showTimes);
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.timestamp);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entity.AppDetainRecordEntity
 * JD-Core Version:    0.7.0.1
 */