package com.tencent.mobileqq.vas.svip.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISVIPHandlerProxy
  extends QRouteApi
{
  public abstract String getImplClassName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy
 * JD-Core Version:    0.7.0.1
 */