package com.tencent.mobileqq.qqlive.api.anchor.stream;

public abstract interface IQQLiveAnchorMediaControl
{
  public abstract boolean isMicEnable();
  
  public abstract void startAudioRecord();
  
  public abstract void startCameraPreview();
  
  public abstract void startScreenCapturePreview();
  
  public abstract void stopAudioRecord();
  
  public abstract void stopCameraPreview();
  
  public abstract void stopScreenCapturePreview();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
 * JD-Core Version:    0.7.0.1
 */