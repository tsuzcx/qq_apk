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
    int n = this.g / 2;
    Object localObject = new RoundRectShape(new float[] { n, n, n, n, n, n, n, n }, null, null);
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
        localObject = new FrameLayout.LayoutParams(this.g, this.g);
        ((FrameLayout.LayoutParams)localObject).topMargin = this.g;
        return localObject;
      }
      if ((localObject instanceof LinearLayout.LayoutParams))
      {
        localObject = new LinearLayout.LayoutParams(this.g, this.g);
        ((LinearLayout.LayoutParams)localObject).topMargin = this.g;
        return localObject;
      }
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = new RelativeLayout.LayoutParams(this.g, this.g);
        ((RelativeLayout.LayoutParams)localObject).topMargin = this.g;
        return localObject;
      }
      localObject = new ViewGroup.MarginLayoutParams(this.g, this.g);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = this.g;
      return localObject;
    }
    Object localObject = new ViewGroup.MarginLayoutParams(this.g, this.g);
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
    boolean bool = true;
    int i3 = 0;
    label47:
    int m;
    int i5;
    int i1;
    int i4;
    int i6;
    int n;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (;;)
      {
        bool = super.onTouchEvent(paramMotionEvent);
        return bool;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.a = ((int)paramMotionEvent.getRawX());
        this.b = ((int)paramMotionEvent.getRawY());
        this.c = getLeft();
        this.d = getRight();
        this.e = getTop();
        this.f = getBottom();
      }
    case 2: 
      m = (int)paramMotionEvent.getRawX() - this.a;
      i5 = (int)paramMotionEvent.getRawY() - this.b;
      i1 = this.c + m;
      i4 = this.e + i5;
      m += this.d;
      i6 = this.f;
      n = i1;
      if (i1 < 0)
      {
        m = getWidth() + 0;
        n = 0;
      }
      if (m > this.j) {
        i1 = this.j;
      }
      break;
    }
    for (int i2 = i1 - getWidth();; i2 = n)
    {
      if (i4 < 0) {
        m = getHeight() + 0;
      }
      for (n = i3;; n = i4)
      {
        i3 = m;
        if (m > this.k)
        {
          i3 = this.k;
          n = i3 - getHeight();
        }
        layout(i2, n, i1, i3);
        break;
        getParent().requestDisallowInterceptTouchEvent(false);
        ValueAnimator localValueAnimator;
        if (getLeft() > this.j / 2)
        {
          localValueAnimator = ObjectAnimator.ofInt(new int[] { getLeft(), this.j - getWidth() });
          localValueAnimator.addUpdateListener(this);
          localValueAnimator.start();
        }
        for (;;)
        {
          m = (int)paramMotionEvent.getRawX();
          n = (int)paramMotionEvent.getRawY();
          if (Math.abs(this.a - m) > this.i) {
            break label47;
          }
          if (Math.abs(this.b - n) <= this.i) {
            break;
          }
          return true;
          localValueAnimator = ObjectAnimator.ofInt(new int[] { getLeft(), 0 });
          localValueAnimator.addUpdateListener(this);
          localValueAnimator.start();
        }
        m = i5 + i6;
      }
      i1 = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.e
 * JD-Core Version:    0.7.0.1
 */