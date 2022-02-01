package com.tencent.mobileqq.gesturelock;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import aubt;
import aubu;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LockPatternView
  extends View
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private aubu jdField_a_of_type_Aubu;
  private ArrayList<aubt> jdField_a_of_type_JavaUtilArrayList = new ArrayList(9);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean[][] jdField_a_of_type_Array2dOfBoolean = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 });
  private float jdField_b_of_type_Float = -1.0F;
  private final int jdField_b_of_type_Int = 128;
  private final Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 0.3F;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float = 0.6F;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float = 3.0F;
  private int jdField_g_of_type_Int;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  
  public LockPatternView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LockPatternView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject = null;
    Context localContext = null;
    for (;;)
    {
      try
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LockPatternView);
        localContext = paramContext;
        localObject = paramContext;
        paramAttributeSet = paramContext.getString(0);
        localContext = paramContext;
        localObject = paramContext;
        if (!"square".equals(paramAttributeSet)) {
          continue;
        }
        localContext = paramContext;
        localObject = paramContext;
        this.n = 0;
      }
      catch (Exception paramContext)
      {
        localObject = localContext;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = localContext;
        QLog.d("LockPatternView", 2, "LockPatternView()", paramContext);
        localContext.recycle();
        return;
        localContext = paramContext;
        localObject = paramContext;
        if (!"lock_height".equals(paramAttributeSet)) {
          break label747;
        }
        localContext = paramContext;
        localObject = paramContext;
        this.n = 2;
        continue;
      }
      finally
      {
        ((TypedArray)localObject).recycle();
      }
      localContext = paramContext;
      localObject = paramContext;
      setClickable(true);
      localContext = paramContext;
      localObject = paramContext;
      this.o = getResources().getColor(2131165687);
      localContext = paramContext;
      localObject = paramContext;
      this.p = getResources().getColor(2131165688);
      localContext = paramContext;
      localObject = paramContext;
      this.q = getResources().getDimensionPixelSize(2131297169);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.o);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.q);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_c_of_type_Int = getResources().getColor(2131165681);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_d_of_type_Int = getResources().getColor(2131165682);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_e_of_type_Int = getResources().getColor(2131165683);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_f_of_type_Int = getResources().getColor(2131165684);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_g_of_type_Int = getResources().getColor(2131165685);
      localContext = paramContext;
      localObject = paramContext;
      this.h = getResources().getColor(2131165686);
      localContext = paramContext;
      localObject = paramContext;
      this.i = getResources().getColor(2131165678);
      localContext = paramContext;
      localObject = paramContext;
      this.j = getResources().getColor(2131165679);
      localContext = paramContext;
      localObject = paramContext;
      this.k = getResources().getColor(2131165680);
      localContext = paramContext;
      localObject = paramContext;
      this.jdField_g_of_type_Float = getResources().getDimensionPixelSize(2131297170);
      localContext = paramContext;
      localObject = paramContext;
      this.l = (getWidth() / 4);
      localContext = paramContext;
      localObject = paramContext;
      this.m = (getHeight() / 4);
      paramContext.recycle();
      return;
      localContext = paramContext;
      localObject = paramContext;
      if ("lock_width".equals(paramAttributeSet))
      {
        localContext = paramContext;
        localObject = paramContext;
        this.n = 1;
      }
      else
      {
        label747:
        localContext = paramContext;
        localObject = paramContext;
        this.n = 0;
      }
    }
  }
  
  private float a(int paramInt)
  {
    return getPaddingLeft() + paramInt * this.jdField_e_of_type_Float + this.jdField_e_of_type_Float / 2.0F;
  }
  
  private int a(float paramFloat)
  {
    float f1 = this.jdField_f_of_type_Float;
    float f2 = f1 * this.jdField_d_of_type_Float;
    float f3 = getPaddingTop();
    float f4 = (f1 - f2) / 2.0F;
    int i1 = 0;
    while (i1 < 3)
    {
      float f5 = i1 * f1 + (f4 + f3);
      if ((paramFloat >= f5) && (paramFloat <= f5 + f2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i1 = paramInt2;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    default: 
      i1 = i2;
    case 0: 
      return i1;
    }
    return Math.min(i2, paramInt2);
  }
  
  private aubt a(float paramFloat1, float paramFloat2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i2 = -1;
    aubt localaubt = b(paramFloat1, paramFloat2);
    int i3;
    int i1;
    if (localaubt != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      localObject1 = localObject2;
      if (!localArrayList.isEmpty())
      {
        localObject1 = (aubt)localArrayList.get(localArrayList.size() - 1);
        int i6 = localaubt.jdField_a_of_type_Int - ((aubt)localObject1).jdField_a_of_type_Int;
        int i5 = localaubt.jdField_b_of_type_Int - ((aubt)localObject1).jdField_b_of_type_Int;
        int i4 = ((aubt)localObject1).jdField_a_of_type_Int;
        i3 = ((aubt)localObject1).jdField_b_of_type_Int;
        i1 = i4;
        if (Math.abs(i6) == 2)
        {
          i1 = i4;
          if (Math.abs(i5) != 1)
          {
            i4 = ((aubt)localObject1).jdField_a_of_type_Int;
            if (i6 <= 0) {
              break label252;
            }
            i1 = 1;
            i1 += i4;
          }
        }
        if ((Math.abs(i5) != 2) || (Math.abs(i6) == 1)) {
          break label257;
        }
        i3 = ((aubt)localObject1).jdField_b_of_type_Int;
        if (i5 > 0) {
          i2 = 1;
        }
      }
    }
    label257:
    for (i2 = i3 + i2;; i2 = i3)
    {
      localObject1 = aubt.a(i1, i2);
      if ((this.jdField_e_of_type_Boolean) && (localObject1 != null) && (this.jdField_a_of_type_Array2dOfBoolean[localObject1.jdField_a_of_type_Int][localObject1.jdField_b_of_type_Int] == 0)) {
        b((aubt)localObject1);
      }
      b(localaubt);
      if (this.jdField_c_of_type_Boolean) {
        performHapticFeedback(1, 3);
      }
      localObject1 = localaubt;
      return localObject1;
      label252:
      i1 = -1;
      break;
    }
  }
  
  private void a(int paramInt)
  {
    setContentDescription(getContext().getString(paramInt));
    sendAccessibilityEvent(4);
    setContentDescription(null);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i3;
    int i2;
    int i1;
    if ((!paramBoolean) || ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int != 2)))
    {
      i3 = this.jdField_f_of_type_Int;
      i2 = this.jdField_c_of_type_Int;
      i1 = this.i;
    }
    for (;;)
    {
      float f2 = this.jdField_e_of_type_Float;
      float f1 = this.jdField_f_of_type_Float;
      int i4 = (int)(3.0F * f2 / 4.0F);
      int i6 = (int)(3.0F * f1 / 4.0F);
      int i5 = (int)((f2 - i4) / 2.0F);
      i6 = (int)((f1 - i6) / 2.0F);
      float f3 = Math.min(this.jdField_e_of_type_Float / this.l, 1.0F);
      float f4 = Math.min(this.jdField_f_of_type_Float / this.m, 1.0F);
      this.jdField_b_of_type_AndroidGraphicsMatrix.setTranslate(i5 + paramInt1, i6 + paramInt2);
      this.jdField_b_of_type_AndroidGraphicsMatrix.preTranslate(this.l / 2, this.m / 2);
      this.jdField_b_of_type_AndroidGraphicsMatrix.preScale(f3, f4);
      this.jdField_b_of_type_AndroidGraphicsMatrix.preTranslate(-this.l / 2, -this.m / 2);
      f3 = paramInt1;
      f2 = f2 / 2.0F + f3;
      f3 = paramInt2;
      f1 = f1 / 2.0F + f3;
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i1);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawCircle(f2, f1, i4 / 2, this.jdField_c_of_type_AndroidGraphicsPaint);
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i2);
      paramCanvas.drawCircle(f2, f1, i4 * 18 / 100, this.jdField_c_of_type_AndroidGraphicsPaint);
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i3);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_g_of_type_Float);
      paramCanvas.drawCircle(f2, f1, i4 / 2, this.jdField_c_of_type_AndroidGraphicsPaint);
      return;
      if (this.jdField_d_of_type_Boolean)
      {
        i3 = this.jdField_g_of_type_Int;
        i2 = this.jdField_d_of_type_Int;
        i1 = this.j;
      }
      else if (this.jdField_a_of_type_Int == 2)
      {
        i3 = this.h;
        i2 = this.jdField_e_of_type_Int;
        i1 = this.k;
      }
      else
      {
        if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1)) {
          break;
        }
        i3 = this.jdField_f_of_type_Int;
        i2 = this.jdField_d_of_type_Int;
        i1 = this.j;
      }
    }
    throw new IllegalStateException("unknown display mode " + this.jdField_a_of_type_Int);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getHistorySize();
    int i1 = 0;
    if (i1 < i2 + 1)
    {
      float f4;
      label33:
      float f3;
      label48:
      float f6;
      float f5;
      float f2;
      float f1;
      float f7;
      label229:
      float f8;
      if (i1 < i2)
      {
        f4 = paramMotionEvent.getHistoricalX(i1);
        if (i1 >= i2) {
          break label541;
        }
        f3 = paramMotionEvent.getHistoricalY(i1);
        int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
        aubt localaubt = a(f4, f3);
        int i4 = this.jdField_a_of_type_JavaUtilArrayList.size();
        if ((localaubt != null) && (i4 == 1))
        {
          this.jdField_d_of_type_Boolean = true;
          b();
        }
        if (Math.abs(f4 - this.jdField_a_of_type_Float) + Math.abs(f3 - this.jdField_b_of_type_Float) > 0.0F)
        {
          f6 = this.jdField_a_of_type_Float;
          f5 = this.jdField_b_of_type_Float;
          this.jdField_a_of_type_Float = f4;
          this.jdField_b_of_type_Float = f3;
          if ((!this.jdField_d_of_type_Boolean) || (i4 <= 0)) {
            break label614;
          }
          ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
          float f9 = this.jdField_e_of_type_Float * this.jdField_c_of_type_Float * 0.5F;
          Object localObject = (aubt)localArrayList.get(i4 - 1);
          f2 = a(((aubt)localObject).jdField_b_of_type_Int);
          f1 = b(((aubt)localObject).jdField_a_of_type_Int);
          localObject = this.jdField_a_of_type_AndroidGraphicsRect;
          if (f2 >= f4) {
            break label550;
          }
          f7 = f2;
          if (f1 >= f3) {
            break label568;
          }
          f8 = f1;
          label239:
          ((Rect)localObject).set((int)(f7 - f9), (int)(f8 - f9), (int)(f4 + f9), (int)(f3 + f9));
          if (f2 >= f6) {
            break label578;
          }
          f3 = f2;
          f2 = f6;
          label281:
          f6 = f1;
          f4 = f5;
          if (f1 < f5)
          {
            f4 = f1;
            f6 = f5;
          }
          ((Rect)localObject).union((int)(f3 - f9), (int)(f4 - f9), (int)(f2 + f9), (int)(f6 + f9));
          if (localaubt != null)
          {
            f2 = a(localaubt.jdField_b_of_type_Int);
            f1 = b(localaubt.jdField_a_of_type_Int);
            if (i4 < 2) {
              break label595;
            }
            localaubt = (aubt)localArrayList.get(i4 - 1 - (i4 - i3));
            f6 = a(localaubt.jdField_b_of_type_Int);
            f5 = b(localaubt.jdField_a_of_type_Int);
            f3 = f2;
            f4 = f6;
            if (f2 < f6)
            {
              f3 = f6;
              f4 = f2;
            }
            if (f1 >= f5) {
              break label585;
            }
            f2 = f3;
            f3 = f1;
            f1 = f5;
            label440:
            f5 = this.jdField_e_of_type_Float / 1.0F;
            f6 = this.jdField_f_of_type_Float / 1.0F;
            ((Rect)localObject).set((int)(f4 - f5), (int)(f3 - f6), (int)(f2 + f5), (int)(f1 + f6));
          }
          if (QLog.isColorLevel()) {
            QLog.d("LockPatternView", 2, "move invalidate.rect=" + localObject);
          }
          invalidate((Rect)localObject);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        f4 = paramMotionEvent.getX();
        break label33;
        label541:
        f3 = paramMotionEvent.getY();
        break label48;
        label550:
        f7 = f2;
        f8 = f4;
        f4 = f7;
        f7 = f8;
        break label229;
        label568:
        f8 = f3;
        f3 = f1;
        break label239;
        label578:
        f3 = f6;
        break label281;
        label585:
        f2 = f3;
        f3 = f5;
        break label440;
        label595:
        f3 = f1;
        f4 = f2;
        f5 = f1;
        f1 = f3;
        f3 = f5;
        break label440;
        label614:
        if (QLog.isColorLevel()) {
          QLog.d("LockPatternView", 2, "move invalidate.all");
        }
        invalidate();
      }
    }
  }
  
  private void a(aubt paramaubt)
  {
    if (this.jdField_a_of_type_Aubu != null) {
      this.jdField_a_of_type_Aubu.b(this.jdField_a_of_type_JavaUtilArrayList);
    }
    if (paramaubt != null)
    {
      a(String.format("%d", new Object[] { Integer.valueOf(paramaubt.a() * 3 + paramaubt.b() + 1) }));
      return;
    }
    a(2131693534);
  }
  
  private void a(String paramString)
  {
    setContentDescription(paramString);
    sendAccessibilityEvent(4);
    setContentDescription(null);
  }
  
  private float b(int paramInt)
  {
    return getPaddingTop() + paramInt * this.jdField_f_of_type_Float + this.jdField_f_of_type_Float / 2.0F;
  }
  
  private int b(float paramFloat)
  {
    float f1 = this.jdField_e_of_type_Float;
    float f2 = f1 * this.jdField_d_of_type_Float;
    float f3 = getPaddingLeft();
    float f4 = (f1 - f2) / 2.0F;
    int i1 = 0;
    while (i1 < 3)
    {
      float f5 = i1 * f1 + (f4 + f3);
      if ((paramFloat >= f5) && (paramFloat <= f5 + f2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private aubt b(float paramFloat1, float paramFloat2)
  {
    int i1 = a(paramFloat2);
    if (i1 < 0) {}
    int i2;
    do
    {
      return null;
      i2 = b(paramFloat1);
    } while ((i2 < 0) || (this.jdField_a_of_type_Array2dOfBoolean[i1][i2] != 0));
    return aubt.a(i1, i2);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aubu != null) {
      this.jdField_a_of_type_Aubu.a();
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_d_of_type_Boolean = false;
      c();
      invalidate();
    }
  }
  
  private void b(aubt paramaubt)
  {
    this.jdField_a_of_type_Array2dOfBoolean[paramaubt.a()][paramaubt.b()] = 1;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramaubt);
    a(paramaubt);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Aubu != null) {
      this.jdField_a_of_type_Aubu.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    a(2131693536);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    e();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = a(f1, f2);
    if (paramMotionEvent != null)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      b();
    }
    for (;;)
    {
      if (paramMotionEvent != null)
      {
        float f3 = a(paramMotionEvent.jdField_b_of_type_Int);
        float f4 = b(paramMotionEvent.jdField_a_of_type_Int);
        float f5 = this.jdField_e_of_type_Float / 2.0F;
        float f6 = this.jdField_f_of_type_Float / 2.0F;
        invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      return;
      this.jdField_d_of_type_Boolean = false;
      d();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Aubu != null) {
      this.jdField_a_of_type_Aubu.b();
    }
    a(2131693535);
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    f();
    this.jdField_a_of_type_Int = 0;
    invalidate();
  }
  
  private void f()
  {
    int i1 = 0;
    while (i1 < 3)
    {
      int i2 = 0;
      while (i2 < 3)
      {
        this.jdField_a_of_type_Array2dOfBoolean[i1][i2] = 0;
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  public void a()
  {
    e();
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return this.m * 3;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return this.l * 3;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LockPatternView", 2, "ondraw.");
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i4 = localArrayList.size();
    boolean[][] arrayOfBoolean = this.jdField_a_of_type_Array2dOfBoolean;
    int i3;
    int i1;
    Object localObject;
    float f3;
    float f4;
    int i5;
    int i6;
    label303:
    boolean bool;
    if (this.jdField_a_of_type_Int == 1)
    {
      i2 = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) % ((i4 + 1) * 700);
      i3 = i2 / 700;
      f();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = (aubt)localArrayList.get(i1);
        arrayOfBoolean[localObject.a()][localObject.b()] = 1;
        i1 += 1;
      }
      if ((i3 > 0) && (i3 < i4))
      {
        i1 = 1;
        if (i1 != 0)
        {
          f1 = i2 % 700 / 700.0F;
          localObject = (aubt)localArrayList.get(i3 - 1);
          f2 = a(((aubt)localObject).jdField_b_of_type_Int);
          f3 = b(((aubt)localObject).jdField_a_of_type_Int);
          localObject = (aubt)localArrayList.get(i3);
          f4 = a(((aubt)localObject).jdField_b_of_type_Int);
          float f5 = b(((aubt)localObject).jdField_a_of_type_Int);
          this.jdField_a_of_type_Float = (f2 + (f4 - f2) * f1);
          this.jdField_b_of_type_Float = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      f1 = this.jdField_e_of_type_Float;
      f2 = this.jdField_f_of_type_Float;
      localObject = this.jdField_a_of_type_AndroidGraphicsPath;
      ((Path)localObject).rewind();
      i5 = getPaddingTop();
      i6 = getPaddingLeft();
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int != 2)) {
        break label400;
      }
      i1 = 1;
      if ((this.jdField_a_of_type_AndroidGraphicsPaint.getFlags() & 0x2) == 0) {
        break label406;
      }
      bool = true;
      label318:
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      i2 = 0;
    }
    for (;;)
    {
      if (i2 >= 3) {
        break label421;
      }
      f3 = i5;
      f4 = i2;
      i3 = 0;
      for (;;)
      {
        if (i3 < 3)
        {
          a(paramCanvas, (int)(i6 + i3 * f1), (int)(f4 * f2 + f3), arrayOfBoolean[i2][i3]);
          i3 += 1;
          continue;
          i1 = 0;
          break;
          label400:
          i1 = 0;
          break label303;
          label406:
          bool = false;
          break label318;
        }
      }
      i2 += 1;
    }
    label421:
    if (i1 != 0)
    {
      if (this.jdField_a_of_type_Int == 2) {
        break label540;
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.o);
    }
    aubt localaubt;
    for (;;)
    {
      i2 = 0;
      i1 = 0;
      if (i1 < i4)
      {
        localaubt = (aubt)localArrayList.get(i1);
        if (arrayOfBoolean[localaubt.jdField_a_of_type_Int][localaubt.jdField_b_of_type_Int] != 0) {
          break;
        }
      }
      if (((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Int == 1)) && (i2 != 0)) {
        ((Path)localObject).lineTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      }
      paramCanvas.drawPath((Path)localObject, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(bool);
      return;
      label540:
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.p);
    }
    int i2 = 1;
    float f1 = a(localaubt.jdField_b_of_type_Int);
    float f2 = b(localaubt.jdField_a_of_type_Int);
    if (i1 == 0) {
      ((Path)localObject).moveTo(f1, f2);
    }
    for (;;)
    {
      i1 += 1;
      break;
      ((Path)localObject).lineTo(f1, f2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getSuggestedMinimumWidth();
    int i2 = getSuggestedMinimumHeight();
    i1 = a(paramInt1, i1);
    paramInt1 = a(paramInt2, i2);
    switch (this.n)
    {
    default: 
      paramInt2 = i1;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt1 = Math.min(i1, paramInt1);
      paramInt2 = paramInt1;
      continue;
      paramInt1 = Math.min(i1, paramInt1);
      paramInt2 = i1;
      continue;
      paramInt2 = Math.min(i1, paramInt1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_e_of_type_Float = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.jdField_f_of_type_Float = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!isEnabled())) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      c(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      return true;
    case 1: 
      b(paramMotionEvent);
      return true;
    case 2: 
      a(paramMotionEvent);
      return true;
    }
    e();
    this.jdField_d_of_type_Boolean = false;
    d();
    return true;
  }
  
  public void setDisplayMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      aubt localaubt = (aubt)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      this.jdField_a_of_type_Float = a(localaubt.b());
      this.jdField_b_of_type_Float = b(localaubt.a());
      f();
    }
    invalidate();
  }
  
  public void setFillInGapCell(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setInStealthMode(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setOnPatternListener(aubu paramaubu)
  {
    this.jdField_a_of_type_Aubu = paramaubu;
  }
  
  public void setPattern(int paramInt, List<aubt> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    f();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aubt localaubt = (aubt)paramList.next();
      this.jdField_a_of_type_Array2dOfBoolean[localaubt.a()][localaubt.b()] = 1;
    }
    setDisplayMode(paramInt);
  }
  
  public void setTactileFeedbackEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.LockPatternView
 * JD-Core Version:    0.7.0.1
 */