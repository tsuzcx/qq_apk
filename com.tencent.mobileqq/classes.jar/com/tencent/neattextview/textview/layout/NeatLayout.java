package com.tencent.neattextview.textview.layout;

import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.luggage.wxa.rv.a;

public class NeatLayout
  extends c
{
  private int l = 0;
  
  static
  {
    System.loadLibrary("linebreak");
  }
  
  public NeatLayout(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    super(paramCharSequence, paramArrayOfFloat);
  }
  
  private native int nComputeBreak(String paramString, float[] paramArrayOfFloat1, float paramFloat1, float paramFloat2, int[] paramArrayOfInt, float[] paramArrayOfFloat2, float paramFloat3, boolean[] paramArrayOfBoolean1, char[] paramArrayOfChar1, float[] paramArrayOfFloat3, char[] paramArrayOfChar2, float[] paramArrayOfFloat4, boolean[] paramArrayOfBoolean2);
  
  public void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, TextUtils.TruncateAt paramTruncateAt, boolean paramBoolean)
  {
    float f4 = paramTextPaint.getTextSize() / 2.0F;
    if (paramBoolean) {
      paramFloat2 = paramTextPaint.getTextSize() / 6.0F;
    } else {
      paramFloat2 = 0.0F;
    }
    int i = this.c.length();
    paramTextPaint = new int[i];
    paramTruncateAt = new float[i];
    boolean[] arrayOfBoolean = new boolean[i];
    int i3 = nComputeBreak(this.c, this.f, 0.0F, paramFloat1 + f4, paramTextPaint, paramTruncateAt, paramFloat2, arrayOfBoolean, a.b, this.i, a.a, this.h, this.k);
    this.l = i3;
    i = 0;
    float f2;
    float f1;
    for (paramFloat3 = 0.0F; (i < i3) && (i < paramInt); paramFloat3 = f1)
    {
      f2 = paramTruncateAt[i];
      f1 = paramFloat3;
      if (paramFloat3 < f2) {
        f1 = f2;
      }
      i += 1;
    }
    float f3 = Math.min(paramFloat3, paramFloat1);
    i = 0;
    int k = 0;
    while ((k < i3) && (k < paramInt))
    {
      int i2 = paramTextPaint[k];
      paramBoolean = arrayOfBoolean[k];
      int n = i2 - i;
      paramFloat3 = paramFloat1 - paramTruncateAt[k];
      int m;
      if (Math.abs(paramFloat3) <= f4) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0)
      {
        int i1 = i2 - 1;
        j = n;
        if (i1 >= 0)
        {
          j = n;
          if (this.d[i1] == '\n') {
            j = n - 1;
          }
        }
        n = j;
        j = i;
        while (j < i2)
        {
          i1 = n;
          if (this.d[j] != '\n')
          {
            i1 = n;
            if (this.f[j] == 0.0F) {
              i1 = n - 1;
            }
          }
          j += 1;
          n = i1;
        }
        paramFloat3 /= (Math.max(2, n) - 1);
      }
      else
      {
        paramFloat3 = 0.0F;
      }
      if (m != 0) {
        f1 = paramFloat1;
      } else {
        f1 = paramTruncateAt[k];
      }
      char[] arrayOfChar = this.d;
      float[] arrayOfFloat = this.f;
      int j = g();
      if (m != 0) {
        f2 = paramFloat1;
      } else {
        f2 = f3;
      }
      a(arrayOfChar, i, i2, f1, arrayOfFloat, j, paramFloat3, paramBoolean, paramFloat2, f2);
      k += 1;
      i = i2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.NeatLayout
 * JD-Core Version:    0.7.0.1
 */