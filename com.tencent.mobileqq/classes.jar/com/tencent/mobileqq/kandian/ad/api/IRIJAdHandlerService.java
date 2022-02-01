package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJAdHandlerService
  extends QRouteApi
{
  public abstract IBaseHandler createAdHandler();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdHandlerService
 * JD-Core Version:    0.7.0.1
 */