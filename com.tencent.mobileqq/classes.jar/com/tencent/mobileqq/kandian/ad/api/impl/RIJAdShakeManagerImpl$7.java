package com.tencent.mobileqq.kandian.ad.api.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class RIJAdShakeManagerImpl$7
  implements MediaPlayer.OnCompletionListener
{
  RIJAdShakeManagerImpl$7(RIJAdShakeManagerImpl paramRIJAdShakeManagerImpl) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    RIJAdShakeManagerImpl.access$2700(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdShakeManagerImpl.7
 * JD-Core Version:    0.7.0.1
 */