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
    if (this.a.mServiceInterface != null) {}
    try
    {
      synchronized (this.a)
      {
        Object localObject2 = (a)this.a.mServiceInterface;
        if (localObject2 != null)
        {
          ((a)localObject2).a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("<initSDKReportManager2> process:");
          ((StringBuilder)localObject2).append(s.e());
          ((StringBuilder)localObject2).append(", mServiceInterface is ok");
          ab.c("RemoteOpProxy", ((StringBuilder)localObject2).toString());
        }
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      return;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<initSDKReportManager2> process:");
      ((StringBuilder)localObject1).append(s.e());
      ((StringBuilder)localObject1).append(", mServiceInterface is null, post the operation");
      ab.c("RemoteOpProxy", ((StringBuilder)localObject1).toString());
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("<initSDKReportManager2> process:");
        ((StringBuilder)localObject1).append(s.e());
        ((StringBuilder)localObject1).append(", getServiceInterface()");
        ab.c("RemoteOpProxy", ((StringBuilder)localObject1).toString());
        localObject1 = (a)this.a.getServiceInterface();
        if (localObject1 != null)
        {
          ((a)localObject1).a();
          return;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<initSDKReportManager2> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", getServiceInterface() error, error msg = ");
        localStringBuilder.append(localException.getMessage());
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        localException.printStackTrace();
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label85:
      break label85;
    }
    ab.e("RemoteOpProxy", "initSDKReportManager2 failed,mServiceInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.i
 * JD-Core Version:    0.7.0.1
 */