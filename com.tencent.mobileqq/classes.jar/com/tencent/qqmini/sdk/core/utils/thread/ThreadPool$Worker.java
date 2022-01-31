package com.tencent.qqmini.sdk.core.utils.thread;

import bglx;
import bgly;
import bgmd;
import bgme;
import bgmg;
import com.tencent.qqmini.sdk.log.QMLog;

class ThreadPool$Worker<T>
  implements bglx<T>, bgme, Comparable<Worker>, Runnable
{
  private int jdField_a_of_type_Int;
  private final bgly<T> jdField_a_of_type_Bgly;
  private final bgmd<T> jdField_a_of_type_Bgmd;
  private bgmg jdField_a_of_type_Bgmg;
  private T jdField_a_of_type_JavaLangObject;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private bgmg a(int paramInt)
  {
    if (paramInt == 1) {
      return this.this$0.jdField_a_of_type_Bgmg;
    }
    if (paramInt == 2) {
      return this.this$0.b;
    }
    return null;
  }
  
  private void a(bgmg parambgmg)
  {
    try
    {
      parambgmg.jdField_a_of_type_Int += 1;
      parambgmg.notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(bgmg parambgmg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/qqmini/sdk/core/utils/thread/ThreadPool$Worker:jdField_a_of_type_Boolean	Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 51	com/tencent/qqmini/sdk/core/utils/thread/ThreadPool$Worker:jdField_a_of_type_Bgmg	Lbgmg;
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 51	com/tencent/qqmini/sdk/core/utils/thread/ThreadPool$Worker:jdField_a_of_type_Bgmg	Lbgmg;
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: monitorenter
    //   27: aload_1
    //   28: getfield 41	bgmg:jdField_a_of_type_Int	I
    //   31: ifle +31 -> 62
    //   34: aload_1
    //   35: aload_1
    //   36: getfield 41	bgmg:jdField_a_of_type_Int	I
    //   39: iconst_1
    //   40: isub
    //   41: putfield 41	bgmg:jdField_a_of_type_Int	I
    //   44: aload_1
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorenter
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 51	com/tencent/qqmini/sdk/core/utils/thread/ThreadPool$Worker:jdField_a_of_type_Bgmg	Lbgmg;
    //   53: aload_0
    //   54: monitorexit
    //   55: iconst_1
    //   56: ireturn
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: aload_1
    //   63: invokevirtual 54	java/lang/Object:wait	()V
    //   66: aload_1
    //   67: monitorexit
    //   68: goto -68 -> 0
    //   71: astore_2
    //   72: aload_1
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: astore_2
    //   82: goto -16 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	Worker
    //   0	85	1	parambgmg	bgmg
    //   71	4	2	localObject	Object
    //   81	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	16	57	finally
    //   18	25	57	finally
    //   58	60	57	finally
    //   27	46	71	finally
    //   62	66	71	finally
    //   66	68	71	finally
    //   72	74	71	finally
    //   48	55	76	finally
    //   77	79	76	finally
    //   62	66	81	java/lang/InterruptedException
  }
  
  public int a(Worker paramWorker)
  {
    return ((Comparable)this.jdField_a_of_type_Bgmd).compareTo(paramWorker.jdField_a_of_type_Bgmd);
  }
  
  public boolean a(int paramInt)
  {
    bgmg localbgmg = a(this.jdField_a_of_type_Int);
    if (localbgmg != null) {
      a(localbgmg);
    }
    this.jdField_a_of_type_Int = 0;
    localbgmg = a(paramInt);
    if (localbgmg != null)
    {
      if (!a(localbgmg)) {
        return false;
      }
      this.jdField_a_of_type_Int = paramInt;
    }
    return true;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Bgly != null) {
      this.jdField_a_of_type_Bgly.a(this);
    }
    Object localObject4 = null;
    Object localObject1 = localObject4;
    if (a(1)) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Bgmd.a(this);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          a(0);
          this.jdField_a_of_type_JavaLangObject = localObject1;
          this.b = true;
          notifyAll();
          if (this.jdField_a_of_type_Bgly != null) {
            this.jdField_a_of_type_Bgly.b(this);
          }
          return;
        }
        finally {}
        localThrowable = localThrowable;
        QMLog.w("Worker", "Exception in running a job", localThrowable);
        Object localObject2 = localObject4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.thread.ThreadPool.Worker
 * JD-Core Version:    0.7.0.1
 */