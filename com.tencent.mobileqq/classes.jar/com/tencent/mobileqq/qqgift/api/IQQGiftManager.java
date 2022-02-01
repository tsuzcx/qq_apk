package com.tencent.mobileqq.qqgift.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQGiftManager
  extends QRouteApi
{
  public abstract void destroy();
  
  public abstract void destroySDKImpl(int paramInt);
  
  public abstract IQQGiftSDK getSDKImpl(int paramInt);
  
  public abstract IQQGiftSDK removeSDKImpl(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.IQQGiftManager
 * JD-Core Version:    0.7.0.1
 */