package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.mobileqq.editor.composite.VideoCompositeHelper.MusicCallBack;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

final class FFmpegUtils$19
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$19(ExecuteBinResponseCallback paramExecuteBinResponseCallback, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FFmpegCmd", 2, paramString);
    }
    this.val$endCallback.onFailure(paramString);
    Object localObject = this.val$endCallback;
    if ((localObject instanceof VideoCompositeHelper.MusicCallBack)) {
      ((VideoCompositeHelper.MusicCallBack)localObject).a(941004);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fakeid:");
    ((StringBuilder)localObject).append(this.val$info.fakeVid);
    ((StringBuilder)localObject).append(" getAudioFromMp4 failed message：");
    ((StringBuilder)localObject).append(paramString);
    QLog.w("FFmpegCmd", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onStart()
  {
    super.onStart();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeid:");
    localStringBuilder.append(this.val$info.fakeVid);
    localStringBuilder.append(" getAudioFromMp4 start");
    QLog.i("FFmpegCmd", 1, localStringBuilder.toString());
  }
  
  public void onSuccess(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.startTime;
    paramString = new StringBuilder();
    paramString.append("fakeid:");
    paramString.append(this.val$info.fakeVid);
    paramString.append(" getAudioFromMp4 success cost：");
    paramString.append(String.valueOf(l1 - l2));
    paramString.append("ms\n");
    QLog.i("FFmpegCmd", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.19
 * JD-Core Version:    0.7.0.1
 */