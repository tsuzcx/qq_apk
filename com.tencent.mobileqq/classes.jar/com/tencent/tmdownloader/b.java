package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.r;

class b
  implements Runnable
{
  b(a parama) {}
  
  public void run()
  {
    r.c("BaseIPCClient", "onServiceDisconnected,clientKey:" + this.a.mClientKey);
    synchronized (this.a)
    {
      this.a.mServiceInterface = null;
      this.a.connectState = "INIT";
      synchronized (this.a.mThreadlock)
      {
        this.a.mThreadlock.notifyAll();
        this.a.onDownloadSDKServiceInvalid();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.b
 * JD-Core Version:    0.7.0.1
 */