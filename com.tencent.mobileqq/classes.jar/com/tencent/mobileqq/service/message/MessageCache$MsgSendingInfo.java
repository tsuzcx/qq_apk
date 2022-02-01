package com.tencent.mobileqq.service.message;

public class MessageCache$MsgSendingInfo
{
  public String a;
  public int b;
  public long c;
  public long d;
  public int e;
  
  public MessageCache$MsgSendingInfo(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = MessageCache.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgSendingInfo{frienduin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", istroop=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", uniseq=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", localSendTime=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", delayTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCache.MsgSendingInfo
 * JD-Core Version:    0.7.0.1
 */