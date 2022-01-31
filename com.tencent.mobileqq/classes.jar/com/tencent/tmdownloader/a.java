package com.tencent.tmdownloader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.f;
import com.tencent.tmassistantbase.util.r;

public abstract class a<T extends IInterface>
  implements ServiceConnection
{
  public static final String CONNTECTSTATE_CONNECTING = "CONNECTING";
  public static final String CONNTECTSTATE_FINISH = "FINISH";
  public static final String CONNTECTSTATE_INIT = "INIT";
  protected static final String TAG = "BaseIPCClient";
  protected String connectState = "INIT";
  public String mClientKey;
  protected Context mContext;
  protected IInterface mServiceCallback = null;
  protected T mServiceInterface = null;
  protected String mServiceName = null;
  protected final Object mThreadlock = new Object();
  
  public a(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mClientKey = paramString1;
    this.mServiceName = paramString2;
  }
  
  protected abstract Intent getBindServiceIntent();
  
  protected T getServiceInterface()
  {
    if ((this.mContext != null) && (this.mContext.getMainLooper().getThread().getId() == Thread.currentThread().getId())) {
      throw new Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
    }
    if (this.mServiceInterface == null)
    {
      initTMAssistantDownloadSDK();
      this.connectState = "CONNECTING";
    }
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.wait(4999L);
      if (this.mServiceInterface == null) {
        throw new Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
      }
    }
    return this.mServiceInterface;
  }
  
  public boolean initTMAssistantDownloadSDK()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        String str = this.connectState;
        if (str == "FINISH") {
          return bool1;
        }
        r.c("BaseIPCClient", "initTMAssistantDownloadSDK,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",threadId:" + Thread.currentThread().getId());
        this.connectState = "INIT";
        if (this.mServiceInterface != null)
        {
          this.connectState = "FINISH";
          continue;
        }
        bool2 = false;
      }
      finally {}
      boolean bool2;
      boolean bool3 = false;
      if (this.mContext == null)
      {
        r.c("BaseIPCClient", "<initTMAssistantDownloadSDK> context is null, Global context is: " + GlobalUtil.getInstance().getContext());
        this.mContext = GlobalUtil.getInstance().getContext();
      }
      bool1 = bool3;
      if (this.mContext == null) {
        continue;
      }
      Object localObject2 = this.mServiceName;
      bool1 = bool3;
      if (localObject2 == null) {
        continue;
      }
      try
      {
        localObject2 = getBindServiceIntent();
        bool1 = this.mContext.bindService((Intent)localObject2, this, 1);
        r.c("BaseIPCClient", "initTMAssistantDownloadSDK bindResult:" + bool1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          bool1 = bool2;
        }
      }
    }
  }
  
  protected abstract void onDownloadSDKServiceInvalid();
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    f.a().post(new c(this, paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    f.a().post(new b(this));
  }
  
  protected abstract void registerServiceCallback();
  
  protected abstract void stubAsInterface(IBinder paramIBinder);
  
  public void unInitTMAssistantDownloadSDK()
  {
    try
    {
      f.a().post(new d(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected abstract void unRegisterServiceCallback();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.a
 * JD-Core Version:    0.7.0.1
 */