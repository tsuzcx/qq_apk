package com.tencent.mobileqq.olympic.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

public class ARTipsCircleProgress
  extends TextView
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private int b = 8;
  private int c = getResources().getColor(2131165345);
  private int d = -1;
  
  public ARTipsCircleProgress(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ARTipsCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ARTipsCircleProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.b);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    if (this.jdField_a_of_type_AndroidGraphicsRectF != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F * (this.jdField_a_of_type_Int / 100.0F), false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    }
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.b / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.b / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (paramInt1 - this.b / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (paramInt2 - this.b / 2);
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    setText(this.jdField_a_of_type_Int + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsCircleProgress
 * JD-Core Version:    0.7.0.1
 */