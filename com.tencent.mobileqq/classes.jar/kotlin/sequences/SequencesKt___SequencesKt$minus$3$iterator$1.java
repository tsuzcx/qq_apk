package kotlin.sequences;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Z"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesKt$minus$3$iterator$1
  extends Lambda
  implements Function1<T, Boolean>
{
  SequencesKt___SequencesKt$minus$3$iterator$1(Collection paramCollection)
  {
    super(1);
  }
  
  public final boolean invoke(T paramT)
  {
    return this.$other.contains(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.minus.3.iterator.1
 * JD-Core Version:    0.7.0.1
 */