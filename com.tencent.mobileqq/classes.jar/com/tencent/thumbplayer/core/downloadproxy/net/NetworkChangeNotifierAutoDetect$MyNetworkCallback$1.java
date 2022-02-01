package com.tencent.thumbplayer.core.downloadproxy.net;

import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;

class NetworkChangeNotifierAutoDetect$MyNetworkCallback$1
  implements Runnable
{
  NetworkChangeNotifierAutoDetect$MyNetworkCallback$1(NetworkChangeNotifierAutoDetect.MyNetworkCallback paramMyNetworkCallback, long paramLong, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAvailable, netId:");
    localStringBuilder.append(this.val$netId);
    TPDLProxyLog.d("NetworkChangeNotifierAutoDetect.java", 0, "tpdlnative", localStringBuilder.toString());
    NetworkChangeNotifierAutoDetect.access$300(this.this$1.this$0).onNetworkConnect(this.val$netId, this.val$connectionType);
    if (this.val$makeVpnDefault)
    {
      NetworkChangeNotifierAutoDetect.access$300(this.this$1.this$0).onConnectionTypeChanged(this.val$connectionType);
      NetworkChangeNotifierAutoDetect.access$300(this.this$1.this$0).purgeActiveNetworkList(new long[] { this.val$netId });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.1
 * JD-Core Version:    0.7.0.1
 */