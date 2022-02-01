package com.tencent.mobileqq.kandian.biz.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJPerformanceReporter;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;

public class FlingExitLayout
  extends ViewGroup
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private final Scroller jdField_a_of_type_AndroidWidgetScroller;
  private FlingExitLayout.OnGestureExitListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout$OnGestureExitListener;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
  private final RecyclerView.OnListScrollListener jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView$OnListScrollListener = new FlingExitLayout.1(this);
  private RecyclerView jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private final int d;
  private int e;
  private int f;
  private int g;
  private int h = -1;
  
  public FlingExitLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlingExitLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlingExitLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateInterpolator());
    paramContext = ViewConfiguration.get(paramContext);
    this.jdField_b_of_type_Int = paramContext.getScaledMinimumFlingVelocity();
    this.jdField_c_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
    this.d = paramContext.getScaledTouchSlop();
    this.jdField_a_of_type_Int = ViewUtils.a(50.0F);
  }
  
  private void a()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private boolean a()
  {
    ReadInJoyCommentListView localReadInJoyCommentListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
    if (localReadInJoyCommentListView == null) {
      return true;
    }
    if (localReadInJoyCommentListView.getChildCount() == 0) {
      return true;
    }
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getChildAt(0).getTop() == 0);
  }
  
  private void b()
  {
    if (getScrollY() != 0) {
      scrollTo(0, 0);
    }
  }
  
  private boolean b()
  {
    RecyclerView localRecyclerView = this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView;
    if (localRecyclerView == null) {
      return true;
    }
    if (this.h == 1) {
      return false;
    }
    if (localRecyclerView.getChildCount() == 0) {
      return true;
    }
    return (this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView.getFirstVisibleItemPos() == 0) && (this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView.getChildAt(0).getTop() == 0);
  }
  
  private void c()
  {
    RIJPerformanceReporter.a().a(0, this.f, -1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      int i = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      if (Math.abs(i) >= this.e - 1)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout$OnGestureExitListener != null) && (this.g >= this.d))
        {
          c();
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout$OnGestureExitListener.a(true);
        }
      }
      else
      {
        if (i >= 0) {
          c();
        }
        scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), i);
        invalidate();
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = this.jdField_a_of_type_Boolean;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3) {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView == null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView == null) {}
      }
      else
      {
        if (paramMotionEvent == null) {
          return false;
        }
        int i = paramMotionEvent.getAction();
        if (i == 3)
        {
          a();
          return false;
        }
        if (i != 0)
        {
          if (i == 2)
          {
            float f2 = paramMotionEvent.getRawX() - this.jdField_a_of_type_Float;
            float f3 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
            if (f2 == 0.0F) {
              f1 = 1.0F;
            } else {
              f1 = f2;
            }
            float f1 = Math.abs(f3 / f1);
            if ((f2 > this.jdField_a_of_type_Int) && (f1 < 0.5F)) {
              i = 1;
            } else {
              i = 0;
            }
            if ((f3 > this.d) && (f1 > 2.0F))
            {
              k = 1;
              j = i;
              i = k;
              break label234;
            }
            int k = 0;
            j = i;
            i = k;
            break label234;
          }
        }
        else
        {
          if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
            this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
          }
          this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
          this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
          this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
        }
        i = 0;
        int j = 0;
        label234:
        if ((i != 0) && (a()) && (b())) {
          i = 1;
        } else {
          i = 0;
        }
        if (j == 0)
        {
          bool1 = bool2;
          if (i == 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i != 1073741824) {
      paramInt1 = getPaddingLeft() + getPaddingRight();
    }
    i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != 1073741824) {
      paramInt2 = getPaddingTop() + getPaddingBottom();
    }
    int j = getChildCount();
    i = 0;
    while (i < j)
    {
      getChildAt(i).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      i += 1;
    }
    this.e = paramInt2;
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramMotionEvent == null) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      float f3 = paramMotionEvent.getRawY();
      int i = paramMotionEvent.getAction();
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          RIJPerformanceReporter.a().a();
          f2 = getScrollY() + this.jdField_c_of_type_Float - f3;
          f1 = f2;
          if (Float.compare(f2, 0.0F) > 0.0F) {
            f1 = 0.0F;
          }
          scrollTo(getScrollX(), (int)f1);
          this.jdField_c_of_type_Float = f3;
          return true;
        }
      }
      float f2 = paramMotionEvent.getRawX() - this.jdField_a_of_type_Float;
      f3 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
      if (f2 == 0.0F) {
        f1 = 1.0F;
      } else {
        f1 = f2;
      }
      float f1 = Math.abs(f3 / f1);
      i = paramMotionEvent.getPointerId(0);
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_c_of_type_Int);
      float f4 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i);
      if ((f2 > this.jdField_a_of_type_Int) && (f1 < 0.5F) && (Math.abs(f4) > this.jdField_b_of_type_Int))
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout$OnGestureExitListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(false);
        }
      }
      int k = getScrollY();
      if (k > 0) {}
      while (Math.abs(k) <= 200)
      {
        i = -k;
        j = 120;
        break;
      }
      i = -(this.e - Math.abs(k));
      int j = 200;
      this.g = ((int)f3);
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, k, 0, i, j);
      invalidate();
      a();
      return true;
    }
    return false;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      b();
    }
  }
  
  public void setCommentLevel(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setListView(ReadInJoyCommentListView paramReadInJoyCommentListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView = paramReadInJoyCommentListView;
  }
  
  public void setOnGestureExitListener(FlingExitLayout.OnGestureExitListener paramOnGestureExitListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout$OnGestureExitListener = paramOnGestureExitListener;
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    setRecyclerView(paramRecyclerView, -1);
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView, int paramInt)
  {
    this.h = paramInt;
    this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView = paramRecyclerView;
    paramRecyclerView = this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.removeOnListScrollListener(this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView$OnListScrollListener);
      this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView.addOnListScrollListener(this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView$OnListScrollListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.FlingExitLayout
 * JD-Core Version:    0.7.0.1
 */