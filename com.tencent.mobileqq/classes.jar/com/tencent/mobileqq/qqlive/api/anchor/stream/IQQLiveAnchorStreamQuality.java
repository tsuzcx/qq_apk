package com.tencent.mobileqq.qqlive.api.anchor.stream;

import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;

public abstract interface IQQLiveAnchorStreamQuality
{
  public abstract void changeOrientation(int paramInt);
  
  public abstract TRTCVideoQualityParams getVideoQuality();
  
  public abstract void setVideoQuality(TRTCVideoQualityParams paramTRTCVideoQualityParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamQuality
 * JD-Core Version:    0.7.0.1
 */