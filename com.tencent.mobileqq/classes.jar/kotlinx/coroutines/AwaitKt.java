package kotlinx.coroutines;

import java.util.Collection;
import java.util.Collection<+Lkotlinx.coroutines.Deferred<+TT;>;>;
import java.util.Collection<+Lkotlinx.coroutines.Job;>;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.Continuation<-Ljava.util.List<+TT;>;>;
import kotlin.coroutines.Continuation<-Lkotlin.Unit;>;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class AwaitKt
{
  @Nullable
  public static final <T> Object awaitAll(@NotNull Collection<? extends Deferred<? extends T>> paramCollection, @NotNull Continuation<? super List<? extends T>> paramContinuation)
  {
    if ((paramContinuation instanceof AwaitKt.awaitAll.2))
    {
      localObject1 = (AwaitKt.awaitAll.2)paramContinuation;
      if ((((AwaitKt.awaitAll.2)localObject1).label & 0x80000000) != 0)
      {
        ((AwaitKt.awaitAll.2)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super List<? extends T>>)localObject1;
        break label47;
      }
    }
    paramContinuation = new AwaitKt.awaitAll.2(paramContinuation);
    label47:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramCollection = (Collection)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
        paramCollection = (Collection<? extends Deferred<? extends T>>)localObject1;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      if (paramCollection.isEmpty()) {
        return CollectionsKt.emptyList();
      }
      localObject1 = paramCollection.toArray(new Deferred[0]);
      if (localObject1 == null) {
        break label174;
      }
      localObject1 = new AwaitAll((Deferred[])localObject1);
      paramContinuation.L$0 = paramCollection;
      paramContinuation.label = 1;
      paramContinuation = ((AwaitAll)localObject1).await(paramContinuation);
      paramCollection = paramContinuation;
      if (paramContinuation == localObject2) {
        return localObject2;
      }
    }
    return (List)paramCollection;
    label174:
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  @Nullable
  public static final <T> Object awaitAll(@NotNull Deferred<? extends T>[] paramArrayOfDeferred, @NotNull Continuation<? super List<? extends T>> paramContinuation)
  {
    if ((paramContinuation instanceof AwaitKt.awaitAll.1))
    {
      localObject1 = (AwaitKt.awaitAll.1)paramContinuation;
      if ((((AwaitKt.awaitAll.1)localObject1).label & 0x80000000) != 0)
      {
        ((AwaitKt.awaitAll.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super List<? extends T>>)localObject1;
        break label47;
      }
    }
    paramContinuation = new AwaitKt.awaitAll.1(paramContinuation);
    label47:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramArrayOfDeferred = (Deferred[])paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
        paramArrayOfDeferred = (Deferred<? extends T>[])localObject1;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      if (paramArrayOfDeferred.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return CollectionsKt.emptyList();
      }
      localObject1 = new AwaitAll(paramArrayOfDeferred);
      paramContinuation.L$0 = paramArrayOfDeferred;
      paramContinuation.label = 1;
      paramContinuation = ((AwaitAll)localObject1).await(paramContinuation);
      paramArrayOfDeferred = paramContinuation;
      if (paramContinuation == localObject2) {
        return localObject2;
      }
    }
    return (List)paramArrayOfDeferred;
  }
  
  @Nullable
  public static final Object joinAll(@NotNull Collection<? extends Job> paramCollection, @NotNull Continuation<? super Unit> paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof AwaitKt.joinAll.3))
    {
      localObject1 = (AwaitKt.joinAll.3)paramContinuation;
      if ((((AwaitKt.joinAll.3)localObject1).label & 0x80000000) != 0)
      {
        ((AwaitKt.joinAll.3)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super Unit>)localObject1;
        break label47;
      }
    }
    paramContinuation = new AwaitKt.joinAll.3(paramContinuation);
    label47:
    Object localObject3 = paramContinuation.result;
    Object localObject4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    Object localObject2;
    if (i != 0)
    {
      if (i == 1)
      {
        paramCollection = (Job)paramContinuation.L$4;
        paramCollection = paramContinuation.L$3;
        localObject1 = (Iterator)paramContinuation.L$2;
        paramCollection = (Iterable)paramContinuation.L$1;
        localObject2 = (Collection)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject3);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject3);
      localObject3 = (Iterable)paramCollection;
      localObject1 = ((Iterable)localObject3).iterator();
      localObject2 = paramCollection;
      paramCollection = (Collection<? extends Job>)localObject3;
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((Iterator)localObject1).next();
      Job localJob = (Job)localObject3;
      paramContinuation.L$0 = localObject2;
      paramContinuation.L$1 = paramCollection;
      paramContinuation.L$2 = localObject1;
      paramContinuation.L$3 = localObject3;
      paramContinuation.L$4 = localJob;
      paramContinuation.label = 1;
      if (localJob.join(paramContinuation) == localObject4) {
        return localObject4;
      }
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public static final Object joinAll(@NotNull Job[] paramArrayOfJob, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if ((paramContinuation instanceof AwaitKt.joinAll.1))
    {
      localObject1 = (AwaitKt.joinAll.1)paramContinuation;
      if ((((AwaitKt.joinAll.1)localObject1).label & 0x80000000) != 0)
      {
        ((AwaitKt.joinAll.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super Unit>)localObject1;
        break label52;
      }
    }
    paramContinuation = new AwaitKt.joinAll.1(paramContinuation);
    label52:
    Object localObject4 = paramContinuation.result;
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    int j;
    Object localObject2;
    Object localObject3;
    Continuation<? super Unit> localContinuation;
    if (i != 0)
    {
      if (i == 1)
      {
        paramArrayOfJob = (Job)paramContinuation.L$4;
        paramArrayOfJob = (Job)paramContinuation.L$3;
        i = paramContinuation.I$1;
        j = paramContinuation.I$0;
        localObject2 = (Job[])paramContinuation.L$2;
        localObject3 = (Job[])paramContinuation.L$1;
        paramArrayOfJob = (Job[])paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject4);
        localObject4 = localObject1;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject4);
      j = paramArrayOfJob.length;
      localObject3 = localObject1;
      localObject1 = paramArrayOfJob;
      localObject4 = localObject1;
      i = 0;
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = paramArrayOfJob;
      paramArrayOfJob = localObject4;
      localContinuation = paramContinuation;
    }
    while (i < j)
    {
      Object localObject5 = localObject2[i];
      localContinuation.L$0 = paramArrayOfJob;
      localContinuation.L$1 = localObject3;
      localContinuation.L$2 = localObject2;
      localContinuation.I$0 = j;
      localContinuation.I$1 = i;
      localContinuation.L$3 = localObject5;
      localContinuation.L$4 = localObject5;
      localContinuation.label = 1;
      paramContinuation = localContinuation;
      localObject4 = localObject1;
      if (localObject5.join(localContinuation) == localObject1) {
        return localObject1;
      }
      i += 1;
      localContinuation = paramContinuation;
      localObject1 = localObject4;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.AwaitKt
 * JD-Core Version:    0.7.0.1
 */