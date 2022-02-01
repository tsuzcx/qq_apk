package com.tencent.mobileqq.config;

public final class QConfItem
{
  @Deprecated
  public int a;
  public String b;
  
  public QConfItem(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QConfItem{taskId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfItem
 * JD-Core Version:    0.7.0.1
 */