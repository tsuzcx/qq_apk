package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;

public class BorderTextView
  extends SimpleTextView
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int b = 0;
  
  public BorderTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BorderTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BorderTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.b);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    paramCanvas.drawRoundRect(new RectF(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, getMeasuredWidth() - this.jdField_a_of_type_Int, getMeasuredHeight() - this.jdField_a_of_type_Int), this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setBorderColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramInt;
  }
  
  public void setRadius(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.BorderTextView
 * JD-Core Version:    0.7.0.1
 */