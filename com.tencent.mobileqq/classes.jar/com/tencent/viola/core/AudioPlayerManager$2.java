package com.tencent.viola.core;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.util.SparseArray;
import com.tencent.viola.utils.ViolaLogUtils;

class AudioPlayerManager$2
  implements MediaPlayer.OnBufferingUpdateListener
{
  AudioPlayerManager$2(AudioPlayerManager paramAudioPlayerManager) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if (paramInt != 100)
    {
      paramMediaPlayer = (AudioPlayerManager.AudioManagerListener)AudioPlayerManager.access$100(this.this$0).get(AudioPlayerManager.access$000(this.this$0));
      if (paramMediaPlayer != null) {
        paramMediaPlayer.playBuffering();
      }
    }
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("onBufferingUpdate,data:");
    paramMediaPlayer.append(AudioPlayerManager.access$500(this.this$0));
    paramMediaPlayer.append(",percent:");
    paramMediaPlayer.append(paramInt);
    ViolaLogUtils.d("AudioPlayerManager", paramMediaPlayer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.AudioPlayerManager.2
 * JD-Core Version:    0.7.0.1
 */