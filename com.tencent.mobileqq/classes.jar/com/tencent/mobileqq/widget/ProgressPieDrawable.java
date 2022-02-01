package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;

public class ProgressPieDrawable
  extends Drawable
{
  static LruCache<String, Typeface> a = new LruCache(8);
  public int A = 2;
  public ProgressPieDrawable.AnimationHandler B = new ProgressPieDrawable.AnimationHandler(this);
  float C;
  public boolean D = true;
  public boolean E = false;
  public WeakReference<Context> F;
  private Paint G;
  private boolean H = false;
  private boolean I;
  WeakReference<ProgressPieDrawable.OnProgressListener> b;
  DisplayMetrics c;
  public int d = 100;
  public int e = 0;
  public int f = -90;
  public boolean g = false;
  public boolean h = false;
  public boolean i = true;
  public float j = 1.5F;
  public float k = 4.0F;
  public boolean l = true;
  public float m = 14.0F;
  public String n;
  public String o;
  public boolean p = true;
  public Drawable q;
  Rect r;
  public Paint s;
  public Paint t;
  public Paint u;
  public Paint v;
  RectF w;
  RectF x;
  public int y = 1;
  public int z = 25;
  
  public ProgressPieDrawable(Context paramContext)
  {
    this.F = new WeakReference(paramContext);
    a(paramContext);
  }
  
  public Resources a()
  {
    if (this.F.get() == null) {
      return null;
    }
    return ((Context)this.F.get()).getResources();
  }
  
  public void a(int paramInt)
  {
    this.C = paramInt;
  }
  
  void a(Context paramContext)
  {
    this.c = paramContext.getResources().getDisplayMetrics();
    this.j *= this.c.density;
    this.k *= this.c.density;
    this.m *= this.c.scaledDensity;
    this.v = new Paint(1);
    this.v.setColor(0);
    this.v.setStyle(Paint.Style.FILL);
    this.G = new Paint(1);
    this.G.setColor(-1493172225);
    this.u = new Paint(1);
    this.u.setColor(16777215);
    if (this.y == 1)
    {
      this.u.setStyle(Paint.Style.STROKE);
      this.u.setStrokeWidth(this.k);
      this.G.setStyle(Paint.Style.STROKE);
      this.G.setStrokeWidth(this.k);
    }
    else
    {
      this.u.setStyle(Paint.Style.FILL);
      this.G.setStyle(Paint.Style.FILL);
    }
    this.s = new Paint(1);
    this.s.setColor(16777215);
    this.s.setStyle(Paint.Style.STROKE);
    this.s.setStrokeWidth(this.j);
    this.t = new Paint(1);
    this.t.setColor(3355443);
    this.t.setTextSize(this.m);
    this.t.setTextAlign(Paint.Align.CENTER);
    this.w = new RectF();
    this.r = new Rect();
    this.x = new RectF();
  }
  
  public void a(ProgressPieDrawable.OnProgressListener paramOnProgressListener)
  {
    this.b = new WeakReference(paramOnProgressListener);
  }
  
  public void a(String paramString)
  {
    this.n = paramString;
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void b()
  {
    this.B.removeMessages(0);
    this.B.a(this.e);
    invalidateSelf();
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
    invalidateSelf();
  }
  
  public boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= this.d);
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c(int paramInt)
  {
    this.B.removeMessages(0);
    if (b(paramInt))
    {
      this.B.a(paramInt);
      this.B.sendEmptyMessage(0);
      invalidateSelf();
      return;
    }
    throw new IllegalArgumentException(String.format("Animation progress (%d) is greater than the max progress (%d) or lower than 0 ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.d) }));
  }
  
  public void c(boolean paramBoolean)
  {
    this.i = paramBoolean;
    invalidateSelf();
  }
  
  public void d(int paramInt)
  {
    if (b(paramInt))
    {
      this.e = paramInt;
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = (ProgressPieDrawable.OnProgressListener)((WeakReference)localObject).get();
        if (localObject != null)
        {
          paramInt = this.e;
          int i1 = this.d;
          if (paramInt == i1) {
            ((ProgressPieDrawable.OnProgressListener)localObject).onProgressCompleted(this);
          } else {
            ((ProgressPieDrawable.OnProgressListener)localObject).onProgressChanged(this, paramInt, i1);
          }
        }
      }
      invalidateSelf();
      return;
    }
    throw new IllegalArgumentException(String.format("Progress (%d) must be between %d and %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(this.d) }));
  }
  
  public void d(boolean paramBoolean)
  {
    this.p = paramBoolean;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!isVisible()) {
      return;
    }
    Rect localRect = getBounds();
    Object localObject = this.w;
    float f1 = this.C;
    ((RectF)localObject).set(0.0F, 0.0F, f1, f1);
    this.w.offset((localRect.width() - this.C) / 2.0F, (localRect.height() - this.C) / 2.0F);
    int i1;
    if (this.i)
    {
      i1 = (int)(this.s.getStrokeWidth() / 2.0F + 0.5F);
      localObject = this.w;
      f1 = i1;
      ((RectF)localObject).inset(f1, f1);
    }
    float f3 = this.w.centerX();
    float f4 = this.w.centerY();
    if (this.D)
    {
      this.x.set(this.w);
      paramCanvas.drawArc(this.x, 0.0F, 360.0F, true, this.v);
      i1 = this.y;
      float f2;
      if ((i1 != 0) && (i1 != 1))
      {
        if (i1 == 2)
        {
          f2 = this.C / 2.0F * (this.e / this.d);
          f1 = f2;
          if (this.i) {
            f1 = f2 + 0.5F - this.s.getStrokeWidth();
          }
          paramCanvas.drawCircle(f3, f4, f1, this.u);
        }
        else
        {
          paramCanvas = new StringBuilder();
          paramCanvas.append("Invalid Progress Fill = ");
          paramCanvas.append(this.y);
          throw new IllegalArgumentException(paramCanvas.toString());
        }
      }
      else
      {
        f2 = this.e * 360 / this.d;
        f1 = f2;
        if (this.g) {
          f1 = f2 - 360.0F;
        }
        f2 = f1;
        if (this.h) {
          f2 = -f1;
        }
        if (this.y == 0)
        {
          if (this.I) {
            paramCanvas.drawArc(this.x, 0.0F, 360.0F, true, this.G);
          }
          paramCanvas.drawArc(this.x, this.f, f2, true, this.u);
        }
        else
        {
          i1 = (int)(this.u.getStrokeWidth() / 2.0F + 0.5F);
          localObject = this.x;
          f1 = i1;
          ((RectF)localObject).inset(f1, f1);
          if (this.I) {
            paramCanvas.drawArc(this.x, 0.0F, 360.0F, false, this.G);
          }
          paramCanvas.drawArc(this.x, this.f, f2, false, this.u);
        }
      }
    }
    if ((!TextUtils.isEmpty(this.n)) && (this.l))
    {
      if (!TextUtils.isEmpty(this.o))
      {
        Typeface localTypeface = (Typeface)a.get(this.o);
        localObject = localTypeface;
        if (localTypeface == null)
        {
          localObject = localTypeface;
          if (a() != null)
          {
            AssetManager localAssetManager = a().getAssets();
            localObject = localTypeface;
            if (localAssetManager != null)
            {
              localObject = Typeface.createFromAsset(localAssetManager, this.o);
              a.put(this.o, localObject);
            }
          }
        }
        this.t.setTypeface((Typeface)localObject);
      }
      i1 = (int)f3;
      int i2 = (int)(f4 - (this.t.descent() + this.t.ascent()) / 2.0F);
      paramCanvas.drawText(this.n, i1, i2, this.t);
    }
    localObject = this.q;
    if ((localObject != null) && (this.p))
    {
      if (this.H)
      {
        this.r.set(0, 0, localRect.width(), localRect.height());
      }
      else
      {
        i1 = ((Drawable)localObject).getIntrinsicWidth();
        this.r.set(0, 0, i1, i1);
        this.r.offset((localRect.width() - i1) / 2, (localRect.height() - i1) / 2);
      }
      this.q.setBounds(this.r);
      this.q.draw(paramCanvas);
    }
    if ((this.i) && (this.D)) {
      paramCanvas.drawOval(this.w, this.s);
    }
  }
  
  public void e(int paramInt)
  {
    this.u.setColor(paramInt);
    invalidateSelf();
  }
  
  public void e(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void f(int paramInt)
  {
    this.G.setColor(paramInt);
    invalidateSelf();
  }
  
  public void g(int paramInt)
  {
    this.v.setColor(paramInt);
    invalidateSelf();
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.C;
  }
  
  public int getIntrinsicWidth()
  {
    return (int)this.C;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void h(int paramInt)
  {
    this.t.setColor(paramInt);
    invalidateSelf();
  }
  
  public void i(int paramInt)
  {
    this.m = (paramInt * this.c.scaledDensity);
    this.t.setTextSize(this.m);
    invalidateSelf();
  }
  
  public void j(int paramInt)
  {
    if (this.u.getStyle() == Paint.Style.STROKE)
    {
      this.k = (paramInt * this.c.density);
      this.u.setStrokeWidth(this.k);
      this.G.setStrokeWidth(this.k);
      invalidateSelf();
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return super.onLevelChange(paramInt);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBounds(Rect paramRect)
  {
    super.setBounds(paramRect);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressPieDrawable
 * JD-Core Version:    0.7.0.1
 */