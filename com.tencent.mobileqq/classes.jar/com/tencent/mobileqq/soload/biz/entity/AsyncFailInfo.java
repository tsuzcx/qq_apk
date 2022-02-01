package com.tencent.mobileqq.soload.biz.entity;

public class AsyncFailInfo
{
  public int lastFailCode = 0;
  public long lastFailTime = 0L;
  public int lastSubFailCode;
  public int netType = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FailInfo{lastFCode=");
    localStringBuilder.append(this.lastFailCode);
    localStringBuilder.append(", lastSubFCode=");
    localStringBuilder.append(this.lastSubFailCode);
    localStringBuilder.append(", netType=");
    localStringBuilder.append(this.netType);
    localStringBuilder.append(", lastFTime=");
    localStringBuilder.append(this.lastFailTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.AsyncFailInfo
 * JD-Core Version:    0.7.0.1
 */