package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface IMsfProxy
{
  public abstract int getMsfConnectedIPFamily();
  
  public abstract int getMsfConnectedNetType();
  
  public abstract void init(MsfServiceSdk paramMsfServiceSdk);
  
  public abstract void initMsfService();
  
  public abstract int onKillProcess();
  
  public abstract int onProcessViewableChanged(boolean paramBoolean, long paramLong, String paramString);
  
  public abstract int registerMsfService(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void registerProxyDone();
  
  public abstract int sendMsg(ToServiceMsg paramToServiceMsg);
  
  public abstract boolean serviceConnected();
  
  public abstract void startMsfService();
  
  public abstract void stopMsfService();
  
  public abstract int unRegisterMsfService(Boolean paramBoolean);
  
  public abstract void unbindMsfService();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
 * JD-Core Version:    0.7.0.1
 */