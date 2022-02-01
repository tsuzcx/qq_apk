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
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
        if ((this.a.jdField_e_of_type_Boolean) && ("com.tencent.mobileqq".equals(this.a.jdField_e_of_type_JavaLangString)))
        {
          File localFile = new File(this.a.l);
          UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
          if ((localFile.exists()) && (localUpgradeDetailWrapper != null))
          {
            String str = MD5.a(localFile);
            if (!TextUtils.equals(localUpgradeDetailWrapper.a.strNewSoftwareMD5.toUpperCase(), str.toUpperCase()))
            {
              DownloadManagerV2.a(this.this$0, this.a, -51, "download file md5 check failed(not patche)");
              localFile.delete();
              return;
            }
          }
        }
        this.a.c = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        LogUtility.b("DownloadManagerV2", "onDownload complete, info.filePath = " + this.a.l);
        if ((!"com.tencent.mobileqq".equals(this.a.jdField_e_of_type_JavaLangString)) || (!this.this$0.a())) {
          break label388;
        }
        LogUtility.b("DownloadManagerV2", "QQ Download complete begin write code ......");
        this.a.j = DownloadManagerV2.a(this.this$0, this.a);
        if (this.a.j == 0) {
          break label338;
        }
        LogUtility.b("DownloadManagerV2", "QQ apk write code fail......");
        this.a.a(-2);
        this.this$0.c(this.a);
        DownloadManagerV2.a(this.this$0, this.a, this.a.j, null);
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
      LogUtility.b("AppCenterReporter", "from:[doMd5CheckAndWriteCode]");
      AppCenterReporter.b(this.a);
      if (this.a.a)
      {
        this.this$0.a(this.a, false);
        return;
        label338:
        LogUtility.b("DownloadManagerV2", "QQ apk code suc......");
        label388:
        do
        {
          this.this$0.c(this.a);
          this.this$0.a(4, this.a);
          long l = localException.mTotalDataLen;
          this.this$0.a(this.a, l);
          break;
        } while (TextUtils.isEmpty(this.a.jdField_e_of_type_JavaLangString));
        LogUtility.b("DownloadManagerV2", this.a.jdField_e_of_type_JavaLangString + " Download complete begin write code ......");
        DownloadManagerV2.b(this.this$0, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.7
 * JD-Core Version:    0.7.0.1
 */