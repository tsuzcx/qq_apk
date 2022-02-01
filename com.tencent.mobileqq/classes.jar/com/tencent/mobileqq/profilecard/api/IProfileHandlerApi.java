package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IProfileHandlerApi
  extends QRouteApi
{
  public abstract String getProfileCardHandler();
  
  public abstract String getProfileCommonHandler();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.IProfileHandlerApi
 * JD-Core Version:    0.7.0.1
 */