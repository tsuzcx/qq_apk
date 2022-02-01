package com.tencent.mobileqq.filemanager.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopFileProtoReqMgr
  extends IRuntimeService
{
  public abstract void cancelRequest(ITroopFileProtoReq paramITroopFileProtoReq);
  
  public abstract ITroopFileProtoReq createProtoReq();
  
  public abstract void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg);
  
  public abstract void sendProtoRequest(ITroopFileProtoReq paramITroopFileProtoReq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */