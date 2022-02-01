package com.tencent.mobileqq.structmsg;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class RoundedColorDrawable
  extends Drawable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -16777216;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = null;
  private int b;
  private int c;
  
  public RoundedColorDrawable(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_Float = paramInt4;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    Object localObject = getBounds();
    this.jdField_a_of_type_AndroidGraphicsRectF.top = ((Rect)localObject).top;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = ((Rect)localObject).left;
    this.jdField_a_of_type_AndroidGraphicsRectF.right = ((Rect)localObject).right;
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = ((Rect)localObject).bottom;
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f = this.jdField_a_of_type_Float;
    paramCanvas.drawRoundRect((RectF)localObject, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getIntrinsicHeight()
  {
    return this.c;
  }
  
  public int getIntrinsicWidth()
  {
    return this.b;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.RoundedColorDrawable
 * JD-Core Version:    0.7.0.1
 */