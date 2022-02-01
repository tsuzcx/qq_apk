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

public class ReboundVLayout
  extends LinearLayout
  implements NestedScrollingParent
{
  private static final int MAX_HEIGHT = 1000;
  private boolean isRunAnim;
  private View mChildView;
  private int mDrag = 3;
  private View mFooterView;
  private View mHeaderView;
  
  public ReboundVLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReboundVLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReboundVLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
  }
  
  @RequiresApi(api=21)
  public ReboundVLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(1);
  }
  
  private boolean isHiddenLeft(View paramView, int paramInt)
  {
    return (paramInt > 0) && (getScrollY() < 1000) && (!ViewCompat.canScrollVertically(paramView, -1));
  }
  
  private boolean isHiddenRight(View paramView, int paramInt)
  {
    return (paramInt < 0) && (getScrollY() > 1000) && (!ViewCompat.canScrollVertically(paramView, 1));
  }
  
  private boolean isShowLeft(View paramView, int paramInt)
  {
    return (paramInt < 0) && (!ViewCompat.canScrollVertically(paramView, -1));
  }
  
  private boolean isShowRight(View paramView, int paramInt)
  {
    return (paramInt > 0) && (!ViewCompat.canScrollVertically(paramView, 1));
  }
  
  public int getNestedScrollAxes()
  {
    return 0;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mChildView = getChildAt(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1000);
    this.mHeaderView = new View(this.mChildView.getContext());
    this.mFooterView = new View(this.mChildView.getContext());
    addView(this.mHeaderView, 0, localLayoutParams);
    addView(this.mFooterView, getChildCount(), localLayoutParams);
    scrollBy(0, 1000);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mChildView.getLayoutParams().height = getHeight();
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return getScrollY() != 1000;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    boolean bool1 = isHiddenLeft(paramView, paramInt2);
    boolean bool2 = isShowLeft(paramView, paramInt2);
    boolean bool3 = isHiddenRight(paramView, paramInt2);
    boolean bool4 = isShowRight(paramView, paramInt2);
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      scrollBy(0, paramInt2 / this.mDrag);
      paramArrayOfInt[1] = paramInt2;
    }
    if ((paramInt2 > 0) && (getScrollY() > 1000) && (!ViewCompat.canScrollVertically(paramView, -1))) {
      scrollTo(0, 1000);
    }
    if ((paramInt2 < 0) && (getScrollY() < -1000) && (!ViewCompat.canScrollVertically(paramView, 1))) {
      scrollTo(0, -1000);
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
    startAnimation(new ReboundVLayout.ProgressAnimation(this, null));
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 < 0) {
      i = 0;
    }
    for (;;)
    {
      super.scrollTo(paramInt1, i);
      return;
      i = paramInt2;
      if (paramInt2 > 2000) {
        i = 2000;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ReboundVLayout
 * JD-Core Version:    0.7.0.1
 */