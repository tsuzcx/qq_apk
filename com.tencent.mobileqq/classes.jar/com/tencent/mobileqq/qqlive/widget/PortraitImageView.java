package com.tencent.mobileqq.qqlive.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

@SuppressLint({"NewApi"})
public class PortraitImageView
  extends View
{
  private static int I = 20;
  private Bitmap A;
  private int B = -1;
  private int C = -1;
  private float D;
  private Runnable E = null;
  private Runnable F = null;
  private double G = 0.0D;
  private GestureDetector H;
  private float J;
  private float K;
  private float L;
  private float M;
  private int N = -1;
  Runnable a = null;
  ScaleGestureDetector b;
  RectF c = new RectF();
  int d;
  int e;
  RectF f = new RectF();
  RectF g = new RectF();
  float h;
  RegionView i;
  PortraitImageView.OnImageTouchedListener j;
  PortraitImageView.OnDragOccurListener k;
  int l;
  int m;
  int n;
  int o;
  int p = 0;
  int q;
  float r;
  boolean s = false;
  private Matrix t = new Matrix();
  private Matrix u = new Matrix();
  private Matrix v = new Matrix();
  private Matrix w = new Matrix();
  private Matrix x = new Matrix();
  private Paint y;
  private float[] z = new float[9];
  
  public PortraitImageView(Context paramContext)
  {
    this(paramContext, null);
    this.h = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public PortraitImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PortraitImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(RectF paramRectF1, RectF paramRectF2)
  {
    if (paramRectF1.left > paramRectF2.left) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i1 = i2;
    if (paramRectF1.right < paramRectF2.right) {
      i1 = i2 | 0x2;
    }
    int i2 = i1;
    if (paramRectF1.top > paramRectF2.top) {
      i2 = i1 | 0x4;
    }
    i1 = i2;
    if (paramRectF1.bottom < paramRectF2.bottom) {
      i1 = i2 | 0x8;
    }
    return i1;
  }
  
  private void a(Context paramContext)
  {
    this.y = new Paint();
    this.y.setDither(true);
    this.y.setFilterBitmap(true);
    this.y.setAntiAlias(true);
    this.F = new PortraitImageView.1(this);
    this.b = new ScaleGestureDetector(paramContext, new PortraitImageView.ScaleListener(this));
    this.H = new GestureDetector(paramContext, new PortraitImageView.MyGestureListener(this, null));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
  }
  
  private void a(Bitmap paramBitmap, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    paramMatrix.reset();
    float f3 = this.l / paramBitmap.getWidth();
    float f4 = this.m / paramBitmap.getHeight();
    if ((f3 < 1.0F) && (f4 < 1.0F))
    {
      float f5 = f1 / paramBitmap.getWidth();
      float f6 = f2 / paramBitmap.getHeight();
      this.r = Math.min(f5, f5);
      float f7 = this.r;
      if ((f7 < 1.0F) && ((f7 < f3) || (f7 < f4))) {
        this.r = Math.max(f5, f6);
      }
    }
    else
    {
      this.r = Math.max(f3, f4);
    }
    f3 = this.r;
    paramMatrix.setScale(f3, f3);
    paramMatrix.postTranslate((f1 - paramBitmap.getWidth() * this.r) / 2.0F, (f2 - paramBitmap.getHeight() * this.r) / 2.0F);
    RectF localRectF = this.f;
    localRectF.left = 0.0F;
    localRectF.right = (localRectF.left + paramBitmap.getWidth());
    localRectF = this.f;
    localRectF.top = 0.0F;
    localRectF.bottom = (localRectF.top + paramBitmap.getHeight());
    paramMatrix.mapRect(this.f);
  }
  
  protected float a()
  {
    Bitmap localBitmap = this.A;
    if (localBitmap == null) {
      return 1.0F;
    }
    return Math.max(localBitmap.getWidth() / this.B, this.A.getHeight() / this.C) * 16.0F;
  }
  
  float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 / paramFloat4 - 1.0F;
    return paramFloat3 * (paramFloat1 * paramFloat1 * paramFloat1 + 1.0F) + paramFloat2;
  }
  
  protected float a(Matrix paramMatrix)
  {
    if (this.A != null) {
      return a(paramMatrix, 0);
    }
    return 1.0F;
  }
  
  protected float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.z);
    return this.z[paramInt];
  }
  
  protected void a(float paramFloat1, float paramFloat2)
  {
    this.x.set(this.u);
    this.x.postTranslate(paramFloat1, paramFloat2);
    this.x.mapRect(this.g, this.f);
    int i1 = a(this.g, this.c);
    int i2 = i1 & 0x1;
    if ((i2 == 0) && ((i1 & 0x2) == 0)) {
      this.u.postTranslate(paramFloat1, 0.0F);
    } else if ((i2 != 0) && (paramFloat1 < 0.0F) && (this.g.right > this.c.right)) {
      this.u.postTranslate(paramFloat1, 0.0F);
    } else if (((i1 & 0x2) != 0) && (paramFloat1 > 0.0F) && (this.g.left < this.c.left)) {
      this.u.postTranslate(paramFloat1, 0.0F);
    }
    i2 = i1 & 0x4;
    if ((i2 == 0) && ((i1 & 0x8) == 0))
    {
      this.u.postTranslate(0.0F, paramFloat2);
      return;
    }
    if ((i2 != 0) && (paramFloat2 < 0.0F) && (this.g.bottom > this.c.bottom))
    {
      this.u.postTranslate(0.0F, paramFloat2);
      return;
    }
    if (((i1 & 0x8) != 0) && (paramFloat2 > 0.0F) && (this.g.top < this.c.top)) {
      this.u.postTranslate(0.0F, paramFloat2);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = this.D;
    float f1 = paramFloat1;
    if (paramFloat1 > f2) {
      f1 = f2;
    }
    b(f1 / getScale(), paramFloat2, paramFloat3);
    setImageMatrix(getImageViewMatrix());
  }
  
  protected void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x.set(this.u);
    this.x.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    this.x.mapRect(this.g, this.f);
    if (a(this.g, this.c) == 0)
    {
      this.u.set(this.x);
      return;
    }
    if ((this.g.width() / this.c.width() >= 1.0F) && (this.g.height() / this.c.height() >= 1.0F))
    {
      this.u.set(this.x);
      paramFloat1 = this.g.left;
      paramFloat2 = this.c.left;
      paramFloat3 = 0.0F;
      if (paramFloat1 > paramFloat2) {
        paramFloat1 = this.c.left;
      }
      for (paramFloat2 = this.g.left;; paramFloat2 = this.g.right)
      {
        paramFloat1 -= paramFloat2;
        break label203;
        if (this.g.right >= this.c.right) {
          break;
        }
        paramFloat1 = this.c.right;
      }
      paramFloat1 = 0.0F;
      label203:
      if (this.g.top > this.c.top) {
        paramFloat2 = this.c.top;
      }
      for (paramFloat3 = this.g.top;; paramFloat3 = this.g.bottom)
      {
        paramFloat2 -= paramFloat3;
        break;
        paramFloat2 = paramFloat3;
        if (this.g.bottom >= this.c.bottom) {
          break;
        }
        paramFloat2 = this.c.bottom;
      }
      a(paramFloat1, paramFloat2);
    }
  }
  
  public int getClipHeight()
  {
    return this.m;
  }
  
  public int getClipWidth()
  {
    return this.l;
  }
  
  public Bitmap getImageBitmap()
  {
    return this.A;
  }
  
  public Matrix getImageViewMatrix()
  {
    this.v.set(this.t);
    this.v.postConcat(this.u);
    return this.v;
  }
  
  public float getImageViewScale()
  {
    return a(getImageViewMatrix());
  }
  
  public Matrix getMMatrix()
  {
    this.v.reset();
    this.v.set(this.t);
    this.v.postConcat(this.u);
    return this.v;
  }
  
  public float getPosX()
  {
    return this.J;
  }
  
  public float getPosY()
  {
    return this.K;
  }
  
  public RectF getRestrictRect()
  {
    return this.c;
  }
  
  public float getScale()
  {
    return a(this.u);
  }
  
  public float getTransX()
  {
    return a(getImageViewMatrix(), 2);
  }
  
  public float getTransY()
  {
    return a(getImageViewMatrix(), 5);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = paramCanvas.save();
    Bitmap localBitmap = this.A;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      if ((Build.VERSION.SDK_INT >= 11) && (getLayerType() == 2))
      {
        paramCanvas.drawBitmap(this.A, this.w, null);
      }
      else
      {
        double d1 = System.currentTimeMillis();
        double d2 = this.G;
        Double.isNaN(d1);
        if (d1 - d2 > 250.0D)
        {
          paramCanvas.drawBitmap(this.A, this.w, this.y);
          this.G = System.currentTimeMillis();
        }
        else
        {
          paramCanvas.drawBitmap(this.A, this.w, null);
          removeCallbacks(this.F);
          postDelayed(this.F, 250L);
        }
      }
    }
    paramCanvas.restoreToCount(i1);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.B = (paramInt3 - paramInt1);
    this.C = (paramInt4 - paramInt2);
    Object localObject = this.E;
    if (localObject != null)
    {
      this.E = null;
      ((Runnable)localObject).run();
    }
    localObject = this.A;
    if (localObject != null)
    {
      a((Bitmap)localObject, this.t);
      setImageMatrix(getImageViewMatrix());
    }
    this.d = (getWidth() / 2);
    this.e = (getHeight() / 2);
    setRestrict(this.n, this.o, this.p, this.q);
    paramInt1 = this.p;
    if (paramInt1 == 0)
    {
      localObject = this.c;
      paramInt1 = this.d;
      paramInt2 = this.l;
      ((RectF)localObject).left = (paramInt1 - paramInt2 / 2);
      ((RectF)localObject).right = (paramInt1 + paramInt2 / 2);
    }
    else
    {
      localObject = this.c;
      ((RectF)localObject).left = paramInt1;
      ((RectF)localObject).right = (paramInt1 + this.l);
    }
    paramInt1 = this.q;
    if (paramInt1 == 0)
    {
      localObject = this.c;
      paramInt1 = this.e;
      paramInt2 = this.m;
      ((RectF)localObject).top = (paramInt1 - paramInt2 / 2);
      ((RectF)localObject).bottom = (paramInt1 + paramInt2 / 2);
      return;
    }
    localObject = this.c;
    ((RectF)localObject).top = paramInt1;
    ((RectF)localObject).bottom = (paramInt1 + this.m);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.A != null)
    {
      this.b.onTouchEvent(paramMotionEvent);
      if (!this.b.isInProgress()) {
        this.H.onTouchEvent(paramMotionEvent);
      }
      int i2 = paramMotionEvent.getAction() & 0xFF;
      int i1 = 0;
      float f1;
      float f2;
      if (i2 != 0)
      {
        if (i2 != 1)
        {
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if (i2 != 6) {
                return true;
              }
              i2 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
              if (paramMotionEvent.getPointerId(i2) == this.N)
              {
                if (i2 == 0) {
                  i1 = 1;
                }
                this.L = paramMotionEvent.getX(i1);
                this.M = paramMotionEvent.getY(i1);
                this.N = paramMotionEvent.getPointerId(i1);
                return true;
              }
            }
            else
            {
              this.N = -1;
              return true;
            }
          }
          else
          {
            i1 = paramMotionEvent.findPointerIndex(this.N);
            if ((i1 != -1) && (i1 < paramMotionEvent.getPointerCount()))
            {
              f1 = paramMotionEvent.getX(i1);
              f2 = paramMotionEvent.getY(i1);
              if (!this.b.isInProgress())
              {
                float f3 = this.L;
                float f4 = this.M;
                this.J += f1 - f3;
                this.K += f2 - f4;
                invalidate();
              }
              this.L = f1;
              this.M = f2;
              return true;
            }
          }
        }
        else
        {
          this.N = -1;
          return true;
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.L = f1;
        this.M = f2;
        this.N = paramMotionEvent.getPointerId(0);
      }
    }
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (getWidth() <= 0)
    {
      this.E = new PortraitImageView.2(this, paramBitmap);
      return;
    }
    if (paramBitmap != null)
    {
      a(paramBitmap, this.t);
      this.A = paramBitmap;
    }
    else
    {
      this.t.reset();
      this.A = paramBitmap;
    }
    this.u.reset();
    setImageMatrix(getImageViewMatrix());
    this.D = a();
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix != null)
    {
      localMatrix = paramMatrix;
      if (paramMatrix.isIdentity()) {
        localMatrix = null;
      }
    }
    if (((localMatrix == null) && (!this.w.isIdentity())) || ((localMatrix != null) && (!this.w.equals(localMatrix))))
    {
      this.w.set(localMatrix);
      invalidate();
    }
  }
  
  public void setOnDragOccurListener(PortraitImageView.OnDragOccurListener paramOnDragOccurListener)
  {
    this.k = paramOnDragOccurListener;
  }
  
  public void setOnImageTouchedListener(PortraitImageView.OnImageTouchedListener paramOnImageTouchedListener)
  {
    this.j = paramOnImageTouchedListener;
  }
  
  public void setRegionView(RegionView paramRegionView)
  {
    this.i = paramRegionView;
  }
  
  public void setRestrict(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = paramInt3;
    this.q = paramInt4;
    paramInt1 = this.B;
    if ((paramInt1 > 0) && ((this.n > paramInt1) || (this.o > this.C)))
    {
      float f2 = this.B;
      paramInt2 = I;
      float f3 = paramInt2;
      float f1 = this.h;
      paramInt1 = this.n;
      f2 = (f2 - f3 * f1) / paramInt1;
      f3 = this.C;
      float f4 = paramInt2;
      paramInt2 = this.o;
      f1 = (f3 - f4 * f1) / paramInt2;
      if (f2 <= f1)
      {
        this.l = ((int)(paramInt1 * f2));
        this.m = ((int)(paramInt2 * f2));
        return;
      }
      this.l = ((int)(paramInt1 * f1));
      this.m = ((int)(paramInt2 * f1));
      return;
    }
    this.l = this.n;
    this.m = this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.widget.PortraitImageView
 * JD-Core Version:    0.7.0.1
 */