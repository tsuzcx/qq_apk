package com.tencent.tmdownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.tmassistantbase.util.r;

class c
  implements Runnable
{
  c(a parama, IBinder paramIBinder) {}
  
  public void run()
  {
    this.b.stubAsInterface(this.a);
    this.b.connectState = "FINISH";
    synchronized (this.b.mThreadlock)
    {
      this.b.mThreadlock.notifyAll();
      r.c("BaseIPCClient", "onServiceConnected,clientKey:" + this.b.mClientKey + ",mServiceInterface:" + this.b.mServiceInterface + ",IBinder:" + this.a + ",threadId:" + Thread.currentThread().getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.c
 * JD-Core Version:    0.7.0.1
 */