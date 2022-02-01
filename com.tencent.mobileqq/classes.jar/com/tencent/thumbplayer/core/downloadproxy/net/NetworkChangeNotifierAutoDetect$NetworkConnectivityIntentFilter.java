package com.tencent.thumbplayer.core.downloadproxy.net;

import android.annotation.SuppressLint;
import android.content.IntentFilter;

@SuppressLint({"NewApi", "ParcelCreator"})
class NetworkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter
  extends IntentFilter
{
  NetworkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter()
  {
    addAction("android.net.conn.CONNECTIVITY_CHANGE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect.NetworkConnectivityIntentFilter
 * JD-Core Version:    0.7.0.1
 */