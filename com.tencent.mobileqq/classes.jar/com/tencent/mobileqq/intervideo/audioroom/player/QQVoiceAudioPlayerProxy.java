package com.tencent.mobileqq.intervideo.audioroom.player;

import android.support.annotation.Keep;

@Keep
public class QQVoiceAudioPlayerProxy
{
  private QQVoiceRtmpPlayer a;
  
  public void init()
  {
    this.a = new QQVoiceRtmpPlayer();
    this.a.init();
  }
  
  public boolean isDestroy()
  {
    QQVoiceRtmpPlayer localQQVoiceRtmpPlayer = this.a;
    return (localQQVoiceRtmpPlayer == null) || (localQQVoiceRtmpPlayer.isDestroy());
  }
  
  public boolean isPlayerReady()
  {
    QQVoiceRtmpPlayer localQQVoiceRtmpPlayer = this.a;
    if (localQQVoiceRtmpPlayer == null) {
      return false;
    }
    return localQQVoiceRtmpPlayer.isPlayerReady();
  }
  
  public boolean isPlaying()
  {
    QQVoiceRtmpPlayer localQQVoiceRtmpPlayer = this.a;
    if (localQQVoiceRtmpPlayer == null) {
      return false;
    }
    return localQQVoiceRtmpPlayer.isPlaying();
  }
  
  public void release()
  {
    QQVoiceRtmpPlayer localQQVoiceRtmpPlayer = this.a;
    if (localQQVoiceRtmpPlayer == null) {
      return;
    }
    localQQVoiceRtmpPlayer.release();
    this.a = null;
  }
  
  public void startPlay(String paramString, IQQVoiceAudioListener paramIQQVoiceAudioListener)
  {
    QQVoiceRtmpPlayer localQQVoiceRtmpPlayer = this.a;
    if (localQQVoiceRtmpPlayer == null) {
      return;
    }
    localQQVoiceRtmpPlayer.setPlayAudioListener(paramIQQVoiceAudioListener);
    this.a.play(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.player.QQVoiceAudioPlayerProxy
 * JD-Core Version:    0.7.0.1
 */