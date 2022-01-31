package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

final class OperatorOnBackpressureLatest$LatestEmitter<T>
  extends AtomicLong
  implements Observer<T>, Producer, Subscription
{
  static final Object EMPTY = new Object();
  static final long NOT_REQUESTED = -4611686018427387904L;
  private static final long serialVersionUID = -1364393685005146274L;
  final Subscriber<? super T> child;
  volatile boolean done;
  boolean emitting;
  boolean missed;
  OperatorOnBackpressureLatest.LatestSubscriber<? super T> parent;
  Throwable terminal;
  final AtomicReference<Object> value;
  
  public OperatorOnBackpressureLatest$LatestEmitter(Subscriber<? super T> paramSubscriber)
  {
    this.child = paramSubscriber;
    this.value = new AtomicReference(EMPTY);
    lazySet(-4611686018427387904L);
  }
  
  /* Error */
  void emit()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 65	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   10: ifeq +11 -> 21
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield 67	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:missed	Z
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 65	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 67	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:missed	Z
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: invokevirtual 71	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:get	()J
    //   37: lstore_3
    //   38: lload_3
    //   39: ldc2_w 72
    //   42: lcmp
    //   43: ifne +31 -> 74
    //   46: iconst_1
    //   47: ifne +209 -> 256
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 65	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore 5
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 5
    //   66: athrow
    //   67: astore 5
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 5
    //   73: athrow
    //   74: aload_0
    //   75: getfield 56	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:value	Ljava/util/concurrent/atomic/AtomicReference;
    //   78: invokevirtual 76	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   81: astore 6
    //   83: aload 6
    //   85: astore 5
    //   87: lload_3
    //   88: lconst_0
    //   89: lcmp
    //   90: ifle +48 -> 138
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: getstatic 44	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   102: if_acmpeq +36 -> 138
    //   105: aload_0
    //   106: getfield 49	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:child	Lrx/Subscriber;
    //   109: aload 6
    //   111: invokevirtual 81	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   114: aload_0
    //   115: getfield 56	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:value	Ljava/util/concurrent/atomic/AtomicReference;
    //   118: aload 6
    //   120: getstatic 44	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   123: invokevirtual 85	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   126: pop
    //   127: aload_0
    //   128: lconst_1
    //   129: invokevirtual 89	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:produced	(J)J
    //   132: pop2
    //   133: getstatic 44	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   136: astore 5
    //   138: aload 5
    //   140: getstatic 44	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   143: if_acmpne +30 -> 173
    //   146: aload_0
    //   147: getfield 91	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:done	Z
    //   150: ifeq +23 -> 173
    //   153: aload_0
    //   154: getfield 93	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:terminal	Ljava/lang/Throwable;
    //   157: astore 5
    //   159: aload 5
    //   161: ifnull +56 -> 217
    //   164: aload_0
    //   165: getfield 49	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:child	Lrx/Subscriber;
    //   168: aload 5
    //   170: invokevirtual 97	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   173: aload_0
    //   174: monitorenter
    //   175: aload_0
    //   176: getfield 67	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:missed	Z
    //   179: ifne +53 -> 232
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 65	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   187: aload_0
    //   188: monitorexit
    //   189: goto -143 -> 46
    //   192: iload_1
    //   193: istore_2
    //   194: aload_0
    //   195: monitorexit
    //   196: aload 5
    //   198: athrow
    //   199: astore 5
    //   201: iload_1
    //   202: ifne +12 -> 214
    //   205: aload_0
    //   206: monitorenter
    //   207: aload_0
    //   208: iconst_0
    //   209: putfield 65	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   212: aload_0
    //   213: monitorexit
    //   214: aload 5
    //   216: athrow
    //   217: aload_0
    //   218: getfield 49	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:child	Lrx/Subscriber;
    //   221: invokevirtual 100	rx/Subscriber:onCompleted	()V
    //   224: goto -51 -> 173
    //   227: astore 5
    //   229: goto -28 -> 201
    //   232: aload_0
    //   233: iconst_0
    //   234: putfield 67	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:missed	Z
    //   237: aload_0
    //   238: monitorexit
    //   239: goto -206 -> 33
    //   242: astore 5
    //   244: iconst_0
    //   245: istore_1
    //   246: goto -54 -> 192
    //   249: astore 5
    //   251: aload_0
    //   252: monitorexit
    //   253: aload 5
    //   255: athrow
    //   256: return
    //   257: astore 5
    //   259: iload_2
    //   260: istore_1
    //   261: goto -69 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	LatestEmitter
    //   3	258	1	i	int
    //   1	259	2	j	int
    //   37	51	3	l	long
    //   60	5	5	localObject1	Object
    //   67	5	5	localObject2	Object
    //   85	112	5	localObject3	Object
    //   199	16	5	localObject4	Object
    //   227	1	5	localObject5	Object
    //   242	1	5	localObject6	Object
    //   249	5	5	localObject7	Object
    //   257	1	5	localObject8	Object
    //   81	38	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   52	59	60	finally
    //   62	64	60	finally
    //   6	20	67	finally
    //   21	33	67	finally
    //   69	71	67	finally
    //   196	199	199	finally
    //   33	38	227	finally
    //   74	83	227	finally
    //   97	138	227	finally
    //   138	159	227	finally
    //   164	173	227	finally
    //   173	175	227	finally
    //   217	224	227	finally
    //   175	187	242	finally
    //   232	239	242	finally
    //   207	214	249	finally
    //   251	253	249	finally
    //   187	189	257	finally
    //   194	196	257	finally
  }
  
  public boolean isUnsubscribed()
  {
    return get() == -9223372036854775808L;
  }
  
  public void onCompleted()
  {
    this.done = true;
    emit();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.terminal = paramThrowable;
    this.done = true;
    emit();
  }
  
  public void onNext(T paramT)
  {
    this.value.lazySet(paramT);
    emit();
  }
  
  long produced(long paramLong)
  {
    long l1;
    long l2;
    do
    {
      l1 = get();
      if (l1 < 0L) {
        return l1;
      }
      l2 = l1 - paramLong;
    } while (!compareAndSet(l1, l2));
    return l2;
  }
  
  public void request(long paramLong)
  {
    if (paramLong >= 0L) {}
    for (;;)
    {
      long l3 = get();
      if (l3 == -9223372036854775808L) {
        return;
      }
      long l1;
      if (l3 == -4611686018427387904L) {
        l1 = paramLong;
      }
      while (compareAndSet(l3, l1))
      {
        if (l3 == -4611686018427387904L) {
          this.parent.requestMore(9223372036854775807L);
        }
        emit();
        return;
        long l2 = l3 + paramLong;
        l1 = l2;
        if (l2 < 0L) {
          l1 = 9223372036854775807L;
        }
      }
    }
  }
  
  public void unsubscribe()
  {
    if (get() >= 0L) {
      getAndSet(-9223372036854775808L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter
 * JD-Core Version:    0.7.0.1
 */