package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class SequencesKt__SequencesKt$flatten$2
  extends Lambda
  implements Function1<Iterable<? extends T>, Iterator<? extends T>>
{
  public static final 2 INSTANCE = new 2();
  
  SequencesKt__SequencesKt$flatten$2()
  {
    super(1);
  }
  
  @NotNull
  public final Iterator<T> invoke(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "it");
    return paramIterable.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequencesKt__SequencesKt.flatten.2
 * JD-Core Version:    0.7.0.1
 */