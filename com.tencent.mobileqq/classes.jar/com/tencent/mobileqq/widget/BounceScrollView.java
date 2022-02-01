package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.widget.OnSizeChangeListener;
import com.tencent.widget.ScrollView;

public class BounceScrollView
  extends ScrollView
{
  private static boolean i;
  private int a = 0;
  private boolean b = false;
  private boolean c;
  private int d;
  private int e;
  protected BounceScrollView.OnScrollChangedListener f;
  ScrollListener g = null;
  OnSizeChangeListener h;
  private GestureDetector j = new GestureDetector(getContext(), new BounceScrollView.1(this));
  private OnInterceptTouchEventListener k;
  private BounceScrollView.MotionEventInterceptor l;
  private BounceScrollView.DrawFinishedListener m;
  private int n;
  private int o;
  private Paint p;
  private float q;
  private boolean r = false;
  private int[] s = { -654311425, -654311425 };
  private float[] t = { 0.0F, 1.0F };
  
  public BounceScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(9)
  public BounceScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOverScrollMode(0);
    setFadingEdgeLength(0);
  }
  
  private void a()
  {
    if (this.r)
    {
      this.p.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, this.q, this.s, this.t, Shader.TileMode.CLAMP));
      this.n = getWidth();
      this.o = getHeight();
    }
  }
  
  public static void setEnableTalkBack(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    paramCanvas = this.m;
    if (paramCanvas != null) {
      paramCanvas.a();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.l;
    boolean bool2 = false;
    if (localObject != null)
    {
      localObject = MotionEvent.obtain(paramMotionEvent);
      if (localObject != null)
      {
        bool1 = this.l.a(this, (MotionEvent)localObject);
        ((MotionEvent)localObject).recycle();
        break label48;
      }
    }
    boolean bool1 = false;
    label48:
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 1)
    {
      localObject = this.f;
      if (localObject != null) {
        ((BounceScrollView.OnScrollChangedListener)localObject).a(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
      localObject = this.g;
      if (localObject != null) {
        ((ScrollListener)localObject).onFingerUpOrCancel(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
    else if (i1 == 3)
    {
      localObject = this.g;
      if (localObject != null) {
        ((ScrollListener)localObject).onFingerUpOrCancel(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
    else if (i1 == 0)
    {
      localObject = this.g;
      if (localObject != null) {
        ((ScrollListener)localObject).onFingerDown(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
    if (!bool1) {}
    try
    {
      boolean bool3 = super.dispatchTouchEvent(paramMotionEvent);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramMotionEvent) {}
    return bool1;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (!this.r) {
      return super.drawChild(paramCanvas, paramView, paramLong);
    }
    int i1 = paramCanvas.saveLayer(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight(), null, 31);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    int i2 = paramCanvas.save();
    paramCanvas.drawRect(0.0F, this.o + getScrollY() - this.q, this.n, this.o + getScrollY(), this.p);
    paramCanvas.restoreToCount(i2);
    paramCanvas.restoreToCount(i1);
    return bool;
  }
  
  public void fling(int paramInt)
  {
    super.fling(paramInt);
    ScrollListener localScrollListener = this.g;
    if (localScrollListener != null) {
      localScrollListener.fling(this, paramInt);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    OnInterceptTouchEventListener localOnInterceptTouchEventListener = this.k;
    if (localOnInterceptTouchEventListener != null) {
      localOnInterceptTouchEventListener.onInterceptTouchEvent(paramMotionEvent);
    }
    try
    {
      if (this.b)
      {
        super.onInterceptTouchEvent(paramMotionEvent);
        return this.j.onTouchEvent(paramMotionEvent);
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      label47:
      break label47;
    }
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = this.a;
    if (i1 > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i1, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.f;
    if (localObject != null) {
      ((BounceScrollView.OnScrollChangedListener)localObject).a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.g;
    if (localObject != null) {
      ((ScrollListener)localObject).onScrollChanged(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.r) {
      getChildAt(0).invalidate();
    }
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
    OnSizeChangeListener localOnSizeChangeListener = this.h;
    if (localOnSizeChangeListener != null) {
      localOnSizeChangeListener.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4, false, 0);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getAction() & 0xFF) == 2) && (this.c) && (this.d < 0) && (this.e > 0))
    {
      View localView = getChildAt(0);
      if (localView != null)
      {
        int i1 = getScrollY();
        if (i1 < this.d) {
          return true;
        }
        int i2 = localView.getMeasuredHeight();
        int i3 = getHeight();
        if ((i1 > 0) && (i3 > 0) && (i2 > 0) && (i2 + this.e <= i1 + i3)) {
          return true;
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDrawFinishedListener(BounceScrollView.DrawFinishedListener paramDrawFinishedListener)
  {
    this.m = paramDrawFinishedListener;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setMotionEventInterceptor(BounceScrollView.MotionEventInterceptor paramMotionEventInterceptor)
  {
    this.l = paramMotionEventInterceptor;
  }
  
  public void setNeedHorizontalGesture(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener paramOnInterceptTouchEventListener)
  {
    this.k = paramOnInterceptTouchEventListener;
  }
  
  public void setOnScrollChangedListener(BounceScrollView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.f = paramOnScrollChangedListener;
  }
  
  public void setOnSizeChangeListener(OnSizeChangeListener paramOnSizeChangeListener)
  {
    this.h = paramOnSizeChangeListener;
  }
  
  public void setScrollListener(ScrollListener paramScrollListener)
  {
    this.g = paramScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BounceScrollView
 * JD-Core Version:    0.7.0.1
 */