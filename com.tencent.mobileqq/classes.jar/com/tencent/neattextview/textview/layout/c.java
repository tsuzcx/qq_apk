package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.RelativeSizeSpan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class c
  implements a
{
  public static final char[] a = { '…' };
  private static final String l = new String(a);
  private e<AbsoluteSizeSpan> A = new e(AbsoluteSizeSpan.class);
  private e<RelativeSizeSpan> B = new e(RelativeSizeSpan.class);
  private e<BackgroundColorSpan> C = new e(BackgroundColorSpan.class);
  private e<ForegroundColorSpan> D = new e(ForegroundColorSpan.class);
  private e<ClickableSpan> E = new e(ClickableSpan.class);
  private e<LineBackgroundSpan> F = new e(LineBackgroundSpan.class);
  private float G = 0.0F;
  private LinkedList<com.tencent.luggage.wxa.rw.c> H;
  private int I = 0;
  private int J = 0;
  private int K = 0;
  protected CharSequence b;
  protected String c;
  protected char[] d;
  protected TextPaint e;
  protected float[] f;
  protected float[] g;
  protected float[] h = new float[com.tencent.luggage.wxa.rv.a.a.length];
  protected float[] i = new float[com.tencent.luggage.wxa.rv.a.b.length];
  protected HashMap<Character, Float> j = new HashMap(com.tencent.luggage.wxa.rv.a.a.length);
  protected boolean[] k;
  private ArrayList<b> m = new ArrayList();
  private LinkedList<com.tencent.luggage.wxa.rw.b> n = new LinkedList();
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private TextUtils.TruncateAt u;
  private int v = 0;
  private int w;
  private TextPaint x = new TextPaint();
  private float[] y;
  private e<ImageSpan> z = new e(ImageSpan.class);
  
  public c(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    this.b = paramCharSequence;
    this.c = paramCharSequence.toString();
    this.d = this.c.toCharArray();
    if (paramArrayOfFloat != null)
    {
      this.f = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, this.f, 0, paramArrayOfFloat.length);
    }
  }
  
  private void a(Paint paramPaint)
  {
    this.j.clear();
    Rect localRect = new Rect();
    char[] arrayOfChar = com.tencent.luggage.wxa.rv.a.a;
    int i3 = arrayOfChar.length;
    int i1 = 0;
    int i2 = 0;
    char c1;
    StringBuilder localStringBuilder;
    float f1;
    while (i1 < i3)
    {
      c1 = arrayOfChar[i1];
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c1);
      localStringBuilder.append("");
      f1 = paramPaint.measureText(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c1);
      localStringBuilder.append("");
      paramPaint.getTextBounds(localStringBuilder.toString(), 0, 1, localRect);
      float f2 = localRect.right;
      this.h[i2] = (f1 - f2);
      i2 += 1;
      i1 += 1;
    }
    arrayOfChar = com.tencent.luggage.wxa.rv.a.b;
    i3 = arrayOfChar.length;
    i1 = 0;
    i2 = 0;
    while (i1 < i3)
    {
      c1 = arrayOfChar[i1];
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c1);
      localStringBuilder.append("");
      paramPaint.getTextBounds(localStringBuilder.toString(), 0, 1, localRect);
      if (localRect.left > 0) {
        f1 = localRect.left;
      } else {
        f1 = 0.0F;
      }
      this.i[i2] = f1;
      this.j.put(Character.valueOf(com.tencent.luggage.wxa.rv.a.b[i2]), Float.valueOf(f1));
      i2 += 1;
      i1 += 1;
    }
  }
  
  private void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat, TextPaint paramTextPaint)
  {
    if (q())
    {
      float f1 = paramTextPaint.measureText(l) + paramTextPaint.getTextSize() / 6.0F + paramFloat;
      paramTextPaint = this.m;
      paramTextPaint = (b)paramTextPaint.get(paramTextPaint.size() - 1);
      this.K = (this.m.size() - 1);
      int i1;
      if ((this.v == 1) && (paramTruncateAt == TextUtils.TruncateAt.MIDDLE)) {
        i1 = o();
      } else if (paramTruncateAt == TextUtils.TruncateAt.END) {
        i1 = paramTextPaint.g() - 1;
      } else {
        i1 = 0;
      }
      int i2 = paramTextPaint.f();
      paramFloat = 0.0F;
      while (i1 >= i2)
      {
        paramTruncateAt = this.f;
        paramFloat += paramTruncateAt[i1];
        if ((paramFloat >= f1) || (i1 == i2)) {
          break;
        }
        paramTruncateAt[i1] = 0.0F;
        this.d[i1] = '\000';
        i1 -= 1;
      }
      if (i1 >= 0)
      {
        paramTruncateAt = this.d;
        this.J = (paramTruncateAt.length - i1);
        this.f[i1] = f1;
        paramTruncateAt[i1] = a[0];
        this.I = (i1 - i2);
      }
    }
  }
  
  private int o()
  {
    b localb = (b)this.m.get(0);
    int i1 = localb.f();
    float f1 = 0.0F;
    while (i1 < localb.g())
    {
      f1 += this.f[i1];
      if (f1 >= this.o / 2.0F) {
        return i1;
      }
      i1 += 1;
    }
    return 0;
  }
  
  private boolean p()
  {
    Object localObject = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (this.m.size() > 0)
      {
        int i1 = this.b.length();
        localObject = this.m;
        if (i1 <= ((b)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).g())
        {
          bool1 = bool2;
          if (this.t > 0.0F)
          {
            float f1 = e()[0];
            localObject = this.m;
            bool1 = bool2;
            if (f1 - ((b)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).b() >= this.t) {}
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean q()
  {
    TextUtils.TruncateAt localTruncateAt = this.u;
    return (localTruncateAt != null) && (localTruncateAt != TextUtils.TruncateAt.MARQUEE) && (p());
  }
  
  public int a(int paramInt)
  {
    int i1 = this.m.size();
    b localb;
    if (i1 > paramInt)
    {
      localb = (b)this.m.get(paramInt);
    }
    else
    {
      if (i1 <= 0) {
        break label54;
      }
      localb = (b)this.m.get(i1 - 1);
    }
    return (int)localb.k();
    label54:
    return 0;
  }
  
  public int a(int paramInt, float paramFloat)
  {
    float f1 = this.q;
    if (this.m.size() > paramInt) {
      return ((b)this.m.get(paramInt)).a((int)(paramFloat - f1), 0);
    }
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 - this.q);
    paramInt2 = (int)(paramInt2 - this.r);
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.e().contains(paramInt1, paramInt2)) {
        return localb.a(paramInt1, paramInt2);
      }
    }
    return this.d.length;
  }
  
  public List<com.tencent.luggage.wxa.rw.c> a()
  {
    if (this.H == null)
    {
      this.H = new LinkedList();
      Iterator localIterator = this.n.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.luggage.wxa.rw.b localb = (com.tencent.luggage.wxa.rw.b)localIterator.next();
        if (localb.b() == com.tencent.luggage.wxa.rw.c.class) {
          this.H.add((com.tencent.luggage.wxa.rw.c)localb);
        }
      }
    }
    return this.H;
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.luggage.wxa.rw.b)localIterator.next()).a(paramCanvas, this.e, this.m);
    }
    localIterator = this.m.iterator();
    b localb;
    for (paramFloat1 = 0.0F; localIterator.hasNext(); paramFloat1 += localb.a())
    {
      localb = (b)localIterator.next();
      localb.a(paramCanvas, this.e, 0.0F, paramFloat1);
    }
    paramCanvas.restore();
  }
  
  public final void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.e = new TextPaint(paramTextPaint);
    this.t = paramFloat6;
    this.p = paramFloat2;
    this.o = paramFloat1;
    this.q = paramFloat3;
    this.r = paramFloat4;
    this.v = paramInt1;
    this.u = paramTruncateAt;
    this.s = paramFloat5;
    this.y = null;
    this.w = paramInt2;
    paramInt2 = this.b.length();
    if (this.f == null)
    {
      this.f = new float[paramInt2];
      paramTextPaint.getTextWidths(this.c, this.f);
    }
    this.k = new boolean[paramInt2];
    a(this.b, paramTextPaint, this.k);
    a(paramTextPaint);
    a(paramTextPaint, paramFloat1, paramFloat2, paramFloat5, paramInt1, paramTruncateAt, paramBoolean);
    a(paramTruncateAt, paramFloat6, paramTextPaint);
  }
  
  protected abstract void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, TextUtils.TruncateAt paramTruncateAt, boolean paramBoolean);
  
  public void a(CharSequence paramCharSequence)
  {
    a(paramCharSequence, f(), this.k);
  }
  
  public void a(CharSequence paramCharSequence, TextPaint paramTextPaint, boolean[] paramArrayOfBoolean)
  {
    boolean bool = paramCharSequence instanceof Spanned;
    int i3 = 0;
    Object localObject;
    if (bool)
    {
      localObject = (Spanned)paramCharSequence;
      i1 = paramCharSequence.length();
      this.z.a((Spanned)localObject, 0, i1);
      this.A.a((Spanned)localObject, 0, i1);
      this.B.a((Spanned)localObject, 0, i1);
      this.D.a((Spanned)localObject, 0, i1);
      this.C.a((Spanned)localObject, 0, i1);
      this.E.a((Spanned)localObject, 0, i1);
      this.F.a((Spanned)localObject, 0, i1);
    }
    this.x.set(paramTextPaint);
    int i1 = 0;
    int i2;
    int i4;
    int i5;
    while (i1 < this.A.a)
    {
      ((AbsoluteSizeSpan[])this.A.b)[i1].updateMeasureState(this.x);
      i2 = this.A.c[i1];
      i4 = this.A.d[i1];
      i5 = i4 - i2;
      paramTextPaint = new float[i5];
      this.x.getTextWidths(paramCharSequence, i2, i4, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.f, i2, i5);
      if (this.g == null) {
        this.g = new float[paramCharSequence.length()];
      }
      this.g[i2] = this.x.getTextSize();
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.B.a)
    {
      ((RelativeSizeSpan[])this.B.b)[i1].updateMeasureState(this.x);
      i2 = this.B.c[i1];
      i4 = this.B.d[i1];
      i5 = i4 - i2;
      paramTextPaint = new float[i5];
      this.x.getTextWidths(paramCharSequence, i2, i4, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.f, i2, i5);
      if (this.g == null) {
        this.g = new float[paramCharSequence.length()];
      }
      this.g[i2] = this.x.getTextSize();
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.z.a)
    {
      paramTextPaint = ((ImageSpan[])this.z.b)[i1];
      i4 = this.z.c[i1];
      i5 = this.z.d[i1];
      localObject = paramTextPaint.getDrawable();
      paramTextPaint = new Rect();
      if (localObject != null) {
        paramTextPaint.set(((Drawable)localObject).getBounds());
      }
      this.f[i4] = paramTextPaint.width();
      paramArrayOfBoolean[i4] = true;
      i2 = i4 + 1;
      while (i2 < i4 + (i5 - i4))
      {
        localObject = this.f;
        if (i2 >= localObject.length) {
          break;
        }
        localObject[i2] = 0.0F;
        paramArrayOfBoolean[i2] = true;
        i2 += 1;
      }
      if (this.g == null) {
        this.g = new float[paramCharSequence.length()];
      }
      this.g[i4] = paramTextPaint.height();
      i1 += 1;
    }
    i1 = 0;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.C.a) {
        break;
      }
      paramCharSequence = ((BackgroundColorSpan[])this.C.b)[i1];
      i2 = this.C.c[i1];
      i4 = this.C.d[i1];
      this.n.add(new com.tencent.luggage.wxa.rw.a(i2, i4, paramCharSequence));
      i1 += 1;
    }
    while (i2 < this.E.a)
    {
      paramCharSequence = ((ClickableSpan[])this.E.b)[i2];
      i1 = this.E.c[i2];
      i3 = this.E.d[i2];
      this.n.add(new com.tencent.luggage.wxa.rw.c(i1, i3, paramCharSequence));
      i2 += 1;
    }
  }
  
  protected void a(char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, int paramInt3, float paramFloat2, boolean paramBoolean, float paramFloat3, float paramFloat4)
  {
    float f1 = b(paramInt1, paramInt2);
    paramArrayOfChar = new d(this, paramArrayOfChar, paramInt1, paramInt2, 0.0F, this.G, paramArrayOfFloat, paramFloat1, f1, paramFloat2, this.e, paramBoolean, paramFloat3, paramInt3, this.w, paramFloat4);
    this.G += f1;
    this.m.add(paramArrayOfChar);
  }
  
  protected float b(int paramInt1, int paramInt2)
  {
    Object localObject = this.e.getFontMetrics();
    float f2 = ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top;
    float f1 = f2;
    float f3;
    if (this.g == null)
    {
      f3 = this.s;
      f1 = f2;
    }
    for (;;)
    {
      return f1 + f3;
      while (paramInt1 < paramInt2)
      {
        localObject = this.g;
        f2 = f1;
        if (f1 < localObject[paramInt1]) {
          f2 = localObject[paramInt1];
        }
        paramInt1 += 1;
        f1 = f2;
      }
      f3 = this.s;
    }
  }
  
  public int b(int paramInt)
  {
    int i1 = this.m.size();
    b localb;
    if (i1 > paramInt)
    {
      localb = (b)this.m.get(paramInt);
    }
    else
    {
      if (i1 <= 0) {
        break label57;
      }
      localb = (b)this.m.get(i1 - 1);
    }
    return (int)localb.d().top;
    label57:
    return 0;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public int c(int paramInt)
  {
    int i1 = this.m.size();
    b localb;
    if (i1 > paramInt)
    {
      localb = (b)this.m.get(paramInt);
    }
    else
    {
      if (i1 <= 0) {
        break label57;
      }
      localb = (b)this.m.get(i1 - 1);
    }
    return (int)localb.d().bottom;
    label57:
    return 0;
  }
  
  public float[] c()
  {
    return this.f;
  }
  
  public int d(int paramInt)
  {
    Iterator localIterator = this.m.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.f() <= paramInt) && (paramInt < localb.g())) {
        return i1;
      }
      i1 += 1;
    }
    return i1 - 1;
  }
  
  public CharSequence d()
  {
    return this.b;
  }
  
  public float e(int paramInt)
  {
    int i1 = d(paramInt);
    if (i1 < 0) {
      return 0.0F;
    }
    return ((b)this.m.get(i1)).a(paramInt);
  }
  
  public float[] e()
  {
    if (this.y == null)
    {
      Iterator localIterator = this.m.iterator();
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        float f3 = f2;
        if (f2 < localb.b()) {
          f3 = localb.b();
        }
        f1 += localb.a();
        f2 = f3;
      }
      this.y = new float[] { f2, f1 };
    }
    return this.y;
  }
  
  public float f(int paramInt)
  {
    if (this.m.size() > paramInt) {
      return ((b)this.m.get(paramInt)).d().width();
    }
    return 0.0F;
  }
  
  public TextPaint f()
  {
    return this.e;
  }
  
  public int g()
  {
    return this.m.size();
  }
  
  public int g(int paramInt)
  {
    if (this.m.size() > paramInt) {
      return ((b)this.m.get(paramInt)).f();
    }
    return this.d.length;
  }
  
  public int h(int paramInt)
  {
    int i1 = (int)(paramInt - this.r);
    Iterator localIterator = this.m.iterator();
    float f1 = 0.0F;
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (b)localIterator.next();
      float f2 = f1;
      if (f1 == 0.0F) {
        f2 = ((b)localObject).e().top;
      }
      localObject = ((b)localObject).e();
      if (((RectF)localObject).contains(((RectF)localObject).centerX(), i1)) {
        return paramInt;
      }
      paramInt += 1;
      f1 = f2;
    }
    if (i1 <= f1) {
      return 0;
    }
    return paramInt - 1;
  }
  
  public HashMap<Character, Float> h()
  {
    return this.j;
  }
  
  public float i(int paramInt)
  {
    if (this.m.size() > paramInt) {
      return ((b)this.m.get(paramInt)).d().right;
    }
    return 0.0F;
  }
  
  public e<ImageSpan> i()
  {
    return this.z;
  }
  
  public e<LineBackgroundSpan> j()
  {
    return this.F;
  }
  
  public e<RelativeSizeSpan> k()
  {
    return this.B;
  }
  
  public e<AbsoluteSizeSpan> l()
  {
    return this.A;
  }
  
  public e<ForegroundColorSpan> m()
  {
    return this.D;
  }
  
  public e<ClickableSpan> n()
  {
    return this.E;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.c
 * JD-Core Version:    0.7.0.1
 */