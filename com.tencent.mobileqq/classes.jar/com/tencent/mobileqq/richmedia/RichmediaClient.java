package com.tencent.mobileqq.richmedia;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicBoolean;

public class RichmediaClient
  implements RichmediaIPCConstants
{
  static volatile RichmediaClient e;
  Messenger a;
  Messenger b;
  HandlerThread c;
  RichmediaClient.IncomingHandler d;
  VideoCompoundController f;
  ServiceConnection g;
  ICallBack h;
  AtomicBoolean i = new AtomicBoolean(false);
  
  private RichmediaClient()
  {
    LOG.a("PTV.RichmediaClient", "RichmediaClient");
    this.c = new HandlerThread("RichmediaClientWorkerThread");
    this.c.start();
    this.d = new RichmediaClient.IncomingHandler(this.c.getLooper(), this);
    this.a = new Messenger(this.d);
    this.g = new RichmediaClient.1(this);
    this.h = new RichmediaClient.2(this);
  }
  
  public static RichmediaClient a()
  {
    LOG.a("PTV.RichmediaClient", "getInstance");
    if (e == null) {
      try
      {
        if (e == null) {
          e = new RichmediaClient();
        }
      }
      finally {}
    }
    return e;
  }
  
  public void a(Context paramContext)
  {
    LOG.a("PTV.RichmediaClient", "bindService");
    if (this.i.compareAndSet(false, true))
    {
      try
      {
        paramContext.bindService(new Intent(paramContext, RichmediaService.class), this.g, 1);
      }
      catch (SecurityException paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bindService failed. e = ");
        localStringBuilder.append(paramContext);
        LOG.b("PTV.RichmediaClient", localStringBuilder.toString());
      }
      LOG.a("PTV.RichmediaClient", "bindService,bingding");
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendToService,msgCode = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",subCmd = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",data = ");
    ((StringBuilder)localObject).append(paramBundle);
    LOG.a("PTV.RichmediaClient", ((StringBuilder)localObject).toString());
    if (this.b == null)
    {
      LOG.b("PTV.RichmediaClient", "sendToService failed. mService is null ");
      return false;
    }
    localObject = Message.obtain(null, paramInt1);
    if (paramBundle != null) {
      paramBundle.putInt("msg_sub_cmd", paramInt2);
    }
    ((Message)localObject).setData(paramBundle);
    try
    {
      this.b.send((Message)localObject);
      return true;
    }
    catch (RemoteException paramBundle)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendToService failed. e = ");
      ((StringBuilder)localObject).append(paramBundle);
      LOG.b("PTV.RichmediaClient", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public VideoCompoundController b()
  {
    if (this.f == null) {
      this.f = new VideoCompoundController();
    }
    return this.f;
  }
  
  /* Error */
  public void b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 36
    //   2: ldc 183
    //   4: invokestatic 43	com/tencent/mobileqq/richmedia/LOG:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: aload_0
    //   9: getfield 34	com/tencent/mobileqq/richmedia/RichmediaClient:i	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   12: iconst_1
    //   13: iconst_0
    //   14: invokevirtual 101	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   17: ifeq +49 -> 66
    //   20: aload_0
    //   21: iconst_2
    //   22: iconst_m1
    //   23: aconst_null
    //   24: invokevirtual 185	com/tencent/mobileqq/richmedia/RichmediaClient:a	(IILandroid/os/Bundle;)Z
    //   27: pop
    //   28: aload_1
    //   29: aload_0
    //   30: getfield 80	com/tencent/mobileqq/richmedia/RichmediaClient:g	Landroid/content/ServiceConnection;
    //   33: invokevirtual 188	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 147	com/tencent/mobileqq/richmedia/RichmediaClient:b	Landroid/os/Messenger;
    //   41: return
    //   42: astore_1
    //   43: goto +16 -> 59
    //   46: astore_1
    //   47: ldc 36
    //   49: iconst_1
    //   50: ldc 190
    //   52: aload_1
    //   53: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   56: goto -20 -> 36
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 147	com/tencent/mobileqq/richmedia/RichmediaClient:b	Landroid/os/Messenger;
    //   64: aload_1
    //   65: athrow
    //   66: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	RichmediaClient
    //   0	67	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   20	36	42	finally
    //   47	56	42	finally
    //   20	36	46	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaClient
 * JD-Core Version:    0.7.0.1
 */