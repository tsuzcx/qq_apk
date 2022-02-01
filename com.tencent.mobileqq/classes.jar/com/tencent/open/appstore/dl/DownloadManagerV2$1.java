package com.tencent.open.appstore.dl;

import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ApkGetCodeListener;

class DownloadManagerV2$1
  implements ApkGetCodeListener
{
  DownloadManagerV2$1(DownloadManagerV2 paramDownloadManagerV2) {}
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive get code finished pkgName|");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" versionCode|");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" code|");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" extraData|");
    ((StringBuilder)localObject).append(paramBundle);
    LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("PackageName", paramString1);
    ((Bundle)localObject).putString("Code", paramString2);
    ((Bundle)localObject).putInt("VersionCode", paramInt);
    ((Bundle)localObject).putBoolean("IsSuccess", paramBoolean);
    ((Bundle)localObject).putAll(paramBundle);
    DownloadManagerV2.a(this.a, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.1
 * JD-Core Version:    0.7.0.1
 */