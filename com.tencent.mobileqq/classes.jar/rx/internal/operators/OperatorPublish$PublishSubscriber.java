package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.SynchronizedQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.Subscriptions;

final class OperatorPublish$PublishSubscriber<T>
  extends Subscriber<T>
  implements Subscription
{
  static final OperatorPublish.InnerProducer[] EMPTY = new OperatorPublish.InnerProducer[0];
  static final OperatorPublish.InnerProducer[] TERMINATED = new OperatorPublish.InnerProducer[0];
  final AtomicReference<PublishSubscriber<T>> current;
  boolean emitting;
  boolean missed;
  final NotificationLite<T> nl;
  final AtomicReference<OperatorPublish.InnerProducer[]> producers;
  final Queue<Object> queue;
  final AtomicBoolean shouldConnect;
  volatile Object terminalEvent;
  
  public OperatorPublish$PublishSubscriber(AtomicReference<PublishSubscriber<T>> paramAtomicReference)
  {
    Object localObject;
    if (UnsafeAccess.isUnsafeAvailable()) {
      localObject = new SpscArrayQueue(RxRingBuffer.SIZE);
    } else {
      localObject = new SynchronizedQueue(RxRingBuffer.SIZE);
    }
    this.queue = ((Queue)localObject);
    this.nl = NotificationLite.instance();
    this.producers = new AtomicReference(EMPTY);
    this.current = paramAtomicReference;
    this.shouldConnect = new AtomicBoolean();
  }
  
  boolean add(OperatorPublish.InnerProducer<T> paramInnerProducer)
  {
    if (paramInnerProducer != null)
    {
      OperatorPublish.InnerProducer[] arrayOfInnerProducer1;
      OperatorPublish.InnerProducer[] arrayOfInnerProducer2;
      do
      {
        arrayOfInnerProducer1 = (OperatorPublish.InnerProducer[])this.producers.get();
        if (arrayOfInnerProducer1 == TERMINATED) {
          return false;
        }
        int i = arrayOfInnerProducer1.length;
        arrayOfInnerProducer2 = new OperatorPublish.InnerProducer[i + 1];
        System.arraycopy(arrayOfInnerProducer1, 0, arrayOfInnerProducer2, 0, i);
        arrayOfInnerProducer2[i] = paramInnerProducer;
      } while (!this.producers.compareAndSet(arrayOfInnerProducer1, arrayOfInnerProducer2));
      return true;
    }
    paramInnerProducer = new NullPointerException();
    for (;;)
    {
      throw paramInnerProducer;
    }
  }
  
  boolean checkTerminated(Object paramObject, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if (paramObject != null)
    {
      if (this.nl.isCompleted(paramObject))
      {
        if (!paramBoolean) {
          break label166;
        }
        this.current.compareAndSet(this, null);
        try
        {
          paramObject = (OperatorPublish.InnerProducer[])this.producers.getAndSet(TERMINATED);
          j = paramObject.length;
          while (i < j)
          {
            paramObject[i].child.onCompleted();
            i += 1;
          }
          return true;
        }
        finally
        {
          unsubscribe();
        }
      }
      paramObject = this.nl.getError(paramObject);
      this.current.compareAndSet(this, null);
      try
      {
        OperatorPublish.InnerProducer[] arrayOfInnerProducer = (OperatorPublish.InnerProducer[])this.producers.getAndSet(TERMINATED);
        int k = arrayOfInnerProducer.length;
        i = j;
        while (i < k)
        {
          arrayOfInnerProducer[i].child.onError(paramObject);
          i += 1;
        }
        return true;
      }
      finally
      {
        unsubscribe();
      }
    }
    label166:
    return false;
  }
  
  /* Error */
  void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 141	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   6: ifeq +11 -> 17
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 143	rx/internal/operators/OperatorPublish$PublishSubscriber:missed	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 141	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 143	rx/internal/operators/OperatorPublish$PublishSubscriber:missed	Z
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_0
    //   30: getfield 145	rx/internal/operators/OperatorPublish$PublishSubscriber:terminalEvent	Ljava/lang/Object;
    //   33: astore 13
    //   35: aload_0
    //   36: getfield 63	rx/internal/operators/OperatorPublish$PublishSubscriber:queue	Ljava/util/Queue;
    //   39: invokeinterface 150 1 0
    //   44: istore 6
    //   46: aload_0
    //   47: aload 13
    //   49: iload 6
    //   51: invokevirtual 152	rx/internal/operators/OperatorPublish$PublishSubscriber:checkTerminated	(Ljava/lang/Object;Z)Z
    //   54: ifeq +4 -> 58
    //   57: return
    //   58: iload 6
    //   60: ifne +269 -> 329
    //   63: aload_0
    //   64: getfield 78	rx/internal/operators/OperatorPublish$PublishSubscriber:producers	Ljava/util/concurrent/atomic/AtomicReference;
    //   67: invokevirtual 93	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   70: checkcast 94	[Lrx/internal/operators/OperatorPublish$InnerProducer;
    //   73: astore 13
    //   75: aload 13
    //   77: arraylength
    //   78: istore 4
    //   80: aload 13
    //   82: arraylength
    //   83: istore 5
    //   85: ldc2_w 153
    //   88: lstore 7
    //   90: iconst_0
    //   91: istore_1
    //   92: iconst_0
    //   93: istore_2
    //   94: iload_1
    //   95: iload 5
    //   97: if_icmpge +33 -> 130
    //   100: aload 13
    //   102: iload_1
    //   103: aaload
    //   104: invokevirtual 157	rx/internal/operators/OperatorPublish$InnerProducer:get	()J
    //   107: lstore 11
    //   109: lload 11
    //   111: lconst_0
    //   112: lcmp
    //   113: iflt +312 -> 425
    //   116: lload 7
    //   118: lload 11
    //   120: invokestatic 163	java/lang/Math:min	(JJ)J
    //   123: lstore 9
    //   125: iload_2
    //   126: istore_3
    //   127: goto +321 -> 448
    //   130: iload 4
    //   132: iload_2
    //   133: if_icmpne +334 -> 467
    //   136: aload_0
    //   137: getfield 145	rx/internal/operators/OperatorPublish$PublishSubscriber:terminalEvent	Ljava/lang/Object;
    //   140: astore 13
    //   142: aload_0
    //   143: getfield 63	rx/internal/operators/OperatorPublish$PublishSubscriber:queue	Ljava/util/Queue;
    //   146: invokeinterface 166 1 0
    //   151: ifnonnull +310 -> 461
    //   154: iconst_1
    //   155: istore 6
    //   157: goto +3 -> 160
    //   160: aload_0
    //   161: aload 13
    //   163: iload 6
    //   165: invokevirtual 152	rx/internal/operators/OperatorPublish$PublishSubscriber:checkTerminated	(Ljava/lang/Object;Z)Z
    //   168: ifeq +4 -> 172
    //   171: return
    //   172: aload_0
    //   173: lconst_1
    //   174: invokevirtual 170	rx/internal/operators/OperatorPublish$PublishSubscriber:request	(J)V
    //   177: goto -148 -> 29
    //   180: iload_1
    //   181: i2l
    //   182: lstore 9
    //   184: lload 9
    //   186: lload 7
    //   188: lcmp
    //   189: ifge +311 -> 500
    //   192: aload_0
    //   193: getfield 145	rx/internal/operators/OperatorPublish$PublishSubscriber:terminalEvent	Ljava/lang/Object;
    //   196: astore 14
    //   198: aload_0
    //   199: getfield 63	rx/internal/operators/OperatorPublish$PublishSubscriber:queue	Ljava/util/Queue;
    //   202: invokeinterface 166 1 0
    //   207: astore 15
    //   209: aload 15
    //   211: ifnonnull +261 -> 472
    //   214: iconst_1
    //   215: istore 6
    //   217: goto +3 -> 220
    //   220: aload_0
    //   221: aload 14
    //   223: iload 6
    //   225: invokevirtual 152	rx/internal/operators/OperatorPublish$PublishSubscriber:checkTerminated	(Ljava/lang/Object;Z)Z
    //   228: ifeq +250 -> 478
    //   231: return
    //   232: aload_0
    //   233: getfield 71	rx/internal/operators/OperatorPublish$PublishSubscriber:nl	Lrx/internal/operators/NotificationLite;
    //   236: aload 15
    //   238: invokevirtual 173	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   241: astore 14
    //   243: aload 13
    //   245: arraylength
    //   246: istore_3
    //   247: iconst_0
    //   248: istore_2
    //   249: iload_2
    //   250: iload_3
    //   251: if_icmpge +242 -> 493
    //   254: aload 13
    //   256: iload_2
    //   257: aaload
    //   258: astore 15
    //   260: aload 15
    //   262: invokevirtual 157	rx/internal/operators/OperatorPublish$InnerProducer:get	()J
    //   265: lstore 9
    //   267: lload 9
    //   269: lconst_0
    //   270: lcmp
    //   271: ifle +215 -> 486
    //   274: aload 15
    //   276: getfield 122	rx/internal/operators/OperatorPublish$InnerProducer:child	Lrx/Subscriber;
    //   279: aload 14
    //   281: invokevirtual 176	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   284: aload 15
    //   286: lconst_1
    //   287: invokevirtual 180	rx/internal/operators/OperatorPublish$InnerProducer:produced	(J)J
    //   290: pop2
    //   291: goto +195 -> 486
    //   294: astore 16
    //   296: aload 15
    //   298: invokevirtual 181	rx/internal/operators/OperatorPublish$InnerProducer:unsubscribe	()V
    //   301: aload 16
    //   303: aload 15
    //   305: getfield 122	rx/internal/operators/OperatorPublish$InnerProducer:child	Lrx/Subscriber;
    //   308: aload 14
    //   310: invokestatic 187	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;Ljava/lang/Object;)V
    //   313: goto +173 -> 486
    //   316: iload_1
    //   317: ifle +186 -> 503
    //   320: aload_0
    //   321: lload 9
    //   323: invokevirtual 170	rx/internal/operators/OperatorPublish$PublishSubscriber:request	(J)V
    //   326: goto +177 -> 503
    //   329: aload_0
    //   330: monitorenter
    //   331: aload_0
    //   332: getfield 143	rx/internal/operators/OperatorPublish$PublishSubscriber:missed	Z
    //   335: ifne +18 -> 353
    //   338: aload_0
    //   339: iconst_0
    //   340: putfield 141	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   343: aload_0
    //   344: monitorexit
    //   345: return
    //   346: astore 13
    //   348: iconst_1
    //   349: istore_1
    //   350: goto +17 -> 367
    //   353: aload_0
    //   354: iconst_0
    //   355: putfield 143	rx/internal/operators/OperatorPublish$PublishSubscriber:missed	Z
    //   358: aload_0
    //   359: monitorexit
    //   360: goto -331 -> 29
    //   363: astore 13
    //   365: iconst_0
    //   366: istore_1
    //   367: aload_0
    //   368: monitorexit
    //   369: aload 13
    //   371: athrow
    //   372: astore 13
    //   374: goto +12 -> 386
    //   377: astore 13
    //   379: goto -12 -> 367
    //   382: astore 13
    //   384: iconst_0
    //   385: istore_1
    //   386: iload_1
    //   387: ifne +22 -> 409
    //   390: aload_0
    //   391: monitorenter
    //   392: aload_0
    //   393: iconst_0
    //   394: putfield 141	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   397: aload_0
    //   398: monitorexit
    //   399: goto +10 -> 409
    //   402: astore 13
    //   404: aload_0
    //   405: monitorexit
    //   406: aload 13
    //   408: athrow
    //   409: aload 13
    //   411: athrow
    //   412: astore 13
    //   414: aload_0
    //   415: monitorexit
    //   416: goto +6 -> 422
    //   419: aload 13
    //   421: athrow
    //   422: goto -3 -> 419
    //   425: iload_2
    //   426: istore_3
    //   427: lload 7
    //   429: lstore 9
    //   431: lload 11
    //   433: ldc2_w 188
    //   436: lcmp
    //   437: ifne +11 -> 448
    //   440: iload_2
    //   441: iconst_1
    //   442: iadd
    //   443: istore_3
    //   444: lload 7
    //   446: lstore 9
    //   448: iload_1
    //   449: iconst_1
    //   450: iadd
    //   451: istore_1
    //   452: iload_3
    //   453: istore_2
    //   454: lload 9
    //   456: lstore 7
    //   458: goto -364 -> 94
    //   461: iconst_0
    //   462: istore 6
    //   464: goto -304 -> 160
    //   467: iconst_0
    //   468: istore_1
    //   469: goto -289 -> 180
    //   472: iconst_0
    //   473: istore 6
    //   475: goto -255 -> 220
    //   478: iload 6
    //   480: ifeq -248 -> 232
    //   483: goto -167 -> 316
    //   486: iload_2
    //   487: iconst_1
    //   488: iadd
    //   489: istore_2
    //   490: goto -241 -> 249
    //   493: iload_1
    //   494: iconst_1
    //   495: iadd
    //   496: istore_1
    //   497: goto -317 -> 180
    //   500: goto -184 -> 316
    //   503: lload 7
    //   505: lconst_0
    //   506: lcmp
    //   507: ifeq -178 -> 329
    //   510: iload 6
    //   512: ifne -183 -> 329
    //   515: goto -155 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	this	PublishSubscriber
    //   91	406	1	i	int
    //   93	397	2	j	int
    //   126	327	3	k	int
    //   78	56	4	m	int
    //   83	15	5	n	int
    //   44	467	6	bool	boolean
    //   88	416	7	l1	long
    //   123	332	9	l2	long
    //   107	325	11	l3	long
    //   33	222	13	localObject1	Object
    //   346	1	13	localObject2	Object
    //   363	7	13	localObject3	Object
    //   372	1	13	localObject4	Object
    //   377	1	13	localObject5	Object
    //   382	1	13	localObject6	Object
    //   402	8	13	localObject7	Object
    //   412	8	13	localObject8	Object
    //   196	113	14	localObject9	Object
    //   207	97	15	localObject10	Object
    //   294	8	16	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   274	284	294	java/lang/Throwable
    //   343	345	346	finally
    //   331	343	363	finally
    //   353	360	363	finally
    //   369	372	372	finally
    //   367	369	377	finally
    //   29	57	382	finally
    //   63	85	382	finally
    //   100	109	382	finally
    //   116	125	382	finally
    //   136	154	382	finally
    //   160	171	382	finally
    //   172	177	382	finally
    //   192	209	382	finally
    //   220	231	382	finally
    //   232	247	382	finally
    //   260	267	382	finally
    //   274	284	382	finally
    //   284	291	382	finally
    //   296	313	382	finally
    //   320	326	382	finally
    //   329	331	382	finally
    //   392	399	402	finally
    //   404	406	402	finally
    //   2	16	412	finally
    //   17	29	412	finally
    //   414	416	412	finally
  }
  
  void init()
  {
    add(Subscriptions.create(new OperatorPublish.PublishSubscriber.1(this)));
  }
  
  public void onCompleted()
  {
    if (this.terminalEvent == null)
    {
      this.terminalEvent = this.nl.completed();
      dispatch();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.terminalEvent == null)
    {
      this.terminalEvent = this.nl.error(paramThrowable);
      dispatch();
    }
  }
  
  public void onNext(T paramT)
  {
    if (!this.queue.offer(this.nl.next(paramT)))
    {
      onError(new MissingBackpressureException());
      return;
    }
    dispatch();
  }
  
  public void onStart()
  {
    request(RxRingBuffer.SIZE);
  }
  
  void remove(OperatorPublish.InnerProducer<T> paramInnerProducer)
  {
    OperatorPublish.InnerProducer[] arrayOfInnerProducer2;
    OperatorPublish.InnerProducer[] arrayOfInnerProducer1;
    do
    {
      arrayOfInnerProducer2 = (OperatorPublish.InnerProducer[])this.producers.get();
      if (arrayOfInnerProducer2 == EMPTY) {
        break;
      }
      if (arrayOfInnerProducer2 == TERMINATED) {
        return;
      }
      int k = -1;
      int m = arrayOfInnerProducer2.length;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        if (arrayOfInnerProducer2[i].equals(paramInnerProducer))
        {
          j = i;
          break;
        }
        i += 1;
      }
      if (j < 0) {
        return;
      }
      if (m == 1)
      {
        arrayOfInnerProducer1 = EMPTY;
      }
      else
      {
        arrayOfInnerProducer1 = new OperatorPublish.InnerProducer[m - 1];
        System.arraycopy(arrayOfInnerProducer2, 0, arrayOfInnerProducer1, 0, j);
        System.arraycopy(arrayOfInnerProducer2, j + 1, arrayOfInnerProducer1, j, m - j - 1);
      }
    } while (!this.producers.compareAndSet(arrayOfInnerProducer2, arrayOfInnerProducer1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorPublish.PublishSubscriber
 * JD-Core Version:    0.7.0.1
 */