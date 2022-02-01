package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.monitor.CaptureFreqMonitor;
import com.tencent.mobileqq.monitor.CaptureFreqMonitorItem;
import java.io.File;

final class FFmpegUtils$9
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$9(ExecuteBinResponseCallback paramExecuteBinResponseCallback, String paramString, long paramLong) {}
  
  public void onFailure(String paramString)
  {
    this.val$endCallback.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.val$outputClipAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.val$endCallback.onFinish(paramBoolean);
  }
  
  public void onStart()
  {
    super.onStart();
    this.val$endCallback.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    System.currentTimeMillis();
    long l = this.startTime;
    if (CaptureFreqMonitor.d) {
      CaptureFreqMonitor.f.a(1, System.currentTimeMillis() - this.val$mergeStartTime);
    }
    this.val$endCallback.onSuccess(paramString);
    SLog.c("FFmpegCmd", " recordVideo combinBackgroundMusic success end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.9
 * JD-Core Version:    0.7.0.1
 */