package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class TDCircleProgressView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = Color.rgb(107, 203, 250);
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  
  public TDCircleProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TDCircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TDCircleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_Float = a(paramContext, 4.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.rgb(144, 144, 144));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    if (this.jdField_c_of_type_Int == 1) {
      this.jdField_b_of_type_Float = -180.0F;
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(a(paramContext, 11.0F));
      this.jdField_c_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(Color.rgb(144, 144, 144));
      return;
      if (this.jdField_c_of_type_Int == 2) {
        this.jdField_b_of_type_Float = -90.0F;
      } else if (this.jdField_c_of_type_Int == 3) {
        this.jdField_b_of_type_Float = 0.0F;
      } else if (this.jdField_c_of_type_Int == 4) {
        this.jdField_b_of_type_Float = 90.0F;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    RectF localRectF = new RectF(this.jdField_a_of_type_Float / 2.0F, this.jdField_a_of_type_Float / 2.0F, getWidth() - this.jdField_a_of_type_Float / 2.0F, getHeight() - this.jdField_a_of_type_Float / 2.0F);
    paramCanvas.drawArc(localRectF, 0.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    float f = this.jdField_a_of_type_Int * 360 / 100;
    paramCanvas.drawArc(localRectF, this.jdField_b_of_type_Float, f, false, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawText(this.jdField_a_of_type_Int + "%", getWidth() / 2, getHeight() / 2 + a(this.jdField_a_of_type_AndroidContentContext, 4.0F), this.jdField_c_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 < paramInt2) {}
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt1);
      return;
      paramInt1 = paramInt2;
    }
  }
  
  public void setCurrent(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TDCircleProgressView
 * JD-Core Version:    0.7.0.1
 */