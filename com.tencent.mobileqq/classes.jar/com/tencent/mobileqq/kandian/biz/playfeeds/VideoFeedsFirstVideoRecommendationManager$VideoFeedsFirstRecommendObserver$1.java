package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;

class VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1
  implements Runnable
{
  VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver paramVideoFeedsFirstRecommendObserver, VideoFeedsFirstVideoRecommendationManager paramVideoFeedsFirstVideoRecommendationManager, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsFirstVideoRecommendationManager.a(this.a);
    if (localVideoPreDownloadMgr != null) {
      if (this.b.a == 1)
      {
        if (!localVideoPreDownloadMgr.a(null, this.b.b)) {
          localVideoPreDownloadMgr.a(null, this.b.b, 0, this.b.e);
        }
      }
      else if (this.b.a == 2) {
        ThirdVideoManager.a().a(this.b.b, new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1.1(this, localVideoPreDownloadMgr));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1
 * JD-Core Version:    0.7.0.1
 */