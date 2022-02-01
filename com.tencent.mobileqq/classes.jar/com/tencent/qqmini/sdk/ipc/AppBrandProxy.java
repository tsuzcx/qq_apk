package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;

@MiniKeep
public class AppBrandProxy
  implements IAppBrandProxy
{
  private static final String TAG = "minisdk-start_AppBrandProxy";
  private Context mContext;
  private LaunchManagerClient mLaunchManagerClient;
  
  public AppBrandProxy()
  {
    AppBrandCmdProxy.g().setAppBrandProxy(this);
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mLaunchManagerClient = new LaunchManagerClient(this.mContext);
  }
  
  public void notifyShareResult(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.mLaunchManagerClient.notifyShareResult(paramMiniAppInfo, localBundle, paramResultReceiver);
  }
  
  public void onAppBackground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mLaunchManagerClient.onAppLifecycle(3, AppLoaderFactory.g().getProcessName(), paramMiniAppInfo, localBundle);
  }
  
  public void onAppDestroy(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mLaunchManagerClient.onAppLifecycle(4, AppLoaderFactory.g().getProcessName(), paramMiniAppInfo, localBundle);
  }
  
  public void onAppForeground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mLaunchManagerClient.onAppLifecycle(2, AppLoaderFactory.g().getProcessName(), paramMiniAppInfo, localBundle);
  }
  
  public void onAppStart(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mLaunchManagerClient.onAppLifecycle(1, AppLoaderFactory.g().getProcessName(), paramMiniAppInfo, localBundle);
  }
  
  public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo)
  {
    QMLog.e("minisdk-start_AppBrandProxy", "preloadDownloadPackage. pName=" + AppLoaderFactory.g().getCurrentProcessName() + " miniAppInfo:" + paramMiniAppInfo);
    if (!AppLoaderFactory.g().isMainProcess()) {
      this.mLaunchManagerClient.preloadPackage(paramMiniAppInfo);
    }
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    QMLog.i("minisdk-start_AppBrandProxy", "cmd. pName=" + AppLoaderFactory.g().getCurrentProcessName() + " cmd:" + paramString);
    if ((!AppLoaderFactory.g().isMainProcess()) && (this.mLaunchManagerClient != null)) {
      this.mLaunchManagerClient.sendCmd(paramString, paramBundle, paramMiniCmdCallback);
    }
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    QMLog.e("minisdk-start_AppBrandProxy", "startMiniApp. pName=" + AppLoaderFactory.g().getCurrentProcessName() + " miniAppInfo:" + paramMiniAppInfo);
    if (!AppLoaderFactory.g().isMainProcess()) {
      this.mLaunchManagerClient.startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
    }
  }
  
  public void stopAllMiniApp()
  {
    QMLog.e("minisdk-start_AppBrandProxy", "stopAllMiniApp. pName=" + AppLoaderFactory.g().getCurrentProcessName());
    if (!AppLoaderFactory.g().isMainProcess()) {
      this.mLaunchManagerClient.stopAllMiniApp();
    }
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp. pName=" + AppLoaderFactory.g().getCurrentProcessName() + " miniAppInfo:" + paramMiniAppInfo);
    if (!AppLoaderFactory.g().isMainProcess()) {
      this.mLaunchManagerClient.stopMiniApp(paramMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxy
 * JD-Core Version:    0.7.0.1
 */