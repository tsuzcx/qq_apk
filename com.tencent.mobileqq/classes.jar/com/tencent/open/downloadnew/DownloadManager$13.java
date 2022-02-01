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
      Object localObject1 = this.this$0.a(this.a.d);
      if (localObject1 != null)
      {
        this.a.l = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        if ("com.tencent.mobileqq".equals(this.a.jdField_e_of_type_JavaLangString))
        {
          localObject2 = new File(this.a.l);
          UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
          if ((((File)localObject2).exists()) && (localUpgradeDetailWrapper != null))
          {
            String str = MD5.a((File)localObject2);
            if (!TextUtils.equals(localUpgradeDetailWrapper.a.strNewSoftwareMD5.toUpperCase(), str.toUpperCase()))
            {
              this.this$0.a(this.a, -51, "download file md5 check failed(not patche)");
              ((File)localObject2).delete();
              return;
            }
          }
        }
        this.a.jdField_c_of_type_Long = ((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDownload complete, info.filePath = ");
        ((StringBuilder)localObject2).append(this.a.l);
        LogUtility.b("DownloadManager_", ((StringBuilder)localObject2).toString());
        if (("com.tencent.mobileqq".equals(this.a.jdField_e_of_type_JavaLangString)) && (this.this$0.b()))
        {
          LogUtility.c("DownloadManager_", "QQ Download complete begin write code ......");
          this.a.j = this.this$0.a(this.a);
          if (this.a.j != 0)
          {
            LogUtility.c("DownloadManager_", "QQ apk write code fail......");
            this.a.jdField_e_of_type_Int = -2;
            this.this$0.e(this.a);
            this.this$0.a(this.a, this.a.j, null);
            return;
          }
          LogUtility.c("DownloadManager_", "QQ apk code suc......");
          this.this$0.e(this.a);
          this.this$0.a(4, this.a);
          long l = ((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen;
          this.this$0.a(this.a, l);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.a.jdField_e_of_type_JavaLangString);
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
      StaticAnalyz.a("300", this.a.h, this.a.jdField_c_of_type_JavaLangString, this.a.o);
      if (this.a.a) {
        this.this$0.c(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.13
 * JD-Core Version:    0.7.0.1
 */