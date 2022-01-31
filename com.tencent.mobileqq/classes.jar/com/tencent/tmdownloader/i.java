package com.tencent.tmdownloader;

import android.os.RemoteException;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.remote.a;

class i
  implements Runnable
{
  i(f paramf) {}
  
  public void run()
  {
    if (this.a.mServiceInterface != null) {
      try
      {
        synchronized (this.a)
        {
          a locala2 = (a)this.a.mServiceInterface;
          if (locala2 != null)
          {
            locala2.a();
            ab.c("RemoteOpProxy", "<initSDKReportManager2> process:" + s.e() + ", mServiceInterface is ok");
          }
          return;
        }
        ab.c("RemoteOpProxy", "<initSDKReportManager2> process:" + s.e() + ", mServiceInterface is null, post the operation");
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        ab.e("RemoteOpProxy", "initSDKReportManager2 failed,mServiceInterface");
        return;
      }
    }
    try
    {
      ab.c("RemoteOpProxy", "<initSDKReportManager2> process:" + s.e() + ", getServiceInterface()");
      a locala1 = (a)this.a.getServiceInterface();
      if (locala1 != null)
      {
        locala1.a();
        return;
      }
    }
    catch (Exception localException)
    {
      ab.c("RemoteOpProxy", "<initSDKReportManager2> process:" + s.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.i
 * JD-Core Version:    0.7.0.1
 */