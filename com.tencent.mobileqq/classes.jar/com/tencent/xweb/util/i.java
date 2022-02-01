package com.tencent.xweb.util;

import android.os.Build.VERSION;
import com.tencent.xweb.a;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class i
{
  static boolean a = false;
  static int b = -1;
  
  public static ClassLoader a()
  {
    return b(XWalkEnvironment.getAvailableVersion());
  }
  
  public static ClassLoader a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, ClassLoader.getSystemClassLoader());
  }
  
  public static ClassLoader a(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    String str = paramString1;
    if (Build.VERSION.SDK_INT >= 29)
    {
      str = paramString1;
      if (paramString1.endsWith("classes.dex"))
      {
        str = paramString1;
        if (!"true".equalsIgnoreCase(a.a("NOT_USE_JAR_REPLACE_DEX", "tools")))
        {
          str = paramString1.replace("classes.dex", "classes.dex.jar");
          if (new File(str).exists())
          {
            Log.i("XWebClassLoaderWrapper", "do use .jar instead of .dex");
          }
          else
          {
            Log.i("XWebClassLoaderWrapper", "try use .jar instead of .dex , but .jar not exist");
            str = paramString1;
          }
        }
      }
    }
    return new DexClassLoader(str, paramString2, paramString3, paramClassLoader);
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    if (paramInt <= 0) {
      return false;
    }
    if (!a)
    {
      a = true;
      b = a.a().a("APK_LOAD_MIN_VER", null, -1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("support apk load min ver = ");
      localStringBuilder.append(b);
      Log.i("XWebClassLoaderWrapper", localStringBuilder.toString());
    }
    int i = b;
    if (i <= 0) {
      return false;
    }
    if (paramInt > i) {
      bool = true;
    }
    return bool;
  }
  
  public static ClassLoader b(int paramInt)
  {
    if (paramInt == -1)
    {
      Log.i("XWebClassLoaderWrapper", "getXWalkClassLoader version = -1");
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (a(paramInt))
    {
      localObject1 = XWalkEnvironment.getDownloadApkPath(paramInt);
      localObject2 = XWalkEnvironment.getExtractedCoreDir(paramInt);
      String str = XWalkEnvironment.getOptimizedDexDir(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("is apk load path  = ");
      localStringBuilder.append((String)localObject1);
      Log.i("XWebClassLoaderWrapper", localStringBuilder.toString());
      return a((String)localObject1, str, (String)localObject2);
    }
    try
    {
      localObject1 = XWalkEnvironment.getExtractedCoreDir(paramInt);
      localObject2 = XWalkEnvironment.getClassDexFilePath(paramInt);
      if (!new File((String)localObject2).exists()) {
        return null;
      }
      localObject1 = a((String)localObject2, XWalkEnvironment.getOptimizedDexDir(paramInt), (String)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getXWalkClassLoader error:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      Log.e("XWebClassLoaderWrapper", ((StringBuilder)localObject2).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.i
 * JD-Core Version:    0.7.0.1
 */