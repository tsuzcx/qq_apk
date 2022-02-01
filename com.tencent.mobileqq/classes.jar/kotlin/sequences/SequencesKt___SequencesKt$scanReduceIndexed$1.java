package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "S", "T", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlin.sequences.SequencesKt___SequencesKt$scanReduceIndexed$1", f="_Sequences.kt", i={0, 0, 0, 1, 1, 1, 1}, l={1522, 1526}, m="invokeSuspend", n={"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s={"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
final class SequencesKt___SequencesKt$scanReduceIndexed$1
  extends RestrictedSuspendLambda
  implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object>
{
  int I$0;
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private SequenceScope p$;
  
  SequencesKt___SequencesKt$scanReduceIndexed$1(Sequence paramSequence, Function3 paramFunction3, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.$this_scanReduceIndexed, this.$operation, paramContinuation);
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
    int j = this.label;
    int i = 1;
    Object localObject2;
    Iterator localIterator;
    Object localObject1;
    Object localObject3;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j == 2)
        {
          i = this.I$0;
          localObject2 = this.L$2;
          localIterator = (Iterator)this.L$1;
          localObject1 = (SequenceScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject2;
        }
        else
        {
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
      }
      else
      {
        localObject2 = this.L$2;
        localIterator = (Iterator)this.L$1;
        localObject1 = (SequenceScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this.p$;
      localIterator = this.$this_scanReduceIndexed.iterator();
      if (!localIterator.hasNext()) {
        break label299;
      }
      localObject3 = localIterator.next();
      this.L$0 = localObject2;
      this.L$1 = localIterator;
      this.L$2 = localObject3;
      this.label = 1;
      paramObject = localObject3;
      localObject1 = localObject2;
      if (((SequenceScope)localObject2).yield(localObject3, this) == localObject4) {
        return localObject4;
      }
    }
    for (;;)
    {
      localObject2 = this;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject3 = ((1)localObject2).$operation;
      j = i + 1;
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramObject = ((Function3)localObject3).invoke(Boxing.boxInt(i), paramObject, localIterator.next());
      ((1)localObject2).L$0 = localObject1;
      ((1)localObject2).L$1 = localIterator;
      ((1)localObject2).L$2 = paramObject;
      ((1)localObject2).I$0 = j;
      ((1)localObject2).label = 2;
      if (((SequenceScope)localObject1).yield(paramObject, (Continuation)localObject2) == localObject4) {
        return localObject4;
      }
      i = j;
    }
    label299:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.scanReduceIndexed.1
 * JD-Core Version:    0.7.0.1
 */