package eipc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

abstract class EIPCModuleManager
{
  public static final int INTERVAL = 1000000;
  public static final int MSG_CALL_MODULE_AYSNC = 1;
  static final String g = "__event_module";
  static Handler l;
  public EIPCChannel channel;
  int h;
  HashSet i = new HashSet();
  public EIPCModuleFactory ipcModuleFactory;
  SparseArray j = new SparseArray();
  ConcurrentHashMap k = new ConcurrentHashMap();
  public final AtomicInteger mCallbackId = new AtomicInteger(1000);
  public SparseArray mCallbackMap = new SparseArray();
  public Context mContext;
  public SparseArray mProcMap = new SparseArray();
  
  public EIPCModuleManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.channel = new EIPCModuleManager.1(this);
  }
  
  static Handler a()
  {
    try
    {
      if (l == null)
      {
        localObject1 = new HandlerThread("ipc", 10);
        ((HandlerThread)localObject1).start();
        l = new Handler(((HandlerThread)localObject1).getLooper());
      }
      Object localObject1 = l;
      return localObject1;
    }
    finally {}
  }
  
  private void a(Runnable paramRunnable)
  {
    if (QIPCClientHelper.sThreadEngine != null)
    {
      QIPCClientHelper.sThreadEngine.excute(paramRunnable);
      return;
    }
    a().post(paramRunnable);
  }
  
  int a(EIPCResultCallback paramEIPCResultCallback)
  {
    int m = this.mCallbackId.addAndGet(1);
    SparseArray localSparseArray = this.mCallbackMap;
    if (paramEIPCResultCallback != null) {}
    try
    {
      this.mCallbackMap.put(m, paramEIPCResultCallback);
      return m;
    }
    finally {}
  }
  
  void a(int paramInt, Bundle paramBundle)
  {
    for (;;)
    {
      int m;
      synchronized (this.j)
      {
        ArrayList localArrayList = (ArrayList)this.j.get(paramInt);
        if (localArrayList == null) {
          return;
        }
        m = localArrayList.size() - 1;
        if (m >= 0)
        {
          EIPCModule localEIPCModule = (EIPCModule)((WeakReference)localArrayList.get(m)).get();
          if (localEIPCModule != null) {
            localEIPCModule.onReceiveMsg(paramInt, paramBundle);
          } else {
            localArrayList.remove(m);
          }
        }
      }
      return;
      m -= 1;
    }
  }
  
  public void addListener(EIPCOnGetConnectionListener paramEIPCOnGetConnectionListener)
  {
    this.i.add(paramEIPCOnGetConnectionListener);
  }
  
  public abstract void callbackResult(int paramInt, EIPCResult paramEIPCResult);
  
  public void destroy()
  {
    this.k.clear();
  }
  
  public void notifyBind(EIPCConnection paramEIPCConnection)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EIPCConst", 2, "connection b, " + paramEIPCConnection);
    }
    Iterator localIterator = ((HashSet)this.i.clone()).iterator();
    while (localIterator.hasNext()) {
      ((EIPCOnGetConnectionListener)localIterator.next()).onConnectBind(paramEIPCConnection);
    }
  }
  
  public void notifyUnbind(EIPCConnection paramEIPCConnection)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EIPCConst", 2, "connection unbind, " + paramEIPCConnection);
    }
    Iterator localIterator = ((HashSet)this.i.clone()).iterator();
    while (localIterator.hasNext()) {
      ((EIPCOnGetConnectionListener)localIterator.next()).onConnectUnbind(paramEIPCConnection);
    }
  }
  
  public IBinder onSetStubBinder(int paramInt, IBinder paramIBinder)
  {
    return null;
  }
  
  public void registerModule(EIPCModule paramEIPCModule)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "registerModule ," + paramEIPCModule);
    }
    paramEIPCModule.a = this;
    synchronized (this.k)
    {
      if (!this.k.containsKey(paramEIPCModule.name))
      {
        int[] arrayOfInt = paramEIPCModule.b;
        int n = arrayOfInt.length;
        int m = 0;
        while (m < n)
        {
          int i1 = arrayOfInt[m];
          ArrayList localArrayList2 = (ArrayList)this.j.get(i1);
          ArrayList localArrayList1 = localArrayList2;
          if (localArrayList2 == null)
          {
            localArrayList1 = new ArrayList();
            this.j.put(i1, localArrayList1);
          }
          localArrayList1.add(new WeakReference(paramEIPCModule));
          m += 1;
        }
        this.k.put(paramEIPCModule.name, paramEIPCModule);
        return;
      }
      throw new RuntimeException("Module duplicated, " + paramEIPCModule.name);
    }
  }
  
  public void removeCallback(EIPCResultCallback paramEIPCResultCallback)
  {
    for (;;)
    {
      int m;
      synchronized (this.mCallbackMap)
      {
        m = this.mCallbackMap.size() - 1;
        if (m >= 0)
        {
          if ((EIPCResultCallback)this.mCallbackMap.valueAt(m) == paramEIPCResultCallback) {
            this.mCallbackMap.removeAt(m);
          }
        }
        else {
          return;
        }
      }
      m -= 1;
    }
  }
  
  public void removeListener(EIPCOnGetConnectionListener paramEIPCOnGetConnectionListener)
  {
    this.i.remove(paramEIPCOnGetConnectionListener);
  }
  
  public void sendMsgToLocalModule(int paramInt, Bundle paramBundle)
  {
    a(paramInt, paramBundle);
  }
  
  public int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2)
    throws RemoteException
  {
    return 1;
  }
  
  public void setModuleFactory(EIPCModuleFactory paramEIPCModuleFactory)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "initEnvironment");
    }
    this.ipcModuleFactory = paramEIPCModuleFactory;
  }
  
  public void unRegisterModule(EIPCModule paramEIPCModule)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "unRegisterModule ," + paramEIPCModule);
    }
    synchronized (this.k)
    {
      this.k.remove(paramEIPCModule.name);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCModuleManager
 * JD-Core Version:    0.7.0.1
 */