package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.open.base.LogUtility;

class DownloadManager$19
  implements ApkGetCodeListener
{
  DownloadManager$19(DownloadManager paramDownloadManager) {}
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive get code finished pkgName|");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" versionCode|");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" code|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" extraData|");
    localStringBuilder.append(paramBundle);
    LogUtility.c("DownloadManager_", localStringBuilder.toString());
    paramBundle = new Bundle();
    paramBundle.putString("PackageName", paramString1);
    paramBundle.putString("Code", paramString2);
    paramBundle.putInt("VersionCode", paramInt);
    paramBundle.putBoolean("IsSuccess", paramBoolean);
    DownloadManager.a(this.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.19
 * JD-Core Version:    0.7.0.1
 */