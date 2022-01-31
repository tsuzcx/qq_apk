package com.tencent.viola.core;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.SparseArray;
import com.tencent.viola.utils.ViolaLogUtils;

class AudioPlayerManager$5
  implements MediaPlayer.OnCompletionListener
{
  AudioPlayerManager$5(AudioPlayerManager paramAudioPlayerManager) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AudioPlayerManager.access$600(this.this$0).put(AudioPlayerManager.access$000(this.this$0), Integer.valueOf(0));
    paramMediaPlayer = (AudioPlayerManager.AudioManagerListener)AudioPlayerManager.access$100(this.this$0).get(AudioPlayerManager.access$000(this.this$0));
    if (paramMediaPlayer != null) {
      paramMediaPlayer.playComplete();
    }
    ViolaLogUtils.d("AudioPlayerManager", "onCompletion,data:" + AudioPlayerManager.access$500(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.core.AudioPlayerManager.5
 * JD-Core Version:    0.7.0.1
 */