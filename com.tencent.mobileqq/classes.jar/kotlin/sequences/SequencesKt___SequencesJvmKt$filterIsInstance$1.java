package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "R", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesJvmKt$filterIsInstance$1
  extends Lambda
  implements Function1<Object, Boolean>
{
  SequencesKt___SequencesJvmKt$filterIsInstance$1(Class paramClass)
  {
    super(1);
  }
  
  public final boolean invoke(@Nullable Object paramObject)
  {
    return this.$klass.isInstance(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance.1
 * JD-Core Version:    0.7.0.1
 */