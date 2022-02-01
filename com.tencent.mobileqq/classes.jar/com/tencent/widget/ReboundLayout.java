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

public class ReboundLayout
  extends LinearLayout
  implements NestedScrollingParent
{
  private static final int MAX_WIDTH = 400;
  private boolean isRunAnim;
  private View mChildView;
  private int mDrag = 3;
  private View mFooterView;
  private View mHeaderView;
  
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
    this.mChildView = getChildAt(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(400, -1);
    this.mHeaderView = new View(this.mChildView.getContext());
    this.mFooterView = new View(this.mChildView.getContext());
    addView(this.mHeaderView, 0, localLayoutParams);
    addView(this.mFooterView, getChildCount(), localLayoutParams);
    scrollBy(400, 0);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mChildView.getLayoutParams().width = getMeasuredWidth();
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
    if ((paramInt1 > 0) && (getScrollX() < 400) && (!ViewCompat.canScrollHorizontally(paramView, -1))) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    int i;
    if ((paramInt1 < 0) && (!ViewCompat.canScrollHorizontally(paramView, -1))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((paramInt1 < 0) && (getScrollX() > 400) && (!ViewCompat.canScrollHorizontally(paramView, 1))) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((paramInt1 > 0) && (!ViewCompat.canScrollHorizontally(paramView, 1))) {
      k = 1;
    } else {
      k = 0;
    }
    if ((paramInt2 != 0) || (i != 0) || (j != 0) || (k != 0))
    {
      scrollBy(paramInt1 / this.mDrag, 0);
      paramArrayOfInt[0] = paramInt1;
    }
    if ((paramInt1 > 0) && (getScrollX() > 400) && (!ViewCompat.canScrollHorizontally(paramView, -1))) {
      scrollTo(400, 0);
    }
    if ((paramInt1 < 0) && (getScrollX() < 400) && (!ViewCompat.canScrollHorizontally(paramView, 1))) {
      scrollTo(400, 0);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {}
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return ((paramView2 instanceof RecyclerView)) && (!this.isRunAnim);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    startAnimation(new ReboundLayout.ProgressAnimation(this, null));
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < 0)
    {
      i = 0;
    }
    else
    {
      i = paramInt1;
      if (paramInt1 > 800) {
        i = 800;
      }
    }
    super.scrollTo(i, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ReboundLayout
 * JD-Core Version:    0.7.0.1
 */