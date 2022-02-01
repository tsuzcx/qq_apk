package com.tencent.thumbplayer.core.downloadproxy.net;

class NetworkChangeNotifierAutoDetect$MyNetworkCallback$4
  implements Runnable
{
  NetworkChangeNotifierAutoDetect$MyNetworkCallback$4(NetworkChangeNotifierAutoDetect.MyNetworkCallback paramMyNetworkCallback, long paramLong) {}
  
  public void run()
  {
    NetworkChangeNotifierAutoDetect.access$300(this.this$1.this$0).onNetworkDisconnect(this.val$netId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.4
 * JD-Core Version:    0.7.0.1
 */