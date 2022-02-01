package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnMediaTimeDiscontinuityListener;
import android.media.MediaTimestamp;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;

class b$j
  implements MediaPlayer.OnMediaTimeDiscontinuityListener
{
  b$j(b paramb) {}
  
  public void onMediaTimeDiscontinuity(MediaPlayer paramMediaPlayer, MediaTimestamp paramMediaTimestamp)
  {
    if ((this.a.getStateChangeListener() != null) && (!this.a.isPaused())) {
      this.a.getStateChangeListener().onWaiting();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.b.j
 * JD-Core Version:    0.7.0.1
 */