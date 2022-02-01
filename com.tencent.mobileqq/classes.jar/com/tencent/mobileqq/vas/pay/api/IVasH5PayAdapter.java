package com.tencent.mobileqq.vas.pay.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVasH5PayAdapter
  extends QRouteApi
{
  public abstract String getDiyCardH5Pay();
  
  public abstract String getSvipCallbackSN();
  
  public abstract long getWebViewTransparentConstants();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.pay.api.IVasH5PayAdapter
 * JD-Core Version:    0.7.0.1
 */