package com.tencent.richmedia.videocompress;

public abstract interface VideoConverter$Processor
{
  public abstract VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2);
  
  public abstract void onCancel();
  
  public abstract void onFail(Throwable paramThrowable);
  
  public abstract void onProgress(int paramInt);
  
  public abstract void onSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.VideoConverter.Processor
 * JD-Core Version:    0.7.0.1
 */