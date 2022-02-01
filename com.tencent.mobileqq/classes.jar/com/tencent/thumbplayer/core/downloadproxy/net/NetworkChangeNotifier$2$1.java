package com.tencent.thumbplayer.core.downloadproxy.net;

class NetworkChangeNotifier$2$1
  implements Runnable
{
  NetworkChangeNotifier$2$1(NetworkChangeNotifier.2 param2, long paramLong) {}
  
  public void run()
  {
    this.this$1.this$0.notifyObserversOfNetworkDisconnect(this.val$netId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifier.2.1
 * JD-Core Version:    0.7.0.1
 */