package com.tencent.open.appstore.dl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.securitysdk.utils.ApkExternalInfoTool;
import java.io.File;
import java.io.IOException;

class DownloadManagerV2$22
  implements Runnable
{
  DownloadManagerV2$22(DownloadManagerV2 paramDownloadManagerV2, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      String str1 = this.a.getString(DownloadConstants.a);
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      Object localObject1 = this.this$0.a(str1);
      str1 = this.a.getString("PackageName");
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[writeApkCodeAsync]  pkgName=");
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(" download info is null");
        LogUtility.e("DownloadManagerV2", ((StringBuilder)localObject1).toString());
        return;
      }
      String str2 = this.a.getString("Code");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[writeApkCodeAsync] pkgName=");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(", code=");
      ((StringBuilder)localObject2).append(str2);
      LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject2).toString());
      boolean bool = TextUtils.isEmpty(str2);
      if (bool)
      {
        ((DownloadInfo)localObject1).D = 0;
        ((DownloadInfo)localObject1).a(4);
        this.this$0.e((DownloadInfo)localObject1);
        this.this$0.a(4, (DownloadInfo)localObject1);
        this.this$0.a((DownloadInfo)localObject1, ((DownloadInfo)localObject1).E);
        LogUtility.b("AppCenterReporter", "from:[writeApkCodeAsync] code is empty");
        AppCenterReporter.b((DownloadInfo)localObject1);
        if (!((DownloadInfo)localObject1).w) {
          return;
        }
        this.this$0.a((DownloadInfo)localObject1, false);
        return;
      }
      this.a.getInt("VersionCode");
      localObject2 = new File(((DownloadInfo)localObject1).q);
      try
      {
        ApkExternalInfoTool.a((File)localObject2, str2);
        localObject2 = ApkExternalInfoTool.a((File)localObject2);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[writeApkCodeAsync] pkgName=");
        localStringBuilder2.append(str1);
        localStringBuilder2.append(",check code=");
        localStringBuilder2.append((String)localObject2);
        LogUtility.b("DownloadManagerV2", localStringBuilder2.toString());
        bool = str2.equals(localObject2);
      }
      catch (IOException localIOException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[writeApkCodeAsync] Exception=");
        ((StringBuilder)localObject2).append(localIOException.getMessage());
        LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject2).toString());
        bool = false;
      }
      StringBuilder localStringBuilder1;
      if (bool)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[writeApkCodeAsync]  pkgName=");
        localStringBuilder1.append(str1);
        localStringBuilder1.append(" write code and check code suc");
        LogUtility.b("DownloadManagerV2", localStringBuilder1.toString());
        ((DownloadInfo)localObject1).D = 0;
        this.this$0.e((DownloadInfo)localObject1);
        this.this$0.a(4, (DownloadInfo)localObject1);
        this.this$0.a((DownloadInfo)localObject1, ((DownloadInfo)localObject1).E);
        LogUtility.b("AppCenterReporter", "from:[writeApkCodeAsync] APK_WRITE_CODE_SUC");
        AppCenterReporter.b((DownloadInfo)localObject1);
        if (((DownloadInfo)localObject1).w) {
          this.this$0.a((DownloadInfo)localObject1, false);
        }
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[writeApkCodeAsync] pkgName=");
        localStringBuilder1.append(str1);
        localStringBuilder1.append(" write code or check code fail");
        LogUtility.b("DownloadManagerV2", localStringBuilder1.toString());
        ((DownloadInfo)localObject1).D = -20;
        ((DownloadInfo)localObject1).a(-2);
        this.this$0.e((DownloadInfo)localObject1);
        DownloadManagerV2.a(this.this$0, (DownloadInfo)localObject1, ((DownloadInfo)localObject1).D, null);
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "[writeApkCodeAsync] >>>", localException);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.22
 * JD-Core Version:    0.7.0.1
 */