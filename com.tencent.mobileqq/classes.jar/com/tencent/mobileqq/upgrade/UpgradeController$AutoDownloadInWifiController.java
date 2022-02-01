package com.tencent.mobileqq.upgrade;

import android.content.Context;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class UpgradeController$AutoDownloadInWifiController
  implements INetEventHandler
{
  private Context jdField_a_of_type_AndroidContentContext;
  
  public UpgradeController$AutoDownloadInWifiController(UpgradeController paramUpgradeController)
  {
    this.jdField_a_of_type_AndroidContentContext = UpgradeController.a(paramUpgradeController);
  }
  
  public void a()
  {
    try
    {
      try
      {
        AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this);
      }
      finally
      {
        break label51;
      }
    }
    catch (Exception localException)
    {
      label17:
      label51:
      break label17;
    }
    if (AppNetConnInfo.isWifiConn()) {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController.c(true);
    } else if (QLog.isColorLevel()) {
      QLog.d("UpgradeConfigManager", 2, "start auto download but not in wifi, mark it");
    }
    return;
    throw localObject;
  }
  
  public void b()
  {
    try
    {
      try
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
      }
      finally
      {
        break label24;
      }
    }
    catch (Exception localException)
    {
      label14:
      label24:
      break label14;
    }
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController.c();
    return;
    throw localObject;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = NetworkUtil.getNetworkType(this.jdField_a_of_type_AndroidContentContext);
    if (i == 0)
    {
      if (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController)) {
        this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController.e();
      }
    }
    else
    {
      if (i == 1)
      {
        if (!UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController))
        {
          this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController.c(true);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController.d();
        return;
      }
      if ((i == 0) && (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController))) {
        this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.AutoDownloadInWifiController
 * JD-Core Version:    0.7.0.1
 */