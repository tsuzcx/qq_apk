package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/CollectionsKt")
class CollectionsKt__ReversedViewsKt
  extends CollectionsKt__MutableCollectionsKt
{
  @NotNull
  public static final <T> List<T> asReversed(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$asReversed");
    return (List)new ReversedListReadOnly(paramList);
  }
  
  @JvmName(name="asReversedMutable")
  @NotNull
  public static final <T> List<T> asReversedMutable(@NotNull List<T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$asReversed");
    return (List)new ReversedList(paramList);
  }
  
  private static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(@NotNull List<?> paramList, int paramInt)
  {
    int i = CollectionsKt.getLastIndex(paramList);
    if ((paramInt >= 0) && (i >= paramInt)) {
      return CollectionsKt.getLastIndex(paramList) - paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Element index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" must be in range [");
    localStringBuilder.append(new IntRange(0, CollectionsKt.getLastIndex(paramList)));
    localStringBuilder.append("].");
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(@NotNull List<?> paramList, int paramInt)
  {
    int i = paramList.size();
    if ((paramInt >= 0) && (i >= paramInt)) {
      return paramList.size() - paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Position index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" must be in range [");
    localStringBuilder.append(new IntRange(0, paramList.size()));
    localStringBuilder.append("].");
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.CollectionsKt__ReversedViewsKt
 * JD-Core Version:    0.7.0.1
 */