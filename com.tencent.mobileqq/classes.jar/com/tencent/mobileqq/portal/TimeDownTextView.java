package com.tencent.mobileqq.portal;

import agej;
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

public class TimeDownTextView
  extends View
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  protected TextPaint a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private CharSequence jdField_b_of_type_JavaLangCharSequence = "";
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public TimeDownTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TimeDownTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/DS-DIGIB.TTF");
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramContext);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#FCD383"));
    setTextSize(1, 18.0F);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#FFFFFF"));
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(agej.a(16.0F, getResources()));
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.k = agej.a(5.0F, getResources());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramCanvas.drawText(this.jdField_b_of_type_JavaLangCharSequence, 0, this.jdField_b_of_type_JavaLangCharSequence.length(), this.g, this.h, this.jdField_b_of_type_AndroidTextTextPaint);
    }
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangCharSequence, 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.e, this.f, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.e = (this.jdField_a_of_type_Int / 2 - this.c / 2);
      this.f = (this.jdField_b_of_type_Int / 2 + this.d / 2);
      return;
    }
    this.g = (this.jdField_a_of_type_Int / 2 - (this.i + this.k + this.c) / 2);
    this.h = (this.jdField_b_of_type_Int / 2 + (this.j + this.d) / 2);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() != this.jdField_a_of_type_JavaLangCharSequence.length())
    {
      this.jdField_a_of_type_AndroidTextTextPaint.getTextBounds(paramCharSequence.toString(), 0, paramCharSequence.length(), this.jdField_a_of_type_AndroidGraphicsRect);
      this.c = this.jdField_a_of_type_AndroidGraphicsRect.width();
      this.d = this.jdField_a_of_type_AndroidGraphicsRect.height();
      this.e = (this.jdField_a_of_type_Int / 2 - this.c / 2);
      this.f = (this.jdField_b_of_type_Int / 2 + this.d / 2);
      Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
      this.f = ((this.jdField_b_of_type_Int - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
    }
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_Boolean = false;
    invalidate();
  }
  
  public void setText2(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence2.length() != this.jdField_b_of_type_JavaLangCharSequence.length()) || (paramCharSequence1.length() != this.jdField_a_of_type_JavaLangCharSequence.length()))
    {
      this.jdField_b_of_type_AndroidTextTextPaint.getTextBounds(paramCharSequence2.toString(), 0, paramCharSequence2.length(), this.jdField_b_of_type_AndroidGraphicsRect);
      this.i = this.jdField_b_of_type_AndroidGraphicsRect.width();
      this.j = this.jdField_b_of_type_AndroidGraphicsRect.height();
      this.jdField_a_of_type_AndroidTextTextPaint.getTextBounds(paramCharSequence1.toString(), 0, paramCharSequence1.length(), this.jdField_a_of_type_AndroidGraphicsRect);
      this.c = this.jdField_a_of_type_AndroidGraphicsRect.width();
      this.d = this.jdField_a_of_type_AndroidGraphicsRect.height();
      this.g = (this.jdField_a_of_type_Int / 2 - (this.i + this.c) / 2);
      Paint.FontMetricsInt localFontMetricsInt = this.jdField_b_of_type_AndroidTextTextPaint.getFontMetricsInt();
      this.h = ((this.jdField_b_of_type_Int - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
      this.e = (this.g + this.i + this.k);
      localFontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
      this.f = ((this.jdField_b_of_type_Int - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence1;
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence2;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(TypedValue.applyDimension(paramInt, paramFloat, getResources().getDisplayMetrics()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.TimeDownTextView
 * JD-Core Version:    0.7.0.1
 */