package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;

public class FSDeleteCommentEvent
  extends SimpleBaseEvent
{
  public boolean isRequestSuccess;
  public FeedCloudMeta.StComment mComment;
  public String mErrMsg;
  public FeedCloudMeta.StFeed mFeed;
  
  public FSDeleteCommentEvent(FeedCloudMeta.StComment paramStComment)
  {
    this.mComment = paramStComment;
  }
  
  public FSDeleteCommentEvent setErrMsg(String paramString)
  {
    this.mErrMsg = paramString;
    return this;
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mFeed = paramStFeed;
  }
  
  public FSDeleteCommentEvent setRequestSuccess(boolean paramBoolean)
  {
    this.isRequestSuccess = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSDeleteCommentEvent
 * JD-Core Version:    0.7.0.1
 */