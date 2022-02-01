package rx.subjects;

import rx.functions.Action1;

final class ReplaySubject$2
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  ReplaySubject$2(ReplaySubject.UnboundedReplayState paramUnboundedReplayState) {}
  
  /* Error */
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 28	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
    //   6: ifeq +149 -> 155
    //   9: aload_1
    //   10: getfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   13: ifeq +6 -> 19
    //   16: goto +139 -> 155
    //   19: aload_1
    //   20: iconst_0
    //   21: putfield 28	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
    //   24: iconst_1
    //   25: istore_3
    //   26: aload_1
    //   27: iconst_1
    //   28: putfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   31: aload_1
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield 13	rx/subjects/ReplaySubject$2:val$state	Lrx/subjects/ReplaySubject$UnboundedReplayState;
    //   37: astore 5
    //   39: aload_1
    //   40: invokevirtual 35	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	()Ljava/lang/Object;
    //   43: checkcast 37	java/lang/Integer
    //   46: invokevirtual 41	java/lang/Integer:intValue	()I
    //   49: istore_2
    //   50: aload 5
    //   52: invokevirtual 46	rx/subjects/ReplaySubject$UnboundedReplayState:get	()I
    //   55: istore 4
    //   57: iload_2
    //   58: iload 4
    //   60: if_icmpeq +17 -> 77
    //   63: aload_1
    //   64: aload 5
    //   66: iload_2
    //   67: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aload_1
    //   71: invokevirtual 54	rx/subjects/ReplaySubject$UnboundedReplayState:replayObserverFromIndex	(Ljava/lang/Integer;Lrx/subjects/SubjectSubscriptionManager$SubjectObserver;)Ljava/lang/Integer;
    //   74: invokevirtual 56	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	(Ljava/lang/Object;)V
    //   77: aload_1
    //   78: monitorenter
    //   79: iload 4
    //   81: aload 5
    //   83: invokevirtual 46	rx/subjects/ReplaySubject$UnboundedReplayState:get	()I
    //   86: if_icmpne +11 -> 97
    //   89: aload_1
    //   90: iconst_0
    //   91: putfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   94: aload_1
    //   95: monitorexit
    //   96: return
    //   97: aload_1
    //   98: monitorexit
    //   99: goto -60 -> 39
    //   102: astore 5
    //   104: iconst_0
    //   105: istore_2
    //   106: iload_2
    //   107: istore_3
    //   108: aload_1
    //   109: monitorexit
    //   110: aload 5
    //   112: athrow
    //   113: astore 5
    //   115: goto +14 -> 129
    //   118: astore 5
    //   120: iload_3
    //   121: istore_2
    //   122: goto -16 -> 106
    //   125: astore 5
    //   127: iconst_0
    //   128: istore_2
    //   129: iload_2
    //   130: ifne +22 -> 152
    //   133: aload_1
    //   134: monitorenter
    //   135: aload_1
    //   136: iconst_0
    //   137: putfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   140: aload_1
    //   141: monitorexit
    //   142: goto +10 -> 152
    //   145: astore 5
    //   147: aload_1
    //   148: monitorexit
    //   149: aload 5
    //   151: athrow
    //   152: aload 5
    //   154: athrow
    //   155: aload_1
    //   156: monitorexit
    //   157: return
    //   158: astore 5
    //   160: aload_1
    //   161: monitorexit
    //   162: goto +6 -> 168
    //   165: aload 5
    //   167: athrow
    //   168: goto -3 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	2
    //   0	171	1	paramSubjectObserver	SubjectSubscriptionManager.SubjectObserver<T>
    //   49	81	2	i	int
    //   25	96	3	j	int
    //   55	32	4	k	int
    //   37	45	5	localUnboundedReplayState	ReplaySubject.UnboundedReplayState
    //   102	9	5	localObject1	Object
    //   113	1	5	localObject2	Object
    //   118	1	5	localObject3	Object
    //   125	1	5	localObject4	Object
    //   145	8	5	localObject5	Object
    //   158	8	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   79	94	102	finally
    //   97	99	102	finally
    //   110	113	113	finally
    //   94	96	118	finally
    //   108	110	118	finally
    //   33	39	125	finally
    //   39	57	125	finally
    //   63	77	125	finally
    //   77	79	125	finally
    //   135	142	145	finally
    //   147	149	145	finally
    //   2	16	158	finally
    //   19	24	158	finally
    //   26	33	158	finally
    //   155	157	158	finally
    //   160	162	158	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subjects.ReplaySubject.2
 * JD-Core Version:    0.7.0.1
 */