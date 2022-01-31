import com.tencent.component.network.utils.http.pool.FutureCallback;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public abstract class pqa
  implements Future
{
  private final FutureCallback jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolFutureCallback;
  private Object jdField_a_of_type_JavaLangObject;
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition;
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  pqa(Lock paramLock, FutureCallback paramFutureCallback)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = paramLock;
    this.jdField_a_of_type_JavaUtilConcurrentLocksCondition = paramLock.newCondition();
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolFutureCallback = paramFutureCallback;
  }
  
  protected abstract Object a(long paramLong, TimeUnit paramTimeUnit);
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.signalAll();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public boolean a(Date paramDate)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        throw new InterruptedException("Operation interrupted");
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    if (paramDate != null) {}
    for (boolean bool = this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.awaitUntil(paramDate); this.jdField_a_of_type_Boolean; bool = true)
    {
      throw new InterruptedException("Operation interrupted");
      this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.await();
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    return bool;
  }
  
  /* Error */
  public boolean cancel(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 20	pqa:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 35 1 0
    //   11: aload_0
    //   12: getfield 63	pqa:b	Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifeq +18 -> 35
    //   20: iconst_0
    //   21: istore_1
    //   22: aload_0
    //   23: getfield 20	pqa:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   26: astore_3
    //   27: aload_3
    //   28: invokeinterface 43 1 0
    //   33: iload_1
    //   34: ireturn
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 63	pqa:b	Z
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 46	pqa:jdField_a_of_type_Boolean	Z
    //   45: aload_0
    //   46: getfield 30	pqa:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolFutureCallback	Lcom/tencent/component/network/utils/http/pool/FutureCallback;
    //   49: ifnull +12 -> 61
    //   52: aload_0
    //   53: getfield 30	pqa:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolFutureCallback	Lcom/tencent/component/network/utils/http/pool/FutureCallback;
    //   56: invokeinterface 67 1 0
    //   61: aload_0
    //   62: getfield 28	pqa:jdField_a_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   65: invokeinterface 40 1 0
    //   70: aload_0
    //   71: getfield 20	pqa:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   74: astore_3
    //   75: goto -48 -> 27
    //   78: astore_3
    //   79: aload_0
    //   80: getfield 20	pqa:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 43 1 0
    //   88: aload_3
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	pqa
    //   0	90	1	paramBoolean	boolean
    //   15	2	2	bool	boolean
    //   26	49	3	localLock	Lock
    //   78	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	16	78	finally
    //   35	61	78	finally
    //   61	70	78	finally
  }
  
  public Object get()
  {
    try
    {
      Object localObject = get(0L, TimeUnit.MILLISECONDS);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new ExecutionException(localTimeoutException);
    }
  }
  
  /* Error */
  public Object get(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	pqa:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 35 1 0
    //   9: aload_0
    //   10: getfield 63	pqa:b	Z
    //   13: ifeq +23 -> 36
    //   16: aload_0
    //   17: getfield 88	pqa:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 20	pqa:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   25: astore 4
    //   27: aload 4
    //   29: invokeinterface 43 1 0
    //   34: aload_3
    //   35: areturn
    //   36: aload_0
    //   37: aload_0
    //   38: lload_1
    //   39: aload_3
    //   40: invokevirtual 90	pqa:a	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   43: putfield 88	pqa:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 63	pqa:b	Z
    //   51: aload_0
    //   52: getfield 30	pqa:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolFutureCallback	Lcom/tencent/component/network/utils/http/pool/FutureCallback;
    //   55: ifnull +16 -> 71
    //   58: aload_0
    //   59: getfield 30	pqa:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolFutureCallback	Lcom/tencent/component/network/utils/http/pool/FutureCallback;
    //   62: aload_0
    //   63: getfield 88	pqa:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   66: invokeinterface 93 2 0
    //   71: aload_0
    //   72: getfield 88	pqa:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   75: astore_3
    //   76: aload_0
    //   77: getfield 20	pqa:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   80: astore 4
    //   82: goto -55 -> 27
    //   85: astore_3
    //   86: aload_0
    //   87: iconst_1
    //   88: putfield 63	pqa:b	Z
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 88	pqa:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   96: aload_0
    //   97: getfield 30	pqa:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolFutureCallback	Lcom/tencent/component/network/utils/http/pool/FutureCallback;
    //   100: ifnull +13 -> 113
    //   103: aload_0
    //   104: getfield 30	pqa:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolFutureCallback	Lcom/tencent/component/network/utils/http/pool/FutureCallback;
    //   107: aload_3
    //   108: invokeinterface 96 2 0
    //   113: new 81	java/util/concurrent/ExecutionException
    //   116: dup
    //   117: aload_3
    //   118: invokespecial 84	java/util/concurrent/ExecutionException:<init>	(Ljava/lang/Throwable;)V
    //   121: athrow
    //   122: astore_3
    //   123: aload_0
    //   124: getfield 20	pqa:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   127: invokeinterface 43 1 0
    //   132: aload_3
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	pqa
    //   0	134	1	paramLong	long
    //   0	134	3	paramTimeUnit	TimeUnit
    //   25	56	4	localLock	Lock
    // Exception table:
    //   from	to	target	type
    //   9	21	85	java/io/IOException
    //   36	71	85	java/io/IOException
    //   71	76	85	java/io/IOException
    //   9	21	122	finally
    //   36	71	122	finally
    //   71	76	122	finally
    //   86	113	122	finally
    //   113	122	122	finally
  }
  
  public boolean isCancelled()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean isDone()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pqa
 * JD-Core Version:    0.7.0.1
 */