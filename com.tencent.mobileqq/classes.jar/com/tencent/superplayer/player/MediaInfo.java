package com.tencent.superplayer.player;

import android.text.TextUtils;
import com.tencent.superplayer.utils.LogUtil;
import java.io.ByteArrayInputStream;
import java.util.Properties;

public class MediaInfo
{
  private static final String FILENAME = "MediaInfo.java";
  private long audioBitRate;
  private String audioCodec;
  private String audioProfile;
  private int channels;
  private String codecMimeType;
  private String containerFormat;
  private long durationMs;
  private String mediaInfoStr;
  private String originalAudioTrackName;
  private long sampleRate;
  private String tag;
  private long videoBitRate;
  private String videoCodec;
  private int videoHeight;
  private String videoProfile;
  private int videoRotation;
  private int videoWidth;
  
  public MediaInfo(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("MediaInfo.java");
    this.tag = localStringBuilder.toString();
  }
  
  public static MediaInfo obtainMediaInfoFromString(String paramString1, String paramString2)
  {
    paramString1 = new MediaInfo(paramString1);
    try
    {
      paramString1.mediaInfoStr = paramString2;
      Properties localProperties = new Properties();
      localProperties.load(new ByteArrayInputStream(paramString2.getBytes()));
      paramString1.containerFormat = localProperties.getProperty("ContainerFormat", "");
      paramString1.videoCodec = localProperties.getProperty("VideoCodec", "");
      paramString1.videoProfile = localProperties.getProperty("VideoProfile", "");
      paramString1.videoWidth = Integer.valueOf(localProperties.getProperty("Width")).intValue();
      paramString1.videoHeight = Integer.valueOf(localProperties.getProperty("Height")).intValue();
      paramString1.videoBitRate = Long.valueOf(localProperties.getProperty("VideoBitRate")).longValue();
      paramString1.audioCodec = localProperties.getProperty("AudioCodec");
      paramString1.audioProfile = localProperties.getProperty("AudioProfile", "");
      paramString1.audioBitRate = Long.valueOf(localProperties.getProperty("AudioBitRate")).longValue();
      paramString1.channels = Integer.valueOf(localProperties.getProperty("Channels")).intValue();
      paramString1.sampleRate = Long.valueOf(localProperties.getProperty("SampleRate")).longValue();
      return paramString1;
    }
    catch (Exception paramString2)
    {
      LogUtil.e("SuperPlayer-", paramString2);
    }
    return paramString1;
  }
  
  public long getAudioBitRate()
  {
    return this.audioBitRate;
  }
  
  public String getAudioCodec()
  {
    return this.audioCodec;
  }
  
  public String getAudioProfile()
  {
    return this.audioProfile;
  }
  
  public int getChannels()
  {
    return this.channels;
  }
  
  public String getCodecMimeType()
  {
    return this.codecMimeType;
  }
  
  public String getContainerFormat()
  {
    return this.containerFormat;
  }
  
  public long getDurationMs()
  {
    return this.durationMs;
  }
  
  public String getMediaInfoStr()
  {
    return this.mediaInfoStr;
  }
  
  public long getSampleRate()
  {
    return this.sampleRate;
  }
  
  public long getVideoBitRate()
  {
    return this.videoBitRate;
  }
  
  public String getVideoCodec()
  {
    return this.videoCodec;
  }
  
  public int getVideoHeight()
  {
    return this.videoHeight;
  }
  
  public String getVideoProfile()
  {
    return this.videoProfile;
  }
  
  public int getVideoRotation()
  {
    return this.videoRotation;
  }
  
  public int getVideoWidth()
  {
    return this.videoWidth;
  }
  
  public void setAudioBitRate(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    this.audioBitRate = paramLong;
  }
  
  public void setAudioCodec(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.audioCodec = paramString;
  }
  
  public void setAudioProfile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.audioProfile = paramString;
  }
  
  public void setChannels(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.channels = paramInt;
  }
  
  public void setCodecMimeType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.codecMimeType = paramString;
  }
  
  public void setContainerFormat(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.containerFormat = paramString;
  }
  
  public void setDurationMs(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    this.durationMs = paramLong;
  }
  
  public void setMediaInfoStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mediaInfoStr = paramString;
  }
  
  public void setSampleRate(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    this.sampleRate = paramLong;
  }
  
  public void setVideoBitRate(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    this.videoBitRate = paramLong;
  }
  
  public void setVideoCodec(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.videoCodec = paramString;
  }
  
  public void setVideoHeight(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.videoHeight = paramInt;
  }
  
  public void setVideoProfile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.videoProfile = paramString;
  }
  
  public void setVideoRotation(int paramInt)
  {
    this.videoRotation = paramInt;
  }
  
  public void setVideoWidth(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.videoWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.player.MediaInfo
 * JD-Core Version:    0.7.0.1
 */