package com.tencent.qcircle.cooperation.config;

import com.tencent.biz.richframework.delegate.IConfigDelegate;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFLog;

public class QCircleConfigHelper
{
  private static IConfigDelegate a;
  
  public static int a()
  {
    int i = a().getConfigValue("qqcircle", "qqcricle_max_crash_count", Integer.valueOf(2)).intValue();
    if (RFLog.isColorLevel()) {
      RFLog.e("QCircleConfigHelper", RFLog.USR, "SECONDARY_QQCIRCLE_DISABLE_PLUGIN:" + i);
    }
    return i;
  }
  
  public static long a()
  {
    return a().getConfigValue("qqcircle", "qqcircle_getplugininfo_time", Integer.valueOf(300000)).intValue();
  }
  
  private static IConfigDelegate a()
  {
    if (a == null) {}
    try
    {
      Class localClass = RFApplication.getDelegateImpl(IConfigDelegate.class);
      if (localClass != null) {
        a = (IConfigDelegate)localClass.newInstance();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        localInstantiationException.printStackTrace();
      }
    }
    return a;
  }
  
  public static boolean a()
  {
    int i = a().getConfigValue("qqcircle", "qqcircle_use_asset", Integer.valueOf(0)).intValue();
    if (RFLog.isColorLevel()) {
      RFLog.e("QCircleConfigHelper", RFLog.USR, "isUseAssetPlugin always:" + i);
    }
    return i == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qcircle.cooperation.config.QCircleConfigHelper
 * JD-Core Version:    0.7.0.1
 */