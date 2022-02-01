package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

public class ReportMediaPlayer
  extends MediaPlayer
  implements IAudioPlayer
{
  private MediaPlayerProxy mAudioProxy = new MediaPlayerProxy(this);
  
  public ReportMediaPlayer()
  {
    super.setOnPreparedListener(this.mAudioProxy);
    super.setOnCompletionListener(this.mAudioProxy);
    super.setOnErrorListener(this.mAudioProxy);
    super.setOnInfoListener(this.mAudioProxy);
  }
  
  public final int getCurrentPosition__()
  {
    return getCurrentPosition();
  }
  
  public final int getDuration__()
  {
    return getDuration();
  }
  
  public final String getPlayerId__()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaPlayer_");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
  
  public final int getPlayerType__()
  {
    return 100;
  }
  
  public final boolean isAudioPlayer__()
  {
    return true;
  }
  
  public void pause()
  {
    super.pause();
    this.mAudioProxy.pause();
  }
  
  public void prepare()
  {
    this.mAudioProxy.prepare();
    super.prepare();
  }
  
  public void prepareAsync()
  {
    this.mAudioProxy.prepare();
    super.prepareAsync();
  }
  
  public void reset()
  {
    super.reset();
    this.mAudioProxy.reset();
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mAudioProxy.setOnCompletionListener(new ReportMediaPlayer.2(this, paramOnCompletionListener));
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mAudioProxy.setOnErrorListener(new ReportMediaPlayer.3(this, paramOnErrorListener));
  }
  
  public void setOnInfoListener(MediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mAudioProxy.setOnInfoListener(new ReportMediaPlayer.4(this, paramOnInfoListener));
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.mAudioProxy.setOnPreparedListener(new ReportMediaPlayer.1(this, paramOnPreparedListener));
  }
  
  public void start()
  {
    super.start();
    this.mAudioProxy.start();
  }
  
  public void stop()
  {
    this.mAudioProxy.stop();
    super.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer
 * JD-Core Version:    0.7.0.1
 */