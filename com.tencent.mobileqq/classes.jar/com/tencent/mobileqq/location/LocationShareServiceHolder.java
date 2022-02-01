package com.tencent.mobileqq.location;

import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.callback.AioCallback;
import com.tencent.mobileqq.location.callback.ConversationCallback;
import com.tencent.mobileqq.location.callback.FloatMapCallback;
import mqq.app.AppRuntime;

public class LocationShareServiceHolder
{
  private static volatile IFloatMapService jdField_a_of_type_ComTencentMobileqqLocationApiIFloatMapService;
  private static volatile ILocationShareService jdField_a_of_type_ComTencentMobileqqLocationApiILocationShareService;
  
  public static IFloatMapService a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (IFloatMapService)paramAppRuntime.getRuntimeService(IFloatMapService.class, "");
    if (jdField_a_of_type_ComTencentMobileqqLocationApiIFloatMapService != paramAppRuntime)
    {
      paramAppRuntime.addFloatMapCallback(new FloatMapCallback());
      jdField_a_of_type_ComTencentMobileqqLocationApiIFloatMapService = paramAppRuntime;
    }
    return paramAppRuntime;
  }
  
  public static ILocationShareService a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (ILocationShareService)paramAppRuntime.getRuntimeService(ILocationShareService.class, "");
    if (jdField_a_of_type_ComTencentMobileqqLocationApiILocationShareService != paramAppRuntime)
    {
      paramAppRuntime.addErrorShareStateCallback(new AioCallback());
      paramAppRuntime.addErrorShareStateCallback(new ConversationCallback());
      jdField_a_of_type_ComTencentMobileqqLocationApiILocationShareService = paramAppRuntime;
    }
    return paramAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareServiceHolder
 * JD-Core Version:    0.7.0.1
 */