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
  public float b;
  public boolean c = true;
  private String d;
  private int e;
  private float[] f;
  private Drawable g;
  private int h;
  private int i;
  private Paint j;
  
  public SignatureActionSpan(Drawable paramDrawable1, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable2, float paramFloat)
  {
    super(paramDrawable1, paramInt1);
    this.d = paramString;
    this.e = paramInt2;
    this.f = new float[this.d.length()];
    this.g = paramDrawable2;
    this.j = new Paint(1);
    this.j.setTextSize(paramFloat);
    this.j.setColor(paramInt2);
  }
  
  public int a()
  {
    Paint localPaint = this.j;
    String str = this.d;
    getSize(localPaint, str, 0, str.length(), this.j.getFontMetricsInt());
    return this.h;
  }
  
  public int b()
  {
    Rect localRect = getDrawable().getBounds();
    Paint.FontMetricsInt localFontMetricsInt = this.j.getFontMetricsInt();
    this.i = Math.max(localRect.bottom, -localFontMetricsInt.top + localFontMetricsInt.bottom);
    return this.i;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    int k;
    if (this.c) {
      k = this.j.getFontMetricsInt().top + paramInt4;
    } else {
      k = paramInt4;
    }
    int m = this.h;
    if (m > 0)
    {
      int n = this.i;
      if (n > 0)
      {
        this.g.setBounds(0, k, m, n + k);
        this.g.draw(paramCanvas);
      }
    }
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
    float f1 = getDrawable().getBounds().right;
    paramInt1 = paramInt4 - this.j.getFontMetricsInt().ascent;
    if (this.c) {
      paramInt1 = paramInt4;
    }
    paramCanvas.drawText(this.d, paramFloat + f1, paramInt1, this.j);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable().getBounds();
    this.j.getTextWidths(this.d, this.f);
    paramInt2 = paramCharSequence.right;
    paramFontMetricsInt = this.f;
    int k = paramFontMetricsInt.length;
    paramInt1 = 0;
    while (paramInt1 < k)
    {
      float f1 = paramFontMetricsInt[paramInt1];
      paramInt2 = (int)(paramInt2 + f1);
      paramInt1 += 1;
    }
    this.h = paramInt2;
    paramPaint = paramPaint.getFontMetricsInt();
    this.i = Math.max(paramCharSequence.bottom, -paramPaint.top + paramPaint.bottom);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureActionSpan
 * JD-Core Version:    0.7.0.1
 */