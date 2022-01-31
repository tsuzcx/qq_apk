package eipc;

import android.os.Bundle;
import android.os.IBinder;
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
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "callModuleAsync ," + paramString1 + "," + paramString2 + "," + paramInt1 + ", " + paramInt2);
    }
    for (;;)
    {
      synchronized (this.this$0.mModuleMap)
      {
        EIPCModule localEIPCModule2 = (EIPCModule)this.this$0.mModuleMap.get(paramString1);
        EIPCModule localEIPCModule1 = localEIPCModule2;
        if (localEIPCModule2 == null)
        {
          localEIPCModule1 = localEIPCModule2;
          if (this.this$0.ipcModuleFactory != null)
          {
            localEIPCModule2 = this.this$0.ipcModuleFactory.onCreateModule(paramString1);
            localEIPCModule1 = localEIPCModule2;
            if (localEIPCModule2 != null)
            {
              this.this$0.registerModule(localEIPCModule2);
              localEIPCModule1 = localEIPCModule2;
            }
          }
        }
        if (localEIPCModule1 != null)
        {
          EIPCModuleManager.excuteOnAsyncThread(new EIPCModuleManager.1.1(this, localEIPCModule1, paramString2, paramBundle, 1000000 * paramInt2 + paramInt1));
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
    synchronized (this.this$0.mCallbackMap)
    {
      EIPCResultCallback localEIPCResultCallback = (EIPCResultCallback)this.this$0.mCallbackMap.get(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("EIPCConst", 2, "callback callbackId," + paramInt + "," + localEIPCResultCallback + ", " + this + MobileQQ.processName);
      }
      if (localEIPCResultCallback != null) {
        localEIPCResultCallback.onCallback(paramEIPCResult);
      }
      this.this$0.mCallbackMap.remove(paramInt);
      return;
    }
  }
  
  public String getProcName()
  {
    return MobileQQ.processName;
  }
  
  public int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2)
  {
    return this.this$0.setClient(paramString, paramInt1, paramEIPCChannel, paramInt2);
  }
  
  public IBinder setStubBinder(int paramInt, IBinder paramIBinder)
  {
    return this.this$0.onSetStubBinder(paramInt, paramIBinder);
  }
  
  public EIPCResult sync(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "callModule ," + paramString1 + "," + paramString2);
    }
    if (TextUtils.equals("__event_module", paramString1))
    {
      this.this$0.dispatchMsgToModule(paramInt, paramBundle);
      return null;
    }
    for (;;)
    {
      synchronized (this.this$0.mModuleMap)
      {
        EIPCModule localEIPCModule1 = (EIPCModule)this.this$0.mModuleMap.get(paramString1);
        EIPCModule localEIPCModule2 = localEIPCModule1;
        if (localEIPCModule1 == null)
        {
          if (this.this$0.ipcModuleFactory != null) {
            localEIPCModule1 = this.this$0.ipcModuleFactory.onCreateModule(paramString1);
          }
          this.this$0.registerModule(localEIPCModule1);
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