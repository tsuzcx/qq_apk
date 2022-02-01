package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"maxOf", "T", "a", "b", "c", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "minOf", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsKt
  extends ComparisonsKt___ComparisonsJvmKt
{
  @SinceKotlin(version="1.1")
  public static final <T> T maxOf(T paramT1, T paramT2, T paramT3, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return ComparisonsKt.maxOf(paramT1, ComparisonsKt.maxOf(paramT2, paramT3, paramComparator), paramComparator);
  }
  
  @SinceKotlin(version="1.1")
  public static final <T> T maxOf(T paramT1, T paramT2, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramComparator.compare(paramT1, paramT2) >= 0) {
      return paramT1;
    }
    return paramT2;
  }
  
  @SinceKotlin(version="1.1")
  public static final <T> T minOf(T paramT1, T paramT2, T paramT3, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return ComparisonsKt.minOf(paramT1, ComparisonsKt.minOf(paramT2, paramT3, paramComparator), paramComparator);
  }
  
  @SinceKotlin(version="1.1")
  public static final <T> T minOf(T paramT1, T paramT2, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramComparator.compare(paramT1, paramT2) <= 0) {
      return paramT1;
    }
    return paramT2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.comparisons.ComparisonsKt___ComparisonsKt
 * JD-Core Version:    0.7.0.1
 */