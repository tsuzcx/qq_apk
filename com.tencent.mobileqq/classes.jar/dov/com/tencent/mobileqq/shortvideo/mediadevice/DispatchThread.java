package dov.com.tencent.mobileqq.shortvideo.mediadevice;

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
    //   1: getfield 25	dov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 25	dov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   11: invokeinterface 31 1 0
    //   16: ifne +37 -> 53
    //   19: aload_0
    //   20: invokespecial 33	dov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:a	()Z
    //   23: istore_1
    //   24: iload_1
    //   25: ifne +28 -> 53
    //   28: aload_0
    //   29: getfield 25	dov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   32: invokevirtual 38	java/lang/Object:wait	()V
    //   35: goto -28 -> 7
    //   38: astore_3
    //   39: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +11 -> 53
    //   45: ldc 45
    //   47: iconst_2
    //   48: ldc 47
    //   50: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 25	dov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   57: invokeinterface 55 1 0
    //   62: checkcast 57	java/lang/Runnable
    //   65: astore_3
    //   66: aload_2
    //   67: monitorexit
    //   68: aload_3
    //   69: ifnonnull +24 -> 93
    //   72: aload_0
    //   73: invokespecial 33	dov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:a	()Z
    //   76: ifeq -76 -> 0
    //   79: aload_0
    //   80: getfield 59	dov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   83: invokevirtual 64	android/os/HandlerThread:quit	()Z
    //   86: pop
    //   87: return
    //   88: astore_3
    //   89: aload_2
    //   90: monitorexit
    //   91: aload_3
    //   92: athrow
    //   93: aload_3
    //   94: invokeinterface 66 1 0
    //   99: aload_0
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 68	dov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   105: new 70	dov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread$1
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 74	dov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread$1:<init>	(Ldov/com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread;)V
    //   113: invokevirtual 80	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   116: pop
    //   117: aload_0
    //   118: invokevirtual 38	java/lang/Object:wait	()V
    //   121: aload_0
    //   122: monitorexit
    //   123: goto -123 -> 0
    //   126: astore_2
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_2
    //   130: athrow
    //   131: astore_2
    //   132: goto -11 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	DispatchThread
    //   23	2	1	bool	boolean
    //   4	86	2	localQueue	Queue
    //   126	4	2	localObject1	Object
    //   131	1	2	localInterruptedException1	java.lang.InterruptedException
    //   38	1	3	localInterruptedException2	java.lang.InterruptedException
    //   65	4	3	localRunnable	Runnable
    //   88	6	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	35	38	java/lang/InterruptedException
    //   7	24	88	finally
    //   28	35	88	finally
    //   39	53	88	finally
    //   53	68	88	finally
    //   89	91	88	finally
    //   101	117	126	finally
    //   117	121	126	finally
    //   121	123	126	finally
    //   127	129	126	finally
    //   117	121	131	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.mediadevice.DispatchThread
 * JD-Core Version:    0.7.0.1
 */