package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class CircleBarView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CircleBarView.CircleAnim jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$CircleAnim;
  private CircleBarView.OnAnimationListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$OnAnimationListener;
  private CircleBarView.ProgressAnim jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$ProgressAnim;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float d;
  private float e;
  private float f;
  
  public CircleBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (i == 1073741824) {
      return j;
    }
    paramInt2 = paramInt1;
    if (i == -2147483648) {
      paramInt2 = Math.min(paramInt1, j);
    }
    return paramInt2;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_Int = -16711936;
    this.jdField_b_of_type_Int = -7829368;
    this.jdField_c_of_type_Float = -90.0F;
    this.d = 360.0F;
    this.e = a(paramContext, 4.0F);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 100.0F;
    this.jdField_c_of_type_Int = a(paramContext, 100.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$ProgressAnim = new CircleBarView.ProgressAnim(this);
  }
  
  public void a()
  {
    CircleBarView.CircleAnim localCircleAnim = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$CircleAnim;
    if ((localCircleAnim != null) && (localCircleAnim.hasStarted())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$CircleAnim.cancel();
    }
    clearAnimation();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$CircleAnim = new CircleBarView.CircleAnim(this);
    this.jdField_a_of_type_Float = 100.0F;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$CircleAnim.setDuration(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$CircleAnim.setRepeatCount(-1);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$CircleAnim.setInterpolator(new LinearInterpolator());
    startAnimation(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$CircleAnim);
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint.getColor() != paramInt)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidGraphicsPaint.getColor() != paramInt)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
      invalidate();
      return true;
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Float, this.d, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Float, this.f, false, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = a(this.jdField_c_of_type_Int, paramInt2);
    paramInt1 = Math.min(a(this.jdField_c_of_type_Int, paramInt1), paramInt2);
    setMeasuredDimension(paramInt1, paramInt1);
    float f1 = paramInt1;
    float f2 = this.e;
    if (f1 >= f2 * 2.0F) {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(f2 / 2.0F, f2 / 2.0F, f1 - f2 / 2.0F, f1 - f2 / 2.0F);
    }
  }
  
  public void setMaxNum(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void setOnAnimationListener(CircleBarView.OnAnimationListener paramOnAnimationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$OnAnimationListener = paramOnAnimationListener;
  }
  
  public void setTextView(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CircleBarView
 * JD-Core Version:    0.7.0.1
 */