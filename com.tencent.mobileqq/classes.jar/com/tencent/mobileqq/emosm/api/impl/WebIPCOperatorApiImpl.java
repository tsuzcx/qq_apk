package com.tencent.mobileqq.emosm.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;

public class WebIPCOperatorApiImpl
  implements IWebIPCOperatorApi
{
  public void doBindService(Context paramContext)
  {
    WebIPCOperator.a().c().doBindService(paramContext);
  }
  
  public void doUnbindService(Context paramContext)
  {
    WebIPCOperator.a().c().doUnbindService(paramContext);
  }
  
  public boolean isServiceClientBinded()
  {
    return WebIPCOperator.a().e();
  }
  
  public void onBindSuc()
  {
    WebIPCOperator.a().b();
  }
  
  public void onDisconnectWithService()
  {
    WebIPCOperator.a().d();
  }
  
  public void onPushMsgFromServer(Bundle paramBundle)
  {
    WebIPCOperator.a().d(paramBundle);
  }
  
  public void onRespFromClient(Bundle paramBundle)
  {
    WebIPCOperator.a().c(paramBundle);
  }
  
  public void registerObserver(OnRemoteRespObserver paramOnRemoteRespObserver)
  {
    WebIPCOperator.a().a(paramOnRemoteRespObserver);
  }
  
  public void sendServiceIpcReq(Bundle paramBundle)
  {
    WebIPCOperator.a().a(paramBundle);
  }
  
  public void sendServiceIpcReqWithoutTimeout(Bundle paramBundle)
  {
    WebIPCOperator.a().b(paramBundle);
  }
  
  public void unRegisterObserver(OnRemoteRespObserver paramOnRemoteRespObserver)
  {
    WebIPCOperator.a().b(paramOnRemoteRespObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.WebIPCOperatorApiImpl
 * JD-Core Version:    0.7.0.1
 */