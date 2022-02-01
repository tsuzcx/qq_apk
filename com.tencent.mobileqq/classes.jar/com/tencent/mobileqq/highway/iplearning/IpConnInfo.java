package com.tencent.mobileqq.highway.iplearning;

import android.os.SystemClock;

public class IpConnInfo
{
  public int iFailCount = 0;
  public boolean isConnSucc = false;
  public boolean isSameIsp = false;
  public long lLastSuccTimeMills = 0L;
  public String mHost = null;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_IpConnInfo_ Host:");
    localStringBuilder.append(this.mHost);
    localStringBuilder.append(" Succ:");
    localStringBuilder.append(this.isConnSucc);
    localStringBuilder.append(" Fail:");
    localStringBuilder.append(this.iFailCount);
    localStringBuilder.append(" Time:");
    localStringBuilder.append(this.lLastSuccTimeMills);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.iplearning.IpConnInfo
 * JD-Core Version:    0.7.0.1
 */