package com.tencent.mobileqq.qqlive.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface ITRTCIPCApi
  extends QRouteApi
{
  public abstract QIPCModule getServerIPCModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.ITRTCIPCApi
 * JD-Core Version:    0.7.0.1
 */