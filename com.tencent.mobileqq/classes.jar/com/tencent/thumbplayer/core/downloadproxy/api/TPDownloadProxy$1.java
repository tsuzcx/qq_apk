package com.tencent.thumbplayer.core.downloadproxy.api;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;

class TPDownloadProxy$1
  extends ConnectivityManager.NetworkCallback
{
  TPDownloadProxy$1(TPDownloadProxy paramTPDownloadProxy) {}
  
  public void onAvailable(Network paramNetwork)
  {
    super.onAvailable(paramNetwork);
    TPListenerManager.getInstance().setNetwork(paramNetwork);
    long l = paramNetwork.getNetworkHandle();
    paramNetwork = new StringBuilder();
    paramNetwork.append("cellular_network, net_id_t: ");
    paramNetwork.append(l);
    TPDLProxyLog.i("FILE_NAME", 0, "tpdlnative", paramNetwork.toString());
    this.this$0.setUserData("cellular_network_interface_id", Long.valueOf(l));
  }
  
  public void onLost(Network paramNetwork)
  {
    super.onLost(paramNetwork);
    this.this$0.setUserData("cellular_network_interface_id", Integer.valueOf(0));
    TPDLProxyLog.i("FILE_NAME", 0, "tpdlnative", "cellular_network failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy.1
 * JD-Core Version:    0.7.0.1
 */