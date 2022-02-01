package com.tencent.mobileqq.wxmini.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWxMiniManager
  extends QRouteApi
{
  public abstract void attachBaseContext(Context paramContext);
  
  public abstract Class<?> getWXMiniEntryClass();
  
  public abstract void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent);
  
  public abstract boolean isWxMiniApp(String paramString);
  
  public abstract void onAppProcessStart(Application paramApplication);
  
  public abstract void onWxContainerProcessStart();
  
  public abstract void preDownload();
  
  public abstract void startWxMiniApp(Context paramContext, String paramString, int paramInt1, int paramInt2);
  
  public abstract void startWxMiniAppById(Context paramContext, String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.api.IWxMiniManager
 * JD-Core Version:    0.7.0.1
 */