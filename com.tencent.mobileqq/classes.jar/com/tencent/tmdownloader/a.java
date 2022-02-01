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
    ??? = this.mContext;
    if ((??? != null) && (((Context)???).getMainLooper().getThread().getId() == Thread.currentThread().getId())) {
      throw new Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
    }
    if (this.mServiceInterface == null)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("<getServiceInterface> time before init:");
      ((StringBuilder)???).append(System.currentTimeMillis());
      ((StringBuilder)???).append("ms\ntid = ");
      ((StringBuilder)???).append(Thread.currentThread().getId());
      ab.c("BaseIPCClientTIME_COST", ((StringBuilder)???).toString());
      initTMAssistantDownloadSDK();
      this.connectState = "CONNECTING";
    }
    for (;;)
    {
      synchronized (this.mThreadlock)
      {
        Object localObject2 = this.mServiceInterface;
        bool2 = true;
        if (localObject2 == null) {
          break label324;
        }
        bool1 = true;
        if ((this.mServiceInterface != null) || (!"INIT".equals(this.connectState))) {
          break label329;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onServiceConnected=");
        ((StringBuilder)localObject2).append(bool1);
        ((StringBuilder)localObject2).append(",onServiceDisconnected=");
        ((StringBuilder)localObject2).append(bool2);
        ab.c("BaseIPCClientTIME_COST", ((StringBuilder)localObject2).toString());
        if ((!bool1) && (!bool2)) {
          this.mThreadlock.wait(4999L);
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append("<getServiceInterface> time after init:");
        ((StringBuilder)???).append(System.currentTimeMillis());
        ((StringBuilder)???).append("ms\ntid = ");
        ((StringBuilder)???).append(Thread.currentThread().getId());
        ((StringBuilder)???).append("\nmServiceInterface = ");
        ((StringBuilder)???).append(this.mServiceInterface);
        ab.c("BaseIPCClientTIME_COST", ((StringBuilder)???).toString());
      }
      if (this.mServiceInterface != null) {
        return this.mServiceInterface;
      }
      throw new Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
      label324:
      boolean bool1 = false;
      continue;
      label329:
      boolean bool2 = false;
    }
  }
  
  public boolean initTMAssistantDownloadSDK()
  {
    if ("FINISH".equals(this.connectState)) {
      return true;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("initTMAssistantDownloadSDK,clientKey:");
    ((StringBuilder)localObject1).append(this.mClientKey);
    ((StringBuilder)localObject1).append(",mServiceInterface:");
    ((StringBuilder)localObject1).append(this.mServiceInterface);
    ((StringBuilder)localObject1).append(",threadId:");
    ((StringBuilder)localObject1).append(Thread.currentThread().getId());
    ab.c("BaseIPCClient", ((StringBuilder)localObject1).toString());
    try
    {
      if (this.mServiceInterface != null) {
        this.connectState = "FINISH";
      } else {
        this.connectState = "INIT";
      }
      if ("FINISH".equals(this.connectState)) {
        return true;
      }
      boolean bool3 = false;
      boolean bool2 = false;
      if (this.mContext == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("<initTMAssistantDownloadSDK> context is null, Global context is: ");
        ((StringBuilder)localObject1).append(GlobalUtil.getInstance().getContext());
        ab.c("BaseIPCClient", ((StringBuilder)localObject1).toString());
        this.mContext = GlobalUtil.getInstance().getContext();
      }
      boolean bool1 = bool3;
      if (this.mContext != null)
      {
        bool1 = bool3;
        if (this.mServiceName != null)
        {
          bool1 = bool2;
          try
          {
            long l = System.currentTimeMillis();
            bool1 = bool2;
            localObject1 = getBindServiceIntent();
            bool1 = bool2;
            bool2 = this.mContext.bindService((Intent)localObject1, this, 1);
            bool1 = bool2;
            localObject1 = new StringBuilder();
            bool1 = bool2;
            ((StringBuilder)localObject1).append(this.mServiceName);
            bool1 = bool2;
            ((StringBuilder)localObject1).append(",BaseIPCClient initTMAssistantDownloadSDK bindService end,timeCost=");
            bool1 = bool2;
            ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
            bool1 = bool2;
            ((StringBuilder)localObject1).append(",result=");
            bool1 = bool2;
            ((StringBuilder)localObject1).append(bool2);
            bool1 = bool2;
            aa.a(((StringBuilder)localObject1).toString());
            bool1 = bool2;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initTMAssistantDownloadSDK bindResult:");
          localStringBuilder.append(bool1);
          ab.c("BaseIPCClient", localStringBuilder.toString());
        }
      }
      return bool1;
    }
    finally {}
  }
  
  protected abstract void onDownloadSDKServiceInvalid();
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    stubAsInterface(paramIBinder);
    this.connectState = "FINISH";
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.notifyAll();
      ??? = new StringBuilder();
      ???.append(this.mServiceName);
      ???.append("BaseIPCClient onServiceConnected");
      aa.a(???.toString());
      ??? = new StringBuilder();
      ???.append("onServiceConnected,clientKey:");
      ???.append(this.mClientKey);
      ???.append(",mServiceInterface:");
      ???.append(this.mServiceInterface);
      ???.append(",IBinder:");
      ???.append(paramIBinder);
      ???.append("\nthreadId:");
      ???.append(Thread.currentThread().getId());
      ???.append("\ntime:");
      ???.append(System.currentTimeMillis());
      ???.append("ms\nis main thread:");
      boolean bool;
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
        bool = true;
      } else {
        bool = false;
      }
      ???.append(bool);
      ab.c("BaseIPCClientTIME_COST", ???.toString());
      k.a().post(new c(this));
      return;
    }
  }
  
  /* Error */
  public void onServiceDisconnected(ComponentName arg1)
  {
    // Byte code:
    //   0: new 85	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 229
    //   11: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 50	com/tencent/tmdownloader/a:mClientKey	Ljava/lang/String;
    //   20: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_1
    //   25: ldc 231
    //   27: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: invokestatic 76	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   34: invokevirtual 73	java/lang/Thread:getId	()J
    //   37: invokestatic 209	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   40: invokevirtual 67	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   43: invokevirtual 73	java/lang/Thread:getId	()J
    //   46: lcmp
    //   47: ifne +8 -> 55
    //   50: iconst_1
    //   51: istore_2
    //   52: goto +5 -> 57
    //   55: iconst_0
    //   56: istore_2
    //   57: aload_1
    //   58: iload_2
    //   59: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc 20
    //   65: aload_1
    //   66: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 114	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: monitorenter
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 42	com/tencent/tmdownloader/a:mServiceInterface	Landroid/os/IInterface;
    //   79: aload_0
    //   80: ldc 17
    //   82: putfield 40	com/tencent/tmdownloader/a:connectState	Ljava/lang/String;
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_0
    //   88: getfield 46	com/tencent/tmdownloader/a:mThreadlock	Ljava/lang/Object;
    //   91: astore_1
    //   92: aload_1
    //   93: monitorenter
    //   94: aload_0
    //   95: getfield 46	com/tencent/tmdownloader/a:mThreadlock	Ljava/lang/Object;
    //   98: invokevirtual 196	java/lang/Object:notifyAll	()V
    //   101: aload_1
    //   102: monitorexit
    //   103: new 85	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   110: astore_1
    //   111: aload_1
    //   112: aload_0
    //   113: getfield 38	com/tencent/tmdownloader/a:mServiceName	Ljava/lang/String;
    //   116: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_1
    //   121: ldc 233
    //   123: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_1
    //   128: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 181	com/tencent/tmassistantbase/util/aa:a	(Ljava/lang/String;)V
    //   134: invokestatic 214	com/tencent/tmassistantbase/util/k:a	()Landroid/os/Handler;
    //   137: new 235	com/tencent/tmdownloader/b
    //   140: dup
    //   141: aload_0
    //   142: invokespecial 236	com/tencent/tmdownloader/b:<init>	(Lcom/tencent/tmdownloader/a;)V
    //   145: invokevirtual 225	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   148: pop
    //   149: return
    //   150: astore_3
    //   151: aload_1
    //   152: monitorexit
    //   153: aload_3
    //   154: athrow
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	a
    //   51	8	2	bool	boolean
    //   150	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   94	103	150	finally
    //   151	153	150	finally
    //   74	87	155	finally
    //   156	158	155	finally
  }
  
  protected abstract void registerServiceCallback();
  
  protected abstract void stubAsInterface(IBinder paramIBinder);
  
  public void unInitTMAssistantDownloadSDK()
  {
    k.a().post(new d(this));
  }
  
  protected abstract void unRegisterServiceCallback();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.a
 * JD-Core Version:    0.7.0.1
 */