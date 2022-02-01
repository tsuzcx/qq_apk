package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsGuidInfo;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsLog;

public class CKeyGuard
{
  private static String TAG = "ckeyguard";
  public static boolean bLoadSucc;
  private static boolean isInit = false;
  public static CKeyGuard mInstance;
  private static String mJarVersion;
  private static String mSoVersion;
  private static ModuleUpdateInterface moduleUpdateInterface;
  
  static
  {
    ModuleUpdateInterface localModuleUpdateInterface = moduleUpdateInterface;
    if (localModuleUpdateInterface != null) {
      bLoadSucc = localModuleUpdateInterface.loadLibrary("ckguard");
    }
    mJarVersion = "V1.0.001";
    mSoVersion = "";
  }
  
  public static String genGuard(Context paramContext)
  {
    if (!bLoadSucc) {
      return "none";
    }
    try
    {
      paramContext = new String(sGuard(System.currentTimeMillis() / 1000L, VsGuidInfo.getInstance(paramContext).getAndroidId()));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label36:
      break label36;
    }
    return "";
  }
  
  public static String getJarVersion()
  {
    return mJarVersion;
  }
  
  public static String getSoVersion()
  {
    return mSoVersion;
  }
  
  public static String getVersion()
  {
    try
    {
      String str = sVersion();
      return str;
    }
    catch (Throwable localThrowable)
    {
      label6:
      break label6;
    }
    return "";
  }
  
  public static void guardInit(Context paramContext)
  {
    if (!bLoadSucc) {
      return;
    }
    mSoVersion = getVersion();
    try
    {
      paramContext = new Thread(new CKeyGuard.1(paramContext));
      paramContext.setName("TVK_guardthread");
      paramContext.start();
      return;
    }
    catch (Throwable paramContext)
    {
      label40:
      break label40;
    }
    VsLog.error(TAG, new Object[] { "guard init catch" });
  }
  
  public static CKeyGuard instance()
  {
    try
    {
      if (mInstance == null)
      {
        mInstance = new CKeyGuard();
        if (!bLoadSucc) {
          bLoadSucc = loadso();
        }
      }
      CKeyGuard localCKeyGuard = mInstance;
      return localCKeyGuard;
    }
    finally {}
  }
  
  private static boolean loadso()
  {
    if (moduleUpdateInterface == null) {
      moduleUpdateInterface = new ModuleUpdateDefault();
    }
    return moduleUpdateInterface.loadLibrary("ckguard");
  }
  
  private static native byte[] sGuard(long paramLong, String paramString);
  
  private static native void sGuardInit(Context paramContext);
  
  private static native String sVersion();
  
  public static void setModuleUpdateInterface(ModuleUpdateInterface paramModuleUpdateInterface)
  {
    moduleUpdateInterface = paramModuleUpdateInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyGuard
 * JD-Core Version:    0.7.0.1
 */