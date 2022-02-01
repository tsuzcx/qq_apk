package com.tencent.mobileqq.qqexpand.audio;

import android.support.annotation.UiThread;

public abstract interface IAudioPlayerStatusListener
{
  @UiThread
  public abstract void onAudioFinishPlay(String paramString);
  
  @UiThread
  public abstract void onAudioPlayFailed(String paramString1, int paramInt, String paramString2);
  
  @UiThread
  public abstract void onAudioStartPlay(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.audio.IAudioPlayerStatusListener
 * JD-Core Version:    0.7.0.1
 */