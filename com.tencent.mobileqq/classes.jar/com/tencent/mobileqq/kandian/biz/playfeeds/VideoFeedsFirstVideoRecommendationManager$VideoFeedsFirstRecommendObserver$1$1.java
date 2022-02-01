package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1$1(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = VideoFeedsFirstVideoRecommendationManager.e();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UUIDToUrlCallback Callback vid=");
      localStringBuilder.append(paramVideoUrlInfo.b);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramVideoUrlInfo.a);
      localStringBuilder.append(", isH265=");
      localStringBuilder.append(paramVideoUrlInfo.c);
      localStringBuilder.append(", isHWCodec=");
      localStringBuilder.append(paramVideoUrlInfo.d);
      localStringBuilder.append(", fileBitRate=");
      localStringBuilder.append(paramVideoUrlInfo.e);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramVideoUrlInfo.a)) && (!this.a.a(paramVideoUrlInfo.a, paramVideoUrlInfo.b))) {
      this.a.a(paramVideoUrlInfo.a, paramVideoUrlInfo.b, 0, this.b.b.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1.1
 * JD-Core Version:    0.7.0.1
 */