package com.tencent.mobileqq.highway.ipv6;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class Ipv6Config
{
  public static final String SP_KEY_IPV6_STRATEGY_BDH = "ipv6_strategy_bdh";
  public static final String SP_KEY_IPV6_STRATEGY_CAD = "ipv6_strategy_cad";
  public static final String SP_KEY_IPV6_STRATEGY_RMD = "ipv6_strategy_rm_down";
  public static final int STRATEGY_FIRST_AS_MSF = 3;
  public static final int STRATEGY_V4_FIRST = 1;
  public static final int STRATEGY_V6_FIRST = 2;
  private static volatile Ipv6Flags sIpv6Flags;
  
  public static Ipv6Flags getFlags()
  {
    try
    {
      if (sIpv6Flags == null) {
        sIpv6Flags = readFromSP();
      }
      Ipv6Flags localIpv6Flags = sIpv6Flags;
      return localIpv6Flags;
    }
    finally {}
  }
  
  private static void persistCfg(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ipv6_strategy_rm_down", paramInt1);
    paramContext.putInt("ipv6_strategy_bdh", paramInt2);
    paramContext.putInt("ipv6_strategy_cad", paramInt3);
    paramContext.commit();
  }
  
  private static Ipv6Flags readFromSP()
  {
    Ipv6Flags localIpv6Flags = new Ipv6Flags();
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    localIpv6Flags.mRMDownStrategy = ((SharedPreferences)localObject).getInt("ipv6_strategy_rm_down", 0);
    localIpv6Flags.mBdhStrategy = ((SharedPreferences)localObject).getInt("ipv6_strategy_bdh", 0);
    localIpv6Flags.mConnAttemptDelay = ((SharedPreferences)localObject).getInt("ipv6_strategy_cad", 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("readFromSP: sRMDownStrategy = ");
    ((StringBuilder)localObject).append(localIpv6Flags.mRMDownStrategy);
    ((StringBuilder)localObject).append(", sBdhStrategy = ");
    ((StringBuilder)localObject).append(localIpv6Flags.mBdhStrategy);
    ((StringBuilder)localObject).append(", sConnAttemptDelay = ");
    ((StringBuilder)localObject).append(localIpv6Flags.mConnAttemptDelay);
    BdhLogUtil.LogEvent("E", ((StringBuilder)localObject).toString());
    return localIpv6Flags;
  }
  
  public static void updateCfgFromSrv(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Ipv6Config.updateCfgFromSrv: rmDownStrategy = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", bdhStrategy = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", connAttemptDelay = ");
      localStringBuilder.append(paramInt3);
      BdhLogUtil.LogEvent("E", localStringBuilder.toString());
      sIpv6Flags = new Ipv6Flags(paramInt1, paramInt2, paramInt3);
      persistCfg(paramContext, paramInt1, paramInt2, paramInt3);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.ipv6.Ipv6Config
 * JD-Core Version:    0.7.0.1
 */