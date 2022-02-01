package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/comparisons/ReverseOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ReverseOrderComparator
  implements Comparator<Comparable<? super Object>>
{
  public static final ReverseOrderComparator INSTANCE = new ReverseOrderComparator();
  
  public int compare(@NotNull Comparable<Object> paramComparable1, @NotNull Comparable<Object> paramComparable2)
  {
    Intrinsics.checkParameterIsNotNull(paramComparable1, "a");
    Intrinsics.checkParameterIsNotNull(paramComparable2, "b");
    return paramComparable2.compareTo(paramComparable1);
  }
  
  @NotNull
  public final Comparator<Comparable<Object>> reversed()
  {
    return (Comparator)NaturalOrderComparator.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.comparisons.ReverseOrderComparator
 * JD-Core Version:    0.7.0.1
 */