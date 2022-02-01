package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class OperatorBufferWithSingleObservable$BufferingSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> child;
  List<T> chunk;
  boolean done;
  
  public OperatorBufferWithSingleObservable$BufferingSubscriber(Subscriber<? super List<T>> paramSubscriber)
  {
    Object localObject;
    this.child = localObject;
    this.chunk = new ArrayList(paramSubscriber.initialCapacity);
  }
  
  /* Error */
  void emit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	rx/internal/operators/OperatorBufferWithSingleObservable$BufferingSubscriber:done	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: getfield 37	rx/internal/operators/OperatorBufferWithSingleObservable$BufferingSubscriber:chunk	Ljava/util/List;
    //   16: astore_1
    //   17: aload_0
    //   18: new 26	java/util/ArrayList
    //   21: dup
    //   22: aload_0
    //   23: getfield 19	rx/internal/operators/OperatorBufferWithSingleObservable$BufferingSubscriber:this$0	Lrx/internal/operators/OperatorBufferWithSingleObservable;
    //   26: getfield 32	rx/internal/operators/OperatorBufferWithSingleObservable:initialCapacity	I
    //   29: invokespecial 35	java/util/ArrayList:<init>	(I)V
    //   32: putfield 37	rx/internal/operators/OperatorBufferWithSingleObservable$BufferingSubscriber:chunk	Ljava/util/List;
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: getfield 24	rx/internal/operators/OperatorBufferWithSingleObservable$BufferingSubscriber:child	Lrx/Subscriber;
    //   41: aload_1
    //   42: invokevirtual 49	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: invokevirtual 52	rx/internal/operators/OperatorBufferWithSingleObservable$BufferingSubscriber:unsubscribe	()V
    //   51: aload_0
    //   52: monitorenter
    //   53: aload_0
    //   54: getfield 45	rx/internal/operators/OperatorBufferWithSingleObservable$BufferingSubscriber:done	Z
    //   57: ifeq +6 -> 63
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: aload_0
    //   64: iconst_1
    //   65: putfield 45	rx/internal/operators/OperatorBufferWithSingleObservable$BufferingSubscriber:done	Z
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: aload_0
    //   72: getfield 24	rx/internal/operators/OperatorBufferWithSingleObservable$BufferingSubscriber:child	Lrx/Subscriber;
    //   75: invokestatic 58	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;)V
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	BufferingSubscriber
    //   16	26	1	localList	List
    //   46	25	1	localThrowable	Throwable
    //   79	4	1	localObject1	Object
    //   84	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   37	45	46	java/lang/Throwable
    //   53	62	79	finally
    //   63	70	79	finally
    //   80	82	79	finally
    //   2	11	84	finally
    //   12	37	84	finally
    //   85	87	84	finally
  }
  
  public void onCompleted()
  {
    try
    {
      try
      {
        if (this.done) {
          return;
        }
        this.done = true;
        List localList = this.chunk;
        this.chunk = null;
        this.child.onNext(localList);
        this.child.onCompleted();
        unsubscribe();
        return;
      }
      finally {}
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.child);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      if (this.done) {
        return;
      }
      this.done = true;
      this.chunk = null;
      this.child.onError(paramThrowable);
      unsubscribe();
      return;
    }
    finally {}
  }
  
  public void onNext(T paramT)
  {
    try
    {
      if (this.done) {
        return;
      }
      this.chunk.add(paramT);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSingleObservable.BufferingSubscriber
 * JD-Core Version:    0.7.0.1
 */