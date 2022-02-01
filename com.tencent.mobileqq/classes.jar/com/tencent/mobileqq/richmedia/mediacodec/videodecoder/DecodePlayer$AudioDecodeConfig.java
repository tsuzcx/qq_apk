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
    if (paramAudioDecodeConfig == null) {
      throw new NullPointerException();
    }
    this.audioFilePath = paramAudioDecodeConfig.audioFilePath;
    this.repeat = paramAudioDecodeConfig.repeat;
    this.speedType = paramAudioDecodeConfig.speedType;
    this.mMuteAudio = paramAudioDecodeConfig.mMuteAudio;
    this.startTimeMs = paramAudioDecodeConfig.startTimeMs;
    this.endTimeMs = paramAudioDecodeConfig.endTimeMs;
    this.videoDurationMs = paramAudioDecodeConfig.videoDurationMs;
  }
  
  public String toString()
  {
    return "AudioDecodeConfig=[audioFilePath:" + this.audioFilePath + " repeat:" + this.repeat + " speedType:" + this.speedType + " mMuteAudio:" + this.mMuteAudio + " startTimeMs:" + this.startTimeMs + " endTimeMs:" + this.endTimeMs + " videoDuration:" + this.videoDurationMs + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer.AudioDecodeConfig
 * JD-Core Version:    0.7.0.1
 */