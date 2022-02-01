package rx.internal.producers;

import java.util.Iterator;
import java.util.List;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;

public final class ProducerObserverArbiter<T>
  implements Observer<T>, Producer
{
  static final Producer NULL_PRODUCER = new ProducerObserverArbiter.1();
  final Subscriber<? super T> child;
  Producer currentProducer;
  boolean emitting;
  volatile boolean hasError;
  Producer missedProducer;
  long missedRequested;
  Object missedTerminal;
  List<T> queue;
  long requested;
  
  public ProducerObserverArbiter(Subscriber<? super T> paramSubscriber)
  {
    this.child = paramSubscriber;
  }
  
  void emitLoop()
  {
    Subscriber localSubscriber = this.child;
    Object localObject1 = null;
    long l3 = 0L;
    for (;;)
    {
      try
      {
        long l5 = this.missedRequested;
        Producer localProducer = this.missedProducer;
        Object localObject4 = this.missedTerminal;
        List localList = this.queue;
        int j = 1;
        if ((l5 == 0L) && (localProducer == null) && (localList == null) && (localObject4 == null))
        {
          this.emitting = false;
          i = 1;
        }
        else
        {
          this.missedRequested = 0L;
          this.missedProducer = null;
          this.queue = null;
          this.missedTerminal = null;
          i = 0;
        }
        if (i != 0)
        {
          if ((l3 != 0L) && (localObject1 != null)) {
            localObject1.request(l3);
          }
          return;
        }
        int i = j;
        if (localList != null) {
          if (localList.isEmpty()) {
            i = j;
          } else {
            i = 0;
          }
        }
        if (localObject4 != null)
        {
          if (localObject4 != Boolean.TRUE)
          {
            localSubscriber.onError((Throwable)localObject4);
            return;
          }
          if (i != 0)
          {
            localSubscriber.onCompleted();
            return;
          }
        }
        long l4;
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject4 = localIterator.next();
              if (localSubscriber.isUnsubscribed()) {
                return;
              }
              if (this.hasError) {
                break;
              }
              try
              {
                localSubscriber.onNext(localObject4);
              }
              catch (Throwable localThrowable)
              {
                Exceptions.throwOrReport(localThrowable, localSubscriber, localObject4);
                return;
              }
            }
          }
          l4 = localList.size() + 0L;
        }
        else
        {
          l4 = 0L;
        }
        long l2 = this.requested;
        long l1 = l2;
        if (l2 != 9223372036854775807L)
        {
          l1 = l2;
          if (l5 != 0L)
          {
            l2 += l5;
            l1 = l2;
            if (l2 < 0L) {
              l1 = 9223372036854775807L;
            }
          }
          l2 = l1;
          if (l4 != 0L)
          {
            l2 = l1;
            if (l1 != 9223372036854775807L)
            {
              l2 = l1 - l4;
              if (l2 < 0L) {
                throw new IllegalStateException("More produced than requested");
              }
            }
          }
          this.requested = l2;
          l1 = l2;
        }
        Object localObject2;
        if (localProducer != null)
        {
          if (localProducer == NULL_PRODUCER)
          {
            this.currentProducer = null;
            continue;
          }
          this.currentProducer = localProducer;
          if (l1 == 0L) {
            continue;
          }
          l1 = BackpressureUtils.addCap(l3, l1);
          localObject2 = localProducer;
        }
        else
        {
          localProducer = this.currentProducer;
          if ((localProducer == null) || (l5 == 0L)) {
            continue;
          }
          l1 = BackpressureUtils.addCap(l3, l5);
          localObject2 = localProducer;
        }
        l3 = l1;
      }
      finally {}
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void onCompleted()
  {
    try
    {
      if (this.emitting)
      {
        this.missedTerminal = Boolean.valueOf(true);
        return;
      }
      this.emitting = true;
      this.child.onCompleted();
      return;
    }
    finally {}
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      int i;
      if (this.emitting)
      {
        this.missedTerminal = paramThrowable;
        i = 0;
      }
      else
      {
        this.emitting = true;
        i = 1;
      }
      if (i != 0)
      {
        this.child.onError(paramThrowable);
        return;
      }
      this.hasError = true;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void onNext(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   6: ifeq +46 -> 52
    //   9: aload_0
    //   10: getfield 54	rx/internal/producers/ProducerObserverArbiter:queue	Ljava/util/List;
    //   13: astore 5
    //   15: aload 5
    //   17: astore 4
    //   19: aload 5
    //   21: ifnonnull +19 -> 40
    //   24: new 138	java/util/ArrayList
    //   27: dup
    //   28: iconst_4
    //   29: invokespecial 141	java/util/ArrayList:<init>	(I)V
    //   32: astore 4
    //   34: aload_0
    //   35: aload 4
    //   37: putfield 54	rx/internal/producers/ProducerObserverArbiter:queue	Ljava/util/List;
    //   40: aload 4
    //   42: aload_1
    //   43: invokeinterface 145 2 0
    //   48: pop
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: getfield 41	rx/internal/producers/ProducerObserverArbiter:child	Lrx/Subscriber;
    //   58: aload_1
    //   59: invokevirtual 103	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   62: aload_0
    //   63: getfield 115	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   66: lstore_2
    //   67: lload_2
    //   68: ldc2_w 116
    //   71: lcmp
    //   72: ifeq +10 -> 82
    //   75: aload_0
    //   76: lload_2
    //   77: lconst_1
    //   78: lsub
    //   79: putfield 115	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   82: aload_0
    //   83: invokevirtual 147	rx/internal/producers/ProducerObserverArbiter:emitLoop	()V
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: monitorenter
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	ProducerObserverArbiter
    //   0	109	1	paramT	T
    //   66	11	2	l	long
    //   17	24	4	localObject	Object
    //   13	7	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   54	67	87	finally
    //   75	82	87	finally
    //   82	86	87	finally
    //   90	97	99	finally
    //   100	102	99	finally
    //   2	15	104	finally
    //   24	40	104	finally
    //   40	51	104	finally
    //   52	54	104	finally
    //   105	107	104	finally
  }
  
  /* Error */
  public void request(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: iflt +118 -> 121
    //   6: lload_1
    //   7: lconst_0
    //   8: lcmp
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   19: ifeq +16 -> 35
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 48	rx/internal/producers/ProducerObserverArbiter:missedRequested	J
    //   27: lload_1
    //   28: ladd
    //   29: putfield 48	rx/internal/producers/ProducerObserverArbiter:missedRequested	J
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 126	rx/internal/producers/ProducerObserverArbiter:currentProducer	Lrx/Producer;
    //   46: astore 7
    //   48: aload_0
    //   49: getfield 115	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   52: lload_1
    //   53: ladd
    //   54: lstore 5
    //   56: lload 5
    //   58: lstore_3
    //   59: lload 5
    //   61: lconst_0
    //   62: lcmp
    //   63: ifge +7 -> 70
    //   66: ldc2_w 116
    //   69: lstore_3
    //   70: aload_0
    //   71: lload_3
    //   72: putfield 115	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   75: aload_0
    //   76: invokevirtual 147	rx/internal/producers/ProducerObserverArbiter:emitLoop	()V
    //   79: aload 7
    //   81: ifnull +11 -> 92
    //   84: aload 7
    //   86: lload_1
    //   87: invokeinterface 60 3 0
    //   92: return
    //   93: astore 7
    //   95: aload_0
    //   96: monitorenter
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   102: aload_0
    //   103: monitorexit
    //   104: aload 7
    //   106: athrow
    //   107: astore 7
    //   109: aload_0
    //   110: monitorexit
    //   111: aload 7
    //   113: athrow
    //   114: astore 7
    //   116: aload_0
    //   117: monitorexit
    //   118: aload 7
    //   120: athrow
    //   121: new 150	java/lang/IllegalArgumentException
    //   124: dup
    //   125: ldc 152
    //   127: invokespecial 153	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ProducerObserverArbiter
    //   0	131	1	paramLong	long
    //   58	14	3	l1	long
    //   54	6	5	l2	long
    //   46	39	7	localProducer	Producer
    //   93	12	7	localObject1	Object
    //   107	5	7	localObject2	Object
    //   114	5	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   48	56	93	finally
    //   70	79	93	finally
    //   97	104	107	finally
    //   109	111	107	finally
    //   15	34	114	finally
    //   35	42	114	finally
    //   116	118	114	finally
  }
  
  /* Error */
  public void setProducer(Producer paramProducer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   6: ifeq +22 -> 28
    //   9: aload_1
    //   10: ifnull +6 -> 16
    //   13: goto +7 -> 20
    //   16: getstatic 36	rx/internal/producers/ProducerObserverArbiter:NULL_PRODUCER	Lrx/Producer;
    //   19: astore_1
    //   20: aload_0
    //   21: aload_1
    //   22: putfield 50	rx/internal/producers/ProducerObserverArbiter:missedProducer	Lrx/Producer;
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: aload_1
    //   37: putfield 126	rx/internal/producers/ProducerObserverArbiter:currentProducer	Lrx/Producer;
    //   40: aload_0
    //   41: getfield 115	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   44: lstore_2
    //   45: aload_0
    //   46: invokevirtual 147	rx/internal/producers/ProducerObserverArbiter:emitLoop	()V
    //   49: aload_1
    //   50: ifnull +16 -> 66
    //   53: lload_2
    //   54: lconst_0
    //   55: lcmp
    //   56: ifeq +10 -> 66
    //   59: aload_1
    //   60: lload_2
    //   61: invokeinterface 60 3 0
    //   66: return
    //   67: astore_1
    //   68: aload_0
    //   69: monitorenter
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
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
    //   0	89	0	this	ProducerObserverArbiter
    //   0	89	1	paramProducer	Producer
    //   44	17	2	l	long
    // Exception table:
    //   from	to	target	type
    //   45	49	67	finally
    //   70	77	79	finally
    //   80	82	79	finally
    //   2	9	84	finally
    //   16	20	84	finally
    //   20	27	84	finally
    //   28	35	84	finally
    //   85	87	84	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.producers.ProducerObserverArbiter
 * JD-Core Version:    0.7.0.1
 */