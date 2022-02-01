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
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.a.mServiceName);
        localStringBuilder1.append("BaseIPCClient registerServiceCallback");
        aa.a(localStringBuilder1.toString());
        this.a.registerServiceCallback();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("<onServiceConnected> service wrong, e = ");
      localStringBuilder2.append(localException.getMessage());
      ab.e("BaseIPCClient", localStringBuilder2.toString());
      return;
      this.a.onDownloadSDKServiceInvalid();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      label97:
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.c
 * JD-Core Version:    0.7.0.1
 */