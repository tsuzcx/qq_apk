package com.tencent.qqperf.monitor.network;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class NetworkMonitor$1
  implements EIPCResultCallback
{
  NetworkMonitor$1(NetworkMonitor paramNetworkMonitor) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "eipcResult=", Integer.valueOf(paramEIPCResult.code), paramEIPCResult.data });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.network.NetworkMonitor.1
 * JD-Core Version:    0.7.0.1
 */