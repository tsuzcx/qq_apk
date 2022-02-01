package com.tencent.open.settings;

import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import mqq.app.AppRuntime;

public class OpensdkFeatureSwitcher
{
  public static boolean a(AppRuntime paramAppRuntime)
  {
    return a(paramAppRuntime, "OpenSdk_featureAccountSelectDialog_864284595");
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    return ((IFeatureRuntimeService)paramAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.settings.OpensdkFeatureSwitcher
 * JD-Core Version:    0.7.0.1
 */