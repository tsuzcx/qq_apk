package com.tencent.mobileqq.kandian.biz.feeds.entity;

public class ColumnInfoForSelfPage
{
  public int a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ColumnInfoForSelfPage{myVideoCount=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", myColumnCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mySubscribeCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", myVideoJumpUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", myColumnJumpUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mySubscribeJumpUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.entity.ColumnInfoForSelfPage
 * JD-Core Version:    0.7.0.1
 */