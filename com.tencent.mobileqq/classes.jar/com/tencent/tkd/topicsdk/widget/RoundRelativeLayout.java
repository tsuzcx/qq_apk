package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/RoundRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mFilter", "Landroid/graphics/PaintFlagsDrawFilter;", "mRect", "Landroid/graphics/RectF;", "mRoundLayoutRadius", "", "mRoundPath", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "", "t", "r", "b", "setRoundLayoutRadius", "roundLayoutRadius", "setRoundPath", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public class RoundRelativeLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 16.0F;
  private final PaintFlagsDrawFilter jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  
  public RoundRelativeLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "getContext()");
    this.jdField_a_of_type_Float = localDisplayUtils.a(localContext, 16.0F);
    setWillNotDraw(false);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.l);
      this.jdField_a_of_type_Float = paramContext.getDimensionPixelSize(R.styleable.J, 0);
      paramContext.recycle();
    }
  }
  
  private final void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f = this.jdField_a_of_type_Float;
    localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if (this.jdField_a_of_type_Float > 0.0F)
    {
      paramCanvas.setDrawFilter((DrawFilter)this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth() - 1, getHeight() - 1);
    a();
  }
  
  public final void setRoundLayoutRadius(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    a();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RoundRelativeLayout
 * JD-Core Version:    0.7.0.1
 */