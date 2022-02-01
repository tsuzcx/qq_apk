package com.tencent.mobileqq.mini.api;

import android.util.Log;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class QQMiniManager
{
  public static Entity createDeskTopAppEntity()
  {
    try
    {
      Entity localEntity = ((IMiniAppService)QRoute.api(IMiniAppService.class)).createDeskTopAppEntity();
      return localEntity;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Manager createMiniAppEntityManager(String paramString)
  {
    try
    {
      paramString = ((IMiniAppService)QRoute.api(IMiniAppService.class)).createMiniAppEntityManager(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("QQMiniManager", "", paramString);
    }
    return null;
  }
  
  public static AppRuntime createMiniAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    try
    {
      paramMobileQQ = ((IMiniAppService)QRoute.api(IMiniAppService.class)).createMiniAppInterface(paramMobileQQ, paramString);
      return paramMobileQQ;
    }
    catch (Throwable paramMobileQQ)
    {
      Log.e("QQMiniManager", "", paramMobileQQ);
    }
    return null;
  }
  
  public static Class getApkgConfigManagerClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getApkgConfigManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getAppBrandUIClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getAppBrandUIClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getDeskTopAppEntityClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getDeskTopAppEntityClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getDesktopCardEntityClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getDesktopCardEntityClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getDesktopDataManagerClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getDesktopDataManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getMiniAppEntityClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppEntityClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static String getMiniAppEntryHandlerClassName()
  {
    try
    {
      String str = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppEntryHandlerClass().getName();
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getMiniAppExposureManagerClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppExposureManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getMiniAppGameDebugSettingFragmentClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppGameDebugSettingFragmentClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getMiniAppLocalSearchManagerClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppLocalSearchManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getMiniAppSearchDataManagerClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppSearchDataManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getMiniAppUserAppInfoListManagerClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppUserAppInfoListManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
  
  public static Class getPublicFragmentActivityForMiniClass()
  {
    try
    {
      Class localClass = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getPublicFragmentActivityForMiniClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQMiniManager", "", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.QQMiniManager
 * JD-Core Version:    0.7.0.1
 */