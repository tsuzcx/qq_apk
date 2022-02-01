package com.tencent.mobileqq.shortvideo.util.videoconverter;

public abstract interface VideoConverter$Processor
{
  public abstract VideoConverter.VideoConvertConfig getEncodeConfig(int paramInt1, int paramInt2);
  
  public abstract void onCanceled();
  
  public abstract void onFailed(Throwable paramThrowable);
  
  public abstract void onProgress(int paramInt);
  
  public abstract void onSuccessed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor
 * JD-Core Version:    0.7.0.1
 */