package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSCommentPraiseUpdateEvent
  extends SimpleBaseEvent
{
  public String errMsg;
  public boolean isRequestSuccess;
  public String mCommentId;
  public String mFeedId;
  public int mPraisedNum;
  public int mPraisedStatus;
  public String mReplyId;
  public int mType;
  
  public FSCommentPraiseUpdateEvent(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    this.mType = paramInt1;
    this.mPraisedStatus = paramInt2;
    this.mFeedId = paramString1;
    this.mCommentId = paramString2;
    this.mReplyId = paramString3;
    this.mPraisedNum = paramInt3;
  }
  
  public FSCommentPraiseUpdateEvent setErrMsg(String paramString)
  {
    this.errMsg = paramString;
    return this;
  }
  
  public FSCommentPraiseUpdateEvent setRequestSuccess(boolean paramBoolean)
  {
    this.isRequestSuccess = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSCommentPraiseUpdateEvent
 * JD-Core Version:    0.7.0.1
 */