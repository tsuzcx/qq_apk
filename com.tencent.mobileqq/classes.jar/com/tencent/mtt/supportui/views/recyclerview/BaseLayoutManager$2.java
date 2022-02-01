package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;

class BaseLayoutManager$2
  implements BaseLayoutManager.OrientationHelper
{
  BaseLayoutManager$2(BaseLayoutManager paramBaseLayoutManager) {}
  
  public int getDecoratedEnd(View paramView)
  {
    if (paramView == null) {
      return 0;
    }
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    return this.this$0.getDecoratedBottom(paramView) + localLayoutParams.bottomMargin;
  }
  
  public int getDecoratedMeasurement(View paramView)
  {
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    return this.this$0.getDecoratedMeasuredHeight(paramView) + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
  }
  
  public int getDecoratedMeasurementInOther(View paramView)
  {
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    return this.this$0.getDecoratedMeasuredWidth(paramView) + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
  }
  
  public int getDecoratedStart(View paramView)
  {
    if (paramView == null) {
      return 0;
    }
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    return this.this$0.getDecoratedTop(paramView) - localLayoutParams.topMargin;
  }
  
  public int getEndAfterPadding()
  {
    return this.this$0.getHeight() - this.this$0.getPaddingBottom() + this.this$0.mRecyclerView.mState.mCustomHeaderHeight;
  }
  
  public int getStartAfterPadding()
  {
    return this.this$0.getPaddingTop() - this.this$0.mRecyclerView.mState.mCustomHeaderHeight;
  }
  
  public int getTotalSpace()
  {
    return this.this$0.getHeight() - this.this$0.getPaddingTop() - this.this$0.getPaddingBottom();
  }
  
  public void offsetChildren(int paramInt)
  {
    this.this$0.offsetChildrenVertical(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.2
 * JD-Core Version:    0.7.0.1
 */