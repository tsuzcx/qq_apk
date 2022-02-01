package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f="Sequences.kt", i={0, 0, 1, 1}, l={67, 69}, m="invokeSuspend", n={"$this$sequence", "iterator", "$this$sequence", "iterator"}, s={"L$0", "L$1", "L$0", "L$1"})
final class SequencesKt__SequencesKt$ifEmpty$1
  extends RestrictedSuspendLambda
  implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  int label;
  private SequenceScope p$;
  
  SequencesKt__SequencesKt$ifEmpty$1(Sequence paramSequence, Function0 paramFunction0, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.$this_ifEmpty, this.$defaultValue, paramContinuation);
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
    Object localObject = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    if (i != 0)
    {
      if ((i != 1) && (i != 2)) {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject = (Iterator)this.L$1;
      localObject = (SequenceScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      Iterator localIterator = this.$this_ifEmpty.iterator();
      if (localIterator.hasNext())
      {
        this.L$0 = paramObject;
        this.L$1 = localIterator;
        this.label = 1;
        if (paramObject.yieldAll(localIterator, this) == localObject) {
          return localObject;
        }
      }
      else
      {
        Sequence localSequence = (Sequence)this.$defaultValue.invoke();
        this.L$0 = paramObject;
        this.L$1 = localIterator;
        this.label = 2;
        if (paramObject.yieldAll(localSequence, this) == localObject) {
          return localObject;
        }
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequencesKt__SequencesKt.ifEmpty.1
 * JD-Core Version:    0.7.0.1
 */