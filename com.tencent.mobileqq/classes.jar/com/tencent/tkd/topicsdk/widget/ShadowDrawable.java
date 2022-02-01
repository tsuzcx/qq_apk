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
  public static final ShadowDrawable.Companion a;
  private final int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint;
  private final int c;
  private final int d;
  private final int e;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetShadowDrawable$Companion = new ShadowDrawable.Companion(null);
  }
  
  private ShadowDrawable(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.e = paramInt1;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt4;
    this.c = paramInt5;
    this.d = paramInt6;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(paramInt4, paramInt5, paramInt6, paramInt3);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      if (this.jdField_a_of_type_ArrayOfInt.length != 1) {
        break label112;
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_ArrayOfInt[0]);
    }
    while (this.e == 1)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      paramCanvas.drawRoundRect((RectF)localObject, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      paramCanvas.drawRoundRect((RectF)localObject, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
      return;
      label112:
      localObject = this.jdField_b_of_type_AndroidGraphicsPaint;
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      if (localRectF == null) {
        Intrinsics.throwNpe();
      }
      f1 = localRectF.left;
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      if (localRectF == null) {
        Intrinsics.throwNpe();
      }
      f2 = localRectF.height() / 2;
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      if (localRectF == null) {
        Intrinsics.throwNpe();
      }
      f3 = localRectF.right;
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      if (localRectF == null) {
        Intrinsics.throwNpe();
      }
      ((Paint)localObject).setShader((Shader)new LinearGradient(f1, f2, f3, localRectF.height() / 2, this.jdField_a_of_type_ArrayOfInt, null, Shader.TileMode.CLAMP));
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f1 = ((RectF)localObject).centerX();
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f2 = ((RectF)localObject).centerY();
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f3 = ((RectF)localObject).width();
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramCanvas.drawCircle(f1, f2, Math.min(f3, ((RectF)localObject).height()) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    f1 = ((RectF)localObject).centerX();
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    f2 = ((RectF)localObject).centerY();
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    f3 = ((RectF)localObject).width();
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramCanvas.drawCircle(f1, f2, Math.min(f3, ((RectF)localObject).height()) / 2, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int + paramInt1 - this.c, this.jdField_a_of_type_Int + paramInt2 - this.d, paramInt3 - this.jdField_a_of_type_Int - this.c, paramInt4 - this.jdField_a_of_type_Int - this.d);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ShadowDrawable
 * JD-Core Version:    0.7.0.1
 */