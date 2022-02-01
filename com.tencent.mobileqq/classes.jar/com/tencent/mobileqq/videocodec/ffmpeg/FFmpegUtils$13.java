package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

final class FFmpegUtils$13
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$13(ExecuteBinResponseCallback paramExecuteBinResponseCallback, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    QLog.e("FFmpegCmd", 1, paramString);
    this.val$endCallback.onFailure(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeid:");
    localStringBuilder.append(this.val$info.fakeVid);
    localStringBuilder.append(" clip audio failed  msg：");
    localStringBuilder.append(paramString);
    QLog.w("FFmpegCmd", 1, localStringBuilder.toString());
  }
  
  public void onStart()
  {
    super.onStart();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeid:");
    localStringBuilder.append(this.val$info.fakeVid);
    localStringBuilder.append(" clip audio start");
    QLog.i("FFmpegCmd", 1, localStringBuilder.toString());
  }
  
  public void onSuccess(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.startTime;
    paramString = new StringBuilder();
    paramString.append("fakeid:");
    paramString.append(this.val$info.fakeVid);
    paramString.append(" clip audio end cost：");
    paramString.append(String.valueOf(l1 - l2));
    QLog.i("FFmpegCmd", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.13
 * JD-Core Version:    0.7.0.1
 */