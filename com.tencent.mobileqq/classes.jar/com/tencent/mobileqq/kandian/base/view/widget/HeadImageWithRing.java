package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;

public class HeadImageWithRing
  extends KanDianUrlRoundCornerImageView
{
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  
  public HeadImageWithRing(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeadImageWithRing(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HeadImageWithRing(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.d;
      paramCanvas.drawCircle(i, i, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = ((int)((getMeasuredWidth() - getPaddingLeft() - getPaddingRight() - this.b) * 0.5F));
    double d1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    Double.isNaN(d1);
    double d2 = getPaddingLeft();
    Double.isNaN(d2);
    this.d = ((int)(d1 * 0.5D + d2));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.b);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  public void setAttrs(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void setDrawRing(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.HeadImageWithRing
 * JD-Core Version:    0.7.0.1
 */