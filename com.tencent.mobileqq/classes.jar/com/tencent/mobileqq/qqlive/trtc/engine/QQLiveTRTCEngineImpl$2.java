package com.tencent.mobileqq.qqlive.trtc.engine;

import com.tencent.mobileqq.qqlive.trtc.video.videoprocess.ITRTCVideoPreProcess;
import com.tencent.mobileqq.qqlive.trtc.video.videoprocess.QQLiveProcessFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener;

class QQLiveTRTCEngineImpl$2
  implements TRTCCloudListener.TRTCVideoFrameListener
{
  public void onGLContextCreated()
  {
    this.a.b();
  }
  
  public void onGLContextDestory()
  {
    this.a.c();
  }
  
  public int onProcessVideoFrame(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame1, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame2)
  {
    paramTRTCVideoFrame1 = new QQLiveProcessFrame(paramTRTCVideoFrame1);
    paramTRTCVideoFrame2 = new QQLiveProcessFrame(paramTRTCVideoFrame2);
    return this.a.a(paramTRTCVideoFrame1, paramTRTCVideoFrame2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.engine.QQLiveTRTCEngineImpl.2
 * JD-Core Version:    0.7.0.1
 */