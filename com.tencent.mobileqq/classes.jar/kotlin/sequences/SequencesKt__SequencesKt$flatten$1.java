package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"}, k=3, mv={1, 1, 16})
final class SequencesKt__SequencesKt$flatten$1
  extends Lambda
  implements Function1<Sequence<? extends T>, Iterator<? extends T>>
{
  public static final 1 INSTANCE = new 1();
  
  SequencesKt__SequencesKt$flatten$1()
  {
    super(1);
  }
  
  @NotNull
  public final Iterator<T> invoke(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "it");
    return paramSequence.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.sequences.SequencesKt__SequencesKt.flatten.1
 * JD-Core Version:    0.7.0.1
 */