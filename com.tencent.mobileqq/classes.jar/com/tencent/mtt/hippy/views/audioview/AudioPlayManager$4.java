package com.tencent.mtt.hippy.views.audioview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.SparseArray;

class AudioPlayManager$4
  implements MediaPlayer.OnCompletionListener
{
  AudioPlayManager$4(AudioPlayManager paramAudioPlayManager) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AudioPlayManager.access$300(this.this$0).put(AudioPlayManager.access$000(this.this$0), Integer.valueOf(0));
    paramMediaPlayer = (AudioPlayManager.AudioManagerListener)AudioPlayManager.access$100(this.this$0).get(AudioPlayManager.access$000(this.this$0));
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onPlayComplete(AudioPlayManager.access$200(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioPlayManager.4
 * JD-Core Version:    0.7.0.1
 */