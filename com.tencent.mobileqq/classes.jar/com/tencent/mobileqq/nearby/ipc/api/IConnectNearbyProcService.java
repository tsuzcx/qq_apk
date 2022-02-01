package com.tencent.mobileqq.nearby.ipc.api;

import android.os.Message;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IConnectNearbyProcService
  extends QRouteApi
{
  public abstract boolean isNearbyReady();
  
  public abstract Message sendIPCMessage(Message paramMessage);
  
  public abstract Object[] sendIPCMessage(int paramInt);
  
  public abstract Object[] sendIPCMessage(int paramInt, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.api.IConnectNearbyProcService
 * JD-Core Version:    0.7.0.1
 */