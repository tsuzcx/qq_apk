package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;

class TickerColumn
{
  private final TickerCharacterList[] a;
  private final TickerDrawMetrics b;
  private char c = '\000';
  private char d = '\000';
  private char[] e;
  private int f;
  private int g;
  private int h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private int q;
  
  TickerColumn(TickerCharacterList[] paramArrayOfTickerCharacterList, TickerDrawMetrics paramTickerDrawMetrics)
  {
    this.a = paramArrayOfTickerCharacterList;
    this.b = paramTickerDrawMetrics;
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    this.e = null;
    char c2 = this.d;
    char c1 = c2;
    if (paramBoolean1)
    {
      c1 = c2;
      if (c2 == 0) {
        c1 = '0';
      }
    }
    Object localObject2 = null;
    int i1 = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = this.a;
      if (i1 >= localObject1.length) {
        break;
      }
      TickerCharacterList.CharacterIndices localCharacterIndices = localObject1[i1].a(this.c, c1, this.b.d());
      localObject1 = localObject2;
      if (localCharacterIndices != null) {
        if (paramBoolean2)
        {
          this.e = paramArrayOfChar;
          this.f = paramInt2;
          this.g = paramInt3;
          localObject1 = localObject2;
        }
        else
        {
          this.e = this.a[i1].b();
          this.f = localCharacterIndices.a;
          this.g = localCharacterIndices.b;
          localObject1 = this.a[i1].c();
        }
      }
      i1 += 1;
      localObject2 = localObject1;
    }
    if ((this.e != null) && (paramInt1 > 1) && (!TextUtils.isEmpty(localObject2)))
    {
      paramInt2 = Math.min(paramInt1 - 1, 5);
      paramArrayOfChar = new String(this.e);
      if (this.b.d() == 1)
      {
        paramInt1 = 0;
        for (;;)
        {
          localObject1 = paramArrayOfChar;
          if (paramInt1 >= paramInt2) {
            break;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramArrayOfChar);
          ((StringBuilder)localObject1).append(localObject2);
          paramArrayOfChar = ((StringBuilder)localObject1).toString();
          this.f += localObject2.length();
          paramInt1 += 1;
        }
      }
      if (this.b.d() == 2)
      {
        paramInt1 = 0;
        for (;;)
        {
          localObject1 = paramArrayOfChar;
          if (paramInt1 >= paramInt2) {
            break;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramArrayOfChar);
          ((StringBuilder)localObject1).append(localObject2);
          paramArrayOfChar = ((StringBuilder)localObject1).toString();
          this.g += localObject2.length();
          paramInt1 += 1;
        }
      }
      localObject1 = paramArrayOfChar;
      this.e = ((String)localObject1).toCharArray();
    }
    if (this.e == null)
    {
      c1 = this.c;
      c2 = this.d;
      if (c1 == c2)
      {
        this.e = new char[] { c1 };
        this.g = 0;
        this.f = 0;
        return;
      }
      this.e = new char[] { c1, c2 };
      this.f = 0;
      this.g = 1;
    }
  }
  
  private boolean a(Canvas paramCanvas, Paint paramPaint, char[] paramArrayOfChar, int paramInt, float paramFloat)
  {
    if ((paramInt >= 0) && (paramInt < paramArrayOfChar.length))
    {
      paramCanvas.drawText(paramArrayOfChar, paramInt, 1, 0.0F, paramFloat, paramPaint);
      return true;
    }
    return false;
  }
  
  private void f()
  {
    float f1 = this.b.a(this.d);
    float f2 = this.l;
    float f3 = this.m;
    if ((f2 == f3) && (f3 != f1))
    {
      this.m = f1;
      this.l = f1;
      this.n = f1;
    }
  }
  
  char a()
  {
    return this.c;
  }
  
  void a(float paramFloat, boolean paramBoolean)
  {
    if (paramFloat == 1.0F)
    {
      this.c = this.d;
      this.o = 0.0F;
      this.p = 0.0F;
    }
    float f1 = this.b.b();
    float f2 = Math.abs(this.g - this.f) * f1 * paramFloat / f1;
    int i1 = (int)f2;
    float f3 = i1;
    float f4 = this.p;
    int i2 = this.q;
    this.i = ((f2 - f3) * f1 * i2 + f4 * (1.0F - paramFloat));
    this.h = (this.f + i1 * i2);
    this.j = f1;
    if (paramBoolean)
    {
      this.l = Math.max(this.m, this.k);
      if (paramFloat > 0.999F)
      {
        this.l = this.m;
        if (this.d == 0) {
          this.h = 0;
        }
      }
    }
    else
    {
      f1 = this.k;
      this.l = (f1 + (this.m - f1) * paramFloat);
    }
  }
  
  void a(int paramInt, char paramChar, boolean paramBoolean)
  {
    this.d = paramChar;
    this.k = this.l;
    this.m = this.b.a(paramChar);
    this.n = Math.max(this.k, this.m);
    a(paramInt, paramBoolean, false, null, 0, 0);
    paramInt = this.g;
    int i2 = this.f;
    int i1 = 1;
    if (paramInt >= i2) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      paramInt = i1;
    } else {
      paramInt = -1;
    }
    this.q = paramInt;
    this.p = this.o;
    this.o = 0.0F;
  }
  
  void a(int paramInt1, char paramChar, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    this.d = paramChar;
    this.k = this.l;
    this.m = this.b.a(paramChar);
    this.n = Math.max(this.k, this.m);
    a(paramInt1, paramBoolean1, paramBoolean2, paramArrayOfChar, paramInt2, paramInt3);
    paramInt1 = this.g;
    paramInt3 = this.f;
    paramInt2 = 1;
    if (paramInt1 >= paramInt3) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      paramInt1 = paramInt2;
    } else {
      paramInt1 = -1;
    }
    this.q = paramInt1;
    this.p = this.o;
    this.o = 0.0F;
  }
  
  void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (a(paramCanvas, paramPaint, this.e, this.h, this.i))
    {
      int i1 = this.h;
      if (i1 >= 0) {
        this.c = this.e[i1];
      }
      this.o = this.i;
    }
    a(paramCanvas, paramPaint, this.e, this.h + 1, this.i - this.j);
    a(paramCanvas, paramPaint, this.e, this.h - 1, this.i + this.j);
  }
  
  char b()
  {
    return this.d;
  }
  
  float c()
  {
    f();
    return this.l;
  }
  
  float d()
  {
    f();
    return this.n;
  }
  
  void e()
  {
    f();
    this.n = this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerColumn
 * JD-Core Version:    0.7.0.1
 */