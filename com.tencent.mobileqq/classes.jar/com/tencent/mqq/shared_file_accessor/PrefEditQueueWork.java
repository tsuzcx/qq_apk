package com.tencent.mqq.shared_file_accessor;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;

final class PrefEditQueueWork
{
  private static final int MSG_RUN = 0;
  private final Object mLock = new Object();
  private final Object mProcessingLock = new Object();
  private final Handler mWorkHandler;
  private final HandlerThread mWorkThread = new HandlerThread("pref-queue-work-thread", -2);
  private final LinkedList<Runnable> mWorks = new LinkedList();
  
  private PrefEditQueueWork()
  {
    this.mWorkThread.start();
    this.mWorkHandler = new PrefEditQueueWork.WorkHandler(this, this.mWorkThread.getLooper());
  }
  
  public static PrefEditQueueWork getInstance()
  {
    return PrefEditQueueWork.Holder.INSTANCE;
  }
  
  /* Error */
  private void processPendingWork()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/mqq/shared_file_accessor/PrefEditQueueWork:mProcessingLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 28	com/tencent/mqq/shared_file_accessor/PrefEditQueueWork:mLock	Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: new 23	java/util/LinkedList
    //   17: dup
    //   18: aload_0
    //   19: getfield 26	com/tencent/mqq/shared_file_accessor/PrefEditQueueWork:mWorks	Ljava/util/LinkedList;
    //   22: invokespecial 72	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 26	com/tencent/mqq/shared_file_accessor/PrefEditQueueWork:mWorks	Ljava/util/LinkedList;
    //   30: invokevirtual 75	java/util/LinkedList:clear	()V
    //   33: aload_0
    //   34: getfield 53	com/tencent/mqq/shared_file_accessor/PrefEditQueueWork:mWorkHandler	Landroid/os/Handler;
    //   37: iconst_0
    //   38: invokevirtual 81	android/os/Handler:removeMessages	(I)V
    //   41: aload_2
    //   42: monitorexit
    //   43: aload_3
    //   44: invokevirtual 85	java/util/LinkedList:size	()I
    //   47: ifle +44 -> 91
    //   50: aload_3
    //   51: invokevirtual 89	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   54: astore_2
    //   55: aload_2
    //   56: invokeinterface 95 1 0
    //   61: ifeq +30 -> 91
    //   64: aload_2
    //   65: invokeinterface 99 1 0
    //   70: checkcast 101	java/lang/Runnable
    //   73: invokeinterface 104 1 0
    //   78: goto -23 -> 55
    //   81: astore_2
    //   82: aload_1
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    //   86: astore_3
    //   87: aload_2
    //   88: monitorexit
    //   89: aload_3
    //   90: athrow
    //   91: aload_1
    //   92: monitorexit
    //   93: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	PrefEditQueueWork
    //   4	88	1	localObject1	Object
    //   81	7	2	localObject3	Object
    //   25	26	3	localLinkedList	LinkedList
    //   86	4	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   7	14	81	finally
    //   43	55	81	finally
    //   55	78	81	finally
    //   82	84	81	finally
    //   89	91	81	finally
    //   91	93	81	finally
    //   14	43	86	finally
    //   87	89	86	finally
  }
  
  public void queue(Runnable paramRunnable)
  {
    synchronized (this.mLock)
    {
      if (!this.mWorks.contains(paramRunnable)) {
        this.mWorks.add(paramRunnable);
      }
      this.mWorkHandler.sendEmptyMessage(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.PrefEditQueueWork
 * JD-Core Version:    0.7.0.1
 */