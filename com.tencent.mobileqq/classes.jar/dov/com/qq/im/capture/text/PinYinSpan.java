package dov.com.qq.im.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.tencent.mobileqq.utils.ChnToSpell;

public class PinYinSpan
  extends ReplacementSpan
  implements Cloneable
{
  private float jdField_a_of_type_Float = 24.0F;
  private int jdField_a_of_type_Int;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private PinYinSpan.OnHanZiToPinYinListener jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnHanZiToPinYinListener;
  private PinYinSpan.OnPinYinDrawListener jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnPinYinDrawListener;
  private PinYinSpan.OnTextDrawListener jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnTextDrawListener;
  private float jdField_b_of_type_Float = 104.0F;
  private int jdField_b_of_type_Int = 16;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  private int c = -1;
  private int d = -1;
  
  private static String a(String paramString, @Nullable PinYinSpan.OnHanZiToPinYinListener paramOnHanZiToPinYinListener)
  {
    String str = paramString;
    if (paramOnHanZiToPinYinListener != null) {
      str = paramOnHanZiToPinYinListener.a(paramString);
    }
    return ChnToSpell.a(str, 1);
  }
  
  private void a(@NonNull Paint paramPaint, @NonNull PinYinSpan.PaintType paramPaintType)
  {
    paramPaint.reset();
    paramPaint.setAntiAlias(true);
    switch (anwu.a[paramPaintType.ordinal()])
    {
    }
    do
    {
      do
      {
        return;
        paramPaint.setTextSize(this.jdField_a_of_type_Float);
        paramPaint.setColor(this.c);
      } while (this.jdField_a_of_type_AndroidGraphicsTypeface == null);
      paramPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      return;
      paramPaint.setTextSize(this.jdField_b_of_type_Float);
      paramPaint.setColor(this.d);
    } while (this.jdField_b_of_type_AndroidGraphicsTypeface == null);
    paramPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@Nullable Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(@Nullable PinYinSpan.OnHanZiToPinYinListener paramOnHanZiToPinYinListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnHanZiToPinYinListener = paramOnHanZiToPinYinListener;
  }
  
  public void a(@Nullable PinYinSpan.OnPinYinDrawListener paramOnPinYinDrawListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnPinYinDrawListener = paramOnPinYinDrawListener;
  }
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void b(@Nullable Typeface paramTypeface)
  {
    this.jdField_b_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return new PinYinSpan();
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCharSequence = paramCharSequence.toString().substring(paramInt1, paramInt2);
    if (this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnTextDrawListener != null) {
      paramCharSequence = this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnTextDrawListener.a(paramCharSequence);
    }
    for (;;)
    {
      Object localObject2 = a(paramCharSequence, this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnHanZiToPinYinListener);
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnPinYinDrawListener != null) {
        localObject1 = this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnPinYinDrawListener.a(paramCharSequence, (String)localObject2);
      }
      paramPaint.setTextSize(this.jdField_a_of_type_Float);
      localObject2 = paramPaint.getFontMetrics();
      float f1 = paramPaint.measureText((String)localObject1, 0, ((String)localObject1).length());
      paramPaint.setTextSize(this.jdField_b_of_type_Float);
      Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
      float f2 = paramPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
      a(paramPaint, PinYinSpan.PaintType.PIN_YIN);
      paramCanvas.drawText((String)localObject1, 0, ((String)localObject1).length(), (f2 - f1) / 2.0F + paramFloat, paramInt4 - Math.abs(localFontMetrics.ascent) - this.jdField_a_of_type_Int - Math.abs(((Paint.FontMetrics)localObject2).descent), paramPaint);
      a(paramPaint, PinYinSpan.PaintType.HAN_ZI);
      paramCanvas.drawText(paramCharSequence, 0, paramCharSequence.length(), paramFloat, paramInt4, paramPaint);
      return;
    }
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    Object localObject = paramCharSequence.toString().substring(paramInt1, paramInt2);
    paramCharSequence = (CharSequence)localObject;
    if (this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnTextDrawListener != null) {
      paramCharSequence = this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnTextDrawListener.a((String)localObject);
    }
    if (paramFontMetricsInt != null)
    {
      a(paramPaint, PinYinSpan.PaintType.HAN_ZI);
      localObject = paramPaint.getFontMetrics();
      a(paramPaint, PinYinSpan.PaintType.PIN_YIN);
      Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
      paramInt1 = (int)(localFontMetrics.bottom - localFontMetrics.top);
      paramFontMetricsInt.ascent = ((int)((Paint.FontMetrics)localObject).ascent - (this.jdField_a_of_type_Int + paramInt1 + this.jdField_b_of_type_Int));
      paramFontMetricsInt.top = ((int)((Paint.FontMetrics)localObject).top - (paramInt1 + this.jdField_a_of_type_Int + this.jdField_b_of_type_Int));
    }
    a(paramPaint, PinYinSpan.PaintType.HAN_ZI);
    return Math.round(paramPaint.measureText(paramCharSequence, 0, paramCharSequence.length()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.PinYinSpan
 * JD-Core Version:    0.7.0.1
 */