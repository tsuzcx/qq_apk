package com.tencent.mobileqq.gamecenter.view;

import agej;
import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.tencent.qphone.base.util.QLog;

public class ScrollLinearLayout
  extends LinearLayout
  implements NestedScrollingParent
{
  private int jdField_a_of_type_Int = agej.a(80.0F, getResources());
  private View jdField_a_of_type_AndroidViewView;
  private OverScroller jdField_a_of_type_AndroidWidgetOverScroller;
  private View b;
  
  public ScrollLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScrollLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScrollLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetOverScroller.fling(0, getScrollY(), 0, paramInt, 0, 0, 0, this.jdField_a_of_type_Int);
    invalidate();
  }
  
  public int getNestedScrollAxes()
  {
    return 0;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = findViewById(2131366584);
    this.jdField_a_of_type_AndroidWidgetOverScroller = new OverScroller(getContext());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.b == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    getChildAt(0).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
    this.b.getLayoutParams().height = getMeasuredHeight();
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + this.b.getMeasuredHeight());
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if (getScrollY() >= this.jdField_a_of_type_Int) {
      return false;
    }
    a((int)paramFloat2);
    return true;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramInt2 > 0) && (getScrollY() < this.jdField_a_of_type_Int))
    {
      paramInt1 = 1;
      if ((paramInt2 >= 0) || (getScrollY() <= 0) || (ViewCompat.canScrollVertically(paramView, -1))) {
        break label65;
      }
    }
    label65:
    for (int i = 1;; i = 0)
    {
      if ((paramInt1 != 0) || (i != 0))
      {
        scrollBy(0, paramInt2);
        paramArrayOfInt[1] = paramInt2;
      }
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    super.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    QLog.e(getClass().getSimpleName(), 1, "view:" + paramView1 + "-- target:" + paramView2);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.e(getClass().getSimpleName(), 1, "result:" + bool);
      return bool;
    }
  }
  
  public void onStopNestedScroll(View paramView)
  {
    super.onStopNestedScroll(paramView);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    paramInt2 = i;
    if (i > this.jdField_a_of_type_Int) {
      paramInt2 = this.jdField_a_of_type_Int;
    }
    if (paramInt2 != getScrollY()) {
      super.scrollTo(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ScrollLinearLayout
 * JD-Core Version:    0.7.0.1
 */