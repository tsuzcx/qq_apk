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
  protected int a;
  private float b;
  private int c;
  private float d;
  private int e;
  private float f;
  private GestureDetector g;
  private final OverScrollEffect h = new OverScrollEffect(this);
  private Camera i = new Camera();
  private List<BounceViewPager.PageChangedObserver> j = new ArrayList();
  
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
    this.g = new GestureDetector(getContext(), new BounceViewPager.ScrollDetector(this));
    this.e = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    Object localObject = new Point();
    ((WindowManager)BaseApplication.getContext().getSystemService("window")).getDefaultDisplay().getSize((Point)localObject);
    this.f = (((Point)localObject).x / 2);
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
    int k = 0;
    while (k < getChildCount())
    {
      getChildAt(k).invalidate();
      k += 1;
    }
  }
  
  public void a(BounceViewPager.PageChangedObserver paramPageChangedObserver)
  {
    if (!this.j.contains(paramPageChangedObserver)) {
      this.j.add(paramPageChangedObserver);
    }
  }
  
  public void b(BounceViewPager.PageChangedObserver paramPageChangedObserver)
  {
    if (this.j.contains(paramPageChangedObserver)) {
      this.j.remove(paramPageChangedObserver);
    }
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    if (paramView.getWidth() == 0) {
      return false;
    }
    int k = paramView.getLeft() / paramView.getWidth();
    if ((k != 0) && (k != getAdapter().getCount() - 1)) {
      k = 0;
    } else {
      k = 1;
    }
    if ((this.h.a()) && (k != 0))
    {
      paramTransformation.clear();
      paramTransformation.setTransformationType(2);
      float f2 = getWidth() / 2;
      k = getHeight() / 2;
      paramTransformation.getMatrix().reset();
      float f3 = this.f;
      float f1;
      if (this.h.a > 0.0F) {
        f1 = Math.min(this.h.a, 1.0F);
      } else {
        f1 = Math.max(this.h.a, -1.0F);
      }
      this.i.save();
      this.i.translate(-(f3 * f1), 0.0F, 0.0F);
      this.i.getMatrix(paramTransformation.getMatrix());
      paramTransformation.getMatrix().preTranslate(-f2, -k);
      paramTransformation.getMatrix().postTranslate(f2, k);
      this.i.restore();
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      int k = paramMotionEvent.getAction() & 0xFF;
      if (k != 0)
      {
        if (k == 5)
        {
          k = MotionEventCompat.getActionIndex(paramMotionEvent);
          this.b = MotionEventCompat.getX(paramMotionEvent, k);
          this.c = MotionEventCompat.getPointerId(paramMotionEvent, k);
        }
      }
      else
      {
        this.b = paramMotionEvent.getX();
        this.c = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      }
      if (this.g.onTouchEvent(paramMotionEvent))
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
    int k;
    try
    {
      k = paramMotionEvent.getAction();
      if (k != 0) {
        if (k != 1) {
          if (k != 2)
          {
            if (k == 3) {
              break label363;
            }
            if (k != 5)
            {
              if (k != 6) {
                break label357;
              }
              k = (paramMotionEvent.getAction() & 0xFF00) >> 8;
              if (MotionEventCompat.getPointerId(paramMotionEvent, k) != this.c) {
                break label357;
              }
              if (k != 0) {
                break label452;
              }
              k = 1;
              this.b = paramMotionEvent.getX(k);
              this.c = MotionEventCompat.getPointerId(paramMotionEvent, k);
              break label458;
            }
          }
        }
      }
      try
      {
        k = MotionEventCompat.getActionIndex(paramMotionEvent);
        this.b = MotionEventCompat.getX(paramMotionEvent, k);
        this.c = MotionEventCompat.getPointerId(paramMotionEvent, k);
      }
      catch (Exception localException1)
      {
        float f3;
        float f1;
        float f5;
        int m;
        int n;
        int i1;
        float f4;
        float f2;
        label357:
        k = 1;
        break label411;
      }
      if (this.c != -1)
      {
        f3 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.c));
        f1 = this.b - f3;
        f5 = getScrollX();
        k = getWidth();
        m = getPageMargin() + k - (getPaddingLeft() + getPaddingRight());
        n = getAdapter().getCount() - 1;
        i1 = getCurrentItem();
        f4 = Math.max(0, (i1 - 1) * m);
        f2 = Math.min(i1 + 1, n) * m;
        f5 += f1;
        if (this.d == 0.0F)
        {
          if (f5 < f4)
          {
            if (f4 == 0.0F)
            {
              f2 = this.e;
              this.h.a((f1 + f2) / k);
            }
          }
          else if ((f5 > f2) && (f2 == n * m))
          {
            f1 = this.e;
            this.h.a((f5 - f2 - f1) / k);
          }
        }
        else {
          this.b = f3;
        }
      }
      else
      {
        this.h.c();
      }
      k = 0;
      break label423;
      label363:
      this.c = -1;
      this.h.c();
      break label458;
      this.b = paramMotionEvent.getX();
      this.c = MotionEventCompat.getPointerId(paramMotionEvent, 0);
    }
    catch (Exception localException2)
    {
      k = 0;
    }
    label411:
    QLog.e("BounceViewPager", 1, "onTouchEvent", localException2);
    for (;;)
    {
      label423:
      if (((this.h.a()) && (k == 0)) || (super.onTouchEvent(paramMotionEvent))) {
        bool = true;
      }
      return bool;
      label452:
      k = 0;
      break;
      label458:
      k = 1;
    }
  }
  
  public void setPull(float paramFloat)
  {
    this.h.a(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.bounce.BounceViewPager
 * JD-Core Version:    0.7.0.1
 */