package com.tencent.mobileqq.mini.appbrand.page;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.smtt.sdk.ValueCallback;

public abstract class AbstactJsRuntime
  implements JsRuntime
{
  public static final String TAG = "AbstactJsRuntime";
  public ApkgInfo apkgInfo;
  protected ValueCallback appServiceJsCallback;
  public final Context mContext;
  protected HandlerThread mHandlerThread;
  protected final Handler mThreadHandler;
  protected String threadName;
  
  public AbstactJsRuntime(Context paramContext, String paramString)
  {
    this.threadName = paramString;
    Log.e("AbstactJsRuntime", "ServiceWebview init in thread --> " + paramString);
    this.mContext = paramContext;
    this.mHandlerThread = new HandlerThread(paramString);
    this.mHandlerThread.start();
    this.mThreadHandler = new Handler(this.mHandlerThread.getLooper());
  }
  
  public ApkgInfo getApkgInfo()
  {
    return this.apkgInfo;
  }
  
  public Context getContextEx()
  {
    return this.mContext;
  }
  
  public void setApkgInfo(ApkgInfo paramApkgInfo)
  {
    this.apkgInfo = paramApkgInfo;
  }
  
  public void setAppServiceJsCallback(ValueCallback paramValueCallback)
  {
    this.appServiceJsCallback = paramValueCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AbstactJsRuntime
 * JD-Core Version:    0.7.0.1
 */