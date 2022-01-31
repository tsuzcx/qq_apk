package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public abstract class BaseContinuationImpl
  implements Serializable, Continuation<Object>, CoroutineStackFrame
{
  @Nullable
  private final Continuation<Object> completion;
  
  public BaseContinuationImpl(@Nullable Continuation<Object> paramContinuation)
  {
    this.completion = paramContinuation;
  }
  
  @NotNull
  public Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    throw ((Throwable)new UnsupportedOperationException("create(Any?;Continuation) has not been overridden"));
  }
  
  @NotNull
  public Continuation<Unit> create(@NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    throw ((Throwable)new UnsupportedOperationException("create(Continuation) has not been overridden"));
  }
  
  @Nullable
  public CoroutineStackFrame getCallerFrame()
  {
    Continuation localContinuation2 = this.completion;
    Continuation localContinuation1 = localContinuation2;
    if (!(localContinuation2 instanceof CoroutineStackFrame)) {
      localContinuation1 = null;
    }
    return (CoroutineStackFrame)localContinuation1;
  }
  
  @Nullable
  public final Continuation<Object> getCompletion()
  {
    return this.completion;
  }
  
  @Nullable
  public StackTraceElement getStackTraceElement()
  {
    return DebugMetadataKt.getStackTraceElement(this);
  }
  
  @Nullable
  protected abstract Object invokeSuspend(@NotNull Object paramObject);
  
  protected void releaseIntercepted() {}
  
  public final void resumeWith(@NotNull Object paramObject)
  {
    Continuation localContinuation;
    for (BaseContinuationImpl localBaseContinuationImpl = (BaseContinuationImpl)this;; localBaseContinuationImpl = (BaseContinuationImpl)localContinuation)
    {
      DebugProbesKt.probeCoroutineResumed((Continuation)localBaseContinuationImpl);
      localContinuation = localBaseContinuationImpl.completion;
      if (localContinuation == null) {
        Intrinsics.throwNpe();
      }
      try
      {
        paramObject = localBaseContinuationImpl.invokeSuspend(paramObject);
        if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
          return;
        }
        localCompanion = Result.Companion;
        paramObject = Result.constructor-impl(paramObject);
      }
      catch (Throwable paramObject)
      {
        for (;;)
        {
          Result.Companion localCompanion = Result.Companion;
          paramObject = Result.constructor-impl(ResultKt.createFailure(paramObject));
        }
        localContinuation.resumeWith(paramObject);
      }
      localBaseContinuationImpl.releaseIntercepted();
      if (!(localContinuation instanceof BaseContinuationImpl)) {
        break;
      }
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Continuation at ");
    Object localObject = getStackTraceElement();
    if (localObject != null) {}
    for (localObject = (Serializable)localObject;; localObject = (Serializable)getClass().getName()) {
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.BaseContinuationImpl
 * JD-Core Version:    0.7.0.1
 */