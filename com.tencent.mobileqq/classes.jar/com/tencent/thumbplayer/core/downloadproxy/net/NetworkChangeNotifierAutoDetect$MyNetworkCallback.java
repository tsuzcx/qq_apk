package com.tencent.thumbplayer.core.downloadproxy.net;

import android.annotation.TargetApi;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;

@TargetApi(21)
class NetworkChangeNotifierAutoDetect$MyNetworkCallback
  extends ConnectivityManager.NetworkCallback
{
  private Network mVpnInPlace;
  
  static
  {
    if (!NetworkChangeNotifierAutoDetect.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private NetworkChangeNotifierAutoDetect$MyNetworkCallback(NetworkChangeNotifierAutoDetect paramNetworkChangeNotifierAutoDetect) {}
  
  private boolean ignoreConnectedInaccessibleVpn(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
  {
    NetworkCapabilities localNetworkCapabilities = paramNetworkCapabilities;
    if (paramNetworkCapabilities == null) {
      localNetworkCapabilities = NetworkChangeNotifierAutoDetect.access$200(this.this$0).getNetworkCapabilities(paramNetwork);
    }
    return (localNetworkCapabilities == null) || ((localNetworkCapabilities.hasTransport(4)) && (!NetworkChangeNotifierAutoDetect.access$200(this.this$0).vpnAccessible(paramNetwork)));
  }
  
  private boolean ignoreConnectedNetwork(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
  {
    return (ignoreNetworkDueToVpn(paramNetwork)) || (ignoreConnectedInaccessibleVpn(paramNetwork, paramNetworkCapabilities));
  }
  
  private boolean ignoreNetworkDueToVpn(Network paramNetwork)
  {
    return (this.mVpnInPlace != null) && (!this.mVpnInPlace.equals(paramNetwork));
  }
  
  void initializeVpnInPlace()
  {
    Network[] arrayOfNetwork = NetworkUtil.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.access$200(this.this$0), null);
    this.mVpnInPlace = null;
    if (arrayOfNetwork.length == 1)
    {
      NetworkCapabilities localNetworkCapabilities = NetworkChangeNotifierAutoDetect.access$200(this.this$0).getNetworkCapabilities(arrayOfNetwork[0]);
      if ((localNetworkCapabilities != null) && (localNetworkCapabilities.hasTransport(4))) {
        this.mVpnInPlace = arrayOfNetwork[0];
      }
    }
  }
  
  public void onAvailable(Network paramNetwork)
  {
    NetworkCapabilities localNetworkCapabilities = NetworkChangeNotifierAutoDetect.access$200(this.this$0).getNetworkCapabilities(paramNetwork);
    if (ignoreConnectedNetwork(paramNetwork, localNetworkCapabilities)) {
      return;
    }
    boolean bool = localNetworkCapabilities.hasTransport(4);
    if (bool) {
      this.mVpnInPlace = paramNetwork;
    }
    long l = NetworkUtil.networkToNetId(paramNetwork);
    int i = NetworkChangeNotifierAutoDetect.access$200(this.this$0).getConnectionType(paramNetwork);
    NetworkChangeNotifierAutoDetect.access$400(this.this$0, new NetworkChangeNotifierAutoDetect.MyNetworkCallback.1(this, l, i, bool));
  }
  
  public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
  {
    if (ignoreConnectedNetwork(paramNetwork, paramNetworkCapabilities)) {
      return;
    }
    long l = NetworkUtil.networkToNetId(paramNetwork);
    TPDLProxyLog.d("NetworkChangeNotifierAutoDetect.java", 0, "tpdlnative", "onCapabilitiesChanged, netId:" + l);
    int i = NetworkChangeNotifierAutoDetect.access$200(this.this$0).getConnectionType(paramNetwork);
    NetworkChangeNotifierAutoDetect.access$400(this.this$0, new NetworkChangeNotifierAutoDetect.MyNetworkCallback.2(this, l, i));
  }
  
  public void onLosing(Network paramNetwork, int paramInt)
  {
    if (ignoreConnectedNetwork(paramNetwork, null)) {
      return;
    }
    long l = NetworkUtil.networkToNetId(paramNetwork);
    TPDLProxyLog.d("NetworkChangeNotifierAutoDetect.java", 0, "tpdlnative", "onLosing, netId:" + l);
    NetworkChangeNotifierAutoDetect.access$400(this.this$0, new NetworkChangeNotifierAutoDetect.MyNetworkCallback.3(this, l));
  }
  
  public void onLost(Network paramNetwork)
  {
    int i = 0;
    if (ignoreNetworkDueToVpn(paramNetwork)) {}
    do
    {
      return;
      long l = NetworkUtil.networkToNetId(paramNetwork);
      TPDLProxyLog.d("NetworkChangeNotifierAutoDetect.java", 0, "tpdlnative", "onLost, netId:" + l);
      NetworkChangeNotifierAutoDetect.access$400(this.this$0, new NetworkChangeNotifierAutoDetect.MyNetworkCallback.4(this, l));
    } while (this.mVpnInPlace == null);
    assert (paramNetwork.equals(this.mVpnInPlace));
    this.mVpnInPlace = null;
    paramNetwork = NetworkUtil.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.access$200(this.this$0), paramNetwork);
    int j = paramNetwork.length;
    while (i < j)
    {
      onAvailable(paramNetwork[i]);
      i += 1;
    }
    i = this.this$0.getCurrentNetworkState().getConnectionType();
    NetworkChangeNotifierAutoDetect.access$400(this.this$0, new NetworkChangeNotifierAutoDetect.MyNetworkCallback.5(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback
 * JD-Core Version:    0.7.0.1
 */