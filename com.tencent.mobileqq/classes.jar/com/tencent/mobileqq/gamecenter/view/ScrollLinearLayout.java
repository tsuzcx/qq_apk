package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class ScrollLinearLayout
  extends LinearLayout
  implements NestedScrollingParent
{
  private int a = AIOUtils.b(80.0F, getResources());
  private View b;
  private View c;
  private OverScroller d;
  
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
    this.d.fling(0, getScrollY(), 0, paramInt, 0, 0, 0, this.a);
    invalidate();
  }
  
  public int getNestedScrollAxes()
  {
    return 0;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = findViewById(2131433082);
    this.d = new OverScroller(getContext());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.c != null)
    {
      if (this.b == null) {
        return;
      }
      getChildAt(0).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      this.c.getLayoutParams().height = getMeasuredHeight();
      setMeasuredDimension(getMeasuredWidth(), this.b.getMeasuredHeight() + this.c.getMeasuredHeight());
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if (getScrollY() >= this.a) {
      return false;
    }
    a((int)paramFloat2);
    return true;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramInt2 > 0) && (getScrollY() < this.a)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int i;
    if ((paramInt2 < 0) && (getScrollY() > 0) && (!ViewCompat.canScrollVertically(paramView, -1))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt1 != 0) || (i != 0))
    {
      scrollBy(0, paramInt2);
      paramArrayOfInt[1] = paramInt2;
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
    String str = getClass().getSimpleName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("view:");
    localStringBuilder.append(paramView1);
    localStringBuilder.append("-- target:");
    localStringBuilder.append(paramView2);
    QLog.e(str, 1, localStringBuilder.toString());
    boolean bool;
    if ((paramInt & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramView1 = getClass().getSimpleName();
    paramView2 = new StringBuilder();
    paramView2.append("result:");
    paramView2.append(bool);
    QLog.e(paramView1, 1, paramView2.toString());
    return bool;
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
    int j = this.a;
    paramInt2 = i;
    if (i > j) {
      paramInt2 = j;
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