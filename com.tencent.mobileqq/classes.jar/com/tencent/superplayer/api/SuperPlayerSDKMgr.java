package com.tencent.superplayer.api;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.thumbplayer.api.ITPModuleLoader;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.util.concurrent.atomic.AtomicBoolean;

public class SuperPlayerSDKMgr
{
  private static final String SDK_Version = "V1.0.1";
  private static String mDataCacheFolder;
  private static int mPlatform;
  private static Context sAppContext;
  private static AtomicBoolean sIsInit = new AtomicBoolean(false);
  private static SuperPlayerSDKMgr.ILogListener sLogListener;
  
  public static String getDataCacheFolder()
  {
    return mDataCacheFolder;
  }
  
  public static SuperPlayerSDKMgr.ILogListener getLogListener()
  {
    return sLogListener;
  }
  
  public static int getPlatform()
  {
    return mPlatform;
  }
  
  public static String getSDKVersion()
  {
    return "V1.0.1";
  }
  
  public static void initSDK(Context paramContext, int paramInt, String paramString)
  {
    if (sIsInit.get()) {
      return;
    }
    sIsInit.set(true);
    sAppContext = paramContext.getApplicationContext();
    mPlatform = paramInt;
    mDataCacheFolder = paramString;
    innerInitTVideoMgr();
    innerInitTPPlayerMgr();
  }
  
  private static void innerInitTPPlayerMgr()
  {
    TPPlayerMgr.setOnLogListener(new SuperPlayerSDKMgr.2());
    TPPlayerMgr.initSdk(sAppContext, null, getPlatform());
    TPPlayerMgr.setProxyEnable(true);
    TPPlayerMgr.setDebugEnable(false);
  }
  
  private static void innerInitTVideoMgr()
  {
    TVideoMgr.init(sAppContext, getPlatform());
    TVideoMgr.setOnLogListener(new SuperPlayerSDKMgr.1());
  }
  
  public static boolean registerTVideoPlatformInfo(TVideoPlatformInfo paramTVideoPlatformInfo)
  {
    return TVideoMgr.registerTVideoPlatformInfo(TVideoPlatformInfo.convert(paramTVideoPlatformInfo));
  }
  
  public static void setLibLoader(ITPModuleLoader paramITPModuleLoader)
  {
    TPPlayerMgr.setLibLoader(paramITPModuleLoader);
  }
  
  public static void setOnLogListener(SuperPlayerSDKMgr.ILogListener paramILogListener)
  {
    sLogListener = paramILogListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerSDKMgr
 * JD-Core Version:    0.7.0.1
 */