package com.tencent.mobileqq.kandian.base.view.widget;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<no name provided>", "", "canvas", "Landroid/graphics/Canvas;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJBlackWhiteModeLinearLayout$drawCanvas$1
  extends Lambda
  implements Function1<Canvas, Unit>
{
  RIJBlackWhiteModeLinearLayout$drawCanvas$1(RIJBlackWhiteModeLinearLayout paramRIJBlackWhiteModeLinearLayout)
  {
    super(1);
  }
  
  public final void invoke(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    RIJBlackWhiteModeLinearLayout.a(this.this$0, paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RIJBlackWhiteModeLinearLayout.drawCanvas.1
 * JD-Core Version:    0.7.0.1
 */