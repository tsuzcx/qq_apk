package com.tencent.tav.player;

public class PlayerMessage
{
  public Object bizMsg1;
  public Object bizMsg2;
  public String form;
  public long msgId;
  
  public PlayerMessage(Object paramObject, long paramLong)
  {
    this.bizMsg1 = paramObject;
    this.msgId = paramLong;
  }
  
  public PlayerMessage(Object paramObject1, Object paramObject2, String paramString, long paramLong)
  {
    this.bizMsg1 = paramObject1;
    this.bizMsg2 = paramObject2;
    this.form = paramString;
    this.msgId = paramLong;
  }
  
  public PlayerMessage(Object paramObject, String paramString, long paramLong)
  {
    this.bizMsg1 = paramObject;
    this.form = paramString;
    this.msgId = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayerMessage{bizMsg1=");
    localStringBuilder.append(this.bizMsg1);
    localStringBuilder.append(", form='");
    localStringBuilder.append(this.form);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msgId=");
    localStringBuilder.append(this.msgId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.PlayerMessage
 * JD-Core Version:    0.7.0.1
 */