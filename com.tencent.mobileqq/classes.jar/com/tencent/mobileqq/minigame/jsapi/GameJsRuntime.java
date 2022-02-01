package com.tencent.mobileqq.minigame.jsapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandServiceEventInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

public class GameJsRuntime
  implements JsRuntime
{
  private final String TAG;
  private int mContextType;
  private volatile boolean mIsDestroyed;
  public ITTEngine mTTEngine;
  
  public GameJsRuntime(ITTEngine paramITTEngine, int paramInt)
  {
    this.TAG = ("[minigame] " + this + "[" + paramInt + "]");
    this.mTTEngine = paramITTEngine;
    this.mContextType = paramInt;
    this.mIsDestroyed = false;
  }
  
  public void clearUp()
  {
    this.mIsDestroyed = true;
  }
  
  public void evaluateCallbackJs(int paramInt, @Nullable String paramString)
  {
    if (isDestroyed()) {
      return;
    }
    ITTJSRuntime localITTJSRuntime = getRealRuntime();
    if (localITTJSRuntime != null)
    {
      localITTJSRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
    QLog.e(this.TAG, 1, "evaluateCallbackJs on null realJsRuntime");
  }
  
  public void evaluateSubcribeJS(@NonNull String paramString1, @Nullable String paramString2, int paramInt)
  {
    if (isDestroyed()) {
      return;
    }
    ITTJSRuntime localITTJSRuntime = getRealRuntime();
    if (localITTJSRuntime != null)
    {
      localITTJSRuntime.evaluateSubscribeJs(paramString1, paramString2);
      return;
    }
    QLog.e(this.TAG, 1, "evaluateSubcribeJS on null realJsRuntime");
  }
  
  public ApkgInfo getApkgInfo()
  {
    return null;
  }
  
  public Context getContextEx()
  {
    return BaseApplication.getContext().getApplicationContext();
  }
  
  public int getPageWebViewId()
  {
    return 0;
  }
  
  public ITTJSRuntime getRealRuntime()
  {
    if (this.mTTEngine != null) {
      return this.mTTEngine.getJsRuntime(this.mContextType);
    }
    return null;
  }
  
  public int getTargetContextType()
  {
    return this.mContextType;
  }
  
  public void initService(ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void initService(ApkgInfo paramApkgInfo, String paramString, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void initWAServiceJS(String paramString) {}
  
  public boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public void loadAppServiceJs(String paramString) {}
  
  public void postMessageToMainThread(String paramString) {}
  
  public void setApkgInfo(ApkgInfo paramApkgInfo) {}
  
  public void setAppBrandEventInterface(AppBrandServiceEventInterface paramAppBrandServiceEventInterface) {}
  
  public void setAppServiceJsCallback(ValueCallback paramValueCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.GameJsRuntime
 * JD-Core Version:    0.7.0.1
 */