package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.qphone.base.util.QLog;

class VideoPlayManager$PlayStartVideoRunnable$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoPlayManager$PlayStartVideoRunnable$1(VideoPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
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
      QLog.d("Viola.VideoPlayManager", 2, localStringBuilder.toString());
    }
    if ((VideoPlayManager.PlayStartVideoRunnable.a(this.a) != null) && (paramVideoUrlInfo.b.equals(VideoPlayManager.PlayStartVideoRunnable.a(this.a).c.b)))
    {
      if (TextUtils.isEmpty(paramVideoUrlInfo.a))
      {
        if (VideoPlayManager.i(this.a.this$0) != null) {
          VideoPlayManager.i(this.a.this$0).a(null, 202, 107, 0, "vid2url failed, get null", null);
        }
        return;
      }
      if (paramVideoUrlInfo.m == 1)
      {
        VideoPlayManager.PlayStartVideoRunnable.c(this.a).a(paramVideoUrlInfo.b, paramVideoUrlInfo.a, 104, VideoPlayManager.PlayStartVideoRunnable.b(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).c.e, paramVideoUrlInfo.d, true, false);
        return;
      }
      VideoPlayManager.PlayStartVideoRunnable.c(this.a).a(paramVideoUrlInfo.b, paramVideoUrlInfo.a, 101, VideoPlayManager.PlayStartVideoRunnable.b(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).c.e, paramVideoUrlInfo.d, true, false);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vid2url换回来后，当前视频已经不再播放，vid:");
      localStringBuilder.append(paramVideoUrlInfo.b);
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramVideoUrlInfo.a);
      QLog.d("Viola.VideoPlayManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VideoPlayManager.PlayStartVideoRunnable.1
 * JD-Core Version:    0.7.0.1
 */