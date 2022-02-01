package com.tencent.thumbplayer.core.downloadproxy.net;

class NetworkChangeNotifierAutoDetect$MyNetworkCallback$2
  implements Runnable
{
  NetworkChangeNotifierAutoDetect$MyNetworkCallback$2(NetworkChangeNotifierAutoDetect.MyNetworkCallback paramMyNetworkCallback, long paramLong, int paramInt) {}
  
  public void run()
  {
    NetworkChangeNotifierAutoDetect.access$300(this.this$1.this$0).onNetworkConnect(this.val$netId, this.val$connectionType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.2
 * JD-Core Version:    0.7.0.1
 */