package com.tencent.tmassistantbase.network;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class b
  extends Handler
{
  private WeakReference<NetworkMonitorReceiver> a;
  
  public b(NetworkMonitorReceiver paramNetworkMonitorReceiver)
  {
    this.a = new WeakReference(paramNetworkMonitorReceiver);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NetworkMonitorReceiver localNetworkMonitorReceiver = (NetworkMonitorReceiver)this.a.get();
    if ((paramMessage.what == 67) && (localNetworkMonitorReceiver != null)) {
      localNetworkMonitorReceiver.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.b
 * JD-Core Version:    0.7.0.1
 */