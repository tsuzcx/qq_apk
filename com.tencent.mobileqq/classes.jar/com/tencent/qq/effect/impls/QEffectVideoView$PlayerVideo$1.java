package com.tencent.qq.effect.impls;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class QEffectVideoView$PlayerVideo$1
  implements MediaPlayer.OnPreparedListener
{
  QEffectVideoView$PlayerVideo$1(QEffectVideoView.PlayerVideo paramPlayerVideo) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QEffectVideoView.access$200(this.this$1.this$0).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qq.effect.impls.QEffectVideoView.PlayerVideo.1
 * JD-Core Version:    0.7.0.1
 */