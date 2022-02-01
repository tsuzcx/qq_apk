package com.tencent.mtt.hippy.views.audioview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.SparseArray;

class AudioPlayManager$2
  implements MediaPlayer.OnPreparedListener
{
  AudioPlayManager$2(AudioPlayManager paramAudioPlayManager) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    int i = ((Integer)AudioPlayManager.access$300(this.this$0).get(AudioPlayManager.access$000(this.this$0), Integer.valueOf(0))).intValue();
    paramMediaPlayer = (AudioPlayManager.AudioManagerListener)AudioPlayManager.access$100(this.this$0).get(AudioPlayManager.access$000(this.this$0));
    AudioPlayManager.access$400(this.this$0).seekTo(i);
    AudioPlayManager.access$400(this.this$0).start();
    if (paramMediaPlayer != null)
    {
      if (i != 0) {
        break label99;
      }
      paramMediaPlayer.onPlayStart(AudioPlayManager.access$200(this.this$0));
    }
    for (;;)
    {
      AudioPlayManager.access$500(this.this$0);
      return;
      label99:
      paramMediaPlayer.onPlayResume(AudioPlayManager.access$200(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioPlayManager.2
 * JD-Core Version:    0.7.0.1
 */