package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;

class BaseLayoutManager$3
  implements BaseLayoutManager.OrientationHelper
{
  BaseLayoutManager$3(BaseLayoutManager paramBaseLayoutManager) {}
  
  public int getDecoratedEnd(View paramView)
  {
    if (paramView == null) {
      return 0;
    }
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    return this.this$0.getDecoratedRight(paramView) + localLayoutParams.rightMargin;
  }
  
  public int getDecoratedMeasurement(View paramView)
  {
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    return this.this$0.getDecoratedMeasuredWidth(paramView) + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
  }
  
  public int getDecoratedMeasurementInOther(View paramView)
  {
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    return this.this$0.getDecoratedMeasuredHeight(paramView) + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
  }
  
  public int getDecoratedStart(View paramView)
  {
    if (paramView == null) {
      return 0;
    }
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    return this.this$0.getDecoratedLeft(paramView) - localLayoutParams.leftMargin;
  }
  
  public int getEndAfterPadding()
  {
    return this.this$0.getWidth() - this.this$0.getPaddingRight() + this.this$0.mRecyclerView.mState.mCustomHeaderWidth;
  }
  
  public int getStartAfterPadding()
  {
    return this.this$0.getPaddingLeft() - this.this$0.mRecyclerView.mState.mCustomHeaderWidth;
  }
  
  public int getTotalSpace()
  {
    return this.this$0.getWidth() - this.this$0.getPaddingLeft() - this.this$0.getPaddingRight();
  }
  
  public void offsetChildren(int paramInt)
  {
    this.this$0.offsetChildrenHorizontal(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.3
 * JD-Core Version:    0.7.0.1
 */