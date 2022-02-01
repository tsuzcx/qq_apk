package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/view/widget/ScalingFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scale", "", "getScale", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setScale", "factor", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ScalingFrameLayout
  extends FrameLayout
{
  private float a = 1.0F;
  
  public ScalingFrameLayout(@NotNull Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  public ScalingFrameLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  public ScalingFrameLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
  }
  
  public final float getScale()
  {
    return this.a;
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    float f = this.a;
    paramCanvas.scale(f, f, getWidth() / 2, getHeight() / 2);
    super.onDraw(paramCanvas);
  }
  
  public final void setScale(float paramFloat)
  {
    this.a = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ScalingFrameLayout
 * JD-Core Version:    0.7.0.1
 */