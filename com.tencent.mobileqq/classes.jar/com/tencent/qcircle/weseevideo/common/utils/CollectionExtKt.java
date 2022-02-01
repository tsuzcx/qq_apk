package com.tencent.qcircle.weseevideo.common.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"append", "", "T", "item", "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "items", "", "K", "V", "key", "v", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "delete", "deleteAll", "insert", "position", "", "(Ljava/util/List;ILjava/lang/Object;)Ljava/util/List;", "replace", "index", "newItem", "toArray", "", "", "libtavcut_debug"}, k=2, mv={1, 1, 16})
public final class CollectionExtKt
{
  @NotNull
  public static final <T> List<T> append(@NotNull List<? extends T> paramList, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$append");
    paramList = CollectionsKt.toMutableList((Collection)paramList);
    paramList.add(paramT);
    return paramList;
  }
  
  @NotNull
  public static final <T> List<T> append(@NotNull List<? extends T> paramList1, @NotNull List<? extends T> paramList2)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "$this$append");
    Intrinsics.checkParameterIsNotNull(paramList2, "items");
    paramList1 = CollectionsKt.toMutableList((Collection)paramList1);
    paramList1.addAll((Collection)paramList2);
    return paramList1;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> append(@NotNull Map<K, ? extends V> paramMap, K paramK, V paramV)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$append");
    paramMap = MapsKt.toMutableMap(paramMap);
    paramMap.put(paramK, paramV);
    return paramMap;
  }
  
  @NotNull
  public static final <T> List<T> delete(@NotNull List<? extends T> paramList, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$delete");
    paramList = CollectionsKt.toMutableList((Collection)paramList);
    paramList.remove(paramT);
    return paramList;
  }
  
  @NotNull
  public static final <T> List<T> deleteAll(@NotNull List<? extends T> paramList1, @NotNull List<? extends T> paramList2)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "$this$deleteAll");
    Intrinsics.checkParameterIsNotNull(paramList2, "items");
    paramList1 = CollectionsKt.toMutableList((Collection)paramList1);
    paramList1.removeAll((Collection)paramList2);
    return paramList1;
  }
  
  @NotNull
  public static final <T> List<T> insert(@NotNull List<? extends T> paramList, int paramInt, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$insert");
    paramList = CollectionsKt.toMutableList((Collection)paramList);
    paramList.add(paramT);
    return paramList;
  }
  
  @NotNull
  public static final <T> List<T> replace(@NotNull List<? extends T> paramList, int paramInt, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$replace");
    paramList = CollectionsKt.toMutableList((Collection)paramList);
    paramList.remove(paramInt);
    paramList.add(paramInt, paramT);
    return paramList;
  }
  
  @NotNull
  public static final float[] toArray(@NotNull List<Float> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$toArray");
    return CollectionsKt.toFloatArray((Collection)paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.common.utils.CollectionExtKt
 * JD-Core Version:    0.7.0.1
 */