package eipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import mqq.app.MobileQQ;

public class EIPCConnection
{
  String a = "";
  boolean b = true;
  EIPCModuleManager c;
  public int clientId;
  EIPCChannel d;
  int e;
  public String procName;
  
  public EIPCConnection(EIPCChannel paramEIPCChannel, String paramString)
  {
    this.d = paramEIPCChannel;
    this.procName = paramString;
  }
  
  public EIPCResult callModule(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    return this.d.sync(paramString1, paramString2, paramBundle, -99999);
  }
  
  public EIPCResult callModule(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
    throws RemoteException
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    return this.d.sync(paramString1, paramString2, paramBundle, paramInt);
  }
  
  public EIPCResult callModuleAsync(String paramString1, String paramString2, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
    throws RemoteException
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    int i = this.c.a(paramEIPCResultCallback);
    return this.d.async(paramString1, paramString2, paramBundle, i, this.e);
  }
  
  public boolean isAvailable()
  {
    IBinder localIBinder = this.d.asBinder();
    return (this.b) && (localIBinder.isBinderAlive()) && (localIBinder.pingBinder());
  }
  
  public IBinder setStubBinder(int paramInt, IBinder paramIBinder)
    throws RemoteException
  {
    return this.d.setStubBinder(paramInt, paramIBinder);
  }
  
  public String toString()
  {
    return this.a + ", EIPCConnection[procName=" + this.procName + ", clientId=" + this.clientId + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCConnection
 * JD-Core Version:    0.7.0.1
 */