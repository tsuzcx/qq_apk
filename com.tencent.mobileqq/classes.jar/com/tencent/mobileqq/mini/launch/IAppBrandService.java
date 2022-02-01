package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import android.os.IInterface;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public abstract interface IAppBrandService
  extends IInterface
{
  public abstract void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle);
  
  public abstract void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle);
  
  public abstract void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle);
  
  public abstract void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle);
  
  public abstract void preloadMiniApp();
  
  public abstract void preloadPackage(MiniAppInfo paramMiniAppInfo);
  
  public abstract void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback);
  
  public abstract void startMiniApp(MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.IAppBrandService
 * JD-Core Version:    0.7.0.1
 */