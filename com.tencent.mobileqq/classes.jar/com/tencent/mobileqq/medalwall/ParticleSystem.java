package com.tencent.mobileqq.medalwall;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ParticleSystem
  implements ValueAnimator.AnimatorUpdateListener
{
  protected Paint a;
  protected float b = 1.0F;
  private final int c;
  private final int d;
  private final ArrayList<ParticleSystem.Particle> e;
  private final ArrayList<ParticleSystem.Particle> f;
  private final ArrayList<ParticleSystem.Particle> g;
  private int h;
  private int i;
  private int j;
  private long k;
  private Bitmap[] l;
  private float m = 0.0005F;
  private int n = 60;
  private int o = 35;
  private int p = 160;
  private int q = 20;
  private int r = 150;
  private final Rect s = new Rect();
  private ValueAnimator t;
  private View u;
  
  public ParticleSystem(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    this.u = paramView;
    this.a = new Paint();
    paramView = this.u.getResources();
    float f1 = paramView.getDisplayMetrics().density;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = new ArrayList(this.d / 2);
    if ((this.c & 0x1) == 1) {
      this.g = new ArrayList(150);
    } else {
      this.g = new ArrayList(1);
    }
    this.f = new ArrayList(this.d / 3);
    paramInt1 = 0;
    this.h = 0;
    this.l = new Bitmap[paramArrayOfInt.length];
    for (;;)
    {
      Bitmap[] arrayOfBitmap = this.l;
      if (paramInt1 >= arrayOfBitmap.length) {
        break;
      }
      try
      {
        arrayOfBitmap[paramInt1] = BitmapFactory.decodeResource(paramView, paramArrayOfInt[paramInt1]);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
      paramInt1 += 1;
    }
    this.n = ((int)(this.n * f1));
    this.o = ((int)(this.o * f1));
    this.p = ((int)(this.p * f1));
    this.q = ((int)(this.q * f1));
    this.r = ((int)(f1 * this.r));
  }
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 + (paramDouble2 - paramDouble1) * Math.random();
  }
  
  public void a()
  {
    if (this.t == null)
    {
      this.t = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
      this.t.setRepeatCount(-1);
    }
    this.t.addUpdateListener(this);
    this.t.start();
  }
  
  public void a(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, ParticleSystem.Particle paramParticle)
  {
    if (paramParticle != null)
    {
      double d1 = a(this.q, this.r);
      double d3 = a(0.0D, 6.283185307179586D);
      double d2 = Math.cos(d3);
      d3 = Math.sin(d3);
      double d4 = Math.random();
      double d5 = this.l.length;
      Double.isNaN(d5);
      int i1 = (int)(d4 * d5);
      d4 = paramFloat1;
      Double.isNaN(d4);
      paramParticle.d = ((float)(d2 * d1 + d4));
      d4 = paramFloat2;
      Double.isNaN(d4);
      paramParticle.e = ((float)(d1 * d3 + d4));
      paramParticle.f = ((float)(d2 * a(5.0D, 10.0D)));
      paramParticle.g = ((float)(d3 * a(5.0D, 10.0D)));
      paramParticle.h = i1;
      paramParticle.i = ((int)a(this.o, this.n));
      paramParticle.j = ((float)a(0.9800000190734863D, 0.9900000095367432D));
      paramParticle.k = ((float)a(0.5D, 1.0D));
      paramParticle.l = ((float)a(0.9800000190734863D, 0.9900000095367432D));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    this.p = ((int)(Math.min(this.i, this.j) * 0.4F));
    paramInt1 = this.p;
    this.q = ((int)(paramInt1 * 0.6F));
    this.r = ((int)(paramInt1 * 0.8F));
    paramInt2 = 0;
    this.h = 0;
    this.e.clear();
    this.g.clear();
    this.f.clear();
    if ((this.c & 0x1) == 1)
    {
      float f1 = this.i;
      float f2 = this.j;
      paramInt1 = 0;
      while (paramInt1 < 150)
      {
        ParticleSystem.Particle localParticle = new ParticleSystem.Particle();
        a(f1 * 0.5F, f2 * 0.4F, localParticle);
        this.g.add(localParticle);
        paramInt1 += 1;
      }
    }
    if ((this.c & 0x2) == 2)
    {
      paramInt1 = paramInt2;
      while (paramInt1 < 40)
      {
        d();
        paramInt1 += 1;
      }
    }
    a();
  }
  
  public void a(Canvas paramCanvas)
  {
    int i1 = this.g.size() - 1;
    while (i1 >= 0)
    {
      localObject = (ParticleSystem.Particle)this.g.get(i1);
      if (!a((ParticleSystem.Particle)localObject))
      {
        this.g.remove(i1);
        if ((localObject != null) && (this.h < this.d))
        {
          this.e.add(localObject);
          this.h += 1;
        }
      }
      i1 -= 1;
    }
    Object localObject = this.s;
    i1 = 0;
    while (i1 < this.g.size())
    {
      ParticleSystem.Particle localParticle = (ParticleSystem.Particle)this.g.get(i1);
      if (localParticle != null)
      {
        this.a.setAlpha((int)(this.b * localParticle.k * 2.0F * 255.0F) % 256);
        ((Rect)localObject).left = ((int)(localParticle.d - localParticle.i * 0.5F));
        ((Rect)localObject).top = ((int)(localParticle.e - localParticle.i * 0.5F));
        ((Rect)localObject).bottom = (((Rect)localObject).top + localParticle.i);
        ((Rect)localObject).right = (((Rect)localObject).left + localParticle.i);
        paramCanvas.drawBitmap(this.l[localParticle.h], null, (Rect)localObject, this.a);
        localParticle.d += localParticle.f;
        localParticle.e += localParticle.g;
        localParticle.f *= 0.98F;
        localParticle.g = (localParticle.g * 0.98F + this.m);
        localParticle.k *= localParticle.l;
      }
      i1 += 1;
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt)
  {
    if (this.b <= 0.05F) {
      return;
    }
    if ((paramInt == 1) && ((this.c & 0x1) == 1) && (this.g.size() > 0)) {
      a(paramCanvas);
    }
    if ((paramInt == 2) && ((this.c & 0x2) == 2)) {
      b(paramCanvas);
    }
  }
  
  public boolean a(ParticleSystem.Particle paramParticle)
  {
    boolean bool2 = false;
    if (paramParticle == null) {
      return false;
    }
    if (paramParticle.i < 1) {
      return false;
    }
    if (paramParticle.k <= 0.05F) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramParticle.d + paramParticle.i * 0.5F >= 0.0F)
    {
      bool1 = bool2;
      if (paramParticle.e + paramParticle.i * 0.5F >= 0.0F)
      {
        bool1 = bool2;
        if (paramParticle.d - paramParticle.i * 0.5F <= this.i)
        {
          if (paramParticle.e - paramParticle.i * 0.5F > this.j) {
            return false;
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    ValueAnimator localValueAnimator = this.t;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.t.removeUpdateListener(this);
      this.t.removeAllUpdateListeners();
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    int i1 = this.f.size() - 1;
    while (i1 >= 0)
    {
      localObject = (ParticleSystem.Particle)this.f.get(i1);
      if (!a((ParticleSystem.Particle)localObject))
      {
        this.f.remove(i1);
        if (localObject != null) {
          this.e.add(localObject);
        }
      }
      i1 -= 1;
    }
    if (Math.abs(SystemClock.elapsedRealtime() - this.k) > 64L)
    {
      this.k = SystemClock.elapsedRealtime();
      d();
    }
    Object localObject = this.s;
    i1 = 0;
    while (i1 < this.f.size())
    {
      ParticleSystem.Particle localParticle = (ParticleSystem.Particle)this.f.get(i1);
      if (localParticle != null)
      {
        double d1 = Math.cos(localParticle.m);
        double d2 = localParticle.k;
        Double.isNaN(d2);
        float f1 = (float)Math.abs(d1 * d2);
        if (f1 >= 0.01F)
        {
          this.a.setAlpha((int)(this.b * f1 * 255.0F));
          d1 = Math.cos(localParticle.p);
          d2 = localParticle.o;
          Double.isNaN(d2);
          double d3 = localParticle.d - localParticle.i * 0.5F;
          Double.isNaN(d3);
          ((Rect)localObject).left = ((int)(d3 + d1 * d2));
          ((Rect)localObject).top = ((int)(localParticle.e - localParticle.i * 0.5F));
          ((Rect)localObject).bottom = (((Rect)localObject).top + localParticle.i);
          ((Rect)localObject).right = (((Rect)localObject).left + localParticle.i);
          paramCanvas.drawBitmap(this.l[localParticle.h], null, (Rect)localObject, this.a);
        }
        localParticle.d += localParticle.f;
        localParticle.e += localParticle.g;
        localParticle.k *= localParticle.l;
        localParticle.m += localParticle.n;
        localParticle.p += localParticle.q;
      }
      i1 += 1;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ParticleSystem", 2, "destroy");
    }
    b();
    this.u = null;
  }
  
  public void d()
  {
    int i1 = this.p;
    double d2 = a(i1, -i1);
    i1 = this.p;
    double d1 = a(i1, -i1);
    double d3 = Math.random();
    double d4 = this.l.length;
    Double.isNaN(d4);
    i1 = (int)(d3 * d4);
    float f1 = this.i;
    float f2 = this.j;
    Object localObject;
    if (this.h < this.d)
    {
      localObject = new ParticleSystem.Particle();
      this.h += 1;
    }
    else if (this.e.size() > 0)
    {
      localObject = this.e;
      localObject = (ParticleSystem.Particle)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
    }
    else
    {
      localObject = null;
    }
    if (localObject != null)
    {
      d3 = f1 * 0.5F;
      Double.isNaN(d3);
      ((ParticleSystem.Particle)localObject).d = ((float)(d2 + d3));
      d2 = f2 * 0.4F;
      Double.isNaN(d2);
      ((ParticleSystem.Particle)localObject).e = ((float)(d1 + d2));
      ((ParticleSystem.Particle)localObject).f = 0.0F;
      ((ParticleSystem.Particle)localObject).g = ((float)a(-1.0D, -2.0D));
      ((ParticleSystem.Particle)localObject).h = i1;
      ((ParticleSystem.Particle)localObject).i = ((int)a(this.o, this.n));
      ((ParticleSystem.Particle)localObject).j = ((float)a(0.9950000047683716D, 0.9980000257492065D));
      ((ParticleSystem.Particle)localObject).k = ((float)a(1.0D, 1.0D));
      ((ParticleSystem.Particle)localObject).l = ((float)a(0.9900000095367432D, 0.9800000190734863D));
      ((ParticleSystem.Particle)localObject).m = ((float)a(0.0D, 3.141592653589793D));
      ((ParticleSystem.Particle)localObject).n = ((float)a(0.01D, 0.001D));
      ((ParticleSystem.Particle)localObject).o = ((float)a(20.0D, 5.0D));
      ((ParticleSystem.Particle)localObject).p = ((float)a(0.0D, 3.141592653589793D));
      ((ParticleSystem.Particle)localObject).q = ((float)a(0.01D, 0.1D));
      ((ParticleSystem.Particle)localObject).c = SystemClock.elapsedRealtime();
      this.f.add(localObject);
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.u;
    if (paramValueAnimator != null) {
      paramValueAnimator.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.ParticleSystem
 * JD-Core Version:    0.7.0.1
 */