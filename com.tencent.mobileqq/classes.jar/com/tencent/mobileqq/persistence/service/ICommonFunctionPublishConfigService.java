package com.tencent.mobileqq.persistence.service;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICommonFunctionPublishConfigService
  extends QRouteApi
{
  public abstract boolean isCopyDBCommandEnable();
  
  public abstract boolean isLocalized();
  
  public abstract boolean isNewUnreadCountEnable();
  
  public abstract boolean isUseNewInvalidUnreadMarkThreshold();
  
  public abstract boolean isWalEnable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService
 * JD-Core Version:    0.7.0.1
 */