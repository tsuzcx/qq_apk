package com.tencent.mobileqq.flashshow.model.comment.bean;

import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

public class FSAddCommentReplyBean
{
  private int a;
  private FeedCloudMeta.StFeed b;
  private FeedCloudMeta.StComment c;
  private FeedCloudMeta.StReply d;
  private boolean e;
  
  public static FSAddCommentReplyBean a()
  {
    return new FSAddCommentReplyBean();
  }
  
  public FSAddCommentReplyBean a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public FSAddCommentReplyBean a(FeedCloudMeta.StComment paramStComment)
  {
    this.c = paramStComment;
    return this;
  }
  
  public FSAddCommentReplyBean a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.b = paramStFeed;
    return this;
  }
  
  public FSAddCommentReplyBean a(FeedCloudMeta.StReply paramStReply)
  {
    this.d = paramStReply;
    return this;
  }
  
  public FSAddCommentReplyBean a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public FeedCloudMeta.StFeed c()
  {
    return this.b;
  }
  
  public FeedCloudMeta.StComment d()
  {
    return this.c;
  }
  
  public FeedCloudMeta.StReply e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.comment.bean.FSAddCommentReplyBean
 * JD-Core Version:    0.7.0.1
 */