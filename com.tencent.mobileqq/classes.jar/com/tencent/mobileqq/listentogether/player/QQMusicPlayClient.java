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
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new QQMusicPlayClient.1(this);
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private QQMusicPlayClient.IncomingHandler jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayClient$IncomingHandler;
  private WeakReference<IConnCallback> jdField_a_of_type_JavaLangRefWeakReference;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private Messenger jdField_b_of_type_AndroidOsMessenger;
  private WeakReference<IPlayCallback> jdField_b_of_type_JavaLangRefWeakReference;
  private WeakReference<IStateChangeCallback> c;
  private WeakReference<IProgressChangeCallback> d;
  
  public QQMusicPlayClient(Context paramContext, AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMusicPlayService.class);
    localIntent.putExtra("key_message", paramMessage);
    try
    {
      this.jdField_a_of_type_AndroidContentContext.startService(localIntent);
      return;
    }
    catch (Throwable paramMessage)
    {
      QLog.e("QQMusicPlay.QQMusicPlayClient", 1, "sendMessage exception===>", paramMessage);
    }
  }
  
  private void a(ISong paramISong)
  {
    Object localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (IPlayCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IPlayCallback)localObject).a(paramISong);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = this.c;
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
    Object localObject = this.d;
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
    Object localObject = this.c;
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
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (IStateChangeCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IStateChangeCallback)localObject).a(paramBoolean1, paramBoolean2);
      }
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_Boolean	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +11 -> 28
    //   20: ldc 97
    //   22: iconst_2
    //   23: ldc 155
    //   25: invokestatic 159	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload_0
    //   29: getfield 161	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayClient$IncomingHandler	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler;
    //   32: ifnull +18 -> 50
    //   35: aload_0
    //   36: getfield 161	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayClient$IncomingHandler	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler;
    //   39: invokevirtual 167	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler:getLooper	()Landroid/os/Looper;
    //   42: invokevirtual 172	android/os/Looper:quit	()V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 161	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayClient$IncomingHandler	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler;
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 57	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   55: aload_0
    //   56: getfield 51	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   59: aload_0
    //   60: getfield 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   63: invokevirtual 176	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   66: aload_0
    //   67: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   70: iconst_m1
    //   71: invokevirtual 179	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 60	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_b_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   79: aload_0
    //   80: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   83: invokevirtual 182	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   86: istore_1
    //   87: aload_0
    //   88: iload_1
    //   89: invokespecial 116	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:a	(I)V
    //   92: goto +47 -> 139
    //   95: astore_3
    //   96: goto +46 -> 142
    //   99: astore_3
    //   100: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +12 -> 115
    //   106: ldc 97
    //   108: iconst_2
    //   109: ldc 184
    //   111: aload_3
    //   112: invokestatic 186	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_0
    //   116: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   119: iconst_m1
    //   120: invokevirtual 179	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 60	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_b_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   128: aload_0
    //   129: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   132: invokevirtual 182	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   135: istore_1
    //   136: goto -49 -> 87
    //   139: aload_0
    //   140: monitorexit
    //   141: return
    //   142: aload_0
    //   143: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   146: iconst_m1
    //   147: invokevirtual 179	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 60	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_b_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   160: invokevirtual 182	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   163: invokespecial 116	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:a	(I)V
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
    //   86	50	1	i	int
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
  
  public int a()
  {
    return QQMusicPlayService.c();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 42	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_Boolean	Z
    //   7: aload_0
    //   8: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 182	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: istore_1
    //   15: iload_1
    //   16: iflt +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +11 -> 36
    //   28: ldc 97
    //   30: iconst_2
    //   31: ldc 190
    //   33: invokestatic 159	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: new 192	android/os/HandlerThread
    //   39: dup
    //   40: ldc 194
    //   42: invokespecial 197	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 200	android/os/HandlerThread:start	()V
    //   50: aload_0
    //   51: new 163	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler
    //   54: dup
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 201	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   60: invokespecial 204	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler:<init>	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient;Landroid/os/Looper;)V
    //   63: putfield 161	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayClient$IncomingHandler	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler;
    //   66: aload_0
    //   67: new 206	android/os/Messenger
    //   70: dup
    //   71: aload_0
    //   72: getfield 161	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayClient$IncomingHandler	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayClient$IncomingHandler;
    //   75: invokespecial 209	android/os/Messenger:<init>	(Landroid/os/Handler;)V
    //   78: putfield 57	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   81: new 78	android/content/Intent
    //   84: dup
    //   85: aload_0
    //   86: getfield 51	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   89: ldc 80
    //   91: invokespecial 83	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   94: astore_2
    //   95: aload_0
    //   96: getfield 51	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   99: aload_2
    //   100: aload_0
    //   101: getfield 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   104: iconst_1
    //   105: invokevirtual 213	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   108: pop
    //   109: aload_0
    //   110: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   113: iconst_0
    //   114: invokevirtual 179	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   117: aload_0
    //   118: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   121: invokevirtual 182	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   124: istore_1
    //   125: aload_0
    //   126: iload_1
    //   127: invokespecial 116	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:a	(I)V
    //   130: goto +32 -> 162
    //   133: astore_2
    //   134: goto +31 -> 165
    //   137: astore_2
    //   138: aload_2
    //   139: invokevirtual 216	java/lang/Exception:printStackTrace	()V
    //   142: ldc 97
    //   144: iconst_1
    //   145: ldc 218
    //   147: aload_2
    //   148: invokestatic 186	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   151: aload_0
    //   152: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   155: invokevirtual 182	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   158: istore_1
    //   159: goto -34 -> 125
    //   162: aload_0
    //   163: monitorexit
    //   164: return
    //   165: aload_0
    //   166: aload_0
    //   167: getfield 40	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   170: invokevirtual 182	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   173: invokespecial 116	com/tencent/mobileqq/listentogether/player/QQMusicPlayClient:a	(I)V
    //   176: aload_2
    //   177: athrow
    //   178: astore_2
    //   179: aload_0
    //   180: monitorexit
    //   181: goto +5 -> 186
    //   184: aload_2
    //   185: athrow
    //   186: goto -2 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	QQMusicPlayClient
    //   14	145	1	i	int
    //   45	55	2	localObject1	Object
    //   133	1	2	localObject2	Object
    //   137	40	2	localException	java.lang.Exception
    //   178	7	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   95	117	133	finally
    //   138	151	133	finally
    //   95	117	137	java/lang/Exception
    //   2	15	178	finally
    //   22	36	178	finally
    //   36	95	178	finally
    //   117	125	178	finally
    //   125	130	178	finally
    //   151	159	178	finally
    //   165	178	178	finally
  }
  
  public void a(IConnCallback paramIConnCallback)
  {
    if (paramIConnCallback != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIConnCallback);
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(IPlayCallback paramIPlayCallback)
  {
    if (paramIPlayCallback != null)
    {
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramIPlayCallback);
      return;
    }
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(IProgressChangeCallback paramIProgressChangeCallback)
  {
    if (paramIProgressChangeCallback != null)
    {
      this.d = new WeakReference(paramIProgressChangeCallback);
      return;
    }
    this.d = null;
  }
  
  public void a(IStateChangeCallback paramIStateChangeCallback)
  {
    if (paramIStateChangeCallback != null)
    {
      this.c = new WeakReference(paramIStateChangeCallback);
      return;
    }
    this.c = null;
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
        if (this.jdField_b_of_type_AndroidOsMessenger != null) {
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
  
  public int b()
  {
    return QQMusicPlayService.b();
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
      this.jdField_a_of_type_Boolean = true;
      a(Message.obtain(null, 10));
      return true;
    }
    finally {}
  }
  
  public boolean d()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      boolean bool = true;
      if (i != 1) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayClient
 * JD-Core Version:    0.7.0.1
 */