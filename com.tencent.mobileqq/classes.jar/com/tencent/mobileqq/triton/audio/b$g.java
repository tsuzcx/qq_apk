package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;

class b$g
  implements MediaPlayer.OnSeekCompleteListener
{
  b$g(b paramb) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (this.a.getStateChangeListener() != null) {
      this.a.getStateChangeListener().onSeeked();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.b.g
 * JD-Core Version:    0.7.0.1
 */