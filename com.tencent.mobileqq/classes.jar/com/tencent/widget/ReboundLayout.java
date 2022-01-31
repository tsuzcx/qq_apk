package com.tencent.widget;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bfuv;

public class ReboundLayout
  extends LinearLayout
  implements NestedScrollingParent
{
  private int jdField_a_of_type_Int = 3;
  private View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public ReboundLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReboundLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReboundLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
  }
  
  @RequiresApi(api=21)
  public ReboundLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(0);
  }
  
  public int getNestedScrollAxes()
  {
    return 0;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = getChildAt(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(400, -1);
    this.jdField_a_of_type_AndroidViewView = new View(this.c.getContext());
    this.b = new View(this.c.getContext());
    addView(this.jdField_a_of_type_AndroidViewView, 0, localLayoutParams);
    addView(this.b, getChildCount(), localLayoutParams);
    scrollBy(400, 0);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.c.getLayoutParams().width = getMeasuredWidth();
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return getScrollX() != 400;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    int i;
    label49:
    int j;
    if ((paramInt1 > 0) && (getScrollX() < 400) && (!ViewCompat.canScrollHorizontally(paramView, -1)))
    {
      paramInt2 = 1;
      if ((paramInt1 >= 0) || (ViewCompat.canScrollHorizontally(paramView, -1))) {
        break label190;
      }
      i = 1;
      if ((paramInt1 >= 0) || (getScrollX() <= 400) || (ViewCompat.canScrollHorizontally(paramView, 1))) {
        break label196;
      }
      j = 1;
      label74:
      if ((paramInt1 <= 0) || (ViewCompat.canScrollHorizontally(paramView, 1))) {
        break label202;
      }
    }
    label190:
    label196:
    label202:
    for (int k = 1;; k = 0)
    {
      if ((paramInt2 != 0) || (i != 0) || (j != 0) || (k != 0))
      {
        scrollBy(paramInt1 / this.jdField_a_of_type_Int, 0);
        paramArrayOfInt[0] = paramInt1;
      }
      if ((paramInt1 > 0) && (getScrollX() > 400) && (!ViewCompat.canScrollHorizontally(paramView, -1))) {
        scrollTo(400, 0);
      }
      if ((paramInt1 < 0) && (getScrollX() < 400) && (!ViewCompat.canScrollHorizontally(paramView, 1))) {
        scrollTo(400, 0);
      }
      return;
      paramInt2 = 0;
      break;
      i = 0;
      break label49;
      j = 0;
      break label74;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {}
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return ((paramView2 instanceof RecyclerView)) && (!this.jdField_a_of_type_Boolean);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    startAnimation(new bfuv(this, null));
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      super.scrollTo(i, paramInt2);
      return;
      i = paramInt1;
      if (paramInt1 > 800) {
        i = 800;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.ReboundLayout
 * JD-Core Version:    0.7.0.1
 */