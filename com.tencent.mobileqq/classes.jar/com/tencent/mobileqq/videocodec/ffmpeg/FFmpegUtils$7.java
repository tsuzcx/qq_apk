package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.qphone.base.util.QLog;

final class FFmpegUtils$7
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$7(ExecuteBinResponseCallback paramExecuteBinResponseCallback) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FFmpegCmd", 2, paramString);
    }
    this.val$endCallback.onFailure(paramString);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.startTime;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("音乐截取成功耗时：");
      paramString.append(String.valueOf(l1 - l2));
      QLog.w("FFmpegCmd", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.7
 * JD-Core Version:    0.7.0.1
 */