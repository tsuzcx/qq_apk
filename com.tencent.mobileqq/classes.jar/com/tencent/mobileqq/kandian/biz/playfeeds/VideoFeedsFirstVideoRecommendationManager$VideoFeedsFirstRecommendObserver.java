package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.EntranceDownloadInfo;
import java.lang.ref.WeakReference;
import java.util.List;

class VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver
  extends VideoPlayRecommendObserver
{
  private WeakReference<VideoFeedsFirstVideoRecommendationManager> a;
  
  public VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver(VideoFeedsFirstVideoRecommendationManager paramVideoFeedsFirstVideoRecommendationManager)
  {
    this.a = new WeakReference(paramVideoFeedsFirstVideoRecommendationManager);
  }
  
  private void a(VideoInfo paramVideoInfo, VideoFeedsFirstVideoRecommendationManager paramVideoFeedsFirstVideoRecommendationManager)
  {
    if (paramVideoFeedsFirstVideoRecommendationManager == null) {
      return;
    }
    if (paramVideoInfo != null) {
      ThreadManager.post(new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1(this, paramVideoFeedsFirstVideoRecommendationManager, paramVideoInfo), 5, null, true);
    }
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("is_from_first_recommend_video");
    VideoFeedsFirstVideoRecommendationManager localVideoFeedsFirstVideoRecommendationManager = (VideoFeedsFirstVideoRecommendationManager)this.a.get();
    if (localVideoFeedsFirstVideoRecommendationManager == null) {
      return;
    }
    if (bool)
    {
      Object localObject1 = (VideoInfo.EntranceDownloadInfo)paramBundle.getParcelable("value_entrance_download_info");
      if (localObject1 != null)
      {
        VideoFeedsFirstVideoRecommendationManager.a(localVideoFeedsFirstVideoRecommendationManager, (VideoInfo.EntranceDownloadInfo)localObject1);
        return;
      }
      VideoFeedsFirstVideoRecommendationManager.a(localVideoFeedsFirstVideoRecommendationManager, paramBundle.getString("VALUE_COOKIE"));
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramBoolean)
      {
        paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
        localObject1 = localObject2;
        if (paramBundle != null)
        {
          localObject1 = localObject2;
          if (paramBundle.size() > 0)
          {
            localObject1 = (VideoInfo)paramBundle.get(0);
            VideoFeedsFirstVideoRecommendationManager.a(localVideoFeedsFirstVideoRecommendationManager, (VideoInfo)localObject1);
          }
        }
      }
      a((VideoInfo)localObject1, localVideoFeedsFirstVideoRecommendationManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver
 * JD-Core Version:    0.7.0.1
 */