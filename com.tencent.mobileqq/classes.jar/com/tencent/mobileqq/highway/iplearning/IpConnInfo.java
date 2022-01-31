package com.tencent.mobileqq.highway.iplearning;

import android.os.SystemClock;

public class IpConnInfo
{
  public int iFailCount;
  public boolean isConnSucc;
  public boolean isSameIsp;
  public long lLastSuccTimeMills;
  public String mHost;
  public int mPort = 443;
  
  public IpConnInfo(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this.isConnSucc = paramBoolean1;
    this.mHost = paramString;
    this.mPort = paramInt;
    this.lLastSuccTimeMills = paramLong;
    this.iFailCount = 0;
  }
  
  public void markAsFailOnceMore()
  {
    this.isConnSucc = false;
    this.iFailCount += 1;
  }
  
  public void markAsSucc()
  {
    this.isConnSucc = true;
    this.iFailCount = 0;
    this.lLastSuccTimeMills = SystemClock.uptimeMillis();
  }
  
  public String toString()
  {
    return "_IpConnInfo_ Host:" + this.mHost + " Succ:" + this.isConnSucc + " Fail:" + this.iFailCount + " Time:" + this.lLastSuccTimeMills;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.iplearning.IpConnInfo
 * JD-Core Version:    0.7.0.1
 */