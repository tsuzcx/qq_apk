package com.tencent.tkd.topicsdk.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/ShadowDrawable;", "Landroid/graphics/drawable/Drawable;", "mShape", "", "bgColor", "", "shapeRadius", "shadowColor", "shadowRadius", "offsetX", "offsetY", "(I[IIIIII)V", "mBgColor", "mBgPaint", "Landroid/graphics/Paint;", "mOffsetX", "mOffsetY", "mRect", "Landroid/graphics/RectF;", "mShadowPaint", "mShadowRadius", "mShapeRadius", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "setAlpha", "alpha", "setBounds", "left", "top", "right", "bottom", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "Builder", "Companion", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class ShadowDrawable
  extends Drawable
{
  public static final ShadowDrawable.Companion a = new ShadowDrawable.Companion(null);
  private final Paint b;
  private final Paint c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int[] h;
  private RectF i;
  private final int j;
  
  private ShadowDrawable(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.j = paramInt1;
    this.h = paramArrayOfInt;
    this.e = paramInt2;
    this.d = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
    this.b = new Paint();
    this.b.setColor(0);
    this.b.setAntiAlias(true);
    this.b.setShadowLayer(paramInt4, paramInt5, paramInt6, paramInt3);
    this.b.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    this.c = new Paint();
    this.c.setAntiAlias(true);
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Object localObject = this.h;
    if (localObject != null) {
      if (localObject.length == 1)
      {
        this.c.setColor(localObject[0]);
      }
      else
      {
        localObject = this.c;
        RectF localRectF = this.i;
        if (localRectF == null) {
          Intrinsics.throwNpe();
        }
        f1 = localRectF.left;
        localRectF = this.i;
        if (localRectF == null) {
          Intrinsics.throwNpe();
        }
        f3 = localRectF.height();
        f2 = 2;
        f3 /= f2;
        localRectF = this.i;
        if (localRectF == null) {
          Intrinsics.throwNpe();
        }
        f4 = localRectF.right;
        localRectF = this.i;
        if (localRectF == null) {
          Intrinsics.throwNpe();
        }
        ((Paint)localObject).setShader((Shader)new LinearGradient(f1, f3, f4, localRectF.height() / f2, this.h, null, Shader.TileMode.CLAMP));
      }
    }
    if (this.j == 1)
    {
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      int k = this.e;
      paramCanvas.drawRoundRect((RectF)localObject, k, k, this.b);
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      k = this.e;
      paramCanvas.drawRoundRect((RectF)localObject, k, k, this.c);
      return;
    }
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f2 = ((RectF)localObject).centerX();
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f3 = ((RectF)localObject).centerY();
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f1 = ((RectF)localObject).width();
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f4 = Math.min(f1, ((RectF)localObject).height());
    f1 = 2;
    paramCanvas.drawCircle(f2, f3, f4 / f1, this.b);
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    f2 = ((RectF)localObject).centerX();
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    f3 = ((RectF)localObject).centerY();
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    f4 = ((RectF)localObject).width();
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramCanvas.drawCircle(f2, f3, Math.min(f4, ((RectF)localObject).height()) / f1, this.c);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    int k = this.d;
    int m = this.f;
    float f1 = paramInt1 + k - m;
    paramInt1 = this.g;
    this.i = new RectF(f1, paramInt2 + k - paramInt1, paramInt3 - k - m, paramInt4 - k - paramInt1);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ShadowDrawable
 * JD-Core Version:    0.7.0.1
 */