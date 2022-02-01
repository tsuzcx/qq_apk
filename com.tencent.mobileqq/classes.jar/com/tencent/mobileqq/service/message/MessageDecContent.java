package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.util.MessageRecordUtil;

public class MessageDecContent
{
  public int a;
  public String a;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("-----MessageDecContent----");
    localStringBuilder.append("msgType:").append(this.jdField_a_of_type_Int).append(" content:").append(MessageRecordUtil.a(this.jdField_a_of_type_JavaLangString));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageDecContent
 * JD-Core Version:    0.7.0.1
 */