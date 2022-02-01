package com.tencent.mobileqq.qqlive.api.ipc;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IQQLiveSdkIPCServerApi
  extends QRouteApi
{
  public static final String MODULE_NAME = "QQLiveSdkServerIPCModule";
  
  public abstract QIPCModule getServerIPCModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.ipc.IQQLiveSdkIPCServerApi
 * JD-Core Version:    0.7.0.1
 */