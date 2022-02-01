package com.tencent.viola.core;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.util.SparseArray;
import com.tencent.viola.utils.ViolaLogUtils;

class AudioPlayerManager$4
  implements MediaPlayer.OnErrorListener
{
  AudioPlayerManager$4(AudioPlayerManager paramAudioPlayerManager) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (AudioPlayerManager.AudioManagerListener)AudioPlayerManager.access$100(this.this$0).get(AudioPlayerManager.access$000(this.this$0));
    if (paramMediaPlayer != null) {
      paramMediaPlayer.playError(paramInt1, paramInt2);
    }
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("playError,data:");
    paramMediaPlayer.append(AudioPlayerManager.access$500(this.this$0));
    paramMediaPlayer.append(",what:");
    paramMediaPlayer.append(paramInt1);
    paramMediaPlayer.append(",extra:");
    paramMediaPlayer.append(paramInt2);
    ViolaLogUtils.e("AudioPlayerManager", paramMediaPlayer.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.AudioPlayerManager.4
 * JD-Core Version:    0.7.0.1
 */