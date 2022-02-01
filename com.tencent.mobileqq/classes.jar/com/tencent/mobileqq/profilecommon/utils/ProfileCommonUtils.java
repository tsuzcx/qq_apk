package com.tencent.mobileqq.profilecommon.utils;

import com.tencent.mobileqq.profilecommon.api.IProfileCommonService;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import mqq.app.AppRuntime;

public class ProfileCommonUtils
{
  public static <T extends AbsProfileCommonProcessor> T a(Class<? extends AbsProfileCommonProcessor> paramClass, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      return ((IProfileCommonService)paramAppRuntime.getRuntimeService(IProfileCommonService.class, "all")).getProcessor(paramClass);
    }
    return null;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      ((IProfileCommonService)paramAppRuntime.getRuntimeService(IProfileCommonService.class, "all")).getProfileDetailForLogin();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.utils.ProfileCommonUtils
 * JD-Core Version:    0.7.0.1
 */