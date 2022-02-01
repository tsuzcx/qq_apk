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
import com.tencent.tmassistantbase.util.aa;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;

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
  protected volatile T mServiceInterface = null;
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
    boolean bool2 = true;
    if ((this.mContext != null) && (this.mContext.getMainLooper().getThread().getId() == Thread.currentThread().getId())) {
      throw new Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
    }
    if (this.mServiceInterface == null)
    {
      ab.c("BaseIPCClientTIME_COST", "<getServiceInterface> time before init:" + System.currentTimeMillis() + "ms\ntid = " + Thread.currentThread().getId());
      initTMAssistantDownloadSDK();
      this.connectState = "CONNECTING";
    }
    synchronized (this.mThreadlock)
    {
      if (this.mServiceInterface != null) {}
      for (boolean bool1 = true; (this.mServiceInterface == null) && ("INIT".equals(this.connectState)); bool1 = false)
      {
        ab.c("BaseIPCClientTIME_COST", "onServiceConnected=" + bool1 + ",onServiceDisconnected=" + bool2);
        if ((!bool1) && (!bool2)) {
          this.mThreadlock.wait(4999L);
        }
        ab.c("BaseIPCClientTIME_COST", "<getServiceInterface> time after init:" + System.currentTimeMillis() + "ms\ntid = " + Thread.currentThread().getId() + "\nmServiceInterface = " + this.mServiceInterface);
        if (this.mServiceInterface != null) {
          break label274;
        }
        throw new Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
      }
      bool2 = false;
    }
    label274:
    return this.mServiceInterface;
  }
  
  public boolean initTMAssistantDownloadSDK()
  {
    boolean bool1 = true;
    if ("FINISH".equals(this.connectState)) {
      return bool1;
    }
    ab.c("BaseIPCClient", "initTMAssistantDownloadSDK,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",threadId:" + Thread.currentThread().getId());
    for (;;)
    {
      boolean bool2;
      long l;
      Intent localIntent;
      try
      {
        if (this.mServiceInterface != null)
        {
          this.connectState = "FINISH";
          if ("FINISH".equals(this.connectState)) {
            break;
          }
          bool2 = false;
          boolean bool3 = false;
          if (this.mContext == null)
          {
            ab.c("BaseIPCClient", "<initTMAssistantDownloadSDK> context is null, Global context is: " + GlobalUtil.getInstance().getContext());
            this.mContext = GlobalUtil.getInstance().getContext();
          }
          bool1 = bool3;
          if (this.mContext == null) {
            break;
          }
          bool1 = bool3;
          if (this.mServiceName == null) {
            break;
          }
          bool1 = bool2;
        }
      }
      finally {}
      try
      {
        l = System.currentTimeMillis();
        bool1 = bool2;
        localIntent = getBindServiceIntent();
        bool1 = bool2;
        bool2 = this.mContext.bindService(localIntent, this, 1);
        bool1 = bool2;
        aa.a(this.mServiceName + ",BaseIPCClient initTMAssistantDownloadSDK bindService end,timeCost=" + (System.currentTimeMillis() - l) + ",result=" + bool2);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      ab.c("BaseIPCClient", "initTMAssistantDownloadSDK bindResult:" + bool1);
      return bool1;
      this.connectState = "INIT";
    }
  }
  
  protected abstract void onDownloadSDKServiceInvalid();
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    stubAsInterface(paramIBinder);
    this.connectState = "FINISH";
    for (;;)
    {
      synchronized (this.mThreadlock)
      {
        this.mThreadlock.notifyAll();
        aa.a(this.mServiceName + "BaseIPCClient onServiceConnected");
        ??? = new StringBuilder().append("onServiceConnected,clientKey:").append(this.mClientKey).append(",mServiceInterface:").append(this.mServiceInterface).append(",IBinder:").append(paramIBinder).append("\nthreadId:").append(Thread.currentThread().getId()).append("\ntime:").append(System.currentTimeMillis()).append("ms\nis main thread:");
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
        {
          bool = true;
          ab.c("BaseIPCClientTIME_COST", bool);
          k.a().post(new c(this));
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  /* Error */
  public void onServiceDisconnected(ComponentName arg1)
  {
    // Byte code:
    //   0: new 87	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   7: ldc 229
    //   9: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_0
    //   13: getfield 50	com/tencent/tmdownloader/a:mClientKey	Ljava/lang/String;
    //   16: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 231
    //   21: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: astore_1
    //   25: invokestatic 76	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   28: invokevirtual 73	java/lang/Thread:getId	()J
    //   31: invokestatic 209	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   34: invokevirtual 67	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   37: invokevirtual 73	java/lang/Thread:getId	()J
    //   40: lcmp
    //   41: ifne +90 -> 131
    //   44: iconst_1
    //   45: istore_2
    //   46: ldc 20
    //   48: aload_1
    //   49: iload_2
    //   50: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 114	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: monitorenter
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 42	com/tencent/tmdownloader/a:mServiceInterface	Landroid/os/IInterface;
    //   66: aload_0
    //   67: ldc 17
    //   69: putfield 40	com/tencent/tmdownloader/a:connectState	Ljava/lang/String;
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_0
    //   75: getfield 46	com/tencent/tmdownloader/a:mThreadlock	Ljava/lang/Object;
    //   78: astore_1
    //   79: aload_1
    //   80: monitorenter
    //   81: aload_0
    //   82: getfield 46	com/tencent/tmdownloader/a:mThreadlock	Ljava/lang/Object;
    //   85: invokevirtual 196	java/lang/Object:notifyAll	()V
    //   88: aload_1
    //   89: monitorexit
    //   90: new 87	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   97: aload_0
    //   98: getfield 38	com/tencent/tmdownloader/a:mServiceName	Ljava/lang/String;
    //   101: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 233
    //   106: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 181	com/tencent/tmassistantbase/util/aa:a	(Ljava/lang/String;)V
    //   115: invokestatic 214	com/tencent/tmassistantbase/util/k:a	()Landroid/os/Handler;
    //   118: new 235	com/tencent/tmdownloader/b
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 236	com/tencent/tmdownloader/b:<init>	(Lcom/tencent/tmdownloader/a;)V
    //   126: invokevirtual 225	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   129: pop
    //   130: return
    //   131: iconst_0
    //   132: istore_2
    //   133: goto -87 -> 46
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    //   141: astore_3
    //   142: aload_1
    //   143: monitorexit
    //   144: aload_3
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	a
    //   45	88	2	bool	boolean
    //   141	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   61	74	136	finally
    //   137	139	136	finally
    //   81	90	141	finally
    //   142	144	141	finally
  }
  
  protected abstract void registerServiceCallback();
  
  protected abstract void stubAsInterface(IBinder paramIBinder);
  
  public void unInitTMAssistantDownloadSDK()
  {
    k.a().post(new d(this));
  }
  
  protected abstract void unRegisterServiceCallback();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.a
 * JD-Core Version:    0.7.0.1
 */