package com.tencent.open.downloadnew;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.securitysdk.utils.ApkExternalInfoTool;
import java.io.File;
import java.io.IOException;

class DownloadManager$21
  implements Runnable
{
  DownloadManager$21(DownloadManager paramDownloadManager, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      String str1 = this.a.getString("PackageName");
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("receive write code msg pkgName|");
      ((StringBuilder)localObject1).append(str1);
      LogUtility.c("DownloadManager_", ((StringBuilder)localObject1).toString());
      if (str1 == null) {
        return;
      }
      localObject1 = this.this$0.f(str1);
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("receive write code msg pkgName|");
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(" download info is null");
        LogUtility.c("DownloadManager_", ((StringBuilder)localObject1).toString());
        return;
      }
      String str2 = this.a.getString("Code");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("receive write code msg pkgName|");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(" code|");
      ((StringBuilder)localObject2).append(str2);
      LogUtility.c("DownloadManager_", ((StringBuilder)localObject2).toString());
      boolean bool = TextUtils.isEmpty(str2);
      if (bool)
      {
        ((DownloadInfo)localObject1).a(4);
        ((DownloadInfo)localObject1).D = 0;
        this.this$0.f((DownloadInfo)localObject1);
        this.this$0.a(4, (DownloadInfo)localObject1);
        this.this$0.a((DownloadInfo)localObject1, ((DownloadInfo)localObject1).E);
        StaticAnalyz.a("300", ((DownloadInfo)localObject1).h, ((DownloadInfo)localObject1).c, ((DownloadInfo)localObject1).F);
        if (!((DownloadInfo)localObject1).w) {
          return;
        }
        this.this$0.d((DownloadInfo)localObject1);
        return;
      }
      this.a.getInt("VersionCode");
      localObject2 = new File(((DownloadInfo)localObject1).q);
      try
      {
        ApkExternalInfoTool.a((File)localObject2, str2);
        localObject2 = ApkExternalInfoTool.a((File)localObject2);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("receive write code msg pkgName|");
        localStringBuilder2.append(str1);
        localStringBuilder2.append(" check code|");
        localStringBuilder2.append((String)localObject2);
        LogUtility.c("DownloadManager_", localStringBuilder2.toString());
        bool = str2.equals(localObject2);
      }
      catch (IOException localIOException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("write code Exception|");
        ((StringBuilder)localObject2).append(localIOException.getMessage());
        LogUtility.c("DownloadManager_", ((StringBuilder)localObject2).toString());
        bool = false;
      }
      StringBuilder localStringBuilder1;
      if (bool)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("receive write code msg pkgName|");
        localStringBuilder1.append(str1);
        localStringBuilder1.append(" write code and check code suc");
        LogUtility.c("DownloadManager_", localStringBuilder1.toString());
        ((DownloadInfo)localObject1).D = 0;
        this.this$0.f((DownloadInfo)localObject1);
        this.this$0.a(4, (DownloadInfo)localObject1);
        this.this$0.a((DownloadInfo)localObject1, ((DownloadInfo)localObject1).E);
        StaticAnalyz.a("300", ((DownloadInfo)localObject1).h, ((DownloadInfo)localObject1).c, ((DownloadInfo)localObject1).F);
        if (((DownloadInfo)localObject1).w) {
          this.this$0.d((DownloadInfo)localObject1);
        }
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("receive write code msg pkgName|");
        localStringBuilder1.append(str1);
        localStringBuilder1.append(" write code or check code fail");
        LogUtility.c("DownloadManager_", localStringBuilder1.toString());
        ((DownloadInfo)localObject1).D = -20;
        ((DownloadInfo)localObject1).s = -2;
        this.this$0.f((DownloadInfo)localObject1);
        this.this$0.a((DownloadInfo)localObject1, ((DownloadInfo)localObject1).D, null);
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.21
 * JD-Core Version:    0.7.0.1
 */