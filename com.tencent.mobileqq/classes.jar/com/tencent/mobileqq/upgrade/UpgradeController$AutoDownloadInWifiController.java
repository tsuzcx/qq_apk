package com.tencent.mobileqq.upgrade;

import android.content.Context;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class UpgradeController$AutoDownloadInWifiController
  implements INetEventHandler
{
  private Context b;
  
  public UpgradeController$AutoDownloadInWifiController(UpgradeController paramUpgradeController)
  {
    this.b = UpgradeController.b(paramUpgradeController);
  }
  
  public void a()
  {
    try
    {
      try
      {
        AppNetConnInfo.registerNetChangeReceiver(this.b, this);
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
      this.a.c(true);
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
    this.a.g();
    return;
    throw localObject;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = NetworkUtil.getNetworkType(this.b);
    if (i == 0)
    {
      if (UpgradeController.d(this.a)) {
        this.a.i();
      }
    }
    else
    {
      if (i == 1)
      {
        if (!UpgradeController.d(this.a))
        {
          this.a.c(true);
          return;
        }
        this.a.h();
        return;
      }
      if ((i == 0) && (UpgradeController.d(this.a))) {
        this.a.i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.AutoDownloadInWifiController
 * JD-Core Version:    0.7.0.1
 */