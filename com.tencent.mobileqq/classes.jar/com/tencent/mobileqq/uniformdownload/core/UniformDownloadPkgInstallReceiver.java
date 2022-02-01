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
  private static IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private static UniformDownloadPkgInstallReceiver jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadPkgInstallReceiver = new UniformDownloadPkgInstallReceiver();
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
    jdField_a_of_type_AndroidContentIntentFilter.addDataScheme("package");
    jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    if (paramContext != null) {
      try
      {
        paramContext.registerReceiver(jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadPkgInstallReceiver, jdField_a_of_type_AndroidContentIntentFilter);
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
    if (FileUtil.a(paramSucDownloadInfo.b))
    {
      QbSdk.openFileWithQB(paramContext, paramSucDownloadInfo.b, "biz_src_jc_file");
      if (QLog.isDevelopLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("浏览器安装成功，准备打开文件:");
        paramContext.append(paramSucDownloadInfo.b);
        QLog.i("UniformDownloadPkgInstallReceiver", 1, paramContext.toString());
      }
    }
    if (paramSucDownloadInfo.a.containsKey("params_open_with_yyb"))
    {
      paramContext = paramSucDownloadInfo.a.getString("params_open_with_yyb", "");
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startAppStoreByTmast(paramContext, 2);
    }
    if (paramSucDownloadInfo.a.getBoolean("tbs_new_report", false))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadPkgInstallReceiver
 * JD-Core Version:    0.7.0.1
 */