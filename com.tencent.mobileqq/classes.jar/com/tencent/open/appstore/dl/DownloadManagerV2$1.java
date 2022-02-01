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
    LogUtility.b("DownloadManagerV2", "receive get code finished pkgName|" + paramString1 + " versionCode|" + paramInt + " code|" + paramString2 + " extraData|" + paramBundle);
    Bundle localBundle = new Bundle();
    localBundle.putString("PackageName", paramString1);
    localBundle.putString("Code", paramString2);
    localBundle.putInt("VersionCode", paramInt);
    localBundle.putBoolean("IsSuccess", paramBoolean);
    localBundle.putAll(paramBundle);
    DownloadManagerV2.a(this.a, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.1
 * JD-Core Version:    0.7.0.1
 */