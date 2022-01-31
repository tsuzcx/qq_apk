package rx.subjects;

import rx.functions.Action1;

final class ReplaySubject$4
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  ReplaySubject$4(ReplaySubject.BoundedState paramBoundedState) {}
  
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
    //   35: aload_1
    //   36: invokevirtual 35	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	()Ljava/lang/Object;
    //   39: checkcast 37	rx/subjects/ReplaySubject$NodeList$Node
    //   42: astore 4
    //   44: aload_0
    //   45: getfield 13	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
    //   48: invokevirtual 43	rx/subjects/ReplaySubject$BoundedState:tail	()Lrx/subjects/ReplaySubject$NodeList$Node;
    //   51: astore 5
    //   53: aload 4
    //   55: aload 5
    //   57: if_acmpeq +17 -> 74
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 13	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
    //   65: aload 4
    //   67: aload_1
    //   68: invokevirtual 47	rx/subjects/ReplaySubject$BoundedState:replayObserverFromIndex	(Lrx/subjects/ReplaySubject$NodeList$Node;Lrx/subjects/SubjectSubscriptionManager$SubjectObserver;)Lrx/subjects/ReplaySubject$NodeList$Node;
    //   71: invokevirtual 49	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	(Ljava/lang/Object;)V
    //   74: aload_1
    //   75: monitorenter
    //   76: aload 5
    //   78: aload_0
    //   79: getfield 13	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
    //   82: invokevirtual 43	rx/subjects/ReplaySubject$BoundedState:tail	()Lrx/subjects/ReplaySubject$NodeList$Node;
    //   85: if_acmpne +43 -> 128
    //   88: aload_1
    //   89: iconst_0
    //   90: putfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   93: aload_1
    //   94: monitorexit
    //   95: return
    //   96: iload_2
    //   97: istore_3
    //   98: aload_1
    //   99: monitorexit
    //   100: aload 4
    //   102: athrow
    //   103: astore 4
    //   105: iload_2
    //   106: ifne +12 -> 118
    //   109: aload_1
    //   110: monitorenter
    //   111: aload_1
    //   112: iconst_0
    //   113: putfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   116: aload_1
    //   117: monitorexit
    //   118: aload 4
    //   120: athrow
    //   121: astore 4
    //   123: aload_1
    //   124: monitorexit
    //   125: aload 4
    //   127: athrow
    //   128: aload_1
    //   129: monitorexit
    //   130: goto -95 -> 35
    //   133: astore 4
    //   135: iconst_0
    //   136: istore_2
    //   137: goto -41 -> 96
    //   140: astore 4
    //   142: aload_1
    //   143: monitorexit
    //   144: aload 4
    //   146: athrow
    //   147: astore 4
    //   149: goto -44 -> 105
    //   152: astore 4
    //   154: iload_3
    //   155: istore_2
    //   156: goto -60 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	4
    //   0	159	1	paramSubjectObserver	SubjectSubscriptionManager.SubjectObserver<T>
    //   3	153	2	i	int
    //   1	154	3	j	int
    //   42	59	4	localNode1	ReplaySubject.NodeList.Node
    //   103	16	4	localObject1	Object
    //   121	5	4	localObject2	Object
    //   133	1	4	localObject3	Object
    //   140	5	4	localObject4	Object
    //   147	1	4	localObject5	Object
    //   152	1	4	localObject6	Object
    //   51	26	5	localNode2	ReplaySubject.NodeList.Node
    // Exception table:
    //   from	to	target	type
    //   100	103	103	finally
    //   6	20	121	finally
    //   20	22	121	finally
    //   23	35	121	finally
    //   123	125	121	finally
    //   76	93	133	finally
    //   128	130	133	finally
    //   111	118	140	finally
    //   142	144	140	finally
    //   35	53	147	finally
    //   60	74	147	finally
    //   74	76	147	finally
    //   93	95	152	finally
    //   98	100	152	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.subjects.ReplaySubject.4
 * JD-Core Version:    0.7.0.1
 */