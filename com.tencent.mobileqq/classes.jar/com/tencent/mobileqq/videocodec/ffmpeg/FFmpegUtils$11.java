package com.tencent.mobileqq.videocodec.ffmpeg;

final class FFmpegUtils$11
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$11(ExecuteBinResponseCallback paramExecuteBinResponseCallback) {}
  
  public void onFailure(String paramString)
  {
    this.val$endCallback.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    this.val$endCallback.onFinish(paramBoolean);
  }
  
  public void onStart()
  {
    super.onStart();
    this.val$endCallback.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.val$endCallback.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.11
 * JD-Core Version:    0.7.0.1
 */