package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CaptureCommonLoadingView
  extends View
{
  private static float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private RectF jdField_b_of_type_AndroidGraphicsRectF;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private int e;
  private int f;
  
  public CaptureCommonLoadingView(Context paramContext)
  {
    super(paramContext);
    int i = this.jdField_c_of_type_Int;
    float f1 = i - 16843176;
    int j = this.jdField_d_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(f1, j - 16843176, i + 16843176, j + 16843176);
    this.e = 100;
    this.f = 0;
    this.jdField_b_of_type_Float = a(2.0F, getContext());
    this.jdField_c_of_type_Float = a(17.5F, getContext());
    this.jdField_d_of_type_Float = a(2.5F, getContext());
    a();
  }
  
  public CaptureCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = this.jdField_c_of_type_Int;
    float f1 = i - 16843176;
    int j = this.jdField_d_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(f1, j - 16843176, i + 16843176, j + 16843176);
    this.e = 100;
    this.f = 0;
    this.jdField_b_of_type_Float = a(2.0F, getContext());
    this.jdField_c_of_type_Float = a(17.5F, getContext());
    this.jdField_d_of_type_Float = a(2.5F, getContext());
    a();
  }
  
  public CaptureCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = this.jdField_c_of_type_Int;
    float f1 = paramInt - 16843176;
    int i = this.jdField_d_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(f1, i - 16843176, paramInt + 16843176, i + 16843176);
    this.e = 100;
    this.f = 0;
    this.jdField_b_of_type_Float = a(2.0F, getContext());
    this.jdField_c_of_type_Float = a(17.5F, getContext());
    this.jdField_d_of_type_Float = a(2.5F, getContext());
    a();
  }
  
  public static int a(float paramFloat, Context paramContext)
  {
    if (jdField_a_of_type_Float == 0.0F) {
      jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramFloat * jdField_a_of_type_Float);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(2130706432);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f1 = this.jdField_b_of_type_Float;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawCircle(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_c_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawCircle(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_c_of_type_Float - this.jdField_d_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    f1 = this.f * 360.0F / this.e;
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, f1);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    paramInt1 = this.jdField_a_of_type_Int;
    this.jdField_c_of_type_Int = (paramInt1 / 2);
    paramInt2 = this.jdField_b_of_type_Int;
    this.jdField_d_of_type_Int = (paramInt2 / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    float f1 = this.jdField_c_of_type_Float - this.jdField_d_of_type_Float;
    paramInt1 = this.jdField_c_of_type_Int;
    float f2 = paramInt1;
    paramInt2 = this.jdField_d_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(f2 - f1, paramInt2 - f1, paramInt1 + f1, paramInt2 + f1);
  }
  
  public void setCorner(int paramInt)
  {
    this.jdField_b_of_type_Float = paramInt;
  }
  
  public void setMax(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.f = paramInt;
    invalidate();
    if (this.f == this.e) {
      setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CaptureCommonLoadingView
 * JD-Core Version:    0.7.0.1
 */