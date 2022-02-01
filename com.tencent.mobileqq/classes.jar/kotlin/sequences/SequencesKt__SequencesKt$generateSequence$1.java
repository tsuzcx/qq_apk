package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
final class SequencesKt__SequencesKt$generateSequence$1
  extends Lambda
  implements Function1<T, T>
{
  SequencesKt__SequencesKt$generateSequence$1(Function0 paramFunction0)
  {
    super(1);
  }
  
  @Nullable
  public final T invoke(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "it");
    return this.$nextFunction.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.SequencesKt__SequencesKt.generateSequence.1
 * JD-Core Version:    0.7.0.1
 */