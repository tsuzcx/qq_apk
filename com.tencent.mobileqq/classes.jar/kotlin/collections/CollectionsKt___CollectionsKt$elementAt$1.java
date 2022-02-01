package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class CollectionsKt___CollectionsKt$elementAt$1
  extends Lambda
  implements Function1
{
  CollectionsKt___CollectionsKt$elementAt$1(int paramInt)
  {
    super(1);
  }
  
  @NotNull
  public final Void invoke(int paramInt)
  {
    throw ((Throwable)new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.$index + '.'));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.CollectionsKt___CollectionsKt.elementAt.1
 * JD-Core Version:    0.7.0.1
 */