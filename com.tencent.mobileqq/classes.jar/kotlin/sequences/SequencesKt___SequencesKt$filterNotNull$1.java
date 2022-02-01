package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "it", "invoke", "(Ljava/lang/Object;)Z"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesKt$filterNotNull$1
  extends Lambda
  implements Function1<T, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  SequencesKt___SequencesKt$filterNotNull$1()
  {
    super(1);
  }
  
  public final boolean invoke(@Nullable T paramT)
  {
    return paramT == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.filterNotNull.1
 * JD-Core Version:    0.7.0.1
 */