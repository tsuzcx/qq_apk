package com.tencent.mobileqq.download.unite.core;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class InstallMonitor
{
  public static InstallMonitor a()
  {
    return InstallMonitor.SingletonHolder.a();
  }
  
  private static String a(Uri paramUri)
  {
    if (paramUri == null) {
      return "";
    }
    paramUri = paramUri.getPath();
    if ((paramUri != null) && (paramUri.startsWith("/external_files")))
    {
      paramUri = paramUri.replaceFirst("/external_files", "");
      QLog.d("[UniteDownload] InstallMonitor", 2, new Object[] { "[path] getFilePathFromUri: invoked. ", " realPath: ", paramUri });
      return paramUri;
    }
    return "";
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ReportHelperKt.a("0X800B53F", 0, "", paramString);
      if (!paramBoolean) {
        ReportHelperKt.a("0X800B540", 0, "", paramString);
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!paramString3.endsWith(".apk")) {}
    String str;
    do
    {
      return false;
      str = MD5.a(new File(paramString3));
      QLog.d("[UniteDownload] InstallMonitor", 2, new Object[] { "[check] validApkMd5: invoked. ", " actualMd5: ", str, " source: ", paramString2, " apkPath: ", paramString3 });
      paramString1 = UniteDownloadDbOperator.a().a(paramString1, paramString2);
    } while (paramString1 == null);
    return a(str, paramString1);
  }
  
  private boolean a(String paramString, List<UniteDownloadEntity> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((UniteDownloadEntity)paramList.next()).apkMd5;
      QLog.d("[UniteDownload] InstallMonitor", 2, new Object[] { "[check] containsValidEntity: invoked. ", " expectedApkMd5: ", str, " actualMd5: ", paramString });
      if ((paramString != null) && (paramString.equals(str))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public void a(String paramString, Intent paramIntent)
  {
    String str2 = paramIntent.getType();
    String str1 = paramIntent.getStringExtra("big_brother_source_key");
    paramIntent = paramIntent.getData();
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] InstallMonitor", 2, new Object[] { "[check] monitorInstallIntent: invoked. ", " intentType: ", str2, " source: ", str1, " uriData: ", paramIntent });
    }
    if ("application/vnd.android.package-archive".equals(str2))
    {
      paramIntent = a(paramIntent);
      str2 = ((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).getApkName(paramIntent);
      QLog.d("[UniteDownload] InstallMonitor", 2, new Object[] { "[path] monitorInstallIntent: invoked. ", " currentInstallApkPath: ", paramIntent });
      if (paramIntent.endsWith(".apk")) {
        ThreadManager.excute(new InstallMonitor.1(this, paramString, str1, paramIntent, str2), 32, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.core.InstallMonitor
 * JD-Core Version:    0.7.0.1
 */