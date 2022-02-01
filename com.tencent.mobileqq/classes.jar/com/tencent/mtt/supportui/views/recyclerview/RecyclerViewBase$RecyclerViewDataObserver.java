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
      int i = m;
      int j = k;
      if (k == -2147483648)
      {
        k = this.this$0.mLayout.getPosition(localView);
        i = m;
        j = k;
        if (m == -2147483648)
        {
          i = this.this$0.mLayout.getDecoratedStart(localView);
          if (!this.this$0.mLayout.canScrollHorizontally()) {
            break label172;
          }
          i += this.this$0.mState.mCustomHeaderWidth;
        }
      }
      for (j = k;; j = k)
      {
        j = this.this$0.validateAnchorItemPosition(j);
        this.this$0.scrollToPositionWithOffset(j, i);
        return;
        label172:
        i += this.this$0.mState.mCustomHeaderHeight;
      }
    }
    this.this$0.requestLayout();
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.this$0.postAdapterUpdate(this.this$0.obtainUpdateOp(2, paramInt1, paramInt2));
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.this$0.postAdapterUpdate(this.this$0.obtainUpdateOp(0, paramInt1, paramInt2));
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.this$0.postAdapterUpdate(this.this$0.obtainUpdateOp(1, paramInt1, paramInt2));
  }
  
  public void onItemsRemoved(ArrayList<Integer> paramArrayList)
  {
    RecyclerViewBase.UpdateOp localUpdateOp = this.this$0.obtainUpdateOp(1, -1, -1);
    localUpdateOp.mRemovePositions = paramArrayList;
    this.this$0.postAdapterUpdate(localUpdateOp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.RecyclerViewDataObserver
 * JD-Core Version:    0.7.0.1
 */