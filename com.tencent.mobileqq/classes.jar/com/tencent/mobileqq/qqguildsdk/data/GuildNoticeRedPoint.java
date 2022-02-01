package com.tencent.mobileqq.qqguildsdk.data;

public class GuildNoticeRedPoint
{
  public int a = 0;
  public int b = 0;
  public long c = 0L;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildNoticeRedPoint{redPointType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", expireTs=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint
 * JD-Core Version:    0.7.0.1
 */