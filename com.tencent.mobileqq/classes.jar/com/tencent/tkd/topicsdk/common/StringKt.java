package com.tencent.tkd.topicsdk.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getNotEmpty", "", "defaultValue", "topicsdk-common_release"}, k=2, mv={1, 1, 16})
public final class StringKt
{
  @NotNull
  public static final String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$getNotEmpty");
    Intrinsics.checkParameterIsNotNull(paramString2, "defaultValue");
    int i;
    if (((CharSequence)paramString1).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return paramString2;
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.StringKt
 * JD-Core Version:    0.7.0.1
 */