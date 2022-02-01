package kotlin.coroutines.experimental;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/SequenceBuilder;", "T", "", "()V", "yield", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "yieldAll", "elements", "", "(Ljava/lang/Iterable;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "iterator", "", "(Ljava/util/Iterator;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "sequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
@RestrictsSuspension
public abstract class SequenceBuilder<T>
{
  @Nullable
  public abstract Object yield(T paramT, @NotNull Continuation<? super Unit> paramContinuation);
  
  @Nullable
  public final Object yieldAll(@NotNull Iterable<? extends T> paramIterable, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (((paramIterable instanceof Collection)) && (((Collection)paramIterable).isEmpty())) {
      paramIterable = Unit.INSTANCE;
    }
    do
    {
      return paramIterable;
      paramContinuation = yieldAll(paramIterable.iterator(), paramContinuation);
      paramIterable = paramContinuation;
    } while (paramContinuation == IntrinsicsKt.getCOROUTINE_SUSPENDED());
    return Unit.INSTANCE;
  }
  
  @Nullable
  public abstract Object yieldAll(@NotNull Iterator<? extends T> paramIterator, @NotNull Continuation<? super Unit> paramContinuation);
  
  @Nullable
  public final Object yieldAll(@NotNull Sequence<? extends T> paramSequence, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramSequence = yieldAll(paramSequence.iterator(), paramContinuation);
    if (paramSequence == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramSequence;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.experimental.SequenceBuilder
 * JD-Core Version:    0.7.0.1
 */