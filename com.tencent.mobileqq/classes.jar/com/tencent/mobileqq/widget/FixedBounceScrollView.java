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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private FixedBounceScrollView.OnOverScrollListener jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$OnOverScrollListener;
  private FixedBounceScrollView.OnScrollListener jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$OnScrollListener;
  boolean jdField_a_of_type_Boolean;
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
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    setOverScrollMode(2);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setFillViewport(true);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.O, 0, 0);
    this.jdField_a_of_type_Float = paramContext.getFloat(R.styleable.D, 4.0F);
    if (paramContext.getInt(R.styleable.F, 0) == 1) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    this.jdField_c_of_type_Boolean = paramContext.getBoolean(R.styleable.E, true);
    this.jdField_a_of_type_Long = paramContext.getInt(R.styleable.C, 400);
    this.jdField_a_of_type_Int = paramContext.getInt(R.styleable.G, 20);
    paramContext.recycle();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewAnimationInterpolator = new FixedBounceScrollView.DefaultQuartOutInterpolator(null);
    }
    setmCustomBottomFadingEdgeScale(0.0F);
    setmCustomTopFadingEdgeScale(0.0F);
  }
  
  private float a()
  {
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      f1 = Math.abs(this.jdField_a_of_type_AndroidViewView.getLeft()) * 1.0F;
      i = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
    }
    else
    {
      f1 = Math.abs(this.jdField_a_of_type_AndroidViewView.getTop()) * 1.0F;
      i = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    }
    double d1 = f1 / i;
    Double.isNaN(d1);
    float f1 = (float)(d1 + 0.2D);
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_Float / (1.0F - (float)Math.pow(f1, 2.0D));
    }
    return this.jdField_a_of_type_Float;
  }
  
  private void a()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    boolean bool = this.jdField_b_of_type_Boolean;
    int j = 0;
    int i = 0;
    int k;
    if (bool)
    {
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        k = ViewCompat.getPaddingEnd(this);
        j = k;
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
        {
          i = ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin;
          j = k;
        }
      }
      else
      {
        k = ViewCompat.getPaddingStart(this);
        j = k;
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
        {
          i = ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin;
          j = k;
        }
      }
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(this.jdField_a_of_type_AndroidViewView.getLeft() - j - i, this.jdField_a_of_type_AndroidGraphicsRect.left - j - i, 0.0F, 0.0F);
    }
    else
    {
      k = getPaddingTop();
      i = j;
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        i = ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin;
      }
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_AndroidViewView.getTop() - k - i, this.jdField_a_of_type_AndroidGraphicsRect.top - k - i);
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
  }
  
  private boolean a()
  {
    if (this.jdField_b_of_type_Boolean)
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
  
  private boolean a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt < 0)) {
      return a();
    }
    return b();
  }
  
  private boolean b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      j = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth() - getWidth();
      i = j;
      if (j < 0) {
        i = 0;
      }
      return getScrollX() == i;
    }
    int j = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - getHeight();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return getScrollY() == i;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return this.jdField_b_of_type_Boolean ^ true;
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    float f1 = this.jdField_d_of_type_Float;
    if (f1 != -1.0F) {
      return f1;
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
    float f1 = this.e;
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
    float f1 = this.f;
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
    float f1 = this.jdField_c_of_type_Float;
    if (f1 != -1.0F) {
      return f1;
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
    TranslateAnimation localTranslateAnimation = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    if ((localTranslateAnimation != null) && (!localTranslateAnimation.hasEnded())) {
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
    if (this.jdField_a_of_type_Boolean) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        if (this.jdField_b_of_type_Boolean) {
          return Math.abs(paramMotionEvent.getX() - this.jdField_b_of_type_Float) >= this.jdField_a_of_type_Int;
        }
        return Math.abs(paramMotionEvent.getY() - this.jdField_b_of_type_Float) >= this.jdField_a_of_type_Int;
      }
    }
    else
    {
      float f1;
      if (this.jdField_b_of_type_Boolean) {
        f1 = paramMotionEvent.getX();
      } else {
        f1 = paramMotionEvent.getY();
      }
      this.jdField_b_of_type_Float = f1;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = this.jdField_d_of_type_Int;
    if (i > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, -2147483648);
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
        int k = ((FrameLayout.LayoutParams)localObject).leftMargin;
        i = ((FrameLayout.LayoutParams)localObject).topMargin;
        int m = ((FrameLayout.LayoutParams)localObject).rightMargin;
        int j = ((FrameLayout.LayoutParams)localObject).bottomMargin;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("marginStart=");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(" topMargin=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" marginEnd=");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(" bottomMargin=");
          ((StringBuilder)localObject).append(j);
          QLog.d("FixedBounceScrollView", 4, ((StringBuilder)localObject).toString());
        }
        if ((k != 0) || (i != 0) || (m != 0) || (j != 0))
        {
          if (paramInt2 <= getMeasuredHeight())
          {
            paramInt1 -= k + m;
            paramInt2 -= i + j;
          }
          else
          {
            paramInt2 += i + j;
          }
          localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
        }
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    FixedBounceScrollView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.a(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getActionMasked();
    boolean bool = true;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          break label557;
        }
      }
      else
      {
        float f1;
        if (this.jdField_b_of_type_Boolean) {
          f1 = paramMotionEvent.getX();
        } else {
          f1 = paramMotionEvent.getY();
        }
        int j = (int)((this.jdField_b_of_type_Float - f1) / a());
        this.jdField_b_of_type_Float = f1;
        setmCustomTopFadingEdgeScale(1.0F);
        setmCustomBottomFadingEdgeScale(1.0F);
        if ((this.jdField_b_of_type_Int <= 0) && (j > 0)) {}
        while ((this.jdField_b_of_type_Int >= 0) && (j < 0))
        {
          i = 0;
          break;
        }
        i = 1;
        this.jdField_b_of_type_Int = j;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dampingDelta=");
          ((StringBuilder)localObject).append(j);
          QLog.d("FixedBounceScrollView", 2, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mChildView.getTop()+mChildView.getPaddingTop()");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidViewView.getTop());
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidViewView.getPaddingTop());
          QLog.d("FixedBounceScrollView", 2, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mChildView.getBottom() + mChildView.getPaddingBottom()");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidViewView.getBottom());
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidViewView.getPaddingBottom());
          QLog.d("FixedBounceScrollView", 2, ((StringBuilder)localObject).toString());
        }
        if ((i == 0) || (!a(j))) {
          break label557;
        }
        if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
          this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getRight(), this.jdField_a_of_type_AndroidViewView.getBottom());
        }
        if (this.jdField_b_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_AndroidViewView;
          ((View)localObject).layout(((View)localObject).getLeft() - j, this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getRight() - j, this.jdField_a_of_type_AndroidViewView.getBottom());
        }
        else
        {
          localObject = this.jdField_a_of_type_AndroidViewView;
          ((View)localObject).layout(((View)localObject).getLeft(), this.jdField_a_of_type_AndroidViewView.getTop() - j + 2, this.jdField_a_of_type_AndroidViewView.getRight(), this.jdField_a_of_type_AndroidViewView.getBottom() - j + 2);
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$OnOverScrollListener;
        if (localObject == null) {
          break label557;
        }
        this.jdField_c_of_type_Int += j;
        if (this.jdField_c_of_type_Int > 0) {
          bool = false;
        }
        ((FixedBounceScrollView.OnOverScrollListener)localObject).a(bool, Math.abs(this.jdField_c_of_type_Int));
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
    if (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
      a();
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    label557:
    return super.onTouchEvent(paramMotionEvent);
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
  
  public void setOnOverScrollListener(FixedBounceScrollView.OnOverScrollListener paramOnOverScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$OnOverScrollListener = paramOnOverScrollListener;
  }
  
  public void setOnScrollListener(FixedBounceScrollView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$OnScrollListener = paramOnScrollListener;
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