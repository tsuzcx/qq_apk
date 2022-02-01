package com.tencent.rmonitor.memory;

import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.data.MemoryLeakPluginConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;

public class MemoryConfigHelper
{
  public static DefaultPluginConfig a()
  {
    return ConfigProxy.INSTANCE.getConfig().b(109);
  }
  
  public static float b()
  {
    return a().f.f / 100.0F;
  }
  
  public static DefaultPluginConfig c()
  {
    return ConfigProxy.INSTANCE.getConfig().b(107);
  }
  
  public static MemoryLeakPluginConfig d()
  {
    return (MemoryLeakPluginConfig)c().f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.MemoryConfigHelper
 * JD-Core Version:    0.7.0.1
 */