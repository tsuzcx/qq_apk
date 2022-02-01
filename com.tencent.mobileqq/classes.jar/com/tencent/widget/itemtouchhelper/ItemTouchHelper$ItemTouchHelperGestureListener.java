package com.tencent.widget.itemtouchhelper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class ItemTouchHelper$ItemTouchHelperGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  ItemTouchHelper$ItemTouchHelperGestureListener(ItemTouchHelper paramItemTouchHelper) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Object localObject = this.this$0.findChildView(paramMotionEvent);
    if (localObject != null)
    {
      localObject = this.this$0.mRecyclerView.getChildViewHolder((View)localObject);
      if (localObject != null)
      {
        if (!this.this$0.mCallback.hasDragFlag(this.this$0.mRecyclerView, (RecyclerView.ViewHolder)localObject)) {
          return;
        }
        if (paramMotionEvent.getPointerId(0) == this.this$0.mActivePointerId)
        {
          int i = paramMotionEvent.findPointerIndex(this.this$0.mActivePointerId);
          float f1 = paramMotionEvent.getX(i);
          float f2 = paramMotionEvent.getY(i);
          paramMotionEvent = this.this$0;
          paramMotionEvent.mInitialTouchX = f1;
          paramMotionEvent.mInitialTouchY = f2;
          paramMotionEvent.mDy = 0.0F;
          paramMotionEvent.mDx = 0.0F;
          if (paramMotionEvent.mCallback.isLongPressDragEnabled()) {
            this.this$0.select((RecyclerView.ViewHolder)localObject, 2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.ItemTouchHelperGestureListener
 * JD-Core Version:    0.7.0.1
 */