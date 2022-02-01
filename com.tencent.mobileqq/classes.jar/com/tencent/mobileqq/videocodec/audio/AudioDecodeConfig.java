package com.tencent.mobileqq.videocodec.audio;

import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;

public class AudioDecodeConfig
{
  public String a;
  public AudioEncoder.AudioData b;
  public boolean c = true;
  public int d = 0;
  public boolean e = false;
  public long f = 0L;
  public long g = 0L;
  public long h = 0L;
  public String i;
  public AudioEncoder.AudioData j;
  
  public void a(AudioDecodeConfig paramAudioDecodeConfig)
  {
    if (paramAudioDecodeConfig != null)
    {
      this.a = paramAudioDecodeConfig.a;
      this.i = paramAudioDecodeConfig.i;
      this.b = paramAudioDecodeConfig.b;
      this.c = paramAudioDecodeConfig.c;
      this.d = paramAudioDecodeConfig.d;
      this.e = paramAudioDecodeConfig.e;
      this.f = paramAudioDecodeConfig.f;
      this.g = paramAudioDecodeConfig.g;
      this.h = paramAudioDecodeConfig.h;
      return;
    }
    throw new NullPointerException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioDecodeConfig=[audioFilePath:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" repeat:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" speedType:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mMuteAudio:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" startTimeMs:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" endTimeMs:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" videoDuration:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.audio.AudioDecodeConfig
 * JD-Core Version:    0.7.0.1
 */