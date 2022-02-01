package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.IHttpCommunicator;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IHttpEngineService
  extends IRuntimeService
{
  public abstract void cancelReq(NetReq paramNetReq);
  
  @Deprecated
  public abstract IHttpCommunicator getCommunicator();
  
  public abstract void sendReq(NetReq paramNetReq);
  
  public abstract NetResp sendReqSync(NetReq paramNetReq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.IHttpEngineService
 * JD-Core Version:    0.7.0.1
 */