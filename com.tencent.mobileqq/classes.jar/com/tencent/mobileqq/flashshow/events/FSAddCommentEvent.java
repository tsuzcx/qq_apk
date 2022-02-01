package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;

public class FSAddCommentEvent
  extends SimpleBaseEvent
{
  public boolean isRequestSuccess;
  public FeedCloudMeta.StComment mComment;
  public String mErrMsg;
  public FeedCloudMeta.StComment mFakeComment;
  public FeedCloudMeta.StFeed mFeed;
  
  public FSAddCommentEvent(FeedCloudMeta.StComment paramStComment1, FeedCloudMeta.StComment paramStComment2)
  {
    this.mFakeComment = paramStComment1;
    this.mComment = paramStComment2;
  }
  
  public FSAddCommentEvent setErrMsg(String paramString)
  {
    this.mErrMsg = paramString;
    return this;
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mFeed = paramStFeed;
  }
  
  public FSAddCommentEvent setRequestSuccess(boolean paramBoolean)
  {
    this.isRequestSuccess = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSAddCommentEvent
 * JD-Core Version:    0.7.0.1
 */