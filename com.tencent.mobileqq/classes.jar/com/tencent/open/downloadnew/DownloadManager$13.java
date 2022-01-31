package com.tencent.open.downloadnew;

import akva;
import android.text.TextUtils;
import bdht;
import bdhu;
import bdjc;
import bdkp;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

public class DownloadManager$13
  implements Runnable
{
  public DownloadManager$13(bdkp parambdkp, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
        if ("com.tencent.mobileqq".equals(this.a.jdField_e_of_type_JavaLangString))
        {
          File localFile = new File(this.a.l);
          UpgradeDetailWrapper localUpgradeDetailWrapper = akva.a().a();
          if ((localFile.exists()) && (localUpgradeDetailWrapper != null))
          {
            String str = bdhu.a(localFile);
            if (!TextUtils.equals(localUpgradeDetailWrapper.a.strNewSoftwareMD5.toUpperCase(), str.toUpperCase()))
            {
              this.this$0.a(this.a, -51, "download file md5 check failed(not patche)");
              localFile.delete();
              return;
            }
          }
        }
        this.a.jdField_c_of_type_Long = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        bdht.b("DownloadManager_", "onDownload complete, info.filePath = " + this.a.l);
        if ((!"com.tencent.mobileqq".equals(this.a.jdField_e_of_type_JavaLangString)) || (!this.this$0.b())) {
          break label388;
        }
        bdht.c("DownloadManager_", "QQ Download complete begin write code ......");
        this.a.j = this.this$0.a(this.a);
        if (this.a.j == 0) {
          break label338;
        }
        bdht.c("DownloadManager_", "QQ apk write code fail......");
        this.a.jdField_e_of_type_Int = -2;
        this.this$0.e(this.a);
        this.this$0.a(this.a, this.a.j, null);
      }
    }
    catch (Exception localException)
    {
      bdht.c("DownloadManager_", "downloadSDKClient>>>", localException);
      for (;;)
      {
        bdjc.a("300", this.a.h, this.a.jdField_c_of_type_JavaLangString, this.a.o);
        if (!this.a.a) {
          break;
        }
        this.this$0.c(this.a);
        return;
        label338:
        bdht.c("DownloadManager_", "QQ apk code suc......");
        this.this$0.e(this.a);
        this.this$0.a(4, this.a);
        long l = localException.mTotalDataLen;
        this.this$0.a(this.a, l);
      }
      label388:
      bdht.c("DownloadManager_", this.a.jdField_e_of_type_JavaLangString + " Download complete begin write code ......");
      bdkp.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.13
 * JD-Core Version:    0.7.0.1
 */