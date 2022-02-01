package com.tencent.mobileqq.nearby.api;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

@QAPI(process={"all"})
public abstract interface INearbyVideoUtilsDelegate
  extends QRouteApi
{
  public abstract void disableShowGuideDialog(AppInterface paramAppInterface);
  
  public abstract String getVideoThumb(String paramString);
  
  public abstract boolean isAuthVideoEnable();
  
  public abstract boolean isNeedShowGuideDialog(AppInterface paramAppInterface);
  
  public abstract void report(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs);
  
  public abstract void report(String paramString, String... paramVarArgs);
  
  public abstract void setAuthVideoConfig(String paramString);
  
  public abstract void showPtvPanel(Activity paramActivity, AppInterface paramAppInterface, int paramInt);
  
  public abstract boolean showTakeAuthVideoGuideDialog(Activity paramActivity, AppInterface paramAppInterface);
  
  public abstract void startPlayerActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean);
  
  public abstract void upload640Video(AppInterface paramAppInterface, String paramString, TransProcessorHandler paramTransProcessorHandler);
  
  public abstract void uploadThumbPhoto(AppInterface paramAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyVideoUtilsDelegate
 * JD-Core Version:    0.7.0.1
 */