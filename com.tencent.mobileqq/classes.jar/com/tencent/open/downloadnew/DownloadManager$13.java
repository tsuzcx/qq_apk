package com.tencent.open.downloadnew;

import android.text.TextUtils;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

class DownloadManager$13
  implements Runnable
{
  DownloadManager$13(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this.this$0.h(this.a.d);
      if (localObject1 != null)
      {
        this.a.q = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        if ("com.tencent.mobileqq".equals(this.a.e))
        {
          localObject2 = new File(this.a.q);
          UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().d();
          if ((((File)localObject2).exists()) && (localUpgradeDetailWrapper != null))
          {
            String str = MD5.a((File)localObject2);
            if (!TextUtils.equals(localUpgradeDetailWrapper.b.strNewSoftwareMD5.toUpperCase(), str.toUpperCase()))
            {
              this.this$0.a(this.a, -51, "download file md5 check failed(not patche)");
              ((File)localObject2).delete();
              return;
            }
          }
        }
        this.a.E = ((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDownload complete, info.filePath = ");
        ((StringBuilder)localObject2).append(this.a.q);
        LogUtility.b("DownloadManager_", ((StringBuilder)localObject2).toString());
        if (("com.tencent.mobileqq".equals(this.a.e)) && (this.this$0.l()))
        {
          LogUtility.c("DownloadManager_", "QQ Download complete begin write code ......");
          this.a.D = this.this$0.h(this.a);
          if (this.a.D != 0)
          {
            LogUtility.c("DownloadManager_", "QQ apk write code fail......");
            this.a.s = -2;
            this.this$0.f(this.a);
            this.this$0.a(this.a, this.a.D, null);
            return;
          }
          LogUtility.c("DownloadManager_", "QQ apk code suc......");
          this.this$0.f(this.a);
          this.this$0.a(4, this.a);
          long l = ((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen;
          this.this$0.a(this.a, l);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.a.e);
          ((StringBuilder)localObject1).append(" Download complete begin write code ......");
          LogUtility.c("DownloadManager_", ((StringBuilder)localObject1).toString());
          DownloadManager.a(this.this$0, this.a);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
      StaticAnalyz.a("300", this.a.h, this.a.c, this.a.F);
      if (this.a.w) {
        this.this$0.d(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.13
 * JD-Core Version:    0.7.0.1
 */