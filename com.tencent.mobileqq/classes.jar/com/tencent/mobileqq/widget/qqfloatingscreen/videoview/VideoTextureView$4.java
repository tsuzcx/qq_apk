package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;

class VideoTextureView$4
  implements MediaPlayer.OnSeekCompleteListener
{
  VideoTextureView$4(VideoTextureView paramVideoTextureView) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (VideoTextureView.a() != null) {
      VideoTextureView.a().onVideoStart(VideoTextureView.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView.4
 * JD-Core Version:    0.7.0.1
 */