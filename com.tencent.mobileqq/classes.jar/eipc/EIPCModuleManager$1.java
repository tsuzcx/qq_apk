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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callModuleAsync ,");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("EIPCConst", 2, ((StringBuilder)localObject).toString());
    }
    synchronized (this.this$0.mModuleMap)
    {
      EIPCModule localEIPCModule = (EIPCModule)this.this$0.mModuleMap.get(paramString1);
      localObject = localEIPCModule;
      if (localEIPCModule == null)
      {
        localObject = localEIPCModule;
        if (this.this$0.ipcModuleFactory != null)
        {
          localEIPCModule = this.this$0.ipcModuleFactory.onCreateModule(paramString1);
          localObject = localEIPCModule;
          if (localEIPCModule != null)
          {
            this.this$0.registerModule(localEIPCModule);
            localObject = localEIPCModule;
          }
        }
      }
      if (localObject != null)
      {
        EIPCModuleManager.excuteOnAsyncThread(new EIPCModuleManager.1.1(this, (EIPCModule)localObject, paramString2, paramBundle, paramInt2 * 1000000 + paramInt1));
      }
      else if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("callModuleAsync no found,");
        paramBundle.append(paramString1);
        paramBundle.append(",");
        paramBundle.append(paramString2);
        QLog.w("EIPCConst", 2, paramBundle.toString());
      }
      return null;
    }
  }
  
  public void callback(int paramInt, EIPCResult paramEIPCResult)
  {
    synchronized (this.this$0.mCallbackMap)
    {
      EIPCResultCallback localEIPCResultCallback = (EIPCResultCallback)this.this$0.mCallbackMap.get(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("callback callbackId,");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",");
        localStringBuilder.append(localEIPCResultCallback);
        localStringBuilder.append(", ");
        localStringBuilder.append(this);
        localStringBuilder.append(MobileQQ.processName);
        QLog.d("EIPCConst", 2, localStringBuilder.toString());
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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("callModule ,");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("EIPCConst", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.equals("__event_module", paramString1))
    {
      this.this$0.dispatchMsgToModule(paramInt, paramBundle);
      return null;
    }
    synchronized (this.this$0.mModuleMap)
    {
      localObject1 = (EIPCModule)this.this$0.mModuleMap.get(paramString1);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (this.this$0.ipcModuleFactory != null) {
          localObject1 = this.this$0.ipcModuleFactory.onCreateModule(paramString1);
        }
        this.this$0.registerModule((EIPCModule)localObject1);
        localObject2 = localObject1;
      }
      if (localObject2 != null) {
        return localObject2.onCall(paramString2, paramBundle, -1);
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("callModule no found,");
        paramBundle.append(paramString1);
        paramBundle.append(",");
        paramBundle.append(paramString2);
        QLog.w("EIPCConst", 2, paramBundle.toString());
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCModuleManager.1
 * JD-Core Version:    0.7.0.1
 */