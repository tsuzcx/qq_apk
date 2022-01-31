package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class OperatorBufferWithTime$ExactSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> child;
  List<T> chunk;
  boolean done;
  final Scheduler.Worker inner;
  
  public OperatorBufferWithTime$ExactSubscriber(Subscriber<? super List<T>> paramSubscriber, Scheduler.Worker paramWorker)
  {
    this.child = paramWorker;
    Object localObject;
    this.inner = localObject;
    this.chunk = new ArrayList();
  }
  
  /* Error */
  void emit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:done	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: getfield 33	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:chunk	Ljava/util/List;
    //   16: astore_1
    //   17: aload_0
    //   18: new 30	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 31	java/util/ArrayList:<init>	()V
    //   25: putfield 33	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:chunk	Ljava/util/List;
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_0
    //   31: getfield 26	rx/internal/operators/OperatorBufferWithTime$ExactSubscriber:child	Lrx/Subscriber;
    //   34: aload_1
    //   35: invokevirtual 45	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   38: return
    //   39: astore_1
    //   40: aload_1
    //   41: aload_0
    //   42: invokestatic 51	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;)V
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	ExactSubscriber
    //   16	19	1	localList	List
    //   39	2	1	localThrowable	Throwable
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	38	39	java/lang/Throwable
    //   2	11	46	finally
    //   12	30	46	finally
    //   47	49	46	finally
  }
  
  public void onCompleted()
  {
    try
    {
      this.inner.unsubscribe();
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
    Object localObject = null;
    try
    {
      if (this.done) {
        return;
      }
      this.chunk.add(paramT);
      paramT = localObject;
      if (this.chunk.size() == this.this$0.count)
      {
        paramT = this.chunk;
        this.chunk = new ArrayList();
      }
      if (paramT != null)
      {
        this.child.onNext(paramT);
        return;
      }
    }
    finally {}
  }
  
  void scheduleExact()
  {
    this.inner.schedulePeriodically(new OperatorBufferWithTime.ExactSubscriber.1(this), this.this$0.timespan, this.this$0.timespan, this.this$0.unit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithTime.ExactSubscriber
 * JD-Core Version:    0.7.0.1
 */