package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.qphone.base.util.QLog;

class VideoPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private VideoPlayManager.VideoPlayParam a;
  private VideoPlayerWrapper b;
  private int c;
  
  public VideoPlayManager$PlayStartVideoRunnable(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.a = paramVideoPlayParam;
    this.b = VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam);
    this.c = paramVideoPlayParam.d;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    if ((this.a != null) && (this.b != null))
    {
      if (VideoPlayManager.h(this.this$0)) {
        return;
      }
      VideoPlayManager.a(this.this$0, true);
      if (this.a.c.a == 0)
      {
        if (TextUtils.isEmpty(this.a.c.i)) {
          return;
        }
        this.b.a("", this.a.c.i, 101, this.c, 0L, this.a.c.e);
        return;
      }
      if ((this.a.c.a != 1) && (this.a.c.a != 3) && (this.a.c.a != 7))
      {
        if ((this.a.c.a != 2) && ((this.a.c.a != 6) || (TextUtils.isEmpty(this.a.c.b))))
        {
          if (this.a.c.a == 5)
          {
            if (this.a.c.b == null) {
              return;
            }
            this.b.a("", this.a.c.b, 101, this.c, 0L, this.a.c.e, false);
            return;
          }
          if (this.a.c.a == 6)
          {
            if (TextUtils.isEmpty(this.a.c.i)) {
              return;
            }
            this.b.a("", this.a.c.i, 101, this.c, 0L, this.a.c.e);
          }
        }
        else
        {
          if (this.a.c.b == null) {
            return;
          }
          ThirdVideoManager.a().a(this.a.c.b, new VideoPlayManager.PlayStartVideoRunnable.1(this));
        }
      }
      else {
        this.b.a(this.a.c.b, 1, this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VideoPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */