package com.tencent.mobileqq.qqutils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQUtilsApi
  extends QRouteApi
{
  public abstract String getDeviceId();
  
  public abstract String getFeatureValueAioConfig();
  
  public abstract boolean isActiveReporting();
  
  public abstract boolean isNowSimpleUI();
  
  public abstract void reportHttpsSniMethod(int paramInt1, String paramString1, int paramInt2, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqutils.api.IQQUtilsApi
 * JD-Core Version:    0.7.0.1
 */