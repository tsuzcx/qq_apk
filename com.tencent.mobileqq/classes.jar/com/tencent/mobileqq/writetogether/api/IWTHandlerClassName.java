package com.tencent.mobileqq.writetogether.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWTHandlerClassName
  extends QRouteApi
{
  public abstract String getClassName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.api.IWTHandlerClassName
 * JD-Core Version:    0.7.0.1
 */