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
    if ((paramVideoInfo.q != null) && (paramVideoInfo.q.equals(this.a.q)) && (!paramVideoInfo.aq) && (paramVideoInfo.al != paramBoolean))
    {
      paramVideoInfo.al = paramBoolean;
      return true;
    }
    return false;
  }
  
  public void run()
  {
    try
    {
      boolean bool = VideoFeedsHelper.a(VideoFeedsRecommendFragment.y(this.this$0), Long.valueOf(this.a.q).longValue());
      if (VideoFeedsRecommendFragment.e(this.this$0) == null) {
        return;
      }
      VideoFeedsRecommendFragment.U(this.this$0).post(new VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.1(this, bool));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.CheckAccountFollowedRunnable
 * JD-Core Version:    0.7.0.1
 */