package com.tencent.qapmsdk.socket;

import com.tencent.qapmsdk.socket.model.SocketInfo;

public class TrafficConnectReporter
{
  private static TrafficConnectReporter.IConnectListener sConnectListener;
  
  public static void onConnected(boolean paramBoolean, String paramString, int paramInt, long paramLong, SocketInfo paramSocketInfo)
  {
    if (sConnectListener != null) {
      sConnectListener.onConnected(paramBoolean, paramString, paramInt, paramLong, paramSocketInfo);
    }
  }
  
  public static void onHandshakeCompleted(boolean paramBoolean, String paramString, int paramInt, long paramLong, SocketInfo paramSocketInfo)
  {
    if (sConnectListener != null) {
      sConnectListener.onHandshakeCompleted(paramBoolean, paramString, paramInt, paramLong, paramSocketInfo);
    }
  }
  
  public static void setConnectListener(TrafficConnectReporter.IConnectListener paramIConnectListener)
  {
    sConnectListener = paramIConnectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficConnectReporter
 * JD-Core Version:    0.7.0.1
 */