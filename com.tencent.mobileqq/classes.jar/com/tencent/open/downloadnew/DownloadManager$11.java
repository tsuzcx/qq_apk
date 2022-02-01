package com.tencent.open.downloadnew;

import android.text.TextUtils;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;

class DownloadManager$11
  implements Runnable
{
  DownloadManager$11(DownloadManager paramDownloadManager, String paramString, Map paramMap, int paramInt, DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2, DownloadInfo paramDownloadInfo3) {}
  
  public void run()
  {
    boolean bool = TextUtils.isEmpty(this.a);
    int j = 3;
    int i = j;
    if (!bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownload download file, url = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append("params = ");
      localStringBuilder.append(this.b);
      LogUtility.a("DownloadManager_", localStringBuilder.toString());
      try
      {
        if (this.c == 0)
        {
          i = this.this$0.f().startDownloadTask(this.a, "application/vnd.android.package-archive", this.b);
        }
        else if (this.c == 1)
        {
          this.b.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
          i = this.this$0.f().startDownloadTask(this.a, "application/tm.android.apkdiff", this.b);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startDownload download unapk file, url = ");
          localStringBuilder.append(this.a);
          localStringBuilder.append(",filename = ");
          localStringBuilder.append(this.d.e);
          LogUtility.a("DownloadManager_", localStringBuilder.toString());
          i = this.this$0.f().startDownloadTask(this.a, 0, "resource/tm.android.unknown", this.d.f, this.b);
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
        i = j;
      }
    }
    for (;;)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadTask downloadSDKClient result=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" url=");
      ((StringBuilder)localObject).append(this.a);
      LogUtility.a("DownloadManager_", ((StringBuilder)localObject).toString());
      if (i != 0)
      {
        this.this$0.a(this.d, i, "");
      }
      else
      {
        localObject = this.e;
        DownloadInfo localDownloadInfo = this.d;
        if ((localObject == localDownloadInfo) && (localDownloadInfo.s == 20)) {
          this.this$0.a(20, this.d);
        }
      }
      DownloadInfoReport.a(1, this.a, i, this.f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.11
 * JD-Core Version:    0.7.0.1
 */