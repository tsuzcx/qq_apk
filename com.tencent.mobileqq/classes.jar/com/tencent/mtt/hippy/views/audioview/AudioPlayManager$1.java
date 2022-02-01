package com.tencent.mtt.hippy.views.audioview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.util.SparseArray;

class AudioPlayManager$1
  implements MediaPlayer.OnBufferingUpdateListener
{
  AudioPlayManager$1(AudioPlayManager paramAudioPlayManager) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if (paramInt == 100) {
      return;
    }
    paramMediaPlayer = (AudioPlayManager.AudioManagerListener)AudioPlayManager.access$100(this.this$0).get(AudioPlayManager.access$000(this.this$0));
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onPlayBuffering(AudioPlayManager.access$200(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioPlayManager.1
 * JD-Core Version:    0.7.0.1
 */