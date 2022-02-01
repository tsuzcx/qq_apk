package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;

public class SaQianView
{
  private static final float q = Resources.getSystem().getDisplayMetrics().density;
  public Context a;
  public int b;
  public View c;
  private Bitmap[] d = new Bitmap[5];
  private int[] e = { 2130846897, 2130846898, 2130846899, 2130846900, 2130846901 };
  private int f;
  private ArrayList<SaQian> g = new ArrayList();
  private boolean h;
  private long i;
  private Matrix j;
  private float k;
  private float l;
  private Paint m;
  private int n;
  private int o;
  private int p;
  
  public SaQianView(Context paramContext, int paramInt1, int paramInt2, View paramView)
  {
    int i1 = 0;
    this.h = false;
    this.j = new Matrix();
    this.b = 255;
    this.a = paramContext;
    try
    {
      while (i1 < this.e.length)
      {
        this.d[i1] = BitmapFactory.decodeResource(paramContext.getResources(), this.e[i1]);
        i1 += 1;
      }
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
      this.k = paramInt1;
      this.l = paramInt2;
      this.m = new Paint(1);
      this.c = paramView;
    }
  }
  
  public static int b(int paramInt)
  {
    return Math.round(paramInt * q);
  }
  
  public void a()
  {
    this.c.invalidate();
  }
  
  public void a(int paramInt)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      int i2 = (int)(Math.random() * 5.0D);
      SaQian localSaQian = SaQian.a(this.d[i2], this.k, this.l, i2, this.a.getResources());
      localSaQian.m = System.currentTimeMillis();
      localSaQian.j = this.b;
      this.g.add(localSaQian);
      i1 += 1;
    }
    this.f += paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = (paramInt2 * 3 / 8);
    this.g.clear();
    this.f = 0;
  }
  
  public void a(Canvas paramCanvas)
  {
    if (!this.h) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if (l1 - this.i > 400L)
    {
      this.i = l1;
      if (this.f <= 3) {
        a(1);
      }
    }
    int i1 = 0;
    SaQian localSaQian;
    float f1;
    float f2;
    while (i1 < this.f)
    {
      localSaQian = (SaQian)this.g.get(i1);
      localSaQian.l = ((float)(System.currentTimeMillis() - localSaQian.m) / 1000.0F);
      f1 = localSaQian.h;
      f2 = localSaQian.l;
      float f3 = localSaQian.i;
      float f4 = localSaQian.l;
      float f5 = b(400);
      float f6 = localSaQian.l;
      float f7 = localSaQian.l;
      localSaQian.c[0] = (this.k + f1 * f2);
      localSaQian.c[1] = (this.l - (f3 * f4 - f5 * 0.5F * f6 * f7));
      if (localSaQian.j > 200) {
        localSaQian.j -= 1;
      } else {
        localSaQian.j -= (int)(Math.random() * 5.0D + 5.0D);
      }
      if ((localSaQian.j < 0) || ((this.p > 0) && (localSaQian.c[1] > this.p)))
      {
        localSaQian.c[0] = this.k;
        localSaQian.c[1] = this.l;
        localSaQian.j = this.b;
        localSaQian.m = System.currentTimeMillis();
        localSaQian.f = (Math.random() * 3.141592653589793D / 6.0D + 2.879793265790644D);
        localSaQian.g = (b(40) + (float)Math.random() * b(50));
        double d1 = localSaQian.g;
        double d2 = Math.cos(localSaQian.f);
        Double.isNaN(d1);
        localSaQian.h = ((float)(d1 * d2));
        d1 = localSaQian.g;
        d2 = Math.sin(localSaQian.f);
        Double.isNaN(d1);
        localSaQian.i = ((float)(d1 * d2));
        localSaQian.d = ((float)Math.random() * b(18) - b(18));
        int i2 = (int)(Math.random() * 5.0D);
        Bitmap localBitmap = this.d[i2];
        localSaQian.e = SaQian.a(i2, localSaQian.a, localSaQian.b, localBitmap);
        if (i2 == 0) {
          localSaQian.a = AIOUtils.b(20.0F, this.a.getResources());
        } else {
          localSaQian.a = AIOUtils.b(14.0F, this.a.getResources());
        }
        localSaQian.b = ((int)(localSaQian.e.getHeight() / localSaQian.e.getWidth() * localSaQian.a));
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.f)
    {
      localSaQian = (SaQian)this.g.get(i1);
      if ((localSaQian.c[0] < this.n) && (localSaQian.c[0] > 0.0F) && (localSaQian.c[1] < this.o) && (localSaQian.c[1] > 0.0F))
      {
        f1 = localSaQian.a * 1.0F / localSaQian.e.getWidth();
        f2 = localSaQian.b * 1.0F / localSaQian.e.getHeight();
        this.j.setTranslate(-localSaQian.a / 2 / f1, -localSaQian.b / 2 / f2);
        this.j.postRotate(localSaQian.d);
        this.j.postTranslate(localSaQian.c[0] / f1, localSaQian.c[1] / f2);
        this.j.postScale(f1, f2);
        this.m.setAlpha(localSaQian.j);
        paramCanvas.drawBitmap(localSaQian.e, this.j, this.m);
      }
      i1 += 1;
    }
    a();
  }
  
  public void b()
  {
    this.h = true;
    a();
    this.i = System.currentTimeMillis();
  }
  
  public void c()
  {
    this.g.clear();
    this.h = false;
    this.f = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.SaQianView
 * JD-Core Version:    0.7.0.1
 */