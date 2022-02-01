package rx.internal.operators;

import rx.Completable;
import rx.Completable.CompletableOnSubscribe;

public final class CompletableOnSubscribeMergeDelayErrorIterable
  implements Completable.CompletableOnSubscribe
{
  final Iterable<? extends Completable> sources;
  
  public CompletableOnSubscribeMergeDelayErrorIterable(Iterable<? extends Completable> paramIterable)
  {
    this.sources = paramIterable;
  }
  
  /* Error */
  public void call(rx.Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    // Byte code:
    //   0: new 30	rx/subscriptions/CompositeSubscription
    //   3: dup
    //   4: invokespecial 31	rx/subscriptions/CompositeSubscription:<init>	()V
    //   7: astore 5
    //   9: new 33	java/util/concurrent/atomic/AtomicInteger
    //   12: dup
    //   13: iconst_1
    //   14: invokespecial 36	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   17: astore_3
    //   18: new 38	rx/internal/util/unsafe/MpscLinkedQueue
    //   21: dup
    //   22: invokespecial 39	rx/internal/util/unsafe/MpscLinkedQueue:<init>	()V
    //   25: astore 4
    //   27: aload_1
    //   28: aload 5
    //   30: invokeinterface 43 2 0
    //   35: aload_0
    //   36: getfield 16	rx/internal/operators/CompletableOnSubscribeMergeDelayErrorIterable:sources	Ljava/lang/Iterable;
    //   39: invokeinterface 49 1 0
    //   44: astore 6
    //   46: aload 6
    //   48: ifnonnull +19 -> 67
    //   51: aload_1
    //   52: new 51	java/lang/NullPointerException
    //   55: dup
    //   56: ldc 53
    //   58: invokespecial 56	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   61: invokeinterface 60 2 0
    //   66: return
    //   67: aload 5
    //   69: invokevirtual 64	rx/subscriptions/CompositeSubscription:isUnsubscribed	()Z
    //   72: ifeq +4 -> 76
    //   75: return
    //   76: aload 6
    //   78: invokeinterface 69 1 0
    //   83: istore_2
    //   84: iload_2
    //   85: ifne +39 -> 124
    //   88: aload_3
    //   89: invokevirtual 73	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   92: ifne +31 -> 123
    //   95: aload 4
    //   97: invokeinterface 78 1 0
    //   102: ifeq +10 -> 112
    //   105: aload_1
    //   106: invokeinterface 81 1 0
    //   111: return
    //   112: aload_1
    //   113: aload 4
    //   115: invokestatic 87	rx/internal/operators/CompletableOnSubscribeMerge:collectErrors	(Ljava/util/Queue;)Ljava/lang/Throwable;
    //   118: invokeinterface 60 2 0
    //   123: return
    //   124: aload 5
    //   126: invokevirtual 64	rx/subscriptions/CompositeSubscription:isUnsubscribed	()Z
    //   129: ifeq +4 -> 133
    //   132: return
    //   133: aload 6
    //   135: invokeinterface 91 1 0
    //   140: checkcast 93	rx/Completable
    //   143: astore 7
    //   145: aload 5
    //   147: invokevirtual 64	rx/subscriptions/CompositeSubscription:isUnsubscribed	()Z
    //   150: ifeq +4 -> 154
    //   153: return
    //   154: aload 7
    //   156: ifnonnull +56 -> 212
    //   159: aload 4
    //   161: new 51	java/lang/NullPointerException
    //   164: dup
    //   165: ldc 95
    //   167: invokespecial 56	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   170: invokeinterface 99 2 0
    //   175: pop
    //   176: aload_3
    //   177: invokevirtual 73	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   180: ifne +31 -> 211
    //   183: aload 4
    //   185: invokeinterface 78 1 0
    //   190: ifeq +10 -> 200
    //   193: aload_1
    //   194: invokeinterface 81 1 0
    //   199: return
    //   200: aload_1
    //   201: aload 4
    //   203: invokestatic 87	rx/internal/operators/CompletableOnSubscribeMerge:collectErrors	(Ljava/util/Queue;)Ljava/lang/Throwable;
    //   206: invokeinterface 60 2 0
    //   211: return
    //   212: aload_3
    //   213: invokevirtual 102	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   216: pop
    //   217: aload 7
    //   219: new 104	rx/internal/operators/CompletableOnSubscribeMergeDelayErrorIterable$1
    //   222: dup
    //   223: aload_0
    //   224: aload 5
    //   226: aload 4
    //   228: aload_3
    //   229: aload_1
    //   230: invokespecial 107	rx/internal/operators/CompletableOnSubscribeMergeDelayErrorIterable$1:<init>	(Lrx/internal/operators/CompletableOnSubscribeMergeDelayErrorIterable;Lrx/subscriptions/CompositeSubscription;Ljava/util/Queue;Ljava/util/concurrent/atomic/AtomicInteger;Lrx/Completable$CompletableSubscriber;)V
    //   233: invokevirtual 110	rx/Completable:subscribe	(Lrx/Completable$CompletableSubscriber;)V
    //   236: goto -169 -> 67
    //   239: astore 5
    //   241: aload 4
    //   243: aload 5
    //   245: invokeinterface 99 2 0
    //   250: pop
    //   251: aload_3
    //   252: invokevirtual 73	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   255: ifne +31 -> 286
    //   258: aload 4
    //   260: invokeinterface 78 1 0
    //   265: ifeq +10 -> 275
    //   268: aload_1
    //   269: invokeinterface 81 1 0
    //   274: return
    //   275: aload_1
    //   276: aload 4
    //   278: invokestatic 87	rx/internal/operators/CompletableOnSubscribeMerge:collectErrors	(Ljava/util/Queue;)Ljava/lang/Throwable;
    //   281: invokeinterface 60 2 0
    //   286: return
    //   287: astore 5
    //   289: aload 4
    //   291: aload 5
    //   293: invokeinterface 99 2 0
    //   298: pop
    //   299: aload_3
    //   300: invokevirtual 73	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   303: ifne +31 -> 334
    //   306: aload 4
    //   308: invokeinterface 78 1 0
    //   313: ifeq +10 -> 323
    //   316: aload_1
    //   317: invokeinterface 81 1 0
    //   322: return
    //   323: aload_1
    //   324: aload 4
    //   326: invokestatic 87	rx/internal/operators/CompletableOnSubscribeMerge:collectErrors	(Ljava/util/Queue;)Ljava/lang/Throwable;
    //   329: invokeinterface 60 2 0
    //   334: return
    //   335: astore_3
    //   336: aload_1
    //   337: aload_3
    //   338: invokeinterface 60 2 0
    //   343: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	CompletableOnSubscribeMergeDelayErrorIterable
    //   0	344	1	paramCompletableSubscriber	rx.Completable.CompletableSubscriber
    //   83	2	2	bool	boolean
    //   17	283	3	localAtomicInteger	java.util.concurrent.atomic.AtomicInteger
    //   335	3	3	localThrowable1	java.lang.Throwable
    //   25	300	4	localMpscLinkedQueue	rx.internal.util.unsafe.MpscLinkedQueue
    //   7	218	5	localCompositeSubscription	rx.subscriptions.CompositeSubscription
    //   239	5	5	localThrowable2	java.lang.Throwable
    //   287	5	5	localThrowable3	java.lang.Throwable
    //   44	90	6	localIterator	java.util.Iterator
    //   143	75	7	localCompletable	Completable
    // Exception table:
    //   from	to	target	type
    //   133	145	239	java/lang/Throwable
    //   76	84	287	java/lang/Throwable
    //   35	46	335	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable
 * JD-Core Version:    0.7.0.1
 */