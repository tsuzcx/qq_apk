package com.tencent.mobileqq.newnearby;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/newnearby/NearbyCenterTransparentDrawable;", "Landroid/graphics/drawable/Drawable;", "radius", "", "x", "", "w", "(FII)V", "paint", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyCenterTransparentDrawable
  extends Drawable
{
  private final Paint a;
  private final float b;
  private final int c;
  private final int d;
  
  public NearbyCenterTransparentDrawable(float paramFloat, int paramInt1, int paramInt2)
  {
    this.b = paramFloat;
    this.c = paramInt1;
    this.d = paramInt2;
    this.a = new Paint();
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Object localObject = getBounds();
    int i;
    if (Build.VERSION.SDK_INT >= 21) {
      i = paramCanvas.saveLayer(0.0F, 0.0F, ((Rect)localObject).width(), ((Rect)localObject).height(), this.a);
    } else {
      i = paramCanvas.saveLayer(0.0F, 0.0F, ((Rect)localObject).width(), ((Rect)localObject).height(), this.a, 31);
    }
    this.a.setColor(Color.parseColor("#AA000000"));
    paramCanvas.drawRect((Rect)localObject, this.a);
    this.a.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    localObject = new RectF(this.c, ((Rect)localObject).top, this.c + this.d, ((Rect)localObject).bottom);
    float f = this.b;
    paramCanvas.drawRoundRect((RectF)localObject, f, f, this.a);
    this.a.setXfermode((Xfermode)null);
    paramCanvas.restoreToCount(i);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyCenterTransparentDrawable
 * JD-Core Version:    0.7.0.1
 */