package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;

class DownloadManager$5$2
  implements Runnable
{
  DownloadManager$5$2(DownloadManager.5 param5, long paramLong1, long paramLong2, String paramString) {}
  
  public void run()
  {
    int i = (int)((float)this.a * 100.0F / (float)this.b);
    DownloadInfo localDownloadInfo = this.d.a.c(this.c, i);
    if (localDownloadInfo == null)
    {
      LogUtility.d("DownloadManager_", "OnDownloadSDKTaskProgressChanged info == null");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDownloadSDKTaskProgressChanged info state=");
      localStringBuilder.append(localDownloadInfo.a());
      localStringBuilder.append(" progress=");
      localStringBuilder.append(localDownloadInfo.t);
      LogUtility.a("DownloadManager_", localStringBuilder.toString());
    }
    this.d.a.a(2, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.5.2
 * JD-Core Version:    0.7.0.1
 */