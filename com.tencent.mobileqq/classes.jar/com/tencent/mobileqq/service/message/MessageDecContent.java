package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.util.MessageRecordUtil;

public class MessageDecContent
{
  public int a;
  public String a;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("-----MessageDecContent----");
    localStringBuilder.append("msgType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" content:");
    localStringBuilder.append(MessageRecordUtil.a(this.jdField_a_of_type_JavaLangString));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageDecContent
 * JD-Core Version:    0.7.0.1
 */