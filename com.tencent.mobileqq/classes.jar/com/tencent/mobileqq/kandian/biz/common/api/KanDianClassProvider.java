package com.tencent.mobileqq.kandian.biz.common.api;

import android.util.Log;
import com.tencent.mobileqq.qroute.QRoute;

public class KanDianClassProvider
{
  public static Class a()
  {
    try
    {
      Class localClass = ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getReadInJoyDAUStatisticClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("KanDianClassProvider", "getReadInJoyDAUStatisticClass", localThrowable);
    }
    return null;
  }
  
  public static Class b()
  {
    try
    {
      Class localClass = ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getReadInJoyLogicManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("KanDianClassProvider", "getReadInJoyLogicManagerClass", localThrowable);
    }
    return null;
  }
  
  public static Class c()
  {
    try
    {
      Class localClass = ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getReadInJoySkinManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("KanDianClassProvider", "getReadInJoySkinManagerClass", localThrowable);
    }
    return null;
  }
  
  public static Class d()
  {
    try
    {
      Class localClass = ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getReadInJoyRefreshManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("KanDianClassProvider", "getReadInJoyRefreshManagerClass", localThrowable);
    }
    return null;
  }
  
  public static Class e()
  {
    try
    {
      Class localClass = ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getReadInJoyOperationManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("KanDianClassProvider", "getReadInJoyOperationManagerClass", localThrowable);
    }
    return null;
  }
  
  public static Class f()
  {
    try
    {
      Class localClass = ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getRIJUgcVideoPublishManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("KanDianClassProvider", "getRIJUgcVideoPublishManagerClass", localThrowable);
    }
    return null;
  }
  
  public static Class g()
  {
    try
    {
      Class localClass = ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getKandianSubscribeManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("KanDianClassProvider", "getKandianSubscribeManagerClass", localThrowable);
    }
    return null;
  }
  
  public static Class h()
  {
    try
    {
      Class localClass = ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getKanDianDailyManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("KanDianClassProvider", "getKanDianDailyManagerClass", localThrowable);
    }
    return null;
  }
  
  public static Class i()
  {
    try
    {
      Class localClass = ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getKanDianMergeManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("KanDianClassProvider", "getKanDianMergeManagerClass", localThrowable);
    }
    return null;
  }
  
  public static Class j()
  {
    try
    {
      Class localClass = ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getReadInJoyManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("KanDianClassProvider", "getReadInJoyManagerClass", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.KanDianClassProvider
 * JD-Core Version:    0.7.0.1
 */