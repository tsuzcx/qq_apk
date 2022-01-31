package com.tencent.qapmsdk.socket;

import com.tencent.qapmsdk.socket.model.SocketInfo;

public abstract interface TrafficConnectReporter$IConnectListener
{
  public abstract void onConnected(boolean paramBoolean, String paramString, int paramInt, long paramLong, SocketInfo paramSocketInfo);
  
  public abstract void onHandshakeCompleted(boolean paramBoolean, String paramString, int paramInt, long paramLong, SocketInfo paramSocketInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficConnectReporter.IConnectListener
 * JD-Core Version:    0.7.0.1
 */