package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;

class DownloadManagerV2$13
  implements Runnable
{
  DownloadManagerV2$13(DownloadManagerV2 paramDownloadManagerV2, String paramString, Map paramMap, int paramInt, DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2) {}
  
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
      LogUtility.b("DownloadManagerV2", localStringBuilder.toString());
      try
      {
        if (this.c == 0)
        {
          i = DownloadManagerV2.e(this.this$0).startDownloadTask(this.a, "application/vnd.android.package-archive", this.b);
        }
        else if (this.c == 1)
        {
          this.b.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
          i = DownloadManagerV2.e(this.this$0).startDownloadTask(this.a, "application/tm.android.apkdiff", this.b);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startDownload download unapk file, url = ");
          localStringBuilder.append(this.a);
          localStringBuilder.append(",filename = ");
          localStringBuilder.append(this.d.e);
          LogUtility.a("DownloadManagerV2", localStringBuilder.toString());
          i = DownloadManagerV2.e(this.this$0).startDownloadTask(this.a, 0, "resource/tm.android.unknown", this.d.f, this.b);
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
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
      LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject).toString());
      if (i != 0)
      {
        DownloadManagerV2.a(this.this$0, this.d, i, "");
        return;
      }
      localObject = this.e;
      DownloadInfo localDownloadInfo = this.d;
      if ((localObject == localDownloadInfo) && (localDownloadInfo.a() == 20)) {
        this.this$0.a(20, this.d);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.13
 * JD-Core Version:    0.7.0.1
 */