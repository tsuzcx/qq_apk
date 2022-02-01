package com.tencent.weseevideo.common.utils;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"append", "", "T", "item", "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "items", "", "K", "V", "key", "v", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "delete", "deleteAll", "insert", "position", "", "(Ljava/util/List;ILjava/lang/Object;)Ljava/util/List;", "replace", "index", "newItem", "toArray", "", "", "libtavcut_debug"}, k=2, mv={1, 1, 16})
public final class CollectionExtKt
{
  @NotNull
  public static final float[] a(@NotNull List<Float> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$toArray");
    return CollectionsKt.toFloatArray((Collection)paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.common.utils.CollectionExtKt
 * JD-Core Version:    0.7.0.1
 */