package com.tencent.mobileqq.nearby;

public class INearbyLikeLimitManager$LikeResultItem
{
  public int a;
  public long a;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ret=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",uin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",succFreeLikeCnt=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",succPayLikeCnt=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",todayLikeCnt=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",totalPayStockCnt=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",errMsg=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeResultItem
 * JD-Core Version:    0.7.0.1
 */