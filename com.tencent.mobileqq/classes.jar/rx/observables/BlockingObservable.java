package rx.observables;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.annotations.Experimental;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func1;
import rx.internal.operators.BlockingOperatorLatest;
import rx.internal.operators.BlockingOperatorMostRecent;
import rx.internal.operators.BlockingOperatorNext;
import rx.internal.operators.BlockingOperatorToFuture;
import rx.internal.operators.BlockingOperatorToIterator;
import rx.internal.util.BlockingUtils;
import rx.internal.util.UtilityFunctions;

public final class BlockingObservable<T>
{
  static final Object ON_START = new Object();
  static final Object SET_PRODUCER = new Object();
  static final Object UNSUBSCRIBE = new Object();
  private final Observable<? extends T> o;
  
  private BlockingObservable(Observable<? extends T> paramObservable)
  {
    this.o = paramObservable;
  }
  
  private T blockForSingle(Observable<? extends T> paramObservable)
  {
    AtomicReference localAtomicReference1 = new AtomicReference();
    AtomicReference localAtomicReference2 = new AtomicReference();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    BlockingUtils.awaitForComplete(localCountDownLatch, paramObservable.subscribe(new BlockingObservable.3(this, localCountDownLatch, localAtomicReference2, localAtomicReference1)));
    if (localAtomicReference2.get() != null)
    {
      if ((localAtomicReference2.get() instanceof RuntimeException)) {
        throw ((RuntimeException)localAtomicReference2.get());
      }
      throw new RuntimeException((Throwable)localAtomicReference2.get());
    }
    return localAtomicReference1.get();
  }
  
  public static <T> BlockingObservable<T> from(Observable<? extends T> paramObservable)
  {
    return new BlockingObservable(paramObservable);
  }
  
  public T first()
  {
    return blockForSingle(this.o.first());
  }
  
