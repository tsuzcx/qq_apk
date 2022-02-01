package com.tencent.thumbplayer.core.downloadproxy.net;

class NetworkChangeNotifierAutoDetect$1
  implements Runnable
{
  NetworkChangeNotifierAutoDetect$1(NetworkChangeNotifierAutoDetect paramNetworkChangeNotifierAutoDetect) {}
  
  public void run()
  {
    if (!NetworkChangeNotifierAutoDetect.access$000(this.this$0)) {
      return;
    }
    if (NetworkChangeNotifierAutoDetect.access$700(this.this$0))
    {
      NetworkChangeNotifierAutoDetect.access$702(this.this$0, false);
      return;
    }
    NetworkChangeNotifierAutoDetect.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect.1
 * JD-Core Version:    0.7.0.1
 */