package com.tencent.mobileqq.guild.message.unread;

import java.io.Serializable;

public class DecreaseMsgSeqInfo
  implements Serializable
{
  public static int MSGTYPE_ATALL = 1;
  public static int MSGTYPE_NONE = 0;
  private static final long serialVersionUID = 1L;
  public long msgSeq;
  public int msgType = MSGTYPE_NONE;
  
  public DecreaseMsgSeqInfo() {}
  
  public DecreaseMsgSeqInfo(long paramLong, int paramInt)
  {
    this.msgSeq = paramLong;
    this.msgType = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      return ((DecreaseMsgSeqInfo)paramObject).msgSeq == this.msgSeq;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (int)this.msgSeq;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgSeq:");
    localStringBuilder.append(this.msgSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("msgType:");
    localStringBuilder.append(this.msgType);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo
 * JD-Core Version:    0.7.0.1
 */