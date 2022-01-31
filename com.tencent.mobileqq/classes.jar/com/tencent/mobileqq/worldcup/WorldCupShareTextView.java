package com.tencent.mobileqq.worldcup;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class WorldCupShareTextView
  extends TextView
{
  private static float jdField_a_of_type_Float = 1.0F;
  private static float b = 200.0F;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private float c;
  private float d;
  
  public WorldCupShareTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public static int a(float paramFloat)
  {
    return (int)((16777216.0F * paramFloat) + 8388608L >> 24);
  }
  
  private void a()
  {
    this.d = getTextSize();
    if (this.d <= jdField_a_of_type_Float) {
      this.d = b;
    }
    this.c = jdField_a_of_type_Float;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    int m;
    int n;
    int i1;
    float f3;
    float f2;
    float f1;
    int i;
    int j;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      m = paramInt1 - getPaddingLeft() - getPaddingRight();
      n = getPaddingBottom();
      i1 = getPaddingTop();
      f3 = 1.0F;
      f2 = 0.0F;
      if (Build.VERSION.SDK_INT > 16)
      {
        f3 = getLineSpacingMultiplier();
        f2 = getLineSpacingExtra();
      }
      f1 = this.d;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f1);
      i = 1;
      paramInt1 = 1;
      j = m;
    }
    for (;;)
    {
      int k = paramInt1;
      float f4 = f1;
      int i2;
      if (f1 > this.c)
      {
        k = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString);
        i2 = a(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null) * f3 + f2);
        if (k >= j) {
          break label170;
        }
        f4 = f1;
      }
      for (k = paramInt1;; k = paramInt1)
      {
        if (k >= 2)
        {
          setSingleLine(false);
          setMaxLines(k);
        }
        setTextSize(0, f4);
        return;
        label170:
        paramInt1 = (paramInt2 - n - i1) / i2;
        if (paramInt1 > i)
        {
          j = m * paramInt1;
          i = paramInt1;
          break;
        }
        f1 -= 1.0F;
        if (f1 > this.c) {
          break label227;
        }
        f4 = this.c;
      }
      label227:
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.e("WorldCupShareTextView", "onSizeChanged new(" + paramInt1 + "," + paramInt2 + ") old(" + paramInt3 + "" + paramInt4 + ")");
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      a(getText().toString(), paramInt1, paramInt2);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    a(paramCharSequence.toString(), getWidth(), getHeight());
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    super.setTypeface(paramTypeface);
    if (this.jdField_a_of_type_AndroidTextTextPaint == null) {
      this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    }
    this.jdField_a_of_type_AndroidTextTextPaint.set(getPaint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.WorldCupShareTextView
 * JD-Core Version:    0.7.0.1
 */