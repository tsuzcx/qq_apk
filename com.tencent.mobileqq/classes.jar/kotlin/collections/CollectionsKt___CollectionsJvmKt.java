package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "reverse", "", "T", "", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/CollectionsKt")
public class CollectionsKt___CollectionsJvmKt
  extends CollectionsKt__ReversedViewsKt
{
  @NotNull
  public static final <R> List<R> filterIsInstance(@NotNull Iterable<?> paramIterable, @NotNull Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterIsInstance");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    return (List)CollectionsKt.filterIsInstanceTo(paramIterable, (Collection)new ArrayList(), paramClass);
  }
  
  @NotNull
  public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull Iterable<?> paramIterable, @NotNull C paramC, @NotNull Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterIsInstanceTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramClass.isInstance(localObject)) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  public static final <T> void reverse(@NotNull List<T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$reverse");
    Collections.reverse(paramList);
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toSortedSet");
    return (SortedSet)CollectionsKt.toCollection(paramIterable, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final <T> SortedSet<T> toSortedSet(@NotNull Iterable<? extends T> paramIterable, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toSortedSet");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (SortedSet)CollectionsKt.toCollection(paramIterable, (Collection)new TreeSet(paramComparator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.CollectionsKt___CollectionsJvmKt
 * JD-Core Version:    0.7.0.1
 */