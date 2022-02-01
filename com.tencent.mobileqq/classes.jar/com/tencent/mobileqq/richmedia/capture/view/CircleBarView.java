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
import bape;
import bapf;
import bapg;

public class CircleBarView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bape jdField_a_of_type_Bape;
  private bapf jdField_a_of_type_Bapf;
  private bapg jdField_a_of_type_Bapg;
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
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824) {
      paramInt2 = i;
    }
    do
    {
      return paramInt2;
      paramInt2 = paramInt1;
    } while (j != -2147483648);
    return Math.min(paramInt1, i);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
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
    this.jdField_a_of_type_Bapg = new bapg(this);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bape != null) && (this.jdField_a_of_type_Bape.hasStarted())) {
      this.jdField_a_of_type_Bape.cancel();
    }
    clearAnimation();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bape = new bape(this);
    this.jdField_a_of_type_Float = 100.0F;
    this.jdField_a_of_type_Bape.setDuration(paramInt);
    this.jdField_a_of_type_Bape.setRepeatCount(-1);
    this.jdField_a_of_type_Bape.setInterpolator(new LinearInterpolator());
    startAnimation(this.jdField_a_of_type_Bape);
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
    if (paramInt1 >= this.e * 2.0F) {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.e / 2.0F, this.e / 2.0F, paramInt1 - this.e / 2.0F, paramInt1 - this.e / 2.0F);
    }
  }
  
  public void setMaxNum(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void setOnAnimationListener(bapf parambapf)
  {
    this.jdField_a_of_type_Bapf = parambapf;
  }
  
  public void setTextView(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CircleBarView
 * JD-Core Version:    0.7.0.1
 */