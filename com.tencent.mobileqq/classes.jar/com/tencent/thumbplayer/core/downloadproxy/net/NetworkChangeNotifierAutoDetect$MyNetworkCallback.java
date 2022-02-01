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
    Network localNetwork = this.mVpnInPlace;
    return (localNetwork != null) && (!localNetwork.equals(paramNetwork));
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
    paramNetworkCapabilities = new StringBuilder();
    paramNetworkCapabilities.append("onCapabilitiesChanged, netId:");
    paramNetworkCapabilities.append(l);
    TPDLProxyLog.d("NetworkChangeNotifierAutoDetect.java", 0, "tpdlnative", paramNetworkCapabilities.toString());
    int i = NetworkChangeNotifierAutoDetect.access$200(this.this$0).getConnectionType(paramNetwork);
    NetworkChangeNotifierAutoDetect.access$400(this.this$0, new NetworkChangeNotifierAutoDetect.MyNetworkCallback.2(this, l, i));
  }
  
  public void onLosing(Network paramNetwork, int paramInt)
  {
    if (ignoreConnectedNetwork(paramNetwork, null)) {
      return;
    }
    long l = NetworkUtil.networkToNetId(paramNetwork);
    paramNetwork = new StringBuilder();
    paramNetwork.append("onLosing, netId:");
    paramNetwork.append(l);
    TPDLProxyLog.d("NetworkChangeNotifierAutoDetect.java", 0, "tpdlnative", paramNetwork.toString());
    NetworkChangeNotifierAutoDetect.access$400(this.this$0, new NetworkChangeNotifierAutoDetect.MyNetworkCallback.3(this, l));
  }
  
  public void onLost(Network paramNetwork)
  {
    if (ignoreNetworkDueToVpn(paramNetwork)) {
      return;
    }
    long l = NetworkUtil.networkToNetId(paramNetwork);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLost, netId:");
    ((StringBuilder)localObject).append(l);
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    TPDLProxyLog.d("NetworkChangeNotifierAutoDetect.java", 0, "tpdlnative", (String)localObject);
    NetworkChangeNotifierAutoDetect.access$400(this.this$0, new NetworkChangeNotifierAutoDetect.MyNetworkCallback.4(this, l));
    if (this.mVpnInPlace != null)
    {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback
 * JD-Core Version:    0.7.0.1
 */