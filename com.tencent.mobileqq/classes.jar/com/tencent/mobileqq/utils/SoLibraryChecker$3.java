package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class SoLibraryChecker$3
  extends DownloadListener
{
  SoLibraryChecker$3(SoLibraryChecker paramSoLibraryChecker, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadUpdate loaded json = ");
      localStringBuilder.append(paramDownloadTask.h);
      localStringBuilder.append(" code = ");
      localStringBuilder.append(paramDownloadTask.c);
      QLog.d("SoLibraryLoader", 2, localStringBuilder.toString());
    }
    boolean bool = SoLibraryChecker.a(this.d, this.a, this.b, this.c);
    if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("downloadUpdate unCompressOffline ");
      paramDownloadTask.append(bool);
      QLog.d("SoLibraryLoader", 2, paramDownloadTask.toString());
    }
    SoLibraryChecker.e(this.d);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = (int)(paramDownloadTask.l * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel()))
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("downding progress = ");
      paramDownloadTask.append(i);
      QLog.d("SoLibraryLoader", 2, paramDownloadTask.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLibraryChecker.3
 * JD-Core Version:    0.7.0.1
 */