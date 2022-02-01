package com.tencent.tmdownloader;

import android.os.RemoteException;
import com.tencent.tmassistantbase.util.aa;
import com.tencent.tmassistantbase.util.ab;

class c
  implements Runnable
{
  c(a parama) {}
  
  public void run()
  {
    try
    {
      if ((this.a.mServiceInterface != null) && (this.a.mServiceCallback != null))
      {
        aa.a(this.a.mServiceName + "BaseIPCClient registerServiceCallback");
        this.a.registerServiceCallback();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.a.onDownloadSDKServiceInvalid();
      return;
    }
    catch (Exception localException)
    {
      ab.e("BaseIPCClient", "<onServiceConnected> service wrong, e = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.c
 * JD-Core Version:    0.7.0.1
 */