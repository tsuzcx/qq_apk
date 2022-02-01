package com.tencent.mobileqq.wifi;

import android.content.Context;
import com.tencent.open.business.base.AppUtil;
import com.tencent.wifisdk.TMSDKCustomConfig.IInstaller;

final class FreeWifiHelper$8
  implements TMSDKCustomConfig.IInstaller
{
  public boolean installApp(Context paramContext, String paramString)
  {
    return AppUtil.a(paramContext, paramString, "biz_src_wifi");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.8
 * JD-Core Version:    0.7.0.1
 */