package com.tencent.mobileqq.uniformdownload.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.uniformdownload.filemanager.FileUtil;
import com.tencent.mobileqq.uniformdownload.filemanager.LocalTbsViewManager;
import com.tencent.mobileqq.uniformdownload.filemanager.QFileAppStorePromoteManager;
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
    if (paramContext != null) {}
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
  
  public void a(Context paramContext, SucDownloadInfo paramSucDownloadInfo)
  {
    if (paramSucDownloadInfo == null) {}
    do
    {
      return;
      if (FileUtil.b(paramSucDownloadInfo.b))
      {
        QbSdk.openFileWithQB(paramContext, paramSucDownloadInfo.b, "biz_src_jc_file");
        if (QLog.isDevelopLevel()) {
          QLog.i("UniformDownloadPkgInstallReceiver", 1, "浏览器安装成功，准备打开文件:" + paramSucDownloadInfo.b);
        }
      }
      if (paramSucDownloadInfo.a.containsKey("params_open_with_yyb")) {
        QFileAppStorePromoteManager.a(paramSucDownloadInfo.a.getString("params_open_with_yyb", ""), 2);
      }
    } while (!paramSucDownloadInfo.a.getBoolean("tbs_new_report", false));
    LocalTbsViewManager.a().a("stat_download_installed_success");
    LocalTbsViewManager.a().a("stat_open_qb_success");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.i("UniformDownloadPkgInstallReceiver", 1, "[UniformDL] package operate broadcast. action:" + str + " pkgName:" + paramIntent);
    }
    ThreadManager.executeOnSubThread(new UniformDownloadPkgInstallReceiver.1(this, str, paramIntent, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadPkgInstallReceiver
 * JD-Core Version:    0.7.0.1
 */