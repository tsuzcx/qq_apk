package com.tencent.mobileqq.weather.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWeatherCommApi
  extends QRouteApi
{
  public abstract void asyncInitGdtDeviceInfo();
  
  public abstract String getGdtDeviceInfoBase64();
  
  public abstract boolean isWeatherArkPageUrl(String paramString);
  
  public abstract boolean isWeatherPA(String paramString);
  
  public abstract void openWeatherByScheme(Context paramContext, String paramString);
  
  public abstract void openWeatherWebForHippy(Context paramContext, String paramString);
  
  public abstract void openWeatherWebPage(Context paramContext, String paramString1, String paramString2);
  
  public abstract void preloadWebProcessAsync(int paramInt);
  
  public abstract boolean startNewWeatherWebPageActivity(Context paramContext, AppInterface paramAppInterface);
  
  public abstract boolean startNewWeatherWebPageActivity(Context paramContext, AppInterface paramAppInterface, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2);
  
  public abstract void startNewWeatherWebPageActivityByFollowState(Context paramContext, AppInterface paramAppInterface, int paramInt, String paramString);
  
  public abstract void startWeatherWebPageActivity(Context paramContext, AppInterface paramAppInterface, int paramInt, String paramString);
  
  public abstract String transformUrlToScheme(String paramString);
  
  public abstract void translate(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.api.IWeatherCommApi
 * JD-Core Version:    0.7.0.1
 */