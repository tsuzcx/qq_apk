package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.View.DragShadowBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragShadow;", "Landroid/view/View$DragShadowBuilder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "onDrawShadow", "", "canvas", "Landroid/graphics/Canvas;", "onProvideShadowMetrics", "shadowSize", "Landroid/graphics/Point;", "shadowTouchPoint", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class DragShadow
  extends View.DragShadowBuilder
{
  public static final DragShadow.Companion a = new DragShadow.Companion(null);
  
  public DragShadow(@Nullable View paramView)
  {
    super(paramView);
  }
  
  public void onDrawShadow(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public void onProvideShadowMetrics(@NotNull Point paramPoint1, @NotNull Point paramPoint2)
  {
    Intrinsics.checkParameterIsNotNull(paramPoint1, "shadowSize");
    Intrinsics.checkParameterIsNotNull(paramPoint2, "shadowTouchPoint");
    paramPoint1.set(1, 1);
    paramPoint2.set(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragShadow
 * JD-Core Version:    0.7.0.1
 */