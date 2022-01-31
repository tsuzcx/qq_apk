package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.ResultReceiver;
import bepk;
import bepl;
import beps;
import bepu;
import beqb;
import besv;
import besw;
import betc;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppBrandProxy
  implements besv
{
  private static final String TAG = "minisdk-start_AppBrandProxy";
  private bepl mAppBrandProxyImpl;
  private Context mContext;
  
  public AppBrandProxy()
  {
    bepk.a().a(this);
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mAppBrandProxyImpl = new bepl(this.mContext);
  }
  
  public void onAppBackground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(3, beqb.a().b(), paramMiniAppInfo, localBundle);
  }
  
  public void onAppDestroy(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(4, beqb.a().b(), null, localBundle);
  }
  
  public void onAppForeground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(2, beqb.a().b(), paramMiniAppInfo, localBundle);
  }
  
  public void onAppStart(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(1, beqb.a().b(), paramMiniAppInfo, localBundle);
  }
  
  public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo)
  {
    betc.d("minisdk-start_AppBrandProxy", "preloadDownloadPackage. pName=" + beqb.a().a() + " miniAppInfo:" + paramMiniAppInfo);
    if (!beqb.a().a())
    {
      this.mAppBrandProxyImpl.a(paramMiniAppInfo);
      return;
    }
    beqb.a().a().preloadDownloadPackage(paramMiniAppInfo);
  }
  
  public void preloadMiniApp()
  {
    if (!beqb.a().a())
    {
      betc.d("minisdk-start_AppBrandProxy", "call preloadMiniApp not in MainProcess. pName=" + beqb.a().a());
      return;
    }
    beqb.a().a().preloadMiniApp(new Bundle());
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, bepu parambepu)
  {
    betc.b("minisdk-start_AppBrandProxy", "cmd. pName=" + beqb.a().a() + " cmd:" + paramString);
    if (!beqb.a().a())
    {
      if (this.mAppBrandProxyImpl != null) {
        this.mAppBrandProxyImpl.a(paramString, paramBundle, parambepu);
      }
      return;
    }
    beps.a().a(paramString, paramBundle, parambepu);
  }
  
  public void share(int paramInt, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(paramInt, paramMiniAppInfo, localBundle, paramResultReceiver);
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    betc.d("minisdk-start_AppBrandProxy", "startMiniApp. pName=" + beqb.a().a() + " miniAppInfo:" + paramMiniAppInfo);
    if (!beqb.a().a())
    {
      this.mAppBrandProxyImpl.a(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    beqb.a().a().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxy
 * JD-Core Version:    0.7.0.1
 */