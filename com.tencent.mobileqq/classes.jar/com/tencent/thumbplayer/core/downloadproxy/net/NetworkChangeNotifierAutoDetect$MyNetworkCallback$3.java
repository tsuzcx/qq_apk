package com.tencent.thumbplayer.core.downloadproxy.net;

class NetworkChangeNotifierAutoDetect$MyNetworkCallback$3
  implements Runnable
{
  NetworkChangeNotifierAutoDetect$MyNetworkCallback$3(NetworkChangeNotifierAutoDetect.MyNetworkCallback paramMyNetworkCallback, long paramLong) {}
  
  public void run()
  {
    NetworkChangeNotifierAutoDetect.access$300(this.this$1.this$0).onNetworkSoonToDisconnect(this.val$netId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.3
 * JD-Core Version:    0.7.0.1
 */