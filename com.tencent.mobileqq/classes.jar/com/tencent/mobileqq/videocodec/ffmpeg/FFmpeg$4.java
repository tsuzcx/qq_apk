package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.biz.qqstory.support.logging.SLog;

class FFmpeg$4
  extends ExecuteBinResponseCallback
{
  FFmpeg$4(FFmpeg paramFFmpeg, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback) {}
  
  public void onFailure(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("concatMediaByTs change ts onFail: ");
    localStringBuilder.append(paramString);
    SLog.d("FFmpegCmd", localStringBuilder.toString());
    this.val$endCallback.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("concatMediaByTs change ts onSuccess: ");
    localStringBuilder.append(paramString);
    SLog.d("FFmpegCmd", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg.4
 * JD-Core Version:    0.7.0.1
 */