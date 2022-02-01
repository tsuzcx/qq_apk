package com.tencent.trtc;

public abstract interface TRTCCloudListener$TRTCVideoFrameListener
{
  public abstract void onGLContextCreated();
  
  public abstract void onGLContextDestory();
  
  public abstract int onProcessVideoFrame(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame1, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener
 * JD-Core Version:    0.7.0.1
 */