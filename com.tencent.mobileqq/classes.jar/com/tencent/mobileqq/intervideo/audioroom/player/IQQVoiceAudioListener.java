package com.tencent.mobileqq.intervideo.audioroom.player;

import android.support.annotation.Keep;

@Keep
public abstract interface IQQVoiceAudioListener
{
  public abstract void onAudioFirstFrame();
  
  public abstract void onCompletion();
  
  public abstract boolean onError(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract boolean onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.player.IQQVoiceAudioListener
 * JD-Core Version:    0.7.0.1
 */