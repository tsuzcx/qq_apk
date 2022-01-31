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
import bclr;
import bcls;
import bclt;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class FixedBounceScrollView
  extends ScrollView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private bcls jdField_a_of_type_Bcls;
  private bclt jdField_a_of_type_Bclt;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = -1.0F;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = -1.0F;
  private int jdField_d_of_type_Int;
  private float e = -1.0F;
  private float f = -1.0F;
  
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
    setOverScrollMode(2);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setFillViewport(true);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FixedBounceScrollView, 0, 0);
    this.jdField_a_of_type_Float = paramContext.getFloat(1, 4.0F);
    if (paramContext.getInt(3, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_c_of_type_Boolean = paramContext.getBoolean(2, true);
      this.jdField_a_of_type_Long = paramContext.getInt(0, 400);
      this.jdField_a_of_type_Int = paramContext.getInt(4, 20);
      paramContext.recycle();
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewAnimationInterpolator = new bclr(null);
      }
      setmCustomBottomFadingEdgeScale(0.0F);
      setmCustomTopFadingEdgeScale(0.0F);
      return;
    }
  }
  
  private float a()
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (float f1 = Math.abs(this.jdField_a_of_type_AndroidViewView.getLeft()) * 1.0F / this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();; f1 = Math.abs(this.jdField_a_of_type_AndroidViewView.getTop()) * 1.0F / this.jdField_a_of_type_AndroidViewView.getMeasuredHeight())
    {
      f1 = (float)(f1 + 0.2D);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      return this.jdField_a_of_type_Float / (1.0F - (float)Math.pow(f1, 2.0D));
    }
    return this.jdField_a_of_type_Float;
  }
  
  private void a()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int i = 0;
    int j;
    if (this.jdField_b_of_type_Boolean) {
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        j = ViewCompat.getPaddingEnd(this);
        i = j;
        if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          break label252;
        }
        i = ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin;
      }
    }
    for (;;)
    {
      for (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(this.jdField_a_of_type_AndroidViewView.getLeft() - j - i, this.jdField_a_of_type_AndroidGraphicsRect.left - j - i, 0.0F, 0.0F);; this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_AndroidViewView.getTop() - j - i, this.jdField_a_of_type_AndroidGraphicsRect.top - j - i))
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
        this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
        return;
        j = ViewCompat.getPaddingStart(this);
        i = j;
        if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          break label252;
        }
        i = ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin;
        break;
        j = getPaddingTop();
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          i = ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin;
        }
      }
      label252:
      int k = 0;
      j = i;
      i = k;
    }
  }
  
  private boolean a()
  {
    if (this.jdField_b_of_type_Boolean) {
      if (getScrollX() != 0) {}
    }
    while (getScrollY() == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt < 0)) {
      return a();
    }
    return b();
  }
  
  private boolean b()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_b_of_type_Boolean)
    {
      j = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth() - getWidth();
      i = j;
      if (j < 0) {
        i = 0;
      }
      bool1 = bool2;
      if (getScrollX() == i) {
        bool1 = true;
      }
      return bool1;
    }
    int j = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - getHeight();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    if (getScrollY() == i) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return !this.jdField_b_of_type_Boolean;
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    if (this.jdField_d_of_type_Float != -1.0F) {
      return this.jdField_d_of_type_Float;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    j = getChildAt(0).getBottom() - getScrollY() - (j - k);
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    if (this.e != -1.0F) {
      return this.e;
    }
    if (computeHorizontalScrollOffset() > 0) {
      return 1.0F;
    }
    return 0.0F;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    if (this.f != -1.0F) {
      return this.f;
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
    if (this.jdField_c_of_type_Float != -1.0F) {
      return this.jdField_c_of_type_Float;
    }
    int i = getVerticalFadingEdgeLength();
    if (getScrollY() < i) {
      return getScrollY() / i;
    }
    return 1.0F;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.hasEnded())) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() > 0) {
      this.jdField_a_of_type_AndroidViewView = getChildAt(0);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Boolean) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    label114:
    do
    {
      do
      {
        return bool;
        if (this.jdField_b_of_type_Boolean) {}
        for (float f1 = paramMotionEvent.getX();; f1 = paramMotionEvent.getY())
        {
          this.jdField_b_of_type_Float = f1;
          break;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break label114;
        }
      } while (Math.abs(paramMotionEvent.getX() - this.jdField_b_of_type_Float) >= this.jdField_a_of_type_Int);
      return false;
    } while (Math.abs(paramMotionEvent.getY() - this.jdField_b_of_type_Float) >= this.jdField_a_of_type_Int);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_d_of_type_Int > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.jdField_d_of_type_Int, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    View localView;
    if (getChildCount() > 0)
    {
      localView = getChildAt(0);
      paramInt2 = localView.getMeasuredHeight();
      if (paramInt2 > 0) {
        break label49;
      }
    }
    label49:
    int k;
    int i;
    int m;
    int j;
    do
    {
      ViewGroup.LayoutParams localLayoutParams;
      do
      {
        return;
        paramInt1 = localView.getMeasuredWidth();
        localLayoutParams = localView.getLayoutParams();
      } while (!(localLayoutParams instanceof FrameLayout.LayoutParams));
      k = ((FrameLayout.LayoutParams)localLayoutParams).leftMargin;
      i = ((FrameLayout.LayoutParams)localLayoutParams).topMargin;
      m = ((FrameLayout.LayoutParams)localLayoutParams).rightMargin;
      j = ((FrameLayout.LayoutParams)localLayoutParams).bottomMargin;
      if (QLog.isColorLevel()) {
        QLog.d("FixedBounceScrollView", 4, "marginStart=" + k + " topMargin=" + i + " marginEnd=" + m + " bottomMargin=" + j);
      }
    } while ((k == 0) && (i == 0) && (m == 0) && (j == 0));
    if (paramInt2 <= getMeasuredHeight())
    {
      paramInt1 -= m + k;
      paramInt2 -= j + i;
    }
    for (;;)
    {
      localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      return;
      paramInt2 = i + j + paramInt2;
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Bclt != null) {
      this.jdField_a_of_type_Bclt.a(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    float f1;
    label66:
    int j;
    int i;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      return super.onTouchEvent(paramMotionEvent);
    case 2: 
      if (this.jdField_b_of_type_Boolean)
      {
        f1 = paramMotionEvent.getX();
        j = (int)((this.jdField_b_of_type_Float - f1) / a());
        this.jdField_b_of_type_Float = f1;
        setmCustomTopFadingEdgeScale(1.0F);
        setmCustomBottomFadingEdgeScale(1.0F);
        if ((this.jdField_b_of_type_Int > 0) || (j <= 0)) {
          break label411;
        }
        i = 0;
      }
      break;
    }
    for (;;)
    {
      label109:
      this.jdField_b_of_type_Int = j;
      if (QLog.isColorLevel())
      {
        QLog.d("FixedBounceScrollView", 2, "dampingDelta=" + j);
        QLog.d("FixedBounceScrollView", 2, "mChildView.getTop()+mChildView.getPaddingTop()" + this.jdField_a_of_type_AndroidViewView.getTop() + " " + this.jdField_a_of_type_AndroidViewView.getPaddingTop());
        QLog.d("FixedBounceScrollView", 2, "mChildView.getBottom() + mChildView.getPaddingBottom()" + this.jdField_a_of_type_AndroidViewView.getBottom() + " " + this.jdField_a_of_type_AndroidViewView.getPaddingBottom());
      }
      if ((i == 0) || (!a(j))) {
        break;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
        this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getRight(), this.jdField_a_of_type_AndroidViewView.getBottom());
      }
      label353:
      bcls localbcls;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidViewView.getLeft() - j, this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getRight() - j, this.jdField_a_of_type_AndroidViewView.getBottom());
        if (this.jdField_a_of_type_Bcls == null) {
          break;
        }
        this.jdField_c_of_type_Int += j;
        localbcls = this.jdField_a_of_type_Bcls;
        if (this.jdField_c_of_type_Int > 0) {
          break label476;
        }
      }
      for (;;)
      {
        localbcls.a(bool, Math.abs(this.jdField_c_of_type_Int));
        break;
        f1 = paramMotionEvent.getY();
        break label66;
        label411:
        if ((this.jdField_b_of_type_Int < 0) || (j >= 0)) {
          break label528;
        }
        i = 0;
        break label109;
        this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidViewView.getTop() - j + 2, this.jdField_a_of_type_AndroidViewView.getRight(), this.jdField_a_of_type_AndroidViewView.getBottom() - j + 2);
        break label353;
        label476:
        bool = false;
      }
      setmCustomTopFadingEdgeScale(0.0F);
      setmCustomBottomFadingEdgeScale(0.0F);
      postInvalidate();
      performClick();
      if (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
        a();
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      break;
      label528:
      i = 1;
    }
  }
  
  public void setBounceDelay(long paramLong)
  {
    if (paramLong >= 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  public void setBounceInterpolator(@NonNull Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public void setDamping(@FloatRange(from=0.0D, to=100.0D) float paramFloat)
  {
    if (this.jdField_a_of_type_Float > 0.0F) {
      this.jdField_a_of_type_Float = paramFloat;
    }
  }
  
  public void setIncrementalDamping(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setNeedDisallowIntercept(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnOverScrollListener(bcls parambcls)
  {
    this.jdField_a_of_type_Bcls = parambcls;
  }
  
  public void setOnScrollListener(bclt parambclt)
  {
    this.jdField_a_of_type_Bclt = parambclt;
  }
  
  public void setScrollHorizontally(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setTriggerOverScrollThreshold(int paramInt)
  {
    if (paramInt >= 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void setmCustomBottomFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.jdField_d_of_type_Float = paramFloat;
  }
  
  public void setmCustomLeftFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void setmCustomRightFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void setmCustomTopFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FixedBounceScrollView
 * JD-Core Version:    0.7.0.1
 */