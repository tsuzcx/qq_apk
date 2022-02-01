package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class OperatorBufferWithTime$InexactSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> child;
  final List<List<T>> chunks;
  boolean done;
  final Scheduler.Worker inner;
  
  public OperatorBufferWithTime$InexactSubscriber(Subscriber<? super List<T>> paramSubscriber, Scheduler.Worker paramWorker)
  {
    this.child = paramWorker;
    Object localObject;
    this.inner = localObject;
    this.chunks = new LinkedList();
  }
  
  void emitChunk(List<T> paramList)
  {
    for (;;)
    {
      try
      {
        if (this.done) {
          return;
        }
        Iterator localIterator = this.chunks.iterator();
        if (localIterator.hasNext())
        {
          if ((List)localIterator.next() != paramList) {
            continue;
          }
          localIterator.remove();
          i = 1;
          if (i == 0) {
            break;
          }
          try
          {
            this.child.onNext(paramList);
            return;
          }
          catch (Throwable paramList)
          {
            Exceptions.throwOrReport(paramList, this);
            return;
          }
        }
        int i = 0;
      }
      finally {}
    }
  }
  
  /* Error */
  public void onCompleted()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:done	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 42	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:done	Z
    //   17: new 30	java/util/LinkedList
    //   20: dup
    //   21: aload_0
    //   22: getfield 33	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:chunks	Ljava/util/List;
    //   25: invokespecial 76	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 33	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:chunks	Ljava/util/List;
    //   33: invokeinterface 79 1 0
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: invokeinterface 48 1 0
    //   46: astore_1
    //   47: aload_1
    //   48: invokeinterface 54 1 0
    //   53: ifeq +39 -> 92
    //   56: aload_1
    //   57: invokeinterface 58 1 0
    //   62: checkcast 44	java/util/List
    //   65: astore_2
    //   66: aload_0
    //   67: getfield 26	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:child	Lrx/Subscriber;
    //   70: aload_2
    //   71: invokevirtual 65	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   74: goto -27 -> 47
    //   77: astore_1
    //   78: aload_1
    //   79: aload_0
    //   80: getfield 26	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:child	Lrx/Subscriber;
    //   83: invokestatic 71	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;)V
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    //   92: aload_0
    //   93: getfield 26	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:child	Lrx/Subscriber;
    //   96: invokevirtual 81	rx/Subscriber:onCompleted	()V
    //   99: aload_0
    //   100: invokevirtual 84	rx/internal/operators/OperatorBufferWithTime$InexactSubscriber:unsubscribe	()V
    //   103: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	InexactSubscriber
    //   28	29	1	localObject1	Object
    //   77	2	1	localThrowable	Throwable
    //   87	4	1	localObject2	Object
    //   65	6	2	localList	List
    // Exception table:
    //   from	to	target	type
    //   0	2	77	java/lang/Throwable
    //   40	47	77	java/lang/Throwable
    //   47	74	77	java/lang/Throwable
    //   90	92	77	java/lang/Throwable
    //   2	11	87	finally
    //   12	40	87	finally
    //   88	90	87	finally
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
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (this.done) {
          return;
        }
        Iterator localIterator = this.chunks.iterator();
        if (localIterator.hasNext())
        {
          List localList = (List)localIterator.next();
          localList.add(paramT);
          localObject2 = localObject1;
          if (localList.size() == this.this$0.count)
          {
            localIterator.remove();
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new LinkedList();
            }
            ((List)localObject2).add(localList);
          }
        }
        else
        {
          if (localObject1 != null)
          {
            paramT = ((List)localObject1).iterator();
            if (paramT.hasNext())
            {
              localObject1 = (List)paramT.next();
              this.child.onNext(localObject1);
              continue;
            }
          }
          return;
        }
      }
      finally {}
      localObject1 = localObject2;
    }
  }
  
  void scheduleChunk()
  {
    this.inner.schedulePeriodically(new OperatorBufferWithTime.InexactSubscriber.1(this), this.this$0.timeshift, this.this$0.timeshift, this.this$0.unit);
  }
  
  void startNewChunk()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (this.done) {
        return;
      }
      this.chunks.add(localArrayList);
      this.inner.schedule(new OperatorBufferWithTime.InexactSubscriber.2(this, localArrayList), this.this$0.timespan, this.this$0.unit);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithTime.InexactSubscriber
 * JD-Core Version:    0.7.0.1
 */