package eipc;

import android.os.Bundle;
import android.os.RemoteException;
import mqq.app.MobileQQ;

class EIPCClient$1
  implements EIPClientConnectListener
{
  EIPCClient$1(EIPCClient paramEIPCClient, Bundle paramBundle, String paramString1, String paramString2, EIPCResultCallback paramEIPCResultCallback) {}
  
  public void connectFailed()
  {
    if (this.val$callback != null) {
      this.val$callback.onCallback(EIPCResult.createResult(-2, null));
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    paramEIPCConnection = null;
    for (;;)
    {
      try
      {
        if (this.val$params != null) {
          this.val$params.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        localEIPCConnection = this.this$0.mServerConnection;
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
      if ((paramEIPCConnection != null) && (this.val$callback != null)) {
        this.val$callback.onCallback(paramEIPCConnection);
      }
      return;
      if (!localEIPCConnection.isAvailable()) {
        paramEIPCConnection = EIPCResult.createResult(-2, null);
      } else {
        localEIPCConnection.callModuleAsync(this.val$module, this.val$action, this.val$params, this.val$callback);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCClient.1
 * JD-Core Version:    0.7.0.1
 */