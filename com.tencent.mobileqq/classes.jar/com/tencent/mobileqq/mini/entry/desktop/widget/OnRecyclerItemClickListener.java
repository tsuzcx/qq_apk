package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import com.tencent.widget.itemtouchhelper.GestureDetectorCompat;

public abstract class OnRecyclerItemClickListener
  implements RecyclerView.OnItemTouchListener
{
  private GestureDetectorCompat mGestureDetector;
  private DragRecyclerView recyclerView;
  
  public OnRecyclerItemClickListener(DragRecyclerView paramDragRecyclerView)
  {
    this.recyclerView = paramDragRecyclerView;
    this.mGestureDetector = new GestureDetectorCompat(paramDragRecyclerView.getContext(), new OnRecyclerItemClickListener.ItemTouchHelperGestureListener(this, null));
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    boolean bool = this.mGestureDetector.onTouchEvent(paramMotionEvent);
    if ((this.recyclerView.isDragging) && (paramMotionEvent.getAction() == 1)) {
      this.recyclerView.onTouchEvent(paramMotionEvent);
    }
    return bool;
  }
  
  public abstract void onItemClick(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void onItemLongPress(RecyclerView.ViewHolder paramViewHolder);
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.OnRecyclerItemClickListener
 * JD-Core Version:    0.7.0.1
 */