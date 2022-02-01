package com.tencent.tfm.metrics;

import android.os.Looper;

class NetworkStateReceiver$1
  extends Thread
{
  NetworkStateReceiver$1(NetworkStateReceiver paramNetworkStateReceiver, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    Looper.prepare();
    NetworkStateReceiver.access$002(this.this$0, new NetworkStateReceiver.NetworkUpdateHandler(null));
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.NetworkStateReceiver.1
 * JD-Core Version:    0.7.0.1
 */