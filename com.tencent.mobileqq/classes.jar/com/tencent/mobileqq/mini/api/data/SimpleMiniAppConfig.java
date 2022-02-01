package com.tencent.mobileqq.mini.api.data;

public class SimpleMiniAppConfig
{
  public static final int TYPE_MINI_APP = 0;
  public static final int TYPE_MINI_GAME = 1;
  public SimpleMiniAppConfig.SimpleMiniAppInfo config;
  public SimpleMiniAppConfig.SimpleLaunchParam launchParam = new SimpleMiniAppConfig.SimpleLaunchParam();
  
  public SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo paramSimpleMiniAppInfo)
  {
    this.config = paramSimpleMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig
 * JD-Core Version:    0.7.0.1
 */