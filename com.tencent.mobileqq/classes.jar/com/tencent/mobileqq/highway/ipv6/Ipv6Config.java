package com.tencent.mobileqq.highway.ipv6;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;

public class Ipv6Config
{
  public static final String SP_KEY_IPV6_STRATEGY_BDH = "ipv6_strategy_bdh";
  public static final String SP_KEY_IPV6_STRATEGY_CAD = "ipv6_strategy_cad";
  public static final String SP_KEY_IPV6_STRATEGY_RMD = "ipv6_strategy_rm_down";
  public static final int STRATEGY_FIRST_AS_MSF = 3;
  public static final int STRATEGY_V4_FIRST = 1;
  public static final int STRATEGY_V6_FIRST = 2;
  public static int sBdhStrategy;
  public static int sConnAttemptDelay;
  public static int sRMDownStrategy;
  
  static
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    sRMDownStrategy = localSharedPreferences.getInt("ipv6_strategy_rm_down", 0);
    sBdhStrategy = localSharedPreferences.getInt("ipv6_strategy_bdh", 0);
    sConnAttemptDelay = localSharedPreferences.getInt("ipv6_strategy_cad", 0);
    BdhLogUtil.LogEvent("E", "Ipv6Config.getCfgFromSP: sRMDownStrategy = " + sRMDownStrategy + ", sBdhStrategy = " + sBdhStrategy + ", sConnAttemptDelay = " + sConnAttemptDelay);
  }
  
  public static boolean isIpv6BDHFirst(HwEngine paramHwEngine)
  {
    boolean bool = true;
    if ((paramHwEngine != null) && (!paramHwEngine.ipv6Switch)) {
      BdhLogUtil.LogEvent("E", "Ipv6Config.isIpv6BDHFirst, hwEngine.ipv6Switch is false");
    }
    do
    {
      return false;
      if (sBdhStrategy == 2) {
        return true;
      }
    } while (sRMDownStrategy != 3);
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void updateCfgFromSrv(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    BdhLogUtil.LogEvent("E", "Ipv6Config.updateCfgFromSrv: rmDownStrategy = " + paramInt1 + ", bdhStrategy = " + paramInt2 + ", connAttemptDelay = " + paramInt3);
    sRMDownStrategy = paramInt1;
    sBdhStrategy = paramInt2;
    sConnAttemptDelay = paramInt3;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ipv6_strategy_rm_down", paramInt1);
    paramContext.putInt("ipv6_strategy_bdh", paramInt2);
    paramContext.putInt("ipv6_strategy_cad", paramInt3);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.ipv6.Ipv6Config
 * JD-Core Version:    0.7.0.1
 */