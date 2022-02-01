package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.mobileqq.editor.composite.VideoCompositeHelper.MusicCallBack;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.monitor.CaptureFreqMonitor;
import com.tencent.mobileqq.monitor.CaptureFreqMonitorItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class FFmpegUtils$15
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$15(ExecuteBinResponseCallback paramExecuteBinResponseCallback, PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {}
  
  public void onFailure(String paramString)
  {
    this.val$endCallback.onFailure(paramString);
    Object localObject = this.val$endCallback;
    if ((localObject instanceof VideoCompositeHelper.MusicCallBack)) {
      ((VideoCompositeHelper.MusicCallBack)localObject).a(941007);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fakeid:");
    ((StringBuilder)localObject).append(this.val$info.fakeVid);
    ((StringBuilder)localObject).append(" combineVideoAndAudio failed msg：");
    ((StringBuilder)localObject).append(paramString);
    QLog.w("FFmpegCmd", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.val$outputClipAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(this.val$finalMixAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(this.val$finalNoneAudioVideoPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(this.val$localAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.val$endCallback.onFinish(paramBoolean);
  }
  
  public void onStart()
  {
    super.onStart();
    this.val$endCallback.onStart();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeid:");
    localStringBuilder.append(this.val$info.fakeVid);
    localStringBuilder.append(" combineVideoAndAudio start");
    QLog.i("FFmpegCmd", 1, localStringBuilder.toString());
  }
  
  public void onSuccess(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.startTime;
    if (CaptureFreqMonitor.d) {
      CaptureFreqMonitor.f.a(1, System.currentTimeMillis() - this.val$mergeStartTime);
    }
    this.val$endCallback.onSuccess(paramString);
    paramString = new StringBuilder();
    paramString.append("fakeid:");
    paramString.append(this.val$info.fakeVid);
    paramString.append(" combineVideoAndAudio end cost time：");
    paramString.append(String.valueOf(l1 - l2));
    QLog.i("FFmpegCmd", 1, paramString.toString());
    paramString = new StringBuilder();
    paramString.append("fakeid:");
    paramString.append(this.val$info.fakeVid);
    paramString.append(" mergeMusic success end");
    QLog.i("FFmpegCmd", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.15
 * JD-Core Version:    0.7.0.1
 */