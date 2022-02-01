package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

public class DecodePlayer$AudioDecodeConfig
{
  public String audioFilePath;
  public long endTimeMs = 0L;
  public boolean mMuteAudio = false;
  public boolean repeat = true;
  public int speedType = 0;
  public long startTimeMs = 0L;
  public long videoDurationMs = 0L;
  
  public void copyFrom(AudioDecodeConfig paramAudioDecodeConfig)
  {
    if (paramAudioDecodeConfig != null)
    {
      this.audioFilePath = paramAudioDecodeConfig.audioFilePath;
      this.repeat = paramAudioDecodeConfig.repeat;
      this.speedType = paramAudioDecodeConfig.speedType;
      this.mMuteAudio = paramAudioDecodeConfig.mMuteAudio;
      this.startTimeMs = paramAudioDecodeConfig.startTimeMs;
      this.endTimeMs = paramAudioDecodeConfig.endTimeMs;
      this.videoDurationMs = paramAudioDecodeConfig.videoDurationMs;
      return;
    }
    throw new NullPointerException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioDecodeConfig=[audioFilePath:");
    localStringBuilder.append(this.audioFilePath);
    localStringBuilder.append(" repeat:");
    localStringBuilder.append(this.repeat);
    localStringBuilder.append(" speedType:");
    localStringBuilder.append(this.speedType);
    localStringBuilder.append(" mMuteAudio:");
    localStringBuilder.append(this.mMuteAudio);
    localStringBuilder.append(" startTimeMs:");
    localStringBuilder.append(this.startTimeMs);
    localStringBuilder.append(" endTimeMs:");
    localStringBuilder.append(this.endTimeMs);
    localStringBuilder.append(" videoDuration:");
    localStringBuilder.append(this.videoDurationMs);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer.AudioDecodeConfig
 * JD-Core Version:    0.7.0.1
 */