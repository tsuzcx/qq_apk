package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.OnCallback;

class VideoFeedsRecommendFragment$AricleObserver
  extends IPublicAccountArticleObserver.OnCallback
{
  private VideoFeedsRecommendFragment$AricleObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSendArticleLikeReq isSuccess=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", articleID=");
    localStringBuilder.append(paramString);
    VideoFeedsPlayActivity.a(localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.AricleObserver
 * JD-Core Version:    0.7.0.1
 */