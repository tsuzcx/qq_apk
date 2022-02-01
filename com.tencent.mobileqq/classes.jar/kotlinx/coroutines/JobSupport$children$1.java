package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/ChildJob;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.JobSupport$children$1", f="JobSupport.kt", i={0, 0, 1, 1, 1, 1, 1, 1}, l={949, 951}, m="invokeSuspend", n={"$this$sequence", "state", "$this$sequence", "state", "list", "this_$iv", "cur$iv", "it"}, s={"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
final class JobSupport$children$1
  extends RestrictedSuspendLambda
  implements Function2<SequenceScope<? super ChildJob>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  int label;
  private SequenceScope p$;
  
  JobSupport$children$1(JobSupport paramJobSupport, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.this$0, paramContinuation);
    paramContinuation.p$ = ((SequenceScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject3;
    Object localObject4;
    Object localObject6;
    Object localObject8;
    Object localObject10;
    Object localObject11;
    Object localObject2;
    Object localObject5;
    Object localObject7;
    Object localObject9;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject1 = (ChildHandleNode)this.L$5;
          localObject3 = (LockFreeLinkedListNode)this.L$4;
          localObject4 = (LockFreeLinkedListHead)this.L$3;
          localObject6 = (NodeList)this.L$2;
          localObject8 = this.L$1;
          localObject10 = (SequenceScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject11 = this;
        }
        else
        {
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
      }
      else
      {
        localObject1 = this.L$1;
        localObject1 = (SequenceScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        break label400;
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this.p$;
      localObject5 = this.this$0.getState$kotlinx_coroutines_core();
      if ((localObject5 instanceof ChildHandleNode))
      {
        paramObject = ((ChildHandleNode)localObject5).childJob;
        this.L$0 = localObject2;
        this.L$1 = localObject5;
        this.label = 1;
        if (((SequenceScope)localObject2).yield(paramObject, this) != localObject12) {
          break label400;
        }
        return localObject12;
      }
      if (!(localObject5 instanceof Incomplete)) {
        break label400;
      }
      localObject7 = ((Incomplete)localObject5).getList();
      if (localObject7 == null) {
        break label400;
      }
      localObject9 = (LockFreeLinkedListHead)localObject7;
      paramObject = ((LockFreeLinkedListHead)localObject9).getNext();
      if (paramObject == null) {
        break label390;
      }
      paramObject = (LockFreeLinkedListNode)paramObject;
    }
    for (Object localObject1 = this; (Intrinsics.areEqual(paramObject, localObject9) ^ true); localObject1 = localObject11)
    {
      localObject3 = paramObject;
      localObject4 = localObject9;
      localObject6 = localObject7;
      localObject8 = localObject5;
      localObject10 = localObject2;
      localObject11 = localObject1;
      if ((paramObject instanceof ChildHandleNode))
      {
        localObject3 = (ChildHandleNode)paramObject;
        ChildJob localChildJob = ((ChildHandleNode)localObject3).childJob;
        ((1)localObject1).L$0 = localObject2;
        ((1)localObject1).L$1 = localObject5;
        ((1)localObject1).L$2 = localObject7;
        ((1)localObject1).L$3 = localObject9;
        ((1)localObject1).L$4 = paramObject;
        ((1)localObject1).L$5 = localObject3;
        ((1)localObject1).label = 2;
        localObject3 = paramObject;
        localObject4 = localObject9;
        localObject6 = localObject7;
        localObject8 = localObject5;
        localObject10 = localObject2;
        localObject11 = localObject1;
        if (((SequenceScope)localObject2).yield(localChildJob, (Continuation)localObject1) == localObject12) {
          return localObject12;
        }
      }
      paramObject = ((LockFreeLinkedListNode)localObject3).getNextNode();
      localObject9 = localObject4;
      localObject7 = localObject6;
      localObject5 = localObject8;
      localObject2 = localObject10;
    }
    label390:
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    label400:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobSupport.children.1
 * JD-Core Version:    0.7.0.1
 */