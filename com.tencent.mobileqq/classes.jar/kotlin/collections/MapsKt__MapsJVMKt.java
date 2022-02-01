package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"INT_MAX_POWER_OF_TWO", "", "checkBuilderCapacity", "", "capacity", "mapCapacity", "expectedSize", "mapOf", "", "K", "V", "pair", "Lkotlin/Pair;", "sortedMapOf", "Ljava/util/SortedMap;", "", "pairs", "", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "getOrPut", "Ljava/util/concurrent/ConcurrentMap;", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toProperties", "Ljava/util/Properties;", "", "toSingletonMap", "toSingletonMapOrSelf", "toSortedMap", "comparator", "Ljava/util/Comparator;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/MapsKt")
class MapsKt__MapsJVMKt
  extends MapsKt__MapWithDefaultKt
{
  private static final int INT_MAX_POWER_OF_TWO = 1073741824;
  
  @ExperimentalStdlibApi
  @PublishedApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void checkBuilderCapacity(int paramInt) {}
  
  public static final <K, V> V getOrPut(@NotNull ConcurrentMap<K, V> paramConcurrentMap, K paramK, @NotNull Function0<? extends V> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramConcurrentMap, "$this$getOrPut");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "defaultValue");
    Object localObject = paramConcurrentMap.get(paramK);
    if (localObject != null) {
      return localObject;
    }
    paramFunction0 = paramFunction0.invoke();
    paramK = paramConcurrentMap.putIfAbsent(paramK, paramFunction0);
    paramConcurrentMap = paramFunction0;
    if (paramK != null) {
      paramConcurrentMap = paramK;
    }
    return paramConcurrentMap;
  }
  
  @PublishedApi
  public static final int mapCapacity(int paramInt)
  {
    if (paramInt < 0) {
      return paramInt;
    }
    if (paramInt < 3) {
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return (int)(paramInt / 0.75F + 1.0F);
    }
    return 2147483647;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> mapOf(@NotNull Pair<? extends K, ? extends V> paramPair)
  {
    Intrinsics.checkParameterIsNotNull(paramPair, "pair");
    paramPair = Collections.singletonMap(paramPair.getFirst(), paramPair.getSecond());
    Intrinsics.checkExpressionValueIsNotNull(paramPair, "java.util.Collections.si…(pair.first, pair.second)");
    return paramPair;
  }
  
  @NotNull
  public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(@NotNull Pair<? extends K, ? extends V>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "pairs");
    TreeMap localTreeMap = new TreeMap();
    MapsKt.putAll((Map)localTreeMap, paramVarArgs);
    return (SortedMap)localTreeMap;
  }
  
  @InlineOnly
  private static final Properties toProperties(@NotNull Map<String, String> paramMap)
  {
    Properties localProperties = new Properties();
    localProperties.putAll(paramMap);
    return localProperties;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> toSingletonMap(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toSingletonMap");
    paramMap = (Map.Entry)paramMap.entrySet().iterator().next();
    paramMap = Collections.singletonMap(paramMap.getKey(), paramMap.getValue());
    Intrinsics.checkExpressionValueIsNotNull(paramMap, "java.util.Collections.singletonMap(key, value)");
    Intrinsics.checkExpressionValueIsNotNull(paramMap, "with(entries.iterator().…ingletonMap(key, value) }");
    return paramMap;
  }
  
  @InlineOnly
  private static final <K, V> Map<K, V> toSingletonMapOrSelf(@NotNull Map<K, ? extends V> paramMap)
  {
    return MapsKt.toSingletonMap(paramMap);
  }
  
  @NotNull
  public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toSortedMap");
    return (SortedMap)new TreeMap(paramMap);
  }
  
  @NotNull
  public static final <K, V> SortedMap<K, V> toSortedMap(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Comparator<? super K> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toSortedMap");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    paramComparator = new TreeMap(paramComparator);
    paramComparator.putAll(paramMap);
    return (SortedMap)paramComparator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.MapsKt__MapsJVMKt
 * JD-Core Version:    0.7.0.1
 */