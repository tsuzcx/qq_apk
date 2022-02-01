package com.tencent.tav.core;

import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;

public class ExportConfig
  implements Cloneable
{
  private int audioAacProfile = 2;
  private int audioBitRate = 128000;
  private int audioChannelCount = 1;
  @Nullable
  private MediaFormat audioFormat;
  private int audioSampleRateHz = 44100;
  private boolean enableBFrame = false;
  private boolean highProfile = false;
  private String outputFilePath;
  private int outputHeight;
  private String outputVideoMimeType = "video/avc";
  private int outputWidth;
  private int videoBitRate = 8000000;
  @Nullable
  private MediaFormat videoFormat;
  private int videoFrameRate = 30;
  private int videoIFrameInterval = 1;
  
  public ExportConfig(int paramInt1, int paramInt2)
  {
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
  }
  
  @Deprecated
  public ExportConfig(EncoderWriter.OutputConfig paramOutputConfig)
  {
    this.outputWidth = paramOutputConfig.VIDEO_TARGET_WIDTH;
    this.outputHeight = paramOutputConfig.VIDEO_TARGET_HEIGHT;
    this.videoIFrameInterval = paramOutputConfig.VIDEO_IFRAME_INTERVAL;
    this.videoBitRate = paramOutputConfig.VIDEO_BIT_RATE;
    this.videoFrameRate = paramOutputConfig.VIDEO_FRAME_RATE;
    this.highProfile = paramOutputConfig.HIGH_PROFILE;
    this.audioChannelCount = paramOutputConfig.AUDIO_CHANNEL_COUNT;
    this.audioBitRate = paramOutputConfig.AUDIO_BIT_RATE;
    this.audioAacProfile = paramOutputConfig.AUDIO_AAC_PROFILE;
  }
  
  private int findFormatValue(String paramString, int paramInt, MediaFormat paramMediaFormat)
  {
    if ((paramMediaFormat != null) && (paramMediaFormat.containsKey(paramString))) {
      return paramMediaFormat.getInteger(paramString);
    }
    return paramInt;
  }
  
  private int findVideoFormatValue(String paramString, int paramInt)
  {
    return findFormatValue(paramString, paramInt, this.videoFormat);
  }
  
  private void initAudioChannelCount()
  {
    setToFormat("channel-count", this.audioChannelCount, this.audioFormat);
  }
  
  private void initFrameRate()
  {
    setToVideoFormat("frame-rate", this.videoFrameRate);
  }
  
  private void initHighProfile()
  {
    MediaFormat localMediaFormat = this.videoFormat;
    if (localMediaFormat == null) {
      return;
    }
    if (this.highProfile)
    {
      CodecHelper.selectProfileAndLevel(localMediaFormat, this.outputVideoMimeType);
      return;
    }
    removeProfile(localMediaFormat);
  }
  
  private void initIFrameInterval()
  {
    setToVideoFormat("i-frame-interval", this.videoIFrameInterval);
  }
  
  private void initMaxBFrame()
  {
    if (this.enableBFrame) {
      setToFormat("max-bframes", 1, this.videoFormat);
    }
  }
  
  private void initOutputSize()
  {
    CGSize localCGSize = CodecHelper.correctSupportSize(getOutputSize(), this.outputVideoMimeType);
    setToVideoFormat("width", (int)localCGSize.width);
    setToVideoFormat("height", (int)localCGSize.height);
  }
  
  private void initOutputVideoMimeType()
  {
    setToFormat("mime", this.outputVideoMimeType, this.videoFormat);
  }
  
  private void initVideoBitrate()
  {
    setToVideoFormat("bitrate", this.videoBitRate);
  }
  
  private void removeProfile(MediaFormat paramMediaFormat)
  {
    if (paramMediaFormat.containsKey("profile")) {
      setToFormat("profile", 0, paramMediaFormat);
    }
    if (paramMediaFormat.containsKey("level")) {
      setToFormat("level", 0, paramMediaFormat);
    }
  }
  
  private void setToFormat(String paramString, int paramInt, MediaFormat paramMediaFormat)
  {
    if (paramMediaFormat == null) {
      return;
    }
    paramMediaFormat.setInteger(paramString, paramInt);
  }
  
  private void setToFormat(String paramString1, String paramString2, MediaFormat paramMediaFormat)
  {
    if (paramMediaFormat == null) {
      return;
    }
    paramMediaFormat.setString(paramString1, paramString2);
  }
  
  private void setToVideoFormat(String paramString, int paramInt)
  {
    setToFormat(paramString, paramInt, this.videoFormat);
  }
  
  public boolean available()
  {
    return (getOutputWidth() > 0) && (getOutputHeight() > 0);
  }
  
  public ExportConfig clone()
  {
    ExportConfig localExportConfig = new ExportConfig(this.outputWidth, this.outputHeight);
    localExportConfig.videoFormat = this.videoFormat;
    localExportConfig.audioFormat = this.audioFormat;
    localExportConfig.videoBitRate = this.videoBitRate;
    localExportConfig.videoFrameRate = this.videoFrameRate;
    localExportConfig.videoIFrameInterval = this.videoIFrameInterval;
    localExportConfig.outputVideoMimeType = this.outputVideoMimeType;
    localExportConfig.outputWidth = this.outputWidth;
    localExportConfig.outputHeight = this.outputHeight;
    localExportConfig.highProfile = this.highProfile;
    localExportConfig.audioBitRate = this.audioBitRate;
    localExportConfig.audioAacProfile = this.audioAacProfile;
    localExportConfig.audioChannelCount = this.audioChannelCount;
    localExportConfig.audioSampleRateHz = this.audioSampleRateHz;
    return localExportConfig;
  }
  
  public int getAudioAacProfile()
  {
    return this.audioAacProfile;
  }
  
  public int getAudioBitRate()
  {
    return this.audioBitRate;
  }
  
  public int getAudioChannelCount()
  {
    return findFormatValue("channel-count", this.audioChannelCount, this.audioFormat);
  }
  
  @NonNull
  public MediaFormat getAudioFormat()
  {
    if (this.audioFormat == null)
    {
      this.audioFormat = new MediaFormat();
      this.audioFormat.setString("mime", "audio/mp4a-latm");
      this.audioFormat.setInteger("sample-rate", this.audioSampleRateHz);
      initAudioChannelCount();
      this.audioFormat.setInteger("bitrate", this.audioBitRate);
      this.audioFormat.setInteger("aac-profile", this.audioAacProfile);
    }
    return this.audioFormat;
  }
  
  public int getAudioSampleRateHz()
  {
    return findFormatValue("sample-rate", this.audioSampleRateHz, this.audioFormat);
  }
  
  public String getOutputFilePath()
  {
    return this.outputFilePath;
  }
  
  public int getOutputHeight()
  {
    return findVideoFormatValue("height", this.outputHeight);
  }
  
  public CGSize getOutputSize()
  {
    return new CGSize(getOutputWidth(), getOutputHeight());
  }
  
  public String getOutputVideoMimeType()
  {
    return this.outputVideoMimeType;
  }
  
  public int getOutputWidth()
  {
    return findVideoFormatValue("width", this.outputWidth);
  }
  
  public int getVideoBitRate()
  {
    return findVideoFormatValue("bitrate", this.videoBitRate);
  }
  
  @NonNull
  public MediaFormat getVideoFormat()
  {
    if (this.videoFormat == null)
    {
      this.videoFormat = new MediaFormat();
      this.videoFormat.setInteger("color-format", 2130708361);
      initOutputSize();
      initVideoBitrate();
      initFrameRate();
      initIFrameInterval();
      initOutputVideoMimeType();
      initHighProfile();
      initMaxBFrame();
    }
    return this.videoFormat;
  }
  
  public int getVideoFrameRate()
  {
    return findVideoFormatValue("frame-rate", this.videoFrameRate);
  }
  
  public int getVideoIFrameInterval()
  {
    return this.videoIFrameInterval;
  }
  
  public boolean isHighProfile()
  {
    return this.highProfile;
  }
  
  public void reset()
  {
    this.audioFormat = null;
    this.videoFormat = null;
  }
  
  public void setAudioChannelCount(int paramInt)
  {
    this.audioChannelCount = paramInt;
    initAudioChannelCount();
  }
  
  public void setEnableBFrame(boolean paramBoolean)
  {
    this.enableBFrame = paramBoolean;
    initMaxBFrame();
  }
  
  public void setHighProfile(boolean paramBoolean)
  {
    this.highProfile = paramBoolean;
    initHighProfile();
  }
  
  public void setOutputFilePath(String paramString)
  {
    this.outputFilePath = paramString;
  }
  
  public void setOutputSize(int paramInt1, int paramInt2)
  {
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    initOutputSize();
  }
  
  public void setOutputVideoMimeType(String paramString)
  {
    this.outputVideoMimeType = paramString;
    initOutputVideoMimeType();
  }
  
  public void setVideoBitRate(int paramInt)
  {
    this.videoBitRate = paramInt;
    initVideoBitrate();
  }
  
  public void setVideoFrameRate(int paramInt)
  {
    this.videoFrameRate = paramInt;
    initFrameRate();
  }
  
  public void setVideoIFrameInterval(int paramInt)
  {
    this.videoIFrameInterval = paramInt;
    initIFrameInterval();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.ExportConfig
 * JD-Core Version:    0.7.0.1
 */