package rx.internal.operators;

import rx.Completable;
import rx.Completable.CompletableOnSubscribe;

public final class CompletableOnSubscribeMergeIterable
  implements Completable.CompletableOnSubscribe
{
  final Iterable<? extends Completable> sources;
  
  public CompletableOnSubscribeMergeIterable(Iterable<? extends Completable> paramIterable)
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
    //   7: astore 4
    //   9: new 33	java/util/concurrent/atomic/AtomicInteger
    //   12: dup
    //   13: iconst_1
    //   14: invokespecial 36	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   17: astore 5
    //   19: new 38	java/util/concurrent/atomic/AtomicBoolean
    //   22: dup
    //   23: invokespecial 39	java/util/concurrent/atomic/AtomicBoolean:<init>	()V
    //   26: astore_3
    //   27: aload_1
    //   28: aload 4
    //   30: invokeinterface 43 2 0
    //   35: aload_0
    //   36: getfield 16	rx/internal/operators/CompletableOnSubscribeMergeIterable:sources	Ljava/lang/Iterable;
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
    //   67: aload 4
    //   69: invokevirtual 64	rx/subscriptions/CompositeSubscription:isUnsubscribed	()Z
    //   72: ifeq +4 -> 76
    //   75: return
    //   76: aload 6
    //   78: invokeinterface 69 1 0
    //   83: istore_2
    //   84: iload_2
    //   85: ifne +27 -> 112
    //   88: aload 5
    //   90: invokevirtual 73	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   93: ifne +18 -> 111
    //   96: aload_3
    //   97: iconst_0
    //   98: iconst_1
    //   99: invokevirtual 77	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   102: ifeq +9 -> 111
    //   105: aload_1
    //   106: invokeinterface 80 1 0
    //   111: return
    //   112: aload 4
    //   114: invokevirtual 64	rx/subscriptions/CompositeSubscription:isUnsubscribed	()Z
    //   117: ifeq +4 -> 121
    //   120: return
    //   121: aload 6
    //   123: invokeinterface 84 1 0
    //   128: checkcast 86	rx/Completable
    //   131: astore 7
    //   133: aload 4
    //   135: invokevirtual 64	rx/subscriptions/CompositeSubscription:isUnsubscribed	()Z
    //   138: ifeq +4 -> 142
    //   141: return
    //   142: aload 7
    //   144: ifnonnull +49 -> 193
    //   147: aload 4
    //   149: invokevirtual 89	rx/subscriptions/CompositeSubscription:unsubscribe	()V
    //   152: new 51	java/lang/NullPointerException
    //   155: dup
    //   156: ldc 91
    //   158: invokespecial 56	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   161: astore 4
    //   163: aload_3
    //   164: iconst_0
    //   165: iconst_1
    //   166: invokevirtual 77	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   169: ifeq +12 -> 181
    //   172: aload_1
    //   173: aload 4
    //   175: invokeinterface 60 2 0
    //   180: return
    //   181: invokestatic 97	rx/plugins/RxJavaPlugins:getInstance	()Lrx/plugins/RxJavaPlugins;
    //   184: invokevirtual 101	rx/plugins/RxJavaPlugins:getErrorHandler	()Lrx/plugins/RxJavaErrorHandler;
    //   187: aload 4
    //   189: invokevirtual 106	rx/plugins/RxJavaErrorHandler:handleError	(Ljava/lang/Throwable;)V
    //   192: return
    //   193: aload 5
    //   195: invokevirtual 109	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   198: pop
    //   199: aload 7
    //   201: new 111	rx/internal/operators/CompletableOnSubscribeMergeIterable$1
    //   204: dup
    //   205: aload_0
    //   206: aload 4
    //   208: aload_3
    //   209: aload_1
    //   210: aload 5
    //   212: invokespecial 114	rx/internal/operators/CompletableOnSubscribeMergeIterable$1:<init>	(Lrx/internal/operators/CompletableOnSubscribeMergeIterable;Lrx/subscriptions/CompositeSubscription;Ljava/util/concurrent/atomic/AtomicBoolean;Lrx/Completable$CompletableSubscriber;Ljava/util/concurrent/atomic/AtomicInteger;)V
    //   215: invokevirtual 117	rx/Completable:subscribe	(Lrx/Completable$CompletableSubscriber;)V
    //   218: goto -151 -> 67
    //   221: astore 5
    //   223: aload 4
    //   225: invokevirtual 89	rx/subscriptions/CompositeSubscription:unsubscribe	()V
    //   228: aload_3
    //   229: iconst_0
    //   230: iconst_1
    //   231: invokevirtual 77	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   234: ifeq +12 -> 246
    //   237: aload_1
    //   238: aload 5
    //   240: invokeinterface 60 2 0
    //   245: return
    //   246: invokestatic 97	rx/plugins/RxJavaPlugins:getInstance	()Lrx/plugins/RxJavaPlugins;
    //   249: invokevirtual 101	rx/plugins/RxJavaPlugins:getErrorHandler	()Lrx/plugins/RxJavaErrorHandler;
    //   252: aload 5
    //   254: invokevirtual 106	rx/plugins/RxJavaErrorHandler:handleError	(Ljava/lang/Throwable;)V
    //   257: return
    //   258: astore 5
    //   260: aload 4
    //   262: invokevirtual 89	rx/subscriptions/CompositeSubscription:unsubscribe	()V
    //   265: aload_3
    //   266: iconst_0
    //   267: iconst_1
    //   268: invokevirtual 77	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   271: ifeq +12 -> 283
    //   274: aload_1
    //   275: aload 5
    //   277: invokeinterface 60 2 0
    //   282: return
    //   283: invokestatic 97	rx/plugins/RxJavaPlugins:getInstance	()Lrx/plugins/RxJavaPlugins;
    //   286: invokevirtual 101	rx/plugins/RxJavaPlugins:getErrorHandler	()Lrx/plugins/RxJavaErrorHandler;
    //   289: aload 5
    //   291: invokevirtual 106	rx/plugins/RxJavaErrorHandler:handleError	(Ljava/lang/Throwable;)V
    //   294: return
    //   295: astore_3
    //   296: aload_1
    //   297: aload_3
    //   298: invokeinterface 60 2 0
    //   303: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	CompletableOnSubscribeMergeIterable
    //   0	304	1	paramCompletableSubscriber	rx.Completable.CompletableSubscriber
    //   83	2	2	bool	boolean
    //   26	240	3	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    //   295	3	3	localThrowable1	java.lang.Throwable
    //   7	254	4	localObject	Object
    //   17	194	5	localAtomicInteger	java.util.concurrent.atomic.AtomicInteger
    //   221	32	5	localThrowable2	java.lang.Throwable
    //   258	32	5	localThrowable3	java.lang.Throwable
    //   44	78	6	localIterator	java.util.Iterator
    //   131	69	7	localCompletable	Completable
    // Exception table:
    //   from	to	target	type
    //   121	133	221	java/lang/Throwable
    //   76	84	258	java/lang/Throwable
    //   35	46	295	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeMergeIterable
 * JD-Core Version:    0.7.0.1
 */