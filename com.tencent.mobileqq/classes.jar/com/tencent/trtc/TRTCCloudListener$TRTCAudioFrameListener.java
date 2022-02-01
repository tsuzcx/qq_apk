package com.tencent.trtc;

public abstract interface TRTCCloudListener$TRTCAudioFrameListener
{
  public abstract void onCapturedRawAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame);
  
  public abstract void onLocalProcessedAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame);
  
  public abstract void onMixedPlayAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame);
  
  public abstract void onRemoteUserAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener
 * JD-Core Version:    0.7.0.1
 */