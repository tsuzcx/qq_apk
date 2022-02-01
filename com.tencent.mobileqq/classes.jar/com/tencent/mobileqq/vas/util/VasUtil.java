package com.tencent.mobileqq.vas.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VasUtil
{
  public static AppInterface a()
  {
    return (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static IVasDepTemp a()
  {
    return (IVasDepTemp)QRoute.api(IVasDepTemp.class);
  }
  
  @Deprecated
  public static IVasService a()
  {
    return (IVasService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "all");
  }
  
  public static IVasSingedApi a(AppRuntime paramAppRuntime)
  {
    return (IVasSingedApi)paramAppRuntime.getRuntimeService(IVasSingedApi.class, "all");
  }
  
  public static String a()
  {
    if (MobileQQ.sMobileQQ == null) {
      return "";
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {
      return "";
    }
    String str = ((AppRuntime)localObject).getCurrentUin();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public static AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.VasUtil
 * JD-Core Version:    0.7.0.1
 */