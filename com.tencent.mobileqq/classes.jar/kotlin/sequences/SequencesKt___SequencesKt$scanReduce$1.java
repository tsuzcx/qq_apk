package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "S", "T", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlin.sequences.SequencesKt___SequencesKt$scanReduce$1", f="_Sequences.kt", i={0, 0, 0, 1, 1, 1}, l={1492, 1495}, m="invokeSuspend", n={"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s={"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class SequencesKt___SequencesKt$scanReduce$1
  extends RestrictedSuspendLambda
  implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private SequenceScope p$;
  
  SequencesKt___SequencesKt$scanReduce$1(Sequence paramSequence, Function2 paramFunction2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.$this_scanReduce, this.$operation, paramContinuation);
    SequenceScope localSequenceScope = (SequenceScope)paramObject;
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
    Object localObject4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    Object localObject2;
    Iterator localIterator;
    Object localObject1;
    switch (this.label)
    {
    default: 
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this.p$;
      localIterator = this.$this_scanReduce.iterator();
      if (!localIterator.hasNext()) {
        break label254;
      }
      Object localObject3 = localIterator.next();
      this.L$0 = localObject2;
      this.L$1 = localIterator;
      this.L$2 = localObject3;
      this.label = 1;
      paramObject = localObject3;
      localObject1 = localObject2;
      if (((SequenceScope)localObject2).yield(localObject3, this) == localObject4) {
        return localObject4;
      }
      break;
    case 1: 
      localObject2 = this.L$2;
      localIterator = (Iterator)this.L$1;
      localObject1 = (SequenceScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      paramObject = localObject2;
    }
    while (localIterator.hasNext())
    {
      localObject2 = this.$operation.invoke(paramObject, localIterator.next());
      this.L$0 = localObject1;
      this.L$1 = localIterator;
      this.L$2 = localObject2;
      this.label = 2;
      paramObject = localObject2;
      if (((SequenceScope)localObject1).yield(localObject2, this) == localObject4)
      {
        return localObject4;
        localObject2 = this.L$2;
        localIterator = (Iterator)this.L$1;
        localObject1 = (SequenceScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
      }
    }
    label254:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.scanReduce.1
 * JD-Core Version:    0.7.0.1
 */