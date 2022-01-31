package com.tencent.mobileqq.widget;

import akxd;
import akxe;
import akxf;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TabDragAnimationView
  extends View
{
  float jdField_a_of_type_Float = 0.0F;
  public int a;
  private final akxd jdField_a_of_type_Akxd;
  private final akxe jdField_a_of_type_Akxe;
  private final akxf jdField_a_of_type_Akxf;
  public ValueAnimator a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public URLDrawable a;
  public boolean a;
  float jdField_b_of_type_Float = 0.0F;
  public int b;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  public boolean b;
  public float c;
  public int c;
  ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  public boolean c;
  public float d;
  public int d;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private final boolean jdField_g_of_type_Boolean;
  private int h;
  private int i = -1;
  private int j;
  private int k;
  private int l = -1;
  
  public TabDragAnimationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = true;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TabDragAnimationView, paramInt, 0);
    try
    {
      this.jdField_a_of_type_Int = paramContext.getInt(2, 0);
      this.jdField_g_of_type_Int = paramContext.getDimensionPixelSize(0, 0);
      this.h = paramContext.getDimensionPixelSize(1, 0);
      if (QLog.isColorLevel()) {
        QLog.d("TabDragAnimationView", 2, "load xml attr, expected logo width=" + this.jdField_g_of_type_Int + ", expected logo height=" + this.h);
      }
      paramContext.recycle();
      this.jdField_a_of_type_Akxf = new akxf(this);
      this.jdField_a_of_type_Akxe = new akxe(this);
      this.jdField_a_of_type_Akxd = new akxd(this);
      this.jdField_c_of_type_Boolean = ThemeUtil.isNowThemeIsAnimate();
      this.jdField_g_of_type_Boolean = Build.MODEL.contains("vivo");
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int m = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = paramInt2 - getPaddingTop() - getPaddingBottom();
    paramInt1 = m;
    if (m > this.jdField_g_of_type_Int) {
      paramInt1 = this.jdField_g_of_type_Int;
    }
    this.jdField_b_of_type_Int = paramInt1;
    if (paramInt2 > this.h)
    {
      paramInt1 = this.h;
      this.jdField_c_of_type_Int = paramInt1;
      if (this.i == -1) {
        break label163;
      }
      paramInt1 = this.i;
      label78:
      if (this.i == -1) {
        break label174;
      }
    }
    label163:
    label174:
    for (paramInt2 = this.i;; paramInt2 = this.jdField_c_of_type_Int / 10)
    {
      this.k = ((int)Math.sqrt(Math.pow(paramInt1, 2.0D) + Math.pow(paramInt2, 2.0D)));
      double d1 = Math.pow(paramInt1 + this.jdField_b_of_type_Int / 2, 2.0D);
      this.j = ((int)Math.sqrt(Math.pow(this.jdField_c_of_type_Int / 2 + paramInt2, 2.0D) + d1));
      return;
      paramInt1 = paramInt2;
      break;
      paramInt1 = this.jdField_b_of_type_Int / 10;
      break label78;
    }
  }
  
  Drawable a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        return this.jdField_a_of_type_ComTencentImageURLDrawable;
      }
      String str1 = ThemeUtil.getAnimatePathByTag(this.jdField_e_of_type_Int);
      Drawable localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_width", this.jdField_b_of_type_Int);
      localBundle.putInt("key_height", this.jdField_c_of_type_Int);
      localBundle.putInt("key_loop", 1);
      int m = this.jdField_f_of_type_Int;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      String str2 = "- tab-" + this.jdField_e_of_type_Int;
      String str3 = "- tab-" + this.jdField_e_of_type_Int;
      this.jdField_a_of_type_ComTencentImageURLDrawable = VasApngUtil.a(localAppRuntime, str1, str2, localDrawable, new int[] { m }, str3, localBundle);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable.setCallback(this);
        return this.jdField_a_of_type_ComTencentImageURLDrawable;
      }
    }
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setCallback(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    return this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_Akxe);
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Float != paramFloat1))
    {
      this.jdField_a_of_type_Akxd.a();
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_c_of_type_Float, paramFloat1 });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(100L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_Akxe);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Int = 8;
      this.jdField_c_of_type_Float = paramFloat1;
      this.jdField_d_of_type_Float = paramFloat2;
      this.jdField_e_of_type_Boolean = paramBoolean;
      invalidate();
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Akxf.a();
      e();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    c();
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Akxf.jdField_a_of_type_Float = paramFloat1;
    this.jdField_a_of_type_Akxf.jdField_b_of_type_Float = paramFloat2;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    invalidate();
  }
  
  void d()
  {
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_Akxd);
    }
    this.jdField_d_of_type_Int = 1;
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.75F, 0.5F, 0.75F, 1.0F });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_Akxd);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
  }
  
  void e()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_Akxf);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_Akxf);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i2 = getPaddingLeft();
    int i1 = getRight() - getLeft() - getPaddingRight();
    int n = getPaddingTop();
    int m = getBottom() - getTop() - getPaddingBottom();
    int i4;
    Drawable localDrawable1;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i4 = (i1 + i2) / 2;
      i3 = (m + n) / 2;
      i2 = i4 - this.jdField_b_of_type_Int / 2;
      i1 = i4 + this.jdField_b_of_type_Int / 2;
      n = i3 - this.jdField_c_of_type_Int / 2;
      m = this.jdField_c_of_type_Int / 2 + i3;
      if ((this.jdField_d_of_type_Int != 1) || (this.jdField_a_of_type_Boolean)) {
        break label551;
      }
      if (((this.jdField_a_of_type_Akxd.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Akxd.jdField_b_of_type_Boolean)) && (this.jdField_d_of_type_Boolean))
      {
        localDrawable1 = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
        label190:
        if (((!this.jdField_a_of_type_Akxd.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Akxd.jdField_b_of_type_Boolean)) || (!this.jdField_d_of_type_Boolean)) {
          break label542;
        }
      }
      break;
    }
    label542:
    for (Drawable localDrawable2 = a();; localDrawable2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
    {
      if (this.jdField_a_of_type_Akxd.jdField_a_of_type_Float != 1.0F) {
        paramCanvas.scale(this.jdField_a_of_type_Akxd.jdField_a_of_type_Float, this.jdField_a_of_type_Akxd.jdField_a_of_type_Float, i4, i3);
      }
      if (localDrawable2 != null)
      {
        localDrawable2.setBounds(i2, n, i1, m);
        localDrawable2.draw(paramCanvas);
      }
      if ((localDrawable1 != null) && (this.jdField_b_of_type_Boolean))
      {
        localDrawable1.setBounds(i2, n, i1, m);
        localDrawable1.draw(paramCanvas);
      }
      return;
      i4 = (i2 + i1) / 2;
      i3 = n + this.jdField_c_of_type_Int / 2;
      i2 = i4 - this.jdField_b_of_type_Int / 2;
      i1 = i4 + this.jdField_b_of_type_Int / 2;
      m = this.jdField_c_of_type_Int + n;
      break;
      i4 = (i2 + i1) / 2;
      i3 = m - this.jdField_c_of_type_Int / 2;
      i2 = i4 - this.jdField_b_of_type_Int / 2;
      i1 = i4 + this.jdField_b_of_type_Int / 2;
      n = m - this.jdField_c_of_type_Int;
      break;
      i4 = i2 + this.jdField_b_of_type_Int / 2;
      i3 = (m + n) / 2;
      i1 = i2 + this.jdField_b_of_type_Int;
      n = i3 - this.jdField_c_of_type_Int / 2;
      m = this.jdField_c_of_type_Int / 2 + i3;
      break;
      i4 = i1 - this.jdField_b_of_type_Int / 2;
      i3 = (m + n) / 2;
      i2 = i1 - this.jdField_b_of_type_Int / 2;
      n = i3 - this.jdField_c_of_type_Int / 2;
      m = this.jdField_c_of_type_Int / 2 + i3;
      break;
      localDrawable1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      break label190;
    }
    label551:
    label564:
    label577:
    double d2;
    double d1;
    label669:
    label681:
    int i6;
    label702:
    label710:
    int i7;
    int i8;
    label738:
    int i5;
    if (this.jdField_d_of_type_Boolean)
    {
      localDrawable1 = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
      if (!this.jdField_d_of_type_Boolean) {
        break label843;
      }
      localDrawable2 = a();
      if ((int)Math.sqrt(Math.pow(this.jdField_b_of_type_Int / 2 + Math.abs(this.jdField_c_of_type_Float), 2.0D) + Math.pow(this.jdField_c_of_type_Int / 2 + Math.abs(this.jdField_d_of_type_Float), 2.0D)) <= this.j) {
        break label955;
      }
      if ((this.jdField_c_of_type_Float != 0.0F) && (this.jdField_d_of_type_Float != 0.0F)) {
        break label881;
      }
      if (this.jdField_c_of_type_Float == 0.0F) {
        break label852;
      }
      d2 = this.k;
      d1 = 0.0D;
      if (this.jdField_c_of_type_Float <= 0.0F) {
        break label943;
      }
      i3 = 1;
      i6 = (int)(d2 * i3);
      if (this.jdField_d_of_type_Float <= 0.0F) {
        break label949;
      }
      i3 = 1;
      i3 = (int)(d1 * i3);
      i7 = i6 * 2;
      i8 = i3 * 2;
      if (localDrawable2 != null)
      {
        if (!this.jdField_e_of_type_Boolean) {
          break label972;
        }
        i4 = i2;
        if (!this.jdField_e_of_type_Boolean) {
          break label982;
        }
        i5 = n;
        label749:
        if (!this.jdField_e_of_type_Boolean) {
          break label992;
        }
        i6 = i1;
        label760:
        if (!this.jdField_e_of_type_Boolean) {
          break label1002;
        }
      }
    }
    label843:
    label852:
    label982:
    label992:
    label1002:
    for (int i3 = m;; i3 = m - i3)
    {
      localDrawable2.setBounds(i4, i5, i6, i3);
      localDrawable2.draw(paramCanvas);
      if ((localDrawable1 == null) || (!this.jdField_b_of_type_Boolean)) {
        break;
      }
      localDrawable1.setBounds(i2 - i7, n - i8, i1 - i7, m - i8);
      localDrawable1.draw(paramCanvas);
      return;
      localDrawable1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      break label564;
      localDrawable2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label577;
      if (this.jdField_d_of_type_Float != 0.0F)
      {
        d2 = 0.0D;
        d1 = this.k;
        break label669;
      }
      d2 = 0.0D;
      d1 = 0.0D;
      break label669;
      label881:
      d1 = Math.pow(this.jdField_d_of_type_Float, 2.0D) / Math.pow(this.jdField_c_of_type_Float, 2.0D);
      d2 = this.k * (1.0D / Math.sqrt(1.0D + d1));
      double d3 = this.k;
      d1 = Math.sqrt(d1 / (1.0D + d1)) * d3;
      break label669;
      i3 = -1;
      break label681;
      i3 = -1;
      break label702;
      i6 = (int)this.jdField_c_of_type_Float;
      i3 = (int)this.jdField_d_of_type_Float;
      break label710;
      i4 = i2 - i6;
      break label738;
      i5 = n - i3;
      break label749;
      i6 = i1 - i6;
      break label760;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    int i4 = this.jdField_g_of_type_Int;
    int m = getPaddingTop();
    int n = getPaddingBottom();
    int i1 = this.h;
    paramInt1 = resolveSizeAndState(i2 + i3 + i4, paramInt1, 0);
    paramInt2 = resolveSizeAndState(m + n + i1, paramInt2, 0);
    View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    a(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f2 = 0.0F;
    int m = 0;
    int n = getPaddingLeft();
    int i5 = getRight();
    int i6 = getLeft();
    int i7 = getPaddingRight();
    int i1 = getPaddingTop();
    int i2 = getBottom();
    int i3 = getTop();
    int i4 = getPaddingBottom();
    n = (n + (i5 - i6 - i7)) / 2;
    i2 = (i1 + (i2 - i3 - i4)) / 2;
    i1 = (int)Math.sqrt(Math.pow(this.jdField_b_of_type_Int / 2.0D, 2.0D) + Math.pow(this.jdField_c_of_type_Int / 2.0D, 2.0D));
    switch (paramMotionEvent.getActionMasked())
    {
    }
    label464:
    do
    {
      do
      {
        return false;
        if (!this.jdField_g_of_type_Boolean) {
          break;
        }
        i3 = (int)(DeviceInfoUtil.k() - ViewUtils.a(14.0F));
        if (this.jdField_e_of_type_Float <= i3) {
          break;
        }
        this.jdField_a_of_type_Float = 0.0F;
        this.jdField_b_of_type_Float = 0.0F;
        this.jdField_e_of_type_Float = 0.0F;
        this.l = -1;
        this.jdField_f_of_type_Boolean = false;
      } while (!this.jdField_a_of_type_Boolean);
      b();
      return false;
      this.l = -1;
      this.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_Boolean) {
        b();
      }
      i3 = (int)Math.sqrt(Math.pow(this.jdField_a_of_type_Float - n, 2.0D) + Math.pow(this.jdField_b_of_type_Float - i2, 2.0D));
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      double d1 = Math.pow(f1 - n, 2.0D);
      n = (int)Math.sqrt(Math.pow(f2 - i2, 2.0D) + d1);
      if ((i3 > i1) || (n <= i1)) {
        m = 1;
      }
      if ((getParent() != null) && (m != 0)) {
        ((ViewGroup)getParent()).performClick();
      }
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_e_of_type_Float = paramMotionEvent.getRawY();
      this.l = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
      if ((int)Math.sqrt(Math.pow(this.jdField_a_of_type_Float - n, 2.0D) + Math.pow(this.jdField_b_of_type_Float - i2, 2.0D)) <= i1)
      {
        if (!this.jdField_d_of_type_Boolean) {
          break label464;
        }
        c();
      }
      for (;;)
      {
        return true;
        d();
      }
    } while (!this.jdField_b_of_type_Boolean);
    m = paramMotionEvent.findPointerIndex(this.l);
    if (m == -1)
    {
      this.jdField_f_of_type_Boolean = false;
      return false;
    }
    float f3 = paramMotionEvent.getX(m);
    float f1 = paramMotionEvent.getY(m);
    if (((int)Math.sqrt(Math.pow(f3 - n, 2.0D) + Math.pow(f1 - i2, 2.0D)) <= this.j) && (f3 != this.jdField_a_of_type_Float) && (f1 != this.jdField_b_of_type_Float))
    {
      f2 = this.jdField_a_of_type_Float;
      float f4 = this.jdField_b_of_type_Float;
      this.jdField_f_of_type_Boolean = true;
      f1 = f4 - f1;
      f2 -= f3;
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Boolean) {
        a(f2, f1, false);
      }
      return this.jdField_f_of_type_Boolean;
      if (this.jdField_f_of_type_Boolean)
      {
        f2 = this.jdField_a_of_type_Float - f3;
        f1 = this.jdField_b_of_type_Float - f1;
      }
      else
      {
        f1 = 0.0F;
      }
    }
  }
  
  public void setAnimEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setEmotionDrawable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Resources localResources = getResources();
    this.jdField_e_of_type_Int = paramInt5;
    this.jdField_f_of_type_Int = paramInt6;
    if (paramInt1 != -1) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(paramInt1);
    }
    if (paramInt2 != -1) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(paramInt2);
    }
    if (paramInt3 != -1) {
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(paramInt3);
    }
    if (paramInt4 != -1) {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(paramInt4);
    }
  }
  
  public void setEmotionDrawable(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable1;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable2;
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramDrawable3;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable4;
  }
  
  public void setExpectedLogoMoveDistance(int paramInt)
  {
    this.i = paramInt;
    if (paramInt != -1) {
      this.k = ((int)Math.sqrt(Math.pow(this.i, 2.0D) * 2.0D));
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 3) || (paramInt == 4) || (paramInt == 1) || (paramInt == 2))
    {
      this.jdField_a_of_type_Int = paramInt;
      invalidate();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("TabDragAnimationView", 2, "unsupported gravity=" + paramInt);
  }
  
  public void setIconSize(int paramInt1, int paramInt2)
  {
    Drawable localDrawable;
    if (((this.jdField_a_of_type_Akxd.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Akxd.jdField_b_of_type_Boolean)) && (this.jdField_d_of_type_Boolean))
    {
      localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      if (paramInt2 < 0) {
        break label111;
      }
      this.h = paramInt2;
      label41:
      if (paramInt1 < 0) {
        break label126;
      }
      this.jdField_g_of_type_Int = paramInt1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabDragAnimationView", 2, "setIconSize, mExpectedLogoWidth=" + this.jdField_g_of_type_Int + ", mExpectedLogoHeight=" + this.h);
      }
      requestLayout();
      return;
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break;
      label111:
      if (localDrawable == null) {
        break label41;
      }
      this.h = localDrawable.getIntrinsicHeight();
      break label41;
      label126:
      if (localDrawable != null) {
        this.jdField_g_of_type_Int = localDrawable.getIntrinsicWidth();
      }
    }
  }
  
  public void setPressChanged(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable == a()))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localDrawable instanceof ApngDrawable)) {
        ((ApngDrawable)localDrawable).repaly();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabDragAnimationView
 * JD-Core Version:    0.7.0.1
 */