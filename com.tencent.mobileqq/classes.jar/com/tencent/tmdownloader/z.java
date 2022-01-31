package com.tencent.tmdownloader;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.tmassistant.aidl.a;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.n;
import java.util.List;

class z
  implements n
{
  z(y paramy) {}
  
  public void a(List<String> paramList)
  {
    synchronized (this.a.a.mCallbacks)
    {
      try
      {
        ac.c("TMADownloadSDKService", "onLogPrint : ");
        int j = this.a.a.mCallbacks.beginBroadcast();
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              ((a)this.a.a.mCallbacks.getBroadcastItem(i)).a(paramList);
              i += 1;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                ac.c("TMADownloadSDKService", "exception: ", localRemoteException);
              }
            }
          }
        }
        try
        {
          this.a.a.mCallbacks.finishBroadcast();
          Log.e("TMADownloadSDKService", getClass().getSimpleName() + " finishBroadcast mRemoteListeners");
          for (;;)
          {
            return;
            this.a.a.mCallbacks.finishBroadcast();
          }
          paramList = finally;
          throw paramList;
        }
        catch (IllegalStateException paramList)
        {
          for (;;)
          {
            Log.w("TMADownloadSDKService", "Error while diffusing message to listener finishBroadcast:", paramList);
          }
        }
      }
      catch (Throwable paramList)
      {
        Log.e("TMADownloadSDKService", "exception: ", paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.z
 * JD-Core Version:    0.7.0.1
 */