package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

class MediaPlayerProxy
  extends BaseAudioPlayerProxy
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener
{
  MediaPlayerProxy(IAudioPlayer paramIAudioPlayer)
  {
    super(paramIAudioPlayer);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    onAudioCompletion(this.mAudioPlayer);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return onAudioError(this.mAudioPlayer, paramInt1, paramInt2);
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return onAudioInfo(this.mAudioPlayer, paramInt1, paramInt2);
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    onAudioPrepared(this.mAudioPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.MediaPlayerProxy
 * JD-Core Version:    0.7.0.1
 */