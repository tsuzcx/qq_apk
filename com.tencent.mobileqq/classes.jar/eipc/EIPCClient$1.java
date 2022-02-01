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
    EIPCResultCallback localEIPCResultCallback = this.val$callback;
    if (localEIPCResultCallback != null) {
      localEIPCResultCallback.onCallback(EIPCResult.createResult(-2, null));
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    Object localObject;
    try
    {
      if (this.val$params != null) {
        this.val$params.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
      }
      localObject = this.this$0.mServerConnection;
      paramEIPCConnection = null;
      if (localObject == null) {
        paramEIPCConnection = EIPCResult.createResult(-1, null);
      } else if (!((EIPCConnection)localObject).isAvailable()) {
        paramEIPCConnection = EIPCResult.createResult(-2, null);
      } else {
        ((EIPCConnection)localObject).callModuleAsync(this.val$module, this.val$action, this.val$params, this.val$callback);
      }
    }
    catch (Throwable paramEIPCConnection)
    {
      paramEIPCConnection.printStackTrace();
      paramEIPCConnection = EIPCResult.createExceptionResult(paramEIPCConnection);
    }
    catch (RemoteException paramEIPCConnection)
    {
      paramEIPCConnection.printStackTrace();
      paramEIPCConnection = EIPCResult.createExceptionResult(paramEIPCConnection);
    }
    if (paramEIPCConnection != null)
    {
      localObject = this.val$callback;
      if (localObject != null) {
        ((EIPCResultCallback)localObject).onCallback(paramEIPCConnection);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCClient.1
 * JD-Core Version:    0.7.0.1
 */