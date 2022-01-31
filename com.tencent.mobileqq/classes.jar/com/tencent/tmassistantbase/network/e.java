package com.tencent.tmassistantbase.network;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class e
  extends Handler
{
  private WeakReference<NetworkMonitorReceiver> a;
  
  public e(NetworkMonitorReceiver paramNetworkMonitorReceiver)
  {
    this.a = new WeakReference(paramNetworkMonitorReceiver);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NetworkMonitorReceiver localNetworkMonitorReceiver = (NetworkMonitorReceiver)this.a.get();
    if ((paramMessage.what == 67) && (localNetworkMonitorReceiver != null)) {
      localNetworkMonitorReceiver.notifyNetworkChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.e
 * JD-Core Version:    0.7.0.1
 */