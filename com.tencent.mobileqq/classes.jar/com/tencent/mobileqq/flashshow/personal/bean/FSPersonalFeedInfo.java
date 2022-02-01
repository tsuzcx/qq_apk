package com.tencent.mobileqq.flashshow.personal.bean;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;

public class FSPersonalFeedInfo
{
  private final FeedCloudMeta.StFeed a;
  private boolean b = false;
  private String c = "";
  private String d = "";
  
  public FSPersonalFeedInfo(FeedCloudMeta.StFeed paramStFeed, String paramString)
  {
    this.a = paramStFeed;
    if (paramStFeed != null)
    {
      this.b = TextUtils.equals(paramStFeed.id.get(), paramString);
      this.c = paramStFeed.id.get();
      this.d = paramStFeed.cover.picUrl.get();
    }
  }
  
  public FeedCloudMeta.StFeed a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.a.likeInfo.count.get();
  }
  
  public boolean d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (FSPersonalFeedInfo)paramObject;
      return (this.c.equals(paramObject.c)) && (this.a.commentCount.get() == paramObject.a.commentCount.get()) && (this.a.likeInfo.count.get() == paramObject.a.likeInfo.count.get()) && (this.a.likeInfo.status.get() == paramObject.a.likeInfo.status.get()) && (this.d.equals(paramObject.d)) && (this.b == paramObject.b);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.bean.FSPersonalFeedInfo
 * JD-Core Version:    0.7.0.1
 */