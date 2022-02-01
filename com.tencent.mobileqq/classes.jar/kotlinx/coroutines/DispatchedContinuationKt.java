package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED$annotations", "()V", "UNDEFINED", "UNDEFINED$annotations", "executeUnconfined", "", "Lkotlinx/coroutines/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class DispatchedContinuationKt
{
  @JvmField
  @NotNull
  public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");
  private static final Symbol UNDEFINED = new Symbol("UNDEFINED");
  
  /* Error */
  private static final boolean executeUnconfined(@NotNull DispatchedContinuation<?> paramDispatchedContinuation, Object paramObject, int paramInt, boolean paramBoolean, kotlin.jvm.functions.Function0<kotlin.Unit> paramFunction0)
  {
    // Byte code:
    //   0: getstatic 65	kotlinx/coroutines/ThreadLocalEventLoop:INSTANCE	Lkotlinx/coroutines/ThreadLocalEventLoop;
    //   3: invokevirtual 69	kotlinx/coroutines/ThreadLocalEventLoop:getEventLoop$kotlinx_coroutines_core	()Lkotlinx/coroutines/EventLoop;
    //   6: astore 5
    //   8: iload_3
    //   9: ifeq +13 -> 22
    //   12: aload 5
    //   14: invokevirtual 75	kotlinx/coroutines/EventLoop:isUnconfinedQueueEmpty	()Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload 5
    //   24: invokevirtual 78	kotlinx/coroutines/EventLoop:isUnconfinedLoopActive	()Z
    //   27: ifeq +24 -> 51
    //   30: aload_0
    //   31: aload_1
    //   32: putfield 84	kotlinx/coroutines/DispatchedContinuation:_state	Ljava/lang/Object;
    //   35: aload_0
    //   36: iload_2
    //   37: putfield 88	kotlinx/coroutines/DispatchedContinuation:resumeMode	I
    //   40: aload 5
    //   42: aload_0
    //   43: checkcast 90	kotlinx/coroutines/DispatchedTask
    //   46: invokevirtual 94	kotlinx/coroutines/EventLoop:dispatchUnconfined	(Lkotlinx/coroutines/DispatchedTask;)V
    //   49: iconst_1
    //   50: ireturn
    //   51: aload_0
    //   52: checkcast 90	kotlinx/coroutines/DispatchedTask
    //   55: astore_0
    //   56: aload 5
    //   58: iconst_1
    //   59: invokevirtual 98	kotlinx/coroutines/EventLoop:incrementUseCount	(Z)V
    //   62: aload 4
    //   64: invokeinterface 104 1 0
    //   69: pop
    //   70: aload 5
    //   72: invokevirtual 107	kotlinx/coroutines/EventLoop:processUnconfinedEvent	()Z
    //   75: istore_3
    //   76: iload_3
    //   77: ifne -7 -> 70
    //   80: iconst_1
    //   81: invokestatic 113	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   84: goto +18 -> 102
    //   87: astore_0
    //   88: goto +26 -> 114
    //   91: astore_1
    //   92: aload_0
    //   93: aload_1
    //   94: aconst_null
    //   95: invokevirtual 117	kotlinx/coroutines/DispatchedTask:handleFatalException$kotlinx_coroutines_core	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   98: iconst_1
    //   99: invokestatic 113	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   102: aload 5
    //   104: iconst_1
    //   105: invokevirtual 120	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   108: iconst_1
    //   109: invokestatic 123	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: iconst_1
    //   115: invokestatic 113	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   118: aload 5
    //   120: iconst_1
    //   121: invokevirtual 120	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   124: iconst_1
    //   125: invokestatic 123	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   128: goto +5 -> 133
    //   131: aload_0
    //   132: athrow
    //   133: goto -2 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramDispatchedContinuation	DispatchedContinuation<?>
    //   0	136	1	paramObject	Object
    //   0	136	2	paramInt	int
    //   0	136	3	paramBoolean	boolean
    //   0	136	4	paramFunction0	kotlin.jvm.functions.Function0<kotlin.Unit>
    //   6	113	5	localEventLoop	EventLoop
    // Exception table:
    //   from	to	target	type
    //   62	70	87	finally
    //   70	76	87	finally
    //   92	98	87	finally
    //   62	70	91	java/lang/Throwable
    //   70	76	91	java/lang/Throwable
  }
  
  /* Error */
  @InternalCoroutinesApi
  public static final <T> void resumeCancellableWith(@NotNull kotlin.coroutines.Continuation<? super T> paramContinuation, @NotNull Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 80
    //   4: ifeq +280 -> 284
    //   7: aload_0
    //   8: checkcast 80	kotlinx/coroutines/DispatchedContinuation
    //   11: astore 5
    //   13: aload_1
    //   14: invokestatic 135	kotlinx/coroutines/CompletedExceptionallyKt:toState	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore 4
    //   19: aload 5
    //   21: getfield 139	kotlinx/coroutines/DispatchedContinuation:dispatcher	Lkotlinx/coroutines/CoroutineDispatcher;
    //   24: aload 5
    //   26: invokevirtual 143	kotlinx/coroutines/DispatchedContinuation:getContext	()Lkotlin/coroutines/CoroutineContext;
    //   29: invokevirtual 149	kotlinx/coroutines/CoroutineDispatcher:isDispatchNeeded	(Lkotlin/coroutines/CoroutineContext;)Z
    //   32: ifeq +35 -> 67
    //   35: aload 5
    //   37: aload 4
    //   39: putfield 84	kotlinx/coroutines/DispatchedContinuation:_state	Ljava/lang/Object;
    //   42: aload 5
    //   44: iconst_1
    //   45: putfield 88	kotlinx/coroutines/DispatchedContinuation:resumeMode	I
    //   48: aload 5
    //   50: getfield 139	kotlinx/coroutines/DispatchedContinuation:dispatcher	Lkotlinx/coroutines/CoroutineDispatcher;
    //   53: aload 5
    //   55: invokevirtual 143	kotlinx/coroutines/DispatchedContinuation:getContext	()Lkotlin/coroutines/CoroutineContext;
    //   58: aload 5
    //   60: checkcast 151	java/lang/Runnable
    //   63: invokevirtual 155	kotlinx/coroutines/CoroutineDispatcher:dispatch	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V
    //   66: return
    //   67: getstatic 65	kotlinx/coroutines/ThreadLocalEventLoop:INSTANCE	Lkotlinx/coroutines/ThreadLocalEventLoop;
    //   70: invokevirtual 69	kotlinx/coroutines/ThreadLocalEventLoop:getEventLoop$kotlinx_coroutines_core	()Lkotlinx/coroutines/EventLoop;
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 78	kotlinx/coroutines/EventLoop:isUnconfinedLoopActive	()Z
    //   78: ifeq +26 -> 104
    //   81: aload 5
    //   83: aload 4
    //   85: putfield 84	kotlinx/coroutines/DispatchedContinuation:_state	Ljava/lang/Object;
    //   88: aload 5
    //   90: iconst_1
    //   91: putfield 88	kotlinx/coroutines/DispatchedContinuation:resumeMode	I
    //   94: aload_0
    //   95: aload 5
    //   97: checkcast 90	kotlinx/coroutines/DispatchedTask
    //   100: invokevirtual 94	kotlinx/coroutines/EventLoop:dispatchUnconfined	(Lkotlinx/coroutines/DispatchedTask;)V
    //   103: return
    //   104: aload 5
    //   106: checkcast 90	kotlinx/coroutines/DispatchedTask
    //   109: astore 4
    //   111: aload_0
    //   112: iconst_1
    //   113: invokevirtual 98	kotlinx/coroutines/EventLoop:incrementUseCount	(Z)V
    //   116: aload 5
    //   118: invokevirtual 143	kotlinx/coroutines/DispatchedContinuation:getContext	()Lkotlin/coroutines/CoroutineContext;
    //   121: getstatic 161	kotlinx/coroutines/Job:Key	Lkotlinx/coroutines/Job$Key;
    //   124: checkcast 163	kotlin/coroutines/CoroutineContext$Key
    //   127: invokeinterface 169 2 0
    //   132: checkcast 157	kotlinx/coroutines/Job
    //   135: astore 6
    //   137: aload 6
    //   139: ifnull +153 -> 292
    //   142: aload 6
    //   144: invokeinterface 172 1 0
    //   149: ifne +143 -> 292
    //   152: aload 6
    //   154: invokeinterface 176 1 0
    //   159: checkcast 59	java/lang/Throwable
    //   162: astore 6
    //   164: getstatic 182	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   167: astore 7
    //   169: aload 5
    //   171: aload 6
    //   173: invokestatic 188	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   176: invokestatic 191	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   179: invokeinterface 197 2 0
    //   184: iconst_1
    //   185: istore_2
    //   186: goto +3 -> 189
    //   189: iload_2
    //   190: ifne +57 -> 247
    //   193: aload 5
    //   195: invokevirtual 143	kotlinx/coroutines/DispatchedContinuation:getContext	()Lkotlin/coroutines/CoroutineContext;
    //   198: astore 6
    //   200: aload 6
    //   202: aload 5
    //   204: getfield 200	kotlinx/coroutines/DispatchedContinuation:countOrElement	Ljava/lang/Object;
    //   207: invokestatic 206	kotlinx/coroutines/internal/ThreadContextKt:updateThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Ljava/lang/Object;
    //   210: astore 7
    //   212: aload 5
    //   214: getfield 209	kotlinx/coroutines/DispatchedContinuation:continuation	Lkotlin/coroutines/Continuation;
    //   217: aload_1
    //   218: invokeinterface 197 2 0
    //   223: getstatic 214	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   226: astore_1
    //   227: aload 6
    //   229: aload 7
    //   231: invokestatic 218	kotlinx/coroutines/internal/ThreadContextKt:restoreThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V
    //   234: goto +13 -> 247
    //   237: astore_1
    //   238: aload 6
    //   240: aload 7
    //   242: invokestatic 218	kotlinx/coroutines/internal/ThreadContextKt:restoreThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V
    //   245: aload_1
    //   246: athrow
    //   247: aload_0
    //   248: invokevirtual 107	kotlinx/coroutines/EventLoop:processUnconfinedEvent	()Z
    //   251: istore_3
    //   252: iload_3
    //   253: ifne -6 -> 247
    //   256: goto +15 -> 271
    //   259: astore_1
    //   260: goto +17 -> 277
    //   263: astore_1
    //   264: aload 4
    //   266: aload_1
    //   267: aconst_null
    //   268: invokevirtual 117	kotlinx/coroutines/DispatchedTask:handleFatalException$kotlinx_coroutines_core	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   271: aload_0
    //   272: iconst_1
    //   273: invokevirtual 120	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   276: return
    //   277: aload_0
    //   278: iconst_1
    //   279: invokevirtual 120	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   282: aload_1
    //   283: athrow
    //   284: aload_0
    //   285: aload_1
    //   286: invokeinterface 197 2 0
    //   291: return
    //   292: iconst_0
    //   293: istore_2
    //   294: goto -105 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramContinuation	kotlin.coroutines.Continuation<? super T>
    //   0	297	1	paramObject	Object
    //   185	109	2	i	int
    //   251	2	3	bool	boolean
    //   17	248	4	localObject1	Object
    //   11	202	5	localDispatchedContinuation	DispatchedContinuation
    //   135	104	6	localObject2	Object
    //   167	74	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   212	227	237	finally
    //   116	137	259	finally
    //   142	184	259	finally
    //   193	212	259	finally
    //   227	234	259	finally
    //   238	247	259	finally
    //   247	252	259	finally
    //   264	271	259	finally
    //   116	137	263	java/lang/Throwable
    //   142	184	263	java/lang/Throwable
    //   193	212	263	java/lang/Throwable
    //   227	234	263	java/lang/Throwable
    //   238	247	263	java/lang/Throwable
    //   247	252	263	java/lang/Throwable
  }
  
  /* Error */
  public static final boolean yieldUndispatched(@NotNull DispatchedContinuation<? super kotlin.Unit> paramDispatchedContinuation)
  {
    // Byte code:
    //   0: getstatic 214	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   3: astore_3
    //   4: getstatic 65	kotlinx/coroutines/ThreadLocalEventLoop:INSTANCE	Lkotlinx/coroutines/ThreadLocalEventLoop;
    //   7: invokevirtual 69	kotlinx/coroutines/ThreadLocalEventLoop:getEventLoop$kotlinx_coroutines_core	()Lkotlinx/coroutines/EventLoop;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 75	kotlinx/coroutines/EventLoop:isUnconfinedQueueEmpty	()Z
    //   15: ifeq +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_2
    //   21: invokevirtual 78	kotlinx/coroutines/EventLoop:isUnconfinedLoopActive	()Z
    //   24: ifeq +23 -> 47
    //   27: aload_0
    //   28: aload_3
    //   29: putfield 84	kotlinx/coroutines/DispatchedContinuation:_state	Ljava/lang/Object;
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 88	kotlinx/coroutines/DispatchedContinuation:resumeMode	I
    //   37: aload_2
    //   38: aload_0
    //   39: checkcast 90	kotlinx/coroutines/DispatchedTask
    //   42: invokevirtual 94	kotlinx/coroutines/EventLoop:dispatchUnconfined	(Lkotlinx/coroutines/DispatchedTask;)V
    //   45: iconst_1
    //   46: ireturn
    //   47: aload_0
    //   48: checkcast 90	kotlinx/coroutines/DispatchedTask
    //   51: astore_3
    //   52: aload_2
    //   53: iconst_1
    //   54: invokevirtual 98	kotlinx/coroutines/EventLoop:incrementUseCount	(Z)V
    //   57: aload_0
    //   58: invokevirtual 224	kotlinx/coroutines/DispatchedContinuation:run	()V
    //   61: aload_2
    //   62: invokevirtual 107	kotlinx/coroutines/EventLoop:processUnconfinedEvent	()Z
    //   65: istore_1
    //   66: iload_1
    //   67: ifne -6 -> 61
    //   70: goto +14 -> 84
    //   73: astore_0
    //   74: goto +17 -> 91
    //   77: astore_0
    //   78: aload_3
    //   79: aload_0
    //   80: aconst_null
    //   81: invokevirtual 117	kotlinx/coroutines/DispatchedTask:handleFatalException$kotlinx_coroutines_core	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   84: aload_2
    //   85: iconst_1
    //   86: invokevirtual 120	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   89: iconst_0
    //   90: ireturn
    //   91: aload_2
    //   92: iconst_1
    //   93: invokevirtual 120	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   96: goto +5 -> 101
    //   99: aload_0
    //   100: athrow
    //   101: goto -2 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramDispatchedContinuation	DispatchedContinuation<? super kotlin.Unit>
    //   65	2	1	bool	boolean
    //   10	82	2	localEventLoop	EventLoop
    //   3	76	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   57	61	73	finally
    //   61	66	73	finally
    //   78	84	73	finally
    //   57	61	77	java/lang/Throwable
    //   61	66	77	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DispatchedContinuationKt
 * JD-Core Version:    0.7.0.1
 */