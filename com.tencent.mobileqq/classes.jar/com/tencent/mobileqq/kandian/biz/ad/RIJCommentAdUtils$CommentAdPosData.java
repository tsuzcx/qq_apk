package com.tencent.mobileqq.kandian.biz.ad;

import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.IReadInJoyArticleBottomVideoView;
import mqq.util.WeakReference;

public class RIJCommentAdUtils$CommentAdPosData
{
  WeakReference<IReadInJoyArticleBottomVideoView> a;
  AdvertisementInfo b;
  int c;
  
  RIJCommentAdUtils$CommentAdPosData(AdvertisementInfo paramAdvertisementInfo, int paramInt, IReadInJoyArticleBottomVideoView paramIReadInJoyArticleBottomVideoView)
  {
    this.b = paramAdvertisementInfo;
    this.c = paramInt;
    this.a = new WeakReference(paramIReadInJoyArticleBottomVideoView);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool3 = paramObject instanceof CommentAdPosData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.c == ((CommentAdPosData)paramObject).c) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    AdvertisementInfo localAdvertisementInfo = this.b;
    int i;
    if (localAdvertisementInfo != null) {
      i = localAdvertisementInfo.hashCode();
    }
    for (int j = this.c;; j = this.c)
    {
      return i + j;
      i = super.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils.CommentAdPosData
 * JD-Core Version:    0.7.0.1
 */