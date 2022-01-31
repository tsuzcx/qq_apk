package com.tencent.mobileqq.data;

import awge;
import awhp;
import bdeu;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.UnsupportedEncodingException;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="subUin,senderuin,time")
public class SubAccountMessage
  extends awge
  implements Comparable<SubAccountMessage>
{
  public static final String SUB_EXTR_RED_PACKET = "RED_PACKET";
  public int extInt;
  public int extLong;
  public String extStr;
  public int extraflag;
  public String frienduin;
  public boolean isValid = true;
  public boolean isread;
  public int issend;
  public int istroop;
  public int longMsgCount;
  public int longMsgId;
  public int longMsgIndex;
  @awhp
  public CharSequence mEmoRecentMsg;
  @awhp
  public String mTimeString;
  @awhp
  public String msg;
  public byte[] msgData;
  public long msgUid;
  public long msgseq;
  public int msgtype;
  @awhp
  public boolean needNotify;
  public String selfuin;
  public String sendername;
  public String senderuin;
  public long shmsgseq;
  public String subExtr;
  public String subUin;
  public long time;
  public long uniseq;
  public int unreadNum;
  public long vipBubbleID;
  
  public static SubAccountMessage clone(SubAccountMessage paramSubAccountMessage)
  {
    SubAccountMessage localSubAccountMessage = new SubAccountMessage();
    localSubAccountMessage.subUin = paramSubAccountMessage.subUin;
    localSubAccountMessage.selfuin = paramSubAccountMessage.selfuin;
    localSubAccountMessage.frienduin = paramSubAccountMessage.frienduin;
    localSubAccountMessage.sendername = paramSubAccountMessage.sendername;
    localSubAccountMessage.senderuin = paramSubAccountMessage.senderuin;
    localSubAccountMessage.time = paramSubAccountMessage.time;
    localSubAccountMessage.msgtype = paramSubAccountMessage.msgtype;
    localSubAccountMessage.msg = paramSubAccountMessage.msg;
    localSubAccountMessage.isread = paramSubAccountMessage.isread;
    localSubAccountMessage.isValid = paramSubAccountMessage.isValid;
    localSubAccountMessage.msgData = paramSubAccountMessage.msgData;
    localSubAccountMessage.extInt = paramSubAccountMessage.extInt;
    localSubAccountMessage.extLong = paramSubAccountMessage.extInt;
    localSubAccountMessage.extraflag = paramSubAccountMessage.extraflag;
    localSubAccountMessage.extStr = paramSubAccountMessage.extStr;
    localSubAccountMessage.longMsgCount = paramSubAccountMessage.longMsgCount;
    localSubAccountMessage.longMsgId = paramSubAccountMessage.longMsgId;
    localSubAccountMessage.longMsgIndex = paramSubAccountMessage.longMsgIndex;
    localSubAccountMessage.msgseq = paramSubAccountMessage.msgseq;
    localSubAccountMessage.shmsgseq = paramSubAccountMessage.shmsgseq;
    localSubAccountMessage.uniseq = paramSubAccountMessage.uniseq;
    localSubAccountMessage.unreadNum = paramSubAccountMessage.unreadNum;
    localSubAccountMessage.vipBubbleID = paramSubAccountMessage.vipBubbleID;
    localSubAccountMessage.istroop = paramSubAccountMessage.istroop;
    localSubAccountMessage.subExtr = paramSubAccountMessage.subExtr;
    return localSubAccountMessage;
  }
  
  public int compareTo(SubAccountMessage paramSubAccountMessage)
  {
    if (paramSubAccountMessage == null) {
      return 0;
    }
    return (int)(paramSubAccountMessage.time - this.time);
  }
  
  public MessageRecord convertToMessageRecord()
  {
    MessageForText localMessageForText = new MessageForText();
    localMessageForText.selfuin = this.selfuin;
    localMessageForText.frienduin = this.frienduin;
    localMessageForText.senderuin = this.senderuin;
    localMessageForText.time = this.time;
    localMessageForText.msgtype = this.msgtype;
    localMessageForText.msg = this.msg;
    localMessageForText.isread = this.isread;
    localMessageForText.isValid = this.isValid;
    localMessageForText.msgData = this.msgData;
    localMessageForText.extInt = this.extInt;
    localMessageForText.extLong = this.extInt;
    localMessageForText.extraflag = this.extraflag;
    localMessageForText.extStr = this.extStr;
    localMessageForText.longMsgCount = this.longMsgCount;
    localMessageForText.longMsgId = this.longMsgId;
    localMessageForText.longMsgIndex = this.longMsgIndex;
    localMessageForText.msgseq = this.msgseq;
    localMessageForText.shmsgseq = this.shmsgseq;
    localMessageForText.uniseq = this.uniseq;
    localMessageForText.vipBubbleID = this.vipBubbleID;
    localMessageForText.istroop = this.istroop;
    return localMessageForText;
  }
  
  public String getTableName()
  {
    return super.getTableName();
  }
  
  public void postRead()
  {
    try
    {
      this.msg = new String(this.msgData, "UTF-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  public void prewrite()
  {
    if (this.msg != null) {}
    try
    {
      this.msgData = this.msg.getBytes("UTF-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubAccountMessage");
    localStringBuilder.append(",subUin:").append(this.subUin).append(",selfUin:").append(this.selfuin).append(",friendUin:").append(this.frienduin).append(",senderUin:").append(this.senderuin).append(",senderName:").append(this.sendername).append(",time:").append(this.time).append(",isRead:").append(this.isread).append(",msgType:").append(this.msgtype).append(",subExtr:").append(this.subExtr).append(",msg:").append(bdeu.a(this.msg));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.SubAccountMessage
 * JD-Core Version:    0.7.0.1
 */