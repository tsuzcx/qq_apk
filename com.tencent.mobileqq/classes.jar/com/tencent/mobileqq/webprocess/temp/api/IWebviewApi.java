package com.tencent.mobileqq.webprocess.temp.api;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.sonic.sdk.SonicRuntime;

@QAPI(process={"all"})
public abstract interface IWebviewApi
  extends QRouteApi
{
  public abstract SonicRuntime createSonicRuntime();
  
  public abstract String getDnsFileName();
  
  public abstract String getQUA(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract int getWebViewDialogMultiLineLayout();
  
  public abstract int getWebViewPreloadMode(Context paramContext);
  
  public abstract void monitorLoadUrl(Intent paramIntent, String paramString);
  
  public abstract void preCheckOffline(String paramString);
  
  public abstract View preloadWebView();
  
  public abstract void removeLastUinCookies(String paramString);
  
  public abstract void reportSchema(String paramString1, String paramString2, int paramInt);
  
  public abstract void showPerformanceDialogWhenDebugMode(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.temp.api.IWebviewApi
 * JD-Core Version:    0.7.0.1
 */