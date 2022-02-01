package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Queue;

public class DispatchThread
  extends Thread
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private final Queue<Runnable> jdField_a_of_type_JavaUtilQueue;
  
  private boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangBoolean)
    {
      boolean bool = this.jdField_a_of_type_JavaLangBoolean.booleanValue();
      return bool;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 25	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   11: invokeinterface 31 1 0
    //   16: ifne +36 -> 52
    //   19: aload_0
    //   20: invokespecial 33	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:a	()Z
    //   23: istore_1
    //   24: iload_1
    //   25: ifne +27 -> 52
    //   28: aload_0
    //   29: getfield 25	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   32: invokevirtual 38	java/lang/Object:wait	()V
    //   35: goto -28 -> 7
    //   38: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +11 -> 52
    //   44: ldc 45
    //   46: iconst_2
    //   47: ldc 47
    //   49: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 25	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   56: invokeinterface 55 1 0
    //   61: checkcast 57	java/lang/Runnable
    //   64: astore_3
    //   65: aload_2
    //   66: monitorexit
    //   67: aload_3
    //   68: ifnonnull +19 -> 87
    //   71: aload_0
    //   72: invokespecial 33	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:a	()Z
    //   75: ifeq -75 -> 0
    //   78: aload_0
    //   79: getfield 59	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   82: invokevirtual 64	android/os/HandlerThread:quit	()Z
    //   85: pop
    //   86: return
    //   87: aload_3
    //   88: invokeinterface 66 1 0
    //   93: aload_0
    //   94: monitorenter
    //   95: aload_0
    //   96: getfield 68	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   99: new 70	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread$1
    //   102: dup
    //   103: aload_0
    //   104: invokespecial 74	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread$1:<init>	(Lcom/tencent/mobileqq/shortvideo/mediadevice/DispatchThread;)V
    //   107: invokevirtual 80	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   110: pop
    //   111: aload_0
    //   112: invokevirtual 38	java/lang/Object:wait	()V
    //   115: aload_0
    //   116: monitorexit
    //   117: goto -117 -> 0
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    //   125: astore_3
    //   126: aload_2
    //   127: monitorexit
    //   128: goto +5 -> 133
    //   131: aload_3
    //   132: athrow
    //   133: goto -2 -> 131
    //   136: astore_3
    //   137: goto -99 -> 38
    //   140: astore_2
    //   141: goto -26 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	DispatchThread
    //   23	2	1	bool	boolean
    //   4	62	2	localQueue	Queue
    //   120	7	2	localObject1	Object
    //   140	1	2	localInterruptedException1	java.lang.InterruptedException
    //   64	24	3	localRunnable	Runnable
    //   125	7	3	localObject2	Object
    //   136	1	3	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   95	111	120	finally
    //   111	115	120	finally
    //   115	117	120	finally
    //   121	123	120	finally
    //   7	24	125	finally
    //   28	35	125	finally
    //   38	52	125	finally
    //   52	67	125	finally
    //   126	128	125	finally
    //   28	35	136	java/lang/InterruptedException
    //   111	115	140	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.DispatchThread
 * JD-Core Version:    0.7.0.1
 */