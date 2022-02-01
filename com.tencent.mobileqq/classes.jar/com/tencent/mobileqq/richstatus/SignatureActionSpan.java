package com.tencent.mobileqq.richstatus;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.text.OffsetableImageSpan;

public class SignatureActionSpan
  extends OffsetableImageSpan
{
  public float a;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private float[] jdField_a_of_type_ArrayOfFloat;
  public float b;
  private int b;
  private int c;
  
  public SignatureActionSpan(Drawable paramDrawable1, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable2, float paramFloat)
  {
    super(paramDrawable1, paramInt1);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ArrayOfFloat = new float[this.jdField_a_of_type_JavaLangString.length()];
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable2;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramFloat);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt2);
  }
  
  public int a()
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    String str = this.jdField_a_of_type_JavaLangString;
    getSize(localPaint, str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt());
    return this.b;
  }
  
  public int b()
  {
    Rect localRect = getDrawable().getBounds();
    Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
    this.c = Math.max(localRect.bottom, -localFontMetricsInt.top + localFontMetricsInt.bottom);
    return this.c;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt().top + paramInt4;
    } else {
      i = paramInt4;
    }
    int j = this.b;
    if (j > 0)
    {
      int k = this.c;
      if (k > 0)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, i, j, k + i);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
    float f = getDrawable().getBounds().right;
    paramInt1 = paramInt4 - this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt().ascent;
    if (this.jdField_a_of_type_Boolean) {
      paramInt1 = paramInt4;
    }
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramFloat + f, paramInt1, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable().getBounds();
    this.jdField_a_of_type_AndroidGraphicsPaint.getTextWidths(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfFloat);
    paramInt2 = paramCharSequence.right;
    paramFontMetricsInt = this.jdField_a_of_type_ArrayOfFloat;
    int i = paramFontMetricsInt.length;
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      float f = paramFontMetricsInt[paramInt1];
      paramInt2 = (int)(paramInt2 + f);
      paramInt1 += 1;
    }
    this.b = paramInt2;
    paramPaint = paramPaint.getFontMetricsInt();
    this.c = Math.max(paramCharSequence.bottom, -paramPaint.top + paramPaint.bottom);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureActionSpan
 * JD-Core Version:    0.7.0.1
 */