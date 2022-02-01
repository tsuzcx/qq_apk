package rx.internal.producers;

import rx.Producer;

public final class ProducerArbiter
  implements Producer
{
  static final Producer NULL_PRODUCER = new ProducerArbiter.1();
  Producer currentProducer;
  boolean emitting;
  long missedProduced;
  Producer missedProducer;
  long missedRequested;
  long requested;
  
  public void emitLoop()
  {
    for (;;)
    {
      try
      {
        long l3 = this.missedRequested;
        long l4 = this.missedProduced;
        Producer localProducer = this.missedProducer;
        if ((l3 == 0L) && (l4 == 0L) && (localProducer == null))
        {
          this.emitting = false;
          return;
        }
        this.missedRequested = 0L;
        this.missedProduced = 0L;
        this.missedProducer = null;
        long l2 = this.requested;
        long l1 = l2;
        if (l2 != 9223372036854775807L)
        {
          l1 = l2 + l3;
          if ((l1 >= 0L) && (l1 != 9223372036854775807L))
          {
            l1 -= l4;
            if (l1 >= 0L) {
              this.requested = l1;
            } else {
              throw new IllegalStateException("more produced than requested");
            }
          }
          else
          {
            this.requested = 9223372036854775807L;
            l1 = 9223372036854775807L;
          }
        }
        if (localProducer != null)
        {
          if (localProducer == NULL_PRODUCER)
          {
            this.currentProducer = null;
          }
          else
          {
            this.currentProducer = localProducer;
            localProducer.request(l1);
          }
        }
        else
        {
          localProducer = this.currentProducer;
          if ((localProducer != null) && (l3 != 0L)) {
            localProducer.request(l3);
          }
        }
      }
      finally {}
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  /* Error */
  public void produced(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifle +106 -> 109
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   12: ifeq +16 -> 28
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 32	rx/internal/producers/ProducerArbiter:missedProduced	J
    //   20: lload_1
    //   21: ladd
    //   22: putfield 32	rx/internal/producers/ProducerArbiter:missedProduced	J
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: getfield 38	rx/internal/producers/ProducerArbiter:requested	J
    //   39: lstore_3
    //   40: lload_3
    //   41: ldc2_w 39
    //   44: lcmp
    //   45: ifeq +31 -> 76
    //   48: lload_3
    //   49: lload_1
    //   50: lsub
    //   51: lstore_1
    //   52: lload_1
    //   53: lconst_0
    //   54: lcmp
    //   55: iflt +11 -> 66
    //   58: aload_0
    //   59: lload_1
    //   60: putfield 38	rx/internal/producers/ProducerArbiter:requested	J
    //   63: goto +13 -> 76
    //   66: new 42	java/lang/IllegalStateException
    //   69: dup
    //   70: ldc 56
    //   72: invokespecial 47	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   75: athrow
    //   76: aload_0
    //   77: invokevirtual 58	rx/internal/producers/ProducerArbiter:emitLoop	()V
    //   80: return
    //   81: astore 5
    //   83: aload_0
    //   84: monitorenter
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   90: aload_0
    //   91: monitorexit
    //   92: aload 5
    //   94: athrow
    //   95: astore 5
    //   97: aload_0
    //   98: monitorexit
    //   99: aload 5
    //   101: athrow
    //   102: astore 5
    //   104: aload_0
    //   105: monitorexit
    //   106: aload 5
    //   108: athrow
    //   109: new 60	java/lang/IllegalArgumentException
    //   112: dup
    //   113: ldc 62
    //   115: invokespecial 63	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	ProducerArbiter
    //   0	119	1	paramLong	long
    //   39	10	3	l	long
    //   81	12	5	localObject1	Object
    //   95	5	5	localObject2	Object
    //   102	5	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	40	81	finally
    //   58	63	81	finally
    //   66	76	81	finally
    //   76	80	81	finally
    //   85	92	95	finally
    //   97	99	95	finally
    //   8	27	102	finally
    //   28	35	102	finally
    //   104	106	102	finally
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
    //   16: getfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   19: ifeq +16 -> 35
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 30	rx/internal/producers/ProducerArbiter:missedRequested	J
    //   27: lload_1
    //   28: ladd
    //   29: putfield 30	rx/internal/producers/ProducerArbiter:missedRequested	J
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 38	rx/internal/producers/ProducerArbiter:requested	J
    //   46: lload_1
    //   47: ladd
    //   48: lstore 5
    //   50: lload 5
    //   52: lstore_3
    //   53: lload 5
    //   55: lconst_0
    //   56: lcmp
    //   57: ifge +7 -> 64
    //   60: ldc2_w 39
    //   63: lstore_3
    //   64: aload_0
    //   65: lload_3
    //   66: putfield 38	rx/internal/producers/ProducerArbiter:requested	J
    //   69: aload_0
    //   70: getfield 49	rx/internal/producers/ProducerArbiter:currentProducer	Lrx/Producer;
    //   73: astore 7
    //   75: aload 7
    //   77: ifnull +11 -> 88
    //   80: aload 7
    //   82: lload_1
    //   83: invokeinterface 53 3 0
    //   88: aload_0
    //   89: invokevirtual 58	rx/internal/producers/ProducerArbiter:emitLoop	()V
    //   92: return
    //   93: astore 7
    //   95: aload_0
    //   96: monitorenter
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
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
    //   121: new 60	java/lang/IllegalArgumentException
    //   124: dup
    //   125: ldc 65
    //   127: invokespecial 63	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ProducerArbiter
    //   0	131	1	paramLong	long
    //   52	14	3	l1	long
    //   48	6	5	l2	long
    //   73	8	7	localProducer	Producer
    //   93	12	7	localObject1	Object
    //   107	5	7	localObject2	Object
    //   114	5	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   42	50	93	finally
    //   64	75	93	finally
    //   80	88	93	finally
    //   88	92	93	finally
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
    //   3: getfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   6: ifeq +21 -> 27
    //   9: aload_1
    //   10: astore_2
    //   11: aload_1
    //   12: ifnonnull +7 -> 19
    //   15: getstatic 25	rx/internal/producers/ProducerArbiter:NULL_PRODUCER	Lrx/Producer;
    //   18: astore_2
    //   19: aload_0
    //   20: aload_2
    //   21: putfield 34	rx/internal/producers/ProducerArbiter:missedProducer	Lrx/Producer;
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_0
    //   35: aload_1
    //   36: putfield 49	rx/internal/producers/ProducerArbiter:currentProducer	Lrx/Producer;
    //   39: aload_1
    //   40: ifnull +13 -> 53
    //   43: aload_1
    //   44: aload_0
    //   45: getfield 38	rx/internal/producers/ProducerArbiter:requested	J
    //   48: invokeinterface 53 3 0
    //   53: aload_0
    //   54: invokevirtual 58	rx/internal/producers/ProducerArbiter:emitLoop	()V
    //   57: return
    //   58: astore_1
    //   59: aload_0
    //   60: monitorenter
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ProducerArbiter
    //   0	80	1	paramProducer	Producer
    //   10	11	2	localProducer	Producer
    // Exception table:
    //   from	to	target	type
    //   34	39	58	finally
    //   43	53	58	finally
    //   53	57	58	finally
    //   61	68	70	finally
    //   71	73	70	finally
    //   2	9	75	finally
    //   15	19	75	finally
    //   19	26	75	finally
    //   27	34	75	finally
    //   76	78	75	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.producers.ProducerArbiter
 * JD-Core Version:    0.7.0.1
 */