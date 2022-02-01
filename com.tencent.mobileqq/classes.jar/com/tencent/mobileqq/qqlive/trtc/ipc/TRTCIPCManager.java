package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.trtc.ITRTCEngine;
import com.tencent.mobileqq.qqlive.trtc.engine.QQLiveTRTCEngineImpl;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCFakeEngineImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;

public class TRTCIPCManager
  implements ITRTCIPCListener
{
  private static final ArrayList<String> a = new ArrayList();
  private final Queue<TRTCIPCManager.PendingIPCTask> b = new ConcurrentLinkedQueue();
  private ITRTCIPCListener c = null;
  
  static
  {
    a.add("Action_Client_Init_SDK");
    a.add("Action_Client_Room_Enter_Room");
  }
  
  private boolean a(TRTCIPCManager.PendingIPCTask paramPendingIPCTask)
  {
    return System.currentTimeMillis() - paramPendingIPCTask.a <= 10000L;
  }
  
  public static TRTCIPCManager b()
  {
    return TRTCIPCManager.InstanceHolder.a;
  }
  
  private boolean h()
  {
    boolean bool;
    if (MobileQQ.sProcessId == 7) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isRealHost: ");
    localStringBuilder.append(bool);
    QLog.d("TRTCIPCManager", 1, localStringBuilder.toString());
    return bool;
  }
  
  private boolean i()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TRTCIPCManager", 2, "onConnectUnbind");
    }
    ITRTCIPCListener localITRTCIPCListener = this.c;
    if (localITRTCIPCListener != null) {
      localITRTCIPCListener.a();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConnectBind ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TRTCIPCManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((ITRTCIPCListener)localObject).a(paramString);
    }
  }
  
  public boolean a(@NonNull String paramString, Bundle paramBundle)
  {
    if (!a.contains(paramString))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("not support pending task ");
      paramBundle.append(paramString);
      QLog.e("TRTCIPCManager", 1, paramBundle.toString());
      return false;
    }
    Object localObject2 = this.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (TRTCIPCManager.PendingIPCTask)((Iterator)localObject2).next();
      if (paramString.equals(((TRTCIPCManager.PendingIPCTask)localObject1).b))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addPendingTask----action = ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" already exist, update and return");
        QLog.e("TRTCIPCManager", 1, ((StringBuilder)localObject2).toString());
        ((TRTCIPCManager.PendingIPCTask)localObject1).a = System.currentTimeMillis();
        ((TRTCIPCManager.PendingIPCTask)localObject1).c = paramBundle;
        return true;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addPendingTask----action = ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("TRTCIPCManager", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new TRTCIPCManager.PendingIPCTask(this);
    ((TRTCIPCManager.PendingIPCTask)localObject1).a = System.currentTimeMillis();
    ((TRTCIPCManager.PendingIPCTask)localObject1).b = paramString;
    ((TRTCIPCManager.PendingIPCTask)localObject1).c = paramBundle;
    return this.b.add(localObject1);
  }
  
  public void b(@NonNull String paramString, Bundle paramBundle)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      TRTCIPCManager.PendingIPCTask localPendingIPCTask = (TRTCIPCManager.PendingIPCTask)localIterator.next();
      if (paramString.equals(localPendingIPCTask.b))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateTask----action = ");
        localStringBuilder.append(paramString);
        QLog.e("TRTCIPCManager", 1, localStringBuilder.toString());
        localPendingIPCTask.a = System.currentTimeMillis();
        if (paramBundle != null) {
          localPendingIPCTask.c = paramBundle;
        }
      }
    }
  }
  
  public boolean b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isClientProcess: ");
    localStringBuilder.append(paramString);
    QLog.d("TRTCIPCManager", 1, localStringBuilder.toString());
    return "com.tencent.mobileqq".equals(paramString);
  }
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doPendingIPCTask enter----size = ");
    ((StringBuilder)localObject).append(this.b.size());
    QLog.i("TRTCIPCManager", 1, ((StringBuilder)localObject).toString());
    int j = this.b.size();
    localObject = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(this.b.poll());
      i += 1;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TRTCIPCManager.PendingIPCTask localPendingIPCTask = (TRTCIPCManager.PendingIPCTask)((Iterator)localObject).next();
      StringBuilder localStringBuilder;
      if (a(localPendingIPCTask))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doPendingIPCTask action = ");
        localStringBuilder.append(localPendingIPCTask.b);
        localStringBuilder.append(" will Run");
        QLog.i("TRTCIPCManager", 1, localStringBuilder.toString());
        TRTCServerIPCModule.a(localPendingIPCTask.b, localPendingIPCTask.c, null);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doPendingIPCTask action = ");
        localStringBuilder.append(localPendingIPCTask.b);
        localStringBuilder.append(" already expire, will discard");
        QLog.i("TRTCIPCManager", 1, localStringBuilder.toString());
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doPendingIPCTask end----size = ");
    ((StringBuilder)localObject).append(this.b.size());
    QLog.i("TRTCIPCManager", 1, ((StringBuilder)localObject).toString());
  }
  
  public void d()
  {
    try
    {
      this.b.clear();
      this.c = null;
      TRTCClientIPCModule.a().b();
      TRTCServerIPCModule.a().b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Class e()
  {
    return TRTCPreloadService.class;
  }
  
  public ITRTCEngine f()
  {
    if (h())
    {
      QLog.d("TRTCIPCManager", 1, "return host engine!");
      return new QQLiveTRTCEngineImpl();
    }
    if (i())
    {
      QLog.d("TRTCIPCManager", 1, "return not host, fake engine!");
      return new TRTCFakeEngineImpl();
    }
    throw new RuntimeException("don't support process");
  }
  
  public String g()
  {
    return "com.tencent.mobileqq:tool";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.ipc.TRTCIPCManager
 * JD-Core Version:    0.7.0.1
 */