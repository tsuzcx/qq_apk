package com.tencent.mobileqq.data;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ApolloKapuEntranceTips
  extends Entity
{
  public String activityUrl;
  @unique
  public int adId;
  public long duration;
  public long endTime;
  public boolean isClick;
  public boolean isInstall;
  public int priority;
  public int showCount;
  public int shownCount;
  public long startTime;
  public String text;
  public String traceInfo;
  
  public boolean isValid()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    return (!this.isClick) && (this.startTime <= l) && (this.endTime > l) && (this.shownCount < this.showCount);
  }
  
  public String toString()
  {
    return "ApolloKapuEntranceTips{adId=" + this.adId + ", text='" + this.text + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", showCount=" + this.showCount + ", duration=" + this.duration + ", activityUrl='" + this.activityUrl + '\'' + ", priority=" + this.priority + ", isInstall=" + this.isInstall + ", shownCount=" + this.shownCount + ", isClick=" + this.isClick + ", traceInfo='" + this.traceInfo + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloKapuEntranceTips
 * JD-Core Version:    0.7.0.1
 */