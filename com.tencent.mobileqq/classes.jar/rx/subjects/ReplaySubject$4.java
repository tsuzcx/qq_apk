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
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 28	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
    //   6: ifeq +146 -> 152
    //   9: aload_1
    //   10: getfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   13: ifeq +6 -> 19
    //   16: goto +136 -> 152
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
    //   33: aload_1
    //   34: invokevirtual 35	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	()Ljava/lang/Object;
    //   37: checkcast 37	rx/subjects/ReplaySubject$NodeList$Node
    //   40: astore 4
    //   42: aload_0
    //   43: getfield 13	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
    //   46: invokevirtual 43	rx/subjects/ReplaySubject$BoundedState:tail	()Lrx/subjects/ReplaySubject$NodeList$Node;
    //   49: astore 5
    //   51: aload 4
    //   53: aload 5
    //   55: if_acmpeq +17 -> 72
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 13	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
    //   63: aload 4
    //   65: aload_1
    //   66: invokevirtual 47	rx/subjects/ReplaySubject$BoundedState:replayObserverFromIndex	(Lrx/subjects/ReplaySubject$NodeList$Node;Lrx/subjects/SubjectSubscriptionManager$SubjectObserver;)Lrx/subjects/ReplaySubject$NodeList$Node;
    //   69: invokevirtual 49	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	(Ljava/lang/Object;)V
    //   72: aload_1
    //   73: monitorenter
    //   74: aload 5
    //   76: aload_0
    //   77: getfield 13	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
    //   80: invokevirtual 43	rx/subjects/ReplaySubject$BoundedState:tail	()Lrx/subjects/ReplaySubject$NodeList$Node;
    //   83: if_acmpne +11 -> 94
    //   86: aload_1
    //   87: iconst_0
    //   88: putfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   91: aload_1
    //   92: monitorexit
    //   93: return
    //   94: aload_1
    //   95: monitorexit
    //   96: goto -63 -> 33
    //   99: astore 4
    //   101: iconst_0
    //   102: istore_2
    //   103: iload_2
    //   104: istore_3
    //   105: aload_1
    //   106: monitorexit
    //   107: aload 4
    //   109: athrow
    //   110: astore 4
    //   112: goto +14 -> 126
    //   115: astore 4
    //   117: iload_3
    //   118: istore_2
    //   119: goto -16 -> 103
    //   122: astore 4
    //   124: iconst_0
    //   125: istore_2
    //   126: iload_2
    //   127: ifne +22 -> 149
    //   130: aload_1
    //   131: monitorenter
    //   132: aload_1
    //   133: iconst_0
    //   134: putfield 31	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   137: aload_1
    //   138: monitorexit
    //   139: goto +10 -> 149
    //   142: astore 4
    //   144: aload_1
    //   145: monitorexit
    //   146: aload 4
    //   148: athrow
    //   149: aload 4
    //   151: athrow
    //   152: aload_1
    //   153: monitorexit
    //   154: return
    //   155: astore 4
    //   157: aload_1
    //   158: monitorexit
    //   159: goto +6 -> 165
    //   162: aload 4
    //   164: athrow
    //   165: goto -3 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	4
    //   0	168	1	paramSubjectObserver	SubjectSubscriptionManager.SubjectObserver<T>
    //   102	25	2	i	int
    //   25	93	3	j	int
    //   40	24	4	localNode1	ReplaySubject.NodeList.Node
    //   99	9	4	localObject1	Object
    //   110	1	4	localObject2	Object
    //   115	1	4	localObject3	Object
    //   122	1	4	localObject4	Object
    //   142	8	4	localObject5	Object
    //   155	8	4	localObject6	Object
    //   49	26	5	localNode2	ReplaySubject.NodeList.Node
    // Exception table:
    //   from	to	target	type
    //   74	91	99	finally
    //   94	96	99	finally
    //   107	110	110	finally
    //   91	93	115	finally
    //   105	107	115	finally
    //   33	51	122	finally
    //   58	72	122	finally
    //   72	74	122	finally
    //   132	139	142	finally
    //   144	146	142	finally
    //   2	16	155	finally
    //   19	24	155	finally
    //   26	33	155	finally
    //   152	154	155	finally
    //   157	159	155	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.subjects.ReplaySubject.4
 * JD-Core Version:    0.7.0.1
 */