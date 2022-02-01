package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ProgressCircle
  extends View
{
  public int a;
  public Paint.Style a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  public boolean a;
  public int b;
  public boolean b;
  public int c = 2;
  private int d;
  private int e;
  private int f;
  
  public ProgressCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint$Style = Paint.Style.STROKE;
    a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.e = 2;
    this.f = 18;
    this.jdField_a_of_type_Int = getResources().getColor(2131167097);
    this.jdField_b_of_type_Int = getResources().getColor(2131167097);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = getWidth();
    int m = getHeight();
    int i = k;
    int j = m;
    if (k != m)
    {
      if (k < m) {
        i = k;
      } else {
        i = m;
      }
      j = i;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.drawColor(0);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    k = this.e;
    ((RectF)localObject).left = (k / 2);
    ((RectF)localObject).top = (k / 2);
    ((RectF)localObject).right = (i - k / 2);
    ((RectF)localObject).bottom = (j - k / 2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(k);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(this.jdField_a_of_type_AndroidGraphicsPaint$Style);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e * this.c);
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    k = this.e;
    ((RectF)localObject).left = k;
    ((RectF)localObject).top = k;
    ((RectF)localObject).right = (i - k);
    ((RectF)localObject).bottom = (j - k);
    paramCanvas.drawArc((RectF)localObject, -90.0F, this.d / 100.0F * 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_Boolean)
    {
      i /= 2;
      j /= 2;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e);
      k = this.f;
      paramCanvas.drawRect(new RectF(i - k / 2, j - k / 2, i + k / 2, j + k / 2), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(40.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText((String)localObject);
      Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
      i = (int)((getWidth() - f1) / 2.0F);
      j = (getHeight() - (localFontMetricsInt.descent - localFontMetricsInt.ascent)) / 2;
      k = -localFontMetricsInt.ascent;
      paramCanvas.drawText((String)localObject, i, j + k, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.d = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressCircle
 * JD-Core Version:    0.7.0.1
 */