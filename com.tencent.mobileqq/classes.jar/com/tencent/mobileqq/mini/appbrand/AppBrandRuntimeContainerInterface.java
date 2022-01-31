package com.tencent.mobileqq.mini.appbrand;

import android.widget.FrameLayout;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public abstract interface AppBrandRuntimeContainerInterface
{
  public abstract void addAppBrandRunTime(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void bringToFront(AppBrandRuntime paramAppBrandRuntime, FrameLayout paramFrameLayout);
  
  public abstract void cleanup();
  
  public abstract void finish();
  
  public abstract AppBrandRuntime getAppBrandRunTime(MiniAppInfo paramMiniAppInfo);
  
  public abstract AppBrandRuntime getAppBrandRunTime(String paramString, int paramInt);
  
  public abstract int getAppBrandRuntimeSize();
  
  public abstract AppBrandRuntime getBehindAppBrandRunTime(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract AppBrandRuntime getSecond();
  
  public abstract void init(ApkgInfo paramApkgInfo, String paramString, FrameLayout paramFrameLayout);
  
  public abstract AppBrandRuntime peek();
  
  public abstract void reload(AppBrandRuntime paramAppBrandRuntime, String paramString);
  
  public abstract void removeAppBrandRunTime(AppBrandRuntime paramAppBrandRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainerInterface
 * JD-Core Version:    0.7.0.1
 */