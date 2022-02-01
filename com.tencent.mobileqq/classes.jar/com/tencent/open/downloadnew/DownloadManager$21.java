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
    DownloadInfo localDownloadInfo;
    try
    {
      String str1 = this.a.getString("PackageName");
      LogUtility.c("DownloadManager_", "receive write code msg pkgName|" + str1);
      if (str1 == null) {
        return;
      }
      localDownloadInfo = this.this$0.b(str1);
      if (localDownloadInfo == null)
      {
        LogUtility.c("DownloadManager_", "receive write code msg pkgName|" + str1 + " download info is null");
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
      return;
    }
    String str2 = this.a.getString("Code");
    LogUtility.c("DownloadManager_", "receive write code msg pkgName|" + localException + " code|" + str2);
    if (TextUtils.isEmpty(str2))
    {
      localDownloadInfo.a(4);
      localDownloadInfo.j = 0;
      this.this$0.e(localDownloadInfo);
      this.this$0.a(4, localDownloadInfo);
      this.this$0.a(localDownloadInfo, localDownloadInfo.jdField_c_of_type_Long);
      StaticAnalyz.a("300", localDownloadInfo.h, localDownloadInfo.jdField_c_of_type_JavaLangString, localDownloadInfo.o);
      if (localDownloadInfo.a) {
        this.this$0.c(localDownloadInfo);
      }
    }
    else
    {
      this.a.getInt("VersionCode");
      Object localObject = new File(localDownloadInfo.l);
      try
      {
        ApkExternalInfoTool.a((File)localObject, str2);
        localObject = ApkExternalInfoTool.a((File)localObject);
        LogUtility.c("DownloadManager_", "receive write code msg pkgName|" + localException + " check code|" + (String)localObject);
        bool = str2.equals(localObject);
        if (bool)
        {
          LogUtility.c("DownloadManager_", "receive write code msg pkgName|" + localException + " write code and check code suc");
          localDownloadInfo.j = 0;
          this.this$0.e(localDownloadInfo);
          this.this$0.a(4, localDownloadInfo);
          this.this$0.a(localDownloadInfo, localDownloadInfo.jdField_c_of_type_Long);
          StaticAnalyz.a("300", localDownloadInfo.h, localDownloadInfo.jdField_c_of_type_JavaLangString, localDownloadInfo.o);
          if (!localDownloadInfo.a) {
            return;
          }
          this.this$0.c(localDownloadInfo);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          LogUtility.c("DownloadManager_", "write code Exception|" + localIOException.getMessage());
          boolean bool = false;
        }
        LogUtility.c("DownloadManager_", "receive write code msg pkgName|" + localException + " write code or check code fail");
        localDownloadInfo.j = -20;
        localDownloadInfo.e = -2;
        this.this$0.e(localDownloadInfo);
        this.this$0.a(localDownloadInfo, localDownloadInfo.j, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.21
 * JD-Core Version:    0.7.0.1
 */