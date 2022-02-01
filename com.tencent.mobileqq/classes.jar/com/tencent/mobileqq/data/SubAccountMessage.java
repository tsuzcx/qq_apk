package com.tencent.mobileqq.data;

import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.util.MessageRecordUtil;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="subUin,senderuin,time")
public class SubAccountMessage
  extends Entity
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
  @notColumn
  public CharSequence mEmoRecentMsg;
  @notColumn
  public String mTimeString;
  @notColumn
  public String msg;
  public byte[] msgData;
  public long msgUid;
  public long msgseq;
  public int msgtype;
  @notColumn
  public boolean needNotify;
  public String selfuin;
  public String sendername;
  public String senderuin;
  public long shmsgseq;
  public String subExtr;
  public String subUin;
  public long time;
  public long uniseq;
  public int unreadNum = 0;
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
    Object localObject = (IMessageFacade)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "");
    String str = this.msg;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.uniseq);
    localStringBuilder.append("");
    localObject = ((IMessageFacade)localObject).constructMessageForText(str, localStringBuilder.toString(), this.frienduin, this.istroop);
    ((MessageRecord)localObject).selfuin = this.selfuin;
    ((MessageRecord)localObject).frienduin = this.frienduin;
    ((MessageRecord)localObject).senderuin = this.senderuin;
    ((MessageRecord)localObject).time = this.time;
    ((MessageRecord)localObject).msgtype = this.msgtype;
    ((MessageRecord)localObject).msg = this.msg;
    ((MessageRecord)localObject).isread = this.isread;
    ((MessageRecord)localObject).isValid = this.isValid;
    ((MessageRecord)localObject).msgData = this.msgData;
    int i = this.extInt;
    ((MessageRecord)localObject).extInt = i;
    ((MessageRecord)localObject).extLong = i;
    ((MessageRecord)localObject).extraflag = this.extraflag;
    ((MessageRecord)localObject).extStr = this.extStr;
    ((MessageRecord)localObject).longMsgCount = this.longMsgCount;
    ((MessageRecord)localObject).longMsgId = this.longMsgId;
    ((MessageRecord)localObject).longMsgIndex = this.longMsgIndex;
    ((MessageRecord)localObject).msgseq = this.msgseq;
    ((MessageRecord)localObject).shmsgseq = this.shmsgseq;
    ((MessageRecord)localObject).uniseq = this.uniseq;
    ((MessageRecord)localObject).vipBubbleID = this.vipBubbleID;
    ((MessageRecord)localObject).istroop = this.istroop;
    return localObject;
  }
  
  public String getTableName()
  {
    return super.getTableName();
  }
  
  protected void postRead()
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
  
  protected void prewrite()
  {
    String str = this.msg;
    if (str != null) {
      try
      {
        this.msgData = str.getBytes("UTF-8");
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubAccountMessage");
    localStringBuilder.append(",subUin:");
    localStringBuilder.append(this.subUin);
    localStringBuilder.append(",selfUin:");
    localStringBuilder.append(this.selfuin);
    localStringBuilder.append(",friendUin:");
    localStringBuilder.append(this.frienduin);
    localStringBuilder.append(",senderUin:");
    localStringBuilder.append(this.senderuin);
    localStringBuilder.append(",senderName:");
    localStringBuilder.append(this.sendername);
    localStringBuilder.append(",time:");
    localStringBuilder.append(this.time);
    localStringBuilder.append(",isRead:");
    localStringBuilder.append(this.isread);
    localStringBuilder.append(",msgType:");
    localStringBuilder.append(this.msgtype);
    localStringBuilder.append(",subExtr:");
    localStringBuilder.append(this.subExtr);
    localStringBuilder.append(",msg:");
    localStringBuilder.append(MessageRecordUtil.a(this.msg));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.SubAccountMessage
 * JD-Core Version:    0.7.0.1
 */