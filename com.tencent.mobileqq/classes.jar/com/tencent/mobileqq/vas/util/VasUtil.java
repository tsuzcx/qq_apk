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
  @Deprecated
  public static IVasService a()
  {
    return (IVasService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "all");
  }
  
  public static IVasService a(AppRuntime paramAppRuntime)
  {
    return (IVasService)paramAppRuntime.getRuntimeService(IVasService.class, "all");
  }
  
  public static IVasDepTemp b()
  {
    return (IVasDepTemp)QRoute.api(IVasDepTemp.class);
  }
  
  public static IVasSingedApi b(AppRuntime paramAppRuntime)
  {
    return (IVasSingedApi)paramAppRuntime.getRuntimeService(IVasSingedApi.class, "all");
  }
  
  public static AppRuntime c()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static AppInterface d()
  {
    return (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static String e()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.VasUtil
 * JD-Core Version:    0.7.0.1
 */