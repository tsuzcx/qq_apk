package com.tencent.tavcut.render.util;

import com.tencent.tavcut.composition.model.component.TimeStretchMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toPagTimeStretchMode", "", "Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "lib_tavcut_release"}, k=2, mv={1, 1, 16})
public final class TimeStretchModeExtKt
{
  public static final int a(@NotNull TimeStretchMode paramTimeStretchMode)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeStretchMode, "$this$toPagTimeStretchMode");
    int i = TimeStretchModeExtKt.WhenMappings.$EnumSwitchMapping$0[paramTimeStretchMode.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return 2;
      }
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.util.TimeStretchModeExtKt
 * JD-Core Version:    0.7.0.1
 */