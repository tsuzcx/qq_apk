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
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_1
    //   7: getfield 28	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
    //   10: ifeq +10 -> 20
    //   13: aload_1
    //   14: getfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   17: ifeq +6 -> 23
    //   20: aload_1
    //   21: monitorexit
    //   22: return
    //   23: aload_1
    //   24: iconst_0
    //   25: putfield 28	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
    //   28: aload_1
    //   29: iconst_1
    //   30: putfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   33: aload_1
    //   34: monitorexit
    //   35: aload_0
    //   36: getfield 13	rx/subjects/ReplaySubject$2:val$state	Lrx/subjects/ReplaySubject$UnboundedReplayState;
    //   39: astore 6
    //   41: aload_1
    //   42: invokevirtual 35	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	()Ljava/lang/Object;
    //   45: checkcast 37	java/lang/Integer
    //   48: invokevirtual 41	java/lang/Integer:intValue	()I
    //   51: istore 4
    //   53: aload 6
    //   55: invokevirtual 46	rx/subjects/ReplaySubject$UnboundedReplayState:get	()I
    //   58: istore 5
    //   60: iload 4
    //   62: iload 5
    //   64: if_icmpeq +18 -> 82
    //   67: aload_1
    //   68: aload 6
    //   70: iload 4
    //   72: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aload_1
    //   76: invokevirtual 54	rx/subjects/ReplaySubject$UnboundedReplayState:replayObserverFromIndex	(Ljava/lang/Integer;Lrx/subjects/SubjectSubscriptionManager$SubjectObserver;)Ljava/lang/Integer;
    //   79: invokevirtual 56	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	(Ljava/lang/Object;)V
    //   82: aload_1
    //   83: monitorenter
    //   84: iload 5
    //   86: aload 6
    //   88: invokevirtual 46	rx/subjects/ReplaySubject$UnboundedReplayState:get	()I
    //   91: if_icmpne +43 -> 134
    //   94: aload_1
    //   95: iconst_0
    //   96: putfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   99: aload_1
    //   100: monitorexit
    //   101: return
    //   102: iload_2
    //   103: istore_3
    //   104: aload_1
    //   105: monitorexit
    //   106: aload 6
    //   108: athrow
    //   109: astore 6
    //   111: iload_2
    //   112: ifne +12 -> 124
    //   115: aload_1
    //   116: monitorenter
    //   117: aload_1
    //   118: iconst_0
    //   119: putfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   122: aload_1
    //   123: monitorexit
    //   124: aload 6
    //   126: athrow
    //   127: astore 6
    //   129: aload_1
    //   130: monitorexit
    //   131: aload 6
    //   133: athrow
    //   134: aload_1
    //   135: monitorexit
    //   136: goto -95 -> 41
    //   139: astore 6
    //   141: iconst_0
    //   142: istore_2
    //   143: goto -41 -> 102
    //   146: astore 6
    //   148: aload_1
    //   149: monitorexit
    //   150: aload 6
    //   152: athrow
    //   153: astore 6
    //   155: goto -44 -> 111
    //   158: astore 6
    //   160: iload_3
    //   161: istore_2
    //   162: goto -60 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	2
    //   0	165	1	paramSubjectObserver	SubjectSubscriptionManager.SubjectObserver<T>
    //   3	159	2	i	int
    //   1	160	3	j	int
    //   51	20	4	k	int
    //   58	34	5	m	int
    //   39	68	6	localUnboundedReplayState	ReplaySubject.UnboundedReplayState
    //   109	16	6	localObject1	Object
    //   127	5	6	localObject2	Object
    //   139	1	6	localObject3	Object
    //   146	5	6	localObject4	Object
    //   153	1	6	localObject5	Object
    //   158	1	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   106	109	109	finally
    //   6	20	127	finally
    //   20	22	127	finally
    //   23	35	127	finally
    //   129	131	127	finally
    //   84	99	139	finally
    //   134	136	139	finally
    //   117	124	146	finally
    //   148	150	146	finally
    //   35	41	153	finally
    //   41	60	153	finally
    //   67	82	153	finally
    //   82	84	153	finally
    //   99	101	158	finally
    //   104	106	158	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.subjects.ReplaySubject.2
 * JD-Core Version:    0.7.0.1
 */