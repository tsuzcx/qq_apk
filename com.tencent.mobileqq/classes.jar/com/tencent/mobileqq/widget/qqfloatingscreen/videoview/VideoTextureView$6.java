package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.media.MediaPlayer;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;

class VideoTextureView$6
  implements Runnable
{
  VideoTextureView$6(VideoTextureView paramVideoTextureView) {}
  
  public void run()
  {
    if (VideoTextureView.a(this.this$0) != null) {
      try
      {
        int i = VideoTextureView.a(this.this$0).getCurrentPosition();
        if (VideoTextureView.a() != null) {
          VideoTextureView.a().onVideoProgressUpdate(i);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    if (VideoTextureView.a(this.this$0) != null) {
      VideoTextureView.a(this.this$0).postDelayed(this.this$0.a, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView.6
 * JD-Core Version:    0.7.0.1
 */