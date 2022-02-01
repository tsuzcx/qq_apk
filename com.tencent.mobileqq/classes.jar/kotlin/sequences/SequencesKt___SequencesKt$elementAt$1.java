package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesKt$elementAt$1
  extends Lambda
  implements Function1
{
  SequencesKt___SequencesKt$elementAt$1(int paramInt)
  {
    super(1);
  }
  
  @NotNull
  public final Void invoke(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sequence doesn't contain element at index ");
    localStringBuilder.append(this.$index);
    localStringBuilder.append('.');
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.elementAt.1
 * JD-Core Version:    0.7.0.1
 */