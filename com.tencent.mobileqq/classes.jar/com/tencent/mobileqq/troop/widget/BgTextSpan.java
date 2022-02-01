package com.tencent.mobileqq.troop.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

public class BgTextSpan
  extends ReplacementSpan
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c;
  private float d;
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = new Paint();
    paramCharSequence.setColor(this.jdField_a_of_type_Int);
    paramCharSequence.setStyle(Paint.Style.FILL);
    paramCharSequence.setAntiAlias(true);
    paramPaint = paramPaint.getFontMetrics();
    float f1 = paramPaint.descent;
    float f2 = paramPaint.ascent;
    f1 = paramInt4 + (f1 - f2 - this.jdField_a_of_type_Float) / 2.0F + paramPaint.ascent;
    paramCanvas.drawRoundRect(new RectF(paramFloat, f1, this.jdField_b_of_type_Float + paramFloat, this.jdField_a_of_type_Float + f1), 0.0F, 0.0F, paramCharSequence);
    paramCharSequence = new TextPaint();
    paramCharSequence.setColor(this.jdField_b_of_type_Int);
    paramCharSequence.setTextSize(this.d);
    paramCharSequence.setAntiAlias(true);
    paramCharSequence.setTextAlign(Paint.Align.CENTER);
    paramPaint = paramCharSequence.getFontMetrics();
    f2 = paramPaint.bottom;
    float f3 = paramPaint.top;
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramFloat + this.jdField_b_of_type_Float / 2.0F, f1 + (this.jdField_a_of_type_Float - (f2 - f3)) / 2.0F - paramPaint.top, paramCharSequence);
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return (int)(this.jdField_b_of_type_Float + this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.BgTextSpan
 * JD-Core Version:    0.7.0.1
 */