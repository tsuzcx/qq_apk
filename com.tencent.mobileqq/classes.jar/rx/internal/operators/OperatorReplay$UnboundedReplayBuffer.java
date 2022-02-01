package rx.internal.operators;

import java.util.ArrayList;

final class OperatorReplay$UnboundedReplayBuffer<T>
  extends ArrayList<Object>
  implements OperatorReplay.ReplayBuffer<T>
{
  private static final long serialVersionUID = 7063189396499112664L;
  final NotificationLite<T> nl = NotificationLite.instance();
  volatile int size;
  
  public OperatorReplay$UnboundedReplayBuffer(int paramInt)
  {
    super(paramInt);
  }
  
  public void complete()
  {
    add(this.nl.completed());
    this.size += 1;
  }
  
  public void error(Throwable paramThrowable)
  {
    add(this.nl.error(paramThrowable));
    this.size += 1;
  }
  
  public void next(T paramT)
  {
    add(this.nl.next(paramT));
    this.size += 1;
  }
  
  /* Error */
  public void replay(OperatorReplay.InnerProducer<T> paramInnerProducer)
  {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 63	rx/internal/operators/OperatorReplay$InnerProducer:emitting	Z
    //   6: ifeq +11 -> 17
    //   9: aload_1
    //   10: iconst_1
    //   11: putfield 66	rx/internal/operators/OperatorReplay$InnerProducer:missed	Z
    //   14: aload_1
    //   15: monitorexit
    //   16: return
    //   17: aload_1
    //   18: iconst_1
    //   19: putfield 63	rx/internal/operators/OperatorReplay$InnerProducer:emitting	Z
    //   22: aload_1
    //   23: monitorexit
    //   24: aload_1
    //   25: invokevirtual 70	rx/internal/operators/OperatorReplay$InnerProducer:isUnsubscribed	()Z
    //   28: ifne +240 -> 268
    //   31: aload_0
    //   32: getfield 41	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:size	I
    //   35: istore_3
    //   36: aload_1
    //   37: invokevirtual 73	rx/internal/operators/OperatorReplay$InnerProducer:index	()Ljava/lang/Object;
    //   40: checkcast 75	java/lang/Integer
    //   43: astore 11
    //   45: aload 11
    //   47: ifnull +94 -> 141
    //   50: aload 11
    //   52: invokevirtual 79	java/lang/Integer:intValue	()I
    //   55: istore_2
    //   56: aload_1
    //   57: invokevirtual 83	rx/internal/operators/OperatorReplay$InnerProducer:get	()J
    //   60: lstore 8
    //   62: lconst_0
    //   63: lstore 4
    //   65: lload 8
    //   67: lstore 6
    //   69: lload 6
    //   71: lconst_0
    //   72: lcmp
    //   73: ifeq +130 -> 203
    //   76: iload_2
    //   77: iload_3
    //   78: if_icmpge +125 -> 203
    //   81: aload_0
    //   82: iload_2
    //   83: invokevirtual 86	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:get	(I)Ljava/lang/Object;
    //   86: astore 11
    //   88: aload_0
    //   89: getfield 28	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:nl	Lrx/internal/operators/NotificationLite;
    //   92: aload_1
    //   93: getfield 90	rx/internal/operators/OperatorReplay$InnerProducer:child	Lrx/Subscriber;
    //   96: aload 11
    //   98: invokevirtual 94	rx/internal/operators/NotificationLite:accept	(Lrx/Observer;Ljava/lang/Object;)Z
    //   101: istore 10
    //   103: iload 10
    //   105: ifne +163 -> 268
    //   108: aload_1
    //   109: invokevirtual 70	rx/internal/operators/OperatorReplay$InnerProducer:isUnsubscribed	()Z
    //   112: ifne +156 -> 268
    //   115: iload_2
    //   116: iconst_1
    //   117: iadd
    //   118: istore_2
    //   119: lload 6
    //   121: lconst_1
    //   122: lsub
    //   123: lstore 6
    //   125: lload 4
    //   127: lconst_1
    //   128: ladd
    //   129: lstore 4
    //   131: goto -62 -> 69
    //   134: astore 11
    //   136: aload_1
    //   137: monitorexit
    //   138: aload 11
    //   140: athrow
    //   141: iconst_0
    //   142: istore_2
    //   143: goto -87 -> 56
    //   146: astore 12
    //   148: aload 12
    //   150: invokestatic 99	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   153: aload_1
    //   154: invokevirtual 102	rx/internal/operators/OperatorReplay$InnerProducer:unsubscribe	()V
    //   157: aload_0
    //   158: getfield 28	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:nl	Lrx/internal/operators/NotificationLite;
    //   161: aload 11
    //   163: invokevirtual 105	rx/internal/operators/NotificationLite:isError	(Ljava/lang/Object;)Z
    //   166: ifne +102 -> 268
    //   169: aload_0
    //   170: getfield 28	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:nl	Lrx/internal/operators/NotificationLite;
    //   173: aload 11
    //   175: invokevirtual 108	rx/internal/operators/NotificationLite:isCompleted	(Ljava/lang/Object;)Z
    //   178: ifne +90 -> 268
    //   181: aload_1
    //   182: getfield 90	rx/internal/operators/OperatorReplay$InnerProducer:child	Lrx/Subscriber;
    //   185: aload 12
    //   187: aload_0
    //   188: getfield 28	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:nl	Lrx/internal/operators/NotificationLite;
    //   191: aload 11
    //   193: invokevirtual 111	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   196: invokestatic 117	rx/exceptions/OnErrorThrowable:addValueAsLastCause	(Ljava/lang/Throwable;Ljava/lang/Object;)Ljava/lang/Throwable;
    //   199: invokevirtual 122	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   202: return
    //   203: lload 4
    //   205: lconst_0
    //   206: lcmp
    //   207: ifeq +27 -> 234
    //   210: aload_1
    //   211: iload_2
    //   212: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: putfield 129	rx/internal/operators/OperatorReplay$InnerProducer:index	Ljava/lang/Object;
    //   218: lload 8
    //   220: ldc2_w 130
    //   223: lcmp
    //   224: ifeq +10 -> 234
    //   227: aload_1
    //   228: lload 4
    //   230: invokevirtual 135	rx/internal/operators/OperatorReplay$InnerProducer:produced	(J)J
    //   233: pop2
    //   234: aload_1
    //   235: monitorenter
    //   236: aload_1
    //   237: getfield 66	rx/internal/operators/OperatorReplay$InnerProducer:missed	Z
    //   240: ifne +18 -> 258
    //   243: aload_1
    //   244: iconst_0
    //   245: putfield 63	rx/internal/operators/OperatorReplay$InnerProducer:emitting	Z
    //   248: aload_1
    //   249: monitorexit
    //   250: return
    //   251: astore 11
    //   253: aload_1
    //   254: monitorexit
    //   255: aload 11
    //   257: athrow
    //   258: aload_1
    //   259: iconst_0
    //   260: putfield 66	rx/internal/operators/OperatorReplay$InnerProducer:missed	Z
    //   263: aload_1
    //   264: monitorexit
    //   265: goto -241 -> 24
    //   268: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	UnboundedReplayBuffer
    //   0	269	1	paramInnerProducer	OperatorReplay.InnerProducer<T>
    //   55	157	2	i	int
    //   35	44	3	j	int
    //   63	166	4	l1	long
    //   67	57	6	l2	long
    //   60	159	8	l3	long
    //   101	3	10	bool	boolean
    //   43	54	11	localObject1	Object
    //   134	58	11	localObject2	Object
    //   251	5	11	localObject3	Object
    //   146	40	12	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	16	134	finally
    //   17	24	134	finally
    //   136	138	134	finally
    //   88	103	146	java/lang/Throwable
    //   236	250	251	finally
    //   253	255	251	finally
    //   258	265	251	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.UnboundedReplayBuffer
 * JD-Core Version:    0.7.0.1
 */