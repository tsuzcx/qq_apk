package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

public class FSAddReplyCommentEvent
  extends SimpleBaseEvent
{
  public boolean isRequestSuccess;
  public FeedCloudMeta.StComment mComment;
  public String mErrMsg;
  public FeedCloudMeta.StReply mFakeReply;
  public FeedCloudMeta.StFeed mFeed;
  public FeedCloudMeta.StReply mReply;
  
  public FSAddReplyCommentEvent(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply1, FeedCloudMeta.StReply paramStReply2)
  {
    this.mComment = paramStComment;
    this.mReply = paramStReply2;
    this.mFakeReply = paramStReply1;
  }
  
  public FSAddReplyCommentEvent setErrMsg(String paramString)
  {
    this.mErrMsg = paramString;
    return this;
  }
  
  public FSAddReplyCommentEvent setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mFeed = paramStFeed;
    return this;
  }
  
  public FSAddReplyCommentEvent setRequestSuccess(boolean paramBoolean)
  {
    this.isRequestSuccess = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSAddReplyCommentEvent
 * JD-Core Version:    0.7.0.1
 */