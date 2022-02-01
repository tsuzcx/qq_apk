package com.tencent.qqlive.module.videoreport.dtreport.audio.api;

import android.support.annotation.NonNull;

public abstract interface IAudioPlayListener
{
  public abstract void onAudioComplete(@NonNull IAudioPlayer paramIAudioPlayer);
  
  public abstract void onAudioError(@NonNull IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2);
  
  public abstract void onAudioPause(IAudioPlayer paramIAudioPlayer);
  
  public abstract void onAudioProgressChanged(@NonNull IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2);
  
  public abstract void onAudioStart(boolean paramBoolean, @NonNull IAudioPlayer paramIAudioPlayer);
  
  public abstract void onAudioStop(@NonNull IAudioPlayer paramIAudioPlayer);
  
  public abstract void onBufferingEnd(@NonNull IAudioPlayer paramIAudioPlayer);
  
  public abstract void onBufferingStart(@NonNull IAudioPlayer paramIAudioPlayer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener
 * JD-Core Version:    0.7.0.1
 */