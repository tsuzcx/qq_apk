package com.tencent.mobileqq.qqlive.data.trtc;

public class TRTCVideoQualityParams$Builder
{
  private TRTCVideoQualityParams videoQuality = new TRTCVideoQualityParams();
  
  public TRTCVideoQualityParams build()
  {
    return this.videoQuality;
  }
  
  public Builder setEnableAdjustRes(boolean paramBoolean)
  {
    TRTCVideoQualityParams.access$502(this.videoQuality, paramBoolean);
    return this;
  }
  
  public Builder setMinVideoBitRate(int paramInt)
  {
    TRTCVideoQualityParams.access$302(this.videoQuality, paramInt);
    return this;
  }
  
  public Builder setVideoBitRate(int paramInt)
  {
    TRTCVideoQualityParams.access$202(this.videoQuality, paramInt);
    return this;
  }
  
  public Builder setVideoFps(int paramInt)
  {
    TRTCVideoQualityParams.access$102(this.videoQuality, paramInt);
    return this;
  }
  
  public Builder setVideoResolution(int paramInt)
  {
    TRTCVideoQualityParams.access$002(this.videoQuality, paramInt);
    return this;
  }
  
  public Builder setVideoResolutionMode(int paramInt)
  {
    TRTCVideoQualityParams.access$402(this.videoQuality, paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams.Builder
 * JD-Core Version:    0.7.0.1
 */