package com.tencent.mobileqq.data;

public abstract class ChatMessage
  extends MessageRecord
{
  public boolean hasPlayedDui;
  public boolean isAioAnimChecked;
  public boolean isDui;
  public boolean isFlowMessage;
  public boolean isShowQIMStyleGroup;
  public boolean isShowQimStyleAvater;
  public boolean isShowTIMStyleGroup;
  public boolean isShowTimStyleAvater;
  public boolean mAnimFlag = true;
  public boolean mIsParsed;
  private boolean mIsSentByXG;
  @Deprecated
  public CharSequence mMessageSource;
  public boolean mMsgAnimFlag;
  public long mMsgAnimTime;
  @Deprecated
  public boolean mNeedGrayTips;
  public boolean mNeedTimeStamp;
  public boolean mPendantAnimatable;
  
  public abstract void doParse();
  
  public String getSummaryMsg()
  {
    return this.msg;
  }
  
  public boolean isSentByXG()
  {
    return this.mIsSentByXG;
  }
  
  public boolean isSupportReply()
  {
    return false;
  }
  
  public void parse()
  {
    if (!this.mIsParsed) {
      try
      {
        if (!this.mIsParsed)
        {
          doParse();
          this.mIsParsed = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public void reParse()
  {
    if (!this.mIsParsed) {
      return;
    }
    this.mIsParsed = false;
    parse();
  }
  
  public void setIsSentByXG(boolean paramBoolean)
  {
    this.mIsSentByXG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ChatMessage
 * JD-Core Version:    0.7.0.1
 */