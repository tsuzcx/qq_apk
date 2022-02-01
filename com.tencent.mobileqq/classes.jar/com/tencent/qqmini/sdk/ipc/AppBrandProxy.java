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
  
  public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadDownloadPackage. pName=");
    localStringBuilder.append(AppLoaderFactory.g().getCurrentProcessName());
    localStringBuilder.append(" miniAppInfo:");
    localStringBuilder.append(paramMiniAppInfo);
    QMLog.e("minisdk-start_AppBrandProxy", localStringBuilder.toString());
    if (!AppLoaderFactory.g().isMainProcess()) {
      this.mLaunchManagerClient.preloadPackage(paramMiniAppInfo, paramResultReceiver);
    }
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cmd. pName=");
    ((StringBuilder)localObject).append(AppLoaderFactory.g().getCurrentProcessName());
    ((StringBuilder)localObject).append(" cmd:");
    ((StringBuilder)localObject).append(paramString);
    QMLog.i("minisdk-start_AppBrandProxy", ((StringBuilder)localObject).toString());
    if (!AppLoaderFactory.g().isMainProcess())
    {
      localObject = this.mLaunchManagerClient;
      if (localObject != null) {
        ((LaunchManagerClient)localObject).sendCmd(paramString, paramBundle, paramMiniCmdCallback);
      }
    }
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startMiniApp. pName=");
    localStringBuilder.append(AppLoaderFactory.g().getCurrentProcessName());
    localStringBuilder.append(" miniAppInfo:");
    localStringBuilder.append(paramMiniAppInfo);
    QMLog.e("minisdk-start_AppBrandProxy", localStringBuilder.toString());
    if (!AppLoaderFactory.g().isMainProcess()) {
      this.mLaunchManagerClient.startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
    }
  }
  
  public void stopAllMiniApp()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopAllMiniApp. pName=");
    localStringBuilder.append(AppLoaderFactory.g().getCurrentProcessName());
    QMLog.e("minisdk-start_AppBrandProxy", localStringBuilder.toString());
    if (!AppLoaderFactory.g().isMainProcess()) {
      this.mLaunchManagerClient.stopAllMiniApp();
    }
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopMiniApp. pName=");
    localStringBuilder.append(AppLoaderFactory.g().getCurrentProcessName());
    localStringBuilder.append(" miniAppInfo:");
    localStringBuilder.append(paramMiniAppInfo);
    QMLog.e("minisdk-start_AppBrandProxy", localStringBuilder.toString());
    if (!AppLoaderFactory.g().isMainProcess()) {
      this.mLaunchManagerClient.stopMiniApp(paramMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxy
 * JD-Core Version:    0.7.0.1
 */