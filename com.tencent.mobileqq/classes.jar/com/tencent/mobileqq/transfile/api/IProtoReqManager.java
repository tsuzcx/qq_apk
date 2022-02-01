package com.tencent.mobileqq.transfile.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReqRunnable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IProtoReqManager
  extends IRuntimeService
{
  public abstract void cancelReq(ProtoReqManagerImpl.ProtoReq paramProtoReq);
  
  public abstract void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg);
  
  public abstract void scheduleRunnable(ProtoReqManagerImpl.ProtoReqRunnable paramProtoReqRunnable, long paramLong);
  
  public abstract void sendProtoReq(ProtoReqManagerImpl.ProtoReq paramProtoReq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.IProtoReqManager
 * JD-Core Version:    0.7.0.1
 */