package com.tencent.mobileqq.flashshow.request.comment;

import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;

public class FSWriteCommentLikeRequest$FSWriteLikeCommentRequestBuilder
{
  private FeedCloudMeta.StFeed a;
  private int b;
  private FeedCloudMeta.StLike c;
  private FeedCloudMeta.StComment d;
  private FeedCloudMeta.StReply e;
  private boolean f;
  
  public static FSWriteLikeCommentRequestBuilder a()
  {
    return new FSWriteLikeCommentRequestBuilder();
  }
  
  public FSWriteLikeCommentRequestBuilder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public FSWriteLikeCommentRequestBuilder a(FeedCloudMeta.StComment paramStComment)
  {
    this.d = paramStComment;
    return this;
  }
  
  public FSWriteLikeCommentRequestBuilder a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.a = paramStFeed;
    return this;
  }
  
  public FSWriteLikeCommentRequestBuilder a(FeedCloudMeta.StLike paramStLike)
  {
    this.c = paramStLike;
    return this;
  }
  
  public FSWriteLikeCommentRequestBuilder a(FeedCloudMeta.StReply paramStReply)
  {
    this.e = paramStReply;
    return this;
  }
  
  public FSWriteLikeCommentRequestBuilder a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public FeedCloudMeta.StFeed b()
  {
    return this.a;
  }
  
  public FeedCloudMeta.StLike c()
  {
    return this.c;
  }
  
  public FeedCloudMeta.StComment d()
  {
    return this.d;
  }
  
  public FeedCloudMeta.StReply e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.comment.FSWriteCommentLikeRequest.FSWriteLikeCommentRequestBuilder
 * JD-Core Version:    0.7.0.1
 */