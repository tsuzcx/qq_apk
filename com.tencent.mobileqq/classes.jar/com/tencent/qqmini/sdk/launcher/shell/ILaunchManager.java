package com.tencent.qqmini.sdk.launcher.shell;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Messenger;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;

public abstract interface ILaunchManager
{
  public abstract void init(Context paramContext);
  
  public abstract boolean isMiniProcess(String paramString);
  
  public abstract void onAppBackground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onAppForeground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onAppStart(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onAppStop(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onHostAppBackground();
  
  public abstract void onPreloadBaseLib(String paramString1, String paramString2);
  
  public abstract void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo);
  
  public abstract void preloadMiniApp(Bundle paramBundle);
  
  public abstract void registerClientMessenger(String paramString, Messenger paramMessenger);
  
  public abstract void registerProcessInfo(List<ILaunchManager.MiniProcessorConfig> paramList);
  
  public abstract boolean sendCmdToMiniProcess(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver);
  
  public abstract void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver);
  
  public abstract void stopAllMiniApp();
  
  public abstract void stopMiniApp(MiniAppInfo paramMiniAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.ILaunchManager
 * JD-Core Version:    0.7.0.1
 */