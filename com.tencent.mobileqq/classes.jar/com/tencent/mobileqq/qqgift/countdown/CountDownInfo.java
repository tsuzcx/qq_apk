package com.tencent.mobileqq.qqgift.countdown;

public class CountDownInfo
{
  public int a;
  public long b;
  public long c;
  
  public CountDownInfo(int paramInt, long paramLong1, long paramLong2)
  {
    this.a = paramInt;
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  public float a(long paramLong1, long paramLong2)
  {
    if (paramLong2 == 0L) {
      return 100.0F;
    }
    return 100.0F * (1.0F - (float)paramLong1 * 1.0F / (float)paramLong2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CountDownInfo{giftID=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", remainTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", countDownTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.countdown.CountDownInfo
 * JD-Core Version:    0.7.0.1
 */