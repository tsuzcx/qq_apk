package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class CircleProgress
  extends ImageView
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  
  public CircleProgress(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = getResources().getColor(2131492982);
    this.e = getResources().getColor(2131493062);
    this.d = 51;
    this.f = 255;
    this.c = getResources().getColor(2131492985);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.g = getWidth();
    this.h = getHeight();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.d * 255 / 100);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(9.0F, 0.0F, 0.0F, this.c);
    paramCanvas.drawArc(new RectF(this.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Int / 2, this.g - this.jdField_a_of_type_Int / 2, this.h - this.jdField_a_of_type_Int / 2), -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.f * 255 / 100);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(9.0F, 0.0F, 0.0F, this.c);
    paramCanvas.drawArc(new RectF(this.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Int / 2, this.g - this.jdField_a_of_type_Int / 2, this.h - this.jdField_a_of_type_Int / 2), -90.0F, (float)(3.6D * this.jdField_b_of_type_Float), false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setBgAndProgressColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.d = paramInt1;
    this.e = paramInt4;
    this.f = paramInt3;
  }
  
  public void setProgress(float paramFloat)
  {
    float f1 = 100.0F;
    if (paramFloat > 100.0F) {}
    for (;;)
    {
      this.jdField_b_of_type_Float = f1;
      f1 = paramFloat;
      if (paramFloat < 0.0F) {
        f1 = 0.0F;
      }
      this.jdField_b_of_type_Float = f1;
      invalidate();
      return;
      f1 = paramFloat;
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float * paramFloat + 0.5D));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgress
 * JD-Core Version:    0.7.0.1
 */