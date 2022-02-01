package com.tencent.trtc;

import java.util.ArrayList;

public class TRTCCloudDef$TRTCTranscodingConfig
{
  public int appId;
  public int audioBitrate;
  public int audioChannels;
  public int audioSampleRate;
  public int backgroundColor;
  public String backgroundImage;
  public int bizId;
  public ArrayList<TRTCCloudDef.TRTCMixUser> mixUsers;
  public int mode;
  public String streamId;
  public int videoBitrate;
  public int videoFramerate;
  public int videoGOP;
  public int videoHeight;
  public int videoWidth;
  
  public TRTCCloudDef$TRTCTranscodingConfig()
  {
    this.mode = 0;
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.videoBitrate = 0;
    this.videoFramerate = 15;
    this.videoGOP = 2;
    this.backgroundColor = 0;
    this.audioSampleRate = 48000;
    this.audioBitrate = 64;
    this.audioChannels = 1;
    this.streamId = null;
  }
  
  public TRTCCloudDef$TRTCTranscodingConfig(TRTCTranscodingConfig paramTRTCTranscodingConfig)
  {
    this.appId = paramTRTCTranscodingConfig.appId;
    this.bizId = paramTRTCTranscodingConfig.bizId;
    this.mode = paramTRTCTranscodingConfig.mode;
    this.videoWidth = paramTRTCTranscodingConfig.videoWidth;
    this.videoHeight = paramTRTCTranscodingConfig.videoHeight;
    this.videoBitrate = paramTRTCTranscodingConfig.videoBitrate;
    this.videoFramerate = paramTRTCTranscodingConfig.videoFramerate;
    this.videoGOP = paramTRTCTranscodingConfig.videoGOP;
    this.backgroundColor = paramTRTCTranscodingConfig.backgroundColor;
    this.backgroundImage = paramTRTCTranscodingConfig.backgroundImage;
    this.audioSampleRate = paramTRTCTranscodingConfig.audioSampleRate;
    this.audioBitrate = paramTRTCTranscodingConfig.audioBitrate;
    this.audioChannels = paramTRTCTranscodingConfig.audioChannels;
    this.streamId = paramTRTCTranscodingConfig.streamId;
    this.mixUsers = new ArrayList(paramTRTCTranscodingConfig.mixUsers);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(", bizId=");
    localStringBuilder.append(this.bizId);
    localStringBuilder.append(", mode=");
    localStringBuilder.append(this.mode);
    localStringBuilder.append(", videoWidth=");
    localStringBuilder.append(this.videoWidth);
    localStringBuilder.append(", videoHeight=");
    localStringBuilder.append(this.videoHeight);
    localStringBuilder.append(", videoBitrate=");
    localStringBuilder.append(this.videoBitrate);
    localStringBuilder.append(", videoFramerate=");
    localStringBuilder.append(this.videoFramerate);
    localStringBuilder.append(", videoGOP=");
    localStringBuilder.append(this.videoGOP);
    localStringBuilder.append(", backgroundColor=");
    localStringBuilder.append(this.backgroundColor);
    localStringBuilder.append(", backgroundImage=");
    localStringBuilder.append(this.backgroundImage);
    localStringBuilder.append(", audioSampleRate=");
    localStringBuilder.append(this.audioSampleRate);
    localStringBuilder.append(", audioBitrate=");
    localStringBuilder.append(this.audioBitrate);
    localStringBuilder.append(", audioChannels=");
    localStringBuilder.append(this.audioChannels);
    localStringBuilder.append(", streamId=");
    localStringBuilder.append(this.streamId);
    localStringBuilder.append(", mixUsers=");
    localStringBuilder.append(this.mixUsers);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig
 * JD-Core Version:    0.7.0.1
 */