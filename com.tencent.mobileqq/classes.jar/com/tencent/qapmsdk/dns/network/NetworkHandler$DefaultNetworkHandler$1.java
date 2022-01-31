package com.tencent.qapmsdk.dns.network;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dns.logic.DnsCacheManager;

class NetworkHandler$DefaultNetworkHandler$1
  implements Runnable
{
  NetworkHandler$DefaultNetworkHandler$1(NetworkHandler.DefaultNetworkHandler paramDefaultNetworkHandler) {}
  
  public void run()
  {
    NetworkUtils.NetworkType localNetworkType = NetworkUtils.getActiveNetworkType();
    String str = NetworkUtils.getWifiSsid();
    int i;
    int j;
    if (localNetworkType != NetworkUtils.NetworkType.DISCONNECTED)
    {
      i = 1;
      if ((this.this$0.lastValidNetworkType == null) || (localNetworkType == this.this$0.lastValidNetworkType)) {
        break label270;
      }
      j = 1;
      label44:
      if ((localNetworkType != this.this$0.lastValidNetworkType) || (localNetworkType != NetworkUtils.NetworkType.WIFI) || ((NetworkUtils.isValidSSID(str)) && (NetworkUtils.isValidSSID(this.this$0.lastSsid)) && (str.equals(this.this$0.lastSsid)))) {
        break label275;
      }
    }
    label270:
    label275:
    for (int k = 1;; k = 0)
    {
      if ((i != 0) && (j != 0))
      {
        Logger.INSTANCE.i(new String[] { "QAPM_DNS_NetworkHandler", "Network type changed, clear dns cache, curNetwork: ", String.valueOf(localNetworkType), ", lastNetwork: ", String.valueOf(this.this$0.lastNetworkType), ", lastValidNetwork: ", String.valueOf(this.this$0.lastValidNetworkType), ", curSsid: ", str, ", lastSsid: ", this.this$0.lastSsid });
        DnsCacheManager.getInstance().clear();
      }
      if ((i != 0) && (k != 0)) {
        DnsCacheManager.getInstance().invalidate();
      }
      this.this$0.lastNetworkType = localNetworkType;
      if (i != 0) {
        this.this$0.lastValidNetworkType = localNetworkType;
      }
      if (localNetworkType == NetworkUtils.NetworkType.WIFI) {
        this.this$0.lastSsid = str;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label44;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.NetworkHandler.DefaultNetworkHandler.1
 * JD-Core Version:    0.7.0.1
 */