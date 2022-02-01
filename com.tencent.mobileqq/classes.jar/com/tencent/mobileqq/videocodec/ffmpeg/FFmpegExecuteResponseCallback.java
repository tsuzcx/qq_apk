package com.tencent.mobileqq.videocodec.ffmpeg;

public abstract interface FFmpegExecuteResponseCallback
{
  public abstract void onFailure(String paramString);
  
  public abstract void onFinish(boolean paramBoolean);
  
  public abstract void onProgress(String paramString);
  
  public abstract void onStart();
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
 * JD-Core Version:    0.7.0.1
 */