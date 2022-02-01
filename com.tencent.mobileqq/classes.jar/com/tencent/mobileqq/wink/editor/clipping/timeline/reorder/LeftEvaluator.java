package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/LeftEvaluator;", "Landroid/animation/TypeEvaluator;", "Landroid/graphics/Rect;", "rect", "(Landroid/graphics/Rect;)V", "evaluate", "fraction", "", "startValue", "endValue", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class LeftEvaluator
  implements TypeEvaluator<Rect>
{
  private final Rect a;
  
  public LeftEvaluator(@NotNull Rect paramRect)
  {
    this.a = paramRect;
  }
  
  @NotNull
  public Rect a(float paramFloat, @NotNull Rect paramRect1, @NotNull Rect paramRect2)
  {
    Intrinsics.checkParameterIsNotNull(paramRect1, "startValue");
    Intrinsics.checkParameterIsNotNull(paramRect2, "endValue");
    int i = paramRect1.left;
    int j = paramRect1.top;
    int k = (int)(paramRect1.right + (paramRect2.right - paramRect1.right) * paramFloat);
    int m = paramRect1.bottom;
    paramRect1 = this.a;
    paramRect1.set(i, j, k, m);
    return paramRect1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.LeftEvaluator
 * JD-Core Version:    0.7.0.1
 */