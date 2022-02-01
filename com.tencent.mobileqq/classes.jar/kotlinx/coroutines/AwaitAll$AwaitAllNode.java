package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/Job;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"}, k=1, mv={1, 1, 16})
final class AwaitAll$AwaitAllNode
  extends JobNode<Job>
{
  private volatile Object _disposer;
  private final CancellableContinuation<List<? extends T>> continuation;
  @NotNull
  public DisposableHandle handle;
  
  public AwaitAll$AwaitAllNode(CancellableContinuation<? super List<? extends T>> paramCancellableContinuation, @NotNull Job paramJob)
  {
    super(localJob);
    this.continuation = paramJob;
    this._disposer = null;
  }
  
  @Nullable
  public final AwaitAll<T>.DisposeHandlersOnCancel getDisposer()
  {
    return (AwaitAll.DisposeHandlersOnCancel)this._disposer;
  }
  
  @NotNull
  public final DisposableHandle getHandle()
  {
    DisposableHandle localDisposableHandle = this.handle;
    if (localDisposableHandle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("handle");
    }
    return localDisposableHandle;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      paramThrowable = this.continuation.tryResumeWithException(paramThrowable);
      if (paramThrowable != null)
      {
        this.continuation.completeResume(paramThrowable);
        paramThrowable = getDisposer();
        if (paramThrowable != null) {
          paramThrowable.disposeAll();
        }
      }
    }
    else
    {
      paramThrowable = this.this$0;
      if (AwaitAll.notCompletedCount$FU.decrementAndGet(paramThrowable) == 0)
      {
        paramThrowable = (Continuation)this.continuation;
        Object localObject1 = AwaitAll.access$getDeferreds$p(this.this$0);
        Object localObject2 = (Collection)new ArrayList(localObject1.length);
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          ((Collection)localObject2).add(localObject1[i].getCompleted());
          i += 1;
        }
        localObject1 = (List)localObject2;
        localObject2 = Result.Companion;
        paramThrowable.resumeWith(Result.constructor-impl(localObject1));
      }
    }
  }
  
  public final void setDisposer(@Nullable AwaitAll<T>.DisposeHandlersOnCancel paramAwaitAll)
  {
    this._disposer = paramAwaitAll;
  }
  
  public final void setHandle(@NotNull DisposableHandle paramDisposableHandle)
  {
    this.handle = paramDisposableHandle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.AwaitAll.AwaitAllNode
 * JD-Core Version:    0.7.0.1
 */