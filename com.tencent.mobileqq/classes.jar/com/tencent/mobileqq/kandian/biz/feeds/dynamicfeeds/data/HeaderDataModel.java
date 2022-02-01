package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

public class HeaderDataModel
{
  public String a;
  public String b;
  public int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("styleID = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", proteusData = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", rankWeight = ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.HeaderDataModel
 * JD-Core Version:    0.7.0.1
 */