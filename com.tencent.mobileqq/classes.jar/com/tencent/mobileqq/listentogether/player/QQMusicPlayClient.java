package com.tencent.mobileqq.listentogether.player;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class QQMusicPlayClient
  implements IConst, IConst.ConnState, IConst.PlayState, IQQMusicPlayClient
{
  private Messenger a;
  private WeakReference<IConnCallback> b;
  private WeakReference<IPlayCallback> c;
  private WeakReference<IStateChangeCallback> d;
  private WeakReference<IProgressChangeCallback> e;
  private Messenger f;
  private Context g;
  private AppRuntime h;
  private QQMusicPlayClient.IncomingHandler i;
  private final AtomicInteger j = new AtomicInteger(-1);
  private volatile boolean k = false;
  private ServiceConnection l = new QQMusicPlayClient.1(this);
  
  public QQMusicPlayClient(Context paramContext, AppRuntime paramAppRuntime)
  {
    this.g = paramContext;
    this.h = paramAppRuntime;
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (IConnCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IConnCallback)localObject).a(paramInt);
      }
    }
  }
  
  private void a(Message paramMessage)
  {
    Intent localIntent = new Intent(this.g, QQMusicPlayService.class);
    localIntent.putExtra("key_message", paramMessage);
    try
    {
      this.g.startService(localIntent);
      return;
    }
    catch (Throwable paramMessage)
    {
      QLog.e("QQMusicPlay.QQMusicPlayClient", 1, "sendMessage exception===>", paramMessage);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (IStateChangeCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IStateChangeCallback)localObject).a(paramString, paramInt);
      }
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = (IProgressChangeCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IProgressChangeCallback)localObject).a(paramString, paramInt1, paramInt2);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (IStateChangeCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IStateChangeCallback)localObject).a(paramBoolean);
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (IStateChangeCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IStateChangeCallback)localObject).a(paramBoolean1, paramBoolean2);
      }
    }
  }
  
  private void b(ISong paramISong)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (IPlayCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IPlayCallback)localObject).a(paramISong);
      }
    }
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:k	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +11 -> 28
    //   20: ldc 101
    //   22: iconst_2
    //   23: ldc 163
    //   25: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload_0
    //   29: getfield 168	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:i	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler;
    //   32: ifnull +18 -> 50
    //   35: aload_0
    //   36: getfield 168	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:i	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler;
    //   39: invokevirtual 174	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler:getLooper	()Landroid/os/Looper;
    //   42: invokevirtual 179	android/os/Looper:quit	()V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 168	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:i	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler;
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 154	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:a	Landroid/os/Messenger;
    //   55: aload_0
    //   56: getfield 59	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:g	Landroid/content/Context;
    //   59: aload_0
    //   60: getfield 57	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:l	Landroid/content/ServiceConnection;
    //   63: invokevirtual 183	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   66: aload_0
    //   67: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   70: iconst_m1
    //   71: invokevirtual 186	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 65	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:f	Landroid/os/Messenger;
    //   79: aload_0
    //   80: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   83: invokevirtual 189	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   86: istore_1
    //   87: aload_0
    //   88: iload_1
    //   89: invokespecial 110	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:a	(I)V
    //   92: goto +47 -> 139
    //   95: astore_3
    //   96: goto +46 -> 142
    //   99: astore_3
    //   100: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +12 -> 115
    //   106: ldc 101
    //   108: iconst_2
    //   109: ldc 191
    //   111: aload_3
    //   112: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_0
    //   116: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   119: iconst_m1
    //   120: invokevirtual 186	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 65	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:f	Landroid/os/Messenger;
    //   128: aload_0
    //   129: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   132: invokevirtual 189	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   135: istore_1
    //   136: goto -49 -> 87
    //   139: aload_0
    //   140: monitorexit
    //   141: return
    //   142: aload_0
    //   143: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   146: iconst_m1
    //   147: invokevirtual 186	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 65	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:f	Landroid/os/Messenger;
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   160: invokevirtual 189	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   163: invokespecial 110	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:a	(I)V
    //   166: aload_3
    //   167: athrow
    //   168: astore_3
    //   169: aload_0
    //   170: monitorexit
    //   171: goto +5 -> 176
    //   174: aload_3
    //   175: athrow
    //   176: goto -2 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	QQMusicPlayClient
    //   86	50	1	m	int
    //   6	2	2	bool	boolean
    //   95	1	3	localObject1	Object
    //   99	68	3	localException	java.lang.Exception
    //   168	7	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	66	95	finally
    //   100	115	95	finally
    //   55	66	99	java/lang/Exception
    //   2	7	168	finally
    //   14	28	168	finally
    //   28	50	168	finally
    //   50	55	168	finally
    //   66	87	168	finally
    //   87	92	168	finally
    //   115	136	168	finally
    //   142	168	168	finally
  }
  
  public void a(IConnCallback paramIConnCallback)
  {
    if (paramIConnCallback != null)
    {
      this.b = new WeakReference(paramIConnCallback);
      return;
    }
    this.b = null;
  }
  
  public void a(IPlayCallback paramIPlayCallback)
  {
    if (paramIPlayCallback != null)
    {
      this.c = new WeakReference(paramIPlayCallback);
      return;
    }
    this.c = null;
  }
  
  public void a(IProgressChangeCallback paramIProgressChangeCallback)
  {
    if (paramIProgressChangeCallback != null)
    {
      this.e = new WeakReference(paramIProgressChangeCallback);
      return;
    }
    this.e = null;
  }
  
  public void a(IStateChangeCallback paramIStateChangeCallback)
  {
    if (paramIStateChangeCallback != null)
    {
      this.d = new WeakReference(paramIStateChangeCallback);
      return;
    }
    this.d = null;
  }
  
  public boolean a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->pausePlay");
      }
      a(Message.obtain(null, 7));
      return true;
    }
    finally {}
  }
  
  public boolean a(ISong paramISong)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        boolean bool = false;
        if (this.f != null) {
          bool = true;
        }
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->startPlay song=[%s] connected=%b", new Object[] { paramISong, Boolean.valueOf(bool) }));
      }
      Message localMessage = Message.obtain(null, 6);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("key_song", paramISong);
      localMessage.setData(localBundle);
      a(localMessage);
      return true;
    }
    finally {}
  }
  
  public boolean b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->resumePlay");
      }
      a(Message.obtain(null, 8));
      return true;
    }
    finally {}
  }
  
  public boolean c()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->stopPlay");
      }
      this.k = true;
      a(Message.obtain(null, 10));
      return true;
    }
    finally {}
  }
  
  public boolean d()
  {
    try
    {
      int m = this.j.get();
      boolean bool = true;
      if (m != 1) {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 50	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:k	Z
    //   7: aload_0
    //   8: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 189	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: istore_1
    //   15: iload_1
    //   16: iflt +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +11 -> 36
    //   28: ldc 101
    //   30: iconst_2
    //   31: ldc 244
    //   33: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: new 246	android/os/HandlerThread
    //   39: dup
    //   40: ldc 248
    //   42: invokespecial 251	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 254	android/os/HandlerThread:start	()V
    //   50: aload_0
    //   51: new 170	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler
    //   54: dup
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 255	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   60: invokespecial 258	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler:<init>	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient;Landroid/os/Looper;)V
    //   63: putfield 168	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:i	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler;
    //   66: aload_0
    //   67: new 260	android/os/Messenger
    //   70: dup
    //   71: aload_0
    //   72: getfield 168	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:i	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler;
    //   75: invokespecial 263	android/os/Messenger:<init>	(Landroid/os/Handler;)V
    //   78: putfield 154	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:a	Landroid/os/Messenger;
    //   81: new 82	android/content/Intent
    //   84: dup
    //   85: aload_0
    //   86: getfield 59	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:g	Landroid/content/Context;
    //   89: ldc 84
    //   91: invokespecial 87	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   94: astore_2
    //   95: aload_0
    //   96: getfield 59	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:g	Landroid/content/Context;
    //   99: aload_2
    //   100: aload_0
    //   101: getfield 57	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:l	Landroid/content/ServiceConnection;
    //   104: iconst_1
    //   105: invokevirtual 267	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   108: pop
    //   109: aload_0
    //   110: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   113: iconst_0
    //   114: invokevirtual 186	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   117: aload_0
    //   118: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   121: invokevirtual 189	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   124: istore_1
    //   125: aload_0
    //   126: iload_1
    //   127: invokespecial 110	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:a	(I)V
    //   130: goto +33 -> 163
    //   133: astore_2
    //   134: goto +32 -> 166
    //   137: astore_2
    //   138: aload_2
    //   139: invokevirtual 270	java/lang/Exception:printStackTrace	()V
    //   142: ldc 101
    //   144: iconst_1
    //   145: ldc_w 272
    //   148: aload_2
    //   149: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: aload_0
    //   153: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   156: invokevirtual 189	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   159: istore_1
    //   160: goto -35 -> 125
    //   163: aload_0
    //   164: monitorexit
    //   165: return
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 48	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   171: invokevirtual 189	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   174: invokespecial 110	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:a	(I)V
    //   177: aload_2
    //   178: athrow
    //   179: astore_2
    //   180: aload_0
    //   181: monitorexit
    //   182: goto +5 -> 187
    //   185: aload_2
    //   186: athrow
    //   187: goto -2 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	QQMusicPlayClient
    //   14	146	1	m	int
    //   45	55	2	localObject1	Object
    //   133	1	2	localObject2	Object
    //   137	41	2	localException	java.lang.Exception
    //   179	7	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   95	117	133	finally
    //   138	152	133	finally
    //   95	117	137	java/lang/Exception
    //   2	15	179	finally
    //   22	36	179	finally
    //   36	95	179	finally
    //   117	125	179	finally
    //   125	130	179	finally
    //   152	160	179	finally
    //   166	179	179	finally
  }
  
  public int f()
  {
    return QQMusicPlayService.g();
  }
  
  public int g()
  {
    return QQMusicPlayService.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayClient
 * JD-Core Version:    0.7.0.1
 */