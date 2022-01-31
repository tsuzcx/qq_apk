package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buildMap", "", "K", "V", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptyMap", "hashMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "mutableMapOf", "component1", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "contains", "", "Lkotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "filter", "predicate", "filterKeys", "filterNot", "filterNotTo", "M", "destination", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterTo", "filterValues", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getOrPut", "getValue", "ifEmpty", "R", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "iterator", "", "", "", "mutableIterator", "mapKeys", "transform", "mapKeysTo", "mapValues", "mapValuesTo", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "", "Lkotlin/sequences/Sequence;", "minusAssign", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "orEmpty", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "pair", "map", "plusAssign", "(Ljava/util/Map;[Lkotlin/Pair;)V", "putAll", "remove", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "toMap", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "toPair", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/MapsKt")
public class MapsKt__MapsKt
  extends MapsKt__MapsJVMKt
{
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V> Map<K, V> buildMap(int paramInt, @BuilderInference Function1<? super Map<K, V>, Unit> paramFunction1)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(paramInt));
    paramFunction1.invoke(localLinkedHashMap);
    return (Map)localLinkedHashMap;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V> Map<K, V> buildMap(@BuilderInference Function1<? super Map<K, V>, Unit> paramFunction1)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramFunction1.invoke(localLinkedHashMap);
    return (Map)localLinkedHashMap;
  }
  
  @InlineOnly
  private static final <K, V> K component1(@NotNull Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "$this$component1");
    return paramEntry.getKey();
  }
  
  @InlineOnly
  private static final <K, V> V component2(@NotNull Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "$this$component2");
    return paramEntry.getValue();
  }
  
  @InlineOnly
  private static final <K, V> boolean contains(@NotNull Map<? extends K, ? extends V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$contains");
    return paramMap.containsKey(paramK);
  }
  
  @InlineOnly
  private static final <K> boolean containsKey(@NotNull Map<? extends K, ?> paramMap, K paramK)
  {
    if (paramMap == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }
    return paramMap.containsKey(paramK);
  }
  
  @InlineOnly
  private static final <K, V> boolean containsValue(@NotNull Map<K, ? extends V> paramMap, V paramV)
  {
    return paramMap.containsValue(paramV);
  }
  
  @NotNull
  public static final <K, V> Map<K, V> emptyMap()
  {
    EmptyMap localEmptyMap = EmptyMap.INSTANCE;
    if (localEmptyMap == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }
    return (Map)localEmptyMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> filter(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Map localMap = (Map)new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Boolean)paramFunction1.invoke(localEntry)).booleanValue()) {
        localMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> filterKeys(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super K, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filterKeys");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Boolean)paramFunction1.invoke(localEntry.getKey())).booleanValue()) {
        localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return (Map)localLinkedHashMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> filterNot(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Map localMap = (Map)new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!((Boolean)paramFunction1.invoke(localEntry)).booleanValue()) {
        localMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull M paramM, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!((Boolean)paramFunction1.invoke(localEntry)).booleanValue()) {
        paramM.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull M paramM, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Boolean)paramFunction1.invoke(localEntry)).booleanValue()) {
        paramM.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> filterValues(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super V, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filterValues");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Boolean)paramFunction1.invoke(localEntry.getValue())).booleanValue()) {
        localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return (Map)localLinkedHashMap;
  }
  
  @InlineOnly
  private static final <K, V> V get(@NotNull Map<? extends K, ? extends V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$get");
    return paramMap.get(paramK);
  }
  
  @InlineOnly
  private static final <K, V> V getOrElse(@NotNull Map<K, ? extends V> paramMap, K paramK, Function0<? extends V> paramFunction0)
  {
    paramMap = paramMap.get(paramK);
    if (paramMap != null) {
      return paramMap;
    }
    return paramFunction0.invoke();
  }
  
  public static final <K, V> V getOrElseNullable(@NotNull Map<K, ? extends V> paramMap, K paramK, @NotNull Function0<? extends V> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$getOrElseNullable");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "defaultValue");
    Object localObject2 = paramMap.get(paramK);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (!paramMap.containsKey(paramK)) {
        localObject1 = paramFunction0.invoke();
      }
    }
    return localObject1;
  }
  
  public static final <K, V> V getOrPut(@NotNull Map<K, V> paramMap, K paramK, @NotNull Function0<? extends V> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$getOrPut");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "defaultValue");
    Object localObject2 = paramMap.get(paramK);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = paramFunction0.invoke();
      paramMap.put(paramK, localObject1);
    }
    return localObject1;
  }
  
  @SinceKotlin(version="1.1")
  public static final <K, V> V getValue(@NotNull Map<K, ? extends V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$getValue");
    return MapsKt.getOrImplicitDefaultNullable(paramMap, paramK);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <K, V> HashMap<K, V> hashMapOf()
  {
    return new HashMap();
  }
  
  @NotNull
  public static final <K, V> HashMap<K, V> hashMapOf(@NotNull Pair<? extends K, ? extends V>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "pairs");
    HashMap localHashMap = new HashMap(MapsKt.mapCapacity(paramVarArgs.length));
    MapsKt.putAll((Map)localHashMap, paramVarArgs);
    return localHashMap;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <M extends Map<?, ?>,  extends R, R> R ifEmpty(M paramM, Function0<? extends R> paramFunction0)
  {
    Object localObject = paramM;
    if (paramM.isEmpty()) {
      localObject = paramFunction0.invoke();
    }
    return localObject;
  }
  
  @InlineOnly
  private static final <K, V> boolean isNotEmpty(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    return !paramMap.isEmpty();
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V> boolean isNullOrEmpty(@Nullable Map<? extends K, ? extends V> paramMap)
  {
    return (paramMap == null) || (paramMap.isEmpty());
  }
  
  @InlineOnly
  private static final <K, V> Iterator<Map.Entry<K, V>> iterator(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$iterator");
    return paramMap.entrySet().iterator();
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <K, V> LinkedHashMap<K, V> linkedMapOf()
  {
    return new LinkedHashMap();
  }
  
  @NotNull
  public static final <K, V> LinkedHashMap<K, V> linkedMapOf(@NotNull Pair<? extends K, ? extends V>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "pairs");
    return (LinkedHashMap)MapsKt.toMap(paramVarArgs, (Map)new LinkedHashMap(MapsKt.mapCapacity(paramVarArgs.length)));
  }
  
  @NotNull
  public static final <K, V, R> Map<R, V> mapKeys(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapKeys");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(MapsKt.mapCapacity(paramMap.size()));
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramMap.next();
      localMap.put(paramFunction1.invoke(localObject), ((Map.Entry)localObject).getValue());
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull M paramM, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapKeysTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramMap.next();
      paramM.put(paramFunction1.invoke(localObject), ((Map.Entry)localObject).getValue());
    }
    return paramM;
  }
  
  @InlineOnly
  private static final <K, V> Map<K, V> mapOf()
  {
    return MapsKt.emptyMap();
  }
  
  @NotNull
  public static final <K, V> Map<K, V> mapOf(@NotNull Pair<? extends K, ? extends V>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "pairs");
    if (paramVarArgs.length > 0) {
      return MapsKt.toMap(paramVarArgs, (Map)new LinkedHashMap(MapsKt.mapCapacity(paramVarArgs.length)));
    }
    return MapsKt.emptyMap();
  }
  
  @NotNull
  public static final <K, V, R> Map<K, R> mapValues(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapValues");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(MapsKt.mapCapacity(paramMap.size()));
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramMap.next();
      localMap.put(((Map.Entry)localObject).getKey(), paramFunction1.invoke(localObject));
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull M paramM, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapValuesTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramMap.next();
      paramM.put(((Map.Entry)localObject).getKey(), paramFunction1.invoke(localObject));
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Iterable<? extends K> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "keys");
    paramMap = MapsKt.toMutableMap(paramMap);
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramIterable);
    return MapsKt.optimizeReadOnlyMap(paramMap);
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minus");
    paramMap = MapsKt.toMutableMap(paramMap);
    paramMap.remove(paramK);
    return MapsKt.optimizeReadOnlyMap(paramMap);
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Sequence<? extends K> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramSequence, "keys");
    paramMap = MapsKt.toMutableMap(paramMap);
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramSequence);
    return MapsKt.optimizeReadOnlyMap(paramMap);
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull K[] paramArrayOfK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfK, "keys");
    paramMap = MapsKt.toMutableMap(paramMap);
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramArrayOfK);
    return MapsKt.optimizeReadOnlyMap(paramMap);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <K, V> void minusAssign(@NotNull Map<K, V> paramMap, Iterable<? extends K> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minusAssign");
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramIterable);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <K, V> void minusAssign(@NotNull Map<K, V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minusAssign");
    paramMap.remove(paramK);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <K, V> void minusAssign(@NotNull Map<K, V> paramMap, Sequence<? extends K> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minusAssign");
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramSequence);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <K, V> void minusAssign(@NotNull Map<K, V> paramMap, K[] paramArrayOfK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minusAssign");
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramArrayOfK);
  }
  
  @InlineOnly
  @JvmName(name="mutableIterator")
  private static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(@NotNull Map<K, V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$iterator");
    return paramMap.entrySet().iterator();
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <K, V> Map<K, V> mutableMapOf()
  {
    return (Map)new LinkedHashMap();
  }
  
  @NotNull
  public static final <K, V> Map<K, V> mutableMapOf(@NotNull Pair<? extends K, ? extends V>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "pairs");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(paramVarArgs.length));
    MapsKt.putAll((Map)localLinkedHashMap, paramVarArgs);
    return (Map)localLinkedHashMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> optimizeReadOnlyMap(@NotNull Map<K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$optimizeReadOnlyMap");
    switch (paramMap.size())
    {
    default: 
      return paramMap;
    case 0: 
      return MapsKt.emptyMap();
    }
    return MapsKt.toSingletonMap(paramMap);
  }
  
  @InlineOnly
  private static final <K, V> Map<K, V> orEmpty(@Nullable Map<K, ? extends V> paramMap)
  {
    if (paramMap != null) {
      return paramMap;
    }
    return MapsKt.emptyMap();
  }
  
  @NotNull
  public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "pairs");
    if (paramMap.isEmpty()) {
      return MapsKt.toMap(paramIterable);
    }
    paramMap = new LinkedHashMap(paramMap);
    MapsKt.putAll((Map)paramMap, paramIterable);
    return (Map)paramMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> paramMap1, @NotNull Map<? extends K, ? extends V> paramMap2)
  {
    Intrinsics.checkParameterIsNotNull(paramMap1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramMap2, "map");
    paramMap1 = new LinkedHashMap(paramMap1);
    paramMap1.putAll(paramMap2);
    return (Map)paramMap1;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Pair<? extends K, ? extends V> paramPair)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramPair, "pair");
    if (paramMap.isEmpty()) {
      return MapsKt.mapOf(paramPair);
    }
    paramMap = new LinkedHashMap(paramMap);
    paramMap.put(paramPair.getFirst(), paramPair.getSecond());
    return (Map)paramMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Sequence<? extends Pair<? extends K, ? extends V>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramSequence, "pairs");
    paramMap = new LinkedHashMap(paramMap);
    MapsKt.putAll((Map)paramMap, paramSequence);
    return MapsKt.optimizeReadOnlyMap((Map)paramMap);
  }
  
  @NotNull
  public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Pair<? extends K, ? extends V>[] paramArrayOfPair)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfPair, "pairs");
    if (paramMap.isEmpty()) {
      return MapsKt.toMap(paramArrayOfPair);
    }
    paramMap = new LinkedHashMap(paramMap);
    MapsKt.putAll((Map)paramMap, paramArrayOfPair);
    return (Map)paramMap;
  }
  
  @InlineOnly
  private static final <K, V> void plusAssign(@NotNull Map<? super K, ? super V> paramMap, Iterable<? extends Pair<? extends K, ? extends V>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plusAssign");
    MapsKt.putAll(paramMap, paramIterable);
  }
  
  @InlineOnly
  private static final <K, V> void plusAssign(@NotNull Map<? super K, ? super V> paramMap, Map<K, ? extends V> paramMap1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plusAssign");
    paramMap.putAll(paramMap1);
  }
  
  @InlineOnly
  private static final <K, V> void plusAssign(@NotNull Map<? super K, ? super V> paramMap, Pair<? extends K, ? extends V> paramPair)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plusAssign");
    paramMap.put(paramPair.getFirst(), paramPair.getSecond());
  }
  
  @InlineOnly
  private static final <K, V> void plusAssign(@NotNull Map<? super K, ? super V> paramMap, Sequence<? extends Pair<? extends K, ? extends V>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plusAssign");
    MapsKt.putAll(paramMap, paramSequence);
  }
  
  @InlineOnly
  private static final <K, V> void plusAssign(@NotNull Map<? super K, ? super V> paramMap, Pair<? extends K, ? extends V>[] paramArrayOfPair)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plusAssign");
    MapsKt.putAll(paramMap, paramArrayOfPair);
  }
  
  public static final <K, V> void putAll(@NotNull Map<? super K, ? super V> paramMap, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$putAll");
    Intrinsics.checkParameterIsNotNull(paramIterable, "pairs");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Pair localPair = (Pair)paramIterable.next();
      paramMap.put(localPair.component1(), localPair.component2());
    }
  }
  
  public static final <K, V> void putAll(@NotNull Map<? super K, ? super V> paramMap, @NotNull Sequence<? extends Pair<? extends K, ? extends V>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$putAll");
    Intrinsics.checkParameterIsNotNull(paramSequence, "pairs");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Pair localPair = (Pair)paramSequence.next();
      paramMap.put(localPair.component1(), localPair.component2());
    }
  }
  
  public static final <K, V> void putAll(@NotNull Map<? super K, ? super V> paramMap, @NotNull Pair<? extends K, ? extends V>[] paramArrayOfPair)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$putAll");
    Intrinsics.checkParameterIsNotNull(paramArrayOfPair, "pairs");
    int j = paramArrayOfPair.length;
    int i = 0;
    while (i < j)
    {
      Pair<? extends K, ? extends V> localPair = paramArrayOfPair[i];
      paramMap.put(localPair.component1(), localPair.component2());
      i += 1;
    }
  }
  
  @InlineOnly
  private static final <K, V> V remove(@NotNull Map<? extends K, V> paramMap, K paramK)
  {
    if (paramMap == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
    return TypeIntrinsics.asMutableMap(paramMap).remove(paramK);
  }
  
  @InlineOnly
  private static final <K, V> void set(@NotNull Map<K, V> paramMap, K paramK, V paramV)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$set");
    paramMap.put(paramK, paramV);
  }
  
  @NotNull
  public static final <K, V> Map<K, V> toMap(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toMap");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        return MapsKt.toMap(paramIterable, (Map)new LinkedHashMap(MapsKt.mapCapacity(((Collection)paramIterable).size())));
      case 0: 
        return MapsKt.emptyMap();
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = (Pair)((List)paramIterable).get(0);; paramIterable = (Pair)paramIterable.iterator().next()) {
        return MapsKt.mapOf(paramIterable);
      }
    }
    return MapsKt.optimizeReadOnlyMap(MapsKt.toMap(paramIterable, (Map)new LinkedHashMap()));
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> paramIterable, @NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toMap");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    MapsKt.putAll(paramM, paramIterable);
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <K, V> Map<K, V> toMap(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toMap");
    switch (paramMap.size())
    {
    default: 
      return MapsKt.toMutableMap(paramMap);
    case 0: 
      return MapsKt.emptyMap();
    }
    return MapsKt.toSingletonMap(paramMap);
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toMap");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    paramM.putAll(paramMap);
    return paramM;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> toMap(@NotNull Sequence<? extends Pair<? extends K, ? extends V>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toMap");
    return MapsKt.optimizeReadOnlyMap(MapsKt.toMap(paramSequence, (Map)new LinkedHashMap()));
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Sequence<? extends Pair<? extends K, ? extends V>> paramSequence, @NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toMap");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    MapsKt.putAll(paramM, paramSequence);
    return paramM;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> toMap(@NotNull Pair<? extends K, ? extends V>[] paramArrayOfPair)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfPair, "$this$toMap");
    switch (paramArrayOfPair.length)
    {
    default: 
      return MapsKt.toMap(paramArrayOfPair, (Map)new LinkedHashMap(MapsKt.mapCapacity(paramArrayOfPair.length)));
    case 0: 
      return MapsKt.emptyMap();
    }
    return MapsKt.mapOf(paramArrayOfPair[0]);
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Pair<? extends K, ? extends V>[] paramArrayOfPair, @NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfPair, "$this$toMap");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    MapsKt.putAll(paramM, paramArrayOfPair);
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <K, V> Map<K, V> toMutableMap(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toMutableMap");
    return (Map)new LinkedHashMap(paramMap);
  }
  
  @InlineOnly
  private static final <K, V> Pair<K, V> toPair(@NotNull Map.Entry<? extends K, ? extends V> paramEntry)
  {
    return new Pair(paramEntry.getKey(), paramEntry.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.MapsKt__MapsKt
 * JD-Core Version:    0.7.0.1
 */