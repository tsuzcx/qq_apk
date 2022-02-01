package com.tencent.superplayer.api;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.superplayer.player.SuperPlayerPool;
import com.tencent.superplayer.report.SPBeaconReporter;
import com.tencent.thumbplayer.api.ITPModuleLoader;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.tmediacodec.TCodecManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class SuperPlayerSDKMgr
{
  private static final String SDK_Version = "1.1.0";
  private static String mDataCacheFolder;
  private static int mPlatform;
  private static ISuperPlayerPool mPlayerRunningPool = new SuperPlayerPool();
  private static Context sAppContext;
  private static AtomicBoolean sIsInit = new AtomicBoolean(false);
  private static SuperPlayerSDKMgr.ILogListener sLogListener;
  
  public static Context getContext()
  {
    return sAppContext;
  }
  
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
  
  public static ISuperPlayerPool getPlayerPool()
  {
    return mPlayerRunningPool;
  }
  
  public static String getSDKVersion()
  {
    return "1.1.0";
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
    SPBeaconReporter.init();
    innerInitTVideoMgr();
    innerInitTPPlayerMgr();
    initTMediaCodecComponent();
  }
  
  private static void initTMediaCodecComponent()
  {
    TCodecManager.getInstance().setGlobalReuseEnable(true);
    TCodecManager.getInstance().setLogEnable(true);
    TCodecManager.getInstance().setLogLevel(2);
    TCodecManager.getInstance().setLogProxy(new SuperPlayerSDKMgr.3());
  }
  
  private static void innerInitTPPlayerMgr()
  {
    TPPlayerMgr.setOnLogListener(new SuperPlayerSDKMgr.2());
    TPPlayerMgr.initSdk(sAppContext, null, getPlatform());
    TPPlayerMgr.setProxyEnable(true);
    TPPlayerMgr.setDebugEnable(false);
    TPDownloadProxyNative.getInstance().isNativeLoaded();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerSDKMgr
 * JD-Core Version:    0.7.0.1
 */