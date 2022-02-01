package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class d
  implements b
{
  public static boolean a = false;
  private static final TextPaint b = new TextPaint(1);
  private static Comparator<Integer> c = new d.1();
  private c d;
  private char[] e;
  private int f;
  private int g;
  private int h;
  private float[] i;
  private float j;
  private boolean k;
  private float l;
  private float m;
  private float n = -1.0F;
  private float o = 0.0F;
  private float p = 0.0F;
  private RectF q = new RectF();
  private RectF r = new RectF();
  private LinkedList<Integer> s = null;
  private int t;
  private float u;
  
  public d(c paramc, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat, float paramFloat3, float paramFloat4, float paramFloat5, TextPaint paramTextPaint, boolean paramBoolean, float paramFloat6, int paramInt3, int paramInt4, float paramFloat7)
  {
    this.d = paramc;
    this.e = paramArrayOfChar;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramArrayOfFloat;
    this.j = paramFloat5;
    this.o = paramFloat6;
    this.k = paramBoolean;
    this.l = paramFloat4;
    this.m = paramFloat3;
    this.p = paramFloat7;
    this.t = paramInt4;
    paramc = paramTextPaint.getFontMetrics();
    paramFloat4 = paramc.leading - paramc.top;
    paramFloat5 = paramc.bottom;
    paramFloat6 = paramc.leading;
    this.u = ((this.l - paramc.bottom + paramc.top) / 2.0F + paramFloat2 - paramc.top);
    paramc = this.q;
    paramFloat2 = this.u;
    paramc.set(paramFloat1, paramFloat2 - paramFloat4, paramFloat3 + paramFloat1, paramFloat2 + (paramFloat5 - paramFloat6));
    this.r.set(paramFloat1, this.u - paramFloat4, paramFloat7 + paramFloat1, this.q.top + this.l);
  }
  
  private boolean a(TextPaint paramTextPaint, int paramInt1, int paramInt2)
  {
    b.set(paramTextPaint);
    paramTextPaint = (AbsoluteSizeSpan)this.d.l().a(paramInt1, paramInt2);
    boolean bool;
    if (paramTextPaint != null)
    {
      paramTextPaint.updateDrawState(b);
      bool = true;
    }
    else
    {
      bool = false;
    }
    paramTextPaint = (RelativeSizeSpan)this.d.k().a(paramInt1, paramInt2);
    if (paramTextPaint != null)
    {
      paramTextPaint.updateDrawState(b);
      bool = true;
    }
    paramTextPaint = (ForegroundColorSpan)this.d.m().a(paramInt1, paramInt2);
    if (paramTextPaint != null) {
      paramTextPaint.updateDrawState(b);
    }
    paramTextPaint = (ClickableSpan)this.d.n().a(paramInt1, paramInt2);
    if (paramTextPaint != null) {
      paramTextPaint.updateDrawState(b);
    }
    return bool;
  }
  
  private ImageSpan c(int paramInt1, int paramInt2)
  {
    return (ImageSpan)this.d.i().a(paramInt1, paramInt2);
  }
  
  private List<LineBackgroundSpan> d(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt1 = this.d.j().c;
    int[] arrayOfInt2 = this.d.j().d;
    LineBackgroundSpan[] arrayOfLineBackgroundSpan = (LineBackgroundSpan[])this.d.j().b;
    LinkedList localLinkedList = new LinkedList();
    int i1 = 0;
    while (i1 < this.d.j().a)
    {
      if ((arrayOfInt1[i1] < paramInt2) && (arrayOfInt2[i1] > paramInt1)) {
        localLinkedList.add(arrayOfLineBackgroundSpan[i1]);
      }
      i1 += 1;
    }
    return localLinkedList;
  }
  
  public float a()
  {
    return this.l;
  }
  
  public float a(int paramInt)
  {
    float f1 = this.q.left + j();
    int i4;
    for (int i1 = this.f;; i1 = i4)
    {
      int i3 = i1;
      i1 = 0;
      int i2 = i3;
      for (;;)
      {
        int i5 = this.g;
        if ((i2 >= i5) || (i2 >= paramInt)) {
          return f1;
        }
        i4 = i2 + 1;
        i2 = i1;
        if (i4 >= i5) {
          break;
        }
        float[] arrayOfFloat = this.i;
        i2 = i4;
        if (arrayOfFloat[i4] != 0.0F)
        {
          i2 = i1;
          if (i1 != 0) {
            break;
          }
          if ((this.k) && (arrayOfFloat[i4] == this.o)) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          i2 = i1;
          if (i1 == 0) {
            break;
          }
          i2 = i4;
        }
      }
      float f2 = f1;
      if (i2 != 0) {
        f2 = f1 + this.o;
      }
      f1 = f2 + (this.i[i3] + this.j);
    }
    return f1;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i2 = this.f;
    float f1 = this.q.left;
    float f2 = j();
    int i1 = this.f;
    f1 += f2;
    int i5;
    for (int i3 = i1;; i3 = i1)
    {
      int i4;
      for (paramInt2 = 0;; paramInt2 = i4)
      {
        i5 = this.g;
        if (i1 >= i5) {
          break label254;
        }
        i1 += 1;
        i4 = paramInt2;
        if (i1 >= i5) {
          break;
        }
        float[] arrayOfFloat = this.i;
        i4 = paramInt2;
        if (arrayOfFloat[i1] != 0.0F)
        {
          i4 = paramInt2;
          if (paramInt2 != 0) {
            break;
          }
          if ((this.k) && (arrayOfFloat[i1] == this.o)) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
          i4 = paramInt2;
          if (paramInt2 == 0) {
            break;
          }
          i4 = paramInt2;
        }
        i2 += 1;
      }
      f2 = f1;
      if (i4 != 0) {
        f2 = f1 + this.o;
      }
      f1 = this.i[i3] + this.j + f2;
      float f3 = paramInt1;
      if ((f2 <= f3) && (f3 < f1)) {
        return i2;
      }
      if (f2 > f3) {
        return this.f;
      }
      if (f3 > this.q.right)
      {
        paramInt1 = this.g;
        if (paramInt1 == this.e.length) {
          return paramInt1;
        }
        return paramInt1 - 1;
      }
      i2 += 1;
    }
    label254:
    return i5;
  }
  
  public void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1 + j();
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    paramFloat1 = paramFloat2 + (this.l - localFontMetrics.bottom + localFontMetrics.top) / 2.0F - localFontMetrics.top;
    Object localObject1 = d(this.f, this.g).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((LineBackgroundSpan)((Iterator)localObject1).next()).drawBackground(paramCanvas, paramTextPaint, (int)this.q.left, (int)this.q.right, (int)this.q.top, (int)paramFloat1, (int)this.q.bottom, this.d.d(), this.f, this.g, this.h);
    }
    localObject1 = null;
    if (a)
    {
      localObject1 = new StringBuilder("canvas w=");
      ((StringBuilder)localObject1).append(paramCanvas.getWidth());
      ((StringBuilder)localObject1).append(" canvas h=");
      ((StringBuilder)localObject1).append(paramCanvas.getHeight());
      ((StringBuilder)localObject1).append('\n');
    }
    int i2 = this.f;
    for (int i3 = i2;; i3 = i2)
    {
      int i1 = 0;
      int i4 = i2;
      for (;;)
      {
        int i5 = this.g;
        if (i4 >= i5) {
          break label499;
        }
        i2 = i4 + 1;
        i4 = i1;
        if (i2 >= i5) {
          break;
        }
        localObject2 = this.i;
        i4 = i2;
        if (localObject2[i2] != 0.0F)
        {
          i4 = i1;
          if (i1 != 0) {
            break;
          }
          if ((this.k) && (localObject2[i2] == this.o)) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          i4 = i1;
          if (i1 == 0) {
            break;
          }
          i4 = i2;
        }
      }
      Object localObject2 = c(i3, i2);
      if (localObject2 != null)
      {
        b.set(paramTextPaint);
        ((ImageSpan)localObject2).draw(paramCanvas, "", i3, i2, f1, 0, (int)paramFloat1, (int)(paramFloat2 + a()), b);
      }
      else
      {
        if (a(paramTextPaint, i3, i2)) {
          paramFloat1 = paramFloat2 + (this.l - localFontMetrics.bottom + localFontMetrics.top) / 2.0F - localFontMetrics.top;
        }
        paramCanvas.drawText(this.e, i3, i2 - i3, f1, paramFloat1, b);
      }
      float f2 = f1;
      if (i4 != 0) {
        f2 = f1 + this.o;
      }
      f1 = f2 + (this.i[i3] + this.j);
      if (a)
      {
        ((StringBuilder)localObject1).append(f1);
        ((StringBuilder)localObject1).append(',');
      }
    }
    label499:
    if (a) {
      Log.i("MeasuredLine", ((StringBuilder)localObject1).toString());
    }
  }
  
  public float b()
  {
    return this.m;
  }
  
  public RectF b(int paramInt1, int paramInt2)
  {
    RectF localRectF = new RectF();
    if (paramInt1 >= paramInt2) {
      return localRectF;
    }
    float f1 = j();
    int i1 = f();
    while (i1 < paramInt1)
    {
      f1 += this.i[i1] + this.j;
      i1 += 1;
    }
    float f2 = f1;
    while (paramInt1 < paramInt2)
    {
      f2 += this.i[paramInt1] + this.j;
      paramInt1 += 1;
    }
    localRectF.set(f1, this.q.top, f2, this.q.bottom);
    return localRectF;
  }
  
  public float[] c()
  {
    return this.i;
  }
  
  public RectF d()
  {
    return this.q;
  }
  
  public RectF e()
  {
    return this.r;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if ((paramObject.f() == f()) && (paramObject.g() == g()) && (paramObject.d().equals(this.q)) && (paramObject.i() == this.k) && (paramObject.h() == this.j))
      {
        if (paramObject.j() != this.n) {
          return false;
        }
        int i1 = this.f;
        while (i1 < this.g)
        {
          if (this.i[i1] != paramObject.c()[i1]) {
            return false;
          }
          i1 += 1;
        }
        return true;
      }
    }
    return false;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public float h()
  {
    return this.j;
  }
  
  public int hashCode()
  {
    return this.f + this.g + (int)this.l + (int)this.m + (int)this.n + this.q.hashCode();
  }
  
  public boolean i()
  {
    return this.k;
  }
  
  public float j()
  {
    float f1 = this.n;
    if (f1 != -1.0F) {
      return f1;
    }
    if ((this.t & 0x7) == 1)
    {
      int i2 = this.f;
      i1 = i2;
      f1 = 0.0F;
      for (;;)
      {
        int i3 = this.g;
        if (i2 >= i3) {
          break;
        }
        i2 += 1;
        if ((i2 >= i3) || (this.i[i2] != 0.0F))
        {
          f1 += this.i[i1] + this.j;
          i1 = i2;
        }
      }
      f1 = (this.p - f1) / 2.0F;
    }
    else
    {
      f1 = 0.0F;
    }
    f1 = Math.max(0.0F, f1);
    e locale = this.d.i();
    int i1 = this.f;
    if ((locale.a(i1, i1 + 1) == null) && (this.d.h().containsKey(Character.valueOf(this.e[this.f]))))
    {
      f1 -= ((Float)this.d.h().get(Character.valueOf(this.e[this.f]))).floatValue();
      this.n = f1;
      return f1;
    }
    this.n = f1;
    return this.n;
  }
  
  public float k()
  {
    return this.u;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MeasuredLine{mStart=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mEnd=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mLetter=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", isSmartLetter=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", mHeight=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", mWidth=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", mLeftOffset=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", mLineRect=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", mLineRect=");
    localStringBuilder.append(this.r);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.d
 * JD-Core Version:    0.7.0.1
 */