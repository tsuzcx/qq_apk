package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.group_pro_proto.common.common.MsgMeta;

public class IGuildMsgSeqTimeService$MsgSeqTimeItem
  implements Cloneable
{
  public long a;
  public long b;
  public long c;
  public byte[] d;
  
  public IGuildMsgSeqTimeService$MsgSeqTimeItem()
  {
    this.a = -1L;
    this.b = -1L;
    this.c = 0L;
    this.d = null;
  }
  
  public IGuildMsgSeqTimeService$MsgSeqTimeItem(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    }
    this.d = paramArrayOfByte;
  }
  
  public void a(MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    this.a = paramMsgSeqTimeItem.a;
    this.b = paramMsgSeqTimeItem.b;
    this.c = paramMsgSeqTimeItem.c;
    paramMsgSeqTimeItem = paramMsgSeqTimeItem.d;
    if (paramMsgSeqTimeItem == null) {
      paramMsgSeqTimeItem = null;
    } else {
      paramMsgSeqTimeItem = (byte[])paramMsgSeqTimeItem.clone();
    }
    this.d = paramMsgSeqTimeItem;
  }
  
  public boolean a()
  {
    return this.a > -1L;
  }
  
  public MsgSeqTimeItem b()
  {
    try
    {
      MsgSeqTimeItem localMsgSeqTimeItem = (MsgSeqTimeItem)super.clone();
      byte[] arrayOfByte;
      if (this.d == null) {
        arrayOfByte = null;
      } else {
        arrayOfByte = (byte[])this.d.clone();
      }
      localMsgSeqTimeItem.d = arrayOfByte;
      return localMsgSeqTimeItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
  
  public long c()
  {
    if (this.d == null)
    {
      QLog.i("MsgSeqTimeItem", 2, "getAtAllSeq msgMeta is null!");
      return -1L;
    }
    common.MsgMeta localMsgMeta = new common.MsgMeta();
    try
    {
      localMsgMeta.mergeFrom(this.d);
      long l = localMsgMeta.at_all_seq.get();
      return l;
    }
    catch (Exception localException) {}
    return -1L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgSeq:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append("cntSeq:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("msgTime:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    if (this.d != null)
    {
      localStringBuilder.append("atAllSeq:");
      localStringBuilder.append(c());
      localStringBuilder.append(" ");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem
 * JD-Core Version:    0.7.0.1
 */