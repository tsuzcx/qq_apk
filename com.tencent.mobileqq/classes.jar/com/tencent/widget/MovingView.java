package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class MovingView
  extends View
{
  private boolean A;
  private Paint B;
  Bitmap a;
  Bitmap b;
  MovingView.MatrixParams c;
  MovingView.MatrixParams d;
  Matrix e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  Random l;
  Scroller m;
  int n;
  Point o;
  boolean p;
  boolean q;
  Handler r = new MovingView.1(this, Looper.getMainLooper());
  private float s;
  private float t;
  private int u;
  private long v;
  private int w;
  private int x;
  private int y;
  private int z = 0;
  
  public MovingView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public MovingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public MovingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void a(Bitmap paramBitmap, MovingView.MatrixParams paramMatrixParams)
  {
    float f3 = paramBitmap.getWidth();
    float f4 = paramBitmap.getHeight();
    float f1 = this.s;
    float f5 = f1 / f3;
    float f2 = this.t;
    float f6 = f2 / f4;
    if (f5 > f6) {
      f2 = f4 * f5;
    } else {
      f1 = f3 * f6;
    }
    paramMatrixParams.a = (f1 / f3);
    paramMatrixParams.b = (f2 / f4);
    paramMatrixParams.c = ((this.s - f1) / 2.0F);
    paramMatrixParams.d = ((this.t - f2) / 2.0F);
  }
  
  private Point b(int paramInt1, int paramInt2)
  {
    int i1 = this.l.nextInt(3);
    int i2 = this.n;
    Point localPoint;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 == 3) {
            if (i1 == 0)
            {
              this.n = 1;
              localPoint = this.o;
              localPoint.x = paramInt1;
              localPoint.y = 0;
            }
            else if (i1 == 1)
            {
              this.n = 0;
              localPoint = this.o;
              localPoint.x = paramInt1;
              localPoint.y = paramInt2;
            }
            else if (i1 == 2)
            {
              this.n = 2;
              localPoint = this.o;
              localPoint.x = 0;
              localPoint.y = paramInt2;
            }
          }
        }
        else if (i1 == 0)
        {
          this.n = 3;
          localPoint = this.o;
          localPoint.x = 0;
          localPoint.y = (-paramInt2);
        }
        else if (i1 == 1)
        {
          this.n = 1;
          localPoint = this.o;
          localPoint.x = paramInt1;
          localPoint.y = (-paramInt2);
        }
        else if (i1 == 2)
        {
          this.n = 0;
          localPoint = this.o;
          localPoint.x = paramInt1;
          localPoint.y = 0;
        }
      }
      else if (i1 == 0)
      {
        this.n = 0;
        localPoint = this.o;
        localPoint.x = 0;
        localPoint.y = paramInt2;
      }
      else if (i1 == 1)
      {
        this.n = 2;
        localPoint = this.o;
        localPoint.x = (-paramInt1);
        localPoint.y = paramInt2;
      }
      else if (i1 == 2)
      {
        this.n = 3;
        localPoint = this.o;
        localPoint.x = (-paramInt1);
        localPoint.y = 0;
      }
    }
    else if (i1 == 0)
    {
      this.n = 2;
      localPoint = this.o;
      localPoint.x = (-paramInt1);
      localPoint.y = 0;
    }
    else if (i1 == 1)
    {
      this.n = 3;
      localPoint = this.o;
      localPoint.x = (-paramInt1);
      localPoint.y = (-paramInt2);
    }
    else if (i1 == 2)
    {
      this.n = 1;
      localPoint = this.o;
      localPoint.x = 0;
      localPoint.y = (-paramInt2);
    }
    return this.o;
  }
  
  private void c()
  {
    this.m = new Scroller(getContext(), new LinearInterpolator());
    this.l = new Random(System.currentTimeMillis());
    this.n = 0;
    this.o = new Point(0, 0);
    this.f = 0;
    this.g = 0;
    this.p = false;
    this.u = 2;
    this.B = new Paint();
    this.B.setAntiAlias(true);
    this.B.setFilterBitmap(true);
    this.e = new Matrix();
  }
  
  int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      paramInt1 = -paramInt1;
    }
    if (paramInt2 <= 0) {
      paramInt2 = -paramInt2;
    }
    if (paramInt1 <= paramInt2) {
      paramInt1 = paramInt2;
    }
    return (int)(paramInt1 * 54.700001F);
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "startTranslate");
    }
    int i1 = this.n;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3)
          {
            this.f = (-this.j);
            this.g = (-this.k);
          }
        }
        else
        {
          this.f = (-this.j);
          this.g = 0;
        }
      }
      else
      {
        this.f = 0;
        this.g = (-this.k);
      }
    }
    else
    {
      this.f = 0;
      this.g = 0;
    }
    Point localPoint = b(this.j, this.k);
    this.h = 0;
    this.i = 0;
    this.m.forceFinished(true);
    this.m.startScroll(0, 0, localPoint.x, localPoint.y, a(localPoint.x, localPoint.y));
    this.r.sendEmptyMessage(1);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Bitmap localBitmap = this.b;
      if (localBitmap == paramBitmap)
      {
        this.a = null;
      }
      else
      {
        this.a = localBitmap;
        this.b = paramBitmap;
        if (this.a != null)
        {
          if (this.d == null) {
            this.d = new MovingView.MatrixParams(this);
          }
          this.d.a = this.c.a;
          this.d.b = this.c.b;
          this.d.c = this.c.c;
          this.d.d = this.c.d;
        }
        if (this.c == null) {
          this.c = new MovingView.MatrixParams(this);
        }
        a(paramBitmap, this.c);
      }
      this.y = 1000;
      this.w = 0;
      this.x = 255;
      this.z = 0;
      this.A = true;
      this.u = 0;
      if (this.a == null) {
        this.p = false;
      }
      if (!this.p)
      {
        this.p = true;
        if (!this.r.hasMessages(2)) {
          this.r.sendEmptyMessage(2);
        }
      }
      invalidate();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "startTranslate, bitmap = null");
    }
    clearAnimation();
    postInvalidate();
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "stopTranslate()");
    }
    this.p = false;
    this.r.removeMessages(2);
    this.r.removeMessages(1);
  }
  
  public float getDefaultHeight()
  {
    return this.t;
  }
  
  public float getDefaultWidth()
  {
    return this.s;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i3 = getVisibility();
    int i2 = 0;
    int i1 = 0;
    if (i3 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "onDraw, getVisibility() != View.VISIBLE");
      }
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      return;
    }
    i3 = this.u;
    if (i3 != 0)
    {
      if ((i3 == 1) && (this.v >= 0L))
      {
        float f1 = (float)(SystemClock.uptimeMillis() - this.v) / this.y;
        if (f1 >= 1.0D) {
          i1 = 1;
        }
        i2 = this.w;
        this.z = ((int)(i2 + (this.x - i2) * f1));
      }
      else
      {
        i1 = 1;
      }
    }
    else
    {
      this.v = SystemClock.uptimeMillis();
      this.u = 1;
      i1 = i2;
    }
    if (i1 != 0)
    {
      this.u = 2;
      this.a = null;
      if (this.b != null)
      {
        this.e.reset();
        this.e.postScale(this.c.a, this.c.b);
        this.e.postTranslate(this.c.c + this.f, this.c.d + this.g);
        paramCanvas.drawBitmap(this.b, this.e, this.B);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "onDraw, bitmap = null 1");
      }
      paramCanvas.drawColor(17170445, PorterDuff.Mode.CLEAR);
      return;
    }
    i1 = this.z;
    if (this.a != null)
    {
      boolean bool = this.A;
      if (bool) {
        this.B.setAlpha(255 - i1);
      }
      this.e.reset();
      this.e.postScale(this.d.a, this.d.b);
      this.e.postTranslate(this.d.c + this.f, this.d.d + this.g);
      paramCanvas.drawBitmap(this.a, this.e, this.B);
      if (bool) {
        this.B.setAlpha(255);
      }
    }
    if (i1 > 0) {
      if (this.b != null)
      {
        this.B.setAlpha(i1);
        this.e.reset();
        this.e.postScale(this.c.a, this.c.b);
        this.e.postTranslate(this.c.c + this.f, this.c.d + this.g);
        paramCanvas.drawBitmap(this.b, this.e, this.B);
        this.B.setAlpha(255);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("MovingView", 2, "onDraw, bitmap = null 2");
        }
        paramCanvas.drawColor(17170445, PorterDuff.Mode.CLEAR);
      }
    }
    invalidate();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0)
    {
      b();
    }
    else if (paramInt == 0)
    {
      Bitmap localBitmap = this.b;
      if (localBitmap != null) {
        a(localBitmap);
      } else if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "setVisibility, bitmap = null");
      }
    }
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.MovingView
 * JD-Core Version:    0.7.0.1
 */