package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import eipc.EIPCServer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class TRTCServerIPCModule
  extends QIPCModule
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  private final CopyOnWriteArrayList<ITRTCIPCListener> b = new CopyOnWriteArrayList();
  private final CopyOnWriteArrayList<ITRTCIPCHandler> c = new CopyOnWriteArrayList();
  private volatile long d = -1L;
  private volatile int e = 0;
  private TRTCInitCallback f = null;
  private WeakReference<Context> g = null;
  
  private TRTCServerIPCModule()
  {
    this("QQLiveServerIPCModule");
  }
  
  private TRTCServerIPCModule(String paramString)
  {
    super(paramString);
    a(TRTCIPCManager.b());
  }
  
  public static TRTCServerIPCModule a()
  {
    return TRTCServerIPCModule.InstanceHolder.a;
  }
  
  private void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("Key_trtc_engine_init_state");
    int j = paramBundle.getInt("Key_trtc_engine_init_code");
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("notifyEngineState ");
      paramBundle.append(i);
      paramBundle.append(", code ");
      paramBundle.append(j);
      QLog.d("TRTCServerIPCModule", 2, paramBundle.toString());
    }
    paramBundle = this.f;
    if (paramBundle != null)
    {
      paramBundle.a(i, j);
      this.f = null;
    }
    paramBundle = this.b.iterator();
    while (paramBundle.hasNext()) {
      ((ITRTCIPCListener)paramBundle.next()).a(TRTCIPCManager.b().g());
    }
  }
  
  public static void a(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    } else {
      localBundle = paramBundle;
    }
    if (a().c())
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("callClientAsync ========");
        paramBundle.append(paramString);
        QLog.d("TRTCServerIPCModule", 2, paramBundle.toString());
      }
      QIPCServerHelper.getInstance().getServer().callClient(TRTCIPCManager.b().g(), 1, "QQLiveClientIPCModule", paramString, localBundle, paramEIPCResultCallback);
      return;
    }
    TRTCIPCManager.b().a(paramString, paramBundle);
  }
  
  private boolean c()
  {
    if (this.e == 1)
    {
      QLog.d("TRTCServerIPCModule", 1, "tryConnect , already bind!");
      return true;
    }
    Object localObject1 = this.g;
    if (localObject1 != null) {
      localObject1 = (Context)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryConnect startForegroundService ");
    localStringBuilder.append(this.d);
    QLog.d("TRTCServerIPCModule", 1, localStringBuilder.toString());
    try
    {
      if (d())
      {
        ((Context)localObject1).startService(new Intent(((Context)localObject1).getApplicationContext(), TRTCIPCManager.b().e()));
        this.d = System.currentTimeMillis();
      }
      return false;
    }
    finally {}
  }
  
  private boolean d()
  {
    long l = System.currentTimeMillis();
    return (this.d == -1L) || (l - this.d > 2000L);
  }
  
  private void e()
  {
    try
    {
      QLog.e("TRTCServerIPCModule", 1, "---already---onBind---- ");
      this.e = 1;
      TRTCIPCManager.b().b("Action_Client_Init_SDK", null);
      TRTCIPCManager.b().c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f()
  {
    if (this.a.compareAndSet(false, true)) {
      QIPCServerHelper.getInstance().getServer().addListener(new TRTCServerIPCModule.TRTCServerConnectionListener(this));
    }
  }
  
  private void g()
  {
    this.f = null;
    this.d = -1L;
    this.e = 2;
  }
  
  public void a(@NonNull Context paramContext, @NonNull ConfigData paramConfigData, TRTCInitCallback paramTRTCInitCallback)
  {
    this.f = paramTRTCInitCallback;
    this.g = new WeakReference(paramContext.getApplicationContext());
    f();
    c();
    paramContext = new StringBuilder();
    paramContext.append("initEngine, bindstate : ");
    paramContext.append(this.e);
    QLog.d("TRTCServerIPCModule", 1, paramContext.toString());
    paramContext = new Bundle();
    paramContext.putParcelable("key_trtc_config_data", paramConfigData);
    if (c())
    {
      a("Action_Client_Init_SDK", paramContext, null);
      return;
    }
    QLog.e("TRTCServerIPCModule", 1, "now wait  init engine!");
    TRTCIPCManager.b().a("Action_Client_Init_SDK", paramContext);
  }
  
  public void a(ITRTCIPCHandler paramITRTCIPCHandler)
  {
    try
    {
      if (!this.c.contains(paramITRTCIPCHandler)) {
        this.c.add(paramITRTCIPCHandler);
      }
      return;
    }
    finally
    {
      paramITRTCIPCHandler = finally;
      throw paramITRTCIPCHandler;
    }
  }
  
  public void a(@NonNull ITRTCIPCListener paramITRTCIPCListener)
  {
    try
    {
      if (!this.b.contains(paramITRTCIPCListener)) {
        this.b.add(paramITRTCIPCListener);
      }
      return;
    }
    finally
    {
      paramITRTCIPCListener = finally;
      throw paramITRTCIPCListener;
    }
  }
  
  public void b()
  {
    g();
    this.b.clear();
    this.c.clear();
  }
  
  public void b(ITRTCIPCHandler paramITRTCIPCHandler)
  {
    try
    {
      this.c.remove(paramITRTCIPCHandler);
      return;
    }
    finally
    {
      paramITRTCIPCHandler = finally;
      throw paramITRTCIPCHandler;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TRTCServerIPCModule", 1, "onCall action is empty!");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("======onCall=====action = ");
    localStringBuilder.append(paramString);
    QLog.i("TRTCServerIPCModule", 1, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new TRTCServerIPCModule.1(this, paramString, paramBundle));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule
 * JD-Core Version:    0.7.0.1
 */