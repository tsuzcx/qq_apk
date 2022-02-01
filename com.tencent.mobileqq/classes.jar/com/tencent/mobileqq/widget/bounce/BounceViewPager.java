package com.tencent.mobileqq.widget.bounce;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.Transformation;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BounceViewPager
  extends ViewPager
{
  private float jdField_a_of_type_Float;
  protected int a;
  private Camera jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private final OverScrollEffect jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect = new OverScrollEffect(this);
  private List<BounceViewPager.PageChangedObserver> jdField_a_of_type_JavaUtilList = new ArrayList();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  
  public BounceViewPager(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public BounceViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    setStaticTransformationsEnabled(true);
    setOnPageChangeListener(new BounceViewPager.MyOnPageChangeListener(this, null));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new BounceViewPager.ScrollDetector(this));
    this.jdField_c_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    Object localObject = new Point();
    ((WindowManager)BaseApplication.getContext().getSystemService("window")).getDefaultDisplay().getSize((Point)localObject);
    this.jdField_c_of_type_Float = (((Point)localObject).x / 2);
    localObject = new FixedSpeedScroller(getContext());
    ((FixedSpeedScroller)localObject).a(850);
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      localField.set(this, localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void a()
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).invalidate();
      i += 1;
    }
  }
  
  public void a(BounceViewPager.PageChangedObserver paramPageChangedObserver)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramPageChangedObserver)) {
      this.jdField_a_of_type_JavaUtilList.add(paramPageChangedObserver);
    }
  }
  
  public void b(BounceViewPager.PageChangedObserver paramPageChangedObserver)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramPageChangedObserver)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramPageChangedObserver);
    }
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    if (paramView.getWidth() == 0) {
      return false;
    }
    int i = paramView.getLeft() / paramView.getWidth();
    if ((i != 0) && (i != getAdapter().getCount() - 1)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect.a()) && (i != 0))
    {
      paramTransformation.clear();
      paramTransformation.setTransformationType(2);
      float f2 = getWidth() / 2;
      i = getHeight() / 2;
      paramTransformation.getMatrix().reset();
      float f3 = this.jdField_c_of_type_Float;
      float f1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect.jdField_a_of_type_Float > 0.0F) {
        f1 = Math.min(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect.jdField_a_of_type_Float, 1.0F);
      } else {
        f1 = Math.max(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect.jdField_a_of_type_Float, -1.0F);
      }
      this.jdField_a_of_type_AndroidGraphicsCamera.save();
      this.jdField_a_of_type_AndroidGraphicsCamera.translate(-(f3 * f1), 0.0F, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(paramTransformation.getMatrix());
      paramTransformation.getMatrix().preTranslate(-f2, -i);
      paramTransformation.getMatrix().postTranslate(f2, i);
      this.jdField_a_of_type_AndroidGraphicsCamera.restore();
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0)
      {
        if (i == 5)
        {
          i = MotionEventCompat.getActionIndex(paramMotionEvent);
          this.jdField_a_of_type_Float = MotionEventCompat.getX(paramMotionEvent, i);
          this.jdField_b_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, i);
        }
      }
      else
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      }
      if (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))
      {
        super.onInterceptTouchEvent(paramMotionEvent);
        return true;
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i;
    try
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i != 1) {
          if (i != 2)
          {
            if (i == 3) {
              break label363;
            }
            if (i != 5)
            {
              if (i != 6) {
                break label357;
              }
              i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
              if (MotionEventCompat.getPointerId(paramMotionEvent, i) != this.jdField_b_of_type_Int) {
                break label357;
              }
              if (i != 0) {
                break label452;
              }
              i = 1;
              this.jdField_a_of_type_Float = paramMotionEvent.getX(i);
              this.jdField_b_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, i);
              break label458;
            }
          }
        }
      }
      try
      {
        i = MotionEventCompat.getActionIndex(paramMotionEvent);
        this.jdField_a_of_type_Float = MotionEventCompat.getX(paramMotionEvent, i);
        this.jdField_b_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, i);
      }
      catch (Exception localException1)
      {
        float f3;
        float f1;
        float f5;
        int j;
        int k;
        int m;
        float f4;
        float f2;
        label357:
        i = 1;
        break label411;
      }
      if (this.jdField_b_of_type_Int != -1)
      {
        f3 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.jdField_b_of_type_Int));
        f1 = this.jdField_a_of_type_Float - f3;
        f5 = getScrollX();
        i = getWidth();
        j = getPageMargin() + i - (getPaddingLeft() + getPaddingRight());
        k = getAdapter().getCount() - 1;
        m = getCurrentItem();
        f4 = Math.max(0, (m - 1) * j);
        f2 = Math.min(m + 1, k) * j;
        f5 += f1;
        if (this.jdField_b_of_type_Float == 0.0F)
        {
          if (f5 < f4)
          {
            if (f4 == 0.0F)
            {
              f2 = this.jdField_c_of_type_Int;
              this.jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect.a((f1 + f2) / i);
            }
          }
          else if ((f5 > f2) && (f2 == k * j))
          {
            f1 = this.jdField_c_of_type_Int;
            this.jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect.a((f5 - f2 - f1) / i);
          }
        }
        else {
          this.jdField_a_of_type_Float = f3;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect.b();
      }
      i = 0;
      break label423;
      label363:
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect.b();
      break label458;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
    }
    catch (Exception localException2)
    {
      i = 0;
    }
    label411:
    QLog.e("BounceViewPager", 1, "onTouchEvent", localException2);
    for (;;)
    {
      label423:
      if (((this.jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect.a()) && (i == 0)) || (super.onTouchEvent(paramMotionEvent))) {
        bool = true;
      }
      return bool;
      label452:
      i = 0;
      break;
      label458:
      i = 1;
    }
  }
  
  public void setPull(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceOverScrollEffect.a(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.bounce.BounceViewPager
 * JD-Core Version:    0.7.0.1
 */