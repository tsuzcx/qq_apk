package com.tencent.qapmsdk.resource;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig.ResourcePlugin.ResourceType;
import com.tencent.qapmsdk.base.config.SDKConfig;

public class RunTimeEnv
{
  public static boolean isPublishMode()
  {
    return (SDKConfig.RES_TYPE & DefaultPluginConfig.ResourcePlugin.ResourceType.OUTSIDE_TAG.getValue()) > 0;
  }
  
  public static boolean isResourceMode()
  {
    return (SDKConfig.RES_TYPE & DefaultPluginConfig.ResourcePlugin.ResourceType.OPEN_RESOURCE.getValue()) > 0;
  }
  
  public static boolean isTagMode()
  {
    return (SDKConfig.RES_TYPE & DefaultPluginConfig.ResourcePlugin.ResourceType.OPEN_TAG.getValue()) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.RunTimeEnv
 * JD-Core Version:    0.7.0.1
 */