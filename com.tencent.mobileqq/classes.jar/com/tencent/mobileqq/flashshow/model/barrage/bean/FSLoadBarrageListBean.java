package com.tencent.mobileqq.flashshow.model.barrage.bean;

import feedcloud.FeedCloudMeta.StFeed;

public class FSLoadBarrageListBean
{
  private int a;
  private int b;
  private FeedCloudMeta.StFeed c;
  private boolean d;
  
  public static FSLoadBarrageListBean a()
  {
    return new FSLoadBarrageListBean();
  }
  
  public FSLoadBarrageListBean a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public FSLoadBarrageListBean a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.c = paramStFeed;
    return this;
  }
  
  public FSLoadBarrageListBean a(boolean paramBoolean)
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
    return this.c;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSLoadBarrageListBean{mContextHashCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mFrom=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mFeed=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isLoadMore=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.barrage.bean.FSLoadBarrageListBean
 * JD-Core Version:    0.7.0.1
 */