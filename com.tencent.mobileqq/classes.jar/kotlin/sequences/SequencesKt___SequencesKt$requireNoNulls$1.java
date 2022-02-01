package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesKt$requireNoNulls$1
  extends Lambda
  implements Function1<T, T>
{
  SequencesKt___SequencesKt$requireNoNulls$1(Sequence paramSequence)
  {
    super(1);
  }
  
  @NotNull
  public final T invoke(@Nullable T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw ((Throwable)new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.'));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.requireNoNulls.1
 * JD-Core Version:    0.7.0.1
 */