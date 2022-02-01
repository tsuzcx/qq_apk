package com.tencent.mobileqq.upgrade;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class UpgradeManager
  implements Manager
{
  private final QQAppInterface a;
  
  public UpgradeManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static UpgradeManager a(QQAppInterface paramQQAppInterface)
  {
    return (UpgradeManager)paramQQAppInterface.getManager(QQManagerFactory.UPGRADE_MANAGER);
  }
  
  public boolean a()
  {
    boolean bool;
    if (UpgradeController.a().b() == 4) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeManager", 2, new Object[] { "hasNewApkDownloaded: invoked. ", " hasDl: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean a(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper != null) && (paramUpgradeDetailWrapper.f != null) && (paramUpgradeDetailWrapper.b != null))
    {
      if (paramUpgradeDetailWrapper.f.dialog == null) {
        return false;
      }
      int i = SharedPreUtils.bT(this.a.getApp(), this.a.getCurrentUin());
      int j = paramUpgradeDetailWrapper.f.dialog.p;
      int k = paramUpgradeDetailWrapper.f.dialog.q;
      long l1 = SharedPreUtils.bU(this.a.getApp(), this.a.getCurrentUin());
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "needShowDownloadDialog: invoked. ", " downloadDialogMaxTimes: ", Integer.valueOf(j), " downloadDialogShownTimes: ", Integer.valueOf(i), " downloadDialogDayRate: ", Integer.valueOf(k), " downloadDialogShownTimestamp: ", Long.valueOf(l1), " now: ", Long.valueOf(l2) });
      }
      if (i >= j) {
        return false;
      }
      if (l2 - l1 >= k * 86400000L) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper != null) && (paramUpgradeDetailWrapper.f != null) && (paramUpgradeDetailWrapper.b != null))
    {
      if (paramUpgradeDetailWrapper.f.dialog == null) {
        return false;
      }
      int i = SharedPreUtils.bV(this.a.getApp(), this.a.getCurrentUin());
      int j = paramUpgradeDetailWrapper.f.dialog.r;
      int k = paramUpgradeDetailWrapper.f.dialog.s;
      long l1 = SharedPreUtils.bW(this.a.getApp(), this.a.getCurrentUin());
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "needShowInstallDialog: invoked. ", " installDialogMaxTimes: ", Integer.valueOf(j), " installDialogShownTimes: ", Integer.valueOf(i), " installDialogDayRate: ", Integer.valueOf(k), " installDialogShownTimestamp: ", Long.valueOf(l1), " now: ", Long.valueOf(l2) });
      }
      if (i >= j) {
        return false;
      }
      if (l2 - l1 >= k * 86400000L) {
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeManager
 * JD-Core Version:    0.7.0.1
 */