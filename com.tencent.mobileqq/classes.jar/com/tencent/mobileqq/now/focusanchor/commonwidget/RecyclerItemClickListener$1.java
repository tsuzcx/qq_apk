package com.tencent.mobileqq.now.focusanchor.commonwidget;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class RecyclerItemClickListener$1
  extends GestureDetector.SimpleOnGestureListener
{
  RecyclerItemClickListener$1(RecyclerItemClickListener paramRecyclerItemClickListener, RecyclerItemClickListener.OnItemClickListener paramOnItemClickListener) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (RecyclerItemClickListener.a(this.b) != null)
    {
      paramMotionEvent = this.a;
      if (paramMotionEvent != null) {
        paramMotionEvent.b(RecyclerItemClickListener.a(this.b), RecyclerItemClickListener.b(this.b).getChildPosition(RecyclerItemClickListener.a(this.b)));
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (RecyclerItemClickListener.a(this.b) != null)
    {
      paramMotionEvent = this.a;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(RecyclerItemClickListener.a(this.b), RecyclerItemClickListener.b(this.b).getChildPosition(RecyclerItemClickListener.a(this.b)));
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.commonwidget.RecyclerItemClickListener.1
 * JD-Core Version:    0.7.0.1
 */