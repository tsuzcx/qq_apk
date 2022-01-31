package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.TypedValue;

public class BgTextSpan
  extends ReplacementSpan
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c;
  private float d;
  
  public BgTextSpan(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = TypedValue.applyDimension(1, paramInt2, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
    this.c = TypedValue.applyDimension(1, paramInt4, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
    this.d = TypedValue.applyDimension(1, paramInt5, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
    this.jdField_b_of_type_Int = paramInt6;
    this.jdField_b_of_type_Float = a(paramString, paramInt3);
  }
  
  private float a(String paramString, int paramInt)
  {
    if (paramString.length() > 1)
    {
      Rect localRect = new Rect();
      Paint localPaint = new Paint();
      localPaint.setTextSize(this.d);
      localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
      float f = TypedValue.applyDimension(1, paramInt, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
      return localRect.width() + f * 2.0F;
    }
    return this.jdField_a_of_type_Float;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = new Paint();
    paramCharSequence.setColor(this.jdField_a_of_type_Int);
    paramCharSequence.setStyle(Paint.Style.FILL);
    paramCharSequence.setAntiAlias(true);
    paramPaint = paramPaint.getFontMetrics();
    float f2 = paramPaint.descent;
    float f3 = paramPaint.ascent;
    float f1 = paramInt4;
    f2 = (f2 - f3 - this.jdField_a_of_type_Float) / 2.0F;
    f1 = paramPaint.ascent + (f2 + f1);
    paramCanvas.drawRoundRect(new RectF(paramFloat, f1, this.jdField_b_of_type_Float + paramFloat, this.jdField_a_of_type_Float + f1), 0.0F, 0.0F, paramCharSequence);
    paramCharSequence = new TextPaint();
    paramCharSequence.setColor(this.jdField_b_of_type_Int);
    paramCharSequence.setTextSize(this.d);
    paramCharSequence.setAntiAlias(true);
    paramCharSequence.setTextAlign(Paint.Align.CENTER);
    paramPaint = paramCharSequence.getFontMetrics();
    f2 = paramPaint.bottom;
    f3 = paramPaint.top;
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Float / 2.0F + paramFloat, f1 + (this.jdField_a_of_type_Float - (f2 - f3)) / 2.0F - paramPaint.top, paramCharSequence);
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return (int)(this.jdField_b_of_type_Float + this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.BgTextSpan
 * JD-Core Version:    0.7.0.1
 */