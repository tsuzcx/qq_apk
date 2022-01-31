package com.tencent.qapmsdk.dns.network;

import android.os.Handler;
import android.os.HandlerThread;

final class NetworkHandler$DefaultNetworkHandler
  implements NetworkHandler.INetworkHandler
{
  Handler handler;
  NetworkUtils.NetworkType lastNetworkType;
  String lastSsid;
  NetworkUtils.NetworkType lastValidNetworkType;
  final Runnable networkChangedTask = new NetworkHandler.DefaultNetworkHandler.1(this);
  
  NetworkHandler$DefaultNetworkHandler()
  {
    HandlerThread localHandlerThread = new HandlerThread("httpdns_networkchanged");
    localHandlerThread.start();
    this.handler = new Handler(localHandlerThread.getLooper());
  }
  
  public void onNetworkChanged()
  {
    this.handler.removeCallbacks(this.networkChangedTask);
    this.handler.postDelayed(this.networkChangedTask, NetworkHandler.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.NetworkHandler.DefaultNetworkHandler
 * JD-Core Version:    0.7.0.1
 */