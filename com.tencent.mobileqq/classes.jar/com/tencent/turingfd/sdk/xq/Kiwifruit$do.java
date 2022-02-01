package com.tencent.turingfd.sdk.xq;

import android.content.ComponentName;
import android.content.ServiceConnection;
import java.util.concurrent.atomic.AtomicReference;

public class Kiwifruit$do
  implements ServiceConnection
{
  public Kiwifruit$do(Kiwifruit paramKiwifruit, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, Object paramObject) {}
  
  /* Error */
  public void onServiceConnected(ComponentName paramComponentName, android.os.IBinder arg2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/turingfd/sdk/xq/Kiwifruit$do:a	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: aload_2
    //   5: invokevirtual 31	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   8: aload_0
    //   9: getfield 17	com/tencent/turingfd/sdk/xq/Kiwifruit$do:b	Ljava/util/concurrent/atomic/AtomicReference;
    //   12: aload_0
    //   13: invokevirtual 31	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   16: aload_0
    //   17: getfield 19	com/tencent/turingfd/sdk/xq/Kiwifruit$do:c	Ljava/lang/Object;
    //   20: astore_1
    //   21: aload_1
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 19	com/tencent/turingfd/sdk/xq/Kiwifruit$do:c	Ljava/lang/Object;
    //   27: invokevirtual 34	java/lang/Object:notifyAll	()V
    //   30: aload_1
    //   31: monitorexit
    //   32: return
    //   33: astore_2
    //   34: aload_1
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: astore_2
    //   39: goto -9 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	do
    //   0	42	1	paramComponentName	ComponentName
    // Exception table:
    //   from	to	target	type
    //   30	32	33	finally
    //   34	36	33	finally
    //   23	30	38	finally
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Kiwifruit.do
 * JD-Core Version:    0.7.0.1
 */