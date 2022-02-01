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
      Object localObject1 = this.this$0.a(this.a.d);
      if (localObject1 != null)
      {
        this.a.l = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        boolean bool = this.a.jdField_e_of_type_Boolean;
        if ((bool) && ("com.tencent.mobileqq".equals(this.a.jdField_e_of_type_JavaLangString)))
        {
          localObject2 = new File(this.a.l);
          UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
          if ((((File)localObject2).exists()) && (localUpgradeDetailWrapper != null))
          {
            String str = MD5.a((File)localObject2);
            if (!TextUtils.equals(localUpgradeDetailWrapper.a.strNewSoftwareMD5.toUpperCase(), str.toUpperCase()))
            {
              DownloadManagerV2.a(this.this$0, this.a, -51, "download file md5 check failed(not patche)");
              ((File)localObject2).delete();
              return;
            }
          }
        }
        this.a.c = ((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDownload complete, info.filePath = ");
        ((StringBuilder)localObject2).append(this.a.l);
        LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject2).toString());
        if (("com.tencent.mobileqq".equals(this.a.jdField_e_of_type_JavaLangString)) && (this.this$0.a()))
        {
          LogUtility.b("DownloadManagerV2", "QQ Download complete begin write code ......");
          this.a.j = DownloadManagerV2.a(this.this$0, this.a);
          if (this.a.j != 0)
          {
            LogUtility.b("DownloadManagerV2", "QQ apk write code fail......");
            this.a.a(-2);
            this.this$0.c(this.a);
            DownloadManagerV2.a(this.this$0, this.a, this.a.j, null);
            return;
          }
          LogUtility.b("DownloadManagerV2", "QQ apk code suc......");
        }
        else if (!TextUtils.isEmpty(this.a.jdField_e_of_type_JavaLangString))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.a.jdField_e_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(" Download complete begin write code ......");
          LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject1).toString());
          DownloadManagerV2.b(this.this$0, this.a);
          return;
        }
        this.this$0.c(this.a);
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
    if (this.a.a) {
      this.this$0.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.7
 * JD-Core Version:    0.7.0.1
 */