package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface IMsfProxy
{
  public abstract void init(MsfServiceSdk paramMsfServiceSdk);
  
  public abstract void initMsfService();
  
  public abstract int registerMsfService(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void registerProxyDone();
  
  public abstract int sendMsg(ToServiceMsg paramToServiceMsg);
  
  public abstract boolean serviceConnected();
  
  public abstract void stopMsfService();
  
  public abstract int unRegisterMsfService(Boolean paramBoolean);
  
  public abstract void unbindMsfService();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
 * JD-Core Version:    0.7.0.1
 */