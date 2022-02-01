package com.tencent.qphone.base.remote;

import android.os.IInterface;

public abstract interface IMsfServiceCallbacker
  extends IInterface
{
  public abstract void onFirstPkgResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onNextPkgResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void onReceiveFirstPkgPushResp(FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onReceiveNextPkgPushResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void onReceivePushResp(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IMsfServiceCallbacker
 * JD-Core Version:    0.7.0.1
 */