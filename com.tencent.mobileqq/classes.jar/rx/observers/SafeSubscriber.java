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
    //   17: astore_2
    //   18: aload_2
    //   19: instanceof 41
    //   22: ifeq +49 -> 71
    //   25: aload_0
    //   26: invokevirtual 39	rx/observers/SafeSubscriber:unsubscribe	()V
    //   29: aload_2
    //   30: checkcast 41	rx/exceptions/OnErrorNotImplementedException
    //   33: athrow
    //   34: astore_2
    //   35: aload_2
    //   36: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   39: new 27	java/lang/RuntimeException
    //   42: dup
    //   43: ldc 43
    //   45: new 45	rx/exceptions/CompositeException
    //   48: dup
    //   49: iconst_2
    //   50: anewarray 25	java/lang/Throwable
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload_2
    //   60: aastore
    //   61: invokestatic 51	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   64: invokespecial 54	rx/exceptions/CompositeException:<init>	(Ljava/util/Collection;)V
    //   67: invokespecial 57	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: athrow
    //   71: aload_2
    //   72: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   75: aload_0
    //   76: invokevirtual 39	rx/observers/SafeSubscriber:unsubscribe	()V
    //   79: new 59	rx/exceptions/OnErrorFailedException
    //   82: dup
    //   83: ldc 61
    //   85: new 45	rx/exceptions/CompositeException
    //   88: dup
    //   89: iconst_2
    //   90: anewarray 25	java/lang/Throwable
    //   93: dup
    //   94: iconst_0
    //   95: aload_1
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: aload_2
    //   100: aastore
    //   101: invokestatic 51	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   104: invokespecial 54	rx/exceptions/CompositeException:<init>	(Ljava/util/Collection;)V
    //   107: invokespecial 62	rx/exceptions/OnErrorFailedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: athrow
    //   111: astore_3
    //   112: aload_3
    //   113: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   116: new 59	rx/exceptions/OnErrorFailedException
    //   119: dup
    //   120: ldc 64
    //   122: new 45	rx/exceptions/CompositeException
    //   125: dup
    //   126: iconst_3
    //   127: anewarray 25	java/lang/Throwable
    //   130: dup
    //   131: iconst_0
    //   132: aload_1
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: aload_2
    //   137: aastore
    //   138: dup
    //   139: iconst_2
    //   140: aload_3
    //   141: aastore
    //   142: invokestatic 51	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   145: invokespecial 54	rx/exceptions/CompositeException:<init>	(Ljava/util/Collection;)V
    //   148: invokespecial 62	rx/exceptions/OnErrorFailedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: athrow
    //   152: astore_1
    //   153: aload_1
    //   154: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   157: new 59	rx/exceptions/OnErrorFailedException
    //   160: dup
    //   161: aload_1
    //   162: invokespecial 66	rx/exceptions/OnErrorFailedException:<init>	(Ljava/lang/Throwable;)V
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	SafeSubscriber
    //   0	166	1	paramThrowable	Throwable
    //   17	13	2	localThrowable1	Throwable
    //   34	103	2	localThrowable2	Throwable
    //   111	30	3	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   4	12	17	java/lang/Throwable
    //   25	29	34	java/lang/Throwable
    //   75	79	111	java/lang/Throwable
    //   12	16	152	java/lang/RuntimeException
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
    //   4: ifne +19 -> 23
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
    //   43: aload_1
    //   44: invokestatic 84	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   47: aload_1
    //   48: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   51: new 86	rx/exceptions/OnCompletedFailedException
    //   54: dup
    //   55: aload_1
    //   56: invokevirtual 78	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   59: aload_1
    //   60: invokespecial 87	rx/exceptions/OnCompletedFailedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: athrow
    //   64: astore_1
    //   65: aload_0
    //   66: invokevirtual 39	rx/observers/SafeSubscriber:unsubscribe	()V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload_1
    //   73: invokestatic 32	rx/internal/util/RxJavaPluginUtils:handleException	(Ljava/lang/Throwable;)V
    //   76: new 74	rx/exceptions/UnsubscribeFailedException
    //   79: dup
    //   80: aload_1
    //   81: invokevirtual 78	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   84: aload_1
    //   85: invokespecial 79	rx/exceptions/UnsubscribeFailedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	SafeSubscriber
    //   24	14	1	localThrowable1	Throwable
    //   42	18	1	localThrowable2	Throwable
    //   64	6	1	localObject	Object
    //   71	14	1	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	23	24	java/lang/Throwable
    //   12	19	42	java/lang/Throwable
    //   12	19	64	finally
    //   43	64	64	finally
    //   65	69	71	java/lang/Throwable
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
      if (!this.done) {
        this.actual.onNext(paramT);
      }
      return;
    }
    catch (Throwable paramT)
    {
      Exceptions.throwOrReport(paramT, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.observers.SafeSubscriber
 * JD-Core Version:    0.7.0.1
 */