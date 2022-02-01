package com.tencent.mobileqq.nearby;

public class INearbyLikeLimitManager$LikeItem
{
  public long a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",freeLikeCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",payLikeCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",totalPerCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",source=");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeItem
 * JD-Core Version:    0.7.0.1
 */