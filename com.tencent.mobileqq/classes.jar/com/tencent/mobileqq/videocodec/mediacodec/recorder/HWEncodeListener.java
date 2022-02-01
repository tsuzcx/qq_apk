package com.tencent.mobileqq.videocodec.mediacodec.recorder;

public abstract interface HWEncodeListener
{
  public abstract void onEncodeError(int paramInt, Throwable paramThrowable);
  
  public abstract void onEncodeFinish(String paramString);
  
  public abstract void onEncodeFrame();
  
  public abstract void onEncodeStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener
 * JD-Core Version:    0.7.0.1
 */