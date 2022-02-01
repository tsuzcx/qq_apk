package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

public class RadiusBackgroundSpan
  extends ReplacementSpan
{
  private int a;
  private int b;
  private int c;
  private int d;
  private TextView e;
  
  public RadiusBackgroundSpan(int paramInt1, int paramInt2, int paramInt3, TextView paramTextView)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramTextView;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    Object localObject = paramCharSequence.subSequence(paramInt1, paramInt2).toString();
    paramInt1 = this.e.getWidth();
    paramCharSequence = (CharSequence)localObject;
    if (this.a > paramInt1)
    {
      this.a = paramInt1;
      paramInt2 = ViewUtils.dip2px(6.0F);
      int i = ViewUtils.dip2px(3.333333F);
      paramCharSequence = TextUtils.ellipsize((CharSequence)localObject, new TextPaint(paramPaint), paramInt1 - paramInt2 * 2 - i * 2, TextUtils.TruncateAt.END).toString();
    }
    paramInt1 = paramPaint.getColor();
    paramPaint.setColor(this.b);
    paramPaint.setAntiAlias(true);
    localObject = new RectF(ViewUtils.dip2px(3.333333F) + paramFloat, paramInt3, this.a + paramFloat - ViewUtils.dip2px(3.333333F), paramInt5);
    paramInt2 = this.d;
    paramCanvas.drawRoundRect((RectF)localObject, paramInt2, paramInt2, paramPaint);
    paramPaint.setColor(this.c);
    paramCanvas.drawText(paramCharSequence, paramFloat + ViewUtils.dip2px(6.0F) + ViewUtils.dip2px(3.333333F), paramInt4, paramPaint);
    paramPaint.setColor(paramInt1);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    this.a = ((int)(paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + ViewUtils.dip2px(6.0F) * 2 + ViewUtils.dip2px(3.333333F) * 2));
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.RadiusBackgroundSpan
 * JD-Core Version:    0.7.0.1
 */