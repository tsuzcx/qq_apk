package com.tencent.mobileqq.widget;

import akvh;
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
  private akvh jdField_a_of_type_Akvh;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
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
    int j = 90;
    if (this.jdField_a_of_type_Akvh.jdField_a_of_type_Double > 0.0D) {}
    for (int i = (int)(1.0D * paramDouble * 90 / this.jdField_a_of_type_Akvh.jdField_a_of_type_Double);; i = 0)
    {
      if (i > 90) {
        i = j;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.g, 180.0F, i, false, this.jdField_d_of_type_AndroidGraphicsPaint);
        return paramDouble - this.jdField_a_of_type_Akvh.jdField_a_of_type_Double;
      }
    }
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
      this.jdField_c_of_type_AndroidGraphicsRectF.left = 1.0F;
      this.jdField_c_of_type_AndroidGraphicsRectF.right = (this.jdField_c_of_type_AndroidGraphicsRectF.left + j - 2.0F);
      this.jdField_c_of_type_AndroidGraphicsRectF.top = 1.0F;
      this.jdField_c_of_type_AndroidGraphicsRectF.bottom = (j - 1);
      this.jdField_d_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_d_of_type_AndroidGraphicsRectF.left = (i - 1 - (j - 2));
      this.jdField_d_of_type_AndroidGraphicsRectF.right = (i - 1);
      this.jdField_d_of_type_AndroidGraphicsRectF.top = 1.0F;
      this.jdField_d_of_type_AndroidGraphicsRectF.bottom = (j - 1);
      this.g = new RectF();
      this.g.left = 1.0F;
      this.g.right = (this.g.left + j - 2.0F);
      this.g.top = 1.0F;
      this.g.bottom = (j - 1);
      this.h = new RectF();
      this.h.left = (i - 1 - (j - 2));
      this.h.right = (i - 1);
      this.h.top = 1.0F;
      this.h.bottom = (j - 1);
    }
    float f1 = i - j;
    if ((this.jdField_a_of_type_AndroidGraphicsRectF == null) || (this.jdField_b_of_type_AndroidGraphicsRectF == null) || (this.jdField_e_of_type_AndroidGraphicsRectF == null) || (this.f == null))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_a_of_type_AndroidGraphicsRectF.left = ((float)((i - f1) * 1.0D / 2.0D - 0.5D));
      this.jdField_a_of_type_AndroidGraphicsRectF.right = ((float)(this.jdField_a_of_type_AndroidGraphicsRectF.left + f1 + 0.5D + 0.5D));
      this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = 2.0F;
      this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_b_of_type_AndroidGraphicsRectF.left = this.jdField_a_of_type_AndroidGraphicsRectF.left;
      this.jdField_b_of_type_AndroidGraphicsRectF.right = this.jdField_a_of_type_AndroidGraphicsRectF.right;
      this.jdField_b_of_type_AndroidGraphicsRectF.top = (j - 2);
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = j;
      this.jdField_e_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_e_of_type_AndroidGraphicsRectF.left = this.jdField_a_of_type_AndroidGraphicsRectF.left;
      this.jdField_e_of_type_AndroidGraphicsRectF.right = this.jdField_a_of_type_AndroidGraphicsRectF.right;
      this.jdField_e_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_e_of_type_AndroidGraphicsRectF.bottom = 2.0F;
      this.f = new RectF();
      this.f.left = this.jdField_e_of_type_AndroidGraphicsRectF.left;
      this.f.right = this.jdField_e_of_type_AndroidGraphicsRectF.right;
      this.f.top = (j - 2);
      this.f.bottom = j;
    }
    double d1;
    if ((this.jdField_e_of_type_AndroidGraphicsPaint == null) || (this.jdField_b_of_type_Float == -1.0F) || (this.jdField_c_of_type_Float == -1.0F))
    {
      this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_e_of_type_AndroidGraphicsPaint.setColor(-65536);
      d1 = (j - 2) / 2 / 1.4142135623731D;
      float f2 = (this.jdField_d_of_type_AndroidGraphicsRectF.left + this.jdField_d_of_type_AndroidGraphicsRectF.right) / 2.0F;
      float f3 = (this.jdField_d_of_type_AndroidGraphicsRectF.top + this.jdField_d_of_type_AndroidGraphicsRectF.bottom) / 2.0F;
      this.jdField_b_of_type_Float = ((float)(f2 + d1));
      this.jdField_c_of_type_Float = ((float)(f3 - d1));
    }
    if (this.jdField_a_of_type_Akvh == null)
    {
      d1 = (j - 2) * 3.141592653589793D;
      double d2 = 2.0F * f1 + d1;
      this.jdField_a_of_type_Akvh = new akvh(this);
      this.jdField_a_of_type_Akvh.jdField_a_of_type_Double = (0.25D * d1 / d2);
      this.jdField_a_of_type_Akvh.b = (f1 * 1.0D / d2);
      this.jdField_a_of_type_Akvh.c = (0.5D * d1 / d2);
      this.jdField_a_of_type_Akvh.d = (f1 * 1.0D / d2);
      this.jdField_a_of_type_Akvh.e = (d1 * 0.25D / d2);
    }
    return true;
  }
  
  private double b(Canvas paramCanvas, double paramDouble)
  {
    double d2 = 1.0D;
    double d1 = 0.0D;
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    if (this.jdField_a_of_type_Akvh.b > 0.0D) {
      d1 = paramDouble / this.jdField_a_of_type_Akvh.b;
    }
    if (d1 > 1.0D) {
      d1 = d2;
    }
    for (;;)
    {
      float f1 = (float)(d1 * (this.jdField_e_of_type_AndroidGraphicsRectF.right - this.jdField_e_of_type_AndroidGraphicsRectF.left));
      paramCanvas.drawRect(this.jdField_e_of_type_AndroidGraphicsRectF.left, this.jdField_e_of_type_AndroidGraphicsRectF.top, this.jdField_e_of_type_AndroidGraphicsRectF.left + f1, this.jdField_e_of_type_AndroidGraphicsRectF.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
      return paramDouble - this.jdField_a_of_type_Akvh.b;
    }
  }
  
  private double c(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int j = 180;
    if (this.jdField_a_of_type_Akvh.c > 0.0D) {}
    for (int i = (int)(1.0D * paramDouble * '´' / this.jdField_a_of_type_Akvh.c);; i = 0)
    {
      if (i > 180) {
        i = j;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.h, 270.0F, i, false, this.jdField_d_of_type_AndroidGraphicsPaint);
        return paramDouble - this.jdField_a_of_type_Akvh.c;
      }
    }
  }
  
  private double d(Canvas paramCanvas, double paramDouble)
  {
    double d1 = 0.0D;
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    if (this.jdField_a_of_type_Akvh.d > 0.0D) {
      d1 = paramDouble / this.jdField_a_of_type_Akvh.d;
    }
    double d2 = d1;
    if (d1 > 1.0D) {
      d2 = 1.0D;
    }
    float f1 = (float)((1.0D - d2) * (this.f.right - this.f.left));
    paramCanvas.drawRect(this.f.left + f1, this.f.top, this.f.right, this.f.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
    return paramDouble - this.jdField_a_of_type_Akvh.d;
  }
  
  private double e(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int j = 90;
    int i;
    if (this.jdField_a_of_type_Akvh.e > 0.0D) {
      if (paramDouble > this.jdField_a_of_type_Akvh.e * 0.99D) {
        i = 90;
      }
    }
    for (;;)
    {
      if (i > 90) {
        i = j;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.g, 90.0F, i, false, this.jdField_d_of_type_AndroidGraphicsPaint);
        return paramDouble - this.jdField_a_of_type_Akvh.e;
        i = (int)(1.0D * paramDouble * 90 / this.jdField_a_of_type_Akvh.e);
        break;
      }
      i = 0;
    }
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
    if ((paramLong1 <= 0L) || (paramLong2 < 0L)) {
      this.jdField_a_of_type_Double = 0.0D;
    }
    for (;;)
    {
      postInvalidate();
      return;
      if (paramLong2 > paramLong1)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Double = 1.0D;
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Double = (paramLong2 * 1.0D / paramLong1);
      }
    }
  }
  
  public void setThemeColor(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OvalProgress
 * JD-Core Version:    0.7.0.1
 */