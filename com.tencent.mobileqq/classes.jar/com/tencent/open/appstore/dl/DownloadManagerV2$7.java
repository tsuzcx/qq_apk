package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

class DownloadManagerV2$7
  implements Runnable
{
  DownloadManagerV2$7(DownloadManagerV2 paramDownloadManagerV2, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this.this$0.g(this.a.d);
      if (localObject1 != null)
      {
        this.a.q = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        boolean bool = this.a.P;
        if ((bool) && ("com.tencent.mobileqq".equals(this.a.e)))
        {
          localObject2 = new File(this.a.q);
          UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().d();
          if ((((File)localObject2).exists()) && (localUpgradeDetailWrapper != null))
          {
            String str = MD5.a((File)localObject2);
            if (!TextUtils.equals(localUpgradeDetailWrapper.b.strNewSoftwareMD5.toUpperCase(), str.toUpperCase()))
            {
              DownloadManagerV2.a(this.this$0, this.a, -51, "download file md5 check failed(not patche)");
              ((File)localObject2).delete();
              return;
            }
          }
        }
        this.a.E = ((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDownload complete, info.filePath = ");
        ((StringBuilder)localObject2).append(this.a.q);
        LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject2).toString());
        if (("com.tencent.mobileqq".equals(this.a.e)) && (this.this$0.f()))
        {
          LogUtility.b("DownloadManagerV2", "QQ Download complete begin write code ......");
          this.a.D = DownloadManagerV2.b(this.this$0, this.a);
          if (this.a.D != 0)
          {
            LogUtility.b("DownloadManagerV2", "QQ apk write code fail......");
            this.a.a(-2);
            this.this$0.e(this.a);
            DownloadManagerV2.a(this.this$0, this.a, this.a.D, null);
            return;
          }
          LogUtility.b("DownloadManagerV2", "QQ apk code suc......");
        }
        else if (!TextUtils.isEmpty(this.a.e))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.a.e);
          ((StringBuilder)localObject1).append(" Download complete begin write code ......");
          LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject1).toString());
          DownloadManagerV2.c(this.this$0, this.a);
          return;
        }
        this.this$0.e(this.a);
        this.this$0.a(4, this.a);
        long l = ((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen;
        this.this$0.a(this.a, l);
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
    LogUtility.b("AppCenterReporter", "from:[doMd5CheckAndWriteCode]");
    AppCenterReporter.b(this.a);
    if (this.a.w) {
      this.this$0.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.7
 * JD-Core Version:    0.7.0.1
 */