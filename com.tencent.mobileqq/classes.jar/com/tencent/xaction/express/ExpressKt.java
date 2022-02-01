package com.tencent.xaction.express;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"convert", "", "", "javaClass", "Ljava/lang/Class;", "XActionCore_release"}, k=2, mv={1, 1, 16})
public final class ExpressKt
{
  @Nullable
  public static final Object a(@NotNull String paramString, @NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$convert");
    Intrinsics.checkParameterIsNotNull(paramClass, "javaClass");
    if (Intrinsics.areEqual(paramClass, Float.TYPE)) {
      return Float.valueOf(Float.parseFloat(paramString));
    }
    if (Intrinsics.areEqual(paramClass, Integer.TYPE)) {
      return Integer.valueOf(Integer.parseInt(paramString));
    }
    if (Intrinsics.areEqual(paramClass, Double.TYPE)) {
      return Double.valueOf(Double.parseDouble(paramString));
    }
    if (Intrinsics.areEqual(paramClass, Long.TYPE)) {
      return Long.valueOf(Long.parseLong(paramString));
    }
    Object localObject = paramString;
    if (Intrinsics.areEqual(paramClass, Short.TYPE)) {
      localObject = Short.valueOf(Short.parseShort(paramString));
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.express.ExpressKt
 * JD-Core Version:    0.7.0.1
 */