package com.tencent.mtt.hippy.a;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mtt.hippy.HippyRootView;

public class e
  extends ImageView
  implements ValueAnimator.AnimatorUpdateListener, ViewTreeObserver.OnGlobalLayoutListener
{
  int a;
  int b;
  int c = 0;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = 0;
  final int h = 30;
  final int i = ViewConfiguration.getTouchSlop();
  private int j = -1;
  private int k = -1;
  
  public e(Context paramContext)
  {
    super(paramContext);
    b();
    setFocusable(true);
  }
  
  private void a()
  {
    int m = Color.parseColor("#ddd9d9");
    StateListDrawable localStateListDrawable = new StateListDrawable();
    float f1 = this.g / 2;
    Object localObject = new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null);
    ShapeDrawable localShapeDrawable = new ShapeDrawable((Shape)localObject);
    localShapeDrawable.getPaint().setColor(-16711936);
    localStateListDrawable.addState(new int[] { 16842908, 16842910 }, localShapeDrawable);
    localObject = new ShapeDrawable((Shape)localObject);
    ((ShapeDrawable)localObject).getPaint().setColor(m);
    localStateListDrawable.addState(new int[0], (Drawable)localObject);
    setBackgroundDrawable(localStateListDrawable);
    Looper.getMainLooper();
    Looper.myQueue().addIdleHandler(new e.1(this));
  }
  
  private void b()
  {
    a();
  }
  
  private ViewGroup.MarginLayoutParams getMarginLayoutParams()
  {
    if (getParent() != null)
    {
      localObject = getLayoutParams();
      if ((localObject instanceof FrameLayout.LayoutParams))
      {
        m = this.g;
        localObject = new FrameLayout.LayoutParams(m, m);
        ((FrameLayout.LayoutParams)localObject).topMargin = this.g;
        return localObject;
      }
      if ((localObject instanceof LinearLayout.LayoutParams))
      {
        m = this.g;
        localObject = new LinearLayout.LayoutParams(m, m);
        ((LinearLayout.LayoutParams)localObject).topMargin = this.g;
        return localObject;
      }
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        m = this.g;
        localObject = new RelativeLayout.LayoutParams(m, m);
        ((RelativeLayout.LayoutParams)localObject).topMargin = this.g;
        return localObject;
      }
      m = this.g;
      localObject = new ViewGroup.MarginLayoutParams(m, m);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = this.g;
      return localObject;
    }
    int m = this.g;
    Object localObject = new ViewGroup.MarginLayoutParams(m, m);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = this.g;
    return localObject;
  }
  
  float a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    return TypedValue.applyDimension(1, paramInt, paramContext);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator != null) && ((paramValueAnimator instanceof Number)))
    {
      int m = ((Number)paramValueAnimator).intValue();
      layout(m, getTop(), getWidth() + m, getBottom());
    }
  }
  
  protected void onAttachedToWindow()
  {
    setLayoutParams(getMarginLayoutParams());
    getViewTreeObserver().addOnGlobalLayoutListener(this);
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof HippyRootView))
    {
      ViewGroup localViewGroup = (ViewGroup)getRootView();
      if (localViewGroup != localViewParent)
      {
        ((HippyRootView)localViewParent).removeView(this);
        localViewGroup.addView(this);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (Build.VERSION.SDK_INT >= 16)
    {
      getViewTreeObserver().removeOnGlobalLayoutListener(this);
      return;
    }
    getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
  
  public void onGlobalLayout()
  {
    this.j = ((ViewGroup)getParent()).getWidth();
    this.k = ((ViewGroup)getParent()).getHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      int i3 = 0;
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3) {
            break label384;
          }
        }
        else
        {
          n = (int)paramMotionEvent.getRawX() - this.a;
          m = (int)paramMotionEvent.getRawY() - this.b;
          int i1 = this.c + n;
          int i4 = this.e + m;
          n = this.d + n;
          int i5 = this.f + m;
          m = i1;
          if (i1 < 0)
          {
            n = getWidth() + 0;
            m = 0;
          }
          i1 = this.j;
          int i2;
          if (n > i1)
          {
            i2 = i1 - getWidth();
          }
          else
          {
            i2 = m;
            i1 = n;
          }
          if (i4 < 0)
          {
            m = getHeight() + 0;
            n = i3;
          }
          else
          {
            n = i4;
            m = i5;
          }
          i4 = this.k;
          i3 = m;
          if (m > i4)
          {
            n = i4 - getHeight();
            i3 = i4;
          }
          layout(i2, n, i1, i3);
          break label384;
        }
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      ValueAnimator localValueAnimator;
      if (getLeft() > this.j / 2) {
        localValueAnimator = ObjectAnimator.ofInt(new int[] { getLeft(), this.j - getWidth() });
      } else {
        localValueAnimator = ObjectAnimator.ofInt(new int[] { getLeft(), 0 });
      }
      localValueAnimator.addUpdateListener(this);
      localValueAnimator.start();
      m = (int)paramMotionEvent.getRawX();
      int n = (int)paramMotionEvent.getRawY();
      if ((Math.abs(this.a - m) > this.i) || (Math.abs(this.b - n) > this.i)) {
        return true;
      }
    }
    else
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      this.a = ((int)paramMotionEvent.getRawX());
      this.b = ((int)paramMotionEvent.getRawY());
      this.c = getLeft();
      this.d = getRight();
      this.e = getTop();
      this.f = getBottom();
    }
    label384:
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.e
 * JD-Core Version:    0.7.0.1
 */