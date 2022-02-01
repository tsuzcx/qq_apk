package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class VideoAnimationUtils$1
  extends DownloadListener
{
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDone:");
      localStringBuilder.append(paramDownloadTask.c);
      QLog.d("VideoAnimationUtils", 2, localStringBuilder.toString());
    }
    VideoAnimationUtils.a(this.a, this.b.getAbsolutePath(), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.VideoAnimationUtils.1
 * JD-Core Version:    0.7.0.1
 */