package com.tencent.mobileqq.ocr.view.gesture;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.mobileqq.qqocr.impl.R.styleable;

public class Settings
{
  private long A = 300L;
  private int a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private int f;
  private int g;
  private float h = 0.0F;
  private float i = 2.0F;
  private float j = -1.0F;
  private float k = 2.0F;
  private float l;
  private float m;
  private boolean n = false;
  private int o = 17;
  private Settings.Fit p = Settings.Fit.INSIDE;
  private Settings.Bounds q = Settings.Bounds.NORMAL;
  private boolean r = true;
  private boolean s = true;
  private boolean t = true;
  private boolean u = false;
  private boolean v = false;
  private boolean w = true;
  private Settings.ExitType x = Settings.ExitType.ALL;
  private int y;
  private int z;
  
  public long A()
  {
    return this.A;
  }
  
  public boolean B()
  {
    return (y()) && ((this.r) || (this.t) || (this.u) || (this.w));
  }
  
  public boolean C()
  {
    return (this.f != 0) && (this.g != 0);
  }
  
  public boolean D()
  {
    return (this.a != 0) && (this.b != 0);
  }
  
  public Settings a()
  {
    this.y += 1;
    return this;
  }
  
  public Settings a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public Settings a(boolean paramBoolean)
  {
    this.s = paramBoolean;
    return this;
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.al);
    this.c = paramAttributeSet.getDimensionPixelSize(R.styleable.aA, this.c);
    this.d = paramAttributeSet.getDimensionPixelSize(R.styleable.az, this.d);
    boolean bool;
    if ((this.c > 0) && (this.d > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    this.h = paramAttributeSet.getFloat(R.styleable.ay, this.h);
    this.i = paramAttributeSet.getFloat(R.styleable.ax, this.i);
    this.j = paramAttributeSet.getFloat(R.styleable.ar, this.j);
    this.k = paramAttributeSet.getFloat(R.styleable.aD, this.k);
    this.l = paramAttributeSet.getDimension(R.styleable.aB, this.l);
    this.m = paramAttributeSet.getDimension(R.styleable.aC, this.m);
    this.n = paramAttributeSet.getBoolean(R.styleable.at, this.n);
    this.o = paramAttributeSet.getInt(R.styleable.aw, this.o);
    int i1 = paramAttributeSet.getInteger(R.styleable.au, this.p.ordinal());
    this.p = Settings.Fit.values()[i1];
    i1 = paramAttributeSet.getInteger(R.styleable.an, this.q.ordinal());
    this.q = Settings.Bounds.values()[i1];
    this.r = paramAttributeSet.getBoolean(R.styleable.aE, this.r);
    this.s = paramAttributeSet.getBoolean(R.styleable.av, this.s);
    this.t = paramAttributeSet.getBoolean(R.styleable.aH, this.t);
    this.u = paramAttributeSet.getBoolean(R.styleable.aG, this.u);
    this.v = paramAttributeSet.getBoolean(R.styleable.aF, this.v);
    this.w = paramAttributeSet.getBoolean(R.styleable.aq, this.w);
    if (paramAttributeSet.getBoolean(R.styleable.as, true)) {
      paramContext = this.x;
    } else {
      paramContext = Settings.ExitType.NONE;
    }
    this.x = paramContext;
    this.A = paramAttributeSet.getInt(R.styleable.am, (int)this.A);
    if (paramAttributeSet.getBoolean(R.styleable.ap, false)) {
      a();
    }
    if (paramAttributeSet.getBoolean(R.styleable.ao, false)) {
      b();
    }
    paramAttributeSet.recycle();
  }
  
  public Settings b()
  {
    this.z += 1;
    return this;
  }
  
  public Settings b(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    return this;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public int e()
  {
    if (this.e) {
      return this.c;
    }
    return this.a;
  }
  
  public int f()
  {
    if (this.e) {
      return this.d;
    }
    return this.b;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public int h()
  {
    return this.g;
  }
  
  public float i()
  {
    return this.h;
  }
  
  public float j()
  {
    return this.i;
  }
  
  public float k()
  {
    return this.j;
  }
  
  public float l()
  {
    return this.k;
  }
  
  public float m()
  {
    return this.l;
  }
  
  public float n()
  {
    return this.m;
  }
  
  public boolean o()
  {
    return this.n;
  }
  
  public int p()
  {
    return this.o;
  }
  
  public Settings.Fit q()
  {
    return this.p;
  }
  
  public Settings.Bounds r()
  {
    return this.q;
  }
  
  public boolean s()
  {
    return (y()) && (this.r);
  }
  
  public boolean t()
  {
    return (y()) && (this.s);
  }
  
  public boolean u()
  {
    return (y()) && (this.t);
  }
  
  public boolean v()
  {
    return (y()) && (this.u);
  }
  
  public boolean w()
  {
    return this.v;
  }
  
  public boolean x()
  {
    return (y()) && (this.w);
  }
  
  public boolean y()
  {
    return this.y <= 0;
  }
  
  public boolean z()
  {
    return this.z <= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.Settings
 * JD-Core Version:    0.7.0.1
 */