  public T first(Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.first(paramFunc1));
  }
  
  public T firstOrDefault(T paramT)
  {
    return blockForSingle(this.o.map(UtilityFunctions.identity()).firstOrDefault(paramT));
  }
  
  public T firstOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.filter(paramFunc1).map(UtilityFunctions.identity()).firstOrDefault(paramT));
  }
  
  public void forEach(Action1<? super T> paramAction1)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    AtomicReference localAtomicReference = new AtomicReference();
    BlockingUtils.awaitForComplete(localCountDownLatch, this.o.subscribe(new BlockingObservable.1(this, localCountDownLatch, localAtomicReference, paramAction1)));
    if (localAtomicReference.get() != null)
    {
      if ((localAtomicReference.get() instanceof RuntimeException)) {
        throw ((RuntimeException)localAtomicReference.get());
      }
      throw new RuntimeException((Throwable)localAtomicReference.get());
    }
  }
  
  public Iterator<T> getIterator()
  {
    return BlockingOperatorToIterator.toIterator(this.o);
  }
  
  public T last()
  {
    return blockForSingle(this.o.last());
  }
  
  public T last(Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.last(paramFunc1));
  }
  
  public T lastOrDefault(T paramT)
  {
    return blockForSingle(this.o.map(UtilityFunctions.identity()).lastOrDefault(paramT));
  }
  
  public T lastOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.filter(paramFunc1).map(UtilityFunctions.identity()).lastOrDefault(paramT));
  }
  
  public Iterable<T> latest()
  {
    return BlockingOperatorLatest.latest(this.o);
  }
  
  public Iterable<T> mostRecent(T paramT)
  {
    return BlockingOperatorMostRecent.mostRecent(this.o, paramT);
  }
  
  public Iterable<T> next()
  {
    return BlockingOperatorNext.next(this.o);
  }
  
  public T single()
  {
    return blockForSingle(this.o.single());
  }
  
  public T single(Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.single(paramFunc1));
  }
  
  public T singleOrDefault(T paramT)
  {
    return blockForSingle(this.o.map(UtilityFunctions.identity()).singleOrDefault(paramT));
  }
  
  public T singleOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.filter(paramFunc1).map(UtilityFunctions.identity()).singleOrDefault(paramT));
  }
  
  @Experimental
  public void subscribe()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Throwable[] arrayOfThrowable = new Throwable[1];
    arrayOfThrowable[0] = null;
    BlockingUtils.awaitForComplete(localCountDownLatch, this.o.subscribe(new BlockingObservable.4(this, arrayOfThrowable, localCountDownLatch)));
    localCountDownLatch = arrayOfThrowable[0];
    if (localCountDownLatch != null)
    {
      if ((localCountDownLatch instanceof RuntimeException)) {
        throw ((RuntimeException)localCountDownLatch);
      }
      throw new RuntimeException(localCountDownLatch);
    }
  }
  
  /* Error */
  @Experimental
  public void subscribe(rx.Observer<? super T> paramObserver)
  {
    // Byte code:
    //   0: invokestatic 175	rx/internal/operators/NotificationLite:instance	()Lrx/internal/operators/NotificationLite;
    //   3: astore 6
    //   5: new 177	java/util/concurrent/LinkedBlockingQueue
    //   8: dup
    //   9: invokespecial 178	java/util/concurrent/LinkedBlockingQueue:<init>	()V
    //   12: astore 7
    //   14: aload_0
    //   15: getfield 27	rx/observables/BlockingObservable:o	Lrx/Observable;
    //   18: new 180	rx/observables/BlockingObservable$5
    //   21: dup
    //   22: aload_0
    //   23: aload 7
    //   25: aload 6
    //   27: invokespecial 183	rx/observables/BlockingObservable$5:<init>	(Lrx/observables/BlockingObservable;Ljava/util/concurrent/BlockingQueue;Lrx/internal/operators/NotificationLite;)V
    //   30: invokevirtual 50	rx/Observable:subscribe	(Lrx/Subscriber;)Lrx/Subscription;
    //   33: astore 5
    //   35: aload 7
    //   37: invokeinterface 188 1 0
    //   42: astore 4
    //   44: aload 4
    //   46: astore_3
    //   47: aload 4
    //   49: ifnonnull +11 -> 60
    //   52: aload 7
    //   54: invokeinterface 191 1 0
    //   59: astore_3
    //   60: aload 6
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 195	rx/internal/operators/NotificationLite:accept	(Lrx/Observer;Ljava/lang/Object;)Z
    //   67: istore_2
    //   68: iload_2
    //   69: ifeq -34 -> 35
    //   72: aload 5
    //   74: invokeinterface 200 1 0
    //   79: return
    //   80: astore_1
    //   81: goto +25 -> 106
    //   84: astore_3
    //   85: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   88: invokevirtual 209	java/lang/Thread:interrupt	()V
    //   91: aload_1
    //   92: aload_3
    //   93: invokeinterface 214 2 0
    //   98: aload 5
    //   100: invokeinterface 200 1 0
    //   105: return
    //   106: aload 5
    //   108: invokeinterface 200 1 0
    //   113: goto +5 -> 118
    //   116: aload_1
    //   117: athrow
    //   118: goto -2 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	BlockingObservable
    //   0	121	1	paramObserver	rx.Observer<? super T>
    //   67	2	2	bool	boolean
    //   46	18	3	localObject1	Object
    //   84	9	3	localInterruptedException	java.lang.InterruptedException
    //   42	6	4	localObject2	Object
    //   33	74	5	localSubscription	rx.Subscription
    //   3	58	6	localNotificationLite	rx.internal.operators.NotificationLite
    //   12	41	7	localLinkedBlockingQueue	java.util.concurrent.LinkedBlockingQueue
    // Exception table:
    //   from	to	target	type
    //   35	44	80	finally
    //   52	60	80	finally
    //   60	68	80	finally
    //   85	98	80	finally
    //   35	44	84	java/lang/InterruptedException
    //   52	60	84	java/lang/InterruptedException
    //   60	68	84	java/lang/InterruptedException
  }
  
  /* Error */
  @Experimental
  public void subscribe(rx.Subscriber<? super T> paramSubscriber)
  {
    // Byte code:
    //   0: invokestatic 175	rx/internal/operators/NotificationLite:instance	()Lrx/internal/operators/NotificationLite;
    //   3: astore 6
    //   5: new 177	java/util/concurrent/LinkedBlockingQueue
    //   8: dup
    //   9: invokespecial 178	java/util/concurrent/LinkedBlockingQueue:<init>	()V
    //   12: astore 7
    //   14: iconst_1
    //   15: anewarray 218	rx/Producer
    //   18: astore 8
    //   20: aload 8
    //   22: iconst_0
    //   23: aconst_null
    //   24: aastore
    //   25: new 220	rx/observables/BlockingObservable$6
    //   28: dup
    //   29: aload_0
    //   30: aload 7
    //   32: aload 6
    //   34: aload 8
    //   36: invokespecial 223	rx/observables/BlockingObservable$6:<init>	(Lrx/observables/BlockingObservable;Ljava/util/concurrent/BlockingQueue;Lrx/internal/operators/NotificationLite;[Lrx/Producer;)V
    //   39: astore 5
    //   41: aload_1
    //   42: aload 5
    //   44: invokevirtual 229	rx/Subscriber:add	(Lrx/Subscription;)V
    //   47: aload_1
    //   48: new 231	rx/observables/BlockingObservable$7
    //   51: dup
    //   52: aload_0
    //   53: aload 7
    //   55: invokespecial 234	rx/observables/BlockingObservable$7:<init>	(Lrx/observables/BlockingObservable;Ljava/util/concurrent/BlockingQueue;)V
    //   58: invokestatic 240	rx/subscriptions/Subscriptions:create	(Lrx/functions/Action0;)Lrx/Subscription;
    //   61: invokevirtual 229	rx/Subscriber:add	(Lrx/Subscription;)V
    //   64: aload_0
    //   65: getfield 27	rx/observables/BlockingObservable:o	Lrx/Observable;
    //   68: aload 5
    //   70: invokevirtual 50	rx/Observable:subscribe	(Lrx/Subscriber;)Lrx/Subscription;
    //   73: pop
    //   74: aload_1
    //   75: invokevirtual 244	rx/Subscriber:isUnsubscribed	()Z
    //   78: ifeq +6 -> 84
    //   81: goto +95 -> 176
    //   84: aload 7
    //   86: invokeinterface 188 1 0
    //   91: astore 4
    //   93: aload 4
    //   95: astore_3
    //   96: aload 4
    //   98: ifnonnull +11 -> 109
    //   101: aload 7
    //   103: invokeinterface 191 1 0
    //   108: astore_3
    //   109: aload_1
    //   110: invokevirtual 244	rx/Subscriber:isUnsubscribed	()Z
    //   113: ifne +63 -> 176
    //   116: aload_3
    //   117: getstatic 23	rx/observables/BlockingObservable:UNSUBSCRIBE	Ljava/lang/Object;
    //   120: if_acmpne +6 -> 126
    //   123: goto +53 -> 176
    //   126: aload_3
    //   127: getstatic 19	rx/observables/BlockingObservable:ON_START	Ljava/lang/Object;
    //   130: if_acmpne +10 -> 140
    //   133: aload_1
    //   134: invokevirtual 247	rx/Subscriber:onStart	()V
    //   137: goto -63 -> 74
    //   140: aload_3
    //   141: getstatic 21	rx/observables/BlockingObservable:SET_PRODUCER	Ljava/lang/Object;
    //   144: if_acmpne +14 -> 158
    //   147: aload_1
    //   148: aload 8
    //   150: iconst_0
    //   151: aaload
    //   152: invokevirtual 251	rx/Subscriber:setProducer	(Lrx/Producer;)V
    //   155: goto -81 -> 74
    //   158: aload 6
    //   160: aload_1
    //   161: aload_3
    //   162: invokevirtual 195	rx/internal/operators/NotificationLite:accept	(Lrx/Observer;Ljava/lang/Object;)Z
    //   165: istore_2
    //   166: iload_2
    //   167: ifeq -93 -> 74
    //   170: aload 5
    //   172: invokevirtual 252	rx/Subscriber:unsubscribe	()V
    //   175: return
    //   176: aload 5
    //   178: invokevirtual 252	rx/Subscriber:unsubscribe	()V
    //   181: return
    //   182: astore_1
    //   183: goto +18 -> 201
    //   186: astore_3
    //   187: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   190: invokevirtual 209	java/lang/Thread:interrupt	()V
    //   193: aload_1
    //   194: aload_3
    //   195: invokevirtual 253	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   198: goto -22 -> 176
    //   201: aload 5
    //   203: invokevirtual 252	rx/Subscriber:unsubscribe	()V
    //   206: goto +5 -> 211
    //   209: aload_1
    //   210: athrow
    //   211: goto -2 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	BlockingObservable
    //   0	214	1	paramSubscriber	rx.Subscriber<? super T>
    //   165	2	2	bool	boolean
    //   95	67	3	localObject1	Object
    //   186	9	3	localInterruptedException	java.lang.InterruptedException
    //   91	6	4	localObject2	Object
    //   39	163	5	local6	BlockingObservable.6
    //   3	156	6	localNotificationLite	rx.internal.operators.NotificationLite
    //   12	90	7	localLinkedBlockingQueue	java.util.concurrent.LinkedBlockingQueue
    //   18	131	8	arrayOfProducer	rx.Producer[]
    // Exception table:
    //   from	to	target	type
    //   74	81	182	finally
    //   84	93	182	finally
    //   101	109	182	finally
    //   109	123	182	finally
    //   126	137	182	finally
    //   140	155	182	finally
    //   158	166	182	finally
    //   187	198	182	finally
    //   74	81	186	java/lang/InterruptedException
    //   84	93	186	java/lang/InterruptedException
    //   101	109	186	java/lang/InterruptedException
    //   109	123	186	java/lang/InterruptedException
    //   126	137	186	java/lang/InterruptedException
    //   140	155	186	java/lang/InterruptedException
    //   158	166	186	java/lang/InterruptedException
  }
  
  @Experimental
  public void subscribe(Action1<? super T> paramAction1)
  {
    subscribe(paramAction1, new BlockingObservable.8(this), Actions.empty());
  }
  
  @Experimental
  public void subscribe(Action1<? super T> paramAction1, Action1<? super Throwable> paramAction11)
  {
    subscribe(paramAction1, paramAction11, Actions.empty());
  }
  
  @Experimental
  public void subscribe(Action1<? super T> paramAction1, Action1<? super Throwable> paramAction11, Action0 paramAction0)
  {
    subscribe(new BlockingObservable.9(this, paramAction1, paramAction11, paramAction0));
  }
  
  public Future<T> toFuture()
  {
    return BlockingOperatorToFuture.toFuture(this.o);
  }
  
  public Iterable<T> toIterable()
  {
    return new BlockingObservable.2(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.observables.BlockingObservable
 * JD-Core Version:    0.7.0.1
 */