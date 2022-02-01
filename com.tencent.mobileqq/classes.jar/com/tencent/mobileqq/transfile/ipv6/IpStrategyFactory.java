package com.tencent.mobileqq.transfile.ipv6;

import apub;
import aqcq;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.ipv6.Ipv6Flags;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;

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
      QLog.d("IpStrategyFactory", 0, "isIpv6Selected ");
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
    aqcq localaqcq = (aqcq)apub.a().a(538);
    if (localaqcq != null) {
      return localaqcq.c;
    }
    return false;
  }
  
  private static boolean isIpv6DownFirst()
  {
    boolean bool = true;
    if (!getRichmediaIpv6Switch()) {
      if (QLog.isColorLevel()) {
        QLog.d("IpStrategyFactory", 0, "isIpv6DownFirst, getRichmediaIpv6Switch is false");
      }
    }
    do
    {
      return false;
      if (Ipv6Config.getFlags().mRMDownStrategy == 2) {
        return true;
      }
    } while (Ipv6Config.getFlags().mRMDownStrategy != 3);
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ipv6.IpStrategyFactory
 * JD-Core Version:    0.7.0.1
 */