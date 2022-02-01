package com.tencent.mobileqq.nearby;

import android.util.Log;
import com.tencent.mobileqq.nearby.api.INearbyService;
import com.tencent.mobileqq.qroute.QRoute;

public class QQNearbyManager
{
  public static Class a()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getWerewolvesDataManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getWerewolvesDataManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class b()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyPeopleProfileActivityClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyPeopleProfileActivityClass]", localThrowable);
    }
    return null;
  }
  
  public static Class c()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyMomentManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyMomentManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class d()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyHandlerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyHandlerClass]", localThrowable);
    }
    return null;
  }
  
  public static int e()
  {
    try
    {
      int i = ((INearbyService)QRoute.api(INearbyService.class)).getQQNearbyFactoryCountManager();
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getQQNearbyFactoryCountManager]", localThrowable);
    }
    return 0;
  }
  
  public static Class f()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyAlumniServletClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyAlumniServletClass]", localThrowable);
    }
    return null;
  }
  
  public static Class g()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyProxyClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyProxyClass]", localThrowable);
    }
    return null;
  }
  
  public static Class h()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getMiniCardManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getMiniCardManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class i()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyFaceScoreManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyFaceScoreManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class j()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyCardManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyCardManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class k()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyGeneralManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyGeneralManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class l()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getLocalRedTouchManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getLocalRedTouchManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class m()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyLikeLimitManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyLikeLimitManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class n()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getSmallVideoFragmentClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getSmallVideoFragmentClass]", localThrowable);
    }
    return null;
  }
  
  public static Class o()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getDynamicNowManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getDynamicNowManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class p()
  {
    try
    {
      Class localClass = ((INearbyService)QRoute.api(INearbyService.class)).getGroupVideoManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getGroupVideoManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static String q()
  {
    try
    {
      String str = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyRelevantHandlerClassName();
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyRelevantHandlerClass]", localThrowable);
    }
    return null;
  }
  
  public static String r()
  {
    try
    {
      String str = ((INearbyService)QRoute.api(INearbyService.class)).getNearbyCardHandlerClassName();
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNearbyCardHandlerClassName]", localThrowable);
    }
    return null;
  }
  
  public static String s()
  {
    try
    {
      String str = ((INearbyService)QRoute.api(INearbyService.class)).getHuayangPluginNewDownloaderClassName();
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getHuayangPluginNewDownloaderClassName]", localThrowable);
    }
    return null;
  }
  
  public static String t()
  {
    try
    {
      String str = ((INearbyService)QRoute.api(INearbyService.class)).getHuayangPluginLauncherClassName();
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getHuayangPluginLauncherClassName]", localThrowable);
    }
    return null;
  }
  
  public static String u()
  {
    try
    {
      String str = ((INearbyService)QRoute.api(INearbyService.class)).getNowChannerHandlerV2ClassName();
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("QQNearbyManager", "[getNowChannerHandlerV2ClassName]", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.QQNearbyManager
 * JD-Core Version:    0.7.0.1
 */