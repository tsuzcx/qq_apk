package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;
import java.util.ArrayList;

class RecyclerViewBase$RecyclerViewDataObserver
  extends RecyclerViewBase.AdapterDataObserver
{
  RecyclerViewBase$RecyclerViewDataObserver(RecyclerViewBase paramRecyclerViewBase) {}
  
  public void onChanged()
  {
    this.this$0.markKnownViewsInvalid();
    this.this$0.removeAnimatingViews();
    this.this$0.mState.mDataChanged = true;
    this.this$0.mState.mStructureChanged = true;
    View localView = this.this$0.mLayout.getChildClosestToStartByOrder();
    if (localView != null)
    {
      int k = this.this$0.mLayout.getPendingPosition();
      int m = this.this$0.mLayout.getPendingOffset();
      int j = k;
      int i = m;
      if (k == -2147483648)
      {
        k = this.this$0.mLayout.getPosition(localView);
        j = k;
        i = m;
        if (m == -2147483648)
        {
          j = this.this$0.mLayout.getDecoratedStart(localView);
          if (this.this$0.mLayout.canScrollHorizontally()) {
            i = this.this$0.mState.mCustomHeaderWidth;
          } else {
            i = this.this$0.mState.mCustomHeaderHeight;
          }
          i = j + i;
          j = k;
        }
      }
      j = this.this$0.validateAnchorItemPosition(j);
      this.this$0.scrollToPositionWithOffset(j, i);
      return;
    }
    this.this$0.requestLayout();
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    RecyclerViewBase localRecyclerViewBase = this.this$0;
    localRecyclerViewBase.postAdapterUpdate(localRecyclerViewBase.obtainUpdateOp(2, paramInt1, paramInt2));
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    RecyclerViewBase localRecyclerViewBase = this.this$0;
    localRecyclerViewBase.postAdapterUpdate(localRecyclerViewBase.obtainUpdateOp(0, paramInt1, paramInt2));
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    RecyclerViewBase localRecyclerViewBase = this.this$0;
    localRecyclerViewBase.postAdapterUpdate(localRecyclerViewBase.obtainUpdateOp(1, paramInt1, paramInt2));
  }
  
  public void onItemsRemoved(ArrayList<Integer> paramArrayList)
  {
    RecyclerViewBase.UpdateOp localUpdateOp = this.this$0.obtainUpdateOp(1, -1, -1);
    localUpdateOp.mRemovePositions = paramArrayList;
    this.this$0.postAdapterUpdate(localUpdateOp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.RecyclerViewDataObserver
 * JD-Core Version:    0.7.0.1
 */