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
    if (UpgradeController.a().a() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "hasNewApkDownloaded: invoked. ", " hasDl: ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean a(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {}
    int i;
    int j;
    int k;
    long l1;
    long l2;
    do
    {
      return false;
      i = SharedPreUtils.aP(this.a.getApp(), this.a.getCurrentUin());
      j = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.c;
      k = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.d;
      l1 = SharedPreUtils.k(this.a.getApp(), this.a.getCurrentUin());
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "needShowDownloadDialog: invoked. ", " downloadDialogMaxTimes: ", Integer.valueOf(j), " downloadDialogShownTimes: ", Integer.valueOf(i), " downloadDialogDayRate: ", Integer.valueOf(k), " downloadDialogShownTimestamp: ", Long.valueOf(l1), " now: ", Long.valueOf(l2) });
      }
    } while ((i >= j) || (l2 - l1 < k * 86400000L));
    return true;
  }
  
  public boolean b(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {}
    int i;
    int j;
    int k;
    long l1;
    long l2;
    do
    {
      return false;
      i = SharedPreUtils.aQ(this.a.getApp(), this.a.getCurrentUin());
      j = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.e;
      k = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.f;
      l1 = SharedPreUtils.l(this.a.getApp(), this.a.getCurrentUin());
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "needShowInstallDialog: invoked. ", " installDialogMaxTimes: ", Integer.valueOf(j), " installDialogShownTimes: ", Integer.valueOf(i), " installDialogDayRate: ", Integer.valueOf(k), " installDialogShownTimestamp: ", Long.valueOf(l1), " now: ", Long.valueOf(l2) });
      }
    } while ((i >= j) || (l2 - l1 < k * 86400000L));
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeManager
 * JD-Core Version:    0.7.0.1
 */