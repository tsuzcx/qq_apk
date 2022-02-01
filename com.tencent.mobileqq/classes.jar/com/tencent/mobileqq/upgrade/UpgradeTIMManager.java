package com.tencent.mobileqq.upgrade;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class UpgradeTIMManager
  implements INetInfoHandler, Manager
{
  private static final String jdField_a_of_type_JavaLangString;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private OfflineDownloader jdField_a_of_type_ComTencentBizCommonOfflineUtilOfflineDownloader;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private UpgradeTIMManager.DownloadTask jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask;
  private UpgradeTIMWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper;
  private File jdField_a_of_type_JavaIoFile;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("tim");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public UpgradeTIMManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizCommonOfflineUtilOfflineDownloader = new OfflineDownloader();
    this.jdField_a_of_type_JavaIoFile = new File(jdField_a_of_type_JavaLangString, "tim.apk");
  }
  
  private void a()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask = new UpgradeTIMManager.DownloadTask(this, paramString1, paramString2);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask, 5, null, true);
    a();
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      long l = this.jdField_a_of_type_JavaIoFile.lastModified();
      if ((System.currentTimeMillis() - l) / 86400000L > 14L)
      {
        this.jdField_a_of_type_JavaIoFile.delete();
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b(QQAppInterface paramQQAppInterface, UpgradeTIMWrapper paramUpgradeTIMWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMManager |showUpgradeInfo");
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.obtainMessage(1134045, paramUpgradeTIMWrapper).sendToTarget();
    }
  }
  
  private void c()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008A48", "0X8008A48", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      PackageInfo localPackageInfo = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 64);
      if (localPackageInfo != null)
      {
        if (!"com.tencent.tim".equals(localPackageInfo.packageName)) {
          this.jdField_a_of_type_JavaIoFile.delete();
        }
      }
      else {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
    }
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask = null;
    b();
    UpgradeTIMWrapper localUpgradeTIMWrapper = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper;
    if (localUpgradeTIMWrapper != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localUpgradeTIMWrapper);
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    boolean bool = a();
    int j = 0;
    int i = j;
    if (bool)
    {
      i = j;
      if (((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).openApk(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()) == 0) {
        i = 1;
      }
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeTIMManager", 2, "jumpToDownloadTIM| no existing apk file, download.");
      }
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_operation_bar", true);
      paramContext.startActivity(localIntent);
      paramContext = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask;
      if (paramContext != null)
      {
        UpgradeTIMManager.DownloadTask.a(paramContext);
        this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask = null;
      }
      b();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, UpgradeTIMWrapper paramUpgradeTIMWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo, with wrapper");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper = paramUpgradeTIMWrapper;
      return;
    }
    if (a())
    {
      b(paramQQAppInterface, paramUpgradeTIMWrapper);
      return;
    }
    if (!NetworkUtil.isWifiConnected(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo, wifi not connected...");
      }
      b(paramQQAppInterface, paramUpgradeTIMWrapper);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper = paramUpgradeTIMWrapper;
    a(paramUpgradeTIMWrapper.c, this.jdField_a_of_type_JavaIoFile.getPath());
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask != null) {
      return;
    }
    if (a()) {
      return;
    }
    if (NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
      a(paramString, this.jdField_a_of_type_JavaIoFile.getPath());
    }
  }
  
  public void onDestroy()
  {
    b();
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, resume download");
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask;
    if (paramString != null) {
      UpgradeTIMManager.DownloadTask.b(paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetNone2Mobile, pause download");
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask;
    if (paramString != null) {
      UpgradeTIMManager.DownloadTask.a(paramString);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, resume download");
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask;
    if (paramString != null) {
      UpgradeTIMManager.DownloadTask.b(paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2Mobile, pause download");
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask;
    if (paramString != null) {
      UpgradeTIMManager.DownloadTask.a(paramString);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, pause download");
    }
    UpgradeTIMManager.DownloadTask localDownloadTask = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMManager$DownloadTask;
    if (localDownloadTask != null) {
      UpgradeTIMManager.DownloadTask.a(localDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTIMManager
 * JD-Core Version:    0.7.0.1
 */