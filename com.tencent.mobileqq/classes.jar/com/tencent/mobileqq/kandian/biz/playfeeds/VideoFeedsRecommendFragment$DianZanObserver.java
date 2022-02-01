package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanObserver;

class VideoFeedsRecommendFragment$DianZanObserver
  extends VideoPlayDianZanObserver
{
  private VideoFeedsRecommendFragment$DianZanObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetDianZanState isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    VideoFeedsPlayActivity.a(((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      if (paramBundle == null) {
        return;
      }
      localObject = paramBundle.getString("VALUE_VIDEO_ARTICLE_ID");
      int i = paramBundle.getInt("VALUE_VIDEO_FAVORITE_STATE");
      if (localObject == null) {
        return;
      }
      paramBundle = VideoFeedsRecommendFragment.a(this.a).a((String)localObject);
      if (paramBundle != null)
      {
        if (i == 1) {
          paramBundle.q = true;
        } else if (i == 0) {
          paramBundle.q = false;
        }
        VideoFeedsRecommendFragment.a(this.a).a(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.DianZanObserver
 * JD-Core Version:    0.7.0.1
 */