package com.tencent.mobileqq.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.earlydownload.handler.ApngHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class QQText$EmoticonSpan
  extends ReplacementSpan
{
  public float a;
  public int a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  protected boolean a;
  public float b;
  int b;
  public float c;
  public int c;
  public float d;
  
  public QQText$EmoticonSpan(QQText paramQQText, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
  }
  
  public int a()
  {
    return 0x7FFFFFFF & this.jdField_a_of_type_Int;
  }
  
  public Drawable a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 != null) {}
    for (localObject1 = (Drawable)((WeakReference)localObject1).get();; localObject1 = null)
    {
      Object localObject2;
      if ((localObject1 instanceof URLDrawable))
      {
        localObject2 = (URLDrawable)localObject1;
        if ((this.jdField_a_of_type_Boolean) && (ApngHandler.b.get()) && (!((URLDrawable)localObject2).mUseApngImage))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQText", 2, "getDrawable: change to apng");
          }
          localObject1 = null;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = b();
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject2);
        }
        return localObject2;
      }
    }
  }
  
  public String a()
  {
    return "";
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected Drawable b()
  {
    Drawable localDrawable2;
    Drawable localDrawable1;
    if (this.jdField_c_of_type_Int == 3)
    {
      localDrawable2 = TextUtils.b(this.jdField_a_of_type_Int, false);
      localDrawable1 = localDrawable2;
      if (localDrawable2 != null)
      {
        localDrawable2.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
        localDrawable1 = localDrawable2;
      }
    }
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return localDrawable1;
            if (this.jdField_c_of_type_Int != 0) {
              break;
            }
            localDrawable2 = TextUtils.a(this.jdField_a_of_type_Int);
            localDrawable1 = localDrawable2;
          } while (localDrawable2 == null);
          localDrawable2.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
          return localDrawable2;
          if ((0x80000000 & this.jdField_a_of_type_Int) != 0) {
            break;
          }
          localDrawable2 = TextUtils.a(this.jdField_a_of_type_Int, false);
          localDrawable1 = localDrawable2;
        } while (localDrawable2 == null);
        localDrawable2.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
        return localDrawable2;
        i = 0x7FFFFFFF & this.jdField_a_of_type_Int;
        if (EmotcationConstants.b[i] != EmotcationConstants.a[i]) {
          break;
        }
        localDrawable2 = TextUtils.a(i, false);
        localDrawable1 = localDrawable2;
      } while (localDrawable2 == null);
      localDrawable2.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
      return localDrawable2;
      localDrawable2 = TextUtils.a(i, true);
      localDrawable1 = localDrawable2;
    } while (localDrawable2 == null);
    localDrawable2.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    return localDrawable2;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = a();
    paramCanvas.save();
    float f2 = paramInt4 - this.jdField_b_of_type_Int;
    float f1 = f2;
    if (paramInt5 > paramInt4)
    {
      f1 = f2;
      if (paramPaint != null) {
        f1 = f2 + paramPaint.getFontMetrics().descent;
      }
    }
    paramCanvas.translate(paramFloat, f1);
    if (paramCharSequence != null)
    {
      paramCharSequence.draw(paramCanvas);
      paramCharSequence.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_b_of_type_Float = paramInt3;
      this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float + this.jdField_b_of_type_Int);
      this.d = paramInt5;
    }
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.jdField_b_of_type_Int);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.EmoticonSpan
 * JD-Core Version:    0.7.0.1
 */