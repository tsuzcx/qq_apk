package com.tencent.mobileqq.videocodec.audio;

public abstract interface AudioCapture$AudioCaptureListener
{
  public abstract void onAudioCaptured(String paramString);
  
  public abstract void onAudioChangeCaptured(String paramString);
  
  public abstract void onAudioError(int paramInt);
  
  public abstract void onAudioFrames(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void onAudioInit();
  
  public abstract void onAudioUnInit();
  
  public abstract void onEncodeAudioCaptured(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.audio.AudioCapture.AudioCaptureListener
 * JD-Core Version:    0.7.0.1
 */