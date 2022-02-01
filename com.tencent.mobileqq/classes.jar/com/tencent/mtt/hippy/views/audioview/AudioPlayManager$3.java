package com.tencent.mtt.hippy.views.audioview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.util.SparseArray;

class AudioPlayManager$3
  implements MediaPlayer.OnErrorListener
{
  AudioPlayManager$3(AudioPlayManager paramAudioPlayManager) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (AudioPlayManager.AudioManagerListener)AudioPlayManager.access$100(this.this$0).get(AudioPlayManager.access$000(this.this$0));
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onPlayError(AudioPlayManager.access$200(this.this$0), paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioPlayManager.3
 * JD-Core Version:    0.7.0.1
 */