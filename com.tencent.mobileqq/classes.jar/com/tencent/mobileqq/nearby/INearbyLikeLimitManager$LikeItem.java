package com.tencent.mobileqq.nearby;

public class INearbyLikeLimitManager$LikeItem
{
  public int a;
  public long a;
  public int b;
  public int c;
  public int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",freeLikeCount=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",payLikeCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",totalPerCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",source=");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeItem
 * JD-Core Version:    0.7.0.1
 */