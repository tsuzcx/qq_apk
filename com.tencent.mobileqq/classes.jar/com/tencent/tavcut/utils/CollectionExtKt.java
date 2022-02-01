package com.tencent.tavcut.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"append", "", "T", "v", "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "delete", "", "K", "key", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "insert", "index", "", "(Ljava/util/List;ILjava/lang/Object;)Ljava/util/List;", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/util/Map;", "insertOrReplace", "V", "value", "remove", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "lib_tavcut_release"}, k=2, mv={1, 1, 16})
public final class CollectionExtKt
{
  @NotNull
  public static final <T> List<T> a(@NotNull List<? extends T> paramList, int paramInt, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$insert");
    paramList = CollectionsKt.toMutableList((Collection)paramList);
    paramList.add(paramInt, paramT);
    return paramList;
  }
  
  @NotNull
  public static final <T> List<T> a(@NotNull List<? extends T> paramList, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$append");
    paramList = CollectionsKt.toMutableList((Collection)paramList);
    paramList.add(paramT);
    return paramList;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> a(@NotNull Map<K, ? extends V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$remove");
    paramMap = MapsKt.toMutableMap(paramMap);
    paramMap.remove(paramK);
    return paramMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> a(@NotNull Map<K, ? extends V> paramMap, K paramK, V paramV)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$insertOrReplace");
    paramMap = MapsKt.toMutableMap(paramMap);
    paramMap.put(paramK, paramV);
    return paramMap;
  }
  
  @NotNull
  public static final <K, T> Map<K, List<T>> a(@NotNull Map<K, ? extends List<? extends T>> paramMap, K paramK, T paramT, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$insert");
    Map localMap = MapsKt.toMutableMap(paramMap);
    paramMap = (List)localMap.get(paramK);
    if (paramMap == null) {
      paramMap = CollectionsKt.emptyList();
    }
    localMap.put(paramK, a(paramMap, paramInt, paramT));
    return localMap;
  }
  
  @NotNull
  public static final <T> List<T> b(@NotNull List<? extends T> paramList, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$delete");
    paramList = CollectionsKt.toMutableList((Collection)paramList);
    paramList.remove(paramT);
    return paramList;
  }
  
  @NotNull
  public static final <K, T> Map<K, List<T>> b(@NotNull Map<K, ? extends List<? extends T>> paramMap, K paramK, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$insert");
    Map localMap = MapsKt.toMutableMap(paramMap);
    paramMap = (List)localMap.get(paramK);
    if (paramMap == null) {
      paramMap = CollectionsKt.emptyList();
    }
    localMap.put(paramK, a(paramMap, paramT));
    return localMap;
  }
  
  @NotNull
  public static final <K, T> Map<K, List<T>> c(@NotNull Map<K, ? extends List<? extends T>> paramMap, K paramK, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$delete");
    Map localMap = MapsKt.toMutableMap(paramMap);
    paramMap = (List)localMap.get(paramK);
    if (paramMap == null) {
      paramMap = CollectionsKt.emptyList();
    }
    localMap.put(paramK, b(paramMap, paramT));
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.CollectionExtKt
 * JD-Core Version:    0.7.0.1
 */