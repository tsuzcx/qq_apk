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
  private static final String a;
  private OfflineDownloader b;
  private File c;
  private UpgradeTIMManager.DownloadTask d;
  private QQAppInterface e;
  private UpgradeTIMWrapper f;
  private Handler g = new Handler(Looper.getMainLooper());
  private boolean h;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("tim");
    a = localStringBuilder.toString();
  }
  
  public UpgradeTIMManager(QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
    this.b = new OfflineDownloader();
    this.c = new File(a, "tim.apk");
  }
  
  private void a()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this);
    this.h = true;
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.d = new UpgradeTIMManager.DownloadTask(this, paramString1, paramString2);
    ThreadManager.post(this.d, 5, null, true);
    a();
  }
  
  private void b()
  {
    if (!this.h) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    this.h = false;
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
  
  private boolean c()
  {
    if (this.c.exists())
    {
      long l = this.c.lastModified();
      if ((System.currentTimeMillis() - l) / 86400000L > 14L)
      {
        this.c.delete();
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void d()
  {
    ReportController.b(this.e, "CliOper", "", "", "0X8008A48", "0X8008A48", 0, 0, "", "", "", "");
    if (this.c.exists())
    {
      PackageInfo localPackageInfo = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(this.c.getAbsolutePath(), 64);
      if (localPackageInfo != null)
      {
        if (!"com.tencent.tim".equals(localPackageInfo.packageName)) {
          this.c.delete();
        }
      }
      else {
        this.c.delete();
      }
    }
    e();
  }
  
  private void e()
  {
    this.d = null;
    b();
    UpgradeTIMWrapper localUpgradeTIMWrapper = this.f;
    if (localUpgradeTIMWrapper != null) {
      b(this.e, localUpgradeTIMWrapper);
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    boolean bool = c();
    int j = 0;
    int i = j;
    if (bool)
    {
      i = j;
      if (((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).openApk(this.c.getAbsolutePath()) == 0) {
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
      paramContext = this.d;
      if (paramContext != null)
      {
        UpgradeTIMManager.DownloadTask.a(paramContext);
        this.d = null;
      }
      b();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, UpgradeTIMWrapper paramUpgradeTIMWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo, with wrapper");
    }
    if (this.d != null)
    {
      this.f = paramUpgradeTIMWrapper;
      return;
    }
    if (c())
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
    this.f = paramUpgradeTIMWrapper;
    a(paramUpgradeTIMWrapper.c, this.c.getPath());
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo");
    }
    if (this.d != null) {
      return;
    }
    if (c()) {
      return;
    }
    if (NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
      a(paramString, this.c.getPath());
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
    paramString = this.d;
    if (paramString != null) {
      UpgradeTIMManager.DownloadTask.b(paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetNone2Mobile, pause download");
    }
    paramString = this.d;
    if (paramString != null) {
      UpgradeTIMManager.DownloadTask.a(paramString);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, resume download");
    }
    paramString = this.d;
    if (paramString != null) {
      UpgradeTIMManager.DownloadTask.b(paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2Mobile, pause download");
    }
    paramString = this.d;
    if (paramString != null) {
      UpgradeTIMManager.DownloadTask.a(paramString);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, pause download");
    }
    UpgradeTIMManager.DownloadTask localDownloadTask = this.d;
    if (localDownloadTask != null) {
      UpgradeTIMManager.DownloadTask.a(localDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTIMManager
 * JD-Core Version:    0.7.0.1
 */