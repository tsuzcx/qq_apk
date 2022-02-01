package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.Task;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelResult", "", "state", "", "cause", "", "cancelResult$kotlinx_coroutines_core", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class DispatchedTask<T>
  extends Task
{
  @JvmField
  public int resumeMode;
  
  public DispatchedTask(int paramInt)
  {
    this.resumeMode = paramInt;
  }
  
  public void cancelResult$kotlinx_coroutines_core(@Nullable Object paramObject, @NotNull Throwable paramThrowable) {}
  
  @NotNull
  public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();
  
  @Nullable
  public final Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object paramObject)
  {
    boolean bool = paramObject instanceof CompletedExceptionally;
    Object localObject = null;
    if (!bool) {
      paramObject = null;
    }
    CompletedExceptionally localCompletedExceptionally = (CompletedExceptionally)paramObject;
    paramObject = localObject;
    if (localCompletedExceptionally != null) {
      paramObject = localCompletedExceptionally.cause;
    }
    return paramObject;
  }
  
  public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object paramObject)
  {
    return paramObject;
  }
  
  public final void handleFatalException$kotlinx_coroutines_core(@Nullable Throwable paramThrowable1, @Nullable Throwable paramThrowable2)
  {
    if ((paramThrowable1 == null) && (paramThrowable2 == null)) {
      return;
    }
    if ((paramThrowable1 != null) && (paramThrowable2 != null)) {
      ExceptionsKt.addSuppressed(paramThrowable1, paramThrowable2);
    }
    if (paramThrowable1 == null) {
      paramThrowable1 = paramThrowable2;
    }
    paramThrowable2 = new StringBuilder();
    paramThrowable2.append("Fatal exception in coroutines machinery for ");
    paramThrowable2.append(this);
    paramThrowable2.append(". ");
    paramThrowable2.append("Please read KDoc to 'handleFatalException' method and report this incident to maintainers");
    paramThrowable2 = paramThrowable2.toString();
    if (paramThrowable1 == null) {
      Intrinsics.throwNpe();
    }
    paramThrowable1 = new CoroutinesInternalError(paramThrowable2, paramThrowable1);
    CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), (Throwable)paramThrowable1);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	kotlinx/coroutines/DispatchedTask:taskContext	Lkotlinx/coroutines/scheduling/TaskContext;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_1
    //   7: aconst_null
    //   8: checkcast 112	java/lang/Throwable
    //   11: astore_2
    //   12: aload_0
    //   13: invokevirtual 104	kotlinx/coroutines/DispatchedTask:getDelegate$kotlinx_coroutines_core	()Lkotlin/coroutines/Continuation;
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +293 -> 313
    //   23: aload 4
    //   25: checkcast 124	kotlinx/coroutines/DispatchedContinuation
    //   28: astore 5
    //   30: aload 5
    //   32: getfield 127	kotlinx/coroutines/DispatchedContinuation:continuation	Lkotlin/coroutines/Continuation;
    //   35: astore 6
    //   37: aload 6
    //   39: invokeinterface 110 1 0
    //   44: astore 4
    //   46: aload_0
    //   47: invokevirtual 130	kotlinx/coroutines/DispatchedTask:takeState$kotlinx_coroutines_core	()Ljava/lang/Object;
    //   50: astore 7
    //   52: aload 4
    //   54: aload 5
    //   56: getfield 134	kotlinx/coroutines/DispatchedContinuation:countOrElement	Ljava/lang/Object;
    //   59: invokestatic 140	kotlinx/coroutines/internal/ThreadContextKt:updateThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: astore 5
    //   64: aload_0
    //   65: aload 7
    //   67: invokevirtual 142	kotlinx/coroutines/DispatchedTask:getExceptionalResult$kotlinx_coroutines_core	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   70: astore 8
    //   72: aload_0
    //   73: getfield 52	kotlinx/coroutines/DispatchedTask:resumeMode	I
    //   76: invokestatic 148	kotlinx/coroutines/DispatchedTaskKt:isCancellableMode	(I)Z
    //   79: ifeq +20 -> 99
    //   82: aload 4
    //   84: getstatic 154	kotlinx/coroutines/Job:Key	Lkotlinx/coroutines/Job$Key;
    //   87: checkcast 156	kotlin/coroutines/CoroutineContext$Key
    //   90: invokeinterface 162 2 0
    //   95: checkcast 150	kotlinx/coroutines/Job
    //   98: astore_1
    //   99: aload 8
    //   101: ifnonnull +93 -> 194
    //   104: aload_1
    //   105: ifnull +89 -> 194
    //   108: aload_1
    //   109: invokeinterface 166 1 0
    //   114: ifne +80 -> 194
    //   117: aload_1
    //   118: invokeinterface 170 1 0
    //   123: astore_1
    //   124: aload_0
    //   125: aload 7
    //   127: aload_1
    //   128: checkcast 112	java/lang/Throwable
    //   131: invokevirtual 172	kotlinx/coroutines/DispatchedTask:cancelResult$kotlinx_coroutines_core	(Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   134: getstatic 178	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   137: astore 7
    //   139: invokestatic 183	kotlinx/coroutines/DebugKt:getRECOVER_STACK_TRACES	()Z
    //   142: ifeq +30 -> 172
    //   145: aload 6
    //   147: instanceof 185
    //   150: ifne +6 -> 156
    //   153: goto +19 -> 172
    //   156: aload_1
    //   157: checkcast 112	java/lang/Throwable
    //   160: aload 6
    //   162: checkcast 185	kotlin/coroutines/jvm/internal/CoroutineStackFrame
    //   165: invokestatic 191	kotlinx/coroutines/internal/StackTraceRecoveryKt:access$recoverFromStackFrame	(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;
    //   168: astore_1
    //   169: goto +8 -> 177
    //   172: aload_1
    //   173: checkcast 112	java/lang/Throwable
    //   176: astore_1
    //   177: aload 6
    //   179: aload_1
    //   180: invokestatic 197	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   183: invokestatic 200	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   186: invokeinterface 204 2 0
    //   191: goto +53 -> 244
    //   194: aload 8
    //   196: ifnull +25 -> 221
    //   199: getstatic 178	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   202: astore_1
    //   203: aload 6
    //   205: aload 8
    //   207: invokestatic 197	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   210: invokestatic 200	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   213: invokeinterface 204 2 0
    //   218: goto +26 -> 244
    //   221: aload_0
    //   222: aload 7
    //   224: invokevirtual 206	kotlinx/coroutines/DispatchedTask:getSuccessfulResult$kotlinx_coroutines_core	(Ljava/lang/Object;)Ljava/lang/Object;
    //   227: astore_1
    //   228: getstatic 178	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   231: astore 7
    //   233: aload 6
    //   235: aload_1
    //   236: invokestatic 200	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   239: invokeinterface 204 2 0
    //   244: getstatic 212	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   247: astore_1
    //   248: aload 4
    //   250: aload 5
    //   252: invokestatic 216	kotlinx/coroutines/internal/ThreadContextKt:restoreThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V
    //   255: getstatic 178	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   258: astore_1
    //   259: aload_0
    //   260: checkcast 2	kotlinx/coroutines/DispatchedTask
    //   263: astore_1
    //   264: aload_3
    //   265: invokeinterface 221 1 0
    //   270: getstatic 212	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   273: invokestatic 200	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   276: astore_1
    //   277: goto +16 -> 293
    //   280: astore_1
    //   281: getstatic 178	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   284: astore_3
    //   285: aload_1
    //   286: invokestatic 197	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   289: invokestatic 200	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   292: astore_1
    //   293: aload_0
    //   294: aload_2
    //   295: aload_1
    //   296: invokestatic 224	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   299: invokevirtual 226	kotlinx/coroutines/DispatchedTask:handleFatalException$kotlinx_coroutines_core	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   302: return
    //   303: astore_1
    //   304: aload 4
    //   306: aload 5
    //   308: invokestatic 216	kotlinx/coroutines/internal/ThreadContextKt:restoreThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V
    //   311: aload_1
    //   312: athrow
    //   313: new 228	kotlin/TypeCastException
    //   316: dup
    //   317: ldc 230
    //   319: invokespecial 233	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   322: athrow
    //   323: astore 4
    //   325: getstatic 178	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   328: astore_1
    //   329: aload_0
    //   330: checkcast 2	kotlinx/coroutines/DispatchedTask
    //   333: astore_1
    //   334: aload_3
    //   335: invokeinterface 221 1 0
    //   340: getstatic 212	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   343: invokestatic 200	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   346: astore_1
    //   347: goto +16 -> 363
    //   350: astore_1
    //   351: getstatic 178	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   354: astore_3
    //   355: aload_1
    //   356: invokestatic 197	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   359: invokestatic 200	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   362: astore_1
    //   363: aload_0
    //   364: aload_2
    //   365: aload_1
    //   366: invokestatic 224	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   369: invokevirtual 226	kotlinx/coroutines/DispatchedTask:handleFatalException$kotlinx_coroutines_core	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   372: aload 4
    //   374: athrow
    //   375: astore_2
    //   376: getstatic 178	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   379: astore_1
    //   380: aload_0
    //   381: checkcast 2	kotlinx/coroutines/DispatchedTask
    //   384: astore_1
    //   385: aload_3
    //   386: invokeinterface 221 1 0
    //   391: getstatic 212	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   394: invokestatic 200	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   397: astore_1
    //   398: goto +16 -> 414
    //   401: astore_1
    //   402: getstatic 178	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   405: astore_3
    //   406: aload_1
    //   407: invokestatic 197	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   410: invokestatic 200	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   413: astore_1
    //   414: aload_0
    //   415: aload_2
    //   416: aload_1
    //   417: invokestatic 224	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   420: invokevirtual 226	kotlinx/coroutines/DispatchedTask:handleFatalException$kotlinx_coroutines_core	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   423: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	DispatchedTask
    //   6	271	1	localObject1	Object
    //   280	6	1	localThrowable1	Throwable
    //   292	4	1	localObject2	Object
    //   303	9	1	localObject3	Object
    //   328	19	1	localObject4	Object
    //   350	6	1	localThrowable2	Throwable
    //   362	36	1	localObject5	Object
    //   401	6	1	localThrowable3	Throwable
    //   413	4	1	localObject6	Object
    //   11	354	2	localThrowable4	Throwable
    //   375	41	2	localThrowable5	Throwable
    //   4	402	3	localObject7	Object
    //   16	289	4	localObject8	Object
    //   323	50	4	localObject9	Object
    //   28	279	5	localObject10	Object
    //   35	199	6	localContinuation	Continuation
    //   50	182	7	localObject11	Object
    //   70	136	8	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   255	277	280	java/lang/Throwable
    //   64	72	303	finally
    //   72	99	303	finally
    //   108	153	303	finally
    //   156	169	303	finally
    //   172	177	303	finally
    //   177	191	303	finally
    //   199	218	303	finally
    //   221	244	303	finally
    //   244	248	303	finally
    //   12	18	323	finally
    //   23	64	323	finally
    //   248	255	323	finally
    //   304	313	323	finally
    //   313	323	323	finally
    //   325	347	350	java/lang/Throwable
    //   12	18	375	java/lang/Throwable
    //   23	64	375	java/lang/Throwable
    //   248	255	375	java/lang/Throwable
    //   304	313	375	java/lang/Throwable
    //   313	323	375	java/lang/Throwable
    //   376	398	401	java/lang/Throwable
  }
  
  @Nullable
  public abstract Object takeState$kotlinx_coroutines_core();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DispatchedTask
 * JD-Core Version:    0.7.0.1
 */