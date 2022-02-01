package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient;

public abstract interface IExtendedEmbeddedWidgetClient
  extends IEmbeddedWidgetClient
{
  public abstract AppBrandRuntime getAppBrandRuntime();
  
  public abstract void nativeDestroy();
  
  public abstract void nativePause();
  
  public abstract void nativeResume();
  
  public abstract void webViewDestory();
  
  public abstract void webViewPause();
  
  public abstract void webViewResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.IExtendedEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */