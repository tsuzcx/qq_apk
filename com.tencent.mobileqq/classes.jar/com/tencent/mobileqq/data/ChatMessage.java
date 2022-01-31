package com.tencent.mobileqq.data;

import awhp;

public abstract class ChatMessage
  extends MessageRecord
{
  public static final int AIO_MARGIN_MSG_TYPE_DIFF = 1;
  public static final int AIO_MARGIN_MSG_TYPE_SAME = 0;
  public int fakeSenderType = 0;
  public boolean hasPlayedDui;
  public boolean isAioAnimChecked;
  public boolean isDui;
  public boolean isFirstMsg;
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
  @awhp
  private int mViewHeight;
  
  protected abstract void doParse();
  
  public String getSummaryMsg()
  {
    return this.msg;
  }
  
  public int getViewHeight()
  {
    return this.mViewHeight;
  }
  
  public boolean isSend()
  {
    if (this.fakeSenderType == 1) {
      return true;
    }
    if (this.fakeSenderType == 2) {
      return false;
    }
    if (this.isMultiMsg) {
      return false;
    }
    return super.isSend();
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
  
  public void setViewHeight(int paramInt)
  {
    this.mViewHeight = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ChatMessage
 * JD-Core Version:    0.7.0.1
 */