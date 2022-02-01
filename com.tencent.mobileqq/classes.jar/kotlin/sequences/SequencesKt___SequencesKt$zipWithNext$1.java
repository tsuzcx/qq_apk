package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "T", "a", "b", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesKt$zipWithNext$1
  extends Lambda
  implements Function2<T, T, Pair<? extends T, ? extends T>>
{
  public static final 1 INSTANCE = new 1();
  
  SequencesKt___SequencesKt$zipWithNext$1()
  {
    super(2);
  }
  
  @NotNull
  public final Pair<T, T> invoke(T paramT1, T paramT2)
  {
    return TuplesKt.to(paramT1, paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.zipWithNext.1
 * JD-Core Version:    0.7.0.1
 */