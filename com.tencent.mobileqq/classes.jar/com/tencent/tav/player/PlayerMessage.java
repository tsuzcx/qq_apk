package com.tencent.tav.player;

public class PlayerMessage
{
  public Object bizMsg1;
  public String form;
  public long msgId;
  
  public PlayerMessage(Object paramObject, long paramLong)
  {
    this.bizMsg1 = paramObject;
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
    return "PlayerMessage{bizMsg1=" + this.bizMsg1 + ", form='" + this.form + '\'' + ", msgId=" + this.msgId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.player.PlayerMessage
 * JD-Core Version:    0.7.0.1
 */