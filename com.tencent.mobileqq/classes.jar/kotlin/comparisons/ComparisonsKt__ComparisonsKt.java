package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"compareBy", "Ljava/util/Comparator;", "T", "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "thenDescending", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/comparisons/ComparisonsKt")
public class ComparisonsKt__ComparisonsKt
{
  @InlineOnly
  private static final <T, K> Comparator<T> compareBy(Comparator<? super K> paramComparator, Function1<? super T, ? extends K> paramFunction1)
  {
    return (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.3(paramComparator, paramFunction1);
  }
  
  @InlineOnly
  private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> paramFunction1)
  {
    return (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1);
  }
  
  @NotNull
  public static final <T> Comparator<T> compareBy(@NotNull Function1<? super T, ? extends Comparable<?>>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "selectors");
    if (paramVarArgs.length > 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    return (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.1(paramVarArgs);
  }
  
  @InlineOnly
  private static final <T, K> Comparator<T> compareByDescending(Comparator<? super K> paramComparator, Function1<? super T, ? extends K> paramFunction1)
  {
    return (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.2(paramComparator, paramFunction1);
  }
  
  @InlineOnly
  private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> paramFunction1)
  {
    return (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1);
  }
  
  public static final <T extends Comparable<?>> int compareValues(@Nullable T paramT1, @Nullable T paramT2)
  {
    if (paramT1 == paramT2) {
      return 0;
    }
    if (paramT1 == null) {
      return -1;
    }
    if (paramT2 == null) {
      return 1;
    }
    return paramT1.compareTo(paramT2);
  }
  
  @InlineOnly
  private static final <T, K> int compareValuesBy(T paramT1, T paramT2, Comparator<? super K> paramComparator, Function1<? super T, ? extends K> paramFunction1)
  {
    return paramComparator.compare(paramFunction1.invoke(paramT1), paramFunction1.invoke(paramT2));
  }
  
  @InlineOnly
  private static final <T> int compareValuesBy(T paramT1, T paramT2, Function1<? super T, ? extends Comparable<?>> paramFunction1)
  {
    return ComparisonsKt.compareValues((Comparable)paramFunction1.invoke(paramT1), (Comparable)paramFunction1.invoke(paramT2));
  }
  
  public static final <T> int compareValuesBy(T paramT1, T paramT2, @NotNull Function1<? super T, ? extends Comparable<?>>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "selectors");
    if (paramVarArgs.length > 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    return compareValuesByImpl$ComparisonsKt__ComparisonsKt(paramT1, paramT2, paramVarArgs);
  }
  
  private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T paramT1, T paramT2, Function1<? super T, ? extends Comparable<?>>[] paramArrayOfFunction1)
  {
    int j = paramArrayOfFunction1.length;
    int i = 0;
    while (i < j)
    {
      Function1<? super T, ? extends Comparable<?>> localFunction1 = paramArrayOfFunction1[i];
      int k = ComparisonsKt.compareValues((Comparable)localFunction1.invoke(paramT1), (Comparable)localFunction1.invoke(paramT2));
      if (k != 0) {
        return k;
      }
      i += 1;
    }
    return 0;
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder()
  {
    NaturalOrderComparator localNaturalOrderComparator = NaturalOrderComparator.INSTANCE;
    if (localNaturalOrderComparator == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }
    return (Comparator)localNaturalOrderComparator;
  }
  
  @InlineOnly
  private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst()
  {
    return ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
  }
  
  @NotNull
  public static final <T> Comparator<T> nullsFirst(@NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (Comparator)new ComparisonsKt__ComparisonsKt.nullsFirst.1(paramComparator);
  }
  
  @InlineOnly
  private static final <T extends Comparable<? super T>> Comparator<T> nullsLast()
  {
    return ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
  }
  
  @NotNull
  public static final <T> Comparator<T> nullsLast(@NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (Comparator)new ComparisonsKt__ComparisonsKt.nullsLast.1(paramComparator);
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder()
  {
    ReverseOrderComparator localReverseOrderComparator = ReverseOrderComparator.INSTANCE;
    if (localReverseOrderComparator == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }
    return (Comparator)localReverseOrderComparator;
  }
  
  @NotNull
  public static final <T> Comparator<T> reversed(@NotNull Comparator<T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "$this$reversed");
    if ((paramComparator instanceof ReversedComparator)) {
      return ((ReversedComparator)paramComparator).getComparator();
    }
    if (Intrinsics.areEqual(paramComparator, NaturalOrderComparator.INSTANCE))
    {
      paramComparator = ReverseOrderComparator.INSTANCE;
      if (paramComparator == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
      }
      return (Comparator)paramComparator;
    }
    if (Intrinsics.areEqual(paramComparator, ReverseOrderComparator.INSTANCE))
    {
      paramComparator = NaturalOrderComparator.INSTANCE;
      if (paramComparator == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
      }
      return (Comparator)paramComparator;
    }
    return (Comparator)new ReversedComparator(paramComparator);
  }
  
  @NotNull
  public static final <T> Comparator<T> then(@NotNull Comparator<T> paramComparator, @NotNull Comparator<? super T> paramComparator1)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "$this$then");
    Intrinsics.checkParameterIsNotNull(paramComparator1, "comparator");
    return (Comparator)new ComparisonsKt__ComparisonsKt.then.1(paramComparator, paramComparator1);
  }
  
  @InlineOnly
  private static final <T, K> Comparator<T> thenBy(@NotNull Comparator<T> paramComparator, Comparator<? super K> paramComparator1, Function1<? super T, ? extends K> paramFunction1)
  {
    return (Comparator)new ComparisonsKt__ComparisonsKt.thenBy.2(paramComparator, paramComparator1, paramFunction1);
  }
  
  @InlineOnly
  private static final <T> Comparator<T> thenBy(@NotNull Comparator<T> paramComparator, Function1<? super T, ? extends Comparable<?>> paramFunction1)
  {
    return (Comparator)new ComparisonsKt__ComparisonsKt.thenBy.1(paramComparator, paramFunction1);
  }
  
  @InlineOnly
  private static final <T, K> Comparator<T> thenByDescending(@NotNull Comparator<T> paramComparator, Comparator<? super K> paramComparator1, Function1<? super T, ? extends K> paramFunction1)
  {
    return (Comparator)new ComparisonsKt__ComparisonsKt.thenByDescending.2(paramComparator, paramComparator1, paramFunction1);
  }
  
  @InlineOnly
  private static final <T> Comparator<T> thenByDescending(@NotNull Comparator<T> paramComparator, Function1<? super T, ? extends Comparable<?>> paramFunction1)
  {
    return (Comparator)new ComparisonsKt__ComparisonsKt.thenByDescending.1(paramComparator, paramFunction1);
  }
  
  @InlineOnly
  private static final <T> Comparator<T> thenComparator(@NotNull Comparator<T> paramComparator, Function2<? super T, ? super T, Integer> paramFunction2)
  {
    return (Comparator)new ComparisonsKt__ComparisonsKt.thenComparator.1(paramComparator, paramFunction2);
  }
  
  @NotNull
  public static final <T> Comparator<T> thenDescending(@NotNull Comparator<T> paramComparator, @NotNull Comparator<? super T> paramComparator1)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "$this$thenDescending");
    Intrinsics.checkParameterIsNotNull(paramComparator1, "comparator");
    return (Comparator)new ComparisonsKt__ComparisonsKt.thenDescending.1(paramComparator, paramComparator1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.comparisons.ComparisonsKt__ComparisonsKt
 * JD-Core Version:    0.7.0.1
 */