package com.tencent.mobileqq.service.message;

public class TempSessionInfo
{
  public int a;
  public long b;
  public long c;
  public int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("----dump tempSession info----");
    localStringBuilder.append("friendType:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" groupCode:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" groupUin:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.TempSessionInfo
 * JD-Core Version:    0.7.0.1
 */