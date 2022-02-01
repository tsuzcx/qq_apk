package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

public abstract interface IAudioPlayerProxy
{
  public abstract boolean isPaused();
  
  public abstract void onAudioCompletion(IAudioPlayer paramIAudioPlayer);
  
  public abstract boolean onAudioError(IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2);
  
  public abstract boolean onAudioInfo(IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2);
  
  public abstract void onAudioPrepared(IAudioPlayer paramIAudioPlayer);
  
  public abstract void onAudioProgressChanged(IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2);
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void reset();
  
  public abstract void setOnCompletionListener(AudioListeners.OnPlayCompletionListener paramOnPlayCompletionListener);
  
  public abstract void setOnErrorListener(AudioListeners.OnPlayErrorListener paramOnPlayErrorListener);
  
  public abstract void setOnInfoListener(AudioListeners.OnPlayInfoListener paramOnPlayInfoListener);
  
  public abstract void setOnPreparedListener(AudioListeners.OnPlayPreparedListener paramOnPlayPreparedListener);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
 * JD-Core Version:    0.7.0.1
 */