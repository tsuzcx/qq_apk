package com.tencent.qphone.base.remote;

import android.os.IInterface;

public abstract interface IMsfServiceCallbacker
  extends IInterface
{
  public abstract void onReceivePushResp(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onSyncReceivePushResp(FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onSyncResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IMsfServiceCallbacker
 * JD-Core Version:    0.7.0.1
 */