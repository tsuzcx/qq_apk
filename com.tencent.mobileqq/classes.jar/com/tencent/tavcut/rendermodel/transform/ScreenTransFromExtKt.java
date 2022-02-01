package com.tencent.tavcut.rendermodel.transform;

import com.tencent.tavcut.composition.model.component.Quat;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Vec3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"anchor", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "left", "", "right", "top", "bottom", "offset", "rotate", "degree", "scale", "scaleX", "scaleY", "transitionY", "y", "transtionX", "x", "lib_tavcut_model_release"}, k=2, mv={1, 1, 16})
public final class ScreenTransFromExtKt
{
  @NotNull
  public static final ScreenTransform anchor(@NotNull ScreenTransform paramScreenTransform, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenTransform, "$this$anchor");
    return ScreenTransform.copy$default(paramScreenTransform, null, null, null, null, new Rect(paramFloat1, paramFloat3, paramFloat2, paramFloat4, null, 16, null), null, null, null, null, null, null, null, null, null, null, null, null, null, 262127, null);
  }
  
  @NotNull
  public static final ScreenTransform offset(@NotNull ScreenTransform paramScreenTransform, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenTransform, "$this$offset");
    return ScreenTransform.copy$default(paramScreenTransform, null, null, null, null, null, new Rect(paramFloat1, paramFloat3, paramFloat2, paramFloat4, null, 16, null), null, null, null, null, null, null, null, null, null, null, null, null, 262111, null);
  }
  
  @NotNull
  public static final ScreenTransform rotate(@NotNull ScreenTransform paramScreenTransform, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenTransform, "$this$rotate");
    double d1 = paramFloat;
    double d2 = 2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = (float)Math.toRadians(d1 / d2);
    return ScreenTransform.copy$default(paramScreenTransform, null, null, null, null, null, null, null, null, null, null, null, null, new Quat(0.0F, 0.0F, (float)Math.sin(d1), (float)Math.cos(d1), null, 16, null), null, null, null, null, null, 258047, null);
  }
  
  @NotNull
  public static final ScreenTransform scale(@NotNull ScreenTransform paramScreenTransform, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenTransform, "$this$scale");
    return ScreenTransform.copy$default(paramScreenTransform, null, null, null, null, null, null, null, null, null, null, null, null, null, new Vec3(paramFloat, paramFloat, 1.0F, null, 8, null), null, null, null, null, 253951, null);
  }
  
  @NotNull
  public static final ScreenTransform scale(@NotNull ScreenTransform paramScreenTransform, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenTransform, "$this$scale");
    return ScreenTransform.copy$default(paramScreenTransform, null, null, null, null, null, null, null, null, null, null, null, null, null, new Vec3(paramFloat1, paramFloat2, 1.0F, null, 8, null), null, null, null, null, 253951, null);
  }
  
  @NotNull
  public static final ScreenTransform transitionY(@NotNull ScreenTransform paramScreenTransform, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenTransform, "$this$transitionY");
    if (paramFloat < 0) {
      return ScreenTransform.copy$default(paramScreenTransform, null, null, null, null, new Rect(0.0F, 0.0F, 0.0F, paramFloat, null, 16, null), null, null, null, null, null, null, null, null, null, null, null, null, null, 262127, null);
    }
    return ScreenTransform.copy$default(paramScreenTransform, null, null, null, null, new Rect(0.0F, paramFloat, 0.0F, 0.0F, null, 16, null), null, null, null, null, null, null, null, null, null, null, null, null, null, 262127, null);
  }
  
  @NotNull
  public static final ScreenTransform transtionX(@NotNull ScreenTransform paramScreenTransform, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenTransform, "$this$transtionX");
    if (paramFloat < 0) {
      return ScreenTransform.copy$default(paramScreenTransform, null, null, null, null, new Rect(paramFloat, 0.0F, 0.0F, 0.0F, null, 16, null), null, null, null, null, null, null, null, null, null, null, null, null, null, 262127, null);
    }
    return ScreenTransform.copy$default(paramScreenTransform, null, null, null, null, new Rect(0.0F, 0.0F, paramFloat, 0.0F, null, 16, null), null, null, null, null, null, null, null, null, null, null, null, null, null, 262127, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.transform.ScreenTransFromExtKt
 * JD-Core Version:    0.7.0.1
 */