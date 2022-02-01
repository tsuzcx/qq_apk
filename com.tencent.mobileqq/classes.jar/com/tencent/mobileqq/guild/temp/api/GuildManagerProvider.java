package com.tencent.mobileqq.guild.temp.api;

import android.util.Log;
import com.tencent.mobileqq.qroute.QRoute;

public class GuildManagerProvider
{
  public static Class a()
  {
    try
    {
      Class localClass = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildPngFrameManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("GuildManagerProvider", "[getGuildPngFrameManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Object a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    try
    {
      paramObject1 = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildAioMsgNavigateAtMe(paramObject1, paramObject2, paramObject3);
      return paramObject1;
    }
    catch (Throwable paramObject1)
    {
      Log.e("GuildManagerProvider", "[getNewGuildAioMsgNavigateAtMe]", paramObject1);
    }
    return null;
  }
  
  public static boolean a(Object paramObject)
  {
    try
    {
      boolean bool = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildAioMsgNavigateBar(paramObject);
      return bool;
    }
    catch (Throwable paramObject)
    {
      Log.e("GuildManagerProvider", "[judgeIsGuildAioMsgNavigateBar]", paramObject);
    }
    return false;
  }
  
  public static Class b()
  {
    try
    {
      Class localClass = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildAioNavigateBarManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("GuildManagerProvider", "[getGuildAioNavigateBarManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Object b(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    try
    {
      paramObject1 = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildAioMsgNavigateUnRead(paramObject1, paramObject2, paramObject3);
      return paramObject1;
    }
    catch (Throwable paramObject1)
    {
      Log.e("GuildManagerProvider", "[getNewGuildAioMsgNavigateUnRead]", paramObject1);
    }
    return null;
  }
  
  public static Object c()
  {
    try
    {
      Object localObject = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildRoamMessageProcessorCallback();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e("GuildManagerProvider", "[getNewGuildRoamMessageProcessorCallback]", localThrowable);
    }
    return null;
  }
  
  public static Object c(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    try
    {
      paramObject1 = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildAioMsgNavigateReply(paramObject1, paramObject2, paramObject3);
      return paramObject1;
    }
    catch (Throwable paramObject1)
    {
      Log.e("GuildManagerProvider", "[getNewGuildAioMsgNavigateReply]", paramObject1);
    }
    return null;
  }
  
  public static Object d()
  {
    try
    {
      Object localObject = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildOfflineMessageProcessorCallback();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e("GuildManagerProvider", "[getNewGuildOfflineMessageProcessorCallback]", localThrowable);
    }
    return null;
  }
  
  public static Object e()
  {
    try
    {
      Object localObject = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildPushMessageProcessorCallback();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e("GuildManagerProvider", "[getNewGuildPushMessageProcessorCallback]", localThrowable);
    }
    return null;
  }
  
  public static Object f()
  {
    try
    {
      Object localObject = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildMessageManagerCallback();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e("GuildManagerProvider", "[getNewGuildMessageManagerCallback]", localThrowable);
    }
    return null;
  }
  
  public static Object g()
  {
    try
    {
      Object localObject = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildSystemMessageProcessorCallback();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e("GuildManagerProvider", "[getNewGuildSystemMessageProcessorCallback]", localThrowable);
    }
    return null;
  }
  
  public static Object h()
  {
    try
    {
      Object localObject = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildGuestMessageProcessorCallback();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e("GuildManagerProvider", "[getNewGuildGuestMessageProcessorCallback]", localThrowable);
    }
    return null;
  }
  
  public static Object i()
  {
    try
    {
      Object localObject = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildRoamMessageEventFlowProcessorCallback();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e("GuildManagerProvider", "[getNewGuildRoamMessageEventFlowProcessorCallback]", localThrowable);
    }
    return null;
  }
  
  public static Class j()
  {
    try
    {
      Class localClass = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildNotificationProcessorClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("GuildManagerProvider", "[getGuildNotificationProcessorClass]", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.temp.api.GuildManagerProvider
 * JD-Core Version:    0.7.0.1
 */