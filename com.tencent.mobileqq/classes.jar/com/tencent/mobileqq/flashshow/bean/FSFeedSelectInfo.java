package com.tencent.mobileqq.flashshow.bean;

public class FSFeedSelectInfo
{
  private int a = 0;
  private int b;
  
  public FSFeedSelectInfo(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public FSFeedSelectInfo a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSFeedSelectInfo{mStatus=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mPosition=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo
 * JD-Core Version:    0.7.0.1
 */