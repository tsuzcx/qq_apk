package com.tencent.mobileqq.nearby.ipc;

import android.os.Message;
import com.tencent.mobileqq.nearby.ipc.api.IConnectNearbyProcService;
import com.tencent.mobileqq.qroute.QRoute;

public class ConnectNearbyProcServiceUtils
{
  public static Message a(Message paramMessage)
  {
    return ((IConnectNearbyProcService)QRoute.api(IConnectNearbyProcService.class)).sendIPCMessage(paramMessage);
  }
  
  public static boolean a()
  {
    return ((IConnectNearbyProcService)QRoute.api(IConnectNearbyProcService.class)).isNearbyReady();
  }
  
  public static Object[] a(int paramInt)
  {
    return ((IConnectNearbyProcService)QRoute.api(IConnectNearbyProcService.class)).sendIPCMessage(paramInt);
  }
  
  public static Object[] a(int paramInt, Object... paramVarArgs)
  {
    return ((IConnectNearbyProcService)QRoute.api(IConnectNearbyProcService.class)).sendIPCMessage(paramInt, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcServiceUtils
 * JD-Core Version:    0.7.0.1
 */