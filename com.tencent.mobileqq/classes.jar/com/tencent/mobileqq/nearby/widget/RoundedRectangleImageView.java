package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/widget/RoundedRectangleImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "value", "", "radius", "getRadius", "()F", "setRadius", "(F)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class RoundedRectangleImageView
  extends ImageView
{
  private float a;
  private Path b;
  
  @JvmOverloads
  public RoundedRectangleImageView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public RoundedRectangleImageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public RoundedRectangleImageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final float getRadius()
  {
    return this.a;
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if (this.b == null)
    {
      localPath = new Path();
      RectF localRectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
      float f = this.a;
      localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
      this.b = localPath;
    }
    Path localPath = this.b;
    if (localPath == null) {
      Intrinsics.throwNpe();
    }
    paramCanvas.clipPath(localPath);
    super.onDraw(paramCanvas);
  }
  
  public final void setRadius(float paramFloat)
  {
    this.a = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.RoundedRectangleImageView
 * JD-Core Version:    0.7.0.1
 */