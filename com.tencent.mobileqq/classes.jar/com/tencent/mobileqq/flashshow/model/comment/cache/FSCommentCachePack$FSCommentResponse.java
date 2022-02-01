package com.tencent.mobileqq.flashshow.model.comment.cache;

import feedcloud.FeedCloudCommon.StCommonExt;

public class FSCommentCachePack$FSCommentResponse
{
  private boolean a;
  private FeedCloudCommon.StCommonExt b;
  private String c;
  private boolean d;
  
  public static FSCommentResponse a()
  {
    return new FSCommentResponse();
  }
  
  public FSCommentResponse a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public FSCommentResponse a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }
  
  public FSCommentResponse b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSCommentResponse{mHasMore=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mCommonExt=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mFeedAttachInfo='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mHasResponse=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.comment.cache.FSCommentCachePack.FSCommentResponse
 * JD-Core Version:    0.7.0.1
 */