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
    return (this.a == null) || (this.a.isDestroy());
  }
  
  public boolean isPlayerReady()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.isPlayerReady();
  }
  
  public boolean isPlaying()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.isPlaying();
  }
  
  public void release()
  {
    if (this.a == null) {
      return;
    }
    this.a.release();
    this.a = null;
  }
  
  public void startPlay(String paramString, IQQVoiceAudioListener paramIQQVoiceAudioListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.setPlayAudioListener(paramIQQVoiceAudioListener);
    this.a.play(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.player.QQVoiceAudioPlayerProxy
 * JD-Core Version:    0.7.0.1
 */