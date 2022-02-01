package com.tencent.mobileqq.service.message;

public class MessageCache$MsgSendingInfo
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  
  public MessageCache$MsgSendingInfo(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Int = MessageCache.jdField_a_of_type_Int;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgSendingInfo{frienduin='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", istroop=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", uniseq=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", localSendTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", delayTime=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCache.MsgSendingInfo
 * JD-Core Version:    0.7.0.1
 */