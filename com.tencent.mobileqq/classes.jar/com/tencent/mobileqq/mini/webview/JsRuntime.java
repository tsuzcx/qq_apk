package com.tencent.mobileqq.mini.webview;

import android.content.Context;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandServiceEventInterface;
import com.tencent.smtt.sdk.ValueCallback;

public abstract interface JsRuntime
{
  public abstract void clearUp();
  
  public abstract void evaluateCallbackJs(int paramInt, String paramString);
  
  public abstract void evaluateSubcribeJS(String paramString1, String paramString2, int paramInt);
  
  public abstract ApkgInfo getApkgInfo();
  
  public abstract Context getContextEx();
  
  public abstract int getPageWebViewId();
  
  public abstract void initService(ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener);
  
  public abstract void initService(ApkgInfo paramApkgInfo, String paramString, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener);
  
  public abstract void initWAServiceJS(String paramString);
  
  public abstract boolean isDestroyed();
  
  public abstract void loadAppServiceJs(String paramString);
  
  public abstract void postMessageToMainThread(String paramString);
  
  public abstract void setApkgInfo(ApkgInfo paramApkgInfo);
  
  public abstract void setAppBrandEventInterface(AppBrandServiceEventInterface paramAppBrandServiceEventInterface);
  
  public abstract void setAppServiceJsCallback(ValueCallback paramValueCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.webview.JsRuntime
 * JD-Core Version:    0.7.0.1
 */