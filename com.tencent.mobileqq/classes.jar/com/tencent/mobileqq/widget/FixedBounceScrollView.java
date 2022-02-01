package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class FixedBounceScrollView
  extends ScrollView
{
  boolean a;
  private boolean b;
  private float c;
  private boolean d;
  private long e;
  private int f;
  private Interpolator g;
  private View h;
  private float i;
  private int j;
  private int k;
  private Rect l = new Rect();
  private TranslateAnimation m;
  private FixedBounceScrollView.OnScrollListener n;
  private FixedBounceScrollView.OnOverScrollListener o;
  private float p = -1.0F;
  private float q = -1.0F;
  private float r = -1.0F;
  private float s = -1.0F;
  private int t;
  
  public FixedBounceScrollView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FixedBounceScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FixedBounceScrollView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = false;
    this.a = false;
    this.t = 0;
    setOverScrollMode(2);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setFillViewport(true);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aB, 0, 0);
    this.c = paramContext.getFloat(R.styleable.aD, 4.0F);
    if (paramContext.getInt(R.styleable.aF, 0) == 1) {
      bool = true;
    }
    this.b = bool;
    this.d = paramContext.getBoolean(R.styleable.aE, true);
    this.e = paramContext.getInt(R.styleable.aC, 400);
    this.f = paramContext.getInt(R.styleable.aG, 20);
    paramContext.recycle();
    if (this.d) {
      this.g = new FixedBounceScrollView.DefaultQuartOutInterpolator(null);
    }
    setmCustomBottomFadingEdgeScale(0.0F);
    setmCustomTopFadingEdgeScale(0.0F);
  }
  
  private float a()
  {
    int i1;
    if (this.b)
    {
      f1 = Math.abs(this.h.getLeft()) * 1.0F;
      i1 = this.h.getMeasuredWidth();
    }
    else
    {
      f1 = Math.abs(this.h.getTop()) * 1.0F;
      i1 = this.h.getMeasuredHeight();
    }
    double d1 = f1 / i1;
    Double.isNaN(d1);
    float f1 = (float)(d1 + 0.2D);
    if (this.d) {
      return this.c / (1.0F - (float)Math.pow(f1, 2.0D));
    }
    return this.c;
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt < 0)) {
      return c();
    }
    return d();
  }
  
  private void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.h.getLayoutParams();
    boolean bool = this.b;
    int i2 = 0;
    int i1 = 0;
    int i3;
    if (bool)
    {
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        i3 = ViewCompat.getPaddingEnd(this);
        i2 = i3;
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
        {
          i1 = ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin;
          i2 = i3;
        }
      }
      else
      {
        i3 = ViewCompat.getPaddingStart(this);
        i2 = i3;
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
        {
          i1 = ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin;
          i2 = i3;
        }
      }
      this.m = new TranslateAnimation(this.h.getLeft() - i2 - i1, this.l.left - i2 - i1, 0.0F, 0.0F);
    }
    else
    {
      i3 = getPaddingTop();
      i1 = i2;
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        i1 = ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin;
      }
      this.m = new TranslateAnimation(0.0F, 0.0F, this.h.getTop() - i3 - i1, this.l.top - i3 - i1);
    }
    this.m.setInterpolator(this.g);
    this.m.setDuration(this.e);
    this.h.startAnimation(this.m);
    this.h.layout(this.l.left, this.l.top, this.l.right, this.l.bottom);
    this.l.setEmpty();
  }
  
  private boolean c()
  {
    if (this.b)
    {
      if (getScrollX() == 0) {
        return true;
      }
    }
    else if (getScrollY() == 0) {
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    if (this.b)
    {
      i2 = this.h.getMeasuredWidth() - getWidth();
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      return getScrollX() == i1;
    }
    int i2 = this.h.getMeasuredHeight() - getHeight();
    int i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    return getScrollY() == i1;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return this.b;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return this.b ^ true;
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    float f1 = this.q;
    if (f1 != -1.0F) {
      return f1;
    }
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getHeight();
    int i3 = getPaddingBottom();
    i2 = getChildAt(0).getBottom() - getScrollY() - (i2 - i3);
    if (i2 < i1) {
      return i2 / i1;
    }
    return 1.0F;
  }
  
  public long getBounceDelay()
  {
    return this.e;
  }
  
  public float getDamping()
  {
    return this.c;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    float f1 = this.r;
    if (f1 != -1.0F) {
      return f1;
    }
    if (computeHorizontalScrollOffset() > 0) {
      return 1.0F;
    }
    return 0.0F;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    float f1 = this.s;
    if (f1 != -1.0F) {
      return f1;
    }
    if (computeHorizontalScrollOffset() + computeHorizontalScrollExtent() < computeHorizontalScrollRange()) {
      return 1.0F;
    }
    return 0.0F;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    float f1 = this.p;
    if (f1 != -1.0F) {
      return f1;
    }
    int i1 = getVerticalFadingEdgeLength();
    if (getScrollY() < i1) {
      return getScrollY() / i1;
    }
    return 1.0F;
  }
  
  public int getTriggerOverScrollThreshold()
  {
    return this.f;
  }
  
  public float getmCustomBottomFadingEdgeScale()
  {
    return this.q;
  }
  
  public float getmCustomLeftFadingEdgeScale()
  {
    return this.r;
  }
  
  public float getmCustomRightFadingEdgeScale()
  {
    return this.s;
  }
  
  public float getmCustomTopFadingEdgeScale()
  {
    return this.p;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    TranslateAnimation localTranslateAnimation = this.m;
    if ((localTranslateAnimation != null) && (!localTranslateAnimation.hasEnded())) {
      this.m.cancel();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() > 0) {
      this.h = getChildAt(0);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 == 2)
      {
        if (this.b) {
          return Math.abs(paramMotionEvent.getX() - this.i) >= this.f;
        }
        return Math.abs(paramMotionEvent.getY() - this.i) >= this.f;
      }
    }
    else
    {
      float f1;
      if (this.b) {
        f1 = paramMotionEvent.getX();
      } else {
        f1 = paramMotionEvent.getY();
      }
      this.i = f1;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = this.t;
    if (i1 > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i1, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt2 = localView.getMeasuredHeight();
      if (paramInt2 <= 0) {
        return;
      }
      paramInt1 = localView.getMeasuredWidth();
      Object localObject = localView.getLayoutParams();
      if ((localObject instanceof FrameLayout.LayoutParams))
      {
        localObject = (FrameLayout.LayoutParams)localObject;
        int i3 = ((FrameLayout.LayoutParams)localObject).leftMargin;
        i1 = ((FrameLayout.LayoutParams)localObject).topMargin;
        int i4 = ((FrameLayout.LayoutParams)localObject).rightMargin;
        int i2 = ((FrameLayout.LayoutParams)localObject).bottomMargin;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("marginStart=");
          ((StringBuilder)localObject).append(i3);
          ((StringBuilder)localObject).append(" topMargin=");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(" marginEnd=");
          ((StringBuilder)localObject).append(i4);
          ((StringBuilder)localObject).append(" bottomMargin=");
          ((StringBuilder)localObject).append(i2);
          QLog.d("FixedBounceScrollView", 4, ((StringBuilder)localObject).toString());
        }
        if ((i3 != 0) || (i1 != 0) || (i4 != 0) || (i2 != 0))
        {
          if (paramInt2 <= getMeasuredHeight())
          {
            paramInt1 -= i3 + i4;
            paramInt2 -= i1 + i2;
          }
          else
          {
            paramInt2 += i1 + i2;
          }
          localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
        }
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    FixedBounceScrollView.OnScrollListener localOnScrollListener = this.n;
    if (localOnScrollListener != null) {
      localOnScrollListener.a(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.h == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool = true;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          break label557;
        }
      }
      else
      {
        float f1;
        if (this.b) {
          f1 = paramMotionEvent.getX();
        } else {
          f1 = paramMotionEvent.getY();
        }
        int i2 = (int)((this.i - f1) / a());
        this.i = f1;
        setmCustomTopFadingEdgeScale(1.0F);
        setmCustomBottomFadingEdgeScale(1.0F);
        if ((this.j <= 0) && (i2 > 0)) {}
        while ((this.j >= 0) && (i2 < 0))
        {
          i1 = 0;
          break;
        }
        i1 = 1;
        this.j = i2;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dampingDelta=");
          ((StringBuilder)localObject).append(i2);
          QLog.d("FixedBounceScrollView", 2, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mChildView.getTop()+mChildView.getPaddingTop()");
          ((StringBuilder)localObject).append(this.h.getTop());
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.h.getPaddingTop());
          QLog.d("FixedBounceScrollView", 2, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mChildView.getBottom() + mChildView.getPaddingBottom()");
          ((StringBuilder)localObject).append(this.h.getBottom());
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.h.getPaddingBottom());
          QLog.d("FixedBounceScrollView", 2, ((StringBuilder)localObject).toString());
        }
        if ((i1 == 0) || (!a(i2))) {
          break label557;
        }
        if (this.l.isEmpty()) {
          this.l.set(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
        }
        if (this.b)
        {
          localObject = this.h;
          ((View)localObject).layout(((View)localObject).getLeft() - i2, this.h.getTop(), this.h.getRight() - i2, this.h.getBottom());
        }
        else
        {
          localObject = this.h;
          ((View)localObject).layout(((View)localObject).getLeft(), this.h.getTop() - i2 + 2, this.h.getRight(), this.h.getBottom() - i2 + 2);
        }
        Object localObject = this.o;
        if (localObject == null) {
          break label557;
        }
        this.k += i2;
        if (this.k > 0) {
          bool = false;
        }
        ((FixedBounceScrollView.OnOverScrollListener)localObject).a(bool, Math.abs(this.k));
        break label557;
      }
    }
    else
    {
      setmCustomTopFadingEdgeScale(0.0F);
      setmCustomBottomFadingEdgeScale(0.0F);
      postInvalidate();
      performClick();
    }
    if (!this.l.isEmpty()) {
      b();
    }
    this.j = 0;
    this.k = 0;
    label557:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBounceDelay(long paramLong)
  {
    if (paramLong >= 0L) {
      this.e = paramLong;
    }
  }
  
  public void setBounceInterpolator(@NonNull Interpolator paramInterpolator)
  {
    this.g = paramInterpolator;
  }
  
  public void setDamping(@FloatRange(from=0.0D, to=100.0D) float paramFloat)
  {
    if (this.c > 0.0F) {
      this.c = paramFloat;
    }
  }
  
  public void setIncrementalDamping(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setNeedDisallowIntercept(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setOnOverScrollListener(FixedBounceScrollView.OnOverScrollListener paramOnOverScrollListener)
  {
    this.o = paramOnOverScrollListener;
  }
  
  public void setOnScrollListener(FixedBounceScrollView.OnScrollListener paramOnScrollListener)
  {
    this.n = paramOnScrollListener;
  }
  
  public void setScrollHorizontally(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setTriggerOverScrollThreshold(int paramInt)
  {
    if (paramInt >= 0) {
      this.f = paramInt;
    }
  }
  
  public void setmCustomBottomFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.q = paramFloat;
  }
  
  public void setmCustomLeftFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.r = paramFloat;
  }
  
  public void setmCustomRightFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.s = paramFloat;
  }
  
  public void setmCustomTopFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.p = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FixedBounceScrollView
 * JD-Core Version:    0.7.0.1
 */