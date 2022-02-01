package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import mqq.app.AppRuntime;

public class ProfileServiceUtils
{
  public static <T extends AbsProfileBusinessProcessor> T getBusinessProcessor(AppRuntime paramAppRuntime, Class<? extends AbsProfileBusinessProcessor> paramClass)
  {
    return getIProfileProtocolService(paramAppRuntime).getBusinessProcessor(paramClass);
  }
  
  public static IProfileProtocolService getIProfileProtocolService(AppRuntime paramAppRuntime)
  {
    return (IProfileProtocolService)paramAppRuntime.getRuntimeService(IProfileProtocolService.class, "all");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils
 * JD-Core Version:    0.7.0.1
 */