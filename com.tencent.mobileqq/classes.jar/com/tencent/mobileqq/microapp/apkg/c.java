package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import Wallet.GetMiniAppRsp;
import android.os.Bundle;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

final class c
  implements BusinessObserver
{
  c(ApkgConfigManager paramApkgConfigManager, ApkgConfigManager.a parama, LaunchParam paramLaunchParam) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApkgConfigManager", 2, "fail get rsp:");
      }
      if (this.a == null) {
        return;
      }
      this.a.onResult(-1, null, null, "rsp is unsuccess");
      return;
    }
    catch (Exception paramBundle)
    {
      StringBuilder localStringBuilder;
      paramBundle.printStackTrace();
    }
    paramBundle = (GetMiniAppRsp)paramBundle.getSerializable("rsp");
    if (paramBundle != null)
    {
      if (paramBundle.err_code == 0)
      {
        if ((paramBundle.apkg_config_list != null) && (paramBundle.apkg_config_list.size() > 0) && (paramBundle.apkg_config_list.get(0) != null) && (((ApkgConfig)paramBundle.apkg_config_list.get(0)).isValid()))
        {
          ApkgConfigManager.access$000(this.c).a(paramBundle.apkg_config_list);
          if (this.a != null) {
            this.a.onResult(0, new MiniAppConfig((ApkgConfig)paramBundle.apkg_config_list.get(0), this.c.getBaseLibInfo()), null, null);
          }
        }
        else if (this.a != null)
        {
          this.a.onResult(-1, null, null, "rsp list not contain valid elem");
        }
      }
      else
      {
        if (paramBundle.isRemoveLocalConfig()) {
          ApkgConfigManager.access$000(this.c).a(this.b);
        }
        if (this.a != null) {
          this.a.onResult(paramBundle.err_code, null, paramBundle.getErrTips(), null);
        }
      }
    }
    else if (this.a != null) {
      this.a.onResult(-1, null, null, "rsp is null");
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNewestConfig GetMiniAppRsp|");
      localStringBuilder.append(paramBundle);
      QLog.d("ApkgConfigManager", 2, localStringBuilder.toString());
      return;
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.c
 * JD-Core Version:    0.7.0.1
 */