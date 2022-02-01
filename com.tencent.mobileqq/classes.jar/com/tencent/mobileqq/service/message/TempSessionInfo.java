package com.tencent.mobileqq.service.message;

public class TempSessionInfo
{
  public int a;
  public long a;
  public int b;
  public long b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("----dump tempSession info----");
    localStringBuilder.append("friendType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" groupCode:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" groupUin:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.TempSessionInfo
 * JD-Core Version:    0.7.0.1
 */