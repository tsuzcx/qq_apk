package com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean;

import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

public class BarrageHolderParam
{
  private FeedCloudMeta.StComment a;
  private FeedCloudMeta.StReply b;
  private String c;
  
  public BarrageHolderParam a(FeedCloudMeta.StComment paramStComment)
  {
    this.a = paramStComment;
    return this;
  }
  
  public BarrageHolderParam a(FeedCloudMeta.StReply paramStReply)
  {
    this.b = paramStReply;
    return this;
  }
  
  public BarrageHolderParam a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public FeedCloudMeta.StComment a()
  {
    return this.a;
  }
  
  public FeedCloudMeta.StReply b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean.BarrageHolderParam
 * JD-Core Version:    0.7.0.1
 */