package com.tencent.mobileqq.mini.entry.desktop.widget;

import java.lang.ref.WeakReference;

public class DragRecyclerView$DragDeleteListenerWrapper
  implements DragRecyclerView.DragDeleteListener
{
  private WeakReference<DragRecyclerView.DragDeleteListener> mRealListener;
  
  public DragRecyclerView$DragDeleteListenerWrapper(DragRecyclerView paramDragRecyclerView, DragRecyclerView.DragDeleteListener paramDragDeleteListener)
  {
    this.mRealListener = new WeakReference(paramDragDeleteListener);
  }
  
  public void onDeleteDragComplete()
  {
    DragRecyclerView.DragDeleteListener localDragDeleteListener = (DragRecyclerView.DragDeleteListener)this.mRealListener.get();
    if (localDragDeleteListener != null) {
      localDragDeleteListener.onDeleteDragComplete();
    }
  }
  
  public void onDeleteDragFinish()
  {
    DragRecyclerView.DragDeleteListener localDragDeleteListener = (DragRecyclerView.DragDeleteListener)this.mRealListener.get();
    if (localDragDeleteListener != null) {
      localDragDeleteListener.onDeleteDragFinish();
    }
  }
  
  public void onDeleteDragStart()
  {
    DragRecyclerView.DragDeleteListener localDragDeleteListener = (DragRecyclerView.DragDeleteListener)this.mRealListener.get();
    if (localDragDeleteListener != null) {
      localDragDeleteListener.onDeleteDragStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.DragDeleteListenerWrapper
 * JD-Core Version:    0.7.0.1
 */