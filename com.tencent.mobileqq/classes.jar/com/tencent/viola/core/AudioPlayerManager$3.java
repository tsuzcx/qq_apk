package com.tencent.viola.core;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.SparseArray;
import com.tencent.viola.utils.ViolaLogUtils;

class AudioPlayerManager$3
  implements MediaPlayer.OnPreparedListener
{
  AudioPlayerManager$3(AudioPlayerManager paramAudioPlayerManager) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    int i = ((Integer)AudioPlayerManager.access$600(this.this$0).get(AudioPlayerManager.access$000(this.this$0), Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      AudioPlayerManager.access$300(this.this$0).start();
      paramMediaPlayer = (AudioPlayerManager.AudioManagerListener)AudioPlayerManager.access$100(this.this$0).get(AudioPlayerManager.access$000(this.this$0));
      if (paramMediaPlayer != null) {
        paramMediaPlayer.playStart();
      }
    }
    for (;;)
    {
      AudioPlayerManager.access$700(this.this$0);
      ViolaLogUtils.d("AudioPlayerManager", "onPrepared,data:" + AudioPlayerManager.access$500(this.this$0) + ",playDuration:" + i);
      return;
      AudioPlayerManager.access$300(this.this$0).seekTo(i);
      AudioPlayerManager.access$300(this.this$0).start();
      paramMediaPlayer = (AudioPlayerManager.AudioManagerListener)AudioPlayerManager.access$100(this.this$0).get(AudioPlayerManager.access$000(this.this$0));
      if (paramMediaPlayer != null) {
        paramMediaPlayer.playResume();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.AudioPlayerManager.3
 * JD-Core Version:    0.7.0.1
 */