package com.tencent.mobileqq.nearby;

public class INearbyLikeLimitManager$LikeResultItem
{
  public int a;
  public String b;
  public long c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ret=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",uin=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",succFreeLikeCnt=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",succPayLikeCnt=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",todayLikeCnt=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",totalPayStockCnt=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",errMsg=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeResultItem
 * JD-Core Version:    0.7.0.1
 */