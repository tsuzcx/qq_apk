package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareBy.2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareByDescending.1;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"all", "", "T", "", "predicate", "Lkotlin/Function1;", "any", "asIterable", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "average", "", "", "averageOfByte", "averageOfDouble", "", "averageOfFloat", "", "averageOfInt", "", "averageOfLong", "", "averageOfShort", "chunked", "", "size", "R", "component1", "(Ljava/util/List;)Ljava/lang/Object;", "component2", "component3", "component4", "component5", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "count", "", "distinct", "distinctBy", "selector", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAt", "index", "(Ljava/lang/Iterable;I)Ljava/lang/Object;", "(Ljava/util/List;I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(Ljava/lang/Iterable;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "", "(Ljava/lang/Iterable;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "(Ljava/lang/Iterable;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "(Ljava/lang/Iterable;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "findLast", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "first", "(Ljava/lang/Iterable;)Ljava/lang/Object;", "firstOrNull", "flatMap", "flatMapTo", "fold", "initial", "operation", "acc", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldRightIndexed", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOf", "(Ljava/lang/Iterable;Ljava/lang/Object;)I", "(Ljava/util/List;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "intersect", "", "other", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "(Ljava/lang/Iterable;)Ljava/lang/Double;", "(Ljava/lang/Iterable;)Ljava/lang/Float;", "maxBy", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "minus", "(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/util/List;", "elements", "", "(Ljava/lang/Iterable;[Ljava/lang/Object;)Ljava/util/List;", "minusElement", "none", "onEach", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Iterable;", "partition", "plus", "(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;", "(Ljava/util/Collection;[Ljava/lang/Object;)Ljava/util/List;", "plusElement", "random", "(Ljava/util/Collection;)Ljava/lang/Object;", "Lkotlin/random/Random;", "(Ljava/util/Collection;Lkotlin/random/Random;)Ljava/lang/Object;", "randomOrNull", "reduce", "S", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceOrNull", "reduceRight", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceRightIndexed", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceRightOrNull", "requireNoNulls", "reversed", "scan", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scanIndexed", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduce", "scanReduceIndexed", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sortBy", "sortByDescending", "sortDescending", "sorted", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "subtract", "sum", "sumOfByte", "sumOfDouble", "sumOfFloat", "sumOfInt", "sumOfLong", "sumOfShort", "sumBy", "sumByDouble", "take", "takeLast", "takeLastWhile", "takeWhile", "toBooleanArray", "", "toByteArray", "", "toCharArray", "", "", "toCollection", "toDoubleArray", "", "toFloatArray", "", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toIntArray", "", "toList", "toLongArray", "", "toMutableList", "toMutableSet", "", "toSet", "toShortArray", "", "union", "windowed", "step", "partialWindows", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "a", "b", "(Ljava/lang/Iterable;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zipWithNext", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/CollectionsKt")
public class CollectionsKt___CollectionsKt
  extends CollectionsKt___CollectionsJvmKt
{
  public static final <T> boolean all(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (((paramIterable instanceof Collection)) && (((Collection)paramIterable).isEmpty())) {
      return true;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (!((Boolean)paramFunction1.invoke(paramIterable.next())).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  public static final <T> boolean any(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$any");
    if ((paramIterable instanceof Collection)) {
      return !((Collection)paramIterable).isEmpty();
    }
    return paramIterable.iterator().hasNext();
  }
  
  public static final <T> boolean any(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (((paramIterable instanceof Collection)) && (((Collection)paramIterable).isEmpty())) {
      return false;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (((Boolean)paramFunction1.invoke(paramIterable.next())).booleanValue()) {
        return true;
      }
    }
    return false;
  }
  
  @InlineOnly
  private static final <T> Iterable<T> asIterable(@NotNull Iterable<? extends T> paramIterable)
  {
    return paramIterable;
  }
  
  @NotNull
  public static final <T> Sequence<T> asSequence(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$asSequence");
    return (Sequence)new CollectionsKt___CollectionsKt.asSequence..inlined.Sequence.1(paramIterable);
  }
  
  @NotNull
  public static final <T, K, V> Map<K, V> associate(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(paramIterable, 10)), 16));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Pair localPair = (Pair)paramFunction1.invoke(paramIterable.next());
      localMap.put(localPair.getFirst(), localPair.getSecond());
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K> Map<K, T> associateBy(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(paramIterable, 10)), 16));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      localMap.put(paramFunction1.invoke(localObject), localObject);
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, V> Map<K, V> associateBy(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(paramIterable, 10)), 16));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      localMap.put(paramFunction1.invoke(localObject), paramFunction11.invoke(localObject));
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull Iterable<? extends T> paramIterable, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      paramM.put(paramFunction1.invoke(localObject), localObject);
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull Iterable<? extends T> paramIterable, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      paramM.put(paramFunction1.invoke(localObject), paramFunction11.invoke(localObject));
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull Iterable<? extends T> paramIterable, @NotNull M paramM, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Pair localPair = (Pair)paramFunction1.invoke(paramIterable.next());
      paramM.put(localPair.getFirst(), localPair.getSecond());
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <K, V> Map<K, V> associateWith(@NotNull Iterable<? extends K> paramIterable, @NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$associateWith");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "valueSelector");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(paramIterable, 10)), 16));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      ((Map)localLinkedHashMap).put(localObject, paramFunction1.invoke(localObject));
    }
    return (Map)localLinkedHashMap;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(@NotNull Iterable<? extends K> paramIterable, @NotNull M paramM, @NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$associateWithTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "valueSelector");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      paramM.put(localObject, paramFunction1.invoke(localObject));
    }
    return paramM;
  }
  
  @JvmName(name="averageOfByte")
  public static final double averageOfByte(@NotNull Iterable<Byte> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$average");
    double d = 0.0D;
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      d += ((Number)paramIterable.next()).byteValue();
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
  public static final double averageOfDouble(@NotNull Iterable<Double> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$average");
    double d = 0.0D;
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      d += ((Number)paramIterable.next()).doubleValue();
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
  public static final double averageOfFloat(@NotNull Iterable<Float> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$average");
    double d = 0.0D;
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      d += ((Number)paramIterable.next()).floatValue();
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
  public static final double averageOfInt(@NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$average");
    double d = 0.0D;
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      d += ((Number)paramIterable.next()).intValue();
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
  public static final double averageOfLong(@NotNull Iterable<Long> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$average");
    double d = 0.0D;
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      d += ((Number)paramIterable.next()).longValue();
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
  public static final double averageOfShort(@NotNull Iterable<Short> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$average");
    double d = 0.0D;
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      d += ((Number)paramIterable.next()).shortValue();
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
  public static final <T> List<List<T>> chunked(@NotNull Iterable<? extends T> paramIterable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$chunked");
    return CollectionsKt.windowed(paramIterable, paramInt, paramInt, true);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T, R> List<R> chunked(@NotNull Iterable<? extends T> paramIterable, int paramInt, @NotNull Function1<? super List<? extends T>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$chunked");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return CollectionsKt.windowed(paramIterable, paramInt, paramInt, true, paramFunction1);
  }
  
  @InlineOnly
  private static final <T> T component1(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$component1");
    return paramList.get(0);
  }
  
  @InlineOnly
  private static final <T> T component2(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$component2");
    return paramList.get(1);
  }
  
  @InlineOnly
  private static final <T> T component3(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$component3");
    return paramList.get(2);
  }
  
  @InlineOnly
  private static final <T> T component4(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$component4");
    return paramList.get(3);
  }
  
  @InlineOnly
  private static final <T> T component5(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$component5");
    return paramList.get(4);
  }
  
  public static final <T> boolean contains(@NotNull Iterable<? extends T> paramIterable, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$contains");
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).contains(paramT);
    }
    return CollectionsKt.indexOf(paramIterable, paramT) >= 0;
  }
  
  public static final <T> int count(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$count");
    int j;
    if ((paramIterable instanceof Collection))
    {
      j = ((Collection)paramIterable).size();
      return j;
    }
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      j = i;
      if (!paramIterable.hasNext()) {
        break;
      }
      paramIterable.next();
      j = i + 1;
      i = j;
      if (j < 0)
      {
        CollectionsKt.throwCountOverflow();
        i = j;
      }
    }
  }
  
  public static final <T> int count(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (((paramIterable instanceof Collection)) && (((Collection)paramIterable).isEmpty())) {
      return 0;
    }
    paramIterable = paramIterable.iterator();
    int i = 0;
    if (paramIterable.hasNext())
    {
      if (!((Boolean)paramFunction1.invoke(paramIterable.next())).booleanValue()) {
        break label117;
      }
      int j = i + 1;
      i = j;
      if (j < 0)
      {
        if (!PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          break label101;
        }
        CollectionsKt.throwCountOverflow();
        i = j;
      }
    }
    label101:
    label117:
    for (;;)
    {
      break;
      throw ((Throwable)new ArithmeticException("Count overflow has happened."));
      return i;
    }
  }
  
  @InlineOnly
  private static final <T> int count(@NotNull Collection<? extends T> paramCollection)
  {
    return paramCollection.size();
  }
  
  @NotNull
  public static final <T> List<T> distinct(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$distinct");
    return CollectionsKt.toList((Iterable)CollectionsKt.toMutableSet(paramIterable));
  }
  
  @NotNull
  public static final <T, K> List<T> distinctBy(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (localHashSet.add(paramFunction1.invoke(localObject))) {
        localArrayList.add(localObject);
      }
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> drop(@NotNull Iterable<? extends T> paramIterable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.toList(paramIterable);
    }
    ArrayList localArrayList;
    if ((paramIterable instanceof Collection))
    {
      i = ((Collection)paramIterable).size() - paramInt;
      if (i <= 0) {
        return CollectionsKt.emptyList();
      }
      if (i == 1) {
        return CollectionsKt.listOf(CollectionsKt.last(paramIterable));
      }
      localArrayList = new ArrayList(i);
      if ((paramIterable instanceof List))
      {
        if ((paramIterable instanceof RandomAccess))
        {
          i = ((Collection)paramIterable).size();
          while (paramInt < i)
          {
            localArrayList.add(((List)paramIterable).get(paramInt));
            paramInt += 1;
          }
        }
        paramIterable = (Iterator)((List)paramIterable).listIterator(paramInt);
        while (paramIterable.hasNext()) {
          localArrayList.add(paramIterable.next());
        }
        return (List)localArrayList;
      }
    }
    else
    {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      paramIterable = paramIterable.iterator();
      i = 0;
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (i >= paramInt) {
          localArrayList.add(localObject);
        } else {
          i += 1;
        }
      }
      return CollectionsKt.optimizeReadOnlyList((List)localArrayList);
    }
  }
  
  @NotNull
  public static final <T> List<T> dropLast(@NotNull List<? extends T> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return CollectionsKt.take((Iterable)paramList, RangesKt.coerceAtLeast(paramList.size() - paramInt, 0));
  }
  
  @NotNull
  public static final <T> List<T> dropLastWhile(@NotNull List<? extends T> paramList, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (!paramList.isEmpty())
    {
      ListIterator localListIterator = paramList.listIterator(paramList.size());
      while (localListIterator.hasPrevious()) {
        if (!((Boolean)paramFunction1.invoke(localListIterator.previous())).booleanValue()) {
          return CollectionsKt.take((Iterable)paramList, localListIterator.nextIndex() + 1);
        }
      }
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final <T> List<T> dropWhile(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    int i = 0;
    Object localObject;
    if (paramIterable.hasNext())
    {
      localObject = paramIterable.next();
      if (i != 0) {
        localArrayList.add(localObject);
      }
    }
    for (;;)
    {
      break;
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue())
      {
        localArrayList.add(localObject);
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  public static final <T> T elementAt(@NotNull Iterable<? extends T> paramIterable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$elementAt");
    if ((paramIterable instanceof List)) {
      return ((List)paramIterable).get(paramInt);
    }
    return CollectionsKt.elementAtOrElse(paramIterable, paramInt, (Function1)new CollectionsKt___CollectionsKt.elementAt.1(paramInt));
  }
  
  @InlineOnly
  private static final <T> T elementAt(@NotNull List<? extends T> paramList, int paramInt)
  {
    return paramList.get(paramInt);
  }
  
  public static final <T> T elementAtOrElse(@NotNull Iterable<? extends T> paramIterable, int paramInt, @NotNull Function1<? super Integer, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$elementAtOrElse");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "defaultValue");
    if ((paramIterable instanceof List))
    {
      paramIterable = (List)paramIterable;
      if ((paramInt >= 0) && (paramInt <= CollectionsKt.getLastIndex(paramIterable))) {
        return paramIterable.get(paramInt);
      }
      return paramFunction1.invoke(Integer.valueOf(paramInt));
    }
    if (paramInt < 0) {
      return paramFunction1.invoke(Integer.valueOf(paramInt));
    }
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramInt == i) {
        return localObject;
      }
      i += 1;
    }
    return paramFunction1.invoke(Integer.valueOf(paramInt));
  }
  
  @InlineOnly
  private static final <T> T elementAtOrElse(@NotNull List<? extends T> paramList, int paramInt, Function1<? super Integer, ? extends T> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= CollectionsKt.getLastIndex(paramList))) {
      return paramList.get(paramInt);
    }
    return paramFunction1.invoke(Integer.valueOf(paramInt));
  }
  
  @Nullable
  public static final <T> T elementAtOrNull(@NotNull Iterable<? extends T> paramIterable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$elementAtOrNull");
    if ((paramIterable instanceof List)) {
      return CollectionsKt.getOrNull((List)paramIterable, paramInt);
    }
    if (paramInt < 0) {
      return null;
    }
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramInt == i) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final <T> T elementAtOrNull(@NotNull List<? extends T> paramList, int paramInt)
  {
    return CollectionsKt.getOrNull(paramList, paramInt);
  }
  
  @NotNull
  public static final <T> List<T> filter(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        localCollection.add(localObject);
      }
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T> List<T> filterIndexed(@NotNull Iterable<? extends T> paramIterable, @NotNull Function2<? super Integer, ? super T, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), localObject)).booleanValue()) {
          localCollection.add(localObject);
        }
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull Iterable<? extends T> paramIterable, @NotNull C paramC, @NotNull Function2<? super Integer, ? super T, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
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
  public static final <T> List<T> filterNot(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        localCollection.add(localObject);
      }
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T> List<T> filterNotNull(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterNotNull");
    return (List)CollectionsKt.filterNotNullTo(paramIterable, (Collection)new ArrayList());
  }
  
  @NotNull
  public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull Iterable<? extends T> paramIterable, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (localObject != null) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull Iterable<? extends T> paramIterable, @NotNull C paramC, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C filterTo(@NotNull Iterable<? extends T> paramIterable, @NotNull C paramC, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  @InlineOnly
  private static final <T> T find(@NotNull Iterable<? extends T> paramIterable, Function1<? super T, Boolean> paramFunction1)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return localObject;
      }
    }
    return null;
  }
  
  @InlineOnly
  private static final <T> T findLast(@NotNull Iterable<? extends T> paramIterable, Function1<? super T, Boolean> paramFunction1)
  {
    Object localObject = null;
    Iterator localIterator = paramIterable.iterator();
    paramIterable = localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        break label50;
      }
      paramIterable = localObject;
    }
    label50:
    for (;;)
    {
      break;
      return paramIterable;
    }
  }
  
  @InlineOnly
  private static final <T> T findLast(@NotNull List<? extends T> paramList, Function1<? super T, Boolean> paramFunction1)
  {
    paramList = paramList.listIterator(paramList.size());
    while (paramList.hasPrevious())
    {
      Object localObject = paramList.previous();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return localObject;
      }
    }
    return null;
  }
  
  public static final <T> T first(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$first");
    if ((paramIterable instanceof List)) {
      return CollectionsKt.first((List)paramIterable);
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      throw ((Throwable)new NoSuchElementException("Collection is empty."));
    }
    return paramIterable.next();
  }
  
  public static final <T> T first(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return localObject;
      }
    }
    throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
  }
  
  public static final <T> T first(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$first");
    if (paramList.isEmpty()) {
      throw ((Throwable)new NoSuchElementException("List is empty."));
    }
    return paramList.get(0);
  }
  
  @Nullable
  public static final <T> T firstOrNull(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$firstOrNull");
    if ((paramIterable instanceof List))
    {
      if (((List)paramIterable).isEmpty()) {
        return null;
      }
      return ((List)paramIterable).get(0);
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return null;
    }
    return paramIterable.next();
  }
  
  @Nullable
  public static final <T> T firstOrNull(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return localObject;
      }
    }
    return null;
  }
  
  @Nullable
  public static final <T> T firstOrNull(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$firstOrNull");
    if (paramList.isEmpty()) {
      return null;
    }
    return paramList.get(0);
  }
  
  @NotNull
  public static final <T, R> List<R> flatMap(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(paramIterable.next()));
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull Iterable<? extends T> paramIterable, @NotNull C paramC, @NotNull Function1<? super T, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(paramIterable.next()));
    }
    return paramC;
  }
  
  public static final <T, R> R fold(@NotNull Iterable<? extends T> paramIterable, R paramR, @NotNull Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramR = paramFunction2.invoke(paramR, paramIterable.next());
    }
    return paramR;
  }
  
  public static final <T, R> R foldIndexed(@NotNull Iterable<? extends T> paramIterable, R paramR, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
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
  
  public static final <T, R> R foldRight(@NotNull List<? extends T> paramList, R paramR, @NotNull Function2<? super T, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    R ? = paramR;
    if (!paramList.isEmpty())
    {
      paramList = paramList.listIterator(paramList.size());
      for (;;)
      {
        ? = paramR;
        if (!paramList.hasPrevious()) {
          break;
        }
        paramR = paramFunction2.invoke(paramList.previous(), paramR);
      }
    }
    return ?;
  }
  
  public static final <T, R> R foldRightIndexed(@NotNull List<? extends T> paramList, R paramR, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    R ? = paramR;
    if (!paramList.isEmpty())
    {
      paramList = paramList.listIterator(paramList.size());
      for (;;)
      {
        ? = paramR;
        if (!paramList.hasPrevious()) {
          break;
        }
        paramR = paramFunction3.invoke(Integer.valueOf(paramList.previousIndex()), paramList.previous(), paramR);
      }
    }
    return ?;
  }
  
  @HidesMembers
  public static final <T> void forEach(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramFunction1.invoke(paramIterable.next());
    }
  }
  
  public static final <T> void forEachIndexed(@NotNull Iterable<? extends T> paramIterable, @NotNull Function2<? super Integer, ? super T, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
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
  
  @InlineOnly
  private static final <T> T getOrElse(@NotNull List<? extends T> paramList, int paramInt, Function1<? super Integer, ? extends T> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= CollectionsKt.getLastIndex(paramList))) {
      return paramList.get(paramInt);
    }
    return paramFunction1.invoke(Integer.valueOf(paramInt));
  }
  
  @Nullable
  public static final <T> T getOrNull(@NotNull List<? extends T> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= CollectionsKt.getLastIndex(paramList))) {
      return paramList.get(paramInt);
    }
    return null;
  }
  
  @NotNull
  public static final <T, K> Map<K, List<T>> groupBy(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramFunction1.invoke(localObject1);
      paramIterable = localMap.get(localObject2);
      if (paramIterable == null)
      {
        paramIterable = new ArrayList();
        localMap.put(localObject2, paramIterable);
      }
      for (;;)
      {
        ((List)paramIterable).add(localObject1);
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramFunction1.invoke(localObject1);
      paramIterable = localMap.get(localObject2);
      if (paramIterable == null)
      {
        paramIterable = new ArrayList();
        localMap.put(localObject2, paramIterable);
      }
      for (;;)
      {
        ((List)paramIterable).add(paramFunction11.invoke(localObject1));
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull Iterable<? extends T> paramIterable, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramFunction1.invoke(localObject1);
      paramIterable = paramM.get(localObject2);
      if (paramIterable == null)
      {
        paramIterable = new ArrayList();
        paramM.put(localObject2, paramIterable);
      }
      for (;;)
      {
        ((List)paramIterable).add(localObject1);
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull Iterable<? extends T> paramIterable, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramFunction1.invoke(localObject1);
      paramIterable = paramM.get(localObject2);
      if (paramIterable == null)
      {
        paramIterable = new ArrayList();
        paramM.put(localObject2, paramIterable);
      }
      for (;;)
      {
        ((List)paramIterable).add(paramFunction11.invoke(localObject1));
        break;
      }
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K> Grouping<T, K> groupingBy(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$groupingBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    return (Grouping)new CollectionsKt___CollectionsKt.groupingBy.1(paramIterable, paramFunction1);
  }
  
  public static final <T> int indexOf(@NotNull Iterable<? extends T> paramIterable, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$indexOf");
    int j;
    if ((paramIterable instanceof List))
    {
      j = ((List)paramIterable).indexOf(paramT);
      return j;
    }
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      if (!paramIterable.hasNext()) {
        break label78;
      }
      Object localObject = paramIterable.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      j = i;
      if (Intrinsics.areEqual(paramT, localObject)) {
        break;
      }
      i += 1;
    }
    label78:
    return -1;
  }
  
  public static final <T> int indexOf(@NotNull List<? extends T> paramList, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$indexOf");
    return paramList.indexOf(paramT);
  }
  
  public static final <T> int indexOfFirst(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
          break label87;
        }
        return i;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
      label87:
      i += 1;
    }
    return -1;
  }
  
  public static final <T> int indexOfFirst(@NotNull List<? extends T> paramList, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      if (((Boolean)paramFunction1.invoke(paramList.next())).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final <T> int indexOfLast(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramIterable = paramIterable.iterator();
    int i = 0;
    int j = -1;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
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
  
  public static final <T> int indexOfLast(@NotNull List<? extends T> paramList, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramList = paramList.listIterator(paramList.size());
    while (paramList.hasPrevious()) {
      if (((Boolean)paramFunction1.invoke(paramList.previous())).booleanValue()) {
        return paramList.nextIndex();
      }
    }
    return -1;
  }
  
  @NotNull
  public static final <T> Set<T> intersect(@NotNull Iterable<? extends T> paramIterable1, @NotNull Iterable<? extends T> paramIterable2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable1, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramIterable2, "other");
    paramIterable1 = CollectionsKt.toMutableSet(paramIterable1);
    CollectionsKt.retainAll((Collection)paramIterable1, paramIterable2);
    return paramIterable1;
  }
  
  @NotNull
  public static final <T, A extends Appendable> A joinTo(@NotNull Iterable<? extends T> paramIterable, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super T, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int i = 0;
    paramIterable = paramIterable.iterator();
    int j;
    for (;;)
    {
      j = i;
      if (!paramIterable.hasNext()) {
        break;
      }
      paramCharSequence2 = paramIterable.next();
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
  public static final <T> String joinToString(@NotNull Iterable<? extends T> paramIterable, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super T, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramIterable = ((StringBuilder)CollectionsKt.joinTo(paramIterable, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramIterable, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramIterable;
  }
  
  public static final <T> T last(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$last");
    if ((paramIterable instanceof List)) {
      paramIterable = CollectionsKt.last((List)paramIterable);
    }
    for (;;)
    {
      return paramIterable;
      Iterator localIterator = paramIterable.iterator();
      if (!localIterator.hasNext()) {
        throw ((Throwable)new NoSuchElementException("Collection is empty."));
      }
      for (paramIterable = localIterator.next(); localIterator.hasNext(); paramIterable = localIterator.next()) {}
    }
  }
  
  public static final <T> T last(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Object localObject = null;
    int i = 0;
    Iterator localIterator = paramIterable.iterator();
    paramIterable = localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        break label89;
      }
      i = 1;
      paramIterable = localObject;
    }
    label89:
    for (;;)
    {
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
      }
      return paramIterable;
    }
  }
  
  public static final <T> T last(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$last");
    if (paramList.isEmpty()) {
      throw ((Throwable)new NoSuchElementException("List is empty."));
    }
    return paramList.get(CollectionsKt.getLastIndex(paramList));
  }
  
  public static final <T> T last(@NotNull List<? extends T> paramList, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramList = paramList.listIterator(paramList.size());
    while (paramList.hasPrevious())
    {
      Object localObject = paramList.previous();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return localObject;
      }
    }
    throw ((Throwable)new NoSuchElementException("List contains no element matching the predicate."));
  }
  
  public static final <T> int lastIndexOf(@NotNull Iterable<? extends T> paramIterable, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$lastIndexOf");
    int k;
    if ((paramIterable instanceof List))
    {
      k = ((List)paramIterable).lastIndexOf(paramT);
      return k;
    }
    int j = -1;
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      k = j;
      if (!paramIterable.hasNext()) {
        break;
      }
      Object localObject = paramIterable.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      if (Intrinsics.areEqual(paramT, localObject)) {
        j = i;
      }
      i += 1;
    }
  }
  
  public static final <T> int lastIndexOf(@NotNull List<? extends T> paramList, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$lastIndexOf");
    return paramList.lastIndexOf(paramT);
  }
  
  @Nullable
  public static final <T> T lastOrNull(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$lastOrNull");
    if ((paramIterable instanceof List)) {
      if (((List)paramIterable).isEmpty()) {
        paramIterable = null;
      }
    }
    for (;;)
    {
      return paramIterable;
      return ((List)paramIterable).get(((List)paramIterable).size() - 1);
      Iterator localIterator = paramIterable.iterator();
      if (!localIterator.hasNext()) {
        return null;
      }
      for (paramIterable = localIterator.next(); localIterator.hasNext(); paramIterable = localIterator.next()) {}
    }
  }
  
  @Nullable
  public static final <T> T lastOrNull(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Object localObject = null;
    Iterator localIterator = paramIterable.iterator();
    paramIterable = localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        break label64;
      }
      paramIterable = localObject;
    }
    label64:
    for (;;)
    {
      break;
      return paramIterable;
    }
  }
  
  @Nullable
  public static final <T> T lastOrNull(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$lastOrNull");
    if (paramList.isEmpty()) {
      return null;
    }
    return paramList.get(paramList.size() - 1);
  }
  
  @Nullable
  public static final <T> T lastOrNull(@NotNull List<? extends T> paramList, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramList = paramList.listIterator(paramList.size());
    while (paramList.hasPrevious())
    {
      Object localObject = paramList.previous();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return localObject;
      }
    }
    return null;
  }
  
  @NotNull
  public static final <T, R> List<R> map(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramIterable, 10));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localCollection.add(paramFunction1.invoke(paramIterable.next()));
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R> List<R> mapIndexed(@NotNull Iterable<? extends T> paramIterable, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramIterable, 10));
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        localCollection.add(paramFunction2.invoke(Integer.valueOf(i), localObject));
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R> List<R> mapIndexedNotNull(@NotNull Iterable<? extends T> paramIterable, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$mapIndexedNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList();
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
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
          localCollection.add(localObject);
        }
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull Iterable<? extends T> paramIterable, @NotNull C paramC, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$mapIndexedNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
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
  public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull Iterable<? extends T> paramIterable, @NotNull C paramC, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
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
  public static final <T, R> List<R> mapNotNull(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$mapNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramFunction1.invoke(paramIterable.next());
      if (localObject != null) {
        localCollection.add(localObject);
      }
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Iterable<? extends T> paramIterable, @NotNull C paramC, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$mapNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramFunction1.invoke(paramIterable.next());
      if (localObject != null) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull Iterable<? extends T> paramIterable, @NotNull C paramC, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramC.add(paramFunction1.invoke(paramIterable.next()));
    }
    return paramC;
  }
  
  @Nullable
  public static final <T extends Comparable<? super T>> T max(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$max");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      localObject = null;
    }
    do
    {
      return localObject;
      paramIterable = (Comparable)localIterator.next();
      localObject = paramIterable;
    } while (!localIterator.hasNext());
    Object localObject = (Comparable)localIterator.next();
    if (paramIterable.compareTo(localObject) < 0) {
      paramIterable = (Iterable<? extends T>)localObject;
    }
    for (;;)
    {
      break;
    }
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Double max(@NotNull Iterable<Double> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$max");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return null;
    }
    double d2 = ((Number)paramIterable.next()).doubleValue();
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
      if (paramIterable.hasNext())
      {
        d2 = ((Number)paramIterable.next()).doubleValue();
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
  public static final Float max(@NotNull Iterable<Float> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$max");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return null;
    }
    float f2 = ((Number)paramIterable.next()).floatValue();
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
      if (paramIterable.hasNext())
      {
        f2 = ((Number)paramIterable.next()).floatValue();
        if (!Float.isNaN(f2)) {
          break;
        }
        return Float.valueOf(f2);
      }
      return Float.valueOf(f1);
    }
  }
  
  @Nullable
  public static final <T, R extends Comparable<? super R>> T maxBy(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      localObject2 = null;
    }
    do
    {
      return localObject2;
      paramIterable = localIterator.next();
      localObject2 = paramIterable;
    } while (!localIterator.hasNext());
    Object localObject1 = (Comparable)paramFunction1.invoke(paramIterable);
    label67:
    Object localObject3 = localIterator.next();
    Object localObject2 = (Comparable)paramFunction1.invoke(localObject3);
    if (((Comparable)localObject1).compareTo(localObject2) < 0)
    {
      paramIterable = localObject3;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = paramIterable;
      if (!localIterator.hasNext()) {
        break;
      }
      break label67;
    }
  }
  
  @Nullable
  public static final <T> T maxWith(@NotNull Iterable<? extends T> paramIterable, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    Iterator localIterator = paramIterable.iterator();
    Object localObject;
    if (!localIterator.hasNext())
    {
      localObject = null;
      return localObject;
    }
    paramIterable = localIterator.next();
    for (;;)
    {
      localObject = paramIterable;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
      if (paramComparator.compare(paramIterable, localObject) < 0) {
        paramIterable = (Iterable<? extends T>)localObject;
      }
    }
  }
  
  @Nullable
  public static final <T extends Comparable<? super T>> T min(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$min");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      localObject = null;
    }
    do
    {
      return localObject;
      paramIterable = (Comparable)localIterator.next();
      localObject = paramIterable;
    } while (!localIterator.hasNext());
    Object localObject = (Comparable)localIterator.next();
    if (paramIterable.compareTo(localObject) > 0) {
      paramIterable = (Iterable<? extends T>)localObject;
    }
    for (;;)
    {
      break;
    }
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Double min(@NotNull Iterable<Double> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$min");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return null;
    }
    double d2 = ((Number)paramIterable.next()).doubleValue();
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
      if (paramIterable.hasNext())
      {
        d2 = ((Number)paramIterable.next()).doubleValue();
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
  public static final Float min(@NotNull Iterable<Float> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$min");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return null;
    }
    float f2 = ((Number)paramIterable.next()).floatValue();
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
      if (paramIterable.hasNext())
      {
        f2 = ((Number)paramIterable.next()).floatValue();
        if (!Float.isNaN(f2)) {
          break;
        }
        return Float.valueOf(f2);
      }
      return Float.valueOf(f1);
    }
  }
  
  @Nullable
  public static final <T, R extends Comparable<? super R>> T minBy(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      localObject2 = null;
    }
    do
    {
      return localObject2;
      paramIterable = localIterator.next();
      localObject2 = paramIterable;
    } while (!localIterator.hasNext());
    Object localObject1 = (Comparable)paramFunction1.invoke(paramIterable);
    label67:
    Object localObject3 = localIterator.next();
    Object localObject2 = (Comparable)paramFunction1.invoke(localObject3);
    if (((Comparable)localObject1).compareTo(localObject2) > 0)
    {
      paramIterable = localObject3;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = paramIterable;
      if (!localIterator.hasNext()) {
        break;
      }
      break label67;
    }
  }
  
  @Nullable
  public static final <T> T minWith(@NotNull Iterable<? extends T> paramIterable, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    Iterator localIterator = paramIterable.iterator();
    Object localObject;
    if (!localIterator.hasNext())
    {
      localObject = null;
      return localObject;
    }
    paramIterable = localIterator.next();
    for (;;)
    {
      localObject = paramIterable;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
      if (paramComparator.compare(paramIterable, localObject) > 0) {
        paramIterable = (Iterable<? extends T>)localObject;
      }
    }
  }
  
  @NotNull
  public static final <T> List<T> minus(@NotNull Iterable<? extends T> paramIterable1, @NotNull Iterable<? extends T> paramIterable2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable1, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramIterable2, "elements");
    paramIterable2 = CollectionsKt.convertToSetForSetOperationWith(paramIterable2, paramIterable1);
    if (paramIterable2.isEmpty()) {
      return CollectionsKt.toList(paramIterable1);
    }
    Collection localCollection = (Collection)new ArrayList();
    paramIterable1 = paramIterable1.iterator();
    while (paramIterable1.hasNext())
    {
      Object localObject = paramIterable1.next();
      if (!paramIterable2.contains(localObject)) {
        localCollection.add(localObject);
      }
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T> List<T> minus(@NotNull Iterable<? extends T> paramIterable, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$minus");
    ArrayList localArrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(paramIterable, 10));
    paramIterable = paramIterable.iterator();
    int i = 0;
    label99:
    for (;;)
    {
      if (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        int j;
        if ((i == 0) && (Intrinsics.areEqual(localObject, paramT)))
        {
          j = 0;
          i = 1;
        }
        for (;;)
        {
          if (j == 0) {
            break label99;
          }
          ((Collection)localArrayList).add(localObject);
          break;
          j = 1;
        }
      }
      return (List)localArrayList;
    }
  }
  
  @NotNull
  public static final <T> List<T> minus(@NotNull Iterable<? extends T> paramIterable, @NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramSequence, "elements");
    paramSequence = SequencesKt.toHashSet(paramSequence);
    if (paramSequence.isEmpty()) {
      return CollectionsKt.toList(paramIterable);
    }
    Collection localCollection = (Collection)new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (!paramSequence.contains(localObject)) {
        localCollection.add(localObject);
      }
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T> List<T> minus(@NotNull Iterable<? extends T> paramIterable, @NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.toList(paramIterable);
    }
    paramArrayOfT = ArraysKt.toHashSet(paramArrayOfT);
    Collection localCollection = (Collection)new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (!paramArrayOfT.contains(localObject)) {
        localCollection.add(localObject);
      }
    }
    return (List)localCollection;
  }
  
  @InlineOnly
  private static final <T> List<T> minusElement(@NotNull Iterable<? extends T> paramIterable, T paramT)
  {
    return CollectionsKt.minus(paramIterable, paramT);
  }
  
  public static final <T> boolean none(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$none");
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).isEmpty();
    }
    return !paramIterable.iterator().hasNext();
  }
  
  public static final <T> boolean none(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (((paramIterable instanceof Collection)) && (((Collection)paramIterable).isEmpty())) {
      return true;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (((Boolean)paramFunction1.invoke(paramIterable.next())).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, C extends Iterable<? extends T>> C onEach(@NotNull C paramC, @NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramC, "$this$onEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    Iterator localIterator = paramC.iterator();
    while (localIterator.hasNext()) {
      paramFunction1.invoke(localIterator.next());
    }
    return paramC;
  }
  
  @NotNull
  public static final <T> Pair<List<T>, List<T>> partition(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        localArrayList1.add(localObject);
      } else {
        localArrayList2.add(localObject);
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @NotNull
  public static final <T> List<T> plus(@NotNull Iterable<? extends T> paramIterable1, @NotNull Iterable<? extends T> paramIterable2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramIterable2, "elements");
    if ((paramIterable1 instanceof Collection)) {
      return CollectionsKt.plus((Collection)paramIterable1, paramIterable2);
    }
    ArrayList localArrayList = new ArrayList();
    CollectionsKt.addAll((Collection)localArrayList, paramIterable1);
    CollectionsKt.addAll((Collection)localArrayList, paramIterable2);
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> plus(@NotNull Iterable<? extends T> paramIterable, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$plus");
    if ((paramIterable instanceof Collection)) {
      return CollectionsKt.plus((Collection)paramIterable, paramT);
    }
    ArrayList localArrayList = new ArrayList();
    CollectionsKt.addAll((Collection)localArrayList, paramIterable);
    localArrayList.add(paramT);
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> plus(@NotNull Iterable<? extends T> paramIterable, @NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramSequence, "elements");
    ArrayList localArrayList = new ArrayList();
    CollectionsKt.addAll((Collection)localArrayList, paramIterable);
    CollectionsKt.addAll((Collection)localArrayList, paramSequence);
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> plus(@NotNull Iterable<? extends T> paramIterable, @NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    if ((paramIterable instanceof Collection)) {
      return CollectionsKt.plus((Collection)paramIterable, paramArrayOfT);
    }
    ArrayList localArrayList = new ArrayList();
    CollectionsKt.addAll((Collection)localArrayList, paramIterable);
    CollectionsKt.addAll((Collection)localArrayList, paramArrayOfT);
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> plus(@NotNull Collection<? extends T> paramCollection, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "elements");
    if ((paramIterable instanceof Collection))
    {
      int i = paramCollection.size();
      ArrayList localArrayList = new ArrayList(((Collection)paramIterable).size() + i);
      localArrayList.addAll(paramCollection);
      localArrayList.addAll((Collection)paramIterable);
      return (List)localArrayList;
    }
    paramCollection = new ArrayList(paramCollection);
    CollectionsKt.addAll((Collection)paramCollection, paramIterable);
    return (List)paramCollection;
  }
  
  @NotNull
  public static final <T> List<T> plus(@NotNull Collection<? extends T> paramCollection, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$plus");
    ArrayList localArrayList = new ArrayList(paramCollection.size() + 1);
    localArrayList.addAll(paramCollection);
    localArrayList.add(paramT);
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> plus(@NotNull Collection<? extends T> paramCollection, @NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramSequence, "elements");
    ArrayList localArrayList = new ArrayList(paramCollection.size() + 10);
    localArrayList.addAll(paramCollection);
    CollectionsKt.addAll((Collection)localArrayList, paramSequence);
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> plus(@NotNull Collection<? extends T> paramCollection, @NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    ArrayList localArrayList = new ArrayList(paramCollection.size() + paramArrayOfT.length);
    localArrayList.addAll(paramCollection);
    CollectionsKt.addAll((Collection)localArrayList, paramArrayOfT);
    return (List)localArrayList;
  }
  
  @InlineOnly
  private static final <T> List<T> plusElement(@NotNull Iterable<? extends T> paramIterable, T paramT)
  {
    return CollectionsKt.plus(paramIterable, paramT);
  }
  
  @InlineOnly
  private static final <T> List<T> plusElement(@NotNull Collection<? extends T> paramCollection, T paramT)
  {
    return CollectionsKt.plus(paramCollection, paramT);
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> T random(@NotNull Collection<? extends T> paramCollection)
  {
    return CollectionsKt.random(paramCollection, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final <T> T random(@NotNull Collection<? extends T> paramCollection, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramCollection.isEmpty()) {
      throw ((Throwable)new NoSuchElementException("Collection is empty."));
    }
    return CollectionsKt.elementAt((Iterable)paramCollection, paramRandom.nextInt(paramCollection.size()));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> T randomOrNull(@NotNull Collection<? extends T> paramCollection)
  {
    return CollectionsKt.randomOrNull(paramCollection, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <T> T randomOrNull(@NotNull Collection<? extends T> paramCollection, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramCollection.isEmpty()) {
      return null;
    }
    return CollectionsKt.elementAt((Iterable)paramCollection, paramRandom.nextInt(paramCollection.size()));
  }
  
  public static final <S, T extends S> S reduce(@NotNull Iterable<? extends T> paramIterable, @NotNull Function2<? super S, ? super T, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      throw ((Throwable)new UnsupportedOperationException("Empty collection can't be reduced."));
    }
    for (paramIterable = localIterator.next(); localIterator.hasNext(); paramIterable = paramFunction2.invoke(paramIterable, localIterator.next())) {}
    return paramIterable;
  }
  
  public static final <S, T extends S> S reduceIndexed(@NotNull Iterable<? extends T> paramIterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      throw ((Throwable)new UnsupportedOperationException("Empty collection can't be reduced."));
    }
    paramIterable = localIterator.next();
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
        paramIterable = paramFunction3.invoke(Integer.valueOf(i), paramIterable, localIterator.next());
        i += 1;
        continue;
      }
      throw ((Throwable)new ArithmeticException("Index overflow has happened."));
    }
    return paramIterable;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <S, T extends S> S reduceOrNull(@NotNull Iterable<? extends T> paramIterable, @NotNull Function2<? super S, ? super T, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Iterator localIterator = paramIterable.iterator();
    Object localObject;
    if (!localIterator.hasNext())
    {
      localObject = null;
      return localObject;
    }
    for (paramIterable = localIterator.next();; paramIterable = paramFunction2.invoke(paramIterable, localIterator.next()))
    {
      localObject = paramIterable;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
  
  public static final <S, T extends S> S reduceRight(@NotNull List<? extends T> paramList, @NotNull Function2<? super T, ? super S, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    ListIterator localListIterator = paramList.listIterator(paramList.size());
    if (!localListIterator.hasPrevious()) {
      throw ((Throwable)new UnsupportedOperationException("Empty list can't be reduced."));
    }
    for (paramList = localListIterator.previous(); localListIterator.hasPrevious(); paramList = paramFunction2.invoke(localListIterator.previous(), paramList)) {}
    return paramList;
  }
  
  public static final <S, T extends S> S reduceRightIndexed(@NotNull List<? extends T> paramList, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    ListIterator localListIterator = paramList.listIterator(paramList.size());
    if (!localListIterator.hasPrevious()) {
      throw ((Throwable)new UnsupportedOperationException("Empty list can't be reduced."));
    }
    for (paramList = localListIterator.previous(); localListIterator.hasPrevious(); paramList = paramFunction3.invoke(Integer.valueOf(localListIterator.previousIndex()), localListIterator.previous(), paramList)) {}
    return paramList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <S, T extends S> S reduceRightOrNull(@NotNull List<? extends T> paramList, @NotNull Function2<? super T, ? super S, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    ListIterator localListIterator = paramList.listIterator(paramList.size());
    Object localObject;
    if (!localListIterator.hasPrevious())
    {
      localObject = null;
      return localObject;
    }
    for (paramList = localListIterator.previous();; paramList = paramFunction2.invoke(localListIterator.previous(), paramList))
    {
      localObject = paramList;
      if (!localListIterator.hasPrevious()) {
        break;
      }
    }
  }
  
  @NotNull
  public static final <T> Iterable<T> requireNoNulls(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$requireNoNulls");
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        throw ((Throwable)new IllegalArgumentException("null element found in " + paramIterable + '.'));
      }
    }
    return paramIterable;
  }
  
  @NotNull
  public static final <T> List<T> requireNoNulls(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$requireNoNulls");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        throw ((Throwable)new IllegalArgumentException("null element found in " + paramList + '.'));
      }
    }
    return paramList;
  }
  
  @NotNull
  public static final <T> List<T> reversed(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$reversed");
    if (((paramIterable instanceof Collection)) && (((Collection)paramIterable).size() <= 1)) {
      return CollectionsKt.toList(paramIterable);
    }
    paramIterable = CollectionsKt.toMutableList(paramIterable);
    CollectionsKt.reverse(paramIterable);
    return paramIterable;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T, R> List<R> scan(@NotNull Iterable<? extends T> paramIterable, R paramR, @NotNull Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$scan");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 9);
    if (i == 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(i + 1);
    localArrayList.add(paramR);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramR = paramFunction2.invoke(paramR, paramIterable.next());
      localArrayList.add(paramR);
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T, R> List<R> scanIndexed(@NotNull Iterable<? extends T> paramIterable, R paramR, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$scanIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 9);
    if (i == 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(i + 1);
    localArrayList.add(paramR);
    i = 0;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      int j = i + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, localObject);
      localArrayList.add(paramR);
      i = j;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <S, T extends S> List<S> scanReduce(@NotNull Iterable<? extends T> paramIterable, @NotNull Function2<? super S, ? super T, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$scanReduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      return CollectionsKt.emptyList();
    }
    Object localObject = localIterator.next();
    ArrayList localArrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(paramIterable, 10));
    localArrayList.add(localObject);
    paramIterable = localObject;
    while (localIterator.hasNext())
    {
      paramIterable = paramFunction2.invoke(paramIterable, localIterator.next());
      localArrayList.add(paramIterable);
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <S, T extends S> List<S> scanReduceIndexed(@NotNull Iterable<? extends T> paramIterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$scanReduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      return CollectionsKt.emptyList();
    }
    Object localObject = localIterator.next();
    ArrayList localArrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(paramIterable, 10));
    localArrayList.add(localObject);
    int i = 1;
    paramIterable = localObject;
    while (localIterator.hasNext())
    {
      int j = i + 1;
      paramIterable = paramFunction3.invoke(Integer.valueOf(i), paramIterable, localIterator.next());
      localArrayList.add(paramIterable);
      i = j;
    }
    return (List)localArrayList;
  }
  
  public static final <T> T single(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$single");
    if ((paramIterable instanceof List)) {
      paramIterable = CollectionsKt.single((List)paramIterable);
    }
    Iterator localIterator;
    do
    {
      return paramIterable;
      localIterator = paramIterable.iterator();
      if (!localIterator.hasNext()) {
        throw ((Throwable)new NoSuchElementException("Collection is empty."));
      }
      paramIterable = localIterator.next();
    } while (!localIterator.hasNext());
    throw ((Throwable)new IllegalArgumentException("Collection has more than one element."));
  }
  
  public static final <T> T single(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Object localObject = null;
    int i = 0;
    Iterator localIterator = paramIterable.iterator();
    paramIterable = localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        break label107;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Collection contains more than one matching element."));
      }
      i = 1;
      paramIterable = localObject;
    }
    label107:
    for (;;)
    {
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
      }
      return paramIterable;
    }
  }
  
  public static final <T> T single(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$single");
    switch (paramList.size())
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("List has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("List is empty."));
    }
    return paramList.get(0);
  }
  
  @Nullable
  public static final <T> T singleOrNull(@NotNull Iterable<? extends T> paramIterable)
  {
    Object localObject1 = null;
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$singleOrNull");
    if ((paramIterable instanceof List)) {
      if (((List)paramIterable).size() == 1) {
        paramIterable = ((List)paramIterable).get(0);
      }
    }
    Iterator localIterator;
    Object localObject2;
    do
    {
      do
      {
        for (;;)
        {
          return paramIterable;
          paramIterable = null;
        }
        localIterator = paramIterable.iterator();
        paramIterable = localObject1;
      } while (!localIterator.hasNext());
      localObject2 = localIterator.next();
      paramIterable = localObject1;
    } while (localIterator.hasNext());
    return localObject2;
  }
  
  @Nullable
  public static final <T> T singleOrNull(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    Iterator localIterator = paramIterable.iterator();
    paramIterable = null;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        break label79;
      }
      if (i == 0) {}
    }
    label79:
    label80:
    for (;;)
    {
      return null;
      i = 1;
      paramIterable = localObject;
      for (;;)
      {
        break;
        if (i == 0) {
          break label80;
        }
        return paramIterable;
      }
    }
  }
  
  @Nullable
  public static final <T> T singleOrNull(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$singleOrNull");
    if (paramList.size() == 1) {
      return paramList.get(0);
    }
    return null;
  }
  
  @NotNull
  public static final <T> List<T> slice(@NotNull List<? extends T> paramList, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(paramList.get(((Number)paramIterable.next()).intValue()));
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> slice(@NotNull List<? extends T> paramList, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.toList((Iterable)paramList.subList(paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1));
  }
  
  public static final <T, R extends Comparable<? super R>> void sortBy(@NotNull List<T> paramList, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$sortBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramList.size() > 1) {
      CollectionsKt.sortWith(paramList, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
    }
  }
  
  public static final <T, R extends Comparable<? super R>> void sortByDescending(@NotNull List<T> paramList, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$sortByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramList.size() > 1) {
      CollectionsKt.sortWith(paramList, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
    }
  }
  
  public static final <T extends Comparable<? super T>> void sortDescending(@NotNull List<T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$sortDescending");
    CollectionsKt.sortWith(paramList, ComparisonsKt.reverseOrder());
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> List<T> sorted(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sorted");
    if ((paramIterable instanceof Collection))
    {
      if (((Collection)paramIterable).size() <= 1) {
        return CollectionsKt.toList(paramIterable);
      }
      paramIterable = ((Collection)paramIterable).toArray(new Comparable[0]);
      if (paramIterable == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      if (paramIterable == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      paramIterable = (Comparable[])paramIterable;
      if (paramIterable == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      }
      ArraysKt.sort((Object[])paramIterable);
      return ArraysKt.asList((Object[])paramIterable);
    }
    paramIterable = CollectionsKt.toMutableList(paramIterable);
    CollectionsKt.sort(paramIterable);
    return paramIterable;
  }
  
  @NotNull
  public static final <T, R extends Comparable<? super R>> List<T> sortedBy(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return CollectionsKt.sortedWith(paramIterable, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return CollectionsKt.sortedWith(paramIterable, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> List<T> sortedDescending(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sortedDescending");
    return CollectionsKt.sortedWith(paramIterable, ComparisonsKt.reverseOrder());
  }
  
  @NotNull
  public static final <T> List<T> sortedWith(@NotNull Iterable<? extends T> paramIterable, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if ((paramIterable instanceof Collection))
    {
      if (((Collection)paramIterable).size() <= 1) {
        return CollectionsKt.toList(paramIterable);
      }
      paramIterable = ((Collection)paramIterable).toArray(new Object[0]);
      if (paramIterable == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      if (paramIterable == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      ArraysKt.sortWith(paramIterable, paramComparator);
      return ArraysKt.asList(paramIterable);
    }
    paramIterable = CollectionsKt.toMutableList(paramIterable);
    CollectionsKt.sortWith(paramIterable, paramComparator);
    return paramIterable;
  }
  
  @NotNull
  public static final <T> Set<T> subtract(@NotNull Iterable<? extends T> paramIterable1, @NotNull Iterable<? extends T> paramIterable2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable1, "$this$subtract");
    Intrinsics.checkParameterIsNotNull(paramIterable2, "other");
    paramIterable1 = CollectionsKt.toMutableSet(paramIterable1);
    CollectionsKt.removeAll((Collection)paramIterable1, paramIterable2);
    return paramIterable1;
  }
  
  public static final <T> int sumBy(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = ((Number)paramFunction1.invoke(paramIterable.next())).intValue() + i) {}
    return i;
  }
  
  public static final <T> double sumByDouble(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    paramIterable = paramIterable.iterator();
    for (double d = 0.0D; paramIterable.hasNext(); d = ((Number)paramFunction1.invoke(paramIterable.next())).doubleValue() + d) {}
    return d;
  }
  
  @JvmName(name="sumOfByte")
  public static final int sumOfByte(@NotNull Iterable<Byte> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = ((Number)paramIterable.next()).byteValue() + i) {}
    return i;
  }
  
  @JvmName(name="sumOfDouble")
  public static final double sumOfDouble(@NotNull Iterable<Double> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (double d = 0.0D; paramIterable.hasNext(); d = ((Number)paramIterable.next()).doubleValue() + d) {}
    return d;
  }
  
  @JvmName(name="sumOfFloat")
  public static final float sumOfFloat(@NotNull Iterable<Float> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (float f = 0.0F; paramIterable.hasNext(); f = ((Number)paramIterable.next()).floatValue() + f) {}
    return f;
  }
  
  @JvmName(name="sumOfInt")
  public static final int sumOfInt(@NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = ((Number)paramIterable.next()).intValue() + i) {}
    return i;
  }
  
  @JvmName(name="sumOfLong")
  public static final long sumOfLong(@NotNull Iterable<Long> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (long l = 0L; paramIterable.hasNext(); l = ((Number)paramIterable.next()).longValue() + l) {}
    return l;
  }
  
  @JvmName(name="sumOfShort")
  public static final int sumOfShort(@NotNull Iterable<Short> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = ((Number)paramIterable.next()).shortValue() + i) {}
    return i;
  }
  
  @NotNull
  public static final <T> List<T> take(@NotNull Iterable<? extends T> paramIterable, int paramInt)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    if ((paramIterable instanceof Collection))
    {
      if (paramInt >= ((Collection)paramIterable).size()) {
        return CollectionsKt.toList(paramIterable);
      }
      if (paramInt == 1) {
        return CollectionsKt.listOf(CollectionsKt.first(paramIterable));
      }
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramIterable = paramIterable.iterator();
    i = j;
    do
    {
      if (!paramIterable.hasNext()) {
        break;
      }
      localArrayList.add(paramIterable.next());
      j = i + 1;
      i = j;
    } while (j != paramInt);
    return CollectionsKt.optimizeReadOnlyList((List)localArrayList);
  }
  
  @NotNull
  public static final <T> List<T> takeLast(@NotNull List<? extends T> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = paramList.size();
    if (paramInt >= i) {
      return CollectionsKt.toList((Iterable)paramList);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(CollectionsKt.last(paramList));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    if ((paramList instanceof RandomAccess))
    {
      paramInt = i - paramInt;
      while (paramInt < i)
      {
        localArrayList.add(paramList.get(paramInt));
        paramInt += 1;
      }
    }
    paramList = (Iterator)paramList.listIterator(i - paramInt);
    while (paramList.hasNext()) {
      localArrayList.add(paramList.next());
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> takeLastWhile(@NotNull List<? extends T> paramList, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (paramList.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    ListIterator localListIterator = paramList.listIterator(paramList.size());
    while (localListIterator.hasPrevious()) {
      if (!((Boolean)paramFunction1.invoke(localListIterator.previous())).booleanValue())
      {
        localListIterator.next();
        int i = paramList.size() - localListIterator.nextIndex();
        if (i == 0) {
          return CollectionsKt.emptyList();
        }
        paramList = new ArrayList(i);
        while (localListIterator.hasNext()) {
          paramList.add(localListIterator.next());
        }
        return (List)paramList;
      }
    }
    return CollectionsKt.toList((Iterable)paramList);
  }
  
  @NotNull
  public static final <T> List<T> takeWhile(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(localObject);
    }
  }
  
  @NotNull
  public static final boolean[] toBooleanArray(@NotNull Collection<Boolean> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toBooleanArray");
    boolean[] arrayOfBoolean = new boolean[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfBoolean[i] = ((Boolean)paramCollection.next()).booleanValue();
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  @NotNull
  public static final byte[] toByteArray(@NotNull Collection<Byte> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toByteArray");
    byte[] arrayOfByte = new byte[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfByte[i] = ((Number)paramCollection.next()).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  @NotNull
  public static final char[] toCharArray(@NotNull Collection<Character> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toCharArray");
    char[] arrayOfChar = new char[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfChar[i] = ((Character)paramCollection.next()).charValue();
      i += 1;
    }
    return arrayOfChar;
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C toCollection(@NotNull Iterable<? extends T> paramIterable, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramC.add(paramIterable.next());
    }
    return paramC;
  }
  
  @NotNull
  public static final double[] toDoubleArray(@NotNull Collection<Double> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toDoubleArray");
    double[] arrayOfDouble = new double[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfDouble[i] = ((Number)paramCollection.next()).doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  @NotNull
  public static final float[] toFloatArray(@NotNull Collection<Float> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toFloatArray");
    float[] arrayOfFloat = new float[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfFloat[i] = ((Number)paramCollection.next()).floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  @NotNull
  public static final <T> HashSet<T> toHashSet(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toHashSet");
    return (HashSet)CollectionsKt.toCollection(paramIterable, (Collection)new HashSet(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(paramIterable, 12))));
  }
  
  @NotNull
  public static final int[] toIntArray(@NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toIntArray");
    int[] arrayOfInt = new int[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfInt[i] = ((Number)paramCollection.next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  @NotNull
  public static final <T> List<T> toList(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toList");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        return CollectionsKt.toMutableList((Collection)paramIterable);
      case 0: 
        return CollectionsKt.emptyList();
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = ((List)paramIterable).get(0);; paramIterable = paramIterable.iterator().next()) {
        return CollectionsKt.listOf(paramIterable);
      }
    }
    return CollectionsKt.optimizeReadOnlyList(CollectionsKt.toMutableList(paramIterable));
  }
  
  @NotNull
  public static final long[] toLongArray(@NotNull Collection<Long> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toLongArray");
    long[] arrayOfLong = new long[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfLong[i] = ((Number)paramCollection.next()).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  @NotNull
  public static final <T> List<T> toMutableList(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toMutableList");
    if ((paramIterable instanceof Collection)) {
      return CollectionsKt.toMutableList((Collection)paramIterable);
    }
    return (List)CollectionsKt.toCollection(paramIterable, (Collection)new ArrayList());
  }
  
  @NotNull
  public static final <T> List<T> toMutableList(@NotNull Collection<? extends T> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toMutableList");
    return (List)new ArrayList(paramCollection);
  }
  
  @NotNull
  public static final <T> Set<T> toMutableSet(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toMutableSet");
    if ((paramIterable instanceof Collection)) {
      return (Set)new LinkedHashSet((Collection)paramIterable);
    }
    return (Set)CollectionsKt.toCollection(paramIterable, (Collection)new LinkedHashSet());
  }
  
  @NotNull
  public static final <T> Set<T> toSet(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toSet");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        return (Set)CollectionsKt.toCollection(paramIterable, (Collection)new LinkedHashSet(MapsKt.mapCapacity(((Collection)paramIterable).size())));
      case 0: 
        return SetsKt.emptySet();
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = ((List)paramIterable).get(0);; paramIterable = paramIterable.iterator().next()) {
        return SetsKt.setOf(paramIterable);
      }
    }
    return SetsKt.optimizeReadOnlySet((Set)CollectionsKt.toCollection(paramIterable, (Collection)new LinkedHashSet()));
  }
  
  @NotNull
  public static final short[] toShortArray(@NotNull Collection<Short> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toShortArray");
    short[] arrayOfShort = new short[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfShort[i] = ((Number)paramCollection.next()).shortValue();
      i += 1;
    }
    return arrayOfShort;
  }
  
  @NotNull
  public static final <T> Set<T> union(@NotNull Iterable<? extends T> paramIterable1, @NotNull Iterable<? extends T> paramIterable2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable1, "$this$union");
    Intrinsics.checkParameterIsNotNull(paramIterable2, "other");
    paramIterable1 = CollectionsKt.toMutableSet(paramIterable1);
    CollectionsKt.addAll((Collection)paramIterable1, paramIterable2);
    return paramIterable1;
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T> List<List<T>> windowed(@NotNull Iterable<? extends T> paramIterable, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$windowed");
    SlidingWindowKt.checkWindowSizeStep(paramInt1, paramInt2);
    if (((paramIterable instanceof RandomAccess)) && ((paramIterable instanceof List)))
    {
      int k = ((List)paramIterable).size();
      int j = k / paramInt2;
      int i;
      if (k % paramInt2 == 0)
      {
        i = 0;
        localArrayList1 = new ArrayList(i + j);
        i = 0;
      }
      for (;;)
      {
        if (i < 0) {}
        int m;
        do
        {
          do
          {
            return (List)localArrayList1;
            i = 1;
            break;
          } while (k <= i);
          m = RangesKt.coerceAtMost(paramInt1, k - i);
        } while ((m < paramInt1) && (!paramBoolean));
        ArrayList localArrayList2 = new ArrayList(m);
        j = 0;
        while (j < m)
        {
          localArrayList2.add(((List)paramIterable).get(j + i));
          j += 1;
        }
        localArrayList1.add((List)localArrayList2);
        i += paramInt2;
      }
    }
    ArrayList localArrayList1 = new ArrayList();
    paramIterable = SlidingWindowKt.windowedIterator(paramIterable.iterator(), paramInt1, paramInt2, paramBoolean, false);
    while (paramIterable.hasNext()) {
      localArrayList1.add((List)paramIterable.next());
    }
    return (List)localArrayList1;
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T, R> List<R> windowed(@NotNull Iterable<? extends T> paramIterable, int paramInt1, int paramInt2, boolean paramBoolean, @NotNull Function1<? super List<? extends T>, ? extends R> paramFunction1)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$windowed");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    SlidingWindowKt.checkWindowSizeStep(paramInt1, paramInt2);
    if (((paramIterable instanceof RandomAccess)) && ((paramIterable instanceof List)))
    {
      int k = ((List)paramIterable).size();
      int m = k / paramInt2;
      int i;
      if (k % paramInt2 == 0)
      {
        i = 0;
        localArrayList = new ArrayList(m + i);
        paramIterable = new MovingSubList((List)paramIterable);
        i = j;
      }
      for (;;)
      {
        if (i < 0) {}
        do
        {
          do
          {
            return (List)localArrayList;
            i = 1;
            break;
          } while (k <= i);
          j = RangesKt.coerceAtMost(paramInt1, k - i);
        } while ((!paramBoolean) && (j < paramInt1));
        paramIterable.move(i, j + i);
        localArrayList.add(paramFunction1.invoke(paramIterable));
        i += paramInt2;
      }
    }
    ArrayList localArrayList = new ArrayList();
    paramIterable = SlidingWindowKt.windowedIterator(paramIterable.iterator(), paramInt1, paramInt2, paramBoolean, true);
    while (paramIterable.hasNext()) {
      localArrayList.add(paramFunction1.invoke((List)paramIterable.next()));
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> Iterable<IndexedValue<T>> withIndex(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new CollectionsKt___CollectionsKt.withIndex.1(paramIterable));
  }
  
  @NotNull
  public static final <T, R> List<Pair<T, R>> zip(@NotNull Iterable<? extends T> paramIterable, @NotNull Iterable<? extends R> paramIterable1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable1, "other");
    Iterator localIterator1 = paramIterable.iterator();
    Iterator localIterator2 = paramIterable1.iterator();
    paramIterable = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), CollectionsKt.collectionSizeOrDefault(paramIterable1, 10)));
    while ((localIterator1.hasNext()) && (localIterator2.hasNext())) {
      paramIterable.add(TuplesKt.to(localIterator1.next(), localIterator2.next()));
    }
    return (List)paramIterable;
  }
  
  @NotNull
  public static final <T, R, V> List<V> zip(@NotNull Iterable<? extends T> paramIterable, @NotNull Iterable<? extends R> paramIterable1, @NotNull Function2<? super T, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable1, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Iterator localIterator1 = paramIterable.iterator();
    Iterator localIterator2 = paramIterable1.iterator();
    paramIterable = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), CollectionsKt.collectionSizeOrDefault(paramIterable1, 10)));
    while ((localIterator1.hasNext()) && (localIterator2.hasNext())) {
      paramIterable.add(paramFunction2.invoke(localIterator1.next(), localIterator2.next()));
    }
    return (List)paramIterable;
  }
  
  @NotNull
  public static final <T, R> List<Pair<T, R>> zip(@NotNull Iterable<? extends T> paramIterable, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = paramArrayOfR.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(TuplesKt.to(localObject, paramArrayOfR[i]));
      i += 1;
    }
  }
  
  @NotNull
  public static final <T, R, V> List<V> zip(@NotNull Iterable<? extends T> paramIterable, @NotNull R[] paramArrayOfR, @NotNull Function2<? super T, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramArrayOfR.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(paramFunction2.invoke(localObject, paramArrayOfR[i]));
      i += 1;
    }
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T> List<Pair<T, T>> zipWithNext(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$zipWithNext");
    Iterator localIterator = paramIterable.iterator();
    Object localObject;
    if (!localIterator.hasNext())
    {
      localObject = CollectionsKt.emptyList();
      return localObject;
    }
    List localList = (List)new ArrayList();
    for (paramIterable = localIterator.next();; paramIterable = (Iterable<? extends T>)localObject)
    {
      localObject = localList;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
      localList.add(TuplesKt.to(paramIterable, localObject));
    }
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T, R> List<R> zipWithNext(@NotNull Iterable<? extends T> paramIterable, @NotNull Function2<? super T, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$zipWithNext");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Iterator localIterator = paramIterable.iterator();
    Object localObject;
    if (!localIterator.hasNext())
    {
      localObject = CollectionsKt.emptyList();
      return localObject;
    }
    List localList = (List)new ArrayList();
    for (paramIterable = localIterator.next();; paramIterable = (Iterable<? extends T>)localObject)
    {
      localObject = localList;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
      localList.add(paramFunction2.invoke(paramIterable, localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.CollectionsKt___CollectionsKt
 * JD-Core Version:    0.7.0.1
 */