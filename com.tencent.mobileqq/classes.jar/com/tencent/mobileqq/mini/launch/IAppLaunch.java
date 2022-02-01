package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

public abstract interface IAppLaunch
{
  public abstract void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle);
  
  public abstract void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle);
  
  public abstract void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle);
  
  public abstract void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle);
  
  public abstract void preloadMiniApp();
  
  public abstract void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback);
  
  public abstract void startMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.IAppLaunch
 * JD-Core Version:    0.7.0.1
 */