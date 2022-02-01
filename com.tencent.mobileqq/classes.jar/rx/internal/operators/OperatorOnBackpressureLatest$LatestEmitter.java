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
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   6: istore_3
    //   7: iconst_1
    //   8: istore_2
    //   9: iload_3
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
    //   37: lstore 4
    //   39: lload 4
    //   41: ldc2_w 72
    //   44: lcmp
    //   45: ifne +4 -> 49
    //   48: return
    //   49: aload_0
    //   50: getfield 56	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:value	Ljava/util/concurrent/atomic/AtomicReference;
    //   53: invokevirtual 76	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   56: astore 7
    //   58: aload 7
    //   60: astore 6
    //   62: lload 4
    //   64: lconst_0
    //   65: lcmp
    //   66: ifle +48 -> 114
    //   69: aload 7
    //   71: astore 6
    //   73: aload 7
    //   75: getstatic 44	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   78: if_acmpeq +36 -> 114
    //   81: aload_0
    //   82: getfield 49	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:child	Lrx/Subscriber;
    //   85: aload 7
    //   87: invokevirtual 81	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   90: aload_0
    //   91: getfield 56	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:value	Ljava/util/concurrent/atomic/AtomicReference;
    //   94: aload 7
    //   96: getstatic 44	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   99: invokevirtual 85	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   102: pop
    //   103: aload_0
    //   104: lconst_1
    //   105: invokevirtual 89	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:produced	(J)J
    //   108: pop2
    //   109: getstatic 44	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   112: astore 6
    //   114: aload 6
    //   116: getstatic 44	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:EMPTY	Ljava/lang/Object;
    //   119: if_acmpne +40 -> 159
    //   122: aload_0
    //   123: getfield 91	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:done	Z
    //   126: ifeq +33 -> 159
    //   129: aload_0
    //   130: getfield 93	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:terminal	Ljava/lang/Throwable;
    //   133: astore 6
    //   135: aload 6
    //   137: ifnull +15 -> 152
    //   140: aload_0
    //   141: getfield 49	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:child	Lrx/Subscriber;
    //   144: aload 6
    //   146: invokevirtual 97	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   149: goto +10 -> 159
    //   152: aload_0
    //   153: getfield 49	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:child	Lrx/Subscriber;
    //   156: invokevirtual 100	rx/Subscriber:onCompleted	()V
    //   159: aload_0
    //   160: monitorenter
    //   161: aload_0
    //   162: getfield 67	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:missed	Z
    //   165: ifne +11 -> 176
    //   168: aload_0
    //   169: iconst_0
    //   170: putfield 65	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   173: aload_0
    //   174: monitorexit
    //   175: return
    //   176: aload_0
    //   177: iconst_0
    //   178: putfield 67	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:missed	Z
    //   181: aload_0
    //   182: monitorexit
    //   183: goto -150 -> 33
    //   186: astore 6
    //   188: iconst_0
    //   189: istore_1
    //   190: iload_1
    //   191: istore_2
    //   192: aload_0
    //   193: monitorexit
    //   194: aload 6
    //   196: athrow
    //   197: astore 6
    //   199: goto +14 -> 213
    //   202: astore 6
    //   204: iload_2
    //   205: istore_1
    //   206: goto -16 -> 190
    //   209: astore 6
    //   211: iconst_0
    //   212: istore_1
    //   213: iload_1
    //   214: ifne +22 -> 236
    //   217: aload_0
    //   218: monitorenter
    //   219: aload_0
    //   220: iconst_0
    //   221: putfield 65	rx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter:emitting	Z
    //   224: aload_0
    //   225: monitorexit
    //   226: goto +10 -> 236
    //   229: astore 6
    //   231: aload_0
    //   232: monitorexit
    //   233: aload 6
    //   235: athrow
    //   236: aload 6
    //   238: athrow
    //   239: astore 6
    //   241: aload_0
    //   242: monitorexit
    //   243: goto +6 -> 249
    //   246: aload 6
    //   248: athrow
    //   249: goto -3 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	LatestEmitter
    //   189	25	1	i	int
    //   8	197	2	j	int
    //   6	4	3	bool	boolean
    //   37	26	4	l	long
    //   60	85	6	localObject1	Object
    //   186	9	6	localObject2	Object
    //   197	1	6	localObject3	Object
    //   202	1	6	localObject4	Object
    //   209	1	6	localObject5	Object
    //   229	8	6	localObject6	Object
    //   239	8	6	localObject7	Object
    //   56	39	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   161	173	186	finally
    //   176	183	186	finally
    //   194	197	197	finally
    //   173	175	202	finally
    //   192	194	202	finally
    //   33	39	209	finally
    //   49	58	209	finally
    //   73	114	209	finally
    //   114	135	209	finally
    //   140	149	209	finally
    //   152	159	209	finally
    //   159	161	209	finally
    //   219	226	229	finally
    //   231	233	229	finally
    //   2	7	239	finally
    //   13	20	239	finally
    //   21	33	239	finally
    //   241	243	239	finally
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
    if (paramLong >= 0L)
    {
      long l3;
      long l1;
      do
      {
        l3 = get();
        if (l3 == -9223372036854775808L) {
          return;
        }
        if (l3 == -4611686018427387904L)
        {
          l1 = paramLong;
        }
        else
        {
          long l2 = l3 + paramLong;
          l1 = l2;
          if (l2 < 0L) {
            l1 = 9223372036854775807L;
          }
        }
      } while (!compareAndSet(l3, l1));
      if (l3 == -4611686018427387904L) {
        this.parent.requestMore(9223372036854775807L);
      }
      emit();
    }
  }
  
  public void unsubscribe()
  {
    if (get() >= 0L) {
      getAndSet(-9223372036854775808L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter
 * JD-Core Version:    0.7.0.1
 */