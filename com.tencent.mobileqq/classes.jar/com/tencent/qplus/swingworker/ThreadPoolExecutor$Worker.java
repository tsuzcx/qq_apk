package com.tencent.qplus.swingworker;

import java.util.concurrent.locks.ReentrantLock;

final class ThreadPoolExecutor$Worker
  implements Runnable
{
  volatile long completedTasks;
  Runnable currentTask;
  private final ReentrantLock runLock = new ReentrantLock();
  Thread thread;
  
  ThreadPoolExecutor$Worker(ThreadPoolExecutor paramThreadPoolExecutor, Runnable paramRunnable)
  {
    this.currentTask = paramRunnable;
  }
  
  /* Error */
  private void runTask(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:runLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 38	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 20	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   15: getfield 44	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
    //   18: iconst_2
    //   19: if_icmpge +27 -> 46
    //   22: invokestatic 50	java/lang/Thread:interrupted	()Z
    //   25: ifeq +21 -> 46
    //   28: aload_0
    //   29: getfield 20	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   32: getfield 44	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
    //   35: iconst_2
    //   36: if_icmplt +10 -> 46
    //   39: aload_0
    //   40: getfield 52	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:thread	Ljava/lang/Thread;
    //   43: invokevirtual 55	java/lang/Thread:interrupt	()V
    //   46: iconst_0
    //   47: istore_2
    //   48: aload_0
    //   49: getfield 20	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   52: aload_0
    //   53: getfield 52	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:thread	Ljava/lang/Thread;
    //   56: aload_1
    //   57: invokevirtual 59	com/tencent/qplus/swingworker/ThreadPoolExecutor:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   60: aload_1
    //   61: invokeinterface 62 1 0
    //   66: iconst_1
    //   67: istore_3
    //   68: iload_3
    //   69: istore_2
    //   70: aload_0
    //   71: getfield 20	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   74: aload_1
    //   75: aconst_null
    //   76: invokevirtual 66	com/tencent/qplus/swingworker/ThreadPoolExecutor:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   79: iload_3
    //   80: istore_2
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 68	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:completedTasks	J
    //   86: lconst_1
    //   87: ladd
    //   88: putfield 68	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:completedTasks	J
    //   91: aload 4
    //   93: invokevirtual 71	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   96: return
    //   97: astore 5
    //   99: iload_2
    //   100: ifne +13 -> 113
    //   103: aload_0
    //   104: getfield 20	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   107: aload_1
    //   108: aload 5
    //   110: invokevirtual 66	com/tencent/qplus/swingworker/ThreadPoolExecutor:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   113: aload 5
    //   115: athrow
    //   116: astore_1
    //   117: aload 4
    //   119: invokevirtual 71	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	Worker
    //   0	124	1	paramRunnable	Runnable
    //   47	53	2	i	int
    //   67	13	3	j	int
    //   4	114	4	localReentrantLock	ReentrantLock
    //   97	17	5	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   60	66	97	java/lang/RuntimeException
    //   70	79	97	java/lang/RuntimeException
    //   81	91	97	java/lang/RuntimeException
    //   11	46	116	finally
    //   48	60	116	finally
    //   60	66	116	finally
    //   70	79	116	finally
    //   81	91	116	finally
    //   103	113	116	finally
    //   113	116	116	finally
  }
  
  void interruptIfIdle()
  {
    ReentrantLock localReentrantLock = this.runLock;
    if (localReentrantLock.tryLock()) {}
    try
    {
      if (this.thread != Thread.currentThread()) {
        this.thread.interrupt();
      }
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  void interruptNow()
  {
    this.thread.interrupt();
  }
  
  boolean isActive()
  {
    return this.runLock.isLocked();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:currentTask	Ljava/lang/Runnable;
    //   4: ifnonnull +25 -> 29
    //   7: aload_0
    //   8: getfield 20	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   11: aload_0
    //   12: invokevirtual 88	com/tencent/qplus/swingworker/ThreadPoolExecutor:getTask	(Lcom/tencent/qplus/swingworker/ThreadPoolExecutor$Worker;)Z
    //   15: istore_1
    //   16: iload_1
    //   17: ifne +12 -> 29
    //   20: aload_0
    //   21: getfield 20	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   24: aload_0
    //   25: invokevirtual 92	com/tencent/qplus/swingworker/ThreadPoolExecutor:workerDone	(Lcom/tencent/qplus/swingworker/ThreadPoolExecutor$Worker;)V
    //   28: return
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 30	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:currentTask	Ljava/lang/Runnable;
    //   34: invokespecial 94	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:runTask	(Ljava/lang/Runnable;)V
    //   37: aload_0
    //   38: getfield 20	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   41: getfield 97	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   44: invokevirtual 38	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 30	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:currentTask	Ljava/lang/Runnable;
    //   52: aload_0
    //   53: getfield 20	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   56: getfield 97	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   59: invokevirtual 71	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   62: goto -62 -> 0
    //   65: astore_2
    //   66: aload_0
    //   67: getfield 20	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   70: aload_0
    //   71: invokevirtual 92	com/tencent/qplus/swingworker/ThreadPoolExecutor:workerDone	(Lcom/tencent/qplus/swingworker/ThreadPoolExecutor$Worker;)V
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	Worker
    //   15	2	1	bool	boolean
    //   65	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	16	65	finally
    //   29	62	65	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.ThreadPoolExecutor.Worker
 * JD-Core Version:    0.7.0.1
 */