package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.ResultReceiver;
import bdkq;
import bdkr;
import bdkx;
import bdkz;
import bdle;
import bdnp;
import bdnr;
import bdnw;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppBrandProxy
  implements bdnp
{
  private static final String TAG = "minisdk-start_AppBrandProxy";
  private bdkr mAppBrandProxyImpl;
  private Context mContext;
  
  public AppBrandProxy()
  {
    bdkq.a().a(this);
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mAppBrandProxyImpl = new bdkr(this.mContext);
  }
  
  public void onAppBackground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(3, bdle.a().b(), paramMiniAppInfo, localBundle);
  }
  
  public void onAppDestroy(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(4, bdle.a().b(), null, localBundle);
  }
  
  public void onAppForeground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(2, bdle.a().b(), paramMiniAppInfo, localBundle);
  }
  
  public void onAppStart(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(1, bdle.a().b(), paramMiniAppInfo, localBundle);
  }
  
  public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo)
  {
    bdnw.d("minisdk-start_AppBrandProxy", "preloadDownloadPackage. pName=" + bdle.a().a() + " miniAppInfo:" + paramMiniAppInfo);
    if (!bdle.a().a())
    {
      this.mAppBrandProxyImpl.a(paramMiniAppInfo);
      return;
    }
    bdle.a().a().preloadDownloadPackage(paramMiniAppInfo);
  }
  
  public void preloadMiniApp()
  {
    if (!bdle.a().a())
    {
      bdnw.d("minisdk-start_AppBrandProxy", "call preloadMiniApp not in MainProcess. pName=" + bdle.a().a());
      return;
    }
    bdle.a().a().preloadMiniApp(new Bundle());
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, bdkz parambdkz)
  {
    bdnw.b("minisdk-start_AppBrandProxy", "cmd. pName=" + bdle.a().a() + " cmd:" + paramString);
    if (!bdle.a().a())
    {
      if (this.mAppBrandProxyImpl != null) {
        this.mAppBrandProxyImpl.a(paramString, paramBundle, parambdkz);
      }
      return;
    }
    bdkx.a().a(paramString, paramBundle, parambdkz);
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    bdnw.d("minisdk-start_AppBrandProxy", "startMiniApp. pName=" + bdle.a().a() + " miniAppInfo:" + paramMiniAppInfo);
    if (!bdle.a().a())
    {
      this.mAppBrandProxyImpl.a(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    bdle.a().a().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxy
 * JD-Core Version:    0.7.0.1
 */