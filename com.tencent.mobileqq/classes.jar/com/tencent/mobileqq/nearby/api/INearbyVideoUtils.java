package com.tencent.mobileqq.nearby.api;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

@QAPI(process={"all"})
public abstract interface INearbyVideoUtils
  extends QRouteApi
{
  public abstract void disableShowGuideDialog(Object paramObject);
  
  public abstract String getVideoThumb(String paramString);
  
  public abstract boolean isAuthVideoEnable();
  
  public abstract boolean isNeedShowGuideDialog(Object paramObject);
  
  public abstract void report(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs);
  
  public abstract void report(String paramString, String... paramVarArgs);
  
  public abstract void setAuthVideoConfig(String paramString);
  
  public abstract void showPtvPanel(Activity paramActivity, AppInterface paramAppInterface, int paramInt);
  
  public abstract boolean showTakeAuthVideoGuideDialog(Activity paramActivity, Object paramObject);
  
  public abstract void startPlayerActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean);
  
  public abstract void upload640Video(Object paramObject, String paramString, TransProcessorHandler paramTransProcessorHandler);
  
  public abstract void uploadThumbPhoto(Object paramObject, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyVideoUtils
 * JD-Core Version:    0.7.0.1
 */