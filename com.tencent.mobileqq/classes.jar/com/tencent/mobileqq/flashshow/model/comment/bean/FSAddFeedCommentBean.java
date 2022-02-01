package com.tencent.mobileqq.flashshow.model.comment.bean;

import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;

public class FSAddFeedCommentBean
{
  private int a;
  private FeedCloudMeta.StFeed b;
  private FeedCloudMeta.StComment c;
  private boolean d;
  private boolean e;
  
  public static FSAddFeedCommentBean a()
  {
    return new FSAddFeedCommentBean();
  }
  
  public FSAddFeedCommentBean a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public FSAddFeedCommentBean a(FeedCloudMeta.StComment paramStComment)
  {
    this.c = paramStComment;
    return this;
  }
  
  public FSAddFeedCommentBean a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.b = paramStFeed;
    return this;
  }
  
  public FSAddFeedCommentBean a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public FSAddFeedCommentBean b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
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
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.comment.bean.FSAddFeedCommentBean
 * JD-Core Version:    0.7.0.1
 */