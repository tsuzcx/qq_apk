package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class OnRecyclerItemClickListener$ItemTouchHelperGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private OnRecyclerItemClickListener$ItemTouchHelperGestureListener(OnRecyclerItemClickListener paramOnRecyclerItemClickListener) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = OnRecyclerItemClickListener.access$100(this.this$0).findChildViewUnder(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      paramMotionEvent = OnRecyclerItemClickListener.access$100(this.this$0).getChildViewHolder(paramMotionEvent);
      this.this$0.onItemLongPress(paramMotionEvent);
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = OnRecyclerItemClickListener.access$100(this.this$0).findChildViewUnder(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      paramMotionEvent = OnRecyclerItemClickListener.access$100(this.this$0).getChildViewHolder(paramMotionEvent);
      this.this$0.onItemClick(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.OnRecyclerItemClickListener.ItemTouchHelperGestureListener
 * JD-Core Version:    0.7.0.1
 */