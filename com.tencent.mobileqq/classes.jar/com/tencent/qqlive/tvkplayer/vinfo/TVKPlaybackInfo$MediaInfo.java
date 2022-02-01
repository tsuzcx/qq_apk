package com.tencent.qqlive.tvkplayer.vinfo;

import java.io.ByteArrayInputStream;
import java.util.Properties;

class TVKPlaybackInfo$MediaInfo
{
  private long audioBitRate;
  private String audioCodec;
  private String audioProfile;
  private int channels;
  private String codecMimeType;
  private String containerFormat;
  private long durationMs;
  private int height;
  private String mediaInfoStr;
  private long sampleRate;
  private long videoBitRate;
  private String videoCodec;
  private String videoProfile;
  private int videoRotation;
  private int width;
  
  long audioBitRate()
  {
    return this.audioBitRate;
  }
  
  String audioCodec()
  {
    return this.audioCodec;
  }
  
  String audioProfile()
  {
    return this.audioProfile;
  }
  
  int channels()
  {
    return this.channels;
  }
  
  String codecMimeType()
  {
    return this.codecMimeType;
  }
  
  String containerFormat()
  {
    return this.containerFormat;
  }
  
  long duration()
  {
    return this.durationMs;
  }
  
  void duration(long paramLong)
  {
    this.durationMs = paramLong;
  }
  
  String mediaInfoStr()
  {
    return this.mediaInfoStr;
  }
  
  void mediaInfoStr(String paramString)
  {
    try
    {
      this.mediaInfoStr = paramString;
      Properties localProperties = new Properties();
      localProperties.load(new ByteArrayInputStream(paramString.getBytes()));
      this.containerFormat = localProperties.getProperty("ContainerFormat", "");
      this.videoCodec = localProperties.getProperty("VideoCodec", "");
      this.videoProfile = localProperties.getProperty("VideoProfile", "");
      this.width = Integer.valueOf(localProperties.getProperty("Width")).intValue();
      this.height = Integer.valueOf(localProperties.getProperty("Height")).intValue();
      this.videoBitRate = Long.valueOf(localProperties.getProperty("VideoBitRate")).longValue();
      this.audioCodec = localProperties.getProperty("AudioCodec");
      this.audioProfile = localProperties.getProperty("AudioProfile", "");
      this.audioBitRate = Long.valueOf(localProperties.getProperty("AudioBitRate")).longValue();
      this.channels = Integer.valueOf(localProperties.getProperty("Channels")).intValue();
      this.sampleRate = Long.valueOf(localProperties.getProperty("SampleRate")).longValue();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.mediaInfoStr = "";
    }
  }
  
  long sampleRate()
  {
    return this.sampleRate;
  }
  
  long videoBitRate()
  {
    return this.videoBitRate;
  }
  
  String videoCodec()
  {
    return this.videoCodec;
  }
  
  int videoHeight()
  {
    return this.height;
  }
  
  void videoHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  String videoProfile()
  {
    return this.videoProfile;
  }
  
  int videoRotation()
  {
    return this.videoRotation;
  }
  
  void videoRotation(int paramInt)
  {
    this.videoRotation = paramInt;
  }
  
  int videoWidth()
  {
    return this.width;
  }
  
  void videoWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo.MediaInfo
 * JD-Core Version:    0.7.0.1
 */