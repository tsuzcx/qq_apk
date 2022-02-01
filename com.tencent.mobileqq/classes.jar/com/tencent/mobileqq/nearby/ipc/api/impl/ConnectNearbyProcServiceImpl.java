package com.tencent.mobileqq.nearby.ipc.api.impl;

import android.os.Message;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearby.ipc.api.IConnectNearbyProcService;

public class ConnectNearbyProcServiceImpl
  implements IConnectNearbyProcService
{
  public boolean isNearbyReady()
  {
    return ConnectNearbyProcService.a();
  }
  
  public Message sendIPCMessage(Message paramMessage)
  {
    return ConnectNearbyProcService.a(paramMessage);
  }
  
  public Object[] sendIPCMessage(int paramInt)
  {
    return ConnectNearbyProcService.a(paramInt);
  }
  
  public Object[] sendIPCMessage(int paramInt, Object... paramVarArgs)
  {
    return ConnectNearbyProcService.a(paramInt, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.api.impl.ConnectNearbyProcServiceImpl
 * JD-Core Version:    0.7.0.1
 */