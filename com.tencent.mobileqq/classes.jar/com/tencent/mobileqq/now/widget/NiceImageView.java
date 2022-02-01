package com.tencent.mobileqq.now.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.R.styleable;

public class NiceImageView
  extends ImageView
{
  private Context a;
  private boolean b;
  private boolean c;
  private int d;
  private int e = -1;
  private int f;
  private int g = -1;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private Xfermode n;
  private int o;
  private int p;
  private float q;
  private float[] r;
  private float[] s;
  private RectF t;
  private RectF u;
  private Paint v;
  private Path w;
  private Path x;
  
  public NiceImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NiceImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NiceImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    int[] arrayOfInt = R.styleable.NiceImageView;
    paramInt = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, 0, 0);
    while (paramInt < paramContext.getIndexCount())
    {
      int i1 = paramContext.getIndex(paramInt);
      if (i1 == 10) {
        this.c = paramContext.getBoolean(i1, this.c);
      } else if (i1 == 9) {
        this.b = paramContext.getBoolean(i1, this.b);
      } else if (i1 == 1) {
        this.d = paramContext.getDimensionPixelSize(i1, this.d);
      } else if (i1 == 0) {
        this.e = paramContext.getColor(i1, this.e);
      } else if (i1 == 8) {
        this.f = paramContext.getDimensionPixelSize(i1, this.f);
      } else if (i1 == 7) {
        this.g = paramContext.getColor(i1, this.g);
      } else if (i1 == 4) {
        this.h = paramContext.getDimensionPixelSize(i1, this.h);
      } else if (i1 == 5) {
        this.i = paramContext.getDimensionPixelSize(i1, this.i);
      } else if (i1 == 6) {
        this.j = paramContext.getDimensionPixelSize(i1, this.j);
      } else if (i1 == 2) {
        this.k = paramContext.getDimensionPixelSize(i1, this.k);
      } else if (i1 == 3) {
        this.l = paramContext.getDimensionPixelSize(i1, this.l);
      } else if (i1 == 11) {
        this.m = paramContext.getColor(i1, this.m);
      }
      paramInt += 1;
    }
    paramContext.recycle();
    this.r = new float[8];
    this.s = new float[8];
    this.u = new RectF();
    this.t = new RectF();
    this.v = new Paint();
    this.w = new Path();
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
    else
    {
      this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
      this.x = new Path();
    }
    c();
    d();
  }
  
  private int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a()
  {
    if (!this.b)
    {
      RectF localRectF = this.u;
      int i1 = this.d;
      localRectF.set(i1 / 2.0F, i1 / 2.0F, this.o - i1 / 2.0F, this.p - i1 / 2.0F);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.w.reset();
    this.v.setStrokeWidth(paramInt1);
    this.v.setColor(paramInt2);
    this.v.setStyle(Paint.Style.STROKE);
  }
  
  private void a(Canvas paramCanvas)
  {
    int i1;
    if (this.b)
    {
      i1 = this.d;
      if (i1 > 0) {
        a(paramCanvas, i1, this.e, this.q - i1 / 2.0F);
      }
      i1 = this.f;
      if (i1 > 0) {
        a(paramCanvas, i1, this.g, this.q - this.d - i1 / 2.0F);
      }
    }
    else
    {
      i1 = this.d;
      if (i1 > 0) {
        a(paramCanvas, i1, this.e, this.u, this.r);
      }
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat)
  {
    a(paramInt1, paramInt2);
    this.w.addCircle(this.o / 2.0F, this.p / 2.0F, paramFloat, Path.Direction.CCW);
    paramCanvas.drawPath(this.w, this.v);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, RectF paramRectF, float[] paramArrayOfFloat)
  {
    a(paramInt1, paramInt2);
    this.w.addRoundRect(paramRectF, paramArrayOfFloat, Path.Direction.CCW);
    paramCanvas.drawPath(this.w, this.v);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.h = 0;
    }
    c();
    a();
    invalidate();
  }
  
  private void b()
  {
    if (this.b)
    {
      this.q = (Math.min(this.o, this.p) / 2.0F);
      RectF localRectF = this.t;
      int i1 = this.o;
      float f1 = i1 / 2.0F;
      float f2 = this.q;
      int i2 = this.p;
      localRectF.set(f1 - f2, i2 / 2.0F - f2, i1 / 2.0F + f2, i2 / 2.0F + f2);
      return;
    }
    this.t.set(0.0F, 0.0F, this.o, this.p);
    if (this.c) {
      this.t = this.u;
    }
  }
  
  private void c()
  {
    if (this.b) {
      return;
    }
    int i2 = this.h;
    int i1 = 0;
    if (i2 > 0) {
      for (;;)
      {
        arrayOfFloat = this.r;
        if (i1 >= arrayOfFloat.length) {
          break;
        }
        i2 = this.h;
        arrayOfFloat[i1] = i2;
        this.s[i1] = (i2 - this.d / 2.0F);
        i1 += 1;
      }
    }
    float[] arrayOfFloat = this.r;
    int i4 = this.i;
    float f1 = i4;
    arrayOfFloat[1] = f1;
    arrayOfFloat[0] = f1;
    i1 = this.j;
    f1 = i1;
    arrayOfFloat[3] = f1;
    arrayOfFloat[2] = f1;
    i2 = this.l;
    f1 = i2;
    arrayOfFloat[5] = f1;
    arrayOfFloat[4] = f1;
    int i3 = this.k;
    f1 = i3;
    arrayOfFloat[7] = f1;
    arrayOfFloat[6] = f1;
    arrayOfFloat = this.s;
    f1 = i4;
    i4 = this.d;
    f1 -= i4 / 2.0F;
    arrayOfFloat[1] = f1;
    arrayOfFloat[0] = f1;
    f1 = i1 - i4 / 2.0F;
    arrayOfFloat[3] = f1;
    arrayOfFloat[2] = f1;
    f1 = i2 - i4 / 2.0F;
    arrayOfFloat[5] = f1;
    arrayOfFloat[4] = f1;
    f1 = i3 - i4 / 2.0F;
    arrayOfFloat[7] = f1;
    arrayOfFloat[6] = f1;
  }
  
  private void d()
  {
    if (!this.b) {
      this.f = 0;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(this.t, null, 31);
    if (!this.c)
    {
      i1 = this.o;
      int i2 = this.d;
      int i3 = this.f;
      float f1 = (i1 - i2 * 2 - i3 * 2) * 1.0F / i1;
      int i4 = this.p;
      paramCanvas.scale(f1, (i4 - i2 * 2 - i3 * 2) * 1.0F / i4, i1 / 2.0F, i4 / 2.0F);
    }
    super.onDraw(paramCanvas);
    this.v.reset();
    this.w.reset();
    if (this.b) {
      this.w.addCircle(this.o / 2.0F, this.p / 2.0F, this.q, Path.Direction.CCW);
    } else {
      this.w.addRoundRect(this.t, this.s, Path.Direction.CCW);
    }
    this.v.setAntiAlias(true);
    this.v.setStyle(Paint.Style.FILL);
    this.v.setXfermode(this.n);
    if (Build.VERSION.SDK_INT <= 27)
    {
      paramCanvas.drawPath(this.w, this.v);
    }
    else
    {
      this.x.addRect(this.t, Path.Direction.CCW);
      this.x.op(this.w, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(this.x, this.v);
    }
    this.v.setXfermode(null);
    int i1 = this.m;
    if (i1 != 0)
    {
      this.v.setColor(i1);
      paramCanvas.drawPath(this.w, this.v);
    }
    paramCanvas.restore();
    a(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.o = paramInt1;
    this.p = paramInt2;
    a();
    b();
  }
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    this.e = paramInt;
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.d = a(this.a, paramInt);
    a(false);
  }
  
  public void setCornerBottomLeftRadius(int paramInt)
  {
    this.k = a(this.a, paramInt);
    a(true);
  }
  
  public void setCornerBottomRightRadius(int paramInt)
  {
    this.l = a(this.a, paramInt);
    a(true);
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.h = a(this.a, paramInt);
    a(false);
  }
  
  public void setCornerTopLeftRadius(int paramInt)
  {
    this.i = a(this.a, paramInt);
    a(true);
  }
  
  public void setCornerTopRightRadius(int paramInt)
  {
    this.j = a(this.a, paramInt);
    a(true);
  }
  
  public void setInnerBorderColor(@ColorInt int paramInt)
  {
    this.g = paramInt;
    invalidate();
  }
  
  public void setInnerBorderWidth(int paramInt)
  {
    this.f = a(this.a, paramInt);
    d();
    invalidate();
  }
  
  public void setMaskColor(@ColorInt int paramInt)
  {
    this.m = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.NiceImageView
 * JD-Core Version:    0.7.0.1
 */