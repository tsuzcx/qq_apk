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
    this.jdField_a_of_type_AndroidGraphicsPaint$Style = Paint.Style.STROKE;
    a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.e = 2;
    this.f = 18;
    this.jdField_a_of_type_Int = getResources().getColor(2131167053);
    this.jdField_b_of_type_Int = getResources().getColor(2131167053);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if (i != j) {
      if (i < j) {
        j = i;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      paramCanvas.drawColor(0);
      this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.e / 2);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.e / 2);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (i - this.e / 2);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j - this.e / 2);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(this.jdField_a_of_type_AndroidGraphicsPaint$Style);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e * this.c);
      this.jdField_a_of_type_AndroidGraphicsRectF.left = this.e;
      this.jdField_a_of_type_AndroidGraphicsRectF.top = this.e;
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (i - this.e);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j - this.e);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F * (this.d / 100.0F), false, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_Boolean)
      {
        i /= 2;
        j /= 2;
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e);
        paramCanvas.drawRect(new RectF(i - this.f / 2, j - this.f / 2, i + this.f / 2, j + this.f / 2), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        String str = this.d + "%";
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(40.0F);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str);
        Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
        i = (int)((getWidth() - f1) / 2.0F);
        j = (getHeight() - (localFontMetricsInt.descent - localFontMetricsInt.ascent)) / 2;
        int k = -localFontMetricsInt.ascent;
        paramCanvas.drawText(str, i, k + j, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
      i = j;
      break;
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.d = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressCircle
 * JD-Core Version:    0.7.0.1
 */