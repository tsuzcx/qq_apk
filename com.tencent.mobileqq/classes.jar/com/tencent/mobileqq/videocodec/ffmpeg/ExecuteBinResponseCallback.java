package com.tencent.mobileqq.videocodec.ffmpeg;

public class ExecuteBinResponseCallback
  implements FFmpegExecuteResponseCallback
{
  public long startTime;
  
  public void onFailure(String paramString) {}
  
  public void onFinish(boolean paramBoolean) {}
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    this.startTime = System.currentTimeMillis();
  }
  
  public void onSuccess(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback
 * JD-Core Version:    0.7.0.1
 */