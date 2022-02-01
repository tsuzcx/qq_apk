package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;

class VideoFeedsRecommendFragment$PlayCountObserver
  extends VideoPlayCountObserver
{
  private VideoFeedsRecommendFragment$PlayCountObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetVideoPlayCount isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    VideoFeedsPlayActivity.a(((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      if (paramBundle == null) {
        return;
      }
      localObject = paramBundle.getString("VALUE_VIDEO_VID");
      if (localObject == null) {
        return;
      }
      localObject = VideoFeedsRecommendFragment.a(this.a).b((String)localObject);
      if (localObject != null)
      {
        ((VideoInfo)localObject).q = paramBundle.getInt("VALUE_VIDEO_PLAY_COUNT");
        VideoFeedsRecommendFragment.a(this.a).a((VideoInfo)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.PlayCountObserver
 * JD-Core Version:    0.7.0.1
 */