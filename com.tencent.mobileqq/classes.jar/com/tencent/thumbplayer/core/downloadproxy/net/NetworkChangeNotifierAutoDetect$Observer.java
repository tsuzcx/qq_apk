package com.tencent.thumbplayer.core.downloadproxy.net;

public abstract interface NetworkChangeNotifierAutoDetect$Observer
{
  public abstract void onConnectionSubtypeChanged(@NetworkConstants.ConnectionSubType int paramInt);
  
  public abstract void onConnectionTypeChanged(@NetworkConstants.ConnectionType int paramInt);
  
  public abstract void onNetworkConnect(long paramLong, int paramInt);
  
  public abstract void onNetworkDisconnect(long paramLong);
  
  public abstract void onNetworkSoonToDisconnect(long paramLong);
  
  public abstract void purgeActiveNetworkList(long[] paramArrayOfLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect.Observer
 * JD-Core Version:    0.7.0.1
 */