package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class TimeDownTextView
  extends View
{
  protected TextPaint a = new TextPaint(1);
  boolean b = false;
  private CharSequence c = "";
  private Rect d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private Rect o;
  private CharSequence p = "";
  private TextPaint q;
  private int r;
  
  public TimeDownTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TimeDownTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/DS-DIGIB.TTF");
    this.a.setTypeface(paramContext);
    this.a.setColor(Color.parseColor("#FCD383"));
    setTextSize(1, 18.0F);
    this.d = new Rect();
    this.q = new TextPaint(1);
    this.q.setColor(Color.parseColor("#FFFFFF"));
    this.q.setTextSize(AIOUtils.b(16.0F, getResources()));
    this.o = new Rect();
    this.r = AIOUtils.b(5.0F, getResources());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.b)
    {
      localCharSequence = this.p;
      paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), this.k, this.l, this.q);
    }
    CharSequence localCharSequence = this.c;
    paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), this.i, this.j, this.a);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    if (!this.b)
    {
      this.i = (this.e / 2 - this.g / 2);
      this.j = (this.f / 2 + this.h / 2);
      return;
    }
    this.k = (this.e / 2 - (this.m + this.r + this.g) / 2);
    this.l = (this.f / 2 + (this.n + this.h) / 2);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() != this.c.length())
    {
      this.a.getTextBounds(paramCharSequence.toString(), 0, paramCharSequence.length(), this.d);
      this.g = this.d.width();
      this.h = this.d.height();
      this.i = (this.e / 2 - this.g / 2);
      this.j = (this.f / 2 + this.h / 2);
      Paint.FontMetricsInt localFontMetricsInt = this.a.getFontMetricsInt();
      this.j = ((this.f - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
    }
    this.c = paramCharSequence;
    this.b = false;
    invalidate();
  }
  
  public void setText2(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence2.length() != this.p.length()) || (paramCharSequence1.length() != this.c.length()))
    {
      this.q.getTextBounds(paramCharSequence2.toString(), 0, paramCharSequence2.length(), this.o);
      this.m = this.o.width();
      this.n = this.o.height();
      this.a.getTextBounds(paramCharSequence1.toString(), 0, paramCharSequence1.length(), this.d);
      this.g = this.d.width();
      this.h = this.d.height();
      this.k = (this.e / 2 - (this.m + this.g) / 2);
      Paint.FontMetricsInt localFontMetricsInt = this.q.getFontMetricsInt();
      this.l = ((this.f - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
      this.i = (this.k + this.m + this.r);
      localFontMetricsInt = this.a.getFontMetricsInt();
      this.j = ((this.f - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
    }
    this.b = true;
    this.c = paramCharSequence1;
    this.p = paramCharSequence2;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.a.setColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.a.setTextSize(TypedValue.applyDimension(paramInt, paramFloat, getResources().getDisplayMetrics()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.TimeDownTextView
 * JD-Core Version:    0.7.0.1
 */