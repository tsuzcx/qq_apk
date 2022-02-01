package com.tencent.mobileqq.vipav;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.VideoView;

final class VipFunCallManager$3
  implements MediaPlayer.OnCompletionListener
{
  VipFunCallManager$3(VideoView paramVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallManager.3
 * JD-Core Version:    0.7.0.1
 */