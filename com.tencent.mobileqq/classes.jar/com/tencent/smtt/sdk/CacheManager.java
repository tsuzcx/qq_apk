package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.ReflectionUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager
{
  @Deprecated
  public static boolean cacheDisabled()
  {
    Object localObject = X5CoreEngine.getInstance();
    if ((localObject != null) && (((X5CoreEngine)localObject).isX5Core())) {
      return ((Boolean)((X5CoreEngine)localObject).wizard().cacheDisabled()).booleanValue();
    }
    localObject = ReflectionUtils.invokeStatic("android.webkit.CacheManager", "cacheDisabled");
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static InputStream getCacheFile(String paramString, boolean paramBoolean)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().getCacheFile(paramString, paramBoolean);
    }
    return null;
  }
  
  public static Object getCacheFile(String paramString, Map<String, String> paramMap)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().getCachFileBaseDir();
    }
    try
    {
      paramString = ReflectionUtils.invokeStatic(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[] { String.class, Map.class }, new Object[] { paramString, paramMap });
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  @Deprecated
  public static File getCacheFileBaseDir()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return (File)localX5CoreEngine.wizard().getCachFileBaseDir();
    }
    return (File)ReflectionUtils.invokeStatic("android.webkit.CacheManager", "getCacheFileBaseDir");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.CacheManager
 * JD-Core Version:    0.7.0.1
 */