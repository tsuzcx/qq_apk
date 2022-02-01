package rx.observers;

import rx.Subscriber;
import rx.exceptions.Exceptions;

public class SafeSubscriber<T>
  extends Subscriber<T>
{
  private final Subscriber<? super T> actual;
  boolean done = false;
  
  public SafeSubscriber(Subscriber<? super T> paramSubscriber)
  {
    super(paramSubscriber);
    this.actual = paramSubscriber;
  }
  
  /* Error */
  protected void _onError(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   4: aload_0
    //   5: getfield 18	rx/observers/SafeSubscriber:actual	Lrx/Subscriber;
    //   8: aload_1
    //   9: invokevirtual 35	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   12: aload_0
    //   13: invokevirtual 39	rx/observers/SafeSubscriber:unsubscribe	()V
    //   16: return
    //   17: astore_1
    //   18: aload_1
    //   19: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   22: new 41	rx/exceptions/OnErrorFailedException
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 43	rx/exceptions/OnErrorFailedException:<init>	(Ljava/lang/Throwable;)V
    //   30: athrow
    //   31: astore_2
    //   32: aload_2
    //   33: instanceof 45
    //   36: ifeq +49 -> 85
    //   39: aload_0
    //   40: invokevirtual 39	rx/observers/SafeSubscriber:unsubscribe	()V
    //   43: aload_2
    //   44: checkcast 45	rx/exceptions/OnErrorNotImplementedException
    //   47: athrow
    //   48: astore_2
    //   49: aload_2
    //   50: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   53: new 27	java/lang/RuntimeException
    //   56: dup
    //   57: ldc 47
    //   59: new 49	rx/exceptions/CompositeException
    //   62: dup
    //   63: iconst_2
    //   64: anewarray 25	java/lang/Throwable
    //   67: dup
    //   68: iconst_0
    //   69: aload_1
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload_2
    //   74: aastore
    //   75: invokestatic 55	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   78: invokespecial 58	rx/exceptions/CompositeException:<init>	(Ljava/util/Collection;)V
    //   81: invokespecial 61	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   84: athrow
    //   85: aload_2
    //   86: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   89: aload_0
    //   90: invokevirtual 39	rx/observers/SafeSubscriber:unsubscribe	()V
    //   93: new 41	rx/exceptions/OnErrorFailedException
    //   96: dup
    //   97: ldc 63
    //   99: new 49	rx/exceptions/CompositeException
    //   102: dup
    //   103: iconst_2
    //   104: anewarray 25	java/lang/Throwable
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload_2
    //   114: aastore
    //   115: invokestatic 55	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   118: invokespecial 58	rx/exceptions/CompositeException:<init>	(Ljava/util/Collection;)V
    //   121: invokespecial 64	rx/exceptions/OnErrorFailedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: athrow
    //   125: astore_3
    //   126: aload_3
    //   127: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   130: new 41	rx/exceptions/OnErrorFailedException
    //   133: dup
    //   134: ldc 66
    //   136: new 49	rx/exceptions/CompositeException
    //   139: dup
    //   140: iconst_3
    //   141: anewarray 25	java/lang/Throwable
    //   144: dup
    //   145: iconst_0
    //   146: aload_1
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: aload_2
    //   151: aastore
    //   152: dup
    //   153: iconst_2
    //   154: aload_3
    //   155: aastore
    //   156: invokestatic 55	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   159: invokespecial 58	rx/exceptions/CompositeException:<init>	(Ljava/util/Collection;)V
    //   162: invokespecial 64	rx/exceptions/OnErrorFailedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	SafeSubscriber
    //   0	166	1	paramThrowable	Throwable
    //   31	13	2	localThrowable1	Throwable
    //   48	103	2	localThrowable2	Throwable
    //   125	30	3	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   12	16	17	java/lang/RuntimeException
    //   4	12	31	java/lang/Throwable
    //   39	43	48	java/lang/Throwable
    //   89	93	125	java/lang/Throwable
  }
  
  public Subscriber<? super T> getActual()
  {
    return this.actual;
  }
  
  /* Error */
  public void onCompleted()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	rx/observers/SafeSubscriber:done	Z
    //   4: ifne +88 -> 92
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 16	rx/observers/SafeSubscriber:done	Z
    //   12: aload_0
    //   13: getfield 18	rx/observers/SafeSubscriber:actual	Lrx/Subscriber;
    //   16: invokevirtual 72	rx/Subscriber:onCompleted	()V
    //   19: aload_0
    //   20: invokevirtual 39	rx/observers/SafeSubscriber:unsubscribe	()V
    //   23: return
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   29: new 74	rx/exceptions/UnsubscribeFailedException
    //   32: dup
    //   33: aload_1
    //   34: invokevirtual 78	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   37: aload_1
    //   38: invokespecial 79	rx/exceptions/UnsubscribeFailedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   41: athrow
    //   42: astore_1
    //   43: goto +25 -> 68
    //   46: astore_1
    //   47: aload_1
    //   48: invokestatic 84	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   51: aload_1
    //   52: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   55: new 86	rx/exceptions/OnCompletedFailedException
    //   58: dup
    //   59: aload_1
    //   60: invokevirtual 78	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   63: aload_1
    //   64: invokespecial 87	rx/exceptions/OnCompletedFailedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: athrow
    //   68: aload_0
    //   69: invokevirtual 39	rx/observers/SafeSubscriber:unsubscribe	()V
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: aload_1
    //   76: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   79: new 74	rx/exceptions/UnsubscribeFailedException
    //   82: dup
    //   83: aload_1
    //   84: invokevirtual 78	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   87: aload_1
    //   88: invokespecial 79	rx/exceptions/UnsubscribeFailedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: athrow
    //   92: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	SafeSubscriber
    //   24	14	1	localThrowable1	Throwable
    //   42	1	1	localObject	Object
    //   46	27	1	localThrowable2	Throwable
    //   74	14	1	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	23	24	java/lang/Throwable
    //   12	19	42	finally
    //   47	68	42	finally
    //   12	19	46	java/lang/Throwable
    //   68	72	74	java/lang/Throwable
  }
  
  public void onError(Throwable paramThrowable)
  {
    Exceptions.throwIfFatal(paramThrowable);
    if (!this.done)
    {
      this.done = true;
      _onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    try
    {
      if (!this.done)
      {
        this.actual.onNext(paramT);
        return;
      }
    }
    catch (Throwable paramT)
    {
      Exceptions.throwOrReport(paramT, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.observers.SafeSubscriber
 * JD-Core Version:    0.7.0.1
 */