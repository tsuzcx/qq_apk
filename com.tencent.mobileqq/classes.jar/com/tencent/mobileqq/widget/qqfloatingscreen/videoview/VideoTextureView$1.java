package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.media.MediaPlayer;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;

class VideoTextureView$1
  implements IVideoInnerStatusListener
{
  public void notifyVideoClose(int paramInt)
  {
    VideoTextureView.d(this.a);
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (VideoTextureView.a(this.a) != null)
    {
      double d1 = paramInt;
      double d2 = VideoTextureView.c(this.a);
      Double.isNaN(d1);
      Double.isNaN(d2);
      paramInt = (int)(d1 * d2 / 100.0D);
      VideoTextureView.a(this.a).seekTo(paramInt);
    }
  }
  
  public void notifyVideoStart()
  {
    if (VideoTextureView.a(this.a) != null) {
      VideoTextureView.a(this.a).start();
    }
    if (VideoTextureView.b(this.a) != null) {
      VideoTextureView.b(this.a).postDelayed(this.a.a, 1000L);
    }
  }
  
  public void notifyVideoStop()
  {
    if (VideoTextureView.a(this.a) != null) {
      VideoTextureView.a(this.a).pause();
    }
    if (VideoTextureView.b(this.a) != null) {
      VideoTextureView.b(this.a).removeCallbacks(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView.1
 * JD-Core Version:    0.7.0.1
 */