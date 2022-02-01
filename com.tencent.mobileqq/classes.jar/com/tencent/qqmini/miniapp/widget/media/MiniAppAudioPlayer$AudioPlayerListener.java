package com.tencent.qqmini.miniapp.widget.media;

public abstract interface MiniAppAudioPlayer$AudioPlayerListener
{
  public abstract void onError(int paramInt1, int paramInt2);
  
  public abstract void onPlayerBufferingUpdate(int paramInt);
  
  public abstract void onPlayerProgress(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onPlayerSeek(boolean paramBoolean, int paramInt);
  
  public abstract void onPlayerStateChange(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.AudioPlayerListener
 * JD-Core Version:    0.7.0.1
 */