package com.tencent.mobileqq.flashshow.bean;

import feedcloud.FeedCloudMeta.StReply;

public class FSReplyItemInfo
{
  public int a;
  public FeedCloudMeta.StReply b;
  public int c;
  
  public FSReplyItemInfo(int paramInt, FeedCloudMeta.StReply paramStReply)
  {
    this.a = paramInt;
    this.b = paramStReply;
  }
  
  public FSReplyItemInfo(int paramInt1, FeedCloudMeta.StReply paramStReply, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramStReply;
    this.c = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.bean.FSReplyItemInfo
 * JD-Core Version:    0.7.0.1
 */