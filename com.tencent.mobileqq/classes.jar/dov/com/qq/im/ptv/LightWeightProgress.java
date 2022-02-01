package dov.com.qq.im.ptv;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import bqja;

public class LightWeightProgress
  extends View
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  protected Paint a;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  protected Paint b;
  int c;
  protected Paint c;
  int d;
  int e;
  int f = 2;
  int g = bqja.a(14.0F);
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  
  public LightWeightProgress(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LightWeightProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public int a()
  {
    return this.d;
  }
  
  protected void a()
  {
    setLayerType(1, null);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_c_of_type_Int = 0;
    this.d = getResources().getColor(2131166275);
    this.e = getResources().getColor(2131166279);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.d);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.e);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int n = this.f / 2;
    float f1 = this.g + n;
    float f2 = n;
    paramCanvas.drawLine(f1, f2, this.jdField_a_of_type_Int - f1, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    f1 = this.g + n;
    f2 = this.jdField_b_of_type_Int - n;
    paramCanvas.drawLine(f1, f2, this.jdField_a_of_type_Int - f1, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    f1 = n;
    f2 = this.g + n;
    paramCanvas.drawLine(f1, f2, f1, this.jdField_b_of_type_Int - f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    f1 = this.jdField_a_of_type_Int - n;
    f2 = this.g + n;
    paramCanvas.drawLine(f1, f2, f1, this.jdField_b_of_type_Int - f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    int i1 = this.g + this.g;
    RectF localRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    RectF localRectF2 = this.jdField_a_of_type_AndroidGraphicsRectF;
    f1 = n;
    localRectF2.top = f1;
    localRectF1.left = f1;
    localRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    localRectF2 = this.jdField_a_of_type_AndroidGraphicsRectF;
    f1 = n + i1;
    localRectF2.bottom = f1;
    localRectF1.right = f1;
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 180.0F, 90.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = n;
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - (n + i1));
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (n + i1);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int - n);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 90.0F, 90.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - (n + i1));
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - (n + i1));
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int - n);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int - n);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 90.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - (n + i1));
    this.jdField_a_of_type_AndroidGraphicsRectF.top = n;
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int - n);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (n + i1);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, 90.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void b(Canvas paramCanvas)
  {
    Paint localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.e);
      localPaint = this.jdField_c_of_type_AndroidGraphicsPaint;
    }
    int n = this.f / 2;
    this.h = (this.jdField_a_of_type_Int - (this.g + n) * 2);
    this.i = (this.h / 2);
    this.j = (this.jdField_b_of_type_Int - (this.g + n) * 2);
    this.k = ((int)(6.283185307179586D * this.g));
    this.m = (this.k + this.h * 2 + this.j * 2);
    this.l = (this.k / 4);
    int i2 = (int)(this.jdField_b_of_type_Float / 10000.0F * this.m);
    int i1 = this.g + this.g;
    if (i2 <= this.i)
    {
      paramCanvas.drawLine(this.jdField_a_of_type_Int / 2, n, this.jdField_a_of_type_Int / 2 + i2, n, localPaint);
      return;
    }
    paramCanvas.drawLine(this.jdField_a_of_type_Int / 2, n, this.jdField_a_of_type_Int - (this.g + n), n, localPaint);
    i2 -= this.i;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - (n + i1));
    this.jdField_a_of_type_AndroidGraphicsRectF.top = n;
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int - n);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (n + i1);
    if (i2 <= this.l)
    {
      f1 = i2 * 1.0F / this.l;
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, f1 * 90.0F, false, localPaint);
      return;
    }
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, 90.0F, false, localPaint);
    i2 -= this.l;
    if (i2 <= this.j)
    {
      paramCanvas.drawLine(this.jdField_a_of_type_Int - n, this.g + n, this.jdField_a_of_type_Int - n, this.g + n + i2, localPaint);
      return;
    }
    paramCanvas.drawLine(this.jdField_a_of_type_Int - n, this.g + n, this.jdField_a_of_type_Int - n, this.jdField_b_of_type_Int - (this.g + n), localPaint);
    i2 -= this.j;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - (n + i1));
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - (n + i1));
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int - n);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int - n);
    if (i2 <= this.l)
    {
      f1 = i2 * 1.0F / this.l;
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, f1 * 90.0F, false, localPaint);
      return;
    }
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 90.0F, false, localPaint);
    i2 -= this.l;
    if (i2 <= this.h)
    {
      f1 = this.jdField_a_of_type_Int - (this.g + n);
      paramCanvas.drawLine(f1, this.jdField_b_of_type_Int - n, f1 - i2, this.jdField_b_of_type_Int - n, localPaint);
      return;
    }
    paramCanvas.drawLine(this.jdField_a_of_type_Int - (this.g + n), this.jdField_b_of_type_Int - n, this.g + n, this.jdField_b_of_type_Int - n, localPaint);
    i2 -= this.h;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = n;
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - (n + i1));
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (n + i1);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int - n);
    if (i2 <= this.l)
    {
      f1 = i2 * 1.0F / this.l;
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 90.0F, f1 * 90.0F, false, localPaint);
      return;
    }
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 90.0F, 90.0F, false, localPaint);
    i2 -= this.l;
    if (i2 <= this.j)
    {
      f1 = this.jdField_b_of_type_Int - (this.g + n);
      paramCanvas.drawLine(n, f1, n, f1 - i2, localPaint);
      return;
    }
    paramCanvas.drawLine(n, this.jdField_b_of_type_Int - (this.g + n), n, this.g + n, localPaint);
    i2 -= this.j;
    RectF localRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    RectF localRectF2 = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f1 = n;
    localRectF2.top = f1;
    localRectF1.left = f1;
    localRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    localRectF2 = this.jdField_a_of_type_AndroidGraphicsRectF;
    f1 = n + i1;
    localRectF2.bottom = f1;
    localRectF1.right = f1;
    if (i2 <= this.l)
    {
      f1 = i2 * 1.0F / this.l;
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 180.0F, f1 * 90.0F, false, localPaint);
      return;
    }
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 180.0F, 90.0F, false, localPaint);
    f1 = i2 - this.l + (this.g + n);
    if (this.jdField_b_of_type_Float == 10000.0F) {
      f1 = this.jdField_a_of_type_Int / 2;
    }
    paramCanvas.drawLine(this.g + n, n, f1, n, localPaint);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_Int = getWidth();
    this.jdField_b_of_type_Int = getHeight();
    if (this.jdField_a_of_type_Int <= 0) {
      return;
    }
    a(paramCanvas);
    b(paramCanvas);
  }
  
  public void setCurrentProgress(float paramFloat)
  {
    float f1 = 10000.0F;
    if (paramFloat > 10000.0F) {}
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
  
  public void setDeleteColor(int paramInt)
  {
    this.e = paramInt;
    invalidate();
  }
  
  public void setStatus(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.f = ((int)(this.jdField_a_of_type_Float * paramFloat + 0.5D));
    this.f += this.f % 2;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.f);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.f);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightProgress
 * JD-Core Version:    0.7.0.1
 */