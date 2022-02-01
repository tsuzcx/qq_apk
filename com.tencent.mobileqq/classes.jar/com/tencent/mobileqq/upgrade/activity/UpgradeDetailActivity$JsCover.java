package com.tencent.mobileqq.upgrade.activity;

import avnl;
import bgdt;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeDetailActivity$JsCover
  extends avnl
{
  protected UpgradeDetailActivity$JsCover(UpgradeDetailActivity paramUpgradeDetailActivity) {}
  
  public String getApkName()
  {
    return UpgradeDetailActivity.a(this.a);
  }
  
  public long getApkSize()
  {
    return UpgradeDetailActivity.a(this.a);
  }
  
  public String getApkVersion()
  {
    return UpgradeDetailActivity.b(this.a);
  }
  
  public int getDownloadState()
  {
    return bgdt.a().a();
  }
  
  public long getUpgradeTime()
  {
    return UpgradeDetailActivity.a(this.a).a.iNewTimeStamp;
  }
  
  public int installApk()
  {
    bgdt.a().a(this.a);
    return 0;
  }
  
  public int pauseDownload()
  {
    bgdt.a().e();
    return 0;
  }
  
  public int resumeDownload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("preLoad_configServlet", 2, "resume download from web, mark it.");
    }
    bgdt.a().d();
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
    bgdt.a().c();
    return 0;
  }
  
  public int tipsLoadComplete()
  {
    QLog.d("Hyim", 2, "loadTipsComplete");
    this.a.a = true;
    int i = getDownloadState();
    this.a.a(i, bgdt.a());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity.JsCover
 * JD-Core Version:    0.7.0.1
 */