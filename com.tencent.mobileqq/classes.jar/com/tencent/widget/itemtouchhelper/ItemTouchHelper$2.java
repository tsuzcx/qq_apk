package com.tencent.widget.itemtouchhelper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.List;

class ItemTouchHelper$2
  implements RecyclerView.OnItemTouchListener
{
  ItemTouchHelper$2(ItemTouchHelper paramItemTouchHelper) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.this$0.mGestureDetector.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.this$0.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.this$0.mInitialTouchX = paramMotionEvent.getX();
      this.this$0.mInitialTouchY = paramMotionEvent.getY();
      this.this$0.obtainVelocityTracker();
      if (this.this$0.mSelected == null)
      {
        paramRecyclerView = this.this$0.findAnimation(paramMotionEvent);
        if (paramRecyclerView != null)
        {
          ItemTouchHelper localItemTouchHelper = this.this$0;
          localItemTouchHelper.mInitialTouchX -= paramRecyclerView.mX;
          localItemTouchHelper = this.this$0;
          localItemTouchHelper.mInitialTouchY -= paramRecyclerView.mY;
          this.this$0.endRecoverAnimation(paramRecyclerView.mViewHolder, true);
          if (this.this$0.mPendingCleanup.remove(paramRecyclerView.mViewHolder.itemView)) {
            this.this$0.mCallback.clearView(this.this$0.mRecyclerView, paramRecyclerView.mViewHolder);
          }
          this.this$0.select(paramRecyclerView.mViewHolder, paramRecyclerView.mActionState);
          paramRecyclerView = this.this$0;
          paramRecyclerView.updateDxDy(paramMotionEvent, paramRecyclerView.mSelectedFlags, 0);
        }
      }
    }
    else if ((i != 3) && (i != 1))
    {
      if (this.this$0.mActivePointerId != -1)
      {
        int j = paramMotionEvent.findPointerIndex(this.this$0.mActivePointerId);
        if (j >= 0) {
          this.this$0.checkSelectForSwipe(i, paramMotionEvent, j);
        }
      }
    }
    else
    {
      paramRecyclerView = this.this$0;
      paramRecyclerView.mActivePointerId = -1;
      paramRecyclerView.select(null, 0);
    }
    if (this.this$0.mVelocityTracker != null) {
      this.this$0.mVelocityTracker.addMovement(paramMotionEvent);
    }
    return this.this$0.mSelected != null;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.this$0.select(null, 0);
  }
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.this$0.mGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.this$0.mVelocityTracker != null) {
      this.this$0.mVelocityTracker.addMovement(paramMotionEvent);
    }
    if (this.this$0.mActivePointerId == -1) {
      return;
    }
    int j = paramMotionEvent.getActionMasked();
    int k = paramMotionEvent.findPointerIndex(this.this$0.mActivePointerId);
    if (k >= 0) {
      this.this$0.checkSelectForSwipe(j, paramMotionEvent, k);
    }
    paramRecyclerView = this.this$0.mSelected;
    if (paramRecyclerView == null) {
      return;
    }
    int i = 0;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 6) {
            return;
          }
          j = paramMotionEvent.getActionIndex();
          if (paramMotionEvent.getPointerId(j) != this.this$0.mActivePointerId) {
            return;
          }
          if (j == 0) {
            i = 1;
          }
          this.this$0.mActivePointerId = paramMotionEvent.getPointerId(i);
          paramRecyclerView = this.this$0;
          paramRecyclerView.updateDxDy(paramMotionEvent, paramRecyclerView.mSelectedFlags, j);
          return;
        }
        if (this.this$0.mVelocityTracker != null) {
          this.this$0.mVelocityTracker.clear();
        }
      }
      else
      {
        if (k < 0) {
          return;
        }
        ItemTouchHelper localItemTouchHelper = this.this$0;
        localItemTouchHelper.updateDxDy(paramMotionEvent, localItemTouchHelper.mSelectedFlags, k);
        this.this$0.moveIfNecessary(paramRecyclerView);
        this.this$0.mRecyclerView.removeCallbacks(this.this$0.mScrollRunnable);
        this.this$0.mScrollRunnable.run();
        this.this$0.mRecyclerView.invalidate();
        return;
      }
    }
    this.this$0.select(null, 0);
    this.this$0.mActivePointerId = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.2
 * JD-Core Version:    0.7.0.1
 */