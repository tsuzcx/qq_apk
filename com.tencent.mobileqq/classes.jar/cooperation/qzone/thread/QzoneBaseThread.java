package cooperation.qzone.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.Job;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class QzoneBaseThread
{
  private BaseHandler handler;
  private HandlerThread thread;
  
  public QzoneBaseThread(String paramString, int paramInt)
  {
    this.thread = new HandlerThread(paramString, paramInt);
    this.thread.start();
    this.handler = new BaseHandler(this.thread.getLooper());
  }
  
  /* Error */
  private Pair<Object, Runnable> breakRefChain(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 46	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: astore_2
    //   5: aload_2
    //   6: ldc 48
    //   8: invokevirtual 54	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   11: astore_3
    //   12: aload_3
    //   13: iconst_1
    //   14: invokevirtual 60	java/lang/reflect/Field:setAccessible	(Z)V
    //   17: aload_3
    //   18: aload_1
    //   19: invokevirtual 64	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_3
    //   24: aload_1
    //   25: aconst_null
    //   26: invokevirtual 68	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   29: new 70	com/tencent/util/Pair
    //   32: dup
    //   33: aload_2
    //   34: aload_1
    //   35: invokespecial 72	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   38: areturn
    //   39: astore 4
    //   41: aconst_null
    //   42: astore_3
    //   43: aload_3
    //   44: astore_2
    //   45: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq -19 -> 29
    //   51: ldc 80
    //   53: iconst_2
    //   54: ldc 82
    //   56: aload 4
    //   58: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   61: aload_3
    //   62: astore_2
    //   63: goto -34 -> 29
    //   66: astore 4
    //   68: aconst_null
    //   69: astore_3
    //   70: aload_3
    //   71: astore_2
    //   72: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq -46 -> 29
    //   78: ldc 80
    //   80: iconst_2
    //   81: ldc 88
    //   83: aload 4
    //   85: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   88: aload_3
    //   89: astore_2
    //   90: goto -61 -> 29
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_3
    //   97: aload_3
    //   98: astore_2
    //   99: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -73 -> 29
    //   105: ldc 80
    //   107: iconst_2
    //   108: ldc 90
    //   110: aload 4
    //   112: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_3
    //   116: astore_2
    //   117: goto -88 -> 29
    //   120: astore 4
    //   122: aload_2
    //   123: astore_3
    //   124: goto -27 -> 97
    //   127: astore 4
    //   129: aload_2
    //   130: astore_3
    //   131: goto -61 -> 70
    //   134: astore 4
    //   136: aload_2
    //   137: astore_3
    //   138: goto -95 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	QzoneBaseThread
    //   0	141	1	paramRunnable	Runnable
    //   4	133	2	localObject1	Object
    //   11	127	3	localObject2	Object
    //   39	18	4	localNoSuchFieldException1	java.lang.NoSuchFieldException
    //   66	18	4	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   93	18	4	localIllegalAccessException1	java.lang.IllegalAccessException
    //   120	1	4	localIllegalAccessException2	java.lang.IllegalAccessException
    //   127	1	4	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   134	1	4	localNoSuchFieldException2	java.lang.NoSuchFieldException
    // Exception table:
    //   from	to	target	type
    //   5	23	39	java/lang/NoSuchFieldException
    //   5	23	66	java/lang/IllegalArgumentException
    //   5	23	93	java/lang/IllegalAccessException
    //   23	29	120	java/lang/IllegalAccessException
    //   23	29	127	java/lang/IllegalArgumentException
    //   23	29	134	java/lang/NoSuchFieldException
  }
  
  private Runnable buildJob(Runnable paramRunnable, boolean paramBoolean)
  {
    Object localObject = breakRefChain(paramRunnable);
    try
    {
      localObject = new Job(((Pair)localObject).first, (Runnable)((Pair)localObject).second, paramBoolean);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ThreadManager", 1, "buildJob " + paramRunnable, localOutOfMemoryError);
    }
    return null;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public HandlerThread getHandlerThread()
  {
    return this.thread;
  }
  
  public Looper getLooper()
  {
    return this.thread.getLooper();
  }
  
  public boolean isAlive()
  {
    return this.thread.isAlive();
  }
  
  public void post(Runnable paramRunnable)
  {
    postDelayed(paramRunnable, 0L);
  }
  
  public void postDelayed(Runnable paramRunnable, long paramLong)
  {
    this.handler.postDelayed(paramRunnable, paramLong);
  }
  
  public void postIrrevocableTask(Runnable paramRunnable)
  {
    postIrrevocableTask(paramRunnable, 0L);
  }
  
  public void postIrrevocableTask(Runnable paramRunnable, long paramLong)
  {
    postDelayed(buildJob(paramRunnable, true), paramLong);
  }
  
  public void removeTask(Runnable paramRunnable)
  {
    this.handler.removeCallbacks(paramRunnable);
  }
  
  public void setDaemon(boolean paramBoolean)
  {
    this.thread.setDaemon(paramBoolean);
  }
  
  public void start()
  {
    this.thread.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.thread.QzoneBaseThread
 * JD-Core Version:    0.7.0.1
 */