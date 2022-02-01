package kotlinx.coroutines;

import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""}, k=1, mv={1, 1, 16})
final class AwaitAll<T>
{
  static final AtomicIntegerFieldUpdater notCompletedCount$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
  private final Deferred<T>[] deferreds;
  volatile int notCompletedCount;
  
  public AwaitAll(@NotNull Deferred<? extends T>[] paramArrayOfDeferred)
  {
    this.deferreds = paramArrayOfDeferred;
    this.notCompletedCount = this.deferreds.length;
  }
  
  @Nullable
  public final Object await(@NotNull Continuation<? super List<? extends T>> paramContinuation)
  {
    Object localObject1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localObject1;
    int k = access$getDeferreds$p(this).length;
    AwaitAll.AwaitAllNode[] arrayOfAwaitAllNode = new AwaitAll.AwaitAllNode[k];
    int j = 0;
    int i = 0;
    while (i < k)
    {
      int m = ((Number)Boxing.boxInt(i)).intValue();
      localObject2 = access$getDeferreds$p(this)[m];
      ((Deferred)localObject2).start();
      AwaitAll.AwaitAllNode localAwaitAllNode = new AwaitAll.AwaitAllNode(this, localCancellableContinuation, (Job)localObject2);
      localAwaitAllNode.setHandle(((Deferred)localObject2).invokeOnCompletion((Function1)localAwaitAllNode));
      arrayOfAwaitAllNode[i] = localAwaitAllNode;
      i += 1;
    }
    Object localObject2 = new AwaitAll.DisposeHandlersOnCancel(this, arrayOfAwaitAllNode);
    k = arrayOfAwaitAllNode.length;
    i = j;
    while (i < k)
    {
      arrayOfAwaitAllNode[i].setDisposer((AwaitAll.DisposeHandlersOnCancel)localObject2);
      i += 1;
    }
    if (localCancellableContinuation.isCompleted()) {
      ((AwaitAll.DisposeHandlersOnCancel)localObject2).disposeAll();
    } else {
      localCancellableContinuation.invokeOnCancellation((Function1)localObject2);
    }
    localObject1 = ((CancellableContinuationImpl)localObject1).getResult();
    if (localObject1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.AwaitAll
 * JD-Core Version:    0.7.0.1
 */