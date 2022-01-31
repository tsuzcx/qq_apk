package com.tencent.open.downloadnew;

import android.os.Bundle;
import android.text.TextUtils;
import bflp;
import bfmy;
import bfok;
import bhqd;
import java.io.File;
import java.io.IOException;

public class DownloadManager$21
  implements Runnable
{
  public DownloadManager$21(bfok parambfok, Bundle paramBundle) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo;
    try
    {
      String str1 = this.a.getString("PackageName");
      bflp.c("DownloadManager_", "receive write code msg pkgName|" + str1);
      if (str1 == null) {
        return;
      }
      localDownloadInfo = this.this$0.b(str1);
      if (localDownloadInfo == null)
      {
        bflp.c("DownloadManager_", "receive write code msg pkgName|" + str1 + " download info is null");
        return;
      }
    }
    catch (Exception localException)
    {
      bflp.c("DownloadManager_", "downloadSDKClient>>>", localException);
      return;
    }
    String str2 = this.a.getString("Code");
    bflp.c("DownloadManager_", "receive write code msg pkgName|" + localException + " code|" + str2);
    if (TextUtils.isEmpty(str2))
    {
      localDownloadInfo.a(4);
      localDownloadInfo.j = 0;
      this.this$0.e(localDownloadInfo);
      this.this$0.a(4, localDownloadInfo);
      this.this$0.a(localDownloadInfo, localDownloadInfo.jdField_c_of_type_Long);
      bfmy.a("300", localDownloadInfo.h, localDownloadInfo.jdField_c_of_type_JavaLangString, localDownloadInfo.o);
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
        bhqd.a((File)localObject, str2);
        localObject = bhqd.a((File)localObject);
        bflp.c("DownloadManager_", "receive write code msg pkgName|" + localException + " check code|" + (String)localObject);
        bool = str2.equals(localObject);
        if (bool)
        {
          bflp.c("DownloadManager_", "receive write code msg pkgName|" + localException + " write code and check code suc");
          localDownloadInfo.j = 0;
          this.this$0.e(localDownloadInfo);
          this.this$0.a(4, localDownloadInfo);
          this.this$0.a(localDownloadInfo, localDownloadInfo.jdField_c_of_type_Long);
          bfmy.a("300", localDownloadInfo.h, localDownloadInfo.jdField_c_of_type_JavaLangString, localDownloadInfo.o);
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
          bflp.c("DownloadManager_", "write code Exception|" + localIOException.getMessage());
          boolean bool = false;
        }
        bflp.c("DownloadManager_", "receive write code msg pkgName|" + localException + " write code or check code fail");
        localDownloadInfo.j = -20;
        localDownloadInfo.e = -2;
        this.this$0.e(localDownloadInfo);
        this.this$0.a(localDownloadInfo, localDownloadInfo.j, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.21
 * JD-Core Version:    0.7.0.1
 */