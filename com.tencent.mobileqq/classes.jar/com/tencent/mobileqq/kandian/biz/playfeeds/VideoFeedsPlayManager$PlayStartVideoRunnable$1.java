package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class VideoFeedsPlayManager$PlayStartVideoRunnable$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoFeedsPlayManager$PlayStartVideoRunnable$1(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, ThirdVideoManager paramThirdVideoManager) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    Object localObject1 = (VideoPlayParam)VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.c).get();
    VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)VideoFeedsPlayManager.PlayStartVideoRunnable.b(this.c).get();
    if (paramVideoUrlInfo == null)
    {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
      return;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("UUIDToUrlCallback Callback code=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.k);
      ((StringBuilder)localObject2).append(", vid=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.b);
      ((StringBuilder)localObject2).append(", url=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.a);
      ((StringBuilder)localObject2).append(", isH265=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.c);
      ((StringBuilder)localObject2).append(", isHWCodec=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.d);
      ((StringBuilder)localObject2).append(", fileBitRate=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.e);
      ((StringBuilder)localObject2).append(", hwBackupUrl=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.h);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.c, (VideoPlayParam)localObject1, localVideoPlayerWrapper))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "sendUUIDToUrlRequest: checkVideoStatus error return");
      }
      return;
    }
    if (paramVideoUrlInfo.b.equals(((VideoPlayParam)localObject1).c.b))
    {
      if (!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.c, paramVideoUrlInfo, localVideoPlayerWrapper)) {
        return;
      }
      localObject2 = VideoFeedsPlayManager.d(this.c.this$0);
      if (localObject2 != null)
      {
        localVideoPlayerWrapper.g = ((VideoPreDownloadMgr)localObject2).a(paramVideoUrlInfo.a, paramVideoUrlInfo.b);
        ((VideoPreDownloadMgr)localObject2).a(((VideoPlayParam)localObject1).c.b, localVideoPlayerWrapper.g);
      }
      localVideoPlayerWrapper.c(false);
      if (paramVideoUrlInfo.m == 1) {
        localVideoPlayerWrapper.a(paramVideoUrlInfo.b, paramVideoUrlInfo.a, 104, this.a, 0L, ((VideoPlayParam)localObject1).c.e, paramVideoUrlInfo.d, true, ((VideoPlayParam)localObject1).i);
      } else {
        localVideoPlayerWrapper.a(paramVideoUrlInfo.b, paramVideoUrlInfo.a, 101, this.a, 0L, ((VideoPlayParam)localObject1).c.e, paramVideoUrlInfo.d, true, ((VideoPlayParam)localObject1).i, paramVideoUrlInfo.h);
      }
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.c, (VideoPlayParam)localObject1, localVideoPlayerWrapper, paramVideoUrlInfo, this.b);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("vid2url换回来后，当前视频已经不再播放，vid:");
      ((StringBuilder)localObject1).append(paramVideoUrlInfo.b);
      ((StringBuilder)localObject1).append(" url:");
      ((StringBuilder)localObject1).append(paramVideoUrlInfo.a);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.PlayStartVideoRunnable.1
 * JD-Core Version:    0.7.0.1
 */