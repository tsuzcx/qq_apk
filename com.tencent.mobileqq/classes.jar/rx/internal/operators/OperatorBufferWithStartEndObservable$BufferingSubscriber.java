package rx.internal.operators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.subscriptions.CompositeSubscription;

final class OperatorBufferWithStartEndObservable$BufferingSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> child;
  final List<List<T>> chunks;
  final CompositeSubscription closingSubscriptions;
  boolean done;
  
  public OperatorBufferWithStartEndObservable$BufferingSubscriber(Subscriber<? super List<T>> paramSubscriber)
  {
    Object localObject;
    this.child = localObject;
    this.chunks = new LinkedList();
    this.closingSubscriptions = new CompositeSubscription();
    add(this.closingSubscriptions);
  }
  
  void endBuffer(List<T> paramList)
  {
    try
    {
      if (this.done) {
        return;
      }
      Iterator localIterator = this.chunks.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while ((List)localIterator.next() != paramList);
      i = 1;
      localIterator.remove();
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramList;
        }
        int i = 0;
      }
    }
    if (i != 0) {
      this.child.onNext(paramList);
    }
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
        Object localObject1 = new LinkedList(this.chunks);
        this.chunks.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          List localList = (List)((Iterator)localObject1).next();
          this.child.onNext(localList);
        }
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
      this.chunks.clear();
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
      Iterator localIterator = this.chunks.iterator();
      while (localIterator.hasNext()) {
        ((List)localIterator.next()).add(paramT);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramT;
    }
  }
  
  /* Error */
  void startBuffer(TOpening paramTOpening)
  {
    // Byte code:
    //   0: new 102	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 103	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 47	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:done	Z
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 31	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:chunks	Ljava/util/List;
    //   24: aload_2
    //   25: invokeinterface 98 2 0
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield 21	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:this$0	Lrx/internal/operators/OperatorBufferWithStartEndObservable;
    //   37: getfield 109	rx/internal/operators/OperatorBufferWithStartEndObservable:bufferClosing	Lrx/functions/Func1;
    //   40: aload_1
    //   41: invokeinterface 115 2 0
    //   46: checkcast 117	rx/Observable
    //   49: astore_1
    //   50: new 119	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber$1
    //   53: dup
    //   54: aload_0
    //   55: aload_2
    //   56: invokespecial 122	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber$1:<init>	(Lrx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber;Ljava/util/List;)V
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 36	rx/internal/operators/OperatorBufferWithStartEndObservable$BufferingSubscriber:closingSubscriptions	Lrx/subscriptions/CompositeSubscription;
    //   64: aload_2
    //   65: invokevirtual 123	rx/subscriptions/CompositeSubscription:add	(Lrx/Subscription;)V
    //   68: aload_1
    //   69: aload_2
    //   70: invokevirtual 127	rx/Observable:unsafeSubscribe	(Lrx/Subscriber;)Lrx/Subscription;
    //   73: pop
    //   74: return
    //   75: astore_1
    //   76: aload_1
    //   77: aload_0
    //   78: invokestatic 91	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;)V
    //   81: return
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	BufferingSubscriber
    //   0	87	1	paramTOpening	TOpening
    //   7	63	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   33	50	75	java/lang/Throwable
    //   10	19	82	finally
    //   20	33	82	finally
    //   83	85	82	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithStartEndObservable.BufferingSubscriber
 * JD-Core Version:    0.7.0.1
 */