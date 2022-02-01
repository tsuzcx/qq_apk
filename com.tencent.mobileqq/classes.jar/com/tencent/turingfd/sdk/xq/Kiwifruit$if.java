package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public class Kiwifruit$if
  extends Thread
{
  public Kiwifruit$if(Kiwifruit paramKiwifruit, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3, Context paramContext, AtomicReference paramAtomicReference4, Object paramObject) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/turingfd/sdk/xq/Kiwifruit$if:g	Lcom/tencent/turingfd/sdk/xq/Kiwifruit;
    //   4: aload_0
    //   5: getfield 21	com/tencent/turingfd/sdk/xq/Kiwifruit$if:a	Ljava/util/concurrent/atomic/AtomicReference;
    //   8: invokevirtual 42	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   11: checkcast 44	android/os/IBinder
    //   14: invokevirtual 49	com/tencent/turingfd/sdk/xq/Kiwifruit:a	(Landroid/os/IBinder;)Ljava/lang/String;
    //   17: astore_1
    //   18: goto +18 -> 36
    //   21: aload_0
    //   22: getfield 23	com/tencent/turingfd/sdk/xq/Kiwifruit$if:b	Ljava/util/concurrent/atomic/AtomicReference;
    //   25: bipush 154
    //   27: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: invokevirtual 59	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   33: ldc 61
    //   35: astore_1
    //   36: aload_0
    //   37: getfield 25	com/tencent/turingfd/sdk/xq/Kiwifruit$if:c	Ljava/util/concurrent/atomic/AtomicReference;
    //   40: aload_1
    //   41: invokevirtual 59	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   44: aload_0
    //   45: getfield 27	com/tencent/turingfd/sdk/xq/Kiwifruit$if:d	Landroid/content/Context;
    //   48: aload_0
    //   49: getfield 29	com/tencent/turingfd/sdk/xq/Kiwifruit$if:e	Ljava/util/concurrent/atomic/AtomicReference;
    //   52: invokevirtual 42	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   55: checkcast 63	android/content/ServiceConnection
    //   58: invokevirtual 69	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   61: goto +15 -> 76
    //   64: aload_0
    //   65: getfield 23	com/tencent/turingfd/sdk/xq/Kiwifruit$if:b	Ljava/util/concurrent/atomic/AtomicReference;
    //   68: bipush 153
    //   70: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 59	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   76: aload_0
    //   77: getfield 31	com/tencent/turingfd/sdk/xq/Kiwifruit$if:f	Ljava/lang/Object;
    //   80: astore_1
    //   81: aload_1
    //   82: monitorenter
    //   83: aload_0
    //   84: getfield 31	com/tencent/turingfd/sdk/xq/Kiwifruit$if:f	Ljava/lang/Object;
    //   87: invokevirtual 74	java/lang/Object:notifyAll	()V
    //   90: aload_1
    //   91: monitorexit
    //   92: return
    //   93: astore_2
    //   94: aload_1
    //   95: monitorexit
    //   96: aload_2
    //   97: athrow
    //   98: astore_1
    //   99: goto -78 -> 21
    //   102: astore_1
    //   103: goto -39 -> 64
    //   106: astore_2
    //   107: goto -17 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	if
    //   17	78	1	localObject1	Object
    //   98	1	1	localObject2	Object
    //   102	1	1	localObject3	Object
    //   106	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   90	92	93	finally
    //   94	96	93	finally
    //   0	18	98	finally
    //   44	61	102	finally
    //   83	90	106	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Kiwifruit.if
 * JD-Core Version:    0.7.0.1
 */