package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

public class OvalProgress
  extends RelativeLayout
{
  private double jdField_a_of_type_Double;
  public float a;
  private int jdField_a_of_type_Int = -3355444;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private OvalProgress.TagProgress jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = -1.0F;
  private int jdField_b_of_type_Int = -16745985;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private RectF jdField_b_of_type_AndroidGraphicsRectF;
  private float jdField_c_of_type_Float = -1.0F;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private RectF jdField_c_of_type_AndroidGraphicsRectF;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private RectF jdField_d_of_type_AndroidGraphicsRectF;
  private Paint jdField_e_of_type_AndroidGraphicsPaint;
  private RectF jdField_e_of_type_AndroidGraphicsRectF;
  private RectF f;
  private RectF g;
  private RectF h;
  
  public OvalProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public OvalProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OvalProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private double a(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.jdField_a_of_type_Double > 0.0D)
    {
      double d1 = 90;
      Double.isNaN(d1);
      i = (int)(1.0D * paramDouble * d1 / this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.jdField_a_of_type_Double);
    }
    else
    {
      i = 0;
    }
    int j = i;
    if (i > 90) {
      j = 90;
    }
    paramCanvas.drawArc(this.g, 180.0F, j, false, this.jdField_d_of_type_AndroidGraphicsPaint);
    return paramDouble - this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.jdField_a_of_type_Double;
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawArc(this.jdField_c_of_type_AndroidGraphicsRectF, 90.0F, 180.0F, false, this.jdField_c_of_type_AndroidGraphicsPaint);
    paramCanvas.drawArc(this.jdField_d_of_type_AndroidGraphicsRectF, 270.0F, 180.0F, false, this.jdField_c_of_type_AndroidGraphicsPaint);
    e(paramCanvas, d(paramCanvas, c(paramCanvas, b(paramCanvas, a(paramCanvas, this.jdField_a_of_type_Double)))));
  }
  
  private boolean a()
  {
    int i = getWidth();
    int j = getHeight();
    if ((i <= 0) && (j <= 0)) {
      return false;
    }
    if (this.jdField_a_of_type_Float <= 0.0F) {
      this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density * 4.0F / 2.0F);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsPaint == null) || (this.jdField_b_of_type_AndroidGraphicsPaint == null))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    }
    Object localObject;
    float f2;
    float f3;
    if ((this.jdField_c_of_type_AndroidGraphicsRectF == null) || (this.jdField_d_of_type_AndroidGraphicsRectF == null) || (this.g == null) || (this.h == null) || (this.jdField_c_of_type_AndroidGraphicsPaint == null) || (this.jdField_d_of_type_AndroidGraphicsPaint == null))
    {
      this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_d_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
      this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
      this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
      localObject = this.jdField_c_of_type_AndroidGraphicsRectF;
      ((RectF)localObject).left = 1.0F;
      f2 = ((RectF)localObject).left;
      f1 = j;
      ((RectF)localObject).right = (f2 + f1 - 2.0F);
      localObject = this.jdField_c_of_type_AndroidGraphicsRectF;
      ((RectF)localObject).top = 1.0F;
      f2 = j - 1;
      ((RectF)localObject).bottom = f2;
      this.jdField_d_of_type_AndroidGraphicsRectF = new RectF();
      localObject = this.jdField_d_of_type_AndroidGraphicsRectF;
      int k = i - 1;
      f3 = k - (j - 2);
      ((RectF)localObject).left = f3;
      float f4 = k;
      ((RectF)localObject).right = f4;
      ((RectF)localObject).top = 1.0F;
      ((RectF)localObject).bottom = f2;
      this.g = new RectF();
      localObject = this.g;
      ((RectF)localObject).left = 1.0F;
      ((RectF)localObject).right = (((RectF)localObject).left + f1 - 2.0F);
      localObject = this.g;
      ((RectF)localObject).top = 1.0F;
      ((RectF)localObject).bottom = f2;
      this.h = new RectF();
      localObject = this.h;
      ((RectF)localObject).left = f3;
      ((RectF)localObject).right = f4;
      ((RectF)localObject).top = 1.0F;
      ((RectF)localObject).bottom = f2;
    }
    float f1 = i - j;
    double d1;
    if ((this.jdField_a_of_type_AndroidGraphicsRectF == null) || (this.jdField_b_of_type_AndroidGraphicsRectF == null) || (this.jdField_e_of_type_AndroidGraphicsRectF == null) || (this.f == null))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      d1 = i - f1;
      Double.isNaN(d1);
      ((RectF)localObject).left = ((float)(d1 * 1.0D / 2.0D - 0.5D));
      d1 = ((RectF)localObject).left + f1;
      Double.isNaN(d1);
      ((RectF)localObject).right = ((float)(d1 + 0.5D + 0.5D));
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      ((RectF)localObject).top = 0.0F;
      ((RectF)localObject).bottom = 2.0F;
      this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_b_of_type_AndroidGraphicsRectF.left = this.jdField_a_of_type_AndroidGraphicsRectF.left;
      this.jdField_b_of_type_AndroidGraphicsRectF.right = this.jdField_a_of_type_AndroidGraphicsRectF.right;
      localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
      f2 = j - 2;
      ((RectF)localObject).top = f2;
      f3 = j;
      ((RectF)localObject).bottom = f3;
      this.jdField_e_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_e_of_type_AndroidGraphicsRectF.left = this.jdField_a_of_type_AndroidGraphicsRectF.left;
      this.jdField_e_of_type_AndroidGraphicsRectF.right = this.jdField_a_of_type_AndroidGraphicsRectF.right;
      localObject = this.jdField_e_of_type_AndroidGraphicsRectF;
      ((RectF)localObject).top = 0.0F;
      ((RectF)localObject).bottom = 2.0F;
      this.f = new RectF();
      this.f.left = this.jdField_e_of_type_AndroidGraphicsRectF.left;
      this.f.right = this.jdField_e_of_type_AndroidGraphicsRectF.right;
      localObject = this.f;
      ((RectF)localObject).top = f2;
      ((RectF)localObject).bottom = f3;
    }
    double d2;
    if ((this.jdField_e_of_type_AndroidGraphicsPaint == null) || (this.jdField_b_of_type_Float == -1.0F) || (this.jdField_c_of_type_Float == -1.0F))
    {
      this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_e_of_type_AndroidGraphicsPaint.setColor(-65536);
      d1 = (j - 2) / 2;
      Double.isNaN(d1);
      d1 /= 1.4142135623731D;
      f2 = (this.jdField_d_of_type_AndroidGraphicsRectF.left + this.jdField_d_of_type_AndroidGraphicsRectF.right) / 2.0F;
      f3 = (this.jdField_d_of_type_AndroidGraphicsRectF.top + this.jdField_d_of_type_AndroidGraphicsRectF.bottom) / 2.0F;
      d2 = f2;
      Double.isNaN(d2);
      this.jdField_b_of_type_Float = ((float)(d2 + d1));
      d2 = f3;
      Double.isNaN(d2);
      this.jdField_c_of_type_Float = ((float)(d2 - d1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress == null)
    {
      d1 = j - 2;
      Double.isNaN(d1);
      d1 *= 3.141592653589793D;
      d2 = 2.0F * f1;
      Double.isNaN(d2);
      d2 += d1;
      this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress = new OvalProgress.TagProgress(this);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress;
      double d3 = 0.25D * d1 / d2;
      ((OvalProgress.TagProgress)localObject).jdField_a_of_type_Double = d3;
      double d4 = f1;
      Double.isNaN(d4);
      d4 = d4 * 1.0D / d2;
      ((OvalProgress.TagProgress)localObject).b = d4;
      ((OvalProgress.TagProgress)localObject).c = (d1 * 0.5D / d2);
      ((OvalProgress.TagProgress)localObject).d = d4;
      ((OvalProgress.TagProgress)localObject).e = d3;
    }
    return true;
  }
  
  private double b(Canvas paramCanvas, double paramDouble)
  {
    double d1 = 0.0D;
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.b > 0.0D) {
      d1 = paramDouble / this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.b;
    }
    double d2 = d1;
    if (d1 > 1.0D) {
      d2 = 1.0D;
    }
    d1 = this.jdField_e_of_type_AndroidGraphicsRectF.right - this.jdField_e_of_type_AndroidGraphicsRectF.left;
    Double.isNaN(d1);
    float f1 = (float)(d2 * d1);
    paramCanvas.drawRect(this.jdField_e_of_type_AndroidGraphicsRectF.left, this.jdField_e_of_type_AndroidGraphicsRectF.top, this.jdField_e_of_type_AndroidGraphicsRectF.left + f1, this.jdField_e_of_type_AndroidGraphicsRectF.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
    return paramDouble - this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.b;
  }
  
  private double c(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.c > 0.0D)
    {
      double d1 = '´';
      Double.isNaN(d1);
      i = (int)(1.0D * paramDouble * d1 / this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.c);
    }
    else
    {
      i = 0;
    }
    int j = i;
    if (i > 180) {
      j = 180;
    }
    paramCanvas.drawArc(this.h, 270.0F, j, false, this.jdField_d_of_type_AndroidGraphicsPaint);
    return paramDouble - this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.c;
  }
  
  private double d(Canvas paramCanvas, double paramDouble)
  {
    double d1 = 0.0D;
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.d > 0.0D) {
      d1 = paramDouble / this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.d;
    }
    double d2 = d1;
    if (d1 > 1.0D) {
      d2 = 1.0D;
    }
    d1 = this.f.right - this.f.left;
    Double.isNaN(d1);
    float f1 = (float)((1.0D - d2) * d1);
    paramCanvas.drawRect(this.f.left + f1, this.f.top, this.f.right, this.f.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
    return paramDouble - this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.d;
  }
  
  private double e(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.e > 0.0D)
    {
      if (paramDouble > this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.e * 0.99D)
      {
        i = 90;
      }
      else
      {
        double d1 = 90;
        Double.isNaN(d1);
        i = (int)(1.0D * paramDouble * d1 / this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.e);
      }
    }
    else {
      i = 0;
    }
    int j = i;
    if (i > 90) {
      j = 90;
    }
    paramCanvas.drawArc(this.g, 90.0F, j, false, this.jdField_d_of_type_AndroidGraphicsPaint);
    return paramDouble - this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress$TagProgress.e;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (a())
    {
      a(paramCanvas);
      if (this.jdField_a_of_type_Boolean) {
        paramCanvas.drawCircle(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, 4.0F, this.jdField_e_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  public void setProgressParams(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L))
    {
      if (paramLong2 > paramLong1)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Double = 1.0D;
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        double d1 = paramLong2;
        Double.isNaN(d1);
        double d2 = paramLong1;
        Double.isNaN(d2);
        this.jdField_a_of_type_Double = (d1 * 1.0D / d2);
      }
    }
    else {
      this.jdField_a_of_type_Double = 0.0D;
    }
    postInvalidate();
  }
  
  public void setThemeColor(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OvalProgress
 * JD-Core Version:    0.7.0.1
 */