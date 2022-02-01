package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"fill", "", "T", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "shuffled", "", "", "sort", "", "comparison", "Lkotlin/Function2;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sortWith", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/CollectionsKt")
public class CollectionsKt__MutableCollectionsJVMKt
  extends CollectionsKt__IteratorsKt
{
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final <T> void fill(@NotNull List<T> paramList, T paramT)
  {
    Collections.fill(paramList, paramT);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final <T> void shuffle(@NotNull List<T> paramList)
  {
    Collections.shuffle(paramList);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final <T> void shuffle(@NotNull List<T> paramList, Random paramRandom)
  {
    Collections.shuffle(paramList, paramRandom);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T> List<T> shuffled(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$shuffled");
    paramIterable = CollectionsKt.toMutableList(paramIterable);
    Collections.shuffle(paramIterable);
    return paramIterable;
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T> List<T> shuffled(@NotNull Iterable<? extends T> paramIterable, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$shuffled");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    paramIterable = CollectionsKt.toMutableList(paramIterable);
    Collections.shuffle(paramIterable, paramRandom);
    return paramIterable;
  }
  
  public static final <T extends Comparable<? super T>> void sort(@NotNull List<T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$sort");
    if (paramList.size() > 1) {
      Collections.sort(paramList);
    }
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use sortWith(comparator) instead.", replaceWith=@ReplaceWith(expression="this.sortWith(comparator)", imports={}))
  @InlineOnly
  private static final <T> void sort(@NotNull List<T> paramList, Comparator<? super T> paramComparator)
  {
    throw ((Throwable)new NotImplementedError(null, 1, null));
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use sortWith(Comparator(comparison)) instead.", replaceWith=@ReplaceWith(expression="this.sortWith(Comparator(comparison))", imports={}))
  @InlineOnly
  private static final <T> void sort(@NotNull List<T> paramList, Function2<? super T, ? super T, Integer> paramFunction2)
  {
    throw ((Throwable)new NotImplementedError(null, 1, null));
  }
  
  public static final <T> void sortWith(@NotNull List<T> paramList, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$sortWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramList.size() > 1) {
      Collections.sort(paramList, paramComparator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.CollectionsKt__MutableCollectionsJVMKt
 * JD-Core Version:    0.7.0.1
 */