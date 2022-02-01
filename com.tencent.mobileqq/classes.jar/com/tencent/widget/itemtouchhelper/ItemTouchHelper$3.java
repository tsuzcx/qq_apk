package com.tencent.widget.itemtouchhelper;

import android.animation.Animator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

class ItemTouchHelper$3
  extends ItemTouchHelper.RecoverAnimation
{
  ItemTouchHelper$3(ItemTouchHelper paramItemTouchHelper, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, RecyclerView.ViewHolder paramViewHolder2)
  {
    super(paramItemTouchHelper, paramViewHolder1, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.mOverridden) {}
    for (;;)
    {
      return;
      if (this.val$swipeDir <= 0) {
        this.this$0.mCallback.clearView(this.this$0.mRecyclerView, this.val$prevSelected);
      }
      while (this.this$0.mOverdrawChild == this.val$prevSelected.itemView)
      {
        this.this$0.removeChildDrawingOrderCallbackIfNecessary(this.val$prevSelected.itemView);
        return;
        this.this$0.mPendingCleanup.add(this.val$prevSelected.itemView);
        this.mIsPendingCleanup = true;
        if (this.val$swipeDir > 0) {
          this.this$0.postDispatchSwipe(this, this.val$swipeDir);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.3
 * JD-Core Version:    0.7.0.1
 */