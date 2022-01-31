package com.tencent.open.appstore.dl;

import akuz;
import android.text.TextUtils;
import bdhk;
import bdhz;
import bdii;
import bdij;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

public class DownloadManagerV2$7
  implements Runnable
{
  public DownloadManagerV2$7(bdhk parambdhk, DownloadInfo paramDownloadInfo) {}
  
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
          UpgradeDetailWrapper localUpgradeDetailWrapper = akuz.a().a();
          if ((localFile.exists()) && (localUpgradeDetailWrapper != null))
          {
            String str = bdij.a(localFile);
            if (!TextUtils.equals(localUpgradeDetailWrapper.a.strNewSoftwareMD5.toUpperCase(), str.toUpperCase()))
            {
              bdhk.a(this.this$0, this.a, -51, "download file md5 check failed(not patche)");
              localFile.delete();
              return;
            }
          }
        }
        this.a.c = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        bdii.b("DownloadManagerV2", "onDownload complete, info.filePath = " + this.a.l);
        if ((!"com.tencent.mobileqq".equals(this.a.jdField_e_of_type_JavaLangString)) || (!this.this$0.a())) {
          break label388;
        }
        bdii.b("DownloadManagerV2", "QQ Download complete begin write code ......");
        this.a.j = bdhk.a(this.this$0, this.a);
        if (this.a.j == 0) {
          break label338;
        }
        bdii.b("DownloadManagerV2", "QQ apk write code fail......");
        this.a.a(-2);
        this.this$0.c(this.a);
        bdhk.a(this.this$0, this.a, this.a.j, null);
      }
    }
    catch (Exception localException)
    {
      bdii.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
      bdii.b("AppCenterReporter", "from:[doMd5CheckAndWriteCode]");
      bdhz.b(this.a);
      if (this.a.a)
      {
        this.this$0.a(this.a, false);
        return;
        label338:
        bdii.b("DownloadManagerV2", "QQ apk code suc......");
        label388:
        do
        {
          this.this$0.c(this.a);
          this.this$0.a(4, this.a);
          long l = localException.mTotalDataLen;
          this.this$0.a(this.a, l);
          break;
        } while (TextUtils.isEmpty(this.a.jdField_e_of_type_JavaLangString));
        bdii.b("DownloadManagerV2", this.a.jdField_e_of_type_JavaLangString + " Download complete begin write code ......");
        bdhk.b(this.this$0, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.7
 * JD-Core Version:    0.7.0.1
 */