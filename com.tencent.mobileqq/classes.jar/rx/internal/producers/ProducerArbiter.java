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
      long l3;
      long l1;
      for (;;)
      {
        long l4;
        try
        {
          l3 = this.missedRequested;
          l4 = this.missedProduced;
          Producer localProducer1 = this.missedProducer;
          if ((l3 == 0L) && (l4 == 0L) && (localProducer1 == null))
          {
            this.emitting = false;
            return;
          }
          this.missedRequested = 0L;
          this.missedProduced = 0L;
          this.missedProducer = null;
          long l2 = this.requested;
          l1 = l2;
          if (l2 != 9223372036854775807L)
          {
            l1 = l2 + l3;
            if ((l1 < 0L) || (l1 == 9223372036854775807L))
            {
              this.requested = 9223372036854775807L;
              l1 = 9223372036854775807L;
            }
          }
          else
          {
            if (localProducer1 == null) {
              break label183;
            }
            if (localProducer1 != NULL_PRODUCER) {
              break label166;
            }
            this.currentProducer = null;
            break;
          }
        }
        finally {}
        l1 -= l4;
        if (l1 < 0L) {
          throw new IllegalStateException("more produced than requested");
        }
        this.requested = l1;
      }
      label166:
      this.currentProducer = localObject;
      localObject.request(l1);
      continue;
      label183:
      Producer localProducer2 = this.currentProducer;
      if ((localProducer2 != null) && (l3 != 0L)) {
        localProducer2.request(l3);
      }
    }
  }
  
  /* Error */
  public void produced(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifgt +13 -> 16
    //   6: new 56	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc 58
    //   12: invokespecial 59	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_0
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   22: ifeq +16 -> 38
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 32	rx/internal/producers/ProducerArbiter:missedProduced	J
    //   30: lload_1
    //   31: ladd
    //   32: putfield 32	rx/internal/producers/ProducerArbiter:missedProduced	J
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: getfield 38	rx/internal/producers/ProducerArbiter:requested	J
    //   49: lstore_3
    //   50: lload_3
    //   51: ldc2_w 39
    //   54: lcmp
    //   55: ifeq +49 -> 104
    //   58: lload_3
    //   59: lload_1
    //   60: lsub
    //   61: lstore_1
    //   62: lload_1
    //   63: lconst_0
    //   64: lcmp
    //   65: ifge +34 -> 99
    //   68: new 44	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc 61
    //   74: invokespecial 49	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: astore 5
    //   80: aload_0
    //   81: monitorenter
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   87: aload_0
    //   88: monitorexit
    //   89: aload 5
    //   91: athrow
    //   92: astore 5
    //   94: aload_0
    //   95: monitorexit
    //   96: aload 5
    //   98: athrow
    //   99: aload_0
    //   100: lload_1
    //   101: putfield 38	rx/internal/producers/ProducerArbiter:requested	J
    //   104: aload_0
    //   105: invokevirtual 63	rx/internal/producers/ProducerArbiter:emitLoop	()V
    //   108: return
    //   109: astore 5
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 5
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	ProducerArbiter
    //   0	116	1	paramLong	long
    //   49	10	3	l	long
    //   78	12	5	localObject1	Object
    //   92	5	5	localObject2	Object
    //   109	5	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   45	50	78	finally
    //   68	78	78	finally
    //   99	104	78	finally
    //   104	108	78	finally
    //   18	37	92	finally
    //   38	45	92	finally
    //   94	96	92	finally
    //   82	89	109	finally
    //   111	113	109	finally
  }
  
  /* Error */
  public void request(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifge +13 -> 16
    //   6: new 56	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc 65
    //   12: invokespecial 59	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: ifne +4 -> 23
    //   22: return
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   29: ifeq +23 -> 52
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 30	rx/internal/producers/ProducerArbiter:missedRequested	J
    //   37: lload_1
    //   38: ladd
    //   39: putfield 30	rx/internal/producers/ProducerArbiter:missedRequested	J
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
    //   54: putfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 38	rx/internal/producers/ProducerArbiter:requested	J
    //   63: lload_1
    //   64: ladd
    //   65: lstore 5
    //   67: lload 5
    //   69: lstore_3
    //   70: lload 5
    //   72: lconst_0
    //   73: lcmp
    //   74: ifge +7 -> 81
    //   77: ldc2_w 39
    //   80: lstore_3
    //   81: aload_0
    //   82: lload_3
    //   83: putfield 38	rx/internal/producers/ProducerArbiter:requested	J
    //   86: aload_0
    //   87: getfield 42	rx/internal/producers/ProducerArbiter:currentProducer	Lrx/Producer;
    //   90: astore 7
    //   92: aload 7
    //   94: ifnull +11 -> 105
    //   97: aload 7
    //   99: lload_1
    //   100: invokeinterface 53 3 0
    //   105: aload_0
    //   106: invokevirtual 63	rx/internal/producers/ProducerArbiter:emitLoop	()V
    //   109: return
    //   110: astore 7
    //   112: aload_0
    //   113: monitorenter
    //   114: aload_0
    //   115: iconst_0
    //   116: putfield 36	rx/internal/producers/ProducerArbiter:emitting	Z
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
    //   0	131	0	this	ProducerArbiter
    //   0	131	1	paramLong	long
    //   69	14	3	l1	long
    //   65	6	5	l2	long
    //   45	5	7	localObject1	Object
    //   90	8	7	localProducer	Producer
    //   110	12	7	localObject2	Object
    //   124	5	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	44	45	finally
    //   47	49	45	finally
    //   52	59	45	finally
    //   59	67	110	finally
    //   81	92	110	finally
    //   97	105	110	finally
    //   105	109	110	finally
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
    //   36: putfield 42	rx/internal/producers/ProducerArbiter:currentProducer	Lrx/Producer;
    //   39: aload_1
    //   40: ifnull +13 -> 53
    //   43: aload_1
    //   44: aload_0
    //   45: getfield 38	rx/internal/producers/ProducerArbiter:requested	J
    //   48: invokeinterface 53 3 0
    //   53: aload_0
    //   54: invokevirtual 63	rx/internal/producers/ProducerArbiter:emitLoop	()V
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
    //   2	9	70	finally
    //   15	19	70	finally
    //   19	26	70	finally
    //   27	34	70	finally
    //   71	73	70	finally
    //   61	68	75	finally
    //   76	78	75	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.producers.ProducerArbiter
 * JD-Core Version:    0.7.0.1
 */