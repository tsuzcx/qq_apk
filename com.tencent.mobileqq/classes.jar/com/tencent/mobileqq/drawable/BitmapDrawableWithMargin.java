package com.tencent.mobileqq.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;

public class BitmapDrawableWithMargin
  extends BitmapDrawable
{
  private float jdField_a_of_type_Float = 1920.0F;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private int b;
  private int c = 0;
  
  public BitmapDrawableWithMargin(Resources paramResources, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramResources, paramBitmap);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_Float = (paramResources.getDisplayMetrics().densityDpi / 160.0F * 12.0F);
    super.setGravity(17);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.c;
    if (i >>> 24 != 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      RectF localRectF = new RectF(getBounds());
      float f = this.jdField_a_of_type_Float;
      paramCanvas.drawRoundRect(localRectF, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    int i = this.b;
    if (i > 0) {
      return i;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    int i = this.jdField_a_of_type_Int;
    if (i > 0) {
      return i;
    }
    return super.getIntrinsicWidth();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha()) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    }
    super.setAlpha(paramInt);
  }
  
  public void setTargetDensity(int paramInt)
  {
    this.jdField_a_of_type_Float = (paramInt / 160.0F * 12.0F);
    super.setTargetDensity(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.drawable.BitmapDrawableWithMargin
 * JD-Core Version:    0.7.0.1
 */