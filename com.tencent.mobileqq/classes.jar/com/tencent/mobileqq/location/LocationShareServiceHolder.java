package com.tencent.mobileqq.location;

import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.callback.AioCallback;
import com.tencent.mobileqq.location.callback.ConversationCallback;
import com.tencent.mobileqq.location.callback.FloatMapCallback;
import mqq.app.AppRuntime;

public class LocationShareServiceHolder
{
  private static volatile ILocationShareService a;
  private static volatile IFloatMapService b;
  
  public static ILocationShareService a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (ILocationShareService)paramAppRuntime.getRuntimeService(ILocationShareService.class, "");
    if (a != paramAppRuntime)
    {
      paramAppRuntime.addErrorShareStateCallback(new AioCallback());
      paramAppRuntime.addErrorShareStateCallback(new ConversationCallback());
      a = paramAppRuntime;
    }
    return paramAppRuntime;
  }
  
  public static IFloatMapService b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (IFloatMapService)paramAppRuntime.getRuntimeService(IFloatMapService.class, "");
    if (b != paramAppRuntime)
    {
      paramAppRuntime.addFloatMapCallback(new FloatMapCallback());
      b = paramAppRuntime;
    }
    return paramAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareServiceHolder
 * JD-Core Version:    0.7.0.1
 */