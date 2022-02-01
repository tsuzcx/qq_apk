package com.tencent.mobileqq.qqexpand.bean.match;

public class CompletePesonalDataTask
{
  public int a;
  public int b;
  public String c;
  public int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompletePesonalDataTask{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", rewardCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", taskDescription='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", taskStatus=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.match.CompletePesonalDataTask
 * JD-Core Version:    0.7.0.1
 */