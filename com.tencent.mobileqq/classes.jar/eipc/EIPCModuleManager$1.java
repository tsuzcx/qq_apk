package eipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

class EIPCModuleManager$1
  extends EIPCChannel.Stub
{
  EIPCModuleManager$1(EIPCModuleManager paramEIPCModuleManager) {}
  
  public EIPCResult async(String paramString1, String paramString2, Bundle paramBundle, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "callModuleAsync ," + paramString1 + "," + paramString2 + "," + paramInt1 + ", " + paramInt2);
    }
    for (;;)
    {
      synchronized (this.g.k)
      {
        EIPCModule localEIPCModule2 = (EIPCModule)this.g.k.get(paramString1);
        EIPCModule localEIPCModule1 = localEIPCModule2;
        if (localEIPCModule2 == null)
        {
          localEIPCModule1 = localEIPCModule2;
          if (this.g.ipcModuleFactory != null)
          {
            localEIPCModule2 = this.g.ipcModuleFactory.onCreateModule(paramString1);
            localEIPCModule1 = localEIPCModule2;
            if (localEIPCModule2 != null)
            {
              this.g.registerModule(localEIPCModule2);
              localEIPCModule1 = localEIPCModule2;
            }
          }
        }
        if (localEIPCModule1 != null)
        {
          EIPCModuleManager.a(this.g, new EIPCModuleManager.1.1(this, localEIPCModule1, paramString2, paramBundle, 1000000 * paramInt2 + paramInt1));
          return null;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("EIPCConst", 2, "callModuleAsync no found," + paramString1 + "," + paramString2);
      }
    }
  }
  
  public void callback(int paramInt, EIPCResult paramEIPCResult)
  {
    synchronized (this.g.mCallbackMap)
    {
      EIPCResultCallback localEIPCResultCallback = (EIPCResultCallback)this.g.mCallbackMap.get(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("EIPCConst", 2, "callback callbackId," + paramInt + "," + localEIPCResultCallback + ", " + this + MobileQQ.processName);
      }
      if (localEIPCResultCallback != null) {
        localEIPCResultCallback.onCallback(paramEIPCResult);
      }
      this.g.mCallbackMap.remove(paramInt);
      return;
    }
  }
  
  public String getProcName()
  {
    return MobileQQ.processName;
  }
  
  public int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2)
    throws RemoteException
  {
    return this.g.setClient(paramString, paramInt1, paramEIPCChannel, paramInt2);
  }
  
  public IBinder setStubBinder(int paramInt, IBinder paramIBinder)
  {
    return this.g.onSetStubBinder(paramInt, paramIBinder);
  }
  
  public EIPCResult sync(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "callModule ," + paramString1 + "," + paramString2);
    }
    if (TextUtils.equals("__event_module", paramString1))
    {
      this.g.a(paramInt, paramBundle);
      return null;
    }
    for (;;)
    {
      synchronized (this.g.k)
      {
        EIPCModule localEIPCModule1 = (EIPCModule)this.g.k.get(paramString1);
        EIPCModule localEIPCModule2 = localEIPCModule1;
        if (localEIPCModule1 == null)
        {
          if (this.g.ipcModuleFactory != null) {
            localEIPCModule1 = this.g.ipcModuleFactory.onCreateModule(paramString1);
          }
          this.g.registerModule(localEIPCModule1);
          localEIPCModule2 = localEIPCModule1;
        }
        if (localEIPCModule2 != null)
        {
          paramString1 = localEIPCModule2.onCall(paramString2, paramBundle, -1);
          return paramString1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("EIPCConst", 2, "callModule no found," + paramString1 + "," + paramString2);
      }
      paramString1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCModuleManager.1
 * JD-Core Version:    0.7.0.1
 */