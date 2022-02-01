package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class a$6
  implements MediaPlayer.OnCompletionListener
{
  a$6(a parama, MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a.d(this.b).onCompletion(paramMediaPlayer);
    this.a.onCompletion(paramMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.a.6
 * JD-Core Version:    0.7.0.1
 */