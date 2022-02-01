package com.tencent.mobileqq.intervideo.audioroom.player;

public abstract interface IQQVoiceRtmpPlayer
{
  public abstract void init();
  
  public abstract boolean isDestroy();
  
  public abstract boolean isPlayerReady();
  
  public abstract boolean isPlaying();
  
  public abstract void play(String paramString);
  
  public abstract void release();
  
  public abstract void setPlayAudioListener(IQQVoiceAudioListener paramIQQVoiceAudioListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.player.IQQVoiceRtmpPlayer
 * JD-Core Version:    0.7.0.1
 */