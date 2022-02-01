package com.tencent.mobileqq.emosm.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWebIPCOperatorApi
  extends QRouteApi
{
  public abstract void doBindService(Context paramContext);
  
  public abstract void doUnbindService(Context paramContext);
  
  public abstract boolean isServiceClientBinded();
  
  public abstract void onBindSuc();
  
  public abstract void onDisconnectWithService();
  
  public abstract void onPushMsgFromServer(Bundle paramBundle);
  
  public abstract void onRespFromClient(Bundle paramBundle);
  
  public abstract void registerObserver(OnRemoteRespObserver paramOnRemoteRespObserver);
  
  public abstract void sendServiceIpcReq(Bundle paramBundle);
  
  public abstract void sendServiceIpcReqWithoutTimeout(Bundle paramBundle);
  
  public abstract void unRegisterObserver(OnRemoteRespObserver paramOnRemoteRespObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
 * JD-Core Version:    0.7.0.1
 */