package com.tencent.mobileqq.vas.utils;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/utils/CacheHelper$ObjectCache;", "", "()V", "cache", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/HashMap;", "clear", "", "getCache", "key", "put", "o", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class CacheHelper$ObjectCache
{
  private final HashMap<String, WeakReference<Object>> a = new HashMap();
  
  @Nullable
  public final Object a(@Nullable String paramString)
  {
    paramString = (WeakReference)((Map)this.a).get(paramString);
    if (paramString != null) {
      return paramString.get();
    }
    return null;
  }
  
  public final void a(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramObject, "o");
    ((Map)this.a).put(paramString, new WeakReference(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.utils.CacheHelper.ObjectCache
 * JD-Core Version:    0.7.0.1
 */