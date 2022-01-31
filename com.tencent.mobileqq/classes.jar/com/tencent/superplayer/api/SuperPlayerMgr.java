package com.tencent.superplayer.api;

import android.app.Application;
import android.content.Context;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.thumbplayer.api.ITPModuleLoader;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.util.concurrent.atomic.AtomicBoolean;

public class SuperPlayerMgr
{
  private static final String SDK_Version = "V1.0.0";
  private static String mDataCacheFolder;
  private static int mPlatform;
  private static Application sApp;
  private static Context sAppContext;
  private static AtomicBoolean sIsInit = new AtomicBoolean(false);
  private static SuperPlayerMgr.ILogListener sLogListener;
  
  public static String getDataCacheFolder()
  {
    return mDataCacheFolder;
  }
  
  public static SuperPlayerMgr.ILogListener getLogListener()
  {
    return sLogListener;
  }
  
  public static int getPlatform()
  {
    return mPlatform;
  }
  
  public static String getSDKVersion()
  {
    return "V1.0.0";
  }
  
  public static void initSDK(Application paramApplication, int paramInt, String paramString)
  {
    if (sIsInit.get()) {
      return;
    }
    sIsInit.set(true);
    sApp = paramApplication;
    sAppContext = paramApplication.getApplicationContext();
    mPlatform = paramInt;
    mDataCacheFolder = paramString;
    innerInitTVideoMgr();
    innerInitTPPlayerMgr();
  }
  
  private static void innerInitTPPlayerMgr()
  {
    TPPlayerMgr.setOnLogListener(new SuperPlayerMgr.2());
    TPPlayerMgr.initSdk(sAppContext, null, getPlatform());
    TPPlayerMgr.setProxyEnable(true);
    TPPlayerMgr.setDebugEnable(false);
  }
  
  private static void innerInitTVideoMgr()
  {
    TVideoMgr.init(sApp, getPlatform());
    TVideoMgr.setOnLogListener(new SuperPlayerMgr.1());
  }
  
  public static void setLibLoader(ITPModuleLoader paramITPModuleLoader)
  {
    TPPlayerMgr.setLibLoader(paramITPModuleLoader);
  }
  
  public static void setOnLogListener(SuperPlayerMgr.ILogListener paramILogListener)
  {
    sLogListener = paramILogListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerMgr
 * JD-Core Version:    0.7.0.1
 */