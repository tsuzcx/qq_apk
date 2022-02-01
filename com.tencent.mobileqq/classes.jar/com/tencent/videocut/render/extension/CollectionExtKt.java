package com.tencent.videocut.render.extension;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"append", "", "T", "v", "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "delete", "", "K", "key", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "insert", "index", "", "(Ljava/util/List;ILjava/lang/Object;)Ljava/util/List;", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/util/Map;", "insertOrReplace", "V", "value", "remove", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class CollectionExtKt
{
  @NotNull
  public static final <T> List<T> a(@NotNull List<? extends T> paramList, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$append");
    paramList = CollectionsKt.toMutableList((Collection)paramList);
    paramList.add(paramT);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.extension.CollectionExtKt
 * JD-Core Version:    0.7.0.1
 */