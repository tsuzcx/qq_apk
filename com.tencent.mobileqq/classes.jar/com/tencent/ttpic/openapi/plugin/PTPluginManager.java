package com.tencent.ttpic.openapi.plugin;

import com.tencent.aekit.plugin.core.IDetect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PTPluginManager
{
  public static final String ASSETS_DIR = "assets://";
  private static Map<String, Class<? extends IDetect>> detectors = new HashMap();
  
  public static Class<? extends IDetect> getDetectClass(String paramString)
  {
    return (Class)detectors.get(paramString);
  }
  
  public static List<Class<? extends IDetect>> getDetectorSet()
  {
    return new ArrayList(detectors.values());
  }
  
  public static boolean isDetectorReady(String paramString)
  {
    return detectors.get(paramString) != null;
  }
  
  public static void registerDetectClass(String paramString, Class<? extends IDetect> paramClass)
  {
    detectors.put(paramString, paramClass);
  }
  
  public static void unregisterDetectClass(String paramString)
  {
    detectors.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.plugin.PTPluginManager
 * JD-Core Version:    0.7.0.1
 */