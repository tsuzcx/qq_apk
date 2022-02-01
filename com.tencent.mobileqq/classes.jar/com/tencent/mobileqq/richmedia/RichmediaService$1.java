package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.RemoteException;

final class RichmediaService$1
  implements Runnable
{
  RichmediaService$1(int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (RichmediaService.a != null)
    {
      ICallBack localICallBack = RichmediaService.a.f;
      if (localICallBack != null) {
        try
        {
          LOG.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localICallBack.b(this.a, this.b);
          LOG.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("sendICallBackRequest cb.sendRequest ipc fail, RemoteException : ");
          localStringBuilder.append(localRemoteException.getMessage());
          LOG.a("RichmediaService", localStringBuilder.toString());
          return;
        }
      }
      LOG.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    LOG.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.1
 * JD-Core Version:    0.7.0.1
 */