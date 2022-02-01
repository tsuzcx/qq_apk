package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class MessageForReplyText$SourceMsgInfo
  implements Serializable
{
  public static final int REPLY_TYPE_ABNORMAL = -1;
  public static final int REPLY_TYPE_NORMAL = 0;
  public static final int SOURCE_SUMMARY_FLAG_CPMPLETE = 1;
  public static final int SOURCE_SUMMARY_FLAG_DIRTY = 0;
  private static final long serialVersionUID = 1L;
  public String mAnonymousNickName;
  public String mAtInfoStr;
  public String mRichMsg;
  private byte[] mSourceMessageByte;
  public long mSourceMsgSenderUin;
  public long mSourceMsgSeq;
  public String mSourceMsgText;
  public int mSourceMsgTime;
  public long mSourceMsgToUin;
  public String mSourceMsgTroopName;
  public int mSourceSummaryFlag = 1;
  public int mType = 0;
  public int oriMsgType;
  public long origUid;
  public int replyPicHeight;
  public int replyPicWidth;
  private long uniseq = 0L;
  
  public MessageForReplyText$SourceMsgInfo() {}
  
  public MessageForReplyText$SourceMsgInfo(SourceMsgInfo paramSourceMsgInfo)
  {
    this.mSourceMsgSeq = paramSourceMsgInfo.mSourceMsgSeq;
    this.mSourceMsgSenderUin = paramSourceMsgInfo.mSourceMsgSenderUin;
    this.mSourceMsgToUin = paramSourceMsgInfo.mSourceMsgToUin;
    this.mSourceMsgText = paramSourceMsgInfo.mSourceMsgText;
    this.mSourceMsgTime = paramSourceMsgInfo.mSourceMsgTime;
    this.mAnonymousNickName = paramSourceMsgInfo.mAnonymousNickName;
    this.mSourceSummaryFlag = paramSourceMsgInfo.mSourceSummaryFlag;
    this.mType = paramSourceMsgInfo.mType;
    this.mRichMsg = paramSourceMsgInfo.mRichMsg;
    this.replyPicWidth = paramSourceMsgInfo.replyPicWidth;
    this.replyPicHeight = paramSourceMsgInfo.replyPicHeight;
    this.oriMsgType = paramSourceMsgInfo.oriMsgType;
    this.origUid = paramSourceMsgInfo.origUid;
    this.mAtInfoStr = paramSourceMsgInfo.mAtInfoStr;
    this.mSourceMsgTroopName = paramSourceMsgInfo.mSourceMsgTroopName;
    this.mSourceMessageByte = paramSourceMsgInfo.getSourceMsg();
    setUniSeq(paramSourceMsgInfo.uniseq, false);
  }
  
  public byte[] getSourceMsg()
  {
    return this.mSourceMessageByte;
  }
  
  public long getUniSeq()
  {
    return this.uniseq;
  }
  
  public void packSourceMsg(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      if ((paramMessageRecord instanceof MessageForReplyText)) {
        return;
      }
      paramQQAppInterface = MsgBackupMsgProxy.a(paramQQAppInterface, paramMessageRecord);
      if (paramQQAppInterface == null) {
        return;
      }
      setSourceMsgByte(paramQQAppInterface);
      setUniSeq(paramMessageRecord.uniseq, false);
    }
  }
  
  public void setSourceMsgByte(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SourceMsgInfo", 2, "sourcemsgbtye is replace by null");
      }
      return;
    }
    this.mSourceMessageByte = paramArrayOfByte;
  }
  
  public void setUniSeq(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uniSeq has value curUniSq=");
      localStringBuilder.append(this.uniseq);
      localStringBuilder.append(" expectSeq=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" forceToReset=");
      localStringBuilder.append(paramBoolean);
      QLog.d("SourceMsgInfo", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.uniseq = paramLong;
      return;
    }
    if (this.uniseq == 0L) {
      this.uniseq = paramLong;
    }
  }
  
  public MessageRecord unPackSourceMsg(QQAppInterface paramQQAppInterface)
  {
    byte[] arrayOfByte = this.mSourceMessageByte;
    if (arrayOfByte == null) {
      return null;
    }
    return MsgBackupMsgProxy.a(paramQQAppInterface, arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo
 * JD-Core Version:    0.7.0.1
 */