package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ILocalManagerApi
  extends QRouteApi
{
  public abstract boolean isLocaleCN();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.ILocalManagerApi
 * JD-Core Version:    0.7.0.1
 */