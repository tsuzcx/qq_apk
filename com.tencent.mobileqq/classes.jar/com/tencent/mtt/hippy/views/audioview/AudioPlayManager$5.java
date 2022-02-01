package com.tencent.mtt.hippy.views.audioview;

import android.media.MediaPlayer;
import android.os.Handler;
import android.util.SparseArray;

class AudioPlayManager$5
  implements Runnable
{
  AudioPlayManager$5(AudioPlayManager paramAudioPlayManager) {}
  
  public void run()
  {
    AudioPlayManager.AudioManagerListener localAudioManagerListener = (AudioPlayManager.AudioManagerListener)AudioPlayManager.access$100(this.this$0).get(AudioPlayManager.access$000(this.this$0));
    if ((localAudioManagerListener != null) && (AudioPlayManager.access$400(this.this$0).isPlaying()))
    {
      localAudioManagerListener.onPlayProgress(AudioPlayManager.access$200(this.this$0), AudioPlayManager.access$400(this.this$0).getCurrentPosition(), AudioPlayManager.access$400(this.this$0).getDuration());
      AudioPlayManager.access$600(this.this$0).postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioPlayManager.5
 * JD-Core Version:    0.7.0.1
 */