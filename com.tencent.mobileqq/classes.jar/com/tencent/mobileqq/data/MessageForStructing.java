package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.app.fms.MessageSearchUtils;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

public class MessageForStructing
  extends MessageForRichText
{
  @notColumn
  public boolean bDynicMsg = false;
  public AbsStructMsg structingMsg;
  
  public MessageForStructing() {}
  
  public MessageForStructing(MessageRecord paramMessageRecord)
  {
    copyStructingMsg(paramMessageRecord);
    this.uniseq = paramMessageRecord.uniseq;
  }
  
  public static String getReplySummary(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    if ((paramChatMessage instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
      AbsStructMsg localAbsStructMsg = localMessageForStructing.structingMsg;
      if ((localAbsStructMsg instanceof StructMsgForGeneralShare)) {
        if (localAbsStructMsg.mMsgServiceID == 95)
        {
          localStringBuilder.append("[在线文档]");
          localStringBuilder.append(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentTitle);
        }
        else if (localMessageForStructing.structingMsg.mMsgServiceID == 33)
        {
          localStringBuilder.append("[链接]");
          localStringBuilder.append(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentTitle);
        }
      }
    }
    if (localStringBuilder.length() == 0) {
      localStringBuilder.append(paramChatMessage.getSummaryMsg());
    }
    return localStringBuilder.toString();
  }
  
  public void copyStructingMsg(MessageRecord paramMessageRecord)
  {
    this.extInt = paramMessageRecord.extInt;
    this.extLong = paramMessageRecord.extLong;
    this.extraflag = paramMessageRecord.extraflag;
    this.extStr = paramMessageRecord.extStr;
    this.frienduin = paramMessageRecord.frienduin;
    this.isread = paramMessageRecord.isread;
    this.issend = paramMessageRecord.issend;
    this.istroop = paramMessageRecord.istroop;
    this.isValid = paramMessageRecord.isValid;
    this.longMsgCount = paramMessageRecord.longMsgCount;
    this.longMsgId = paramMessageRecord.longMsgId;
    this.longMsgIndex = paramMessageRecord.longMsgIndex;
    this.msg = paramMessageRecord.msg;
    this.msgData = paramMessageRecord.msgData;
    this.msgseq = paramMessageRecord.msgseq;
    this.msgtype = paramMessageRecord.msgtype;
    this.msgUid = paramMessageRecord.msgUid;
    this.selfuin = paramMessageRecord.selfuin;
    this.senderuin = paramMessageRecord.senderuin;
    this.sendFailCode = paramMessageRecord.sendFailCode;
    this.shmsgseq = paramMessageRecord.shmsgseq;
    this.time = paramMessageRecord.time;
    this.versionCode = paramMessageRecord.versionCode;
    this.vipBubbleID = paramMessageRecord.vipBubbleID;
    this.structingMsg = StructMsgFactory.a(this.msgData);
  }
  
  protected void doParse()
  {
    if (!this.bDynicMsg) {
      this.structingMsg = StructMsgFactory.a(this.msgData);
    }
  }
  
  public void doPrewrite()
  {
    prewrite();
  }
  
  public String getContentForSearch()
  {
    Object localObject = this.structingMsg;
    if (localObject != null)
    {
      boolean bool = MessageSearchUtils.a(String.valueOf(((AbsStructMsg)localObject).mMsgServiceID));
      localObject = this.structingMsg;
      if (((localObject instanceof AbsShareMsg)) && (bool))
      {
        String str = ((AbsShareMsg)localObject).mContentTitle;
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          return localObject;
        }
        AbsStructMsg localAbsStructMsg = this.structingMsg;
        localObject = str;
        if (!(localAbsStructMsg instanceof AbsStructMsg)) {
          return localObject;
        }
        return ((AbsShareMsg)localAbsStructMsg).mMsgBrief;
      }
    }
    localObject = null;
    return localObject;
  }
  
  public String getSummaryMsg()
  {
    AbsStructMsg localAbsStructMsg = this.structingMsg;
    String str2 = "";
    String str1 = str2;
    if (localAbsStructMsg != null)
    {
      str1 = str2;
      if (localAbsStructMsg.mMsgBrief != null) {
        str1 = this.structingMsg.mMsgBrief;
      }
    }
    return str1;
  }
  
  public boolean isHotPicsStruct()
  {
    boolean bool3 = StructMsgForImageShare.class.isInstance(this.structingMsg);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((StructMsgForImageShare)this.structingMsg).mImageBizType == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.m(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    AbsStructMsg localAbsStructMsg = this.structingMsg;
    if (localAbsStructMsg != null) {
      try
      {
        if (!this.bDynicMsg)
        {
          this.msgData = localAbsStructMsg.getBytes();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForStructing
 * JD-Core Version:    0.7.0.1
 */