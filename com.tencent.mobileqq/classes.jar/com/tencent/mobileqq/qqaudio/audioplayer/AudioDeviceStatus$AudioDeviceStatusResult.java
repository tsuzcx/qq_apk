package com.tencent.mobileqq.qqaudio.audioplayer;

public class AudioDeviceStatus$AudioDeviceStatusResult
{
  int a;
  AudioPlayerHelper.AudioPlayerParameter b;
  volatile boolean c;
  
  public AudioDeviceStatus$AudioDeviceStatusResult(AudioPlayerHelper.AudioPlayerParameter paramAudioPlayerParameter, int paramInt)
  {
    this(paramAudioPlayerParameter, paramInt, false);
  }
  
  public AudioDeviceStatus$AudioDeviceStatusResult(AudioPlayerHelper.AudioPlayerParameter paramAudioPlayerParameter, int paramInt, boolean paramBoolean)
  {
    this.b = paramAudioPlayerParameter;
    this.c = paramBoolean;
    this.a = paramInt;
  }
  
  public AudioPlayerHelper.AudioPlayerParameter a()
  {
    return this.b;
  }
  
  public boolean a(AudioDeviceStatusResult paramAudioDeviceStatusResult)
  {
    if (paramAudioDeviceStatusResult != null)
    {
      AudioPlayerHelper.AudioPlayerParameter localAudioPlayerParameter = this.b;
      if (localAudioPlayerParameter != null) {
        return localAudioPlayerParameter.equals(paramAudioDeviceStatusResult.b);
      }
    }
    return false;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void d()
  {
    if (this.c) {
      this.c = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceStatus.AudioDeviceStatusResult
 * JD-Core Version:    0.7.0.1
 */