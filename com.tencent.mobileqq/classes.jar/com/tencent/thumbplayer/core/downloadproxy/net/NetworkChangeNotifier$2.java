package com.tencent.thumbplayer.core.downloadproxy.net;

import android.os.Handler;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.Arrays;

class NetworkChangeNotifier$2
  implements NetworkChangeNotifierAutoDetect.Observer
{
  NetworkChangeNotifier$2(NetworkChangeNotifier paramNetworkChangeNotifier) {}
  
  public void onConnectionSubtypeChanged(int paramInt)
  {
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", "onConnectionSubtypeChanged, newConnectionSubtype:" + paramInt);
    this.this$0.notifyObserversOfConnectionSubtypeChange(paramInt);
  }
  
  public void onConnectionTypeChanged(int paramInt)
  {
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", "onConnectionTypeChanged, newConnectionType:" + paramInt);
    NetworkChangeNotifier.access$100(this.this$0, paramInt);
  }
  
  public void onNetworkConnect(long paramLong, int paramInt)
  {
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", "onNetworkConnect, connectionType:" + paramInt + ", netId:" + paramLong);
    this.this$0.notifyObserversOfNetworkConnect(paramLong, paramInt);
  }
  
  public void onNetworkDisconnect(long paramLong)
  {
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", "onNetworkDisconnect, netId:" + paramLong);
    NetworkChangeNotifier.access$200(this.this$0).postDelayed(new NetworkChangeNotifier.2.1(this, paramLong), 1000L);
  }
  
  public void onNetworkSoonToDisconnect(long paramLong)
  {
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", "onNetworkSoonToDisconnect, netId:" + paramLong);
    this.this$0.notifyObserversOfNetworkSoonToDisconnect(paramLong);
  }
  
  public void purgeActiveNetworkList(long[] paramArrayOfLong)
  {
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", "purgeActiveNetworkList, activeNetIds:" + Arrays.toString(paramArrayOfLong));
    this.this$0.notifyObserversToPurgeActiveNetworkList(paramArrayOfLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifier.2
 * JD-Core Version:    0.7.0.1
 */