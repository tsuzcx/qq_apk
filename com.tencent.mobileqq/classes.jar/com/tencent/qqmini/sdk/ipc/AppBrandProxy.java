package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.ResultReceiver;
import beot;
import beou;
import bepb;
import bepd;
import bepk;
import bese;
import besf;
import besl;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppBrandProxy
  implements bese
{
  private static final String TAG = "minisdk-start_AppBrandProxy";
  private beou mAppBrandProxyImpl;
  private Context mContext;
  
  public AppBrandProxy()
  {
    beot.a().a(this);
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mAppBrandProxyImpl = new beou(this.mContext);
  }
  
  public void onAppBackground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(3, bepk.a().b(), paramMiniAppInfo, localBundle);
  }
  
  public void onAppDestroy(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(4, bepk.a().b(), null, localBundle);
  }
  
  public void onAppForeground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(2, bepk.a().b(), paramMiniAppInfo, localBundle);
  }
  
  public void onAppStart(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("PID", Process.myPid());
    this.mAppBrandProxyImpl.a(1, bepk.a().b(), paramMiniAppInfo, localBundle);
  }
  
  public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo)
  {
    besl.d("minisdk-start_AppBrandProxy", "preloadDownloadPackage. pName=" + bepk.a().a() + " miniAppInfo:" + paramMiniAppInfo);
    if (!bepk.a().a())
    {
      this.mAppBrandProxyImpl.a(paramMiniAppInfo);
      return;
    }
    bepk.a().a().preloadDownloadPackage(paramMiniAppInfo);
  }
  
  public void preloadMiniApp()
  {
    if (!bepk.a().a())
    {
      besl.d("minisdk-start_AppBrandProxy", "call preloadMiniApp not in MainProcess. pName=" + bepk.a().a());
      return;
    }
    bepk.a().a().preloadMiniApp(new Bundle());
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, bepd parambepd)
  {
    besl.b("minisdk-start_AppBrandProxy", "cmd. pName=" + bepk.a().a() + " cmd:" + paramString);
    if (!bepk.a().a())
    {
      if (this.mAppBrandProxyImpl != null) {
        this.mAppBrandProxyImpl.a(paramString, paramBundle, parambepd);
      }
      return;
    }
    bepb.a().a(paramString, paramBundle, parambepd);
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
    besl.d("minisdk-start_AppBrandProxy", "startMiniApp. pName=" + bepk.a().a() + " miniAppInfo:" + paramMiniAppInfo);
    if (!bepk.a().a())
    {
      this.mAppBrandProxyImpl.a(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    bepk.a().a().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxy
 * JD-Core Version:    0.7.0.1
 */