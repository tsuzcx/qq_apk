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
    return "MsgSendingInfo{frienduin='" + this.jdField_a_of_type_JavaLangString + '\'' + ", istroop=" + this.jdField_a_of_type_Int + ", uniseq=" + this.jdField_a_of_type_Long + ", localSendTime=" + this.jdField_b_of_type_Long + ", delayTime=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCache.MsgSendingInfo
 * JD-Core Version:    0.7.0.1
 */