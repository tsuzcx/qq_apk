package com.tencent.thumbplayer.core.downloadproxy.net;

import android.annotation.TargetApi;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.LinkProperties;
import android.net.Network;

@TargetApi(21)
class NetworkChangeNotifierAutoDetect$DefaultNetworkCallback
  extends ConnectivityManager.NetworkCallback
{
  private NetworkChangeNotifierAutoDetect$DefaultNetworkCallback(NetworkChangeNotifierAutoDetect paramNetworkChangeNotifierAutoDetect) {}
  
  public void onAvailable(Network paramNetwork)
  {
    if (NetworkChangeNotifierAutoDetect.access$000(this.this$0)) {
      NetworkChangeNotifierAutoDetect.access$100(this.this$0);
    }
  }
  
  public void onLinkPropertiesChanged(Network paramNetwork, LinkProperties paramLinkProperties)
  {
    onAvailable(null);
  }
  
  public void onLost(Network paramNetwork)
  {
    onAvailable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect.DefaultNetworkCallback
 * JD-Core Version:    0.7.0.1
 */