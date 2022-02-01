package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.util.MessageRecordUtil;

public class MessageDecContent
{
  public int a;
  public String b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("-----MessageDecContent----");
    localStringBuilder.append("msgType:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" content:");
    localStringBuilder.append(MessageRecordUtil.a(this.b));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageDecContent
 * JD-Core Version:    0.7.0.1
 */