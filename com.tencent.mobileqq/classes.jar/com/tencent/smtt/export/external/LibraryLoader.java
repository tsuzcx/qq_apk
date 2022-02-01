package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.io.File;
import java.util.ArrayList;

public class LibraryLoader
{
  private static String[] sLibrarySearchPaths;
  
  public static String[] getLibrarySearchPaths(Context paramContext)
  {
    Object localObject = sLibrarySearchPaths;
    if (localObject != null) {
      return localObject;
    }
    if (paramContext == null) {
      return new String[] { "/system/lib" };
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(getNativeLibraryDir(paramContext));
    ((ArrayList)localObject).add("/system/lib");
    paramContext = new String[((ArrayList)localObject).size()];
    ((ArrayList)localObject).toArray(paramContext);
    sLibrarySearchPaths = paramContext;
    return sLibrarySearchPaths;
  }
  
  public static String getNativeLibraryDir(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 9) {
      return paramContext.getApplicationInfo().nativeLibraryDir;
    }
    if (i >= 4)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getApplicationInfo().dataDir);
      localStringBuilder.append("/lib");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/data/");
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("/lib");
    return localStringBuilder.toString();
  }
  
  public static void loadLibrary(Context paramContext, String paramString)
  {
    paramContext = getLibrarySearchPaths(paramContext);
    String str1 = System.mapLibraryName(paramString);
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str2 = paramContext[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append("/");
      localStringBuilder.append(str1);
      str2 = localStringBuilder.toString();
      if (!new File(str2).exists()) {
        i += 1;
      } else {
        try
        {
          System.load(str2);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      }
    }
    try
    {
      System.loadLibrary(paramString);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */