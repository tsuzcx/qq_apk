package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

public class GradientProgressView
  extends View
{
  int jdField_a_of_type_Int = 5;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  SweepGradient jdField_a_of_type_AndroidGraphicsSweepGradient;
  int b = 0;
  int c = 0;
  int d = -1;
  
  public GradientProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GradientProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      int i = this.c;
      int j = this.d;
      this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(paramInt1 / 2, paramInt2 / 2, new int[] { i, j }, new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, paramInt1 - this.jdField_a_of_type_Int, paramInt2 - this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsSweepGradient == null) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.b += 3;
    if (this.b > 360) {
      this.b -= 360;
    }
    paramCanvas.rotate(this.b, i / 2, j / 2);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, true, this.jdField_a_of_type_AndroidGraphicsPaint);
    postInvalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  public void setEndColor(int paramInt)
  {
    this.d = paramInt;
    a(getWidth(), getHeight());
  }
  
  public void setStartColor(int paramInt)
  {
    this.c = paramInt;
    a(getWidth(), getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.GradientProgressView
 * JD-Core Version:    0.7.0.1
 */