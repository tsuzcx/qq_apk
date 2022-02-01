package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;

class VideoTextureView$3
  implements MediaPlayer.OnCompletionListener
{
  VideoTextureView$3(VideoTextureView paramVideoTextureView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (VideoTextureView.a() != null) {
      VideoTextureView.a().onVideoComplete(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView.3
 * JD-Core Version:    0.7.0.1
 */