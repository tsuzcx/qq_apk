package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareBy.2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareByDescending.1;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"all", "", "T", "Lkotlin/sequences/Sequence;", "predicate", "Lkotlin/Function1;", "any", "asIterable", "", "asSequence", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "average", "", "", "averageOfByte", "averageOfDouble", "", "averageOfFloat", "", "averageOfInt", "", "averageOfLong", "", "averageOfShort", "chunked", "", "size", "R", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)Z", "count", "distinct", "distinctBy", "selector", "drop", "n", "dropWhile", "elementAt", "index", "(Lkotlin/sequences/Sequence;I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(Lkotlin/sequences/Sequence;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "findLast", "first", "(Lkotlin/sequences/Sequence;)Ljava/lang/Object;", "firstOrNull", "flatMap", "flatMapTo", "fold", "initial", "operation", "acc", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "forEach", "", "action", "forEachIndexed", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOf", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "(Lkotlin/sequences/Sequence;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "maxBy", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "minus", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "elements", "", "(Lkotlin/sequences/Sequence;[Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "minusElement", "none", "onEach", "partition", "plus", "plusElement", "reduce", "S", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceOrNull", "requireNoNulls", "scan", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "scanIndexed", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/sequences/Sequence;", "scanReduce", "scanReduceIndexed", "single", "singleOrNull", "sorted", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "sum", "sumOfByte", "sumOfDouble", "sumOfFloat", "sumOfInt", "sumOfLong", "sumOfShort", "sumBy", "sumByDouble", "take", "takeWhile", "toCollection", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toMutableSet", "", "toSet", "", "windowed", "step", "partialWindows", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "zipWithNext", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/sequences/SequencesKt")
public class SequencesKt___SequencesKt
  extends SequencesKt___SequencesJvmKt
{
  public static final <T> boolean all(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      if (!((Boolean)paramFunction1.invoke(paramSequence.next())).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  public static final <T> boolean any(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$any");
    return paramSequence.iterator().hasNext();
  }
  
  public static final <T> boolean any(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      if (((Boolean)paramFunction1.invoke(paramSequence.next())).booleanValue()) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public static final <T> Iterable<T> asIterable(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$asIterable");
    return (Iterable)new SequencesKt___SequencesKt.asIterable..inlined.Iterable.1(paramSequence);
  }
  
  @InlineOnly
  private static final <T> Sequence<T> asSequence(@NotNull Sequence<? extends T> paramSequence)
  {
    return paramSequence;
  }
  
  @NotNull
  public static final <T, K, V> Map<K, V> associate(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Pair localPair = (Pair)paramFunction1.invoke(paramSequence.next());
      localMap.put(localPair.getFirst(), localPair.getSecond());
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K> Map<K, T> associateBy(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      localMap.put(paramFunction1.invoke(localObject), localObject);
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, V> Map<K, V> associateBy(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      localMap.put(paramFunction1.invoke(localObject), paramFunction11.invoke(localObject));
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull Sequence<? extends T> paramSequence, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      paramM.put(paramFunction1.invoke(localObject), localObject);
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull Sequence<? extends T> paramSequence, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      paramM.put(paramFunction1.invoke(localObject), paramFunction11.invoke(localObject));
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull Sequence<? extends T> paramSequence, @NotNull M paramM, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Pair localPair = (Pair)paramFunction1.invoke(paramSequence.next());
      paramM.put(localPair.getFirst(), localPair.getSecond());
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <K, V> Map<K, V> associateWith(@NotNull Sequence<? extends K> paramSequence, @NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateWith");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "valueSelector");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      ((Map)localLinkedHashMap).put(localObject, paramFunction1.invoke(localObject));
    }
    return (Map)localLinkedHashMap;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(@NotNull Sequence<? extends K> paramSequence, @NotNull M paramM, @NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateWithTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "valueSelector");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      paramM.put(localObject, paramFunction1.invoke(localObject));
    }
    return paramM;
  }
  
  @JvmName(name="averageOfByte")
  public static final double averageOfByte(@NotNull Sequence<Byte> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    double d = 0.0D;
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      d += ((Number)paramSequence.next()).byteValue();
      i += 1;
      if (i < 0) {
        CollectionsKt.throwCountOverflow();
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / i;
  }
  
  @JvmName(name="averageOfDouble")
  public static final double averageOfDouble(@NotNull Sequence<Double> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    double d = 0.0D;
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      d += ((Number)paramSequence.next()).doubleValue();
      i += 1;
      if (i < 0) {
        CollectionsKt.throwCountOverflow();
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / i;
  }
  
  @JvmName(name="averageOfFloat")
  public static final double averageOfFloat(@NotNull Sequence<Float> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    double d = 0.0D;
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      d += ((Number)paramSequence.next()).floatValue();
      i += 1;
      if (i < 0) {
        CollectionsKt.throwCountOverflow();
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / i;
  }
  
  @JvmName(name="averageOfInt")
  public static final double averageOfInt(@NotNull Sequence<Integer> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    double d = 0.0D;
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      d += ((Number)paramSequence.next()).intValue();
      i += 1;
      if (i < 0) {
        CollectionsKt.throwCountOverflow();
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / i;
  }
  
  @JvmName(name="averageOfLong")
  public static final double averageOfLong(@NotNull Sequence<Long> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    double d = 0.0D;
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      d += ((Number)paramSequence.next()).longValue();
      i += 1;
      if (i < 0) {
        CollectionsKt.throwCountOverflow();
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / i;
  }
  
  @JvmName(name="averageOfShort")
  public static final double averageOfShort(@NotNull Sequence<Short> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    double d = 0.0D;
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      d += ((Number)paramSequence.next()).shortValue();
      i += 1;
      if (i < 0) {
        CollectionsKt.throwCountOverflow();
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / i;
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T> Sequence<List<T>> chunked(@NotNull Sequence<? extends T> paramSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$chunked");
    return SequencesKt.windowed(paramSequence, paramInt, paramInt, true);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T, R> Sequence<R> chunked(@NotNull Sequence<? extends T> paramSequence, int paramInt, @NotNull Function1<? super List<? extends T>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$chunked");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return SequencesKt.windowed(paramSequence, paramInt, paramInt, true, paramFunction1);
  }
  
  public static final <T> boolean contains(@NotNull Sequence<? extends T> paramSequence, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$contains");
    return SequencesKt.indexOf(paramSequence, paramT) >= 0;
  }
  
  public static final <T> int count(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$count");
    int i = 0;
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      paramSequence.next();
      int j = i + 1;
      i = j;
      if (j < 0)
      {
        CollectionsKt.throwCountOverflow();
        i = j;
      }
    }
    return i;
  }
  
  public static final <T> int count(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    int i = 0;
    if (paramSequence.hasNext())
    {
      if (!((Boolean)paramFunction1.invoke(paramSequence.next())).booleanValue()) {
        break label95;
      }
      int j = i + 1;
      i = j;
      if (j < 0)
      {
        if (!PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          break label79;
        }
        CollectionsKt.throwCountOverflow();
        i = j;
      }
    }
    label79:
    label95:
    for (;;)
    {
      break;
      throw ((Throwable)new ArithmeticException("Count overflow has happened."));
      return i;
    }
  }
  
  @NotNull
  public static final <T> Sequence<T> distinct(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$distinct");
    return SequencesKt.distinctBy(paramSequence, (Function1)SequencesKt___SequencesKt.distinct.1.INSTANCE);
  }
  
  @NotNull
  public static final <T, K> Sequence<T> distinctBy(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return (Sequence)new DistinctSequence(paramSequence, paramFunction1);
  }
  
  @NotNull
  public static final <T> Sequence<T> drop(@NotNull Sequence<? extends T> paramSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return paramSequence;
    }
    if ((paramSequence instanceof DropTakeSequence)) {
      return ((DropTakeSequence)paramSequence).drop(paramInt);
    }
    return (Sequence)new DropSequence(paramSequence, paramInt);
  }
  
  @NotNull
  public static final <T> Sequence<T> dropWhile(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return (Sequence)new DropWhileSequence(paramSequence, paramFunction1);
  }
  
  public static final <T> T elementAt(@NotNull Sequence<? extends T> paramSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$elementAt");
    return SequencesKt.elementAtOrElse(paramSequence, paramInt, (Function1)new SequencesKt___SequencesKt.elementAt.1(paramInt));
  }
  
  public static final <T> T elementAtOrElse(@NotNull Sequence<? extends T> paramSequence, int paramInt, @NotNull Function1<? super Integer, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$elementAtOrElse");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "defaultValue");
    if (paramInt < 0) {
      return paramFunction1.invoke(Integer.valueOf(paramInt));
    }
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (paramInt == i) {
        return localObject;
      }
      i += 1;
    }
    return paramFunction1.invoke(Integer.valueOf(paramInt));
  }
  
  @Nullable
  public static final <T> T elementAtOrNull(@NotNull Sequence<? extends T> paramSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$elementAtOrNull");
    if (paramInt < 0) {
      return null;
    }
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (paramInt == i) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  @NotNull
  public static final <T> Sequence<T> filter(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return (Sequence)new FilteringSequence(paramSequence, true, paramFunction1);
  }
  
  @NotNull
  public static final <T> Sequence<T> filterIndexed(@NotNull Sequence<? extends T> paramSequence, @NotNull Function2<? super Integer, ? super T, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    return (Sequence)new TransformingSequence((Sequence)new FilteringSequence((Sequence)new IndexingSequence(paramSequence), true, (Function1)new SequencesKt___SequencesKt.filterIndexed.1(paramFunction2)), (Function1)SequencesKt___SequencesKt.filterIndexed.2.INSTANCE);
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull Sequence<? extends T> paramSequence, @NotNull C paramC, @NotNull Function2<? super Integer, ? super T, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), localObject)).booleanValue()) {
          paramC.add(localObject);
        }
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return paramC;
  }
  
  @NotNull
  public static final <T> Sequence<T> filterNot(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return (Sequence)new FilteringSequence(paramSequence, false, paramFunction1);
  }
  
  @NotNull
  public static final <T> Sequence<T> filterNotNull(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterNotNull");
    paramSequence = SequencesKt.filterNot(paramSequence, (Function1)SequencesKt___SequencesKt.filterNotNull.1.INSTANCE);
    if (paramSequence == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
    }
    return paramSequence;
  }
  
  @NotNull
  public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull Sequence<? extends T> paramSequence, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (localObject != null) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull Sequence<? extends T> paramSequence, @NotNull C paramC, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C filterTo(@NotNull Sequence<? extends T> paramSequence, @NotNull C paramC, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  @InlineOnly
  private static final <T> T find(@NotNull Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return localObject;
      }
    }
    return null;
  }
  
  @InlineOnly
  private static final <T> T findLast(@NotNull Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Object localObject = null;
    Iterator localIterator = paramSequence.iterator();
    paramSequence = localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        break label50;
      }
      paramSequence = localObject;
    }
    label50:
    for (;;)
    {
      break;
      return paramSequence;
    }
  }
  
  public static final <T> T first(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$first");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      throw ((Throwable)new NoSuchElementException("Sequence is empty."));
    }
    return paramSequence.next();
  }
  
  public static final <T> T first(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return localObject;
      }
    }
    throw ((Throwable)new NoSuchElementException("Sequence contains no element matching the predicate."));
  }
  
  @Nullable
  public static final <T> T firstOrNull(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$firstOrNull");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    return paramSequence.next();
  }
  
  @Nullable
  public static final <T> T firstOrNull(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return localObject;
      }
    }
    return null;
  }
  
  @NotNull
  public static final <T, R> Sequence<R> flatMap(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends Sequence<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return (Sequence)new FlatteningSequence(paramSequence, paramFunction1, (Function1)SequencesKt___SequencesKt.flatMap.1.INSTANCE);
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull Sequence<? extends T> paramSequence, @NotNull C paramC, @NotNull Function1<? super T, ? extends Sequence<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      CollectionsKt.addAll(paramC, (Sequence)paramFunction1.invoke(paramSequence.next()));
    }
    return paramC;
  }
  
  public static final <T, R> R fold(@NotNull Sequence<? extends T> paramSequence, R paramR, @NotNull Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      paramR = paramFunction2.invoke(paramR, paramSequence.next());
    }
    return paramR;
  }
  
  public static final <T, R> R foldIndexed(@NotNull Sequence<? extends T> paramSequence, R paramR, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, localObject);
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return paramR;
  }
  
  public static final <T> void forEach(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      paramFunction1.invoke(paramSequence.next());
    }
  }
  
  public static final <T> void forEachIndexed(@NotNull Sequence<? extends T> paramSequence, @NotNull Function2<? super Integer, ? super T, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        paramFunction2.invoke(Integer.valueOf(i), localObject);
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
  }
  
  @NotNull
  public static final <T, K> Map<K, List<T>> groupBy(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramSequence.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramFunction1.invoke(localObject1);
      paramSequence = localMap.get(localObject2);
      if (paramSequence == null)
      {
        paramSequence = new ArrayList();
        localMap.put(localObject2, paramSequence);
      }
      for (;;)
      {
        ((List)paramSequence).add(localObject1);
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramSequence.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramFunction1.invoke(localObject1);
      paramSequence = localMap.get(localObject2);
      if (paramSequence == null)
      {
        paramSequence = new ArrayList();
        localMap.put(localObject2, paramSequence);
      }
      for (;;)
      {
        ((List)paramSequence).add(paramFunction11.invoke(localObject1));
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull Sequence<? extends T> paramSequence, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Iterator localIterator = paramSequence.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramFunction1.invoke(localObject1);
      paramSequence = paramM.get(localObject2);
      if (paramSequence == null)
      {
        paramSequence = new ArrayList();
        paramM.put(localObject2, paramSequence);
      }
      for (;;)
      {
        ((List)paramSequence).add(localObject1);
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull Sequence<? extends T> paramSequence, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Iterator localIterator = paramSequence.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramFunction1.invoke(localObject1);
      paramSequence = paramM.get(localObject2);
      if (paramSequence == null)
      {
        paramSequence = new ArrayList();
        paramM.put(localObject2, paramSequence);
      }
      for (;;)
      {
        ((List)paramSequence).add(paramFunction11.invoke(localObject1));
        break;
      }
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K> Grouping<T, K> groupingBy(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$groupingBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    return (Grouping)new SequencesKt___SequencesKt.groupingBy.1(paramSequence, paramFunction1);
  }
  
  public static final <T> int indexOf(@NotNull Sequence<? extends T> paramSequence, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$indexOf");
    int i = 0;
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      if (Intrinsics.areEqual(paramT, localObject)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final <T> int indexOfFirst(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
          break label86;
        }
        return i;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
      label86:
      i += 1;
    }
    return -1;
  }
  
  public static final <T> int indexOfLast(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    int i = 0;
    int j = -1;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
          j = i;
        }
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return j;
  }
  
  @NotNull
  public static final <T, A extends Appendable> A joinTo(@NotNull Sequence<? extends T> paramSequence, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super T, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int i = 0;
    paramSequence = paramSequence.iterator();
    int j;
    for (;;)
    {
      j = i;
      if (!paramSequence.hasNext()) {
        break;
      }
      paramCharSequence2 = paramSequence.next();
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        j = i;
        if (i > paramInt) {
          break;
        }
      }
      StringsKt.appendElement(paramA, paramCharSequence2, paramFunction1);
    }
    if ((paramInt >= 0) && (j > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  @NotNull
  public static final <T> String joinToString(@NotNull Sequence<? extends T> paramSequence, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super T, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramSequence = ((StringBuilder)SequencesKt.joinTo(paramSequence, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramSequence, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramSequence;
  }
  
  public static final <T> T last(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$last");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      throw ((Throwable)new NoSuchElementException("Sequence is empty."));
    }
    for (paramSequence = localIterator.next(); localIterator.hasNext(); paramSequence = localIterator.next()) {}
    return paramSequence;
  }
  
  public static final <T> T last(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Object localObject = null;
    int i = 0;
    Iterator localIterator = paramSequence.iterator();
    paramSequence = localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        break label88;
      }
      i = 1;
      paramSequence = localObject;
    }
    label88:
    for (;;)
    {
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Sequence contains no element matching the predicate."));
      }
      return paramSequence;
    }
  }
  
  public static final <T> int lastIndexOf(@NotNull Sequence<? extends T> paramSequence, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$lastIndexOf");
    int j = -1;
    int i = 0;
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      if (Intrinsics.areEqual(paramT, localObject)) {
        j = i;
      }
      i += 1;
    }
    return j;
  }
  
  @Nullable
  public static final <T> T lastOrNull(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$lastOrNull");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      paramSequence = null;
    }
    for (;;)
    {
      return paramSequence;
      for (paramSequence = localIterator.next(); localIterator.hasNext(); paramSequence = localIterator.next()) {}
    }
  }
  
  @Nullable
  public static final <T> T lastOrNull(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Object localObject = null;
    Iterator localIterator = paramSequence.iterator();
    paramSequence = localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        break label63;
      }
      paramSequence = localObject;
    }
    label63:
    for (;;)
    {
      break;
      return paramSequence;
    }
  }
  
  @NotNull
  public static final <T, R> Sequence<R> map(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return (Sequence)new TransformingSequence(paramSequence, paramFunction1);
  }
  
  @NotNull
  public static final <T, R> Sequence<R> mapIndexed(@NotNull Sequence<? extends T> paramSequence, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    return (Sequence)new TransformingIndexedSequence(paramSequence, paramFunction2);
  }
  
  @NotNull
  public static final <T, R> Sequence<R> mapIndexedNotNull(@NotNull Sequence<? extends T> paramSequence, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapIndexedNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    return SequencesKt.filterNotNull((Sequence)new TransformingIndexedSequence(paramSequence, paramFunction2));
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull Sequence<? extends T> paramSequence, @NotNull C paramC, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapIndexedNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        localObject = paramFunction2.invoke(Integer.valueOf(i), localObject);
        if (localObject != null) {
          paramC.add(localObject);
        }
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull Sequence<? extends T> paramSequence, @NotNull C paramC, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        paramC.add(paramFunction2.invoke(Integer.valueOf(i), localObject));
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, R> Sequence<R> mapNotNull(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return SequencesKt.filterNotNull((Sequence)new TransformingSequence(paramSequence, paramFunction1));
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Sequence<? extends T> paramSequence, @NotNull C paramC, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramFunction1.invoke(paramSequence.next());
      if (localObject != null) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull Sequence<? extends T> paramSequence, @NotNull C paramC, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      paramC.add(paramFunction1.invoke(paramSequence.next()));
    }
    return paramC;
  }
  
  @Nullable
  public static final <T extends Comparable<? super T>> T max(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$max");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      localObject = null;
    }
    do
    {
      return localObject;
      paramSequence = (Comparable)localIterator.next();
      localObject = paramSequence;
    } while (!localIterator.hasNext());
    Object localObject = (Comparable)localIterator.next();
    if (paramSequence.compareTo(localObject) < 0) {
      paramSequence = (Sequence<? extends T>)localObject;
    }
    for (;;)
    {
      break;
    }
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Double max(@NotNull Sequence<Double> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$max");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    double d2 = ((Number)paramSequence.next()).doubleValue();
    double d1 = d2;
    if (Double.isNaN(d2))
    {
      return Double.valueOf(d2);
      if (d1 >= d2) {
        break label99;
      }
      d1 = d2;
    }
    label99:
    for (;;)
    {
      if (paramSequence.hasNext())
      {
        d2 = ((Number)paramSequence.next()).doubleValue();
        if (!Double.isNaN(d2)) {
          break;
        }
        return Double.valueOf(d2);
      }
      return Double.valueOf(d1);
    }
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Float max(@NotNull Sequence<Float> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$max");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    float f2 = ((Number)paramSequence.next()).floatValue();
    float f1 = f2;
    if (Float.isNaN(f2))
    {
      return Float.valueOf(f2);
      if (f1 >= f2) {
        break label99;
      }
      f1 = f2;
    }
    label99:
    for (;;)
    {
      if (paramSequence.hasNext())
      {
        f2 = ((Number)paramSequence.next()).floatValue();
        if (!Float.isNaN(f2)) {
          break;
        }
        return Float.valueOf(f2);
      }
      return Float.valueOf(f1);
    }
  }
  
  @Nullable
  public static final <T, R extends Comparable<? super R>> T maxBy(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      localObject2 = null;
    }
    do
    {
      return localObject2;
      paramSequence = localIterator.next();
      localObject2 = paramSequence;
    } while (!localIterator.hasNext());
    Object localObject1 = (Comparable)paramFunction1.invoke(paramSequence);
    label67:
    Object localObject3 = localIterator.next();
    Object localObject2 = (Comparable)paramFunction1.invoke(localObject3);
    if (((Comparable)localObject1).compareTo(localObject2) < 0)
    {
      paramSequence = localObject3;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = paramSequence;
      if (!localIterator.hasNext()) {
        break;
      }
      break label67;
    }
  }
  
  @Nullable
  public static final <T> T maxWith(@NotNull Sequence<? extends T> paramSequence, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    Iterator localIterator = paramSequence.iterator();
    Object localObject;
    if (!localIterator.hasNext())
    {
      localObject = null;
      return localObject;
    }
    paramSequence = localIterator.next();
    for (;;)
    {
      localObject = paramSequence;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
      if (paramComparator.compare(paramSequence, localObject) < 0) {
        paramSequence = (Sequence<? extends T>)localObject;
      }
    }
  }
  
  @Nullable
  public static final <T extends Comparable<? super T>> T min(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$min");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      localObject = null;
    }
    do
    {
      return localObject;
      paramSequence = (Comparable)localIterator.next();
      localObject = paramSequence;
    } while (!localIterator.hasNext());
    Object localObject = (Comparable)localIterator.next();
    if (paramSequence.compareTo(localObject) > 0) {
      paramSequence = (Sequence<? extends T>)localObject;
    }
    for (;;)
    {
      break;
    }
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Double min(@NotNull Sequence<Double> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$min");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    double d2 = ((Number)paramSequence.next()).doubleValue();
    double d1 = d2;
    if (Double.isNaN(d2))
    {
      return Double.valueOf(d2);
      if (d1 <= d2) {
        break label99;
      }
      d1 = d2;
    }
    label99:
    for (;;)
    {
      if (paramSequence.hasNext())
      {
        d2 = ((Number)paramSequence.next()).doubleValue();
        if (!Double.isNaN(d2)) {
          break;
        }
        return Double.valueOf(d2);
      }
      return Double.valueOf(d1);
    }
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Float min(@NotNull Sequence<Float> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$min");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    float f2 = ((Number)paramSequence.next()).floatValue();
    float f1 = f2;
    if (Float.isNaN(f2))
    {
      return Float.valueOf(f2);
      if (f1 <= f2) {
        break label99;
      }
      f1 = f2;
    }
    label99:
    for (;;)
    {
      if (paramSequence.hasNext())
      {
        f2 = ((Number)paramSequence.next()).floatValue();
        if (!Float.isNaN(f2)) {
          break;
        }
        return Float.valueOf(f2);
      }
      return Float.valueOf(f1);
    }
  }
  
  @Nullable
  public static final <T, R extends Comparable<? super R>> T minBy(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      localObject2 = null;
    }
    do
    {
      return localObject2;
      paramSequence = localIterator.next();
      localObject2 = paramSequence;
    } while (!localIterator.hasNext());
    Object localObject1 = (Comparable)paramFunction1.invoke(paramSequence);
    label67:
    Object localObject3 = localIterator.next();
    Object localObject2 = (Comparable)paramFunction1.invoke(localObject3);
    if (((Comparable)localObject1).compareTo(localObject2) > 0)
    {
      paramSequence = localObject3;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = paramSequence;
      if (!localIterator.hasNext()) {
        break;
      }
      break label67;
    }
  }
  
  @Nullable
  public static final <T> T minWith(@NotNull Sequence<? extends T> paramSequence, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    Iterator localIterator = paramSequence.iterator();
    Object localObject;
    if (!localIterator.hasNext())
    {
      localObject = null;
      return localObject;
    }
    paramSequence = localIterator.next();
    for (;;)
    {
      localObject = paramSequence;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
      if (paramComparator.compare(paramSequence, localObject) > 0) {
        paramSequence = (Sequence<? extends T>)localObject;
      }
    }
  }
  
  @NotNull
  public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> paramSequence, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "elements");
    return (Sequence)new SequencesKt___SequencesKt.minus.3(paramSequence, paramIterable);
  }
  
  @NotNull
  public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> paramSequence, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$minus");
    return (Sequence)new SequencesKt___SequencesKt.minus.1(paramSequence, paramT);
  }
  
  @NotNull
  public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> paramSequence1, @NotNull Sequence<? extends T> paramSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence1, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramSequence2, "elements");
    return (Sequence)new SequencesKt___SequencesKt.minus.4(paramSequence1, paramSequence2);
  }
  
  @NotNull
  public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> paramSequence, @NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramSequence;
    }
    return (Sequence)new SequencesKt___SequencesKt.minus.2(paramSequence, paramArrayOfT);
  }
  
  @InlineOnly
  private static final <T> Sequence<T> minusElement(@NotNull Sequence<? extends T> paramSequence, T paramT)
  {
    return SequencesKt.minus(paramSequence, paramT);
  }
  
  public static final <T> boolean none(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$none");
    return !paramSequence.iterator().hasNext();
  }
  
  public static final <T> boolean none(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      if (((Boolean)paramFunction1.invoke(paramSequence.next())).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T> Sequence<T> onEach(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$onEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    return SequencesKt.map(paramSequence, (Function1)new SequencesKt___SequencesKt.onEach.1(paramFunction1));
  }
  
  @NotNull
  public static final <T> Pair<List<T>, List<T>> partition(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        localArrayList1.add(localObject);
      } else {
        localArrayList2.add(localObject);
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @NotNull
  public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> paramSequence, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "elements");
    return SequencesKt.flatten(SequencesKt.sequenceOf(new Sequence[] { paramSequence, CollectionsKt.asSequence(paramIterable) }));
  }
  
  @NotNull
  public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> paramSequence, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$plus");
    return SequencesKt.flatten(SequencesKt.sequenceOf(new Sequence[] { paramSequence, SequencesKt.sequenceOf(new Object[] { paramT }) }));
  }
  
  @NotNull
  public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> paramSequence1, @NotNull Sequence<? extends T> paramSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramSequence2, "elements");
    return SequencesKt.flatten(SequencesKt.sequenceOf(new Sequence[] { paramSequence1, paramSequence2 }));
  }
  
  @NotNull
  public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> paramSequence, @NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    return SequencesKt.plus(paramSequence, (Iterable)ArraysKt.asList(paramArrayOfT));
  }
  
  @InlineOnly
  private static final <T> Sequence<T> plusElement(@NotNull Sequence<? extends T> paramSequence, T paramT)
  {
    return SequencesKt.plus(paramSequence, paramT);
  }
  
  public static final <S, T extends S> S reduce(@NotNull Sequence<? extends T> paramSequence, @NotNull Function2<? super S, ? super T, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      throw ((Throwable)new UnsupportedOperationException("Empty sequence can't be reduced."));
    }
    for (paramSequence = localIterator.next(); localIterator.hasNext(); paramSequence = paramFunction2.invoke(paramSequence, localIterator.next())) {}
    return paramSequence;
  }
  
  public static final <S, T extends S> S reduceIndexed(@NotNull Sequence<? extends T> paramSequence, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      throw ((Throwable)new UnsupportedOperationException("Empty sequence can't be reduced."));
    }
    paramSequence = localIterator.next();
    int i = 1;
    while (localIterator.hasNext())
    {
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        paramSequence = paramFunction3.invoke(Integer.valueOf(i), paramSequence, localIterator.next());
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return paramSequence;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <S, T extends S> S reduceOrNull(@NotNull Sequence<? extends T> paramSequence, @NotNull Function2<? super S, ? super T, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Iterator localIterator = paramSequence.iterator();
    Object localObject;
    if (!localIterator.hasNext())
    {
      localObject = null;
      return localObject;
    }
    for (paramSequence = localIterator.next();; paramSequence = paramFunction2.invoke(paramSequence, localIterator.next()))
    {
      localObject = paramSequence;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
  
  @NotNull
  public static final <T> Sequence<T> requireNoNulls(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$requireNoNulls");
    return SequencesKt.map(paramSequence, (Function1)new SequencesKt___SequencesKt.requireNoNulls.1(paramSequence));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T, R> Sequence<R> scan(@NotNull Sequence<? extends T> paramSequence, R paramR, @NotNull Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$scan");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    return SequencesKt.sequence((Function2)new SequencesKt___SequencesKt.scan.1(paramSequence, paramR, paramFunction2, null));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T, R> Sequence<R> scanIndexed(@NotNull Sequence<? extends T> paramSequence, R paramR, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$scanIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    return SequencesKt.sequence((Function2)new SequencesKt___SequencesKt.scanIndexed.1(paramSequence, paramR, paramFunction3, null));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <S, T extends S> Sequence<S> scanReduce(@NotNull Sequence<? extends T> paramSequence, @NotNull Function2<? super S, ? super T, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$scanReduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    return SequencesKt.sequence((Function2)new SequencesKt___SequencesKt.scanReduce.1(paramSequence, paramFunction2, null));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <S, T extends S> Sequence<S> scanReduceIndexed(@NotNull Sequence<? extends T> paramSequence, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$scanReduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    return SequencesKt.sequence((Function2)new SequencesKt___SequencesKt.scanReduceIndexed.1(paramSequence, paramFunction3, null));
  }
  
  public static final <T> T single(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$single");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      throw ((Throwable)new NoSuchElementException("Sequence is empty."));
    }
    Object localObject = paramSequence.next();
    if (paramSequence.hasNext()) {
      throw ((Throwable)new IllegalArgumentException("Sequence has more than one element."));
    }
    return localObject;
  }
  
  public static final <T> T single(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Object localObject = null;
    int i = 0;
    Iterator localIterator = paramSequence.iterator();
    paramSequence = localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        break label106;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Sequence contains more than one matching element."));
      }
      i = 1;
      paramSequence = localObject;
    }
    label106:
    for (;;)
    {
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Sequence contains no element matching the predicate."));
      }
      return paramSequence;
    }
  }
  
  @Nullable
  public static final <T> T singleOrNull(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$singleOrNull");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {}
    Object localObject;
    do
    {
      return null;
      localObject = paramSequence.next();
    } while (paramSequence.hasNext());
    return localObject;
  }
  
  @Nullable
  public static final <T> T singleOrNull(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    Iterator localIterator = paramSequence.iterator();
    paramSequence = null;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        break label78;
      }
      if (i == 0) {}
    }
    label78:
    label79:
    for (;;)
    {
      return null;
      i = 1;
      paramSequence = localObject;
      for (;;)
      {
        break;
        if (i == 0) {
          break label79;
        }
        return paramSequence;
      }
    }
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> Sequence<T> sorted(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sorted");
    return (Sequence)new SequencesKt___SequencesKt.sorted.1(paramSequence);
  }
  
  @NotNull
  public static final <T, R extends Comparable<? super R>> Sequence<T> sortedBy(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return SequencesKt.sortedWith(paramSequence, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <T, R extends Comparable<? super R>> Sequence<T> sortedByDescending(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return SequencesKt.sortedWith(paramSequence, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> Sequence<T> sortedDescending(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sortedDescending");
    return SequencesKt.sortedWith(paramSequence, ComparisonsKt.reverseOrder());
  }
  
  @NotNull
  public static final <T> Sequence<T> sortedWith(@NotNull Sequence<? extends T> paramSequence, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (Sequence)new SequencesKt___SequencesKt.sortedWith.1(paramSequence, paramComparator);
  }
  
  public static final <T> int sumBy(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    paramSequence = paramSequence.iterator();
    for (int i = 0; paramSequence.hasNext(); i = ((Number)paramFunction1.invoke(paramSequence.next())).intValue() + i) {}
    return i;
  }
  
  public static final <T> double sumByDouble(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    paramSequence = paramSequence.iterator();
    for (double d = 0.0D; paramSequence.hasNext(); d = ((Number)paramFunction1.invoke(paramSequence.next())).doubleValue() + d) {}
    return d;
  }
  
  @JvmName(name="sumOfByte")
  public static final int sumOfByte(@NotNull Sequence<Byte> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (int i = 0; paramSequence.hasNext(); i = ((Number)paramSequence.next()).byteValue() + i) {}
    return i;
  }
  
  @JvmName(name="sumOfDouble")
  public static final double sumOfDouble(@NotNull Sequence<Double> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (double d = 0.0D; paramSequence.hasNext(); d = ((Number)paramSequence.next()).doubleValue() + d) {}
    return d;
  }
  
  @JvmName(name="sumOfFloat")
  public static final float sumOfFloat(@NotNull Sequence<Float> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (float f = 0.0F; paramSequence.hasNext(); f = ((Number)paramSequence.next()).floatValue() + f) {}
    return f;
  }
  
  @JvmName(name="sumOfInt")
  public static final int sumOfInt(@NotNull Sequence<Integer> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (int i = 0; paramSequence.hasNext(); i = ((Number)paramSequence.next()).intValue() + i) {}
    return i;
  }
  
  @JvmName(name="sumOfLong")
  public static final long sumOfLong(@NotNull Sequence<Long> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (long l = 0L; paramSequence.hasNext(); l = ((Number)paramSequence.next()).longValue() + l) {}
    return l;
  }
  
  @JvmName(name="sumOfShort")
  public static final int sumOfShort(@NotNull Sequence<Short> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (int i = 0; paramSequence.hasNext(); i = ((Number)paramSequence.next()).shortValue() + i) {}
    return i;
  }
  
  @NotNull
  public static final <T> Sequence<T> take(@NotNull Sequence<? extends T> paramSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return SequencesKt.emptySequence();
    }
    if ((paramSequence instanceof DropTakeSequence)) {
      return ((DropTakeSequence)paramSequence).take(paramInt);
    }
    return (Sequence)new TakeSequence(paramSequence, paramInt);
  }
  
  @NotNull
  public static final <T> Sequence<T> takeWhile(@NotNull Sequence<? extends T> paramSequence, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return (Sequence)new TakeWhileSequence(paramSequence, paramFunction1);
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C toCollection(@NotNull Sequence<? extends T> paramSequence, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      paramC.add(paramSequence.next());
    }
    return paramC;
  }
  
  @NotNull
  public static final <T> HashSet<T> toHashSet(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toHashSet");
    return (HashSet)SequencesKt.toCollection(paramSequence, (Collection)new HashSet());
  }
  
  @NotNull
  public static final <T> List<T> toList(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toList");
    return CollectionsKt.optimizeReadOnlyList(SequencesKt.toMutableList(paramSequence));
  }
  
  @NotNull
  public static final <T> List<T> toMutableList(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toMutableList");
    return (List)SequencesKt.toCollection(paramSequence, (Collection)new ArrayList());
  }
  
  @NotNull
  public static final <T> Set<T> toMutableSet(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      localLinkedHashSet.add(paramSequence.next());
    }
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final <T> Set<T> toSet(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toSet");
    return SetsKt.optimizeReadOnlySet((Set)SequencesKt.toCollection(paramSequence, (Collection)new LinkedHashSet()));
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T> Sequence<List<T>> windowed(@NotNull Sequence<? extends T> paramSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$windowed");
    return SlidingWindowKt.windowedSequence(paramSequence, paramInt1, paramInt2, paramBoolean, false);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T, R> Sequence<R> windowed(@NotNull Sequence<? extends T> paramSequence, int paramInt1, int paramInt2, boolean paramBoolean, @NotNull Function1<? super List<? extends T>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$windowed");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return SequencesKt.map(SlidingWindowKt.windowedSequence(paramSequence, paramInt1, paramInt2, paramBoolean, true), paramFunction1);
  }
  
  @NotNull
  public static final <T> Sequence<IndexedValue<T>> withIndex(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$withIndex");
    return (Sequence)new IndexingSequence(paramSequence);
  }
  
  @NotNull
  public static final <T, R> Sequence<Pair<T, R>> zip(@NotNull Sequence<? extends T> paramSequence, @NotNull Sequence<? extends R> paramSequence1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramSequence1, "other");
    return (Sequence)new MergingSequence(paramSequence, paramSequence1, (Function2)SequencesKt___SequencesKt.zip.1.INSTANCE);
  }
  
  @NotNull
  public static final <T, R, V> Sequence<V> zip(@NotNull Sequence<? extends T> paramSequence, @NotNull Sequence<? extends R> paramSequence1, @NotNull Function2<? super T, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramSequence1, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    return (Sequence)new MergingSequence(paramSequence, paramSequence1, paramFunction2);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T> Sequence<Pair<T, T>> zipWithNext(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$zipWithNext");
    return SequencesKt.zipWithNext(paramSequence, (Function2)SequencesKt___SequencesKt.zipWithNext.1.INSTANCE);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T, R> Sequence<R> zipWithNext(@NotNull Sequence<? extends T> paramSequence, @NotNull Function2<? super T, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$zipWithNext");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    return SequencesKt.sequence((Function2)new SequencesKt___SequencesKt.zipWithNext.2(paramSequence, paramFunction2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt
 * JD-Core Version:    0.7.0.1
 */