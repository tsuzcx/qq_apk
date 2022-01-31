package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

public class AppBrandProxy
  implements IAppLaunch
{
  public static final String KEY_PRELOAD_TYPE = "key_preload_type";
  public static final String PRELOAD_TYPE_APP = "preload_app";
  public static final String PRELOAD_TYPE_GAME = "preload_game";
  private static final String TAG = "miniapp-process_AppBrandProxy";
  private static AppBrandProxy instance;
  private static byte[] lock = new byte[0];
  private AppBrandProxyImpl mAppBrandProxyImpl = new AppBrandProxyImpl(this.mContext);
  private Context mContext = BaseApplicationImpl.getApplication();
  protected MiniAppConfig mMiniConfig;
  private String mPreloadType = "preload_app";
  
  public static AppBrandProxy g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new AppBrandProxy();
      }
      return instance;
    }
  }
  
  public static boolean isMainProcess()
  {
    return "com.tencent.mobileqq".equals(BaseApplicationImpl.getApplication().getQQProcessName());
  }
  
  public MiniAppConfig getMiniAppConfig()
  {
    return this.mMiniConfig;
  }
  
  public void onAppBackground(String paramString)
  {
    onAppBackground(paramString, this.mMiniConfig, null);
  }
  
  public void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    if (this.mAppBrandProxyImpl != null) {
      this.mAppBrandProxyImpl.onAppBackground(paramString, paramMiniAppConfig, paramBundle);
    }
  }
  
  public void onAppForeground(String paramString)
  {
    if (this.mMiniConfig != null)
    {
      onAppForeground(paramString, this.mMiniConfig, null);
      return;
    }
    QLog.e("miniapp-start", 1, "onAppForeground but MiniConfig is still Null!!!");
  }
  
  public void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    if (this.mAppBrandProxyImpl != null)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt("PID", Process.myPid());
      this.mAppBrandProxyImpl.onAppForeground(paramString, paramMiniAppConfig, localBundle);
    }
  }
  
  public void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_preload_type", this.mPreloadType);
    onAppStart(paramString, paramMiniAppConfig, localBundle);
  }
  
  public void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    if (this.mAppBrandProxyImpl != null)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt("PID", Process.myPid());
      this.mAppBrandProxyImpl.onAppStart(paramString, paramMiniAppConfig, localBundle);
    }
  }
  
  public void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    if (this.mAppBrandProxyImpl != null) {
      this.mAppBrandProxyImpl.onAppStop(paramString, paramMiniAppConfig, paramBundle);
    }
  }
  
  public void preloadMiniApp()
  {
    if (!isMainProcess())
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "call preloadMiniApp not in MainProcess. pName=" + BaseApplicationImpl.getApplication().getQQProcessName());
      return;
    }
    AppBrandLaunchManager.g().getHandler().post(new AppBrandProxy.1(this));
  }
  
  public void preloadPackage(@NonNull MiniAppInfo paramMiniAppInfo)
  {
    if (isMainProcess()) {
      AppBrandLaunchManager.g().preloadPackage(paramMiniAppInfo);
    }
    while (this.mAppBrandProxyImpl == null) {
      return;
    }
    this.mAppBrandProxyImpl.preloadPackage(paramMiniAppInfo);
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    if (this.mAppBrandProxyImpl != null) {
      this.mAppBrandProxyImpl.sendCmd(paramString, paramBundle, paramCmdCallback);
    }
  }
  
  public void setMiniAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.mMiniConfig = paramMiniAppConfig;
    onAppForeground(BaseApplicationImpl.getApplication().getQQProcessName(), paramMiniAppConfig, null);
  }
  
  public void setPreloadType(String paramString)
  {
    this.mPreloadType = paramString;
    onAppStart(BaseApplicationImpl.getApplication().getQQProcessName(), null);
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    QLog.i("miniapp-process_AppBrandProxy", 1, "[MiniEng]startMiniApp. pName=" + BaseApplicationImpl.getApplication().getQQProcessName());
    if (!isMainProcess())
    {
      if (this.mAppBrandProxyImpl != null) {
        this.mAppBrandProxyImpl.startMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
      }
      return;
    }
    AppBrandLaunchManager.g().startMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxy
 * JD-Core Version:    0.7.0.1
 */