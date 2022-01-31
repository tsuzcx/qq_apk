package eipc;

import android.os.Bundle;
import android.os.RemoteException;
import mqq.app.MobileQQ;

class EIPCClient$2
  implements EIPClientConnectListener
{
  EIPCClient$2(EIPCClient paramEIPCClient, Bundle paramBundle, String paramString1, String paramString2, EIPCResultCallback paramEIPCResultCallback) {}
  
  public void connectFailed()
  {
    if (this.d != null) {
      this.d.onCallback(EIPCResult.createResult(-2, null));
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    paramEIPCConnection = null;
    for (;;)
    {
      try
      {
        if (this.a != null) {
          this.a.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        localEIPCConnection = this.e.d;
        if (localEIPCConnection != null) {
          continue;
        }
        paramEIPCConnection = EIPCResult.createResult(-1, null);
      }
      catch (RemoteException paramEIPCConnection)
      {
        EIPCConnection localEIPCConnection;
        paramEIPCConnection.printStackTrace();
        paramEIPCConnection = EIPCResult.createExceptionResult(paramEIPCConnection);
        continue;
      }
      catch (Throwable paramEIPCConnection)
      {
        paramEIPCConnection.printStackTrace();
        paramEIPCConnection = EIPCResult.createExceptionResult(paramEIPCConnection);
        continue;
      }
      if ((paramEIPCConnection != null) && (this.d != null)) {
        this.d.onCallback(paramEIPCConnection);
      }
      return;
      if (!localEIPCConnection.isAvailable()) {
        paramEIPCConnection = EIPCResult.createResult(-2, null);
      } else {
        localEIPCConnection.callModuleAsync(this.b, this.c, this.a, this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCClient.2
 * JD-Core Version:    0.7.0.1
 */