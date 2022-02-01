package com.tencent.mobileqq.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SingleTouchLayout
  extends FrameLayout
{
  int A = -1;
  int B = 1;
  boolean C = true;
  boolean D = true;
  DisplayMetrics E;
  PointF F = new PointF();
  PointF G = new PointF();
  int H;
  int I;
  View J;
  int K = 2;
  int L = 0;
  boolean M = false;
  boolean N = true;
  public int O = 0;
  boolean P = false;
  public int Q;
  public int R;
  public SingleTouchLayout.SingleTapListener S;
  float T;
  float U;
  long V;
  private PointF W = new PointF();
  private float Z = 0.0F;
  public float a = 4.0F;
  private float aa = 1.0F;
  private int ab;
  private int ac;
  public float b = 0.3F;
  public int c;
  public int d;
  public int e;
  public int f;
  public Point g;
  public Point h;
  public Point i;
  public Point j;
  Point k = new Point();
  Point l = new Point();
  Rect m = new Rect();
  Matrix n = new Matrix();
  Bitmap o;
  Bitmap p;
  Bitmap q;
  Bitmap r;
  public int s;
  public int t;
  Path u = new Path();
  Paint v;
  float w;
  float x;
  int y = 0;
  int z = 8;
  
  public SingleTouchLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SingleTouchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SingleTouchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
    a();
  }
  
  public static double a(double paramDouble)
  {
    return paramDouble * 180.0D / 3.141592653589793D;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, float paramFloat)
  {
    Point localPoint = new Point();
    paramPoint2.x -= paramPoint1.x;
    paramPoint2.y -= paramPoint1.y;
    paramPoint2 = new Point();
    double d3 = Math.sqrt(localPoint.x * localPoint.x + localPoint.y * localPoint.y);
    if ((localPoint.x == 0) && (localPoint.y == 0)) {
      return paramPoint1;
    }
    if ((localPoint.x >= 0) && (localPoint.y >= 0))
    {
      d1 = localPoint.y;
      Double.isNaN(d1);
      d1 = Math.asin(d1 / d3);
    }
    else
    {
      if ((localPoint.x < 0) && (localPoint.y >= 0))
      {
        d1 = Math.abs(localPoint.x);
        Double.isNaN(d1);
        d1 = Math.asin(d1 / d3);
        d2 = 1.570796326794897D;
      }
      for (;;)
      {
        d1 += d2;
        break label276;
        if ((localPoint.x < 0) && (localPoint.y < 0))
        {
          d1 = Math.abs(localPoint.y);
          Double.isNaN(d1);
          d1 = Math.asin(d1 / d3);
          d2 = 3.141592653589793D;
        }
        else
        {
          if ((localPoint.x < 0) || (localPoint.y >= 0)) {
            break;
          }
          d1 = localPoint.x;
          Double.isNaN(d1);
          d1 = Math.asin(d1 / d3);
          d2 = 4.71238898038469D;
        }
      }
      d1 = 0.0D;
    }
    label276:
    double d1 = a(d1);
    double d2 = paramFloat;
    Double.isNaN(d2);
    d1 = b(d1 + d2);
    paramPoint2.x = ((int)Math.round(Math.cos(d1) * d3));
    paramPoint2.y = ((int)Math.round(d3 * Math.sin(d1)));
    paramPoint2.x += paramPoint1.x;
    paramPoint2.y += paramPoint1.y;
    return paramPoint2;
  }
  
  public static double b(double paramDouble)
  {
    return paramDouble * 3.141592653589793D / 180.0D;
  }
  
  double a(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public int a(Integer... paramVarArgs)
  {
    paramVarArgs = Arrays.asList(paramVarArgs);
    Collections.sort(paramVarArgs);
    return ((Integer)paramVarArgs.get(paramVarArgs.size() - 1)).intValue();
  }
  
  Point a(int paramInt, SingleTouchLayout.ComputeResult paramComputeResult)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramComputeResult.a;
          }
          return paramComputeResult.d;
        }
        return paramComputeResult.c;
      }
      return paramComputeResult.b;
    }
    return paramComputeResult.a;
  }
  
  SingleTouchLayout.ComputeResult a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    Point localPoint1 = new Point(paramInt1, paramInt2);
    Point localPoint2 = new Point(paramInt3, paramInt2);
    Point localPoint3 = new Point(paramInt3, paramInt4);
    Point localPoint4 = new Point(paramInt1, paramInt4);
    Point localPoint5 = new Point((paramInt1 + paramInt3) / 2, (paramInt2 + paramInt4) / 2);
    SingleTouchLayout.ComputeResult localComputeResult = new SingleTouchLayout.ComputeResult(this);
    localComputeResult.a = a(localPoint5, localPoint1, paramFloat);
    localComputeResult.b = a(localPoint5, localPoint2, paramFloat);
    localComputeResult.c = a(localPoint5, localPoint3, paramFloat);
    localComputeResult.d = a(localPoint5, localPoint4, paramFloat);
    paramInt1 = a(new Integer[] { Integer.valueOf(localComputeResult.a.x), Integer.valueOf(localComputeResult.b.x), Integer.valueOf(localComputeResult.c.x), Integer.valueOf(localComputeResult.d.x) });
    paramInt2 = b(new Integer[] { Integer.valueOf(localComputeResult.a.x), Integer.valueOf(localComputeResult.b.x), Integer.valueOf(localComputeResult.c.x), Integer.valueOf(localComputeResult.d.x) });
    localComputeResult.g = (paramInt1 - paramInt2);
    paramInt3 = a(new Integer[] { Integer.valueOf(localComputeResult.a.y), Integer.valueOf(localComputeResult.b.y), Integer.valueOf(localComputeResult.c.y), Integer.valueOf(localComputeResult.d.y) });
    paramInt4 = b(new Integer[] { Integer.valueOf(localComputeResult.a.y), Integer.valueOf(localComputeResult.b.y), Integer.valueOf(localComputeResult.c.y), Integer.valueOf(localComputeResult.d.y) });
    localComputeResult.h = (paramInt3 - paramInt4);
    localPoint1 = new Point((paramInt1 + paramInt2) / 2, (paramInt3 + paramInt4) / 2);
    localComputeResult.i = (localComputeResult.g / 2 - localPoint1.x);
    localComputeResult.j = (localComputeResult.h / 2 - localPoint1.y);
    paramInt1 = this.s / 2;
    paramInt2 = this.t / 2;
    localPoint1 = localComputeResult.a;
    localPoint1.x += localComputeResult.i + paramInt1;
    localPoint1 = localComputeResult.b;
    localPoint1.x += localComputeResult.i + paramInt1;
    localPoint1 = localComputeResult.c;
    localPoint1.x += localComputeResult.i + paramInt1;
    localPoint1 = localComputeResult.d;
    localPoint1.x += localComputeResult.i + paramInt1;
    localPoint1 = localComputeResult.a;
    localPoint1.y += localComputeResult.j + paramInt2;
    localPoint1 = localComputeResult.b;
    localPoint1.y += localComputeResult.j + paramInt2;
    localPoint1 = localComputeResult.c;
    localPoint1.y += localComputeResult.j + paramInt2;
    localPoint1 = localComputeResult.d;
    localPoint1.y += localComputeResult.j + paramInt2;
    localComputeResult.e = a(this.K, localComputeResult);
    localComputeResult.f = a(this.L, localComputeResult);
    return localComputeResult;
  }
  
  void a()
  {
    setWillNotDraw(false);
    this.v = new Paint();
    this.v.setAntiAlias(true);
    this.v.setDither(true);
    this.v.setColor(this.A);
    this.v.setStrokeWidth(this.B);
    this.v.setStyle(Paint.Style.STROKE);
    this.w = AIOUtils.b(2.0F, getResources());
    this.x = AIOUtils.b(1.0F, getResources());
    this.v.setShadowLayer(this.w, 0.0F, this.x, -16777216);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = getResources().getDisplayMetrics().densityDpi;
    if (this.o == null) {}
    try
    {
      this.o = BitmapFactory.decodeResource(getResources(), 2130849303, localOptions);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label164:
      break label164;
    }
    QLog.e("SingleTouchLayout", 1, "controlDrawable decode failed");
    if (this.q == null) {}
    try
    {
      this.q = BitmapFactory.decodeResource(getResources(), 2130849304, localOptions);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label199:
      break label199;
    }
    QLog.e("SingleTouchLayout", 1, "deleteDrawable decode failed");
    setIconSize(this.o.getWidth(), this.o.getHeight());
    c();
  }
  
  void a(AttributeSet paramAttributeSet)
  {
    this.E = getContext().getResources().getDisplayMetrics();
    this.z = ((int)TypedValue.applyDimension(1, 8.0F, this.E));
    this.B = ((int)TypedValue.applyDimension(1, 1.0F, this.E));
    this.A = -1;
    this.aa = 1.0F;
    this.Z = 0.0F;
    this.K = 2;
    this.L = 0;
    this.C = true;
  }
  
  @TargetApi(11)
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.J == null) {
      return true;
    }
    if ((this.Q > 0) && (this.R > 0)) {
      this.P = true;
    }
    int i1 = (int)(this.Q * paramFloat1);
    int i2 = (int)(this.R * paramFloat1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("transformDraw(): mActualViewWidth=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", mActualViewHeight=");
      ((StringBuilder)localObject).append(i2);
      QLog.d("SingleTouchLayout", 2, ((StringBuilder)localObject).toString());
    }
    int i3 = this.z;
    Object localObject = a(-i3, -i3, i1 + i3, i2 + i3, paramFloat2);
    if ((!a(((SingleTouchLayout.ComputeResult)localObject).g, ((SingleTouchLayout.ComputeResult)localObject).h)) && (this.P) && (this.W.x != 0.0F) && (this.W.y != 0.0F) && (this.C)) {
      return false;
    }
    this.g = ((SingleTouchLayout.ComputeResult)localObject).a;
    this.h = ((SingleTouchLayout.ComputeResult)localObject).b;
    this.i = ((SingleTouchLayout.ComputeResult)localObject).c;
    this.j = ((SingleTouchLayout.ComputeResult)localObject).d;
    this.k = ((SingleTouchLayout.ComputeResult)localObject).e;
    this.l = ((SingleTouchLayout.ComputeResult)localObject).f;
    this.c = ((SingleTouchLayout.ComputeResult)localObject).g;
    this.d = ((SingleTouchLayout.ComputeResult)localObject).h;
    this.H = ((SingleTouchLayout.ComputeResult)localObject).i;
    this.I = ((SingleTouchLayout.ComputeResult)localObject).j;
    localObject = (FrameLayout.LayoutParams)this.J.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = ((this.c + this.s - this.J.getWidth()) / 2);
    ((FrameLayout.LayoutParams)localObject).topMargin = ((this.d + this.t - this.J.getHeight()) / 2);
    this.J.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.J.setScaleX(paramFloat1);
    this.J.setScaleY(paramFloat1);
    this.J.setRotation(paramFloat2 % 360.0F);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("transformDraw(): mViewWidth=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", mViewHeight=");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("SingleTouchLayout", 2, ((StringBuilder)localObject).toString());
    }
    b();
    return true;
  }
  
  boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 < 10000.0F;
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.M;
    boolean bool1 = true;
    if (bool2)
    {
      paramInt1 += this.s;
      paramInt2 += this.t;
      int i1 = (int)(this.W.x - paramInt1 / 2);
      int i2 = (int)(this.W.y - paramInt2 / 2);
      if (QLog.isColorLevel()) {
        QLog.d("SingleTouchLayout", 2, String.format("inBounds: l=%s, t=%s, w=%s, h=%s, cp.x=%s, cp.y=%s, width=%s, height=%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.W.x), Float.valueOf(this.W.y), Integer.valueOf(this.e), Integer.valueOf(this.e) }));
      }
      if ((i1 >= 0) && (i2 >= 0) && (i1 + paramInt1 <= this.e) && (i2 + paramInt2 <= this.f)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean a(View paramView)
  {
    View localView = this.J;
    if (localView != paramView)
    {
      removeView(localView);
      this.J = paramView;
      addView(this.J, new FrameLayout.LayoutParams(-2, -2));
      return true;
    }
    return false;
  }
  
  public boolean a(View paramView, int paramInt)
  {
    View localView = this.J;
    if (localView != paramView)
    {
      removeView(localView);
      this.J = paramView;
      addView(this.J, new FrameLayout.LayoutParams(paramInt, -2));
      return true;
    }
    return false;
  }
  
  int b(float paramFloat1, float paramFloat2)
  {
    if (a(new PointF(paramFloat1, paramFloat2), new PointF(this.k)) < Math.min(this.s / 2, this.t / 2)) {
      return 2;
    }
    return 1;
  }
  
  public int b(Integer... paramVarArgs)
  {
    paramVarArgs = Arrays.asList(paramVarArgs);
    Collections.sort(paramVarArgs);
    return ((Integer)paramVarArgs.get(0)).intValue();
  }
  
  void b()
  {
    int i1 = this.c + this.s;
    int i2 = this.d + this.t;
    int i3 = (int)(this.W.x - i1 / 2);
    int i4 = (int)(this.W.y - i2 / 2);
    if ((this.ab != i3) || (this.ac != i4))
    {
      this.ab = i3;
      this.ac = i4;
    }
    layout(i3, i4, i1 + i3, i2 + i4);
  }
  
  public void b(View paramView)
  {
    removeView(this.J);
    this.J = paramView;
    addView(this.J, new FrameLayout.LayoutParams(-2, -2));
  }
  
  public boolean c()
  {
    return a(this.aa, this.Z);
  }
  
  boolean c(float paramFloat1, float paramFloat2)
  {
    return a(new PointF(paramFloat1, paramFloat2), new PointF(this.l)) < Math.min(this.s / 2, this.t / 2);
  }
  
  void d()
  {
    this.n.setRotate(this.Z);
    Bitmap localBitmap = this.p;
    if ((localBitmap != null) && (localBitmap != this.o)) {
      localBitmap.recycle();
    }
    localBitmap = this.o;
    this.p = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), this.o.getHeight(), this.n, false);
    localBitmap = this.r;
    if ((localBitmap != null) && (localBitmap != this.q)) {
      localBitmap.recycle();
    }
    localBitmap = this.q;
    this.r = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), this.q.getHeight(), this.n, false);
  }
  
  public View getBindView()
  {
    return this.J;
  }
  
  public PointF getCenterPoint()
  {
    return this.W;
  }
  
  public int getFrameWidth()
  {
    return this.B;
  }
  
  public float getImageDegree()
  {
    return this.Z;
  }
  
  public float getImageScale()
  {
    return this.aa;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = (ViewGroup)getParent();
    if ((this.W.x != 0.0F) && (this.W.y != 0.0F))
    {
      if ((this.e == 0) || (this.f == 0))
      {
        this.e = ((ViewGroup)localObject).getWidth();
        this.f = ((ViewGroup)localObject).getHeight();
        c();
      }
    }
    else
    {
      this.e = ((ViewGroup)localObject).getWidth();
      this.f = ((ViewGroup)localObject).getHeight();
      this.W.set(this.e / 2, this.f / 2);
      c();
    }
    if (!this.P) {
      c();
    }
    super.onDraw(paramCanvas);
    if ((this.C) && (this.g != null) && (this.h != null) && (this.i != null) && (this.j != null) && (this.k != null) && (this.l != null))
    {
      this.u.reset();
      this.u.moveTo(this.g.x, this.g.y);
      this.u.lineTo(this.h.x, this.h.y);
      this.u.lineTo(this.i.x, this.i.y);
      this.u.lineTo(this.j.x, this.j.y);
      this.u.lineTo(this.g.x, this.g.y);
      this.u.lineTo(this.h.x, this.h.y);
      paramCanvas.drawPath(this.u, this.v);
      this.v.setFilterBitmap(true);
      this.m.set(this.k.x - this.s / 2, this.k.y - this.t / 2, this.k.x + this.s / 2, this.k.y + this.t / 2);
      Bitmap localBitmap = this.p;
      localObject = localBitmap;
      if (localBitmap == null) {
        localObject = this.o;
      }
      paramCanvas.drawBitmap((Bitmap)localObject, null, this.m, this.v);
      this.m.set(this.l.x - this.s / 2, this.l.y - this.t / 2, this.l.x + this.s / 2, this.l.y + this.t / 2);
      localBitmap = this.r;
      localObject = localBitmap;
      if (localBitmap == null) {
        localObject = this.q;
      }
      paramCanvas.drawBitmap((Bitmap)localObject, null, this.m, this.v);
      this.v.setFilterBitmap(false);
    }
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.C) && (!this.D)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return true;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ActionMove: x=");
          ((StringBuilder)localObject).append(paramMotionEvent.getX());
          ((StringBuilder)localObject).append(", y=");
          ((StringBuilder)localObject).append(paramMotionEvent.getY());
          QLog.d("SingleTouchLayout", 4, ((StringBuilder)localObject).toString());
        }
        this.G.set(paramMotionEvent.getX() + this.ab, paramMotionEvent.getY() + this.ac);
        i1 = this.y;
        float f1;
        float f2;
        if (i1 == 2)
        {
          if (!this.C) {
            return true;
          }
          i1 = this.J.getWidth() / 2;
          int i2 = this.J.getHeight() / 2;
          double d1 = Math.sqrt(i1 * i1 + i2 * i2);
          double d2 = a(this.W, this.G) / d1;
          f1 = this.b;
          if (d2 <= f1) {}
          do
          {
            d1 = f1;
            break;
            f1 = this.a;
            d1 = d2;
          } while (d2 >= f1);
          if (this.N)
          {
            d2 = a(this.W, this.F);
            double d3 = a(this.F, this.G);
            double d4 = a(this.W, this.G);
            d3 = (d2 * d2 + d4 * d4 - d3 * d3) / (d2 * 2.0D * d4);
            d2 = d3;
            if (d3 >= 1.0D) {
              d2 = 1.0D;
            }
            f2 = (float)a(Math.acos(d2));
            paramMotionEvent = new PointF(this.F.x - this.W.x, this.F.y - this.W.y);
            localObject = new PointF(this.G.x - this.W.x, this.G.y - this.W.y);
            f1 = f2;
            if (paramMotionEvent.x * ((PointF)localObject).y - paramMotionEvent.y * ((PointF)localObject).x < 0.0F) {
              f1 = -f2;
            }
          }
          else
          {
            f1 = 0.0F;
          }
          f2 = (float)d1;
          if (a(f2, this.Z + f1))
          {
            this.Z += f1;
            this.aa = f2;
            if (f1 != 0.0F) {
              d();
            }
            if (QLog.isColorLevel())
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("ActionMove-Zoom: scale=");
              paramMotionEvent.append(this.aa);
              paramMotionEvent.append(", deltaY=");
              paramMotionEvent.append(this.Z);
              QLog.d("SingleTouchLayout", 4, paramMotionEvent.toString());
            }
          }
        }
        else if (i1 == 1)
        {
          if (!this.D) {
            return true;
          }
          f1 = this.G.x - this.F.x;
          f2 = this.G.y - this.F.y;
          if (this.M)
          {
            if ((getLeft() + f1 >= 0.0F) && (getRight() + f1 <= this.e))
            {
              paramMotionEvent = this.W;
              paramMotionEvent.x += f1;
            }
            if ((getTop() + f2 >= 0.0F) && (getBottom() + f2 <= this.f))
            {
              paramMotionEvent = this.W;
              paramMotionEvent.y += f2;
            }
          }
          else
          {
            paramMotionEvent = this.W;
            paramMotionEvent.x += f1;
            paramMotionEvent = this.W;
            paramMotionEvent.y += f2;
          }
          b();
        }
        this.F.set(this.G);
        return true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ActionUp -- (");
      ((StringBuilder)localObject).append(paramMotionEvent.getX());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramMotionEvent.getY());
      ((StringBuilder)localObject).append(")");
      Log.d("SingleTouchLayout", ((StringBuilder)localObject).toString());
      localObject = this.S;
      if ((localObject != null) && (this.C)) {
        if (this.y != 2)
        {
          if ((System.currentTimeMillis() - this.V < 100L) && (a(this.T, this.U, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())))
          {
            if (c(paramMotionEvent.getX(), paramMotionEvent.getY())) {
              this.S.b(this);
            } else {
              this.S.a(this);
            }
          }
          else {
            this.S.a(this, paramMotionEvent.getX() - this.T, paramMotionEvent.getY() - this.U);
          }
        }
        else {
          ((SingleTouchLayout.SingleTapListener)localObject).a(this, this.aa);
        }
      }
      this.y = 0;
      return true;
    }
    this.V = System.currentTimeMillis();
    this.T = paramMotionEvent.getRawX();
    this.U = paramMotionEvent.getRawY();
    this.F.set(paramMotionEvent.getX() + this.ab, paramMotionEvent.getY() + this.ac);
    this.y = b(paramMotionEvent.getX(), paramMotionEvent.getY());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ActionDown -- (");
    ((StringBuilder)localObject).append(paramMotionEvent.getX());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramMotionEvent.getY());
    ((StringBuilder)localObject).append(")");
    Log.d("SingleTouchLayout", ((StringBuilder)localObject).toString());
    return true;
  }
  
  public void setActualViewSize(int paramInt1, int paramInt2)
  {
    if (this.J != null)
    {
      this.Q = paramInt1;
      this.R = paramInt2;
      c();
    }
  }
  
  public void setBoundLimited(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public void setCenterPoint(float paramFloat1, float paramFloat2)
  {
    this.W = new PointF(paramFloat1, paramFloat2);
    b();
  }
  
  public void setEditable(boolean paramBoolean)
  {
    this.C = paramBoolean;
    invalidate();
  }
  
  public void setFrameWidth(int paramInt)
  {
    if (this.B == paramInt) {
      return;
    }
    float f1 = paramInt;
    this.B = ((int)TypedValue.applyDimension(1, f1, this.E));
    this.v.setStrokeWidth(f1);
    invalidate();
  }
  
  public void setIconSize(int paramInt1, int paramInt2)
  {
    this.s = paramInt1;
    this.t = paramInt2;
    c();
  }
  
  public void setImageDegree(float paramFloat)
  {
    if (this.Z != paramFloat)
    {
      this.Z = paramFloat;
      d();
      c();
    }
  }
  
  public void setImageScale(float paramFloat)
  {
    if (this.aa != paramFloat)
    {
      this.aa = paramFloat;
      c();
    }
  }
  
  public void setMovable(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void setRotateEnable(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public void setScaleLimit(float paramFloat1, float paramFloat2)
  {
    this.b = paramFloat1;
    this.a = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.SingleTouchLayout
 * JD-Core Version:    0.7.0.1
 */