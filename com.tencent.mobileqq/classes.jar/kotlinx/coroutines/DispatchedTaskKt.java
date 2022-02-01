package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class DispatchedTaskKt
{
  public static final int MODE_ATOMIC_DEFAULT = 0;
  public static final int MODE_CANCELLABLE = 1;
  public static final int MODE_UNDISPATCHED = 2;
  
  public static final <T> void dispatch(@NotNull DispatchedTask<? super T> paramDispatchedTask, int paramInt)
  {
    Object localObject = paramDispatchedTask.getDelegate$kotlinx_coroutines_core();
    if ((isDispatchedMode(paramInt)) && ((localObject instanceof DispatchedContinuation)) && (isCancellableMode(paramInt) == isCancellableMode(paramDispatchedTask.resumeMode)))
    {
      CoroutineDispatcher localCoroutineDispatcher = ((DispatchedContinuation)localObject).dispatcher;
      localObject = ((Continuation)localObject).getContext();
      if (localCoroutineDispatcher.isDispatchNeeded((CoroutineContext)localObject))
      {
        localCoroutineDispatcher.dispatch((CoroutineContext)localObject, (Runnable)paramDispatchedTask);
        return;
      }
      resumeUnconfined(paramDispatchedTask);
      return;
    }
    resume(paramDispatchedTask, (Continuation)localObject, paramInt);
  }
  
  public static final boolean isCancellableMode(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static final boolean isDispatchedMode(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static final <T> void resume(@NotNull DispatchedTask<? super T> paramDispatchedTask, @NotNull Continuation<? super T> paramContinuation, int paramInt)
  {
    Object localObject2 = paramDispatchedTask.takeState$kotlinx_coroutines_core();
    Object localObject1 = paramDispatchedTask.getExceptionalResult$kotlinx_coroutines_core(localObject2);
    if (localObject1 != null)
    {
      paramDispatchedTask = (DispatchedTask<? super T>)localObject1;
      if (DebugKt.getRECOVER_STACK_TRACES()) {
        if (!(paramContinuation instanceof CoroutineStackFrame)) {
          paramDispatchedTask = (DispatchedTask<? super T>)localObject1;
        } else {
          paramDispatchedTask = StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)localObject1, (CoroutineStackFrame)paramContinuation);
        }
      }
    }
    else
    {
      paramDispatchedTask = null;
    }
    if (paramDispatchedTask != null)
    {
      localObject1 = Result.Companion;
      paramDispatchedTask = Result.constructor-impl(ResultKt.createFailure(paramDispatchedTask));
    }
    else
    {
      paramDispatchedTask = Result.Companion;
      paramDispatchedTask = Result.constructor-impl(localObject2);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          if (paramContinuation != null)
          {
            localObject2 = (DispatchedContinuation)paramContinuation;
            paramContinuation = ((DispatchedContinuation)localObject2).getContext();
            localObject1 = ThreadContextKt.updateThreadContext(paramContinuation, ((DispatchedContinuation)localObject2).countOrElement);
            try
            {
              ((DispatchedContinuation)localObject2).continuation.resumeWith(paramDispatchedTask);
              paramDispatchedTask = Unit.INSTANCE;
              return;
            }
            finally
            {
              ThreadContextKt.restoreThreadContext(paramContinuation, localObject1);
            }
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
        }
        paramDispatchedTask = new StringBuilder();
        paramDispatchedTask.append("Invalid mode ");
        paramDispatchedTask.append(paramInt);
        throw ((Throwable)new IllegalStateException(paramDispatchedTask.toString().toString()));
      }
      DispatchedContinuationKt.resumeCancellableWith(paramContinuation, paramDispatchedTask);
      return;
    }
    paramContinuation.resumeWith(paramDispatchedTask);
  }
  
  /* Error */
  private static final void resumeUnconfined(@NotNull DispatchedTask<?> paramDispatchedTask)
  {
    // Byte code:
    //   0: getstatic 204	kotlinx/coroutines/ThreadLocalEventLoop:INSTANCE	Lkotlinx/coroutines/ThreadLocalEventLoop;
    //   3: invokevirtual 208	kotlinx/coroutines/ThreadLocalEventLoop:getEventLoop$kotlinx_coroutines_core	()Lkotlinx/coroutines/EventLoop;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 213	kotlinx/coroutines/EventLoop:isUnconfinedLoopActive	()Z
    //   11: ifeq +9 -> 20
    //   14: aload_2
    //   15: aload_0
    //   16: invokevirtual 216	kotlinx/coroutines/EventLoop:dispatchUnconfined	(Lkotlinx/coroutines/DispatchedTask;)V
    //   19: return
    //   20: aload_2
    //   21: iconst_1
    //   22: invokevirtual 220	kotlinx/coroutines/EventLoop:incrementUseCount	(Z)V
    //   25: aload_0
    //   26: aload_0
    //   27: invokevirtual 56	kotlinx/coroutines/DispatchedTask:getDelegate$kotlinx_coroutines_core	()Lkotlin/coroutines/Continuation;
    //   30: iconst_2
    //   31: invokestatic 92	kotlinx/coroutines/DispatchedTaskKt:resume	(Lkotlinx/coroutines/DispatchedTask;Lkotlin/coroutines/Continuation;I)V
    //   34: aload_2
    //   35: invokevirtual 223	kotlinx/coroutines/EventLoop:processUnconfinedEvent	()Z
    //   38: istore_1
    //   39: iload_1
    //   40: ifne -6 -> 34
    //   43: goto +14 -> 57
    //   46: astore_0
    //   47: goto +16 -> 63
    //   50: astore_3
    //   51: aload_0
    //   52: aload_3
    //   53: aconst_null
    //   54: invokevirtual 227	kotlinx/coroutines/DispatchedTask:handleFatalException$kotlinx_coroutines_core	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   57: aload_2
    //   58: iconst_1
    //   59: invokevirtual 230	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   62: return
    //   63: aload_2
    //   64: iconst_1
    //   65: invokevirtual 230	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   68: goto +5 -> 73
    //   71: aload_0
    //   72: athrow
    //   73: goto -2 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramDispatchedTask	DispatchedTask<?>
    //   38	2	1	bool	boolean
    //   6	58	2	localEventLoop	EventLoop
    //   50	3	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   25	34	46	finally
    //   34	39	46	finally
    //   51	57	46	finally
    //   25	34	50	java/lang/Throwable
    //   34	39	50	java/lang/Throwable
  }
  
  public static final void resumeWithStackTrace(@NotNull Continuation<?> paramContinuation, @NotNull Throwable paramThrowable)
  {
    Object localObject = Result.Companion;
    localObject = paramThrowable;
    if (DebugKt.getRECOVER_STACK_TRACES()) {
      if (!(paramContinuation instanceof CoroutineStackFrame)) {
        localObject = paramThrowable;
      } else {
        localObject = StackTraceRecoveryKt.access$recoverFromStackFrame(paramThrowable, (CoroutineStackFrame)paramContinuation);
      }
    }
    paramContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject)));
  }
  
  /* Error */
  public static final void runUnconfinedEventLoop(@NotNull DispatchedTask<?> paramDispatchedTask, @NotNull EventLoop paramEventLoop, @NotNull kotlin.jvm.functions.Function0<Unit> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: invokevirtual 220	kotlinx/coroutines/EventLoop:incrementUseCount	(Z)V
    //   5: aload_2
    //   6: invokeinterface 239 1 0
    //   11: pop
    //   12: aload_1
    //   13: invokevirtual 223	kotlinx/coroutines/EventLoop:processUnconfinedEvent	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifne -6 -> 12
    //   21: iconst_1
    //   22: invokestatic 245	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   25: goto +18 -> 43
    //   28: astore_0
    //   29: goto +24 -> 53
    //   32: astore_2
    //   33: aload_0
    //   34: aload_2
    //   35: aconst_null
    //   36: invokevirtual 227	kotlinx/coroutines/DispatchedTask:handleFatalException$kotlinx_coroutines_core	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   39: iconst_1
    //   40: invokestatic 245	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   43: aload_1
    //   44: iconst_1
    //   45: invokevirtual 230	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   48: iconst_1
    //   49: invokestatic 248	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   52: return
    //   53: iconst_1
    //   54: invokestatic 245	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   57: aload_1
    //   58: iconst_1
    //   59: invokevirtual 230	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   62: iconst_1
    //   63: invokestatic 248	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   66: goto +5 -> 71
    //   69: aload_0
    //   70: athrow
    //   71: goto -2 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramDispatchedTask	DispatchedTask<?>
    //   0	74	1	paramEventLoop	EventLoop
    //   0	74	2	paramFunction0	kotlin.jvm.functions.Function0<Unit>
    //   16	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	28	finally
    //   12	17	28	finally
    //   33	39	28	finally
    //   5	12	32	java/lang/Throwable
    //   12	17	32	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DispatchedTaskKt
 * JD-Core Version:    0.7.0.1
 */