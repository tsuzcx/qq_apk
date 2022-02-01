package com.tencent.mobileqq.qqlive.trtc.video.source.screen;

import com.tencent.mobileqq.qqlive.data.trtc.QQLiveScreenCaptureParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.video.source.ITRTCVideoBaseSource;

public abstract interface ITRTCScreenCaptureSource
  extends ITRTCVideoBaseSource
{
  public abstract void a(TRTCVideoQualityParams paramTRTCVideoQualityParams, QQLiveScreenCaptureParams paramQQLiveScreenCaptureParams);
  
  public abstract void a(IRTCScreenCaptureEventListener paramIRTCScreenCaptureEventListener);
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.source.screen.ITRTCScreenCaptureSource
 * JD-Core Version:    0.7.0.1
 */