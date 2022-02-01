package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;

class VideoTextureView$2
  implements MediaPlayer.OnPreparedListener
{
  VideoTextureView$2(VideoTextureView paramVideoTextureView) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (VideoTextureView.a(this.a) != null)
    {
      VideoTextureView.a(this.a).start();
      paramMediaPlayer = this.a;
      VideoTextureView.a(paramMediaPlayer, VideoTextureView.a(paramMediaPlayer).getDuration());
    }
    if (VideoTextureView.a() != null)
    {
      VideoTextureView.a().onVideoStart(VideoTextureView.c(this.a));
      VideoTextureView.a().onVideoProgressUpdate(0);
      VideoTextureView.a().onVideoSize(VideoTextureView.a(this.a).getVideoWidth(), VideoTextureView.a(this.a).getVideoHeight());
    }
    if (VideoTextureView.b(this.a) != null) {
      VideoTextureView.b(this.a).post(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView.2
 * JD-Core Version:    0.7.0.1
 */