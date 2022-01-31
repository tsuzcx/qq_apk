package com.tencent.qqmini.sdk.ipc;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import bgpr;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService.Stub;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager;
import com.tencent.qqmini.sdk.log.QMLog;

public class AppMainServiceBinder
  extends IAppMainService.Stub
{
  private static final String TAG = "minisdk-start_AppMainServiceBinder";
  private Context mContext;
  public String mProcessName;
  
  public AppMainServiceBinder(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mProcessName = paramString;
  }
  
  public void onAppLifecycle(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_AppMainServiceBinder", "handleAppLifecycle lifecycle:" + paramInt + " process:" + paramString + " miniAppInfo:" + paramMiniAppInfo);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      AppLoaderFactory.g().getLaunchManager().onAppStart(paramString, paramMiniAppInfo, paramBundle);
      return;
    case 4: 
      AppLoaderFactory.g().getLaunchManager().onAppStop(paramString, paramMiniAppInfo, paramBundle);
      return;
    case 2: 
      AppLoaderFactory.g().getLaunchManager().onAppForeground(paramString, paramMiniAppInfo, paramBundle);
      return;
    }
    AppLoaderFactory.g().getLaunchManager().onAppBackground(paramString, paramMiniAppInfo, paramBundle);
  }
  
  public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo)
  {
    QMLog.w("minisdk-start_AppMainServiceBinder", "AppMainServiceBinder call preloadPackage not from Main Processor. pName=" + this.mProcessName);
  }
  
  public void preloadMiniApp()
  {
    QMLog.w("minisdk-start_AppMainServiceBinder", "AppMainServiceBinder call preloadMiniApp not from Main Processor . pName=" + this.mProcessName);
  }
  
  public Bundle requestAync(String paramString1, String paramString2, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_AppMainServiceBinder", "requestAync cmd:" + paramString1 + " process:" + paramString2);
    try
    {
      if ("query_mini_process".equals(paramString1))
      {
        boolean bool = AppLoaderFactory.g().getLaunchManager().isMiniProcess(paramString2);
        paramString1 = new Bundle();
        paramString1.putBoolean("key_result", bool);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      QMLog.i("minisdk-start_AppMainServiceBinder", "requestAync exception!", paramString1);
    }
    return null;
  }
  
  public void sendCmd(String paramString1, String paramString2, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    bgpr.a().a(paramString1, paramBundle, paramMiniCmdCallback);
  }
  
  public void startMiniApp(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    QMLog.w("minisdk-start_AppMainServiceBinder", "AppMainServiceBinder call startMiniApp not from Main Processor. pName=" + this.mProcessName);
    AppLoaderFactory.g().getLaunchManager().startMiniApp(null, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void stopAllMiniApp()
  {
    AppLoaderFactory.g().getLaunchManager().stopAllMiniApp();
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    AppLoaderFactory.g().getLaunchManager().stopMiniApp(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppMainServiceBinder
 * JD-Core Version:    0.7.0.1
 */