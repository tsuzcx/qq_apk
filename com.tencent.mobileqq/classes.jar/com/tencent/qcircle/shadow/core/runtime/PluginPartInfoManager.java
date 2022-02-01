package com.tencent.qcircle.shadow.core.runtime;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PluginPartInfoManager
{
  private static Map<ClassLoader, PluginPartInfo> sPluginInfos = new HashMap();
  
  public static void addPluginInfo(ClassLoader paramClassLoader, PluginPartInfo paramPluginPartInfo)
  {
    sPluginInfos.put(paramClassLoader, paramPluginPartInfo);
  }
  
  public static Collection<PluginPartInfo> getAllPluginInfo()
  {
    return sPluginInfos.values();
  }
  
  public static PluginPartInfo getPluginInfo(ClassLoader paramClassLoader)
  {
    Object localObject = (PluginPartInfo)sPluginInfos.get(paramClassLoader);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("没有找到classLoader对应的pluginInfo classLoader:");
    ((StringBuilder)localObject).append(paramClassLoader);
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.PluginPartInfoManager
 * JD-Core Version:    0.7.0.1
 */