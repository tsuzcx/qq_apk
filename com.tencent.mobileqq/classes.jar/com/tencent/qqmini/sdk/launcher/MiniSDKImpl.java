package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniCodeProxy;
import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.IMiniServer;
import java.util.List;

public class MiniSDKImpl
{
  public static final int LINKTYPE_FAKEURL = 0;
  public static final int LINKTYPE_MINICODE = 1;
  public static final int LINKTYPE_SCHEMA = 2;
  public static final String TAG = "minisdk-start_MiniSDKImpl";
  private Configuration mConfiguration;
  private volatile Context mContext;
  private ILaunchManager mLaunchManager;
  
  private static Configuration createConfiguration(Context paramContext)
  {
    Configuration localConfiguration = new Configuration.Builder(paramContext).build();
    paramContext = localConfiguration;
    if (!isConfigurationValid(localConfiguration))
    {
      QMLog.e("minisdk-start_MiniSDKImpl", "Failed to create invalid configuration");
      paramContext = null;
    }
    return paramContext;
  }
  
  private ILaunchManager getLaunchManager()
  {
    if (this.mLaunchManager == null)
    {
      IMiniServiceManager localIMiniServiceManager = AppLoaderFactory.g().getMiniServiceManager();
      if (localIMiniServiceManager != null) {
        try
        {
          this.mLaunchManager = ((ILaunchManager)localIMiniServiceManager.getService("LAUNCH_SERVICE"));
        }
        catch (RemoteException localRemoteException)
        {
          QMLog.e("minisdk-start_MiniSDKImpl", "Failed to getLaunchManager", localRemoteException);
        }
      }
    }
    return this.mLaunchManager;
  }
  
  private static boolean isConfigurationValid(Configuration paramConfiguration)
  {
    return (paramConfiguration != null) && (paramConfiguration.processInfoList != null) && (paramConfiguration.processInfoList.size() > 0);
  }
  
  public void init(Context paramContext)
  {
    if (paramContext == null)
    {
      QMLog.e("minisdk-start_MiniSDKImpl", "Failed to init MiniSDK. context is null");
      return;
    }
    if (this.mContext == null) {
      try
      {
        if (this.mContext == null)
        {
          QMLog.i("minisdk-start_MiniSDKImpl", "MiniSDK init context.");
          this.mConfiguration = createConfiguration(paramContext);
          AppLoaderFactory.g().init(paramContext, this.mConfiguration);
          this.mContext = paramContext;
        }
        return;
      }
      finally {}
    }
  }
  
  public void notifyPeriodicCacheUpdate(MiniAppInfo paramMiniAppInfo)
  {
    if (AppLoaderFactory.g().isMainProcess()) {
      AppLoaderFactory.g().getMiniServer().sendCmdToMiniProcess(1002, new Bundle(), paramMiniAppInfo, null);
    }
  }
  
  public void notifyShareResult(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (AppLoaderFactory.g().isMainProcess())
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      AppLoaderFactory.g().getMiniServer().sendCmdToMiniProcess(1001, localBundle, paramMiniAppInfo, paramResultReceiver);
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().notifyShareResult(paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void onHostAppBackground()
  {
    if (AppLoaderFactory.g().isMainProcess()) {
      AppLoaderFactory.g().getMiniServer().onHostAppBackground();
    }
  }
  
  public void preDownloadPkg(MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getMiniServer().preDownloadPkg(paramMiniAppInfo, paramResultReceiver);
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().preloadDownloadPackage(paramMiniAppInfo, paramResultReceiver);
  }
  
  public void preloadMiniApp(Context paramContext, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_MiniSDKImpl", "preloadMiniApp");
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getMiniServer().preloadMiniApp(paramBundle);
      return;
    }
    QMLog.e("minisdk-start_MiniSDKImpl", "preloadMiniApp should be called only in main process!!!");
  }
  
  public String scanMiniCode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    try
    {
      paramArrayOfByte = ((MiniCodeProxy)AppLoaderFactory.g().getProxyManager().get(MiniCodeProxy.class)).decode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      label37:
      break label37;
    }
    return "scanMiniCode error";
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startMiniApp miniappInfo:");
    localStringBuilder.append(paramMiniAppInfo);
    QMLog.i("minisdk-start_MiniSDKImpl", localStringBuilder.toString());
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getMiniServer().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void stopAllMiniApp()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopAllMiniApp. pName=");
    localStringBuilder.append(AppLoaderFactory.g().getCurrentProcessName());
    QMLog.i("minisdk-start_MiniSDKImpl", localStringBuilder.toString());
    try
    {
      getLaunchManager().stopAllMiniApp();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QMLog.e("minisdk-start_MiniSDKImpl", "Failed to stopAllMiniApp", localRemoteException);
    }
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopMiniApp. pName=");
    localStringBuilder.append(AppLoaderFactory.g().getCurrentProcessName());
    localStringBuilder.append(" miniAppInfo:");
    localStringBuilder.append(paramMiniAppInfo);
    QMLog.i("minisdk-start_MiniSDKImpl", localStringBuilder.toString());
    try
    {
      getLaunchManager().stopMiniApp(paramMiniAppInfo);
      return;
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_MiniSDKImpl", "Failed to stopMiniApp", paramMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniSDKImpl
 * JD-Core Version:    0.7.0.1
 */