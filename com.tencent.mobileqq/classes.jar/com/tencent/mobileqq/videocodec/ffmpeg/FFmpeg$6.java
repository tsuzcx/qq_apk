package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.IOException;
import java.util.ArrayList;

class FFmpeg$6
  extends ExecuteBinResponseCallback
{
  FFmpeg$6(FFmpeg paramFFmpeg, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback, String[] paramArrayOfString, ArrayList paramArrayList) {}
  
  public void onFailure(String paramString)
  {
    SLog.e("FFmpegCmd", paramString);
    this.val$unitCallback.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.val$cmd == null) {
      this.val$unitCallback.onFinish(paramBoolean);
    }
    if (paramBoolean) {
      try
      {
        this.this$0.cmdFFmpegQueue(this.val$nextQueue);
        return;
      }
      catch (IOException localIOException)
      {
        this.val$unitCallback.onFailure(localIOException.getMessage());
        SLog.e("FFmpegCmd", localIOException.getMessage());
        return;
      }
      catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
      {
        this.val$unitCallback.onFailure(localFFmpegCommandAlreadyRunningException.getMessage());
        SLog.e("FFmpegCmd", localFFmpegCommandAlreadyRunningException.getMessage());
      }
    }
  }
  
  public void onProgress(String paramString)
  {
    this.val$unitCallback.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.val$unitCallback.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.val$unitCallback.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg.6
 * JD-Core Version:    0.7.0.1
 */