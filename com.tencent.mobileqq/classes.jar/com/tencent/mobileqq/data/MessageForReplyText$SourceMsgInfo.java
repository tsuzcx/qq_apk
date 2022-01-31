package com.tencent.mobileqq.data;

import java.io.Serializable;

public class MessageForReplyText$SourceMsgInfo
  implements Serializable
{
  public static final int REPLY_TYPE_ABNORMAL = -1;
  public static final int REPLY_TYPE_NORMAL = 0;
  public static final int REPLY_TYPE_PIC_COMMENT = 2;
  public static final int REPLY_TYPE_SHARE_COMMENT = 1;
  public static final int SOURCE_SUMMARY_FLAG_CPMPLETE = 1;
  public static final int SOURCE_SUMMARY_FLAG_DIRTY = 0;
  private static final long serialVersionUID = 1L;
  public String mAnonymousNickName;
  public int mLocalAtInfoDone;
  public String mRichMsg;
  public String mRichMsg2;
  public long mSourceMsgSenderUin;
  public long mSourceMsgSeq;
  public String mSourceMsgText;
  public int mSourceMsgTime;
  public int mSourceSummaryFlag = 1;
  public int mType = 0;
  
  public MessageForReplyText$SourceMsgInfo() {}
  
  public MessageForReplyText$SourceMsgInfo(SourceMsgInfo paramSourceMsgInfo)
  {
    this.mSourceMsgSeq = paramSourceMsgInfo.mSourceMsgSeq;
    this.mSourceMsgSenderUin = paramSourceMsgInfo.mSourceMsgSenderUin;
    this.mSourceMsgText = paramSourceMsgInfo.mSourceMsgText;
    this.mSourceMsgTime = paramSourceMsgInfo.mSourceMsgTime;
    this.mAnonymousNickName = paramSourceMsgInfo.mAnonymousNickName;
    this.mSourceSummaryFlag = paramSourceMsgInfo.mSourceSummaryFlag;
    this.mType = paramSourceMsgInfo.mType;
    this.mRichMsg = paramSourceMsgInfo.mRichMsg;
    this.mRichMsg2 = paramSourceMsgInfo.mRichMsg2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo
 * JD-Core Version:    0.7.0.1
 */