package com.tencent.mobileqq.qqguildsdk.data;

public class AddGuildOption
{
  public int a = 0;
  public String b;
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AddGuildOption{optionType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", question='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", answer='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.AddGuildOption
 * JD-Core Version:    0.7.0.1
 */