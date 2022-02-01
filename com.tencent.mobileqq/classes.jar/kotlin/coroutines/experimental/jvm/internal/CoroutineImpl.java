package kotlin.coroutines.experimental.jvm.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/jvm/internal/CoroutineImpl;", "Lkotlin/jvm/internal/Lambda;", "", "Lkotlin/coroutines/experimental/Continuation;", "arity", "", "completion", "(ILkotlin/coroutines/experimental/Continuation;)V", "_context", "Lkotlin/coroutines/experimental/CoroutineContext;", "_facade", "context", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "facade", "getFacade", "()Lkotlin/coroutines/experimental/Continuation;", "label", "create", "", "value", "doResume", "data", "exception", "", "resume", "resumeWithException", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
public abstract class CoroutineImpl
  extends Lambda<Object>
  implements Continuation<Object>
{
  private final CoroutineContext _context;
  private Continuation<Object> _facade;
  @JvmField
  @Nullable
  protected Continuation<Object> completion;
  @JvmField
  protected int label;
  
  public CoroutineImpl(int paramInt, @Nullable Continuation<Object> paramContinuation)
  {
    super(paramInt);
    this.completion = paramContinuation;
    if (this.completion != null)
    {
      paramInt = 0;
      this.label = paramInt;
      paramContinuation = this.completion;
      if (paramContinuation == null) {
        break label51;
      }
    }
    label51:
    for (paramContinuation = paramContinuation.getContext();; paramContinuation = null)
    {
      this._context = paramContinuation;
      return;
      paramInt = -1;
      break;
    }
  }
  
  @NotNull
  public Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    throw ((Throwable)new IllegalStateException("create(Any?;Continuation) has not been overridden"));
  }
  
  @NotNull
  public Continuation<Unit> create(@NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    throw ((Throwable)new IllegalStateException("create(Continuation) has not been overridden"));
  }
  
  @Nullable
  protected abstract Object doResume(@Nullable Object paramObject, @Nullable Throwable paramThrowable);
  
  @NotNull
  public CoroutineContext getContext()
  {
    CoroutineContext localCoroutineContext = this._context;
    if (localCoroutineContext == null) {
      Intrinsics.throwNpe();
    }
    return localCoroutineContext;
  }
  
  @NotNull
  public final Continuation<Object> getFacade()
  {
    if (this._facade == null)
    {
      localObject = this._context;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this._facade = CoroutineIntrinsics.interceptContinuationIfNeeded((CoroutineContext)localObject, (Continuation)this);
    }
    Object localObject = this._facade;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return localObject;
  }
  
  public void resume(@Nullable Object paramObject)
  {
    Continuation localContinuation = this.completion;
    if (localContinuation == null) {
      Intrinsics.throwNpe();
    }
    try
    {
      paramObject = doResume(paramObject, null);
      if (paramObject != IntrinsicsKt.getCOROUTINE_SUSPENDED())
      {
        if (localContinuation != null) {
          break label49;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
      }
    }
    catch (Throwable paramObject)
    {
      localContinuation.resumeWithException(paramObject);
    }
    return;
    label49:
    localContinuation.resume(paramObject);
  }
  
  public void resumeWithException(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    Continuation localContinuation = this.completion;
    if (localContinuation == null) {
      Intrinsics.throwNpe();
    }
    try
    {
      paramThrowable = doResume(null, paramThrowable);
      if (paramThrowable != IntrinsicsKt.getCOROUTINE_SUSPENDED())
      {
        if (localContinuation != null) {
          break label55;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
      }
    }
    catch (Throwable paramThrowable)
    {
      localContinuation.resumeWithException(paramThrowable);
    }
    return;
    label55:
    localContinuation.resume(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
 * JD-Core Version:    0.7.0.1
 */