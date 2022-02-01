package com.tencent.mobileqq.qqlive.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQLiveSDKManager
  extends QRouteApi
{
  public abstract void destroy();
  
  public abstract void destroySDKImpl(String paramString);
  
  public abstract IQQLiveSDK getSDKImpl(String paramString);
  
  public abstract void openDemo(Context paramContext);
  
  public abstract IQQLiveSDK removeSDKImpl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager
 * JD-Core Version:    0.7.0.1
 */