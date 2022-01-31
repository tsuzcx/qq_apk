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
    long l1 = 0L;
    Object localObject1 = null;
    int i = 0;
    long l5;
    Producer localProducer;
    Object localObject4;
    List localList;
    try
    {
      l5 = this.missedRequested;
      localProducer = this.missedProducer;
      localObject4 = this.missedTerminal;
      localList = this.queue;
      if ((l5 == 0L) && (localProducer == null) && (localList == null) && (localObject4 == null))
      {
        this.emitting = false;
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break;
        }
        if ((l1 != 0L) && (localObject1 != null)) {
          localObject1.request(l1);
        }
        label93:
        return;
        this.missedRequested = 0L;
        this.missedProducer = null;
        this.queue = null;
        this.missedTerminal = null;
      }
      if (localList == null) {
        break label139;
      }
    }
    finally {}
    if (localList.isEmpty()) {
      label139:
      i = 1;
    }
    while (localObject4 != null) {
      if (localObject4 != Boolean.TRUE)
      {
        localSubscriber.onError((Throwable)localObject4);
        return;
        i = 0;
      }
      else if (i != 0)
      {
        localSubscriber.onCompleted();
        return;
      }
    }
    long l3 = 0L;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject4 = localIterator.next();
          if (localSubscriber.isUnsubscribed()) {
            break label93;
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
      l3 = 0L + localList.size();
    }
    long l4 = this.requested;
    long l2;
    if (l4 != 9223372036854775807L)
    {
      l2 = l4;
      if (l5 != 0L)
      {
        l4 += l5;
        l2 = l4;
        if (l4 < 0L) {
          l2 = 9223372036854775807L;
        }
      }
      if ((l3 != 0L) && (l2 != 9223372036854775807L))
      {
        l3 = l2 - l3;
        l2 = l3;
        if (l3 < 0L) {
          throw new IllegalStateException("More produced than requested");
        }
      }
      this.requested = l2;
    }
    for (;;)
    {
      if (localProducer != null) {
        if (localProducer == NULL_PRODUCER) {
          this.currentProducer = null;
        }
      }
      for (;;)
      {
        break;
        this.currentProducer = localProducer;
        if (l2 != 0L)
        {
          l1 = BackpressureUtils.addCap(l1, l2);
          Object localObject3 = localProducer;
          continue;
          localProducer = this.currentProducer;
          if ((localProducer != null) && (l5 != 0L))
          {
            l1 = BackpressureUtils.addCap(l1, l5);
            localObject3 = localProducer;
          }
        }
      }
      l2 = l4;
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
      if (this.emitting) {
        this.missedTerminal = paramThrowable;
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break;
        }
        this.child.onError(paramThrowable);
        return;
        this.emitting = true;
      }
      this.hasError = true;
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
    //   2	15	99	finally
    //   24	40	99	finally
    //   40	51	99	finally
    //   52	54	99	finally
    //   100	102	99	finally
    //   90	97	104	finally
    //   105	107	104	finally
  }
  
  /* Error */
  public void request(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifge +13 -> 16
    //   6: new 150	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc 152
    //   12: invokespecial 153	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: ifne +4 -> 23
    //   22: return
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   29: ifeq +23 -> 52
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 48	rx/internal/producers/ProducerObserverArbiter:missedRequested	J
    //   37: lload_1
    //   38: ladd
    //   39: putfield 48	rx/internal/producers/ProducerObserverArbiter:missedRequested	J
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore 7
    //   47: aload_0
    //   48: monitorexit
    //   49: aload 7
    //   51: athrow
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 126	rx/internal/producers/ProducerObserverArbiter:currentProducer	Lrx/Producer;
    //   63: astore 7
    //   65: aload_0
    //   66: getfield 115	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   69: lload_1
    //   70: ladd
    //   71: lstore 5
    //   73: lload 5
    //   75: lstore_3
    //   76: lload 5
    //   78: lconst_0
    //   79: lcmp
    //   80: ifge +7 -> 87
    //   83: ldc2_w 116
    //   86: lstore_3
    //   87: aload_0
    //   88: lload_3
    //   89: putfield 115	rx/internal/producers/ProducerObserverArbiter:requested	J
    //   92: aload_0
    //   93: invokevirtual 147	rx/internal/producers/ProducerObserverArbiter:emitLoop	()V
    //   96: aload 7
    //   98: ifnull -76 -> 22
    //   101: aload 7
    //   103: lload_1
    //   104: invokeinterface 60 3 0
    //   109: return
    //   110: astore 7
    //   112: aload_0
    //   113: monitorenter
    //   114: aload_0
    //   115: iconst_0
    //   116: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   119: aload_0
    //   120: monitorexit
    //   121: aload 7
    //   123: athrow
    //   124: astore 7
    //   126: aload_0
    //   127: monitorexit
    //   128: aload 7
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ProducerObserverArbiter
    //   0	131	1	paramLong	long
    //   75	14	3	l1	long
    //   71	6	5	l2	long
    //   45	5	7	localObject1	Object
    //   63	39	7	localProducer	Producer
    //   110	12	7	localObject2	Object
    //   124	5	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	44	45	finally
    //   47	49	45	finally
    //   52	59	45	finally
    //   65	73	110	finally
    //   87	96	110	finally
    //   114	121	124	finally
    //   126	128	124	finally
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
    //   10: ifnull +11 -> 21
    //   13: aload_0
    //   14: aload_1
    //   15: putfield 50	rx/internal/producers/ProducerObserverArbiter:missedProducer	Lrx/Producer;
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: getstatic 36	rx/internal/producers/ProducerObserverArbiter:NULL_PRODUCER	Lrx/Producer;
    //   24: astore_1
    //   25: goto -12 -> 13
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
    //   50: ifnull +39 -> 89
    //   53: lload_2
    //   54: lconst_0
    //   55: lcmp
    //   56: ifeq +33 -> 89
    //   59: aload_1
    //   60: lload_2
    //   61: invokeinterface 60 3 0
    //   66: return
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: aload_0
    //   74: monitorenter
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 56	rx/internal/producers/ProducerObserverArbiter:emitting	Z
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    //   89: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ProducerObserverArbiter
    //   0	90	1	paramProducer	Producer
    //   44	17	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	9	67	finally
    //   13	20	67	finally
    //   21	25	67	finally
    //   28	35	67	finally
    //   68	70	67	finally
    //   45	49	72	finally
    //   75	82	84	finally
    //   85	87	84	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.producers.ProducerObserverArbiter
 * JD-Core Version:    0.7.0.1
 */