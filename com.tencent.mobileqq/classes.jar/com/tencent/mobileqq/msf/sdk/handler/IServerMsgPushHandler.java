package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract interface IServerMsgPushHandler
  extends IMsfHandler
{
  public abstract void onConnClose(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onConnOpened(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onOpenConnAllFailed(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onReceFirstResp(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRecvServerConfigPush(FromServiceMsg paramFromServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler
 * JD-Core Version:    0.7.0.1
 */