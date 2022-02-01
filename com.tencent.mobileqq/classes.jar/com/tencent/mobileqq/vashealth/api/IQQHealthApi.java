package com.tencent.mobileqq.vashealth.api;

import android.content.Context;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRemote;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

@QAPI(process={"all"})
public abstract interface IQQHealthApi
  extends QRouteApi
{
  public abstract String SP_LBS_LATITUDE();
  
  public abstract String SP_LBS_LOGITUDE();
  
  public abstract String SP_LBS_UPDATE_TIME_STAMP();
  
  public abstract void checkRedPackRequest(AppRuntime paramAppRuntime);
  
  public abstract NewIntent getStepCounterServletIntent(Context paramContext);
  
  public abstract Class<? extends Entity> getTracePathDataClass();
  
  public abstract Class<? extends Entity> getTracePointDataClass();
  
  @QRemote
  public abstract void hideBanner();
  
  public abstract boolean isHealthUin(String paramString);
  
  public abstract boolean isNeedRedirectAIOToMainPage(String paramString);
  
  public abstract boolean isNeedReport(String paramString);
  
  public abstract boolean isSupportStepCounter(Context paramContext);
  
  public abstract void setIsOldMode(boolean paramBoolean);
  
  @QRemote
  public abstract void showBanner(long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.IQQHealthApi
 * JD-Core Version:    0.7.0.1
 */