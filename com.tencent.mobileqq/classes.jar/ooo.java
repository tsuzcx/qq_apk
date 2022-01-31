import android.os.Handler;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;

public class ooo
  implements AsyncTaskExecutor
{
  public static final ooo a;
  private volatile Handler a;
  
  static
  {
    jdField_a_of_type_Ooo = new ooo();
  }
  
  /* Error */
  public void execute(java.lang.Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	ooo:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   4: ifnonnull +42 -> 46
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 24	ooo:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +29 -> 44
    //   18: ldc 26
    //   20: iconst_0
    //   21: invokestatic 32	com/tencent/mobileqq/app/ThreadManagerV2:newFreeHandlerThread	(Ljava/lang/String;I)Landroid/os/HandlerThread;
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 37	android/os/HandlerThread:start	()V
    //   29: aload_0
    //   30: new 39	android/os/Handler
    //   33: dup
    //   34: aload_2
    //   35: invokevirtual 43	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   38: invokespecial 46	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   41: putfield 24	ooo:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield 24	ooo:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   50: aload_1
    //   51: invokevirtual 50	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   54: pop
    //   55: return
    //   56: astore_2
    //   57: ldc 52
    //   59: iconst_2
    //   60: aload_2
    //   61: iconst_0
    //   62: anewarray 4	java/lang/Object
    //   65: invokestatic 58	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   68: aload_0
    //   69: new 39	android/os/Handler
    //   72: dup
    //   73: invokestatic 61	com/tencent/mobileqq/app/ThreadManagerV2:getFileThreadLooper	()Landroid/os/Looper;
    //   76: invokespecial 46	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   79: putfield 24	ooo:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   82: goto -38 -> 44
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ooo
    //   0	90	1	paramRunnable	java.lang.Runnable
    //   13	22	2	localObject	Object
    //   56	5	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   18	44	56	java/lang/OutOfMemoryError
    //   9	14	85	finally
    //   18	44	85	finally
    //   44	46	85	finally
    //   57	82	85	finally
    //   86	88	85	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ooo
 * JD-Core Version:    0.7.0.1
 */