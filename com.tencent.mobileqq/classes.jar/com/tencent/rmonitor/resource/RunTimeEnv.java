package com.tencent.rmonitor.resource;

import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.constants.ResourceType;

public class RunTimeEnv
{
  private static int a(int paramInt)
  {
    return paramInt & ConfigProxy.INSTANCE.getConfig().a("RES_TYPE");
  }
  
  public static boolean a()
  {
    return a(ResourceType.OUTSIDE_TAG.getValue()) != 0;
  }
  
  public static boolean b()
  {
    return a(ResourceType.OPEN_TAG.getValue()) != 0;
  }
  
  public static boolean c()
  {
    return a(ResourceType.OPEN_RESOURCE.getValue()) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.RunTimeEnv
 * JD-Core Version:    0.7.0.1
 */