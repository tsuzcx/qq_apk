package com.tencent.mobileqq.transfile.ipv6;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.RichmediaIpv6ConifgBean;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.ipv6.Ipv6Flags;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;

public class IpStrategyFactory
{
  private static final String TAG = "IpStrategyFactory";
  
  public static IpStrategy createDownStrategy()
  {
    if (!getRichmediaIpv6Switch()) {
      return new Ipv4FirstStrategy();
    }
    Ipv6Flags localIpv6Flags = Ipv6Config.getFlags();
    if (localIpv6Flags.mRMDownStrategy == 2) {
      return new Ipv6FirstStrategy();
    }
    if (localIpv6Flags.mRMDownStrategy == 3) {
      return new IpFirstAsMSFStrategy(MsfServiceSdk.get().getConnectedIPFamily());
    }
    return new Ipv4FirstStrategy();
  }
  
  public static boolean createIpv6Flag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IpStrategyFactory", 2, "isIpv6Selected ");
    }
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    if (i == 2) {
      return true;
    }
    if (i == 3) {
      return isIpv6DownFirst();
    }
    return false;
  }
  
  private static boolean getRichmediaIpv6Switch()
  {
    RichmediaIpv6ConifgBean localRichmediaIpv6ConifgBean = (RichmediaIpv6ConifgBean)QConfigManager.a().a(538);
    if (localRichmediaIpv6ConifgBean != null) {
      return localRichmediaIpv6ConifgBean.c;
    }
    return false;
  }
  
  private static boolean isIpv6DownFirst()
  {
    boolean bool1 = getRichmediaIpv6Switch();
    boolean bool2 = false;
    if (!bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IpStrategyFactory", 2, "isIpv6DownFirst, getRichmediaIpv6Switch is false");
      }
      return false;
    }
    if (Ipv6Config.getFlags().mRMDownStrategy == 2) {
      return true;
    }
    bool1 = bool2;
    if (Ipv6Config.getFlags().mRMDownStrategy == 3)
    {
      bool1 = bool2;
      if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ipv6.IpStrategyFactory
 * JD-Core Version:    0.7.0.1
 */