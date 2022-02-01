package com.tencent.mobileqq.flashshow.model.comment.bean;

import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class FSLoadCommentListBean
{
  private int a;
  private FeedCloudMeta.StFeed b;
  private boolean c;
  private QQCircleFeedBase.StBusiInfoCommentListData d;
  
  public static FSLoadCommentListBean a()
  {
    return new FSLoadCommentListBean();
  }
  
  public FSLoadCommentListBean a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.b = paramStFeed;
    return this;
  }
  
  public FSLoadCommentListBean a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public void a(QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData)
  {
    this.d = paramStBusiInfoCommentListData;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public FeedCloudMeta.StFeed c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public QQCircleFeedBase.StBusiInfoCommentListData e()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSLoadCommentListBean{mContextHashCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mFeed=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isLoadMore=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.comment.bean.FSLoadCommentListBean
 * JD-Core Version:    0.7.0.1
 */