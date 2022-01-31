package com.tencent.qapmsdk.socket;

import com.tencent.qapmsdk.impl.report.TrafficMonitorReport;
import com.tencent.qapmsdk.socket.model.SocketInfo;

class TrafficMonitor$1
  implements TrafficConnectReporter.IConnectListener
{
  TrafficMonitor$1(TrafficMonitor paramTrafficMonitor) {}
  
  public void onConnected(boolean paramBoolean, String paramString, int paramInt, long paramLong, SocketInfo paramSocketInfo)
  {
    paramSocketInfo.tcpTime = paramLong;
    if ((!paramBoolean) && (paramSocketInfo.exception != null)) {
      paramSocketInfo.errorCode = SocketInfo.getErrorCode(paramSocketInfo.exception);
    }
    if (!paramSocketInfo.hasSaved)
    {
      TrafficMonitorReport.getInstance().addSocketToQueue(paramSocketInfo);
      paramSocketInfo.hasSaved = true;
    }
  }
  
  public void onHandshakeCompleted(boolean paramBoolean, String paramString, int paramInt, long paramLong, SocketInfo paramSocketInfo)
  {
    if ((paramBoolean) && (paramSocketInfo != null)) {
      paramSocketInfo.sslTime = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficMonitor.1
 * JD-Core Version:    0.7.0.1
 */