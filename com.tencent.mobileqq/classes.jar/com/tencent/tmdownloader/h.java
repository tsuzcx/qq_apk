package com.tencent.tmdownloader;

import android.os.RemoteException;
import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.remote.a;

class h
  implements Runnable
{
  h(f paramf) {}
  
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
            r.c("RemoteOpProxy", "<initSDKReportManager2> process:" + m.e() + ", mServiceInterface is ok");
          }
          return;
        }
        r.c("RemoteOpProxy", "<initSDKReportManager2> process:" + m.e() + ", mServiceInterface is null, post the operation");
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        r.e("RemoteOpProxy", "initSDKReportManager2 failed,mServiceInterface");
        return;
      }
    }
    try
    {
      r.c("RemoteOpProxy", "<initSDKReportManager2> process:" + m.e() + ", getServiceInterface()");
      a locala1 = (a)this.a.getServiceInterface();
      if (locala1 != null)
      {
        locala1.a();
        return;
      }
    }
    catch (Exception localException)
    {
      r.c("RemoteOpProxy", "<initSDKReportManager2> process:" + m.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.h
 * JD-Core Version:    0.7.0.1
 */