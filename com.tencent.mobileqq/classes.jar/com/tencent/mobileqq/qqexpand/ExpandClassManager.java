package com.tencent.mobileqq.qqexpand;

import android.util.Log;
import com.tencent.mobileqq.qqexpand.manager.IExpandClassManager;
import com.tencent.mobileqq.qroute.QRoute;

public class ExpandClassManager
{
  public static Class a()
  {
    try
    {
      Class localClass = ((IExpandClassManager)QRoute.api(IExpandClassManager.class)).getExpandManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ExpandTempleManager", "[getExpandManager]", localThrowable);
    }
    return null;
  }
  
  public static String a()
  {
    try
    {
      String str = ((IExpandClassManager)QRoute.api(IExpandClassManager.class)).getExpandHandlerClassName();
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ExpandTempleManager", "[getExpandHandlerClassName]", localThrowable);
    }
    return null;
  }
  
  public static Class b()
  {
    try
    {
      Class localClass = ((IExpandClassManager)QRoute.api(IExpandClassManager.class)).getExpandLimitChatManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ExpandTempleManager", "[getExpandLimitChatManagerClass]", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ExpandClassManager
 * JD-Core Version:    0.7.0.1
 */