package com.tencent.mobileqq.uniformdownload.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.util.SucDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;

public class UniformDownloadPkgInstallReceiver
  extends BroadcastReceiver
{
  private static UniformDownloadPkgInstallReceiver a = new UniformDownloadPkgInstallReceiver();
  private static IntentFilter b;
  
  public static void a(Context paramContext)
  {
    b = new IntentFilter();
    b.addDataScheme("package");
    b.addAction("android.intent.action.PACKAGE_ADDED");
    b.addAction("android.intent.action.PACKAGE_REPLACED");
    if (paramContext != null) {
      try
      {
        paramContext.registerReceiver(a, b);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void a(Context paramContext, SucDownloadInfo paramSucDownloadInfo)
  {
    if (paramSucDownloadInfo == null) {
      return;
    }
    if (FileUtil.b(paramSucDownloadInfo.c))
    {
      QbSdk.openFileWithQB(paramContext, paramSucDownloadInfo.c, "biz_src_jc_file");
      if (QLog.isDevelopLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("浏览器安装成功，准备打开文件:");
        paramContext.append(paramSucDownloadInfo.c);
        QLog.i("UniformDownloadPkgInstallReceiver", 1, paramContext.toString());
      }
    }
    if (paramSucDownloadInfo.d.containsKey("params_open_with_yyb"))
    {
      paramContext = paramSucDownloadInfo.d.getString("params_open_with_yyb", "");
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startAppStoreByTmast(paramContext, 2);
    }
    if (paramSucDownloadInfo.d.getBoolean("tbs_new_report", false))
    {
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).reportQQBrowserDownloadEvent("stat_download_installed_success");
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).reportQQBrowserDownloadEvent("stat_open_qb_success");
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] package operate broadcast. action:");
      localStringBuilder.append(str);
      localStringBuilder.append(" pkgName:");
      localStringBuilder.append(paramIntent);
      QLog.i("UniformDownloadPkgInstallReceiver", 1, localStringBuilder.toString());
    }
    ThreadManager.executeOnSubThread(new UniformDownloadPkgInstallReceiver.1(this, str, paramIntent, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadPkgInstallReceiver
 * JD-Core Version:    0.7.0.1
 */