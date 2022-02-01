package com.tencent.mobileqq.upgrade.activity;

import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeDetailActivity$JsCover
  extends JsBridge.JsHandler
{
  protected UpgradeDetailActivity$JsCover(UpgradeDetailActivity paramUpgradeDetailActivity) {}
  
  public String getApkName()
  {
    return UpgradeDetailActivity.a(this.a);
  }
  
  public long getApkSize()
  {
    return UpgradeDetailActivity.c(this.a);
  }
  
  public String getApkVersion()
  {
    return UpgradeDetailActivity.b(this.a);
  }
  
  public int getDownloadState()
  {
    return UpgradeController.a().b();
  }
  
  public long getUpgradeTime()
  {
    return UpgradeDetailActivity.d(this.a).b.iNewTimeStamp;
  }
  
  public int installApk()
  {
    UpgradeController.a().a(this.a);
    return 0;
  }
  
  public int pauseDownload()
  {
    UpgradeController.a().i();
    return 0;
  }
  
  public int resumeDownload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("preLoad_configServlet", 2, "resume download from web, mark it.");
    }
    UpgradeController.a().h();
    return 0;
  }
  
  public int startDownload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("preLoad_configServlet", 2, "start download from web, mark it.");
    }
    UpgradeDetailActivity.a(this.a, true);
    return 0;
  }
  
  public int stopDownload()
  {
    UpgradeController.a().g();
    return 0;
  }
  
  public int tipsLoadComplete()
  {
    QLog.d("Hyim", 2, "loadTipsComplete");
    this.a.d = true;
    int i = getDownloadState();
    this.a.a(i, UpgradeController.a());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity.JsCover
 * JD-Core Version:    0.7.0.1
 */