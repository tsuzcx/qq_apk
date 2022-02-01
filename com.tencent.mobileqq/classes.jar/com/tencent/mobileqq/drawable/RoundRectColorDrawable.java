package com.tencent.mobileqq.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;

public class RoundRectColorDrawable
  extends ColorDrawable
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private final int b;
  
  public RoundRectColorDrawable(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt2, paramInt3);
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
  }
  
  public void draw(Canvas paramCanvas)
  {
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f = this.jdField_a_of_type_Float;
    paramCanvas.drawRoundRect(localRectF, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getIntrinsicHeight()
  {
    return this.b;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.drawable.RoundRectColorDrawable
 * JD-Core Version:    0.7.0.1
 */