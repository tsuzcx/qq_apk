package com.tencent.mobileqq.leba.entity;

public class GroupInfo
{
  public long a;
  public int b;
  public int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GroupInfo：");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.entity.GroupInfo
 * JD-Core Version:    0.7.0.1
 */