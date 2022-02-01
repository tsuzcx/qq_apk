package com.tencent.mobileqq.flashshow.model.comment.bean;

import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;

public class FSDeleteFeedCommentBean
{
  private int a;
  private FeedCloudMeta.StFeed b;
  private FeedCloudMeta.StComment c;
  private boolean d;
  
  public static FSDeleteFeedCommentBean a()
  {
    return new FSDeleteFeedCommentBean();
  }
  
  public FSDeleteFeedCommentBean a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public FSDeleteFeedCommentBean a(FeedCloudMeta.StComment paramStComment)
  {
    this.c = paramStComment;
    return this;
  }
  
  public FSDeleteFeedCommentBean a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.b = paramStFeed;
    return this;
  }
  
  public FSDeleteFeedCommentBean a(boolean paramBoolean)
  {
    this.d = paramBoolean;
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
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.comment.bean.FSDeleteFeedCommentBean
 * JD-Core Version:    0.7.0.1
 */