package com.tencent.mobileqq.guild.message.eventflow;

import java.io.Serializable;

public class GuildEventFlowTimeItem
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public byte[] cookie;
  public long eventBeginTime = 0L;
  public long eventEndTime = 0L;
  public long registProxyTime = 0L;
  
  public GuildEventFlowTimeItem()
  {
    this.cookie = null;
  }
  
  public GuildEventFlowTimeItem(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    this.cookie = null;
    this.registProxyTime = paramLong1;
    this.eventBeginTime = paramLong2;
    this.eventEndTime = paramLong3;
    if (paramArrayOfByte == null) {
      paramArrayOfByte = localObject;
    } else {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    }
    this.cookie = paramArrayOfByte;
  }
  
  public GuildEventFlowTimeItem clone()
  {
    try
    {
      GuildEventFlowTimeItem localGuildEventFlowTimeItem = (GuildEventFlowTimeItem)super.clone();
      byte[] arrayOfByte;
      if (this.cookie == null) {
        arrayOfByte = null;
      } else {
        arrayOfByte = (byte[])this.cookie.clone();
      }
      localGuildEventFlowTimeItem.cookie = arrayOfByte;
      return localGuildEventFlowTimeItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registProxyTime:");
    localStringBuilder.append(this.registProxyTime);
    localStringBuilder.append(" ");
    localStringBuilder.append("eventBeginTime:");
    localStringBuilder.append(this.eventBeginTime);
    localStringBuilder.append(" ");
    localStringBuilder.append("eventEndTime:");
    localStringBuilder.append(this.eventEndTime);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowTimeItem
 * JD-Core Version:    0.7.0.1
 */