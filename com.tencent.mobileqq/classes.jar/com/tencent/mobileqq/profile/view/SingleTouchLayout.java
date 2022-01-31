package com.tencent.mobileqq.profile.view;

import aepi;
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
import awwi;
import awwj;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SingleTouchLayout
  extends FrameLayout
{
  public float a;
  public int a;
  long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  public Point a;
  PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  View jdField_a_of_type_AndroidViewView;
  public awwj a;
  boolean jdField_a_of_type_Boolean = true;
  public float b;
  public int b;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  public Point b;
  PointF jdField_b_of_type_AndroidGraphicsPointF = new PointF();
  boolean jdField_b_of_type_Boolean = true;
  float jdField_c_of_type_Float;
  public int c;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  public Point c;
  private PointF jdField_c_of_type_AndroidGraphicsPointF = new PointF();
  boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float;
  public int d;
  Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  public Point d;
  boolean jdField_d_of_type_Boolean = true;
  float jdField_e_of_type_Float;
  public int e;
  Point jdField_e_of_type_AndroidGraphicsPoint = new Point();
  boolean jdField_e_of_type_Boolean = false;
  float jdField_f_of_type_Float;
  public int f;
  Point jdField_f_of_type_AndroidGraphicsPoint = new Point();
  private float jdField_g_of_type_Float = 0.0F;
  int jdField_g_of_type_Int = 0;
  private float jdField_h_of_type_Float = 1.0F;
  int jdField_h_of_type_Int = 8;
  int i = -1;
  int j = 1;
  int k;
  int l;
  int m = 2;
  int n = 0;
  public int o;
  public int p;
  private int q;
  private int r;
  
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
    this.jdField_a_of_type_Float = 4.0F;
    this.jdField_b_of_type_Float = 0.3F;
    a(paramAttributeSet);
    a();
  }
  
  public static double a(double paramDouble)
  {
    return 180.0D * paramDouble / 3.141592653589793D;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, float paramFloat)
  {
    Point localPoint = new Point();
    paramPoint2.x -= paramPoint1.x;
    paramPoint2.y -= paramPoint1.y;
    double d2 = 0.0D;
    paramPoint2 = new Point();
    double d3 = Math.sqrt(localPoint.x * localPoint.x + localPoint.y * localPoint.y);
    if ((localPoint.x == 0) && (localPoint.y == 0)) {
      return paramPoint1;
    }
    double d1;
    if ((localPoint.x >= 0) && (localPoint.y >= 0)) {
      d1 = Math.asin(localPoint.y / d3);
    }
    for (;;)
    {
      d1 = b(a(d1) + paramFloat);
      paramPoint2.x = ((int)Math.round(Math.cos(d1) * d3));
      paramPoint2.y = ((int)Math.round(Math.sin(d1) * d3));
      paramPoint2.x += paramPoint1.x;
      paramPoint2.y += paramPoint1.y;
      return paramPoint2;
      if ((localPoint.x < 0) && (localPoint.y >= 0))
      {
        d1 = Math.asin(Math.abs(localPoint.x) / d3) + 1.570796326794897D;
      }
      else if ((localPoint.x < 0) && (localPoint.y < 0))
      {
        d1 = Math.asin(Math.abs(localPoint.y) / d3) + 3.141592653589793D;
      }
      else
      {
        d1 = d2;
        if (localPoint.x >= 0)
        {
          d1 = d2;
          if (localPoint.y < 0) {
            d1 = Math.asin(localPoint.x / d3) + 4.71238898038469D;
          }
        }
      }
    }
  }
  
  public static double b(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  double a(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public float a()
  {
    return this.jdField_g_of_type_Float;
  }
  
  int a(float paramFloat1, float paramFloat2)
  {
    if (a(new PointF(paramFloat1, paramFloat2), new PointF(this.jdField_e_of_type_AndroidGraphicsPoint)) < Math.min(this.jdField_e_of_type_Int / 2, this.jdField_f_of_type_Int / 2)) {
      return 2;
    }
    return 1;
  }
  
  public int a(Integer... paramVarArgs)
  {
    paramVarArgs = Arrays.asList(paramVarArgs);
    Collections.sort(paramVarArgs);
    return ((Integer)paramVarArgs.get(paramVarArgs.size() - 1)).intValue();
  }
  
  Point a(int paramInt, awwi paramawwi)
  {
    switch (paramInt)
    {
    default: 
      return paramawwi.jdField_a_of_type_AndroidGraphicsPoint;
    case 0: 
      return paramawwi.jdField_a_of_type_AndroidGraphicsPoint;
    case 1: 
      return paramawwi.jdField_b_of_type_AndroidGraphicsPoint;
    case 2: 
      return paramawwi.jdField_c_of_type_AndroidGraphicsPoint;
    }
    return paramawwi.jdField_d_of_type_AndroidGraphicsPoint;
  }
  
  public PointF a()
  {
    return this.jdField_c_of_type_AndroidGraphicsPointF;
  }
  
  awwi a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    Point localPoint1 = new Point(paramInt1, paramInt2);
    Point localPoint2 = new Point(paramInt3, paramInt2);
    Point localPoint3 = new Point(paramInt3, paramInt4);
    Point localPoint4 = new Point(paramInt1, paramInt4);
    Point localPoint5 = new Point((paramInt1 + paramInt3) / 2, (paramInt2 + paramInt4) / 2);
    awwi localawwi = new awwi(this);
    localawwi.jdField_a_of_type_AndroidGraphicsPoint = a(localPoint5, localPoint1, paramFloat);
    localawwi.jdField_b_of_type_AndroidGraphicsPoint = a(localPoint5, localPoint2, paramFloat);
    localawwi.jdField_c_of_type_AndroidGraphicsPoint = a(localPoint5, localPoint3, paramFloat);
    localawwi.jdField_d_of_type_AndroidGraphicsPoint = a(localPoint5, localPoint4, paramFloat);
    paramInt1 = a(new Integer[] { Integer.valueOf(localawwi.jdField_a_of_type_AndroidGraphicsPoint.x), Integer.valueOf(localawwi.jdField_b_of_type_AndroidGraphicsPoint.x), Integer.valueOf(localawwi.jdField_c_of_type_AndroidGraphicsPoint.x), Integer.valueOf(localawwi.jdField_d_of_type_AndroidGraphicsPoint.x) });
    paramInt2 = b(new Integer[] { Integer.valueOf(localawwi.jdField_a_of_type_AndroidGraphicsPoint.x), Integer.valueOf(localawwi.jdField_b_of_type_AndroidGraphicsPoint.x), Integer.valueOf(localawwi.jdField_c_of_type_AndroidGraphicsPoint.x), Integer.valueOf(localawwi.jdField_d_of_type_AndroidGraphicsPoint.x) });
    localawwi.jdField_a_of_type_Int = (paramInt1 - paramInt2);
    paramInt3 = a(new Integer[] { Integer.valueOf(localawwi.jdField_a_of_type_AndroidGraphicsPoint.y), Integer.valueOf(localawwi.jdField_b_of_type_AndroidGraphicsPoint.y), Integer.valueOf(localawwi.jdField_c_of_type_AndroidGraphicsPoint.y), Integer.valueOf(localawwi.jdField_d_of_type_AndroidGraphicsPoint.y) });
    paramInt4 = b(new Integer[] { Integer.valueOf(localawwi.jdField_a_of_type_AndroidGraphicsPoint.y), Integer.valueOf(localawwi.jdField_b_of_type_AndroidGraphicsPoint.y), Integer.valueOf(localawwi.jdField_c_of_type_AndroidGraphicsPoint.y), Integer.valueOf(localawwi.jdField_d_of_type_AndroidGraphicsPoint.y) });
    localawwi.jdField_b_of_type_Int = (paramInt3 - paramInt4);
    localPoint1 = new Point((paramInt1 + paramInt2) / 2, (paramInt3 + paramInt4) / 2);
    localawwi.jdField_c_of_type_Int = (localawwi.jdField_a_of_type_Int / 2 - localPoint1.x);
    localawwi.jdField_d_of_type_Int = (localawwi.jdField_b_of_type_Int / 2 - localPoint1.y);
    paramInt2 = this.jdField_e_of_type_Int / 2;
    paramInt1 = this.jdField_f_of_type_Int / 2;
    localPoint1 = localawwi.jdField_a_of_type_AndroidGraphicsPoint;
    localPoint1.x += localawwi.jdField_c_of_type_Int + paramInt2;
    localPoint1 = localawwi.jdField_b_of_type_AndroidGraphicsPoint;
    localPoint1.x += localawwi.jdField_c_of_type_Int + paramInt2;
    localPoint1 = localawwi.jdField_c_of_type_AndroidGraphicsPoint;
    localPoint1.x += localawwi.jdField_c_of_type_Int + paramInt2;
    localPoint1 = localawwi.jdField_d_of_type_AndroidGraphicsPoint;
    paramInt3 = localPoint1.x;
    localPoint1.x = (paramInt2 + localawwi.jdField_c_of_type_Int + paramInt3);
    localPoint1 = localawwi.jdField_a_of_type_AndroidGraphicsPoint;
    localPoint1.y += localawwi.jdField_d_of_type_Int + paramInt1;
    localPoint1 = localawwi.jdField_b_of_type_AndroidGraphicsPoint;
    localPoint1.y += localawwi.jdField_d_of_type_Int + paramInt1;
    localPoint1 = localawwi.jdField_c_of_type_AndroidGraphicsPoint;
    localPoint1.y += localawwi.jdField_d_of_type_Int + paramInt1;
    localPoint1 = localawwi.jdField_d_of_type_AndroidGraphicsPoint;
    paramInt2 = localPoint1.y;
    localPoint1.y = (paramInt1 + localawwi.jdField_d_of_type_Int + paramInt2);
    localawwi.jdField_e_of_type_AndroidGraphicsPoint = a(this.m, localawwi);
    localawwi.jdField_f_of_type_AndroidGraphicsPoint = a(this.n, localawwi);
    return localawwi;
  }
  
  void a()
  {
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.i);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.j);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_Float = aepi.a(2.0F, getResources());
    this.jdField_d_of_type_Float = aepi.a(1.0F, getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(this.jdField_c_of_type_Float, 0.0F, this.jdField_d_of_type_Float, -16777216);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = getResources().getDisplayMetrics().densityDpi;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130846949, localOptions);
      if (this.jdField_c_of_type_AndroidGraphicsBitmap != null) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      try
      {
        this.jdField_c_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130846950, localOptions);
        setIconSize(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
        a();
        return;
        localOutOfMemoryError2 = localOutOfMemoryError2;
        QLog.e("SingleTouchLayout", 1, "controlDrawable decode failed");
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          QLog.e("SingleTouchLayout", 1, "deleteDrawable decode failed");
        }
      }
    }
  }
  
  void a(AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.jdField_h_of_type_Int = ((int)TypedValue.applyDimension(1, 8.0F, this.jdField_a_of_type_AndroidUtilDisplayMetrics));
    this.j = ((int)TypedValue.applyDimension(1, 1.0F, this.jdField_a_of_type_AndroidUtilDisplayMetrics));
    this.i = -1;
    this.jdField_h_of_type_Float = 1.0F;
    this.jdField_g_of_type_Float = 0.0F;
    this.m = 2;
    this.n = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(View paramView)
  {
    removeView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, -2));
  }
  
  public boolean a()
  {
    return a(this.jdField_h_of_type_Float, this.jdField_g_of_type_Float);
  }
  
  @TargetApi(11)
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return true;
    }
    if ((this.o > 0) && (this.p > 0)) {
      this.jdField_e_of_type_Boolean = true;
    }
    int i1 = (int)(this.o * paramFloat1);
    int i2 = (int)(this.p * paramFloat1);
    if (QLog.isColorLevel()) {
      QLog.d("SingleTouchLayout", 2, "transformDraw(): mActualViewWidth=" + i1 + ", mActualViewHeight=" + i2);
    }
    Object localObject = a(-this.jdField_h_of_type_Int, -this.jdField_h_of_type_Int, this.jdField_h_of_type_Int + i1, i2 + this.jdField_h_of_type_Int, paramFloat2);
    if ((a(((awwi)localObject).jdField_a_of_type_Int, ((awwi)localObject).jdField_b_of_type_Int)) || (!this.jdField_e_of_type_Boolean) || (this.jdField_c_of_type_AndroidGraphicsPointF.x == 0.0F) || (this.jdField_c_of_type_AndroidGraphicsPointF.y == 0.0F) || (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidGraphicsPoint = ((awwi)localObject).jdField_a_of_type_AndroidGraphicsPoint;
      this.jdField_b_of_type_AndroidGraphicsPoint = ((awwi)localObject).jdField_b_of_type_AndroidGraphicsPoint;
      this.jdField_c_of_type_AndroidGraphicsPoint = ((awwi)localObject).jdField_c_of_type_AndroidGraphicsPoint;
      this.jdField_d_of_type_AndroidGraphicsPoint = ((awwi)localObject).jdField_d_of_type_AndroidGraphicsPoint;
      this.jdField_e_of_type_AndroidGraphicsPoint = ((awwi)localObject).jdField_e_of_type_AndroidGraphicsPoint;
      this.jdField_f_of_type_AndroidGraphicsPoint = ((awwi)localObject).jdField_f_of_type_AndroidGraphicsPoint;
      this.jdField_a_of_type_Int = ((awwi)localObject).jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = ((awwi)localObject).jdField_b_of_type_Int;
      this.k = ((awwi)localObject).jdField_c_of_type_Int;
      this.l = ((awwi)localObject).jdField_d_of_type_Int;
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = ((this.jdField_a_of_type_Int + this.jdField_e_of_type_Int - this.jdField_a_of_type_AndroidViewView.getWidth()) / 2);
      ((FrameLayout.LayoutParams)localObject).topMargin = ((this.jdField_b_of_type_Int + this.jdField_f_of_type_Int - this.jdField_a_of_type_AndroidViewView.getHeight()) / 2);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidViewView.setScaleX(paramFloat1);
      this.jdField_a_of_type_AndroidViewView.setScaleY(paramFloat1);
      this.jdField_a_of_type_AndroidViewView.setRotation(paramFloat2 % 360.0F);
      if (QLog.isColorLevel()) {
        QLog.d("SingleTouchLayout", 2, "transformDraw(): mViewWidth=" + this.jdField_a_of_type_Int + ", mViewHeight=" + this.jdField_b_of_type_Int);
      }
      b();
      return true;
    }
    return false;
  }
  
  boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 < 10000.0F;
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    int i1;
    int i2;
    if (this.jdField_c_of_type_Boolean)
    {
      paramInt1 = this.jdField_e_of_type_Int + paramInt1;
      paramInt2 = this.jdField_f_of_type_Int + paramInt2;
      i1 = (int)(this.jdField_c_of_type_AndroidGraphicsPointF.x - paramInt1 / 2);
      i2 = (int)(this.jdField_c_of_type_AndroidGraphicsPointF.y - paramInt2 / 2);
      if (QLog.isColorLevel()) {
        QLog.d("SingleTouchLayout", 2, String.format("inBounds: l=%s, t=%s, w=%s, h=%s, cp.x=%s, cp.y=%s, width=%s, height=%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.jdField_c_of_type_AndroidGraphicsPointF.x), Float.valueOf(this.jdField_c_of_type_AndroidGraphicsPointF.y), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    }
    return (i1 >= 0) && (i2 >= 0) && (paramInt1 + i1 <= this.jdField_c_of_type_Int) && (i2 + paramInt2 <= this.jdField_d_of_type_Int);
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView != paramView)
    {
      removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = paramView;
      addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-2, -2));
      return true;
    }
    return false;
  }
  
  public boolean a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != paramView)
    {
      removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = paramView;
      addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(paramInt, -2));
      return true;
    }
    return false;
  }
  
  public float b()
  {
    return this.jdField_h_of_type_Float;
  }
  
  public int b(Integer... paramVarArgs)
  {
    paramVarArgs = Arrays.asList(paramVarArgs);
    Collections.sort(paramVarArgs);
    return ((Integer)paramVarArgs.get(0)).intValue();
  }
  
  void b()
  {
    int i1 = this.jdField_a_of_type_Int + this.jdField_e_of_type_Int;
    int i2 = this.jdField_b_of_type_Int + this.jdField_f_of_type_Int;
    int i3 = (int)(this.jdField_c_of_type_AndroidGraphicsPointF.x - i1 / 2);
    int i4 = (int)(this.jdField_c_of_type_AndroidGraphicsPointF.y - i2 / 2);
    if ((this.q != i3) || (this.r != i4))
    {
      this.q = i3;
      this.r = i4;
    }
    layout(i3, i4, i1 + i3, i2 + i4);
  }
  
  boolean b(float paramFloat1, float paramFloat2)
  {
    return a(new PointF(paramFloat1, paramFloat2), new PointF(this.jdField_f_of_type_AndroidGraphicsPoint)) < Math.min(this.jdField_e_of_type_Int / 2, this.jdField_f_of_type_Int / 2);
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(this.jdField_g_of_type_Float);
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap)) {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), this.jdField_a_of_type_AndroidGraphicsMatrix, false);
    if ((this.jdField_d_of_type_AndroidGraphicsBitmap != null) && (this.jdField_d_of_type_AndroidGraphicsBitmap != this.jdField_c_of_type_AndroidGraphicsBitmap)) {
      this.jdField_d_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_d_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_c_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight(), this.jdField_a_of_type_AndroidGraphicsMatrix, false);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = (ViewGroup)getParent();
    if ((this.jdField_c_of_type_AndroidGraphicsPointF.x == 0.0F) || (this.jdField_c_of_type_AndroidGraphicsPointF.y == 0.0F))
    {
      this.jdField_c_of_type_Int = ((ViewGroup)localObject).getWidth();
      this.jdField_d_of_type_Int = ((ViewGroup)localObject).getHeight();
      this.jdField_c_of_type_AndroidGraphicsPointF.set(this.jdField_c_of_type_Int / 2, this.jdField_d_of_type_Int / 2);
      a();
      if (!this.jdField_e_of_type_Boolean) {
        a();
      }
      super.onDraw(paramCanvas);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsPoint != null) && (this.jdField_b_of_type_AndroidGraphicsPoint != null) && (this.jdField_c_of_type_AndroidGraphicsPoint != null) && (this.jdField_d_of_type_AndroidGraphicsPoint != null) && (this.jdField_e_of_type_AndroidGraphicsPoint != null) && (this.jdField_f_of_type_AndroidGraphicsPoint != null))
      {
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_c_of_type_AndroidGraphicsPoint.x, this.jdField_c_of_type_AndroidGraphicsPoint.y);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_d_of_type_AndroidGraphicsPoint.x, this.jdField_d_of_type_AndroidGraphicsPoint.y);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
        this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_e_of_type_AndroidGraphicsPoint.x - this.jdField_e_of_type_Int / 2, this.jdField_e_of_type_AndroidGraphicsPoint.y - this.jdField_f_of_type_Int / 2, this.jdField_e_of_type_AndroidGraphicsPoint.x + this.jdField_e_of_type_Int / 2, this.jdField_e_of_type_AndroidGraphicsPoint.y + this.jdField_f_of_type_Int / 2);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
          break label534;
        }
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        label380:
        paramCanvas.drawBitmap((Bitmap)localObject, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_f_of_type_AndroidGraphicsPoint.x - this.jdField_e_of_type_Int / 2, this.jdField_f_of_type_AndroidGraphicsPoint.y - this.jdField_f_of_type_Int / 2, this.jdField_f_of_type_AndroidGraphicsPoint.x + this.jdField_e_of_type_Int / 2, this.jdField_f_of_type_AndroidGraphicsPoint.y + this.jdField_f_of_type_Int / 2);
        if (this.jdField_d_of_type_AndroidGraphicsBitmap != null) {
          break label542;
        }
      }
    }
    label534:
    label542:
    for (localObject = this.jdField_c_of_type_AndroidGraphicsBitmap;; localObject = this.jdField_d_of_type_AndroidGraphicsBitmap)
    {
      paramCanvas.drawBitmap((Bitmap)localObject, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(false);
      b();
      return;
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_d_of_type_Int != 0)) {
        break;
      }
      this.jdField_c_of_type_Int = ((ViewGroup)localObject).getWidth();
      this.jdField_d_of_type_Int = ((ViewGroup)localObject).getHeight();
      a();
      break;
      localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
      break label380;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    label314:
    label327:
    label358:
    do
    {
      do
      {
        for (;;)
        {
          return true;
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_e_of_type_Float = paramMotionEvent.getRawX();
          this.jdField_f_of_type_Float = paramMotionEvent.getRawY();
          this.jdField_a_of_type_AndroidGraphicsPointF.set(paramMotionEvent.getX() + this.q, paramMotionEvent.getY() + this.r);
          this.jdField_g_of_type_Int = a(paramMotionEvent.getX(), paramMotionEvent.getY());
          Log.d("SingleTouchLayout", "ActionDown -- (" + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ")");
        }
        Log.d("SingleTouchLayout", "ActionUp -- (" + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ")");
        if ((this.jdField_a_of_type_Awwj != null) && (this.jdField_a_of_type_Boolean))
        {
          if (this.jdField_g_of_type_Int == 2) {
            break label358;
          }
          if ((System.currentTimeMillis() - this.jdField_a_of_type_Long >= 100L) || (!a(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float, paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
            break label327;
          }
          if (!b(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            break label314;
          }
          this.jdField_a_of_type_Awwj.b(this);
        }
        for (;;)
        {
          this.jdField_g_of_type_Int = 0;
          break;
          this.jdField_a_of_type_Awwj.a(this);
          continue;
          this.jdField_a_of_type_Awwj.a(this, paramMotionEvent.getX() - this.jdField_e_of_type_Float, paramMotionEvent.getY() - this.jdField_f_of_type_Float);
          continue;
          this.jdField_a_of_type_Awwj.a(this, this.jdField_h_of_type_Float);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SingleTouchLayout", 4, "ActionMove: x=" + paramMotionEvent.getX() + ", y=" + paramMotionEvent.getY());
        }
        this.jdField_b_of_type_AndroidGraphicsPointF.set(paramMotionEvent.getX() + this.q, paramMotionEvent.getY() + this.r);
        if (this.jdField_g_of_type_Int != 2) {
          break;
        }
      } while (!this.jdField_a_of_type_Boolean);
      i1 = this.jdField_a_of_type_AndroidViewView.getWidth() / 2;
      i2 = this.jdField_a_of_type_AndroidViewView.getHeight() / 2;
      d1 = Math.sqrt(i1 * i1 + i2 * i2);
      d2 = a(this.jdField_c_of_type_AndroidGraphicsPointF, this.jdField_b_of_type_AndroidGraphicsPointF) / d1;
      if (d2 <= this.jdField_b_of_type_Float)
      {
        d1 = this.jdField_b_of_type_Float;
        f1 = 0.0F;
        if (this.jdField_d_of_type_Boolean)
        {
          d2 = a(this.jdField_c_of_type_AndroidGraphicsPointF, this.jdField_a_of_type_AndroidGraphicsPointF);
          d3 = a(this.jdField_a_of_type_AndroidGraphicsPointF, this.jdField_b_of_type_AndroidGraphicsPointF);
          d4 = a(this.jdField_c_of_type_AndroidGraphicsPointF, this.jdField_b_of_type_AndroidGraphicsPointF);
          d3 = (d2 * d2 + d4 * d4 - d3 * d3) / (d2 * 2.0D * d4);
          d2 = d3;
          if (d3 >= 1.0D) {
            d2 = 1.0D;
          }
          f2 = (float)a(Math.acos(d2));
          paramMotionEvent = new PointF(this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_c_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_c_of_type_AndroidGraphicsPointF.y);
          localPointF = new PointF(this.jdField_b_of_type_AndroidGraphicsPointF.x - this.jdField_c_of_type_AndroidGraphicsPointF.x, this.jdField_b_of_type_AndroidGraphicsPointF.y - this.jdField_c_of_type_AndroidGraphicsPointF.y);
          f1 = f2;
          if (paramMotionEvent.x * localPointF.y - paramMotionEvent.y * localPointF.x < 0.0F) {
            f1 = -f2;
          }
        }
        if (a((float)d1, this.jdField_g_of_type_Float + f1))
        {
          this.jdField_g_of_type_Float += f1;
          this.jdField_h_of_type_Float = ((float)d1);
          if (f1 != 0.0F) {
            c();
          }
          if (QLog.isColorLevel()) {
            QLog.d("SingleTouchLayout", 4, "ActionMove-Zoom: scale=" + this.jdField_h_of_type_Float + ", deltaY=" + this.jdField_g_of_type_Float);
          }
        }
      }
      while (this.jdField_g_of_type_Int != 1) {
        for (;;)
        {
          int i1;
          int i2;
          double d2;
          double d3;
          double d4;
          PointF localPointF;
          this.jdField_a_of_type_AndroidGraphicsPointF.set(this.jdField_b_of_type_AndroidGraphicsPointF);
          break;
          double d1 = d2;
          if (d2 >= this.jdField_a_of_type_Float) {
            d1 = this.jdField_a_of_type_Float;
          }
        }
      }
    } while (!this.jdField_b_of_type_Boolean);
    float f1 = this.jdField_b_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = this.jdField_b_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsPointF.y;
    if (this.jdField_c_of_type_Boolean)
    {
      if ((getLeft() + f1 >= 0.0F) && (getRight() + f1 <= this.jdField_c_of_type_Int))
      {
        paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsPointF;
        paramMotionEvent.x = (f1 + paramMotionEvent.x);
      }
      if ((getTop() + f2 >= 0.0F) && (getBottom() + f2 <= this.jdField_d_of_type_Int)) {
        paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsPointF;
      }
    }
    for (paramMotionEvent.y = (f2 + paramMotionEvent.y);; paramMotionEvent.y = (f2 + paramMotionEvent.y))
    {
      b();
      break;
      paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsPointF;
      paramMotionEvent.x = (f1 + paramMotionEvent.x);
      paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsPointF;
    }
  }
  
  public void setActualViewSize(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.o = paramInt1;
      this.p = paramInt2;
      a();
    }
  }
  
  public void setBoundLimited(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setCenterPoint(float paramFloat1, float paramFloat2)
  {
    this.jdField_c_of_type_AndroidGraphicsPointF = new PointF(paramFloat1, paramFloat2);
    b();
  }
  
  public void setEditable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setFrameWidth(int paramInt)
  {
    if (this.j == paramInt) {
      return;
    }
    this.j = ((int)TypedValue.applyDimension(1, paramInt, this.jdField_a_of_type_AndroidUtilDisplayMetrics));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt);
    invalidate();
  }
  
  public void setIconSize(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
    a();
  }
  
  public void setImageDegree(float paramFloat)
  {
    if (this.jdField_g_of_type_Float != paramFloat)
    {
      this.jdField_g_of_type_Float = paramFloat;
      c();
      a();
    }
  }
  
  public void setImageScale(float paramFloat)
  {
    if (this.jdField_h_of_type_Float != paramFloat)
    {
      this.jdField_h_of_type_Float = paramFloat;
      a();
    }
  }
  
  public void setMovable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setRotateEnable(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setScaleLimit(float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Float = paramFloat1;
    this.jdField_a_of_type_Float = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.SingleTouchLayout
 * JD-Core Version:    0.7.0.1
 */