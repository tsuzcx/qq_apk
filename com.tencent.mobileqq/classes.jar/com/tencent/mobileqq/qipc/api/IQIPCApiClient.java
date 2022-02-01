package com.tencent.mobileqq.qipc.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQIPCApiClient
  extends QRouteApi
{
  public abstract QIPCApiResult callServer(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void callServer(String paramString1, String paramString2, Bundle paramBundle, QIPCApiCallback paramQIPCApiCallback);
  
  public abstract void register(QIPCApiModule paramQIPCApiModule);
  
  public abstract void unRegisterModule(QIPCApiModule paramQIPCApiModule);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.api.IQIPCApiClient
 * JD-Core Version:    0.7.0.1
 */