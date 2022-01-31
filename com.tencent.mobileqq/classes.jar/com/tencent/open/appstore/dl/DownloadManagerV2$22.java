package com.tencent.open.appstore.dl;

import android.os.Bundle;
import android.text.TextUtils;
import bfkr;
import bflg;
import bflp;
import bfoh;
import bhqd;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import java.io.IOException;

public class DownloadManagerV2$22
  implements Runnable
{
  public DownloadManagerV2$22(bfkr parambfkr, Bundle paramBundle) {}
  
  public void run()
  {
    String str1;
    try
    {
      Object localObject1 = this.a.getString(bfoh.a);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      localObject1 = this.this$0.a((String)localObject1);
      str1 = this.a.getString("PackageName");
      if (localObject1 == null)
      {
        bflp.e("DownloadManagerV2", "[writeApkCodeAsync]  pkgName=" + str1 + " download info is null");
        return;
      }
    }
    catch (Exception localException)
    {
      bflp.c("DownloadManagerV2", "[writeApkCodeAsync] >>>", localException);
      return;
    }
    String str2 = this.a.getString("Code");
    bflp.b("DownloadManagerV2", "[writeApkCodeAsync] pkgName=" + str1 + ", code=" + str2);
    if (TextUtils.isEmpty(str2))
    {
      localException.j = 0;
      localException.a(4);
      this.this$0.c(localException);
      this.this$0.a(4, localException);
      this.this$0.a(localException, localException.c);
      bflp.b("AppCenterReporter", "from:[writeApkCodeAsync] code is empty");
      bflg.b(localException);
      if (localException.a) {
        this.this$0.a(localException, false);
      }
    }
    else
    {
      this.a.getInt("VersionCode");
      Object localObject2 = new File(localException.l);
      try
      {
        bhqd.a((File)localObject2, str2);
        localObject2 = bhqd.a((File)localObject2);
        bflp.b("DownloadManagerV2", "[writeApkCodeAsync] pkgName=" + str1 + ",check code=" + (String)localObject2);
        bool = str2.equals(localObject2);
        if (bool)
        {
          bflp.b("DownloadManagerV2", "[writeApkCodeAsync]  pkgName=" + str1 + " write code and check code suc");
          localException.j = 0;
          this.this$0.c(localException);
          this.this$0.a(4, localException);
          this.this$0.a(localException, localException.c);
          bflp.b("AppCenterReporter", "from:[writeApkCodeAsync] APK_WRITE_CODE_SUC");
          bflg.b(localException);
          if (!localException.a) {
            return;
          }
          this.this$0.a(localException, false);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          bflp.b("DownloadManagerV2", "[writeApkCodeAsync] Exception=" + localIOException.getMessage());
          boolean bool = false;
        }
        bflp.b("DownloadManagerV2", "[writeApkCodeAsync] pkgName=" + str1 + " write code or check code fail");
        localException.j = -20;
        localException.a(-2);
        this.this$0.c(localException);
        bfkr.a(this.this$0, localException, localException.j, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.22
 * JD-Core Version:    0.7.0.1
 */