package com.tencent.superplayer.api;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.superplayer.config.ConfigManager;
import com.tencent.superplayer.datatransport.SPProxyConfig;
import com.tencent.superplayer.player.SuperPlayerPool;
import com.tencent.superplayer.report.SPBeaconReporter;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.ITPModuleLoader;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.datatransport.TPProxyGlobalManager;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import com.tencent.tmediacodec.TCodecManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class SuperPlayerSDKMgr
{
  private static final String SDK_Version = "1.1.0";
  private static final String TAG = "SuperPlayerSDKMgr";
  private static Context sAppContext;
  private static String sDataCacheFolder;
  private static String sDeviceId;
  private static final SuperPlayerSDKMgr.InnerLogListener sInnerLogListener = new SuperPlayerSDKMgr.InnerLogListener(null);
  private static AtomicBoolean sIsInit = new AtomicBoolean(false);
  private static SuperPlayerSDKMgr.ILogListener sLogListener;
  private static int sPlatform;
  private static ISuperPlayerPool sPlayerRunningPool = new SuperPlayerPool();
  private static SuperPlayerSdkOption sSdkOption;
  private static String sUid;
  
  public static Context getContext()
  {
    return sAppContext;
  }
  
  public static String getDataCacheFolder()
  {
    return sDataCacheFolder;
  }
  
  public static SuperPlayerSDKMgr.ILogListener getLogListener()
  {
    return sLogListener;
  }
  
  public static int getPlatform()
  {
    return sPlatform;
  }
  
  public static ISuperPlayerPool getPlayerPool()
  {
    return sPlayerRunningPool;
  }
  
  public static String getSDKVersion()
  {
    return "1.1.0";
  }
  
  public static SuperPlayerSdkOption getSdkOption()
  {
    return sSdkOption;
  }
  
  public static String getUid()
  {
    return sUid;
  }
  
  private static void initConfigComponent()
  {
    ConfigManager.get().init();
    ConfigManager.get().setCallback(new SuperPlayerSDKMgr.2());
  }
  
  @Deprecated
  public static void initSDK(Context paramContext, int paramInt, String paramString)
  {
    initSDK(paramContext, paramInt, paramString, SuperPlayerSdkOption.option());
  }
  
  public static void initSDK(Context paramContext, int paramInt, String paramString, SuperPlayerSdkOption paramSuperPlayerSdkOption)
  {
    if (sIsInit.get()) {
      return;
    }
    sIsInit.set(true);
    sAppContext = paramContext.getApplicationContext();
    sPlatform = paramInt;
    sDataCacheFolder = paramString;
    paramContext = paramSuperPlayerSdkOption;
    if (paramSuperPlayerSdkOption == null) {
      paramContext = SuperPlayerSdkOption.option();
    }
    sSdkOption = paramContext;
    sUid = sSdkOption.uid;
    if (sSdkOption.deviceId.isEmpty()) {
      paramContext = BeaconAdapter.getQIMEI();
    } else {
      paramContext = sSdkOption.deviceId;
    }
    sDeviceId = paramContext;
    sSdkOption.loadConfigFromConfigManager();
    SPProxyConfig.init(sSdkOption);
    SPBeaconReporter.init();
    innerInitTVideoMgr();
    innerInitTPPlayerMgr();
    initTMediaCodecComponent();
    initConfigComponent();
  }
  
  private static void initTMediaCodecComponent()
  {
    TCodecManager.getInstance().setGlobalReuseEnable(true);
    TCodecManager.getInstance().setLogLevel(2);
    TCodecManager.getInstance().setLogProxy(new SuperPlayerSDKMgr.1());
  }
  
  private static void innerInitTPPlayerMgr()
  {
    TPPlayerMgr.setOnLogListener(sInnerLogListener);
    TPPlayerMgr.initSdk(sAppContext, sDeviceId, getPlatform());
    TPPlayerMgr.setProxyEnable(true);
    TPPlayerMgr.setDebugEnable(false);
    TPDownloadProxyNative.getInstance().isNativeLoaded();
  }
  
  private static void innerInitTVideoMgr()
  {
    try
    {
      TVideoMgr.init(sAppContext, getPlatform());
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("innerInitTVideoMgr error, ");
      localStringBuilder.append(localThrowable.toString());
      LogUtil.e("SuperPlayerSDKMgr", localStringBuilder.toString());
    }
    TVideoMgr.setOnLogListener(sInnerLogListener);
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
  
  public static void setUpcInfo(String paramString, int paramInt)
  {
    TPPlayerMgr.setUpcInfo(paramString, paramInt);
  }
  
  public static void setUpdatePlayerInfoInterval(int paramInt)
  {
    TPProxyGlobalManager.getInstance().setUpdatePlayerInfoInterval(paramInt);
  }
  
  public static void setsUid(String paramString)
  {
    sUid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerSDKMgr
 * JD-Core Version:    0.7.0.1
 */