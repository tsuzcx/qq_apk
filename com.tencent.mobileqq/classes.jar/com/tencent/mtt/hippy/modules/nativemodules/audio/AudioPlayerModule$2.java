package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class AudioPlayerModule$2
  implements MediaPlayer.OnCompletionListener
{
  AudioPlayerModule$2(AudioPlayerModule paramAudioPlayerModule) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AudioPlayerModule.a(this.a, "COMPLETED");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.AudioPlayerModule.2
 * JD-Core Version:    0.7.0.1
 */