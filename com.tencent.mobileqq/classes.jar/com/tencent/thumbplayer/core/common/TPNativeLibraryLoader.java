package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.text.TextUtils;

public class TPNativeLibraryLoader
{
  private static final String DEFAULT_LIB_PLAYER_CORE_VERSION = "2.16.0.1086.full";
  private static final String MAIN_PLAYER_CORE_VERSION = "2.16.0";
  private static boolean mIsLibLoaded = false;
  private static Object mIsLibLoadedLock = new Object();
  private static ITPNativeLibraryExternalLoader mLibLoader = null;
  private static final boolean mLibNameHasArchSuffix = false;
  private static final String mLibPlayerCorePrefix = "TPCore-master";
  
  private static native String _getPlayerCoreVersion();
  
  public static String getLibVersion()
  {
    return getPlayerCoreVersion();
  }
  
  public static String getPlayerCoreVersion()
  {
    try
    {
      String str = _getPlayerCoreVersion();
      return str;
    }
    catch (Throwable localThrowable)
    {
      label6:
      break label6;
    }
    TPNativeLog.printLog(2, "getPlayerCoreVersion: *.so is not loaded yet, return the hard-coded version number:2.16.0.1086.full");
    return "2.16.0.1086.full";
  }
  
  public static boolean isLibLoaded()
  {
    try
    {
      loadLibIfNeeded(null);
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TPNativeLibraryLoader isLibLoaded error:");
      localStringBuilder.append(localThrowable.getMessage());
      TPNativeLog.printLog(4, localStringBuilder.toString());
    }
    synchronized (mIsLibLoadedLock)
    {
      boolean bool = mIsLibLoaded;
      return bool;
    }
  }
  
  private static boolean isMatchJavaAndPlayerCore(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javaVersion:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", coreVersion:");
    localStringBuilder.append(paramString2);
    TPNativeLog.printLog(2, localStringBuilder.toString());
    boolean bool3 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
      bool1 = bool2;
      if (paramString1.length >= 3)
      {
        if (paramString2.length < 3) {
          return false;
        }
        int i = 0;
        while (i < 3)
        {
          if (!paramString1[i].matches(paramString2[i])) {
            return false;
          }
          i += 1;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean loadLib(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadLib cpu arch:");
    ((StringBuilder)localObject).append(TPSystemInfo.getCpuArchitecture());
    TPNativeLog.printLog(2, ((StringBuilder)localObject).toString());
    if ((TPSystemInfo.getCpuArchitecture() != 3) && (TPSystemInfo.getCpuArchitecture() != 4) && (TPSystemInfo.getCpuArchitecture() != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TPCore-master");
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      ITPNativeLibraryExternalLoader localITPNativeLibraryExternalLoader = mLibLoader;
      boolean bool1;
      if (localITPNativeLibraryExternalLoader != null) {
        bool1 = localITPNativeLibraryExternalLoader.loadLib((String)localObject, "2.16.0.1086.full");
      } else {
        bool1 = loadLibDefault((String)localObject, paramContext);
      }
      boolean bool2 = bool1;
      if (bool1)
      {
        paramContext = getPlayerCoreVersion();
        bool2 = isMatchJavaAndPlayerCore("2.16.0", paramContext);
        if (!bool2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("nativePlayerCoreVer(");
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append(") doesn't match javaPlayerCoreVer:(");
          ((StringBuilder)localObject).append("2.16.0");
          ((StringBuilder)localObject).append(")");
          TPNativeLog.printLog(4, ((StringBuilder)localObject).toString());
        }
      }
      if (bool2)
      {
        TPNativeLog.printLog(2, "Native libs loaded successfully");
        return bool2;
      }
      TPNativeLog.printLog(4, "Failed to load native libs");
      return bool2;
    }
    return false;
  }
  
  private static boolean loadLibDefault(String paramString, Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      bool1 = bool2;
      localStringBuilder1.append("loadLibDefault loading ");
      bool1 = bool2;
      localStringBuilder1.append(paramString);
      bool1 = bool2;
      TPNativeLog.printLog(2, localStringBuilder1.toString());
      bool1 = bool2;
      System.loadLibrary(paramString);
      boolean bool3 = true;
      bool2 = true;
      bool1 = bool2;
      localStringBuilder1 = new StringBuilder();
      bool1 = bool2;
      localStringBuilder1.append("loadLibDefault ");
      bool1 = bool2;
      localStringBuilder1.append(paramString);
      bool1 = bool2;
      localStringBuilder1.append(" loaded successfully");
      bool1 = bool2;
      TPNativeLog.printLog(2, localStringBuilder1.toString());
      bool1 = bool3;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("loadLibDefault failed to load ");
      localStringBuilder3.append(paramString);
      localStringBuilder3.append(",");
      localStringBuilder3.append(localThrowable.getMessage());
      TPNativeLog.printLog(4, localStringBuilder3.toString());
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (paramContext != null)
      {
        bool2 = bool1;
        if (TPSystemInfo.getCpuArchitecture() >= 6)
        {
          bool2 = bool1;
          try
          {
            localStringBuilder2 = new StringBuilder();
            bool2 = bool1;
            localStringBuilder2.append("loadLibDefault try to load ");
            bool2 = bool1;
            localStringBuilder2.append(paramString);
            bool2 = bool1;
            localStringBuilder2.append(" from APK");
            bool2 = bool1;
            TPNativeLog.printLog(2, localStringBuilder2.toString());
            bool2 = bool1;
            bool1 = TPLoadLibFromApk.load(paramString, TPNativeLibraryLoader.class.getClassLoader(), paramContext);
            if (bool1)
            {
              bool2 = bool1;
              paramContext = new StringBuilder();
              bool2 = bool1;
              paramContext.append("loadLibDefault loaded ");
              bool2 = bool1;
              paramContext.append(paramString);
              bool2 = bool1;
              paramContext.append(" from APK successfully");
              bool2 = bool1;
              TPNativeLog.printLog(2, paramContext.toString());
              return bool1;
            }
            bool2 = bool1;
            paramContext = new StringBuilder();
            bool2 = bool1;
            paramContext.append("loadLibDefault loaded ");
            bool2 = bool1;
            paramContext.append(paramString);
            bool2 = bool1;
            paramContext.append(" from APK failed");
            bool2 = bool1;
            TPNativeLog.printLog(4, paramContext.toString());
            return bool1;
          }
          catch (Throwable paramContext)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("loadLibDefault loaded ");
            localStringBuilder2.append(paramString);
            localStringBuilder2.append(" from APK failed,");
            localStringBuilder2.append(paramContext.getMessage());
            TPNativeLog.printLog(4, localStringBuilder2.toString());
          }
        }
      }
    }
    return bool2;
  }
  
  public static void loadLibIfNeeded(Context paramContext)
  {
    synchronized (mIsLibLoadedLock)
    {
      if (!mIsLibLoaded)
      {
        mIsLibLoaded = loadLib(paramContext);
        if (mIsLibLoaded) {
          TPNativeLog.printLog(2, "TPNativeLibraryLoader load lib successfully");
        } else {
          TPNativeLog.printLog(2, "TPNativeLibraryLoader load lib failed");
        }
      }
      if (mIsLibLoaded) {
        return;
      }
      throw new UnsupportedOperationException("Failed to load native library");
    }
  }
  
  public static void setLibLoader(ITPNativeLibraryExternalLoader paramITPNativeLibraryExternalLoader)
  {
    mLibLoader = paramITPNativeLibraryExternalLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPNativeLibraryLoader
 * JD-Core Version:    0.7.0.1
 */