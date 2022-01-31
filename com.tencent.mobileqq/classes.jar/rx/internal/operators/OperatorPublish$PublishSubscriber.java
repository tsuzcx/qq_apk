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
    if (UnsafeAccess.isUnsafeAvailable()) {}
    for (Object localObject = new SpscArrayQueue(RxRingBuffer.SIZE);; localObject = new SynchronizedQueue(RxRingBuffer.SIZE))
    {
      this.queue = ((Queue)localObject);
      this.nl = NotificationLite.instance();
      this.producers = new AtomicReference(EMPTY);
      this.current = paramAtomicReference;
      this.shouldConnect = new AtomicBoolean();
      return;
    }
  }
  
  boolean add(OperatorPublish.InnerProducer<T> paramInnerProducer)
  {
    if (paramInnerProducer == null) {
      throw new NullPointerException();
    }
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
    //   29: iconst_0
    //   30: istore 4
    //   32: aload_0
    //   33: getfield 145	rx/internal/operators/OperatorPublish$PublishSubscriber:terminalEvent	Ljava/lang/Object;
    //   36: astore 14
    //   38: aload_0
    //   39: getfield 60	rx/internal/operators/OperatorPublish$PublishSubscriber:queue	Ljava/util/Queue;
    //   42: invokeinterface 150 1 0
    //   47: istore 7
    //   49: aload_0
    //   50: aload 14
    //   52: iload 7
    //   54: invokevirtual 152	rx/internal/operators/OperatorPublish$PublishSubscriber:checkTerminated	(Ljava/lang/Object;Z)Z
    //   57: ifne +410 -> 467
    //   60: iload 7
    //   62: ifne +250 -> 312
    //   65: aload_0
    //   66: getfield 75	rx/internal/operators/OperatorPublish$PublishSubscriber:producers	Ljava/util/concurrent/atomic/AtomicReference;
    //   69: invokevirtual 96	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   72: checkcast 97	[Lrx/internal/operators/OperatorPublish$InnerProducer;
    //   75: astore 14
    //   77: aload 14
    //   79: arraylength
    //   80: istore 5
    //   82: aload 14
    //   84: arraylength
    //   85: istore 6
    //   87: iconst_0
    //   88: istore_2
    //   89: ldc2_w 153
    //   92: lstore 8
    //   94: iconst_0
    //   95: istore_1
    //   96: iload_1
    //   97: iload 6
    //   99: if_icmpge +76 -> 175
    //   102: aload 14
    //   104: iload_1
    //   105: aaload
    //   106: invokevirtual 157	rx/internal/operators/OperatorPublish$InnerProducer:get	()J
    //   109: lstore 12
    //   111: lload 12
    //   113: lconst_0
    //   114: lcmp
    //   115: iflt +34 -> 149
    //   118: lload 8
    //   120: lload 12
    //   122: invokestatic 163	java/lang/Math:min	(JJ)J
    //   125: lstore 10
    //   127: iload_2
    //   128: istore_3
    //   129: iload_1
    //   130: iconst_1
    //   131: iadd
    //   132: istore_1
    //   133: iload_3
    //   134: istore_2
    //   135: lload 10
    //   137: lstore 8
    //   139: goto -43 -> 96
    //   142: astore 14
    //   144: aload_0
    //   145: monitorexit
    //   146: aload 14
    //   148: athrow
    //   149: iload_2
    //   150: istore_3
    //   151: lload 8
    //   153: lstore 10
    //   155: lload 12
    //   157: ldc2_w 164
    //   160: lcmp
    //   161: ifne -32 -> 129
    //   164: iload_2
    //   165: iconst_1
    //   166: iadd
    //   167: istore_3
    //   168: lload 8
    //   170: lstore 10
    //   172: goto -43 -> 129
    //   175: iload 5
    //   177: iload_2
    //   178: if_icmpne +70 -> 248
    //   181: aload_0
    //   182: getfield 145	rx/internal/operators/OperatorPublish$PublishSubscriber:terminalEvent	Ljava/lang/Object;
    //   185: astore 14
    //   187: aload_0
    //   188: getfield 60	rx/internal/operators/OperatorPublish$PublishSubscriber:queue	Ljava/util/Queue;
    //   191: invokeinterface 168 1 0
    //   196: ifnonnull +46 -> 242
    //   199: iconst_1
    //   200: istore 7
    //   202: aload_0
    //   203: aload 14
    //   205: iload 7
    //   207: invokevirtual 152	rx/internal/operators/OperatorPublish$PublishSubscriber:checkTerminated	(Ljava/lang/Object;Z)Z
    //   210: ifne +257 -> 467
    //   213: aload_0
    //   214: lconst_1
    //   215: invokevirtual 172	rx/internal/operators/OperatorPublish$PublishSubscriber:request	(J)V
    //   218: goto -186 -> 32
    //   221: astore 14
    //   223: iload 4
    //   225: istore_1
    //   226: iload_1
    //   227: ifne +12 -> 239
    //   230: aload_0
    //   231: monitorenter
    //   232: aload_0
    //   233: iconst_0
    //   234: putfield 141	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   237: aload_0
    //   238: monitorexit
    //   239: aload 14
    //   241: athrow
    //   242: iconst_0
    //   243: istore 7
    //   245: goto -43 -> 202
    //   248: iconst_0
    //   249: istore_1
    //   250: iload_1
    //   251: i2l
    //   252: lload 8
    //   254: lcmp
    //   255: ifge +209 -> 464
    //   258: aload_0
    //   259: getfield 145	rx/internal/operators/OperatorPublish$PublishSubscriber:terminalEvent	Ljava/lang/Object;
    //   262: astore 15
    //   264: aload_0
    //   265: getfield 60	rx/internal/operators/OperatorPublish$PublishSubscriber:queue	Ljava/util/Queue;
    //   268: invokeinterface 168 1 0
    //   273: astore 16
    //   275: aload 16
    //   277: ifnonnull +66 -> 343
    //   280: iconst_1
    //   281: istore 7
    //   283: aload_0
    //   284: aload 15
    //   286: iload 7
    //   288: invokevirtual 152	rx/internal/operators/OperatorPublish$PublishSubscriber:checkTerminated	(Ljava/lang/Object;Z)Z
    //   291: ifne +176 -> 467
    //   294: iload 7
    //   296: ifeq +53 -> 349
    //   299: iload_1
    //   300: ifle +168 -> 468
    //   303: aload_0
    //   304: iload_1
    //   305: i2l
    //   306: invokevirtual 172	rx/internal/operators/OperatorPublish$PublishSubscriber:request	(J)V
    //   309: goto +159 -> 468
    //   312: aload_0
    //   313: monitorenter
    //   314: aload_0
    //   315: getfield 143	rx/internal/operators/OperatorPublish$PublishSubscriber:missed	Z
    //   318: ifne +122 -> 440
    //   321: aload_0
    //   322: iconst_0
    //   323: putfield 141	rx/internal/operators/OperatorPublish$PublishSubscriber:emitting	Z
    //   326: iconst_1
    //   327: istore_2
    //   328: aload_0
    //   329: monitorexit
    //   330: return
    //   331: iload_1
    //   332: istore_2
    //   333: aload_0
    //   334: monitorexit
    //   335: aload 14
    //   337: athrow
    //   338: astore 14
    //   340: goto -114 -> 226
    //   343: iconst_0
    //   344: istore 7
    //   346: goto -63 -> 283
    //   349: aload_0
    //   350: getfield 68	rx/internal/operators/OperatorPublish$PublishSubscriber:nl	Lrx/internal/operators/NotificationLite;
    //   353: aload 16
    //   355: invokevirtual 175	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   358: astore 15
    //   360: aload 14
    //   362: arraylength
    //   363: istore_3
    //   364: iconst_0
    //   365: istore_2
    //   366: iload_2
    //   367: iload_3
    //   368: if_icmpge +65 -> 433
    //   371: aload 14
    //   373: iload_2
    //   374: aaload
    //   375: astore 16
    //   377: aload 16
    //   379: invokevirtual 157	rx/internal/operators/OperatorPublish$InnerProducer:get	()J
    //   382: lstore 10
    //   384: lload 10
    //   386: lconst_0
    //   387: lcmp
    //   388: ifle +102 -> 490
    //   391: aload 16
    //   393: getfield 122	rx/internal/operators/OperatorPublish$InnerProducer:child	Lrx/Subscriber;
    //   396: aload 15
    //   398: invokevirtual 178	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   401: aload 16
    //   403: lconst_1
    //   404: invokevirtual 182	rx/internal/operators/OperatorPublish$InnerProducer:produced	(J)J
    //   407: pop2
    //   408: goto +82 -> 490
    //   411: astore 17
    //   413: aload 16
    //   415: invokevirtual 183	rx/internal/operators/OperatorPublish$InnerProducer:unsubscribe	()V
    //   418: aload 17
    //   420: aload 16
    //   422: getfield 122	rx/internal/operators/OperatorPublish$InnerProducer:child	Lrx/Subscriber;
    //   425: aload 15
    //   427: invokestatic 189	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;Ljava/lang/Object;)V
    //   430: goto +60 -> 490
    //   433: iload_1
    //   434: iconst_1
    //   435: iadd
    //   436: istore_1
    //   437: goto -187 -> 250
    //   440: aload_0
    //   441: iconst_0
    //   442: putfield 143	rx/internal/operators/OperatorPublish$PublishSubscriber:missed	Z
    //   445: aload_0
    //   446: monitorexit
    //   447: goto -415 -> 32
    //   450: astore 14
    //   452: iconst_0
    //   453: istore_1
    //   454: goto -123 -> 331
    //   457: astore 14
    //   459: aload_0
    //   460: monitorexit
    //   461: aload 14
    //   463: athrow
    //   464: goto -165 -> 299
    //   467: return
    //   468: lload 8
    //   470: lconst_0
    //   471: lcmp
    //   472: ifeq -160 -> 312
    //   475: iload 7
    //   477: ifeq -445 -> 32
    //   480: goto -168 -> 312
    //   483: astore 14
    //   485: iload_2
    //   486: istore_1
    //   487: goto -156 -> 331
    //   490: iload_2
    //   491: iconst_1
    //   492: iadd
    //   493: istore_2
    //   494: goto -128 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	PublishSubscriber
    //   95	392	1	i	int
    //   88	406	2	j	int
    //   128	241	3	k	int
    //   30	194	4	m	int
    //   80	99	5	n	int
    //   85	15	6	i1	int
    //   47	429	7	bool	boolean
    //   92	377	8	l1	long
    //   125	260	10	l2	long
    //   109	47	12	l3	long
    //   36	67	14	localObject1	Object
    //   142	5	14	localObject2	Object
    //   185	19	14	localObject3	Object
    //   221	115	14	localObject4	Object
    //   338	34	14	localObject5	Object
    //   450	1	14	localObject6	Object
    //   457	5	14	localObject7	Object
    //   483	1	14	localObject8	Object
    //   262	164	15	localObject9	Object
    //   273	148	16	localObject10	Object
    //   411	8	17	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	16	142	finally
    //   17	29	142	finally
    //   144	146	142	finally
    //   32	60	221	finally
    //   65	87	221	finally
    //   102	111	221	finally
    //   118	127	221	finally
    //   181	199	221	finally
    //   202	218	221	finally
    //   258	275	221	finally
    //   283	294	221	finally
    //   303	309	221	finally
    //   312	314	221	finally
    //   349	364	221	finally
    //   377	384	221	finally
    //   391	401	221	finally
    //   401	408	221	finally
    //   413	430	221	finally
    //   335	338	338	finally
    //   391	401	411	java/lang/Throwable
    //   314	326	450	finally
    //   440	447	450	finally
    //   232	239	457	finally
    //   459	461	457	finally
    //   328	330	483	finally
    //   333	335	483	finally
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
    OperatorPublish.InnerProducer[] arrayOfInnerProducer2 = (OperatorPublish.InnerProducer[])this.producers.get();
    if ((arrayOfInnerProducer2 == EMPTY) || (arrayOfInnerProducer2 == TERMINATED)) {}
    int m;
    int i;
    label39:
    int j;
    do
    {
      return;
      int k = -1;
      m = arrayOfInnerProducer2.length;
      i = 0;
      j = k;
      if (i < m)
      {
        if (!arrayOfInnerProducer2[i].equals(paramInnerProducer)) {
          break;
        }
        j = i;
      }
    } while (j < 0);
    OperatorPublish.InnerProducer[] arrayOfInnerProducer1;
    if (m == 1) {
      arrayOfInnerProducer1 = EMPTY;
    }
    while (this.producers.compareAndSet(arrayOfInnerProducer2, arrayOfInnerProducer1))
    {
      return;
      i += 1;
      break label39;
      arrayOfInnerProducer1 = new OperatorPublish.InnerProducer[m - 1];
      System.arraycopy(arrayOfInnerProducer2, 0, arrayOfInnerProducer1, 0, j);
      System.arraycopy(arrayOfInnerProducer2, j + 1, arrayOfInnerProducer1, j, m - j - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorPublish.PublishSubscriber
 * JD-Core Version:    0.7.0.1
 */