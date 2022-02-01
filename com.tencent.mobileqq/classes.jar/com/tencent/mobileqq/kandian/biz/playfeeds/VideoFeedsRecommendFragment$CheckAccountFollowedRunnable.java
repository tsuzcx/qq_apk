package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;

class VideoFeedsRecommendFragment$CheckAccountFollowedRunnable
  implements Runnable
{
  private VideoInfo a;
  
  public VideoFeedsRecommendFragment$CheckAccountFollowedRunnable(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, VideoInfo paramVideoInfo)
  {
    this.a = paramVideoInfo;
  }
  
  private boolean a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramVideoInfo.j != null) && (paramVideoInfo.j.equals(this.a.j)) && (!paramVideoInfo.r) && (paramVideoInfo.p != paramBoolean))
    {
      paramVideoInfo.p = paramBoolean;
      return true;
    }
    return false;
  }
  
  public void run()
  {
    try
    {
      boolean bool = VideoFeedsHelper.a(VideoFeedsRecommendFragment.a(this.this$0), Long.valueOf(this.a.j).longValue());
      if (VideoFeedsRecommendFragment.a(this.this$0) == null) {
        return;
      }
      VideoFeedsRecommendFragment.a(this.this$0).post(new VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.1(this, bool));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.CheckAccountFollowedRunnable
 * JD-Core Version:    0.7.0.1
 */