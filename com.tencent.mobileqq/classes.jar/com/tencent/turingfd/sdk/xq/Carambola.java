package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public class Carambola
  extends Thread
{
  public Carambola(Casaba paramCasaba, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3, Context paramContext, AtomicReference paramAtomicReference4, Object paramObject) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/turingfd/sdk/xq/Carambola:this$0	Lcom/tencent/turingfd/sdk/xq/Casaba;
    //   4: aload_0
    //   5: getfield 21	com/tencent/turingfd/sdk/xq/Carambola:vh	Ljava/util/concurrent/atomic/AtomicReference;
    //   8: invokevirtual 44	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   11: checkcast 46	android/os/IBinder
    //   14: invokevirtual 52	com/tencent/turingfd/sdk/xq/Casaba:a	(Landroid/os/IBinder;)Ljava/lang/String;
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 25	com/tencent/turingfd/sdk/xq/Carambola:Aj	Ljava/util/concurrent/atomic/AtomicReference;
    //   22: aload_1
    //   23: invokevirtual 56	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield 27	com/tencent/turingfd/sdk/xq/Carambola:Hg	Landroid/content/Context;
    //   30: aload_0
    //   31: getfield 29	com/tencent/turingfd/sdk/xq/Carambola:wh	Ljava/util/concurrent/atomic/AtomicReference;
    //   34: invokevirtual 44	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   37: checkcast 58	android/content/ServiceConnection
    //   40: invokevirtual 64	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   43: aload_0
    //   44: getfield 31	com/tencent/turingfd/sdk/xq/Carambola:Bj	Ljava/lang/Object;
    //   47: astore_1
    //   48: aload_1
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 31	com/tencent/turingfd/sdk/xq/Carambola:Bj	Ljava/lang/Object;
    //   54: invokevirtual 69	java/lang/Object:notifyAll	()V
    //   57: aload_1
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 23	com/tencent/turingfd/sdk/xq/Carambola:zj	Ljava/util/concurrent/atomic/AtomicReference;
    //   65: bipush 154
    //   67: invokestatic 75	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokevirtual 56	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   73: ldc 77
    //   75: astore_1
    //   76: goto -58 -> 18
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 23	com/tencent/turingfd/sdk/xq/Carambola:zj	Ljava/util/concurrent/atomic/AtomicReference;
    //   84: bipush 153
    //   86: invokestatic 75	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokevirtual 56	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   92: goto -49 -> 43
    //   95: astore_2
    //   96: aload_1
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: goto -44 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	Carambola
    //   60	1	1	localThrowable1	java.lang.Throwable
    //   75	1	1	str	java.lang.String
    //   79	18	1	localThrowable2	java.lang.Throwable
    //   95	4	2	localObject2	Object
    //   100	1	2	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	18	60	java/lang/Throwable
    //   26	43	79	java/lang/Throwable
    //   50	57	95	finally
    //   57	59	95	finally
    //   96	98	95	finally
    //   50	57	100	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Carambola
 * JD-Core Version:    0.7.0.1
 */