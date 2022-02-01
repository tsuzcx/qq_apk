package com.tencent.mobileqq.vashealth.api.impl;

import android.net.Uri;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class PathTraceManagerImpl$3
  extends DownloadListener
{
  PathTraceManagerImpl$3(PathTraceManagerImpl paramPathTraceManagerImpl, String paramString1, String paramString2) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("PathTraceManager", 1, "voice down");
    }
    paramDownloadTask = new File(this.a);
    try
    {
      ZipUtils.unZipFile(paramDownloadTask, PathTraceManagerImpl.access$600(this.c));
      i = 1;
    }
    catch (IOException paramDownloadTask)
    {
      int i;
      label47:
      StringBuilder localStringBuilder;
      break label47;
    }
    QLog.i("PathTraceManager", 1, "unzip fail");
    i = 0;
    if (i != 0)
    {
      QLog.d("PathTraceManager", 1, "unzip success");
      if (this.b != null)
      {
        paramDownloadTask = PathTraceManagerImpl.access$600(this.c);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append(".mp3");
        AudioUtil.a(Uri.fromFile(new File(paramDownloadTask, localStringBuilder.toString())), false, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */