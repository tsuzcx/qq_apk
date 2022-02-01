package com.tencent.thumbplayer.core.downloadproxy.net;

import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.Arrays;

class NetworkChangeNotifier$2
  implements NetworkChangeNotifierAutoDetect.Observer
{
  NetworkChangeNotifier$2(NetworkChangeNotifier paramNetworkChangeNotifier) {}
  
  public void onConnectionSubtypeChanged(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConnectionSubtypeChanged, newConnectionSubtype:");
    localStringBuilder.append(paramInt);
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
    this.this$0.notifyObserversOfConnectionSubtypeChange(paramInt);
  }
  
  public void onConnectionTypeChanged(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConnectionTypeChanged, newConnectionType:");
    localStringBuilder.append(paramInt);
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
    NetworkChangeNotifier.access$100(this.this$0, paramInt);
  }
  
  public void onNetworkConnect(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetworkConnect, connectionType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", netId:");
    localStringBuilder.append(paramLong);
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
    this.this$0.notifyObserversOfNetworkConnect(paramLong, paramInt);
  }
  
  public void onNetworkDisconnect(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetworkDisconnect, netId:");
    localStringBuilder.append(paramLong);
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
    this.this$0.notifyObserversOfNetworkDisconnect(paramLong);
  }
  
  public void onNetworkSoonToDisconnect(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetworkSoonToDisconnect, netId:");
    localStringBuilder.append(paramLong);
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
    this.this$0.notifyObserversOfNetworkSoonToDisconnect(paramLong);
  }
  
  public void purgeActiveNetworkList(long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("purgeActiveNetworkList, activeNetIds:");
    localStringBuilder.append(Arrays.toString(paramArrayOfLong));
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
    this.this$0.notifyObserversToPurgeActiveNetworkList(paramArrayOfLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifier.2
 * JD-Core Version:    0.7.0.1
 */