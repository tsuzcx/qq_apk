package kotlin.sequences;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "toSortedSet", "Ljava/util/SortedSet;", "T", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/sequences/SequencesKt")
class SequencesKt___SequencesJvmKt
  extends SequencesKt__SequencesKt
{
  @NotNull
  public static final <R> Sequence<R> filterIsInstance(@NotNull Sequence<?> paramSequence, @NotNull Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterIsInstance");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    paramSequence = SequencesKt.filter(paramSequence, (Function1)new SequencesKt___SequencesJvmKt.filterIsInstance.1(paramClass));
    if (paramSequence == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }
    return paramSequence;
  }
  
  @NotNull
  public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull Sequence<?> paramSequence, @NotNull C paramC, @NotNull Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterIsInstanceTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (paramClass.isInstance(localObject)) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toSortedSet");
    return (SortedSet)SequencesKt.toCollection(paramSequence, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final <T> SortedSet<T> toSortedSet(@NotNull Sequence<? extends T> paramSequence, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toSortedSet");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (SortedSet)SequencesKt.toCollection(paramSequence, (Collection)new TreeSet(paramComparator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesJvmKt
 * JD-Core Version:    0.7.0.1
 */