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
@DebugMetadata(c="kotlin.sequences.SequencesKt___SequencesKt$scanReduce$1", f="_Sequences.kt", i={0, 0, 0, 1, 1, 1}, l={1486, 1489}, m="invokeSuspend", n={"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s={"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
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
    Object localObject5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject3 = this.L$2;
          localObject1 = (Iterator)this.L$1;
          localObject2 = (SequenceScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject3;
          break label195;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject3 = this.L$2;
      localObject2 = (Iterator)this.L$1;
      localObject1 = (SequenceScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      paramObject = localObject3;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject3 = this.p$;
      localObject2 = this.$this_scanReduce.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label263;
      }
      Object localObject4 = ((Iterator)localObject2).next();
      this.L$0 = localObject3;
      this.L$1 = localObject2;
      this.L$2 = localObject4;
      this.label = 1;
      paramObject = localObject4;
      localObject1 = localObject3;
      if (((SequenceScope)localObject3).yield(localObject4, this) == localObject5) {
        return localObject5;
      }
    }
    Object localObject3 = localObject2;
    Object localObject2 = localObject1;
    Object localObject1 = localObject3;
    label195:
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = this.$operation.invoke(paramObject, ((Iterator)localObject1).next());
      this.L$0 = localObject2;
      this.L$1 = localObject1;
      this.L$2 = localObject3;
      this.label = 2;
      paramObject = localObject3;
      if (((SequenceScope)localObject2).yield(localObject3, this) == localObject5) {
        return localObject5;
      }
    }
    label263:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.scanReduce.1
 * JD-Core Version:    0.7.0.1
 